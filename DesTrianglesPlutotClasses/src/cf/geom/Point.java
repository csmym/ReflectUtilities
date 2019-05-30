/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cf.geom;

/**
 *
 * @author yvan
 */

public class Point {

    @tags.ToCheck(priority = 1)
    @tags.GetterToCheck(priority = 6)
    @tags.SetterToCheck(priority = 7)
    
    private double x, y;

    @tags.ToCheck(priority = 2)
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @tags.ToCheck(priority = 3)
    public double getX() {
        return x;
    }

    @tags.ToCheck(priority = 4)
    public void setX(double x) {
        this.x = x;
    }

    @tags.ToCheck(priority = 3)
    public double getY() {
        return y;
    }

    @tags.ToCheck(priority = 4)
    public void setY(double y) {
        this.y = y;
    }

    @Override
    @tags.ToCheck(priority = 5)
    @tags.ToCompare(value = cf.geom.Point.class, priority = 10)
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
