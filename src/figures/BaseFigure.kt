package figures

import java.util.Vector

open class BaseFigure: Cloneable {
    protected open val id: Int = 0
    protected var points: Vector<Point> = Vector()

    fun getRotateRight(): Vector<Point> {
        val newPoints: Vector<Point> = points
        val basePoint: Point = points[0]
        for(i in newPoints.indices) {
            val beforeRotationPoint: Point = newPoints[i]
            newPoints[i].x = beforeRotationPoint.y - basePoint.y + basePoint.x
            newPoints[i].y = -beforeRotationPoint.x + basePoint.y + basePoint.x
        }
        return newPoints
    }

    fun getRotateLeft(): Vector<Point> {
        val newPoints: Vector<Point> = points
        val basePoint: Point = points[0]
        for(i in newPoints.indices) {
            val beforeRotationPoint: Point = newPoints[i]
            newPoints[i].x = -beforeRotationPoint.y + basePoint.y + basePoint.x
            newPoints[i].y = beforeRotationPoint.x + basePoint.y - basePoint.x
        }
        return newPoints
    }

    fun getMoveRight(): Vector<Point> {
        val newPoints: Vector<Point> = Vector(points)
        for(i in newPoints.indices) newPoints[i].x += 1
        return newPoints
    }

    fun getMoveLeft(): Vector<Point> {
        val newPoints: Vector<Point> = Vector(points)
        for(i in newPoints.indices) newPoints[i].x -= 1
        return newPoints
    }

    fun getMoveDown(): Vector<Point> {
        val newPoints: Vector<Point> = Vector(points)
        for(i in newPoints.indices) newPoints[i].y -= 1
        return newPoints
    }

    fun setMove(points: Vector<Point>) {
        this.points = points
    }

    fun MoveTo(point: Point) {
        for(i in points.indices) {
            points[i].x += point.x
            points[i].y += point.y
        }
    }

    public override fun clone(): Any {
        return super.clone()
    }
}

