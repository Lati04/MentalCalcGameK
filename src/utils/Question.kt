package utils

import kotlin.random.Random

// Classe de base représentant une question
open class Question(val level: Int) {
    // Méthode pour générer la question
    open fun generateQuestion(): String {
        return ""
    }

    // Méthode pour évaluer la réponse donnée par l'utilisateur
    open fun evaluate(response: Int): Boolean {
        return false
    }
}

// Sous-classe pour une question d'addition
class AdditionQuestion(level: Int) : Question(level) {
    private val number1 = Random.nextInt(1, 99)
    private val number2 = Random.nextInt(1, 99)

    override fun generateQuestion(): String {
        return "$number1 + $number2"
    }

    override fun evaluate(response: Int): Boolean {
        return response == number1 + number2
    }
}

// Sous-classe pour une question de soustraction et d'addition
class SubtractionAdditionQuestion(level: Int) : Question(level) {
    private val number1 = Random.nextInt(100, 999)
    private val number2 = Random.nextInt(1, 99)
    private val number3 = Random.nextInt(1, 99)

    override fun generateQuestion(): String {
        return "$number1 - $number2 + $number3"
    }

    override fun evaluate(response: Int): Boolean {
        return response == number1 - number2 + number3
    }
}

// Sous-classe pour une question de multiplication
class MultiplicationQuestion(level: Int) : Question(level) {
    private val number1 = Random.nextInt(1, 9)
    private val number2 = Random.nextInt(1, 99)

    override fun generateQuestion(): String {
        return "$number1 * $number2"
    }

    override fun evaluate(response: Int): Boolean {
        return response == number1 * number2
    }
}