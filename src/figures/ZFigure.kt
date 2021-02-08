package figures

class ZFigure: BaseFigure() {
    override val id: Int = 7
    init {
        points.addElement(Point(0, 1))
        points.addElement(Point(1, 1))
        points.addElement(Point(1, 0))
        points.addElement(Point(2, 0))
    }
}