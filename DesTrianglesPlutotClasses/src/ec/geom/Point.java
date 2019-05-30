/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package ec.geom;

/**
 *
 * @author yvan
 */
public class Point {

    // TODO déclarer x et y, les coordonnées cartésiennes de ce point
    private double x, y;

    // TODO constructeur aux coordonnées cartésiennes

    // TODO les getters pour les attributs

    // TODO les setters pour les attributs
    
    /* TODO public toString() qui retourne par exemple "(2.5, 3.2)" 
            si x = 2.5 et y = 3.2*/

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
