/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cecf.exceptions;

/**
 *
 * @author yvan
 */
public class PasUneEquationDuPremierDegré extends Exception {

    public PasUneEquationDuPremierDegré() {
        super("Ce n'est pas une équation du premier degré");
    }
    
}
