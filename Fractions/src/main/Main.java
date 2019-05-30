/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package main;

import caseinedev.IntrospectionUtilities;
import checker.Checker;
import exceptions.DénominateurNul;
import fractions.Fraction;
import java.util.Arrays;

/**
 *
 * @author yvan
 */
public class Main {
    public static void main(String[] args) throws DénominateurNul, NoSuchMethodException {
        Fraction a = new Fraction(13,8);
        Fraction b = new Fraction(-7,12);
        //a.plus(b).affiche();
        
        Checker chk = new Checker(Fraction.class);
        System.out.println(chk);
        System.out.println(Arrays.stream(Fraction.class.getDeclaredMethod("plus", Fraction.class).getExceptionTypes())
                .filter(p -> IntrospectionUtilities.isCheckedException(p)).count());
        try {
            a.plus(b);
        } catch(ArithmeticException e) {
            
        }
    }
}
