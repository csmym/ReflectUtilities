/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package tests;

import static tags.CheckModifier.isFinal;
import static tags.CheckModifier.isPrivate;
import static tags.CheckModifier.isProtected;
import static tags.CheckModifier.isPublic;
import static tags.CheckModifier.isStatic;
import tags.GetterToCheck;
import tags.SetterToCheck;
import tags.ToCheck;

/**
 *
 * @author yvan
 */
public class A {
      
    @ToCheck(modifiers = {isFinal, isPrivate, isProtected, isPublic, isStatic},
            priority = 1)
    @SetterToCheck(value ="a",
            priority = 6)
    private int a;
    
    @ToCheck(modifiers = {isFinal, isPrivate, isProtected, isPublic, isStatic},
            priority = 2)
    @GetterToCheck(value = "B",
            priority = 7)
    protected final char B = 'B';
    
    @ToCheck(modifiers = {isFinal, isPrivate, isProtected, isPublic, isStatic},
            priority = 3)
    @GetterToCheck(value = "C",
            priority = 8)
    static final String C = "C";
    
    @ToCheck(modifiers = {isFinal, isPrivate, isProtected, isPublic, isStatic},
            priority = 4)
    @SetterToCheck(value = "D",
            priority = 9)
    private double d = 4.0;
    
    @ToCheck(modifiers = {isFinal, isPrivate, isProtected, isPublic, isStatic},
            priority = 5)
    public A() {
        this.a = 0;
    }
    
    public int getA() {
        return a;
    }
    
    public void setA(int a) {
        this.a = a;
    }

    public char getB() {
        return B;
    }

    public static String getC() {
        return C;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }
     
}
