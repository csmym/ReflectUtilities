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
public @interface MinInt {
    int value() default Integer.MIN_VALUE;
}
