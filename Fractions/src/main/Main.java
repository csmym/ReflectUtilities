/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package main;

import cf.equations.Equation;
import checker.Checker;
import cf.exceptions.DénominateurNul;
import cf.fractions.Fraction;

/**
 *
 * @author yvan
 */
public class Main {
    public static void main(String[] args) throws DénominateurNul, NoSuchMethodException {
        //Fraction a = new Fraction(13,8);
        //Fraction b = new Fraction(-7,12);
        //a.plus(b).affiche();
        
        Checker chk = new Checker(Fraction.class);
        System.out.println(chk);
        System.out.println("// -------- Equation ---------");
        Checker chkequation = new Checker(Equation.class);
        System.out.println(chkequation);
        /*System.out.println(Arrays.stream(Fraction.class.getDeclaredMethod("plus", Fraction.class).getExceptionTypes())
                .filter(p -> isCheckedException(p)).count());
        try {
            a.plus(b);
        } catch(ArithmeticException e) {
            
        }*/
    }
}
