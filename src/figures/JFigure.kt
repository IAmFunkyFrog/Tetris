package figures

class JFigure: BaseFigure() {
    override val id: Int = 2
    init {
        points.addElement(Point(0, 0))
        points.addElement(Point(1, 0))
        points.addElement(Point(1, 1))
        points.addElement(Point(1, 2))
    }
}