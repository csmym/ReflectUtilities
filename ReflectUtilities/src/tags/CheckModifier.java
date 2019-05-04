/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package tags;

/**
 *
 * @author yvan
 */
public enum CheckModifier {
    isAbstract, 
    isFinal,
    isInterface,
    isNative,
    isPrivate,
    isProtected,
    isPublic,
    isStatic,
    isStrict,
    isSynchronized,
    isTransient,
    isVolatile;
    
    @Override
    public String toString() {
        
        return "assertTrue(\"Revoir %s (Modificateurs)\", Modifier."+name()+"(%d) == Modifier."+name()+"(x.getModifiers()));\n";
    }
    
}
