package figures

import java.util.ArrayList

open class BaseFigure(var id: Int = 0): Cloneable {
    var points: ArrayList<Point> = ArrayList()
        protected set

    private fun copyPointsArrayList(points: ArrayList<Point>): ArrayList<Point> {
        val copied: ArrayList<Point> = ArrayList()
        for(point in points) copied.add(Point(point.x, point.y))
        return copied
    }

    fun getRotateRight(): ArrayList<Point> {
        val newPoints: ArrayList<Point> = copyPointsArrayList(points)
        val basePoint: Point = points[0]
        for(i in newPoints.indices) {
            val beforeRotationPoint: Point = newPoints[i]
            newPoints[i].x = beforeRotationPoint.y - basePoint.y + basePoint.x
            newPoints[i].y = -beforeRotationPoint.x + basePoint.y + basePoint.x
        }
        return newPoints
    }

    fun getRotateLeft(): ArrayList<Point> {
        val newPoints: ArrayList<Point> = copyPointsArrayList(points)
        val basePoint: Point = points[0]
        for(i in newPoints.indices) {
            val beforeRotationPoint: Point = newPoints[i]
            newPoints[i].x = -beforeRotationPoint.y + basePoint.y + basePoint.x
            newPoints[i].y = beforeRotationPoint.x + basePoint.y - basePoint.x
        }
        return newPoints
    }

    fun getMoveRight(): ArrayList<Point> {
        val newPoints: ArrayList<Point> = copyPointsArrayList(points)
        for(i in newPoints.indices) newPoints[i].x += 1
        return newPoints
    }

    fun getMoveLeft(): ArrayList<Point> {
        val newPoints: ArrayList<Point> = copyPointsArrayList(points)
        for(i in newPoints.indices) newPoints[i].x -= 1
        return newPoints
    }

    fun getMoveDown(): ArrayList<Point> {
        val newPoints: ArrayList<Point> = copyPointsArrayList(points)
        for(i in newPoints.indices) newPoints[i].y -= 1
        return newPoints
    }

    fun setMove(points: ArrayList<Point>) {
        this.points = points
    }

    fun moveTo(point: Point) {
        for(i in points.indices) {
            points[i].x += point.x
            points[i].y += point.y
        }
    }

    public override fun clone(): Any {
        val copied: BaseFigure = BaseFigure(id)
        copied.setMove(copyPointsArrayList(points))
        return copied as Any
    }
}