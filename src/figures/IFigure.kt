package figures

class IFigure: BaseFigure() {
    override val id: Int = 1
    init {
        points.addElement(Point(0, 0))
        points.addElement(Point(1, 0))
        points.addElement(Point(2, 0))
        points.addElement(Point(3, 0))
    }
}