/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package solution.main;

import checker.Checker;
import solution.exceptions.DénominateurNul;
import solution.fractions.Fraction;

/**
 *
 * @author yvan
 */
public class Main {
    public static void main(String[] args) throws DénominateurNul {
        Fraction a = new Fraction(13,8);
        Fraction b = new Fraction(-7,12);
        a.plus(b).affiche();
        
        Checker chk = new Checker(Fraction.class);
        System.out.println(chk);
    }
}
