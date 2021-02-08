import figures.*
import java.util.*

class Game(private val width: Int, private val height: Int) {
    private val figureFabric: FigureFabric = FigureFabric()
    private var currentFigure: BaseFigure? = null
    private val spawn: Point = Point(width / 2, height - 4)
    val table: Array<Array<Int>> = Array(height) { Array(width) { 0 } }
    var inProcess: Boolean = false
        private set

    private fun checkValidFigureCoords(figureCoords: Vector<Point>): Boolean {
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

    private fun setCurrentFigureOnTable() {
        if(currentFigure != null && checkValidFigureCoords(currentFigure!!.points)) {
            for(point in currentFigure!!.points) table[point.y][point.x] = currentFigure!!.id
        }
    }
    //Метод возвращает вектор с высотами линий, в которых сложился тетрис
    private fun checkTetris(): Vector<Int> {
        val lines: Vector<Int> = Vector()
        for(i in table.indices) {
            var flag: Boolean = true
            for(j in table[i].indices) {
                if(table[i][j] == 0) flag = false
            }
            if(flag) lines.addElement(i)
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

    fun restart() {
        for(i in table.indices) {
            for(j in table[i].indices) {
                table[i][j] = 0
            }
        }
        currentFigure = figureFabric.getRandomFigure()
        currentFigure!!.MoveTo(spawn)
        inProcess = true
    }

    fun tick() {
        if(!inProcess) return

        if(currentFigure == null) {
            currentFigure = figureFabric.getRandomFigure()
            currentFigure?.MoveTo(spawn)
            if(!checkValidFigureCoords(currentFigure!!.points)) {
                inProcess = false
            }
        }

        setCurrentFigureOnTable()

        val newFigureCoords: Vector<Point> = currentFigure!!.getMoveDown()
        if(checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        else currentFigure = null
    }

    fun figureRotateRight() {
        if(currentFigure != null) {
            val newFigureCoords: Vector<Point> = currentFigure!!.getRotateRight()
            if(checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        }
    }

    fun figureRotateLeft() {
        if(currentFigure != null) {
            val newFigureCoords: Vector<Point> = currentFigure!!.getRotateLeft()
            if (checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        }
    }

    fun figureMoveRight() {
        if(currentFigure != null) {
            val newFigureCoords: Vector<Point> = currentFigure!!.getMoveRight()
            if (checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        }

    }

    fun figureMoveLeft() {
        if(currentFigure != null) {
            val newFigureCoords: Vector<Point> = currentFigure!!.getMoveLeft()
            if (checkValidFigureCoords(newFigureCoords)) currentFigure!!.setMove(newFigureCoords)
        }
    }

}