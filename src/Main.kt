import utils.Game

fun main() {
    println("\u001B[35m ============================================================================================")
    println("|                         Bienvenue dans le Jeu de Calcul Mental!                            |")
    println("| Le but du jeu est de répondre correctement aux questions de calcul pour gagner des points. |")
    println("|       Vous avez 3 vies. Si vous répondez incorrectement 3 fois, le jeu se termine.         |")
    println("|            Chaque niveau présente des opérations de plus en plus difficiles.               |")
    println("|                                        Bon jeu!                                            |")
    println(" ============================================================================================ \u001B[0m")
    val game = Game()
    game.play()
}
