import figures.*
import java.util.*

class Game(private val width: Int, private val height: Int) {
    private val figureFabric: FigureFabric = FigureFabric()
    private var currentFigure: BaseFigure? = null
    val table: Array<Array<Int>> = Array(height) { Array(width) { 0 } }
    var inProcess: Boolean = false
        private set

    private fun checkValidFigureCoords(figureCoords: ArrayList<Point>): Boolean {
        var flag: Boolean = true
        for(point in figureCoords) {
            if(point.x < 0 || point.x >= width) {
                flag = false
                break
            }
            if(point.y < 0 || point.y >= height) {
                flag = false
                break
            }
            if(table[point.y][point.x] != 0) {
                flag = false
                break
            }
        }
        return flag
    }

    private fun setFigureOnTable(figure: BaseFigure) {
        if(checkValidFigureCoords(figure.points)) {
            for(point in figure.points) table[point.y][point.x] = figure.id
        }
    }

    private fun deleteFigureFromTable(figure: BaseFigure) {
        for (i in table.indices) {
            for (j in table[i].indices) {
                if (table[i][j] == figure.id) table[i][j] = 0
            }
        }
    }
    //Метод возвращает вектор с высотами линий, в которых сложился тетрис
    private fun checkTetris(): ArrayList<Int> {
        val lines: ArrayList<Int> = ArrayList()
        for(i in table.indices) {
            var flag: Boolean = true
            for(j in table[i].indices) {
                if(table[i][j] == 0) flag = false
            }
            if(flag) lines.add(i)
        }
        return lines
    }

    private fun deleteRow(rowHeight: Int) {
        if(rowHeight < 0 || rowHeight >= height) return

        for(i in rowHeight until height - 1) {
            for(j in table[i].indices) {
                table[i][j] = table[i + 1][j]
            }
        }
        for(j in table[height - 1].indices) {
            table[height - 1][j] = 0
        }
    }

    private fun spawnFigure(): BaseFigure {
        val figure = figureFabric.getRandomFigure()
        figure.moveTo(Point(width / 2 - 2, height - 5))
        return figure
    }

    fun restart() {
        for(i in table.indices) {
            for(j in table[i].indices) {
                table[i][j] = 0
            }
        }
        currentFigure = spawnFigure()
        inProcess = true
    }

    fun tick() {
        if(!inProcess) return

        if(currentFigure == null) {
            currentFigure = spawnFigure()
            if(!checkValidFigureCoords(currentFigure!!.points)) {
                inProcess = false
                return
            }
        }
        else {
            deleteFigureFromTable(currentFigure!!)

            val newFigureCoords: ArrayList<Point> = currentFigure!!.getMoveDown()
            if(checkValidFigureCoords(newFigureCoords)) {
                currentFigure!!.setMove(newFigureCoords)
                setFigureOnTable(currentFigure!!)
            }
            else {
                setFigureOnTable(currentFigure!!)
                currentFigure = null
            }
        }
    }

    fun figureRotateRight() {
        if(currentFigure != null) {
            val newFigureCoords: ArrayList<Point> = currentFigure!!.getRotateRight()
            if(checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        }
    }

    fun figureRotateLeft() {
        if(currentFigure != null) {
            val newFigureCoords: ArrayList<Point> = currentFigure!!.getRotateLeft()
            if (checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        }
    }

    fun figureMoveRight() {
        if(currentFigure != null) {
            val newFigureCoords: ArrayList<Point> = currentFigure!!.getMoveRight()
            if (checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        }

    }

    fun figureMoveLeft() {
        if(currentFigure != null) {
            val newFigureCoords: ArrayList<Point> = currentFigure!!.getMoveLeft()
            if (checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        }
    }

}