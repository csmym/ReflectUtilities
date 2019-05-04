/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package tags;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author yvan
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ToCheckModifiers {
    boolean checkIsABSTRACT() default true;
    boolean checkIsFINAL() default true;
    boolean checkIsNATIVE() default true;
    boolean checkIsPRIVATE() default true;
    boolean checkIsPROTECTED() default true;
    boolean checkIsPUBLIC() default true;
    boolean checkIsSTATIC() default true;
    boolean checkIsSTRICT() default true;
    boolean checkIsSYNCHRONIZED() default true;
    boolean checkIsTRANSIENT() default true;
    boolean checkIsVOLATILE() default true;
}
