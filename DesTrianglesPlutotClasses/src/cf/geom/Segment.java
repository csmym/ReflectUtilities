/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cf.geom;

/**
 *
 * @author yvan
 */
public class Segment {
    @tags.ToCheck(priority = 20)
    @tags.GetterToCheck(priority = 26)
    @tags.SetterToCheck(priority = 27)
    private Point p1, p2;

    @tags.ToCheck(priority = 21)
    public Segment(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @tags.ToCheck(priority = 22)
    public Point getP1() {
        return p1;
    }

    @tags.ToCheck(priority = 23)
    public void setP1(Point p1) {
        this.p1 = p1;
    }

    @tags.ToCheck(priority = 22)
    public Point getP2() {
        return p2;
    }

    @tags.ToCheck(priority = 23)
    public void setP2(Point p2) {
        this.p2 = p2;
    }
    
    @tags.ToCheck(priority = 24)
    @tags.ToCompare(value = cf.geom.Segment.class, priority = 28)
    public double getLongueur() {
        return Math.sqrt((p2.getX()-p1.getX())*(p2.getX()-p1.getX())+(p2.getY()-p1.getY())*(p2.getY()-p1.getY()));
    }
    
    @tags.ToCheck(priority = 25)
    @tags.ToCompare(value = cf.geom.Segment.class, priority = 28)
    @Override
    public String toString() {
        return "["+p1+" ; "+p2+"]";
    }
}
