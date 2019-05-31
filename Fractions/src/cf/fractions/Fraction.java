/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cf.fractions;

import cf.exceptions.InversionFractionNulle;
import cf.exceptions.DénominateurNul;
import cf.exceptions.DivisionParUneFractionNulle;
import cf.exceptions.SituationImpossible;

/**
 *
 * @author yvan
 */
@tags.ToCheck(priority = 1, value = "Modificateurs de Fraction. Bien relire l'énoncé")
public final class Fraction {

    @tags.ToCheck(
            priority = 2,
            value = "Les attributs. Bien relire l'énoncé")
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

    @tags.ToCheck(priority = 3, value = "Le constructeur à deux paramètres. Bien relire l'énoncé")
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

    @tags.ToCheck(priority = 4, value = "Le constructeur à un paramètre. Bien relire l'énoncé")
    public Fraction(int numérateur) {
        this.numérateur = numérateur;
        this.dénominateur = 1;
    }

    @tags.ToCheck(priority = 5, value = "Le constructeur par défaut. Bien relire l'énoncé")
    public Fraction() {
        this(0);
    }

    @tags.ToCheck(priority = 6, value = "signature affiche()")    
    public void affiche() {
        if (dénominateur == 1 || numérateur == 0) {
            System.out.println(numérateur);
        } else {
            System.out.println(numérateur + "/" + dénominateur);
        }
    }   
    
    public String toString() {
        if (dénominateur == 1 || numérateur == 0) {
            return numérateur+"";
        } else {
            return numérateur + "/" + dénominateur;
        }
    }

    @tags.ToCheck(priority = 7, value = "signature opposé()")
    public Fraction opposé() {
        try {
            return new Fraction(-numérateur, dénominateur);
        } catch (DénominateurNul ex) {
            throw new SituationImpossible();// IllegalStateException
        }
    }

    @tags.ToCheck(priority = 8, value = "signature inverse()")
    public Fraction inverse() throws InversionFractionNulle {
        try {
            return new Fraction(dénominateur, numérateur);
        } catch (DénominateurNul ex) {
            throw new InversionFractionNulle();
        }
    }

    @tags.ToCheck(priority = 9, value = "signature plus(Fraction f)")
    public Fraction plus(Fraction f) {
        int ppcm = ppcm(dénominateur, f.dénominateur);
        try {
            return new Fraction(numérateur * ppcm / dénominateur + f.numérateur * ppcm / f.dénominateur, ppcm);
        } catch (DénominateurNul ex) {
            throw new SituationImpossible();
        }
    }

    @tags.ToCheck(priority = 10, value = "signature fois(Fraction f)")
    public Fraction fois(Fraction f) {
        try {
            return new Fraction(numérateur * f.numérateur, dénominateur * f.dénominateur);
        } catch (DénominateurNul ex) {
            throw new SituationImpossible();
        }
    }

    @tags.ToCheck(priority = 11, value = "signature moins(Fraction f)")
    public Fraction moins(Fraction f) {
        return plus(f.opposé());
    }

    @tags.ToCheck(priority = 12, value = "signature diviséPar(Fraction f)")
    public Fraction diviséPar(Fraction f) throws DivisionParUneFractionNulle {
        try {
            return fois(f.inverse());
        } catch (InversionFractionNulle ex) {
            throw new DivisionParUneFractionNulle();
        }
    }

}
