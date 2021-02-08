package figures

class LFigure: BaseFigure() {
    override val id: Int = 3
    init {
        points.addElement(Point(0, 0))
        points.addElement(Point(0, 1))
        points.addElement(Point(0, 2))
        points.addElement(Point(1, 0))
    }
}