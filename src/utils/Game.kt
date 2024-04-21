package utils

class Game {
    private var level = 1
    private var score = 0
    private var lives = 3

    fun play() {
        println("\u001B[35m =========================")
        println("|   Are you ready to game |")
        println(" =========================\u001B[0m")
        var correctAnswersCount = 0 // Nombre total de bonnes réponses
        while (lives > 0) {
            println("Niveau actuel : $level")
            val question = when (level) {
                1 -> AdditionQuestion(1)
                2 -> SubtractionAdditionQuestion(2)
                3 -> MultiplicationQuestion(3)
                else -> Question(0)
            }

            var equation: String
            var response: Int?
            do {
                equation = question.generateQuestion()
                println("\u001B[34mRésolvez l'opération : $equation\u001B[0m")
                response = readlnOrNull()?.toIntOrNull()
                if (response == null) {
                    println("Veuillez entrer un nombre entier valide.")
                } else if (!question.evaluate(response)) {
                    lives-- // Décrémenter le nombre de vies
                    if (lives > 0) {
                        println("\u001B[31mMauvaise réponse. Il vous reste $lives vie(s). Réessayez.\u001B[0m")
                        println("\u001B[31m====================================================\u001B[0m")
                    } else {
                        println("\u001B[35mGame Over. Votre score final est de $score.\u001B[0m")
                        println("\u001B[35m=======================================\u001B[0m")
                        return
                    }
                }
            } while (response == null || !question.evaluate(response))

            // Logique pour traiter une réponse correcte
            correctAnswersCount++
            score += when (level) {
                1 -> 1
                2 -> 2
                3 -> 3
                else -> 0
            }
            println("\u001B[34mBonne réponse ! Votre score est de $score\u001B[0m")
            println("\u001B[34m====================================\u001B[0m")

            // Logique pour passer au niveau suivant si nécessaire
            if ((level == 1 && correctAnswersCount == 2) || (level == 2 && correctAnswersCount == 4)) {
                level++
                correctAnswersCount = 0 // Réinitialiser le compteur pour le nouveau niveau
            }

            println("\u001B[35m====================================\u001B[0m")
        }

    }
}

