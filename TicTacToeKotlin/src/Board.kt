class Board(private val n: Int) {

    //empty space
    private val empty = "___"
    //number of moves starting at 0
    private var moveCount = 0
    //Boolean saying that the game is not over
    var isGameOver = false
    //An array to keep the board values for the rows and columns
    private var board = Array(n) { Array(n) { empty } }

    //function resets board
    private fun resetBoard() {
        board = Array(n) { Array(n) { empty } }
    }

    //function prints board
    //checks to see if there is an element in the row
    fun printBoard() {
        board.forEach { row ->
            row.forEach { element ->
                if (element == empty) {
                    print("|$element|")
                } else {
                    println("| $element |")
                }
            }
            println()
        }
    }

    //function that places players move
    fun placePiece(x: Int, y: Int, move: String) {
        //checks if the game is not over AND the position is valid AND the coordinates are empty
        if (!isGameOver
            && isPositionValid(x, y)
            && board[x][y] == empty
        ) {
            //increments the move number by 1
            moveCount++
            board[x][y] = move
            printBoard()
            //the game is over if the winning move is played or if it is a draw
            isGameOver = isWinningMove(x, y, move) || isDraw()
            if (isGameOver && !isDraw()){
                println("You Win!!!!!")
            } else if(isDraw()){
                println("Draw")
            }
        }
    }

    //function returns true or false depending if the position is valid
    private fun isPositionValid(x: Int, y: Int): Boolean {
        return ((x in 0 until n) && (y in 0 until n))
    }

    //function returns true if the move causes a win or false if the move doesn't
    private fun isWinningMove(x: Int, y: Int, move: String): Boolean {
        //check the row
        for (i in 0 until n) {
            if (board[x][i] != move) {
                break
            }
            if (i == n - 1){
                return true
            }
        }
        //check the column
        for (i in 0 until n) {
            if (board[i][y] != move) {
                break
            }
            if (i == n - 1) {
                return true
            }
        }
        //what if it is diagonal?
        return false
    }

    //function resets game
    fun resetGame() {
        resetBoard()
        isGameOver = false
        moveCount = 0
    }
}