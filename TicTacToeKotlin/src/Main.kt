import java.util.*

private var board = Board(0)
private val player1 = "X"
private val player2 = "O"
private var currentPlayer = ""
private var answer = ""


fun main(){
    //asks player for size of the board (doesn't have to be 3X3
    println("Please enter size of your board:")
    val scanner = Scanner(System.`in`)
    val size = Integer.parseInt(scanner.nextLine())

    board = Board(size)
    board.printBoard()

    //while loop prompts players for their move coordinates
    while(!board.isGameOver){
        takeTurns()
        println("$currentPlayer's turn")
        println("Enter row number: ")
        var row = Integer.parseInt(scanner.nextLine())
        println("Enter column number: ")
        var col = Integer.parseInt(scanner.nextLine())
        board.placePiece(row - 1, col - 1, currentPlayer)
        if (board.isGameOver){
            println("Do you want to play again? Type y or yes")
            var answer = scanner.nextLine()
            if(isPlayingAgain(answer)){
                board.resetGame()
            }
        }
    }
}

//function alternates turns
fun takeTurns(){
    currentPlayer = if (player1 == currentPlayer) {
        player2
    }else{
        player1
    }
}

//function returns true if the player says yes to playing again
fun isPlayingAgain(answer: String): Boolean{
    return(answer.equals("y", ignoreCase = true)
            || answer.equals("yes", ignoreCase = true))
}