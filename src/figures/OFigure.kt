package figures

class OFigure: BaseFigure() {
    override val id: Int = 4
    init {
        points.addElement(Point(0, 0))
        points.addElement(Point(1, 0))
        points.addElement(Point(0, 1))
        points.addElement(Point(1, 1))
    }
}