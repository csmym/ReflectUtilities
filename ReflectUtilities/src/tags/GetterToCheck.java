/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package tags;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author yvan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GetterToCheck {
    String value() default "";
    int priority() default 0;
}
