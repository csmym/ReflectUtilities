/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package solution.exceptions;

/**
 *
 * @author yvan
 */
public class InversionFractionNulle extends Exception {

    public InversionFractionNulle() {
        super("Impossible d'inverser une fraction nulle");
    }   
}
