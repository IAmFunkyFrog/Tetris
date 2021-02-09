package figures

import java.util.Vector

class FigureFabric() {
    private val figures: Vector<BaseFigure> = Vector()
    private var figuresCount: Int = 1

    init {
        figures.addElement(IFigure())
        figures.addElement(JFigure())
        figures.addElement(LFigure())
        figures.addElement(OFigure())
        figures.addElement(SFigure())
        figures.addElement(TFigure())
        figures.addElement(ZFigure())
    }

    fun getRandomFigure(): BaseFigure {
        val newFigure = figures[(Math.random() * figures.size).toInt()].clone() as BaseFigure
        newFigure.id = figuresCount
        figuresCount++
        return newFigure
    }
}