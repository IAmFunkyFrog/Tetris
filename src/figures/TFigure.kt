package figures

class TFigure: BaseFigure() {
    override val id: Int = 6
    init {
        points.addElement(Point(0, 1))
        points.addElement(Point(1, 1))
        points.addElement(Point(2, 1))
        points.addElement(Point(1, 0))
    }
}