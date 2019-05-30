/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package solution.fractions;

import solution.exceptions.*;
import static tags.CheckModifier.*;
import tags.ToCheck;

/**
 *
 * @author yvan
 */
@ToCheck(priority = 1, value = "Modificateurs de Fraction", modifiers = {isAbstract, isFinal, isPublic})
public final class Fraction {

    @ToCheck(
            priority = 2,
            value = "Les attributs",
            modifiers = {
                isFinal,
                isPublic,
                isProtected,
                isPrivate})
    public final int numérateur, dénominateur;

    private static int pgcd(int a, int b) {
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    private static int ppcm(int a, int b) {
        return (a * b) / pgcd(a, b);
    }

    @ToCheck(priority = 3, value = "Le constructeur à deux paramètres")
    public Fraction(int numérateur, int dénominateur) throws DénominateurNul {
        if (dénominateur == 0) {
            throw new DénominateurNul();
        }
        int pgcd = pgcd(Math.abs(numérateur), Math.abs(dénominateur));
        if (dénominateur < 0) {
            this.numérateur = -numérateur / pgcd;
            this.dénominateur = -dénominateur / pgcd;
        } else {
            this.numérateur = numérateur / pgcd;
            this.dénominateur = dénominateur / pgcd;
        }
    }

    @ToCheck(priority = 4, value = "Le constructeur à un paramètre")
    public Fraction(int numérateur) {
        this.numérateur = numérateur;
        this.dénominateur = 1;
    }

    @ToCheck(priority = 5, value = "Le constructeur par défaut")
    public Fraction() {
        this(0);
    }

    @ToCheck(priority = 6, value = "affiche()")
    public void affiche() {
        if (dénominateur == 1 || numérateur == 0) {
            System.out.println(numérateur);
        } else {
            System.out.println(numérateur + "/" + dénominateur);
        }
    }

    @ToCheck(priority = 7, value = "opposé()")
    public Fraction opposé() {
        try {
            return new Fraction(-numérateur, dénominateur);
        } catch (DénominateurNul ex) {
            throw new SituationImpossible();// IllegalStateException
        }
    }

    @ToCheck(priority = 8, value = "inverse()")
    public Fraction inverse() throws InversionFractionNulle {
        try {
            return new Fraction(dénominateur, numérateur);
        } catch (DénominateurNul ex) {
            throw new InversionFractionNulle();
        }
    }

    @ToCheck(priority = 9, value = "plus(Fraction f)")
    public Fraction plus(Fraction f) {
        int ppcm = ppcm(dénominateur, f.dénominateur);
        try {
            return new Fraction(numérateur * ppcm / dénominateur + f.numérateur * ppcm / f.dénominateur, ppcm);
        } catch (DénominateurNul ex) {
            throw new SituationImpossible();
        }
    }

    @ToCheck(priority = 10, value = "fois(Fraction f)")
    public Fraction fois(Fraction f) {
        try {
            return new Fraction(numérateur * f.numérateur, dénominateur * f.dénominateur);
        } catch (DénominateurNul ex) {
            throw new SituationImpossible();
        }
    }

    @ToCheck(priority = 11, value = "moins(Fraction f)")
    public Fraction moins(Fraction f) {
        return plus(f.opposé());
    }

    @ToCheck(priority = 12, value = "diviséPar(Fraction f)")
    public Fraction diviséPar(Fraction f) throws DivisionParUneFractionNulle {
        try {
            return fois(f.inverse());
        } catch (InversionFractionNulle ex) {
            throw new DivisionParUneFractionNulle();
        }
    }

}
