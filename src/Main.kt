import kotlinx.coroutines.*
import java.util.*
import java.util.concurrent.TimeUnit

fun moveFigure(move: Char, game: Game) {
    when(move) {
        'a' -> game.figureMoveLeft()
        'd' -> game.figureMoveRight()
        'w' -> game.figureRotateLeft()
        's' -> game.figureRotateRight()
        'e' -> game.tick()
    }
}

fun main(args: Array<String>) {
    val game = Game(8, 14)
    game.restart()
    while(game.inProcess) {
        val move: String? = readLine()
        if(move != null) moveFigure(move[0], game)
        for(i in game.table.size - 1 downTo 0) {
            for(j in game.table[i].indices) print(game.table[i][j])
            println()
        }
        println()
    }
}