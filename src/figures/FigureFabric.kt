package figures

import java.util.Vector

class FigureFabric(private var figures: Vector<BaseFigure> = Vector()) {
    init {
        if(figures.isEmpty()) {
            figures.addElement(IFigure())
            figures.addElement(JFigure())
            figures.addElement(LFigure())
            figures.addElement(OFigure())
            figures.addElement(SFigure())
            figures.addElement(TFigure())
            figures.addElement(ZFigure())
        }
    }

    fun getRandomFigure(): BaseFigure {
        return figures[(Math.random() * figures.size).toInt()].clone() as BaseFigure
    }
}