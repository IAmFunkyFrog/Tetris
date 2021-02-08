fun main() {
    val game = Game(5, 10)

    for(row in game.table) {
        for(cell in row) print(cell)
        println()
    }
}