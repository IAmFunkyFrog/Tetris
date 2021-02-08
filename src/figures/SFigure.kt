package figures

class SFigure: BaseFigure() {
    override val id: Int = 5
    init {
        points.addElement(Point(0, 0))
        points.addElement(Point(1, 0))
        points.addElement(Point(1, 1))
        points.addElement(Point(2, 1))
    }
}