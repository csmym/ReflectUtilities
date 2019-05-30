/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cf.geom;

/**
 *
 * @author yvan
 */
public class Triangle {

    @tags.ToCheck(priority = 30)
    private Segment c1, c2, c3;

    @tags.ToCheck(priority = 31)
    public Triangle(Point p1, Point p2, Point p3) {
        this.c1 = new Segment(p1, p2);
        this.c2 = new Segment(p2, p3);
        this.c3 = new Segment(p3, p1);
    }

    @tags.ToCheck(priority = 32)
    public Point getP1() {
        return c1.getP1();
    }

    @tags.ToCheck(priority = 33)
    public void setP1(Point p1) {
        this.c1 = new Segment(p1, c2.getP1());
        this.c3 = new Segment(c3.getP1(), p1);
    }

    @tags.ToCheck(priority = 32)
    public Point getP2() {
        return c2.getP1();
    }

    @tags.ToCheck(priority = 33)
    public void setP2(Point p2) {
        this.c1 = new Segment(c1.getP1(), p2);
        this.c2 = new Segment(p2, c3.getP1());    
    }

    @tags.ToCheck(priority = 32)
    public Point getP3() {
        return c3.getP1();
    }

    @tags.ToCheck(priority = 33)
    public void setP3(Point p3) {
        this.c2 = new Segment(c2.getP1(), p3);
        this.c3 = new Segment(p3, c1.getP1());
    }

    @tags.ToCheck(priority = 34)
    @tags.ToCompare(value = cf.geom.Triangle.class, priority = 37)
    public double getPerimetre() {
        return c1.getLongueur() + c2.getLongueur() + c3.getLongueur();
    }

    @tags.ToCheck(priority = 34)
    @tags.ToCompare(value = cf.geom.Triangle.class, priority = 37)
    public Point getBaryCentre() {
        Point a = c1.getP1();
        Point b = c2.getP1();
        Point c = c3.getP1();

        return new Point((a.getX() + b.getX() + c.getX()) / 3, (a.getY() + b.getY() + c.getY()) / 3);
    }

    @tags.ToCheck(priority = 34)
    @tags.ToCompare(value = cf.geom.Triangle.class, priority = 37)
    public double getSurface() {
        double a = c1.getLongueur();
        double b = c2.getLongueur();
        double c = c3.getLongueur();
        double p = (a + b + c)/2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
