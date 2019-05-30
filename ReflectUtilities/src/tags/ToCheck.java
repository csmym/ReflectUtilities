
package tags;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation à placer devant
 *    - une classe
 *    - un attribut
 *    - une méthode
 * Pour vérifier dans tous les cas
 *    - leur nom
 *    - les modificateurs décrits dans le contenu de modifiers()
 * Pour vérifier (en plus) dans le cas d'une classe
 *    - sa super classe
 * 
 * La propriété value() est le message affiché par le test unitaire en cas 
 * d'incohérence.
 * 
 * La propriété modifiers() définit les modificateurs à tester.
 * 
 * La propriété priority() définit un ordre de priorité dans l'exécution des 
 * tests unitaires.
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
