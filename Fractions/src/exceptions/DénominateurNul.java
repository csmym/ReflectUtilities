/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package exceptions;

/**
 *
 * @author yvan
 */
public class DénominateurNul extends Exception {

    public DénominateurNul() {
        super("Le dénominateur ne peut pas être nul");
    }
    
}
