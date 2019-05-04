
package tags;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author yvan
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ToCheck {
    String value() default "";
    //ToCheckModifiers modifiers() default @ToCheckModifiers;
    CheckModifier[] modifiers() default {
        /*CheckModifier.isAbstract,
        CheckModifier.isFinal,
        CheckModifier.isInterface,
        CheckModifier.isNative,*/
        CheckModifier.isPrivate,
        CheckModifier.isProtected,
        CheckModifier.isPublic,
        CheckModifier.isStatic/*,
        CheckModifier.isStrict,
        CheckModifier.isSynchronized,
        CheckModifier.isTransient,
        CheckModifier.isVolatile*/
    };   
    int priority() default 0;
}
