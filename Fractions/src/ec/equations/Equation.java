/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package ec.equations;

import ec.exceptions.DivisionParUneFractionNulle;
import ec.fractions.Fraction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Permet de résoudre l'équation ax+b=c, où a, b, c et x sont des fractions.
 *
 * En cas de solution unique, elle est accessible par la méthode getX() et
 * getNbSolutions() rend 1 Si, getX() vaut null, deux cas se présentent 1.
 * l'ensemble des solutions est vide => getNbSolutions() rend 0 2. l'ensemble
 * des solutions est Q => getNbSolutions() rend -1 (par convention)
 *
 * @author yvan
 */
public final class Equation {

    // TODO Résoudre l'équation ax + b = c où a, b, c et x sont des fractions.
    private final int nbSolutions;
    private final Fraction x;

    public Equation(Fraction a, Fraction b, Fraction c) {
        Fraction x = null;
        int nbSolutions = 0;
        try {
            x = c.moins(b).diviséPar(b);
            nbSolutions = 1;
        } catch (DivisionParUneFractionNulle ex) {
            /*if (b.numérateur == c.numérateur && b.dénominateur == c.dénominateur) {
                x = null;
                nbSolutions = -1;
            } else {
                x = null;
                nbSolutions = 0;
            }*/
        }
        this.x = x;
        this.nbSolutions = nbSolutions;
    }

    public Fraction getX() {
        return x;
    }

    public int getNbSolutions() {
        return nbSolutions;
    }
}
