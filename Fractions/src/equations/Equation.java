/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package equations;

import exceptions.PasUneEquationDuPremierDegré;
import exceptions.DivisionParUneFractionNulle;
import fractions.Fraction;

/**
 * Permet de résoudre l'équation ax+b=c, où a, b, c et x sont des fractions.
 * 
 * En cas de solution unique, elle est accessible par la méthode getX()
 * et getNbSolutions() rend 1
 * Si, getX() vaut null, deux cas se présentent
 *    1. l'ensemble des solutions est vide => getNbSolutions() rend 0
 *    2. l'ensemble des solutions est Q    => getNbSolutions() rend -1 (par convention)
 * @author yvan
 */
public final class Equation {

    private Fraction x = null;
    private int nbSolutions;
    /**
     * Pour résoudre ax + b = c;
     *
     * @param a une fraction de type Fraction
     * @param b une fraction de type Fraction
     * @param c une fraction de type Fraction
     */
    public Equation(Fraction a, Fraction b, Fraction c) throws DivisionParUneFractionNulle /* throws PasUneEquationDuPremierDegré */ {
        try {
            x = c.moins(b).diviséPar(a);
            nbSolutions = 1;
        } catch (DivisionParUneFractionNulle ex) {
            if (b.numérateur == c.numérateur && b.dénominateur == c.dénominateur) {
                nbSolutions = -1;
            } else {
                nbSolutions = 0;
            }
            //throw new PasUneEquationDuPremierDegré();
        }
    }

    public Fraction getX() {
        return x;
    }

    public int getNbSolutions() {
        return nbSolutions;
    }
    
}
