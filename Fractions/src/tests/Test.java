/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import cf.exceptions.InversionFractionNulle;
import cf.exceptions.DénominateurNul;
import cf.exceptions.DivisionParUneFractionNulle;
import cf.exceptions.SituationImpossible;
import cf.equations.Equation;
import cf.fractions.Fraction;
import java.util.Random;

/**
 *
 * @author yvan
 */
public class Test {

    private static final Random random = new Random();

    public static Fraction randomFraction() {
        try {
            int den;
            do {
                den = 10 - random.nextInt(21);
            } while (den == 0);
            return new Fraction(10 - random.nextInt(21), den);
        } catch (DénominateurNul ex) {
            throw new SituationImpossible();
        }
    }

    public static void inegaliteAttendue(String msg, int a, int b) {
        if (a == b) {
            throw new VerificationException(msg + " valeur attendu " + a + " mais reçu " + b);
        }
    }

    public static void inegaliteAttendue(int a, int b) {
        inegaliteAttendue("", a, b);
    }

    public static void egaliteAttendue(String msg, Fraction a, Fraction b) {
        if (a.numérateur != b.numérateur || a.dénominateur != b.dénominateur) {
            throw new VerificationException(msg + " valeur attendu " + (a.numérateur+"/"+a.dénominateur) + " mais reçu " + (b.numérateur+"/"+b.dénominateur));
        }
    }

    public static void egaliteAttendue(Fraction a, Fraction b) {
        egaliteAttendue("", a, b);
    }

    public static void egaliteAttendue(String msg, int a, int b) {
        if (a != b) {
            throw new VerificationException(msg + " valeur attendu " + a + " mais reçu " + b);
        }
    }

    public static void egaliteAttendue(int a, int b) {
        egaliteAttendue("", a, b);
    }

    public static void véritéAttendue(String msg, boolean v) {
        if (!v) {
            throw new VerificationException(msg);
        }
    }

    public static void plantageProvoqué(String msg) {
        throw new VerificationException(msg);
    }

    public static void testConstruction() {
        System.out.println("Test construction");
        try {
            Fraction ar;
            ar = new Fraction(4, 2);
            egaliteAttendue(new Fraction(2, 1), ar);

            ar = new Fraction(5, 0);
            plantageProvoqué("Ne devrait pas passer par là");
        } catch (DénominateurNul ex) {
        }
    }

    public static void testPlus() {
        System.out.println("Test plus");
        try {
            Fraction a = new Fraction(1, 2);
            Fraction b = new Fraction(2, 3);
            Fraction c = new Fraction(7, 6);

            egaliteAttendue(c, a.plus(b));

            egaliteAttendue(new Fraction(23, 4), new Fraction(25, 5).plus(new Fraction(3, 4)));
            egaliteAttendue(new Fraction(17, 4), new Fraction(25, 5).plus(new Fraction(-3, 4)));
            egaliteAttendue(new Fraction(17, 4), new Fraction(25, 5).plus(new Fraction(-3, 4)));
            egaliteAttendue(new Fraction(-17, 4), new Fraction(-25, 5).plus(new Fraction(3, 4)));
            egaliteAttendue(new Fraction(-23, 4), new Fraction(-25, 5).plus(new Fraction(-3, 4)));
            egaliteAttendue(new Fraction(-23, 4), new Fraction(25, -5).plus(new Fraction(3, -4)));
            egaliteAttendue(new Fraction(23, -4), new Fraction(25, -5).plus(new Fraction(3, -4)));
        } catch (DénominateurNul ex) {
        }
    }

    public static void testMoins() {
        System.out.println("Test différence");
        try {
            Fraction a = new Fraction(1, 2);
            Fraction b = new Fraction(2, 3);
            Fraction c = new Fraction(-1, 6);
            egaliteAttendue(c, a.moins(b));

            egaliteAttendue(new Fraction(17, 4), new Fraction(25, 5).moins(new Fraction(3, 4)));
            egaliteAttendue(new Fraction(23, 4), new Fraction(25, 5).moins(new Fraction(-3, 4)));
            egaliteAttendue(new Fraction(23, 4), new Fraction(25, 5).moins(new Fraction(-3, 4)));
            egaliteAttendue(new Fraction(23, -4), new Fraction(-25, 5).moins(new Fraction(3, 4)));
            egaliteAttendue(new Fraction(-17, 4), new Fraction(-25, 5).moins(new Fraction(-3, 4)));
            egaliteAttendue(new Fraction(-17, 4), new Fraction(25, -5).moins(new Fraction(3, -4)));
            egaliteAttendue(new Fraction(17, -4), new Fraction(25, -5).moins(new Fraction(3, -4)));
        } catch (DénominateurNul ex) {
        }
    }

    public static void testMultiplication() {
        System.out.println("Test multiplication");
        try {
            Fraction a = new Fraction(1, 2);
            Fraction b = new Fraction(2, 3);
            Fraction c = new Fraction(1, 3);
            egaliteAttendue(c, a.fois(b));
            egaliteAttendue(new Fraction(24, 120), new Fraction(1, 2).fois(new Fraction(2, 3)).fois(new Fraction(3, 4)).fois(new Fraction(4, 5)));
            egaliteAttendue(new Fraction(24, 120), new Fraction(-1, 2).fois(new Fraction(-2, 3)).fois(new Fraction(-3, 4)).fois(new Fraction(-4, 5)));
            egaliteAttendue(new Fraction(24, -120), new Fraction(-1, 2).fois(new Fraction(2, -3)).fois(new Fraction(-3, 4)).fois(new Fraction(-4, -5)));
            egaliteAttendue(new Fraction(24, 120), new Fraction(1, -2).fois(new Fraction(-2, 3)).fois(new Fraction(3, -4)).fois(new Fraction(-4, 5)));
        } catch (DénominateurNul ex) {
        }
    }

    public static void testDivision() {
        System.out.println("Test division");
        boolean plantage = false;
        try {
            Fraction a = new Fraction(1, 2);
            Fraction b = new Fraction(2, 3);
            Fraction c = new Fraction(3, 4);
            egaliteAttendue(c, a.diviséPar(b));

            egaliteAttendue(new Fraction(5, 4), new Fraction(1, 2).diviséPar(new Fraction(2, 3)).diviséPar(new Fraction(3, 4)).diviséPar(new Fraction(4, 5)));
            egaliteAttendue(new Fraction(5, 4), new Fraction(-1, 2).diviséPar(new Fraction(-2, 3)).diviséPar(new Fraction(-3, 4)).diviséPar(new Fraction(-4, 5)));
            egaliteAttendue(new Fraction(5, -4), new Fraction(-1, 2).diviséPar(new Fraction(2, -3)).diviséPar(new Fraction(-3, 4)).diviséPar(new Fraction(-4, -5)));
            egaliteAttendue(new Fraction(5, 4), new Fraction(1, -2).diviséPar(new Fraction(-2, 3)).diviséPar(new Fraction(3, -4)).diviséPar(new Fraction(-4, 5)));
            a.diviséPar(new Fraction(0));
            plantageProvoqué("Ne devrait pas passer par là");
        } catch (DivisionParUneFractionNulle ex) {
            plantage = true;
        } catch (DénominateurNul ex) {
        }
        véritéAttendue("Il devrait y avoir une division par zéro", plantage);
    }

    public static void testOppose() {
        System.out.println("Test oppose");
        try {
            Fraction a = new Fraction(1, 2);
            Fraction b = new Fraction(-2, 4);
            egaliteAttendue(b, a.opposé());

            egaliteAttendue(new Fraction(20, 4), new Fraction(5, -1).opposé());
            egaliteAttendue(new Fraction(-20, 4), new Fraction(5, 1).opposé());
            egaliteAttendue(new Fraction(-20, -4), new Fraction(-5, 1).opposé());
            egaliteAttendue(new Fraction(20, -4), new Fraction(-5, -1).opposé());

        } catch (DénominateurNul ex) {
        }
    }

    public static void testInverse() {
        System.out.println("Test inverse");
        boolean plantage = false;
        try {
            Fraction a = new Fraction(1, 2);
            Fraction b = new Fraction(2, 1);
            egaliteAttendue(b, a.inverse());
            b = new Fraction(0, 1);
            b.inverse();
            plantageProvoqué("Ne devrait pas passer par là");
        } catch (DénominateurNul dn) {
        } catch (InversionFractionNulle ex) {
            plantage = true;
        }
        véritéAttendue("Il devrait y avoir une inversion de fraction null", plantage);
    }

    public static void testFractions() {
        testConstruction();
        testPlus();
        testMoins();
        testInverse();
        testOppose();
        testDivision();
        testMultiplication();
    }

    public static void testEquations() throws DivisionParUneFractionNulle {
        System.out.println("Test equations");
        Fraction a, b, c;
        Fraction axplusb;
        Equation e;

        for (int i = 0; i < 1000; i++) {
            a = randomFraction();
            b = randomFraction();
            c = randomFraction();

            e = new Equation(a, b, c);
            if (a.numérateur == 0) {
                inegaliteAttendue(1, e.getNbSolutions());
            } else {
                egaliteAttendue(c, a.fois(e.getX()).plus(b));
            }
        }
    }

    public static void main(String[] args) throws DivisionParUneFractionNulle {

            testFractions();
            testEquations();
    }
}
