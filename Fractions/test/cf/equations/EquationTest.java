/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cf.equations;

import java.lang.reflect.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import reflect.ReflectUtilities;

import rf.fractions.Fraction;
import rf.equations.Equation;


/**
 *
 * @author yvan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EquationTest {

    @Test
    public void p000000000_checkMethodEquationgetX() {
        System.out.println("getX");
        try {
            Method x = Equation.class.getDeclaredMethod("getX"
            );
            assertTrue("Revoir getX (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getX (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getX (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getX (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getX (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getX");
        }
    }

    @Test
    public void p000000000_checkMethodEquationgetNbSolutions() {
        System.out.println("getNbSolutions");
        try {
            Method x = Equation.class.getDeclaredMethod("getNbSolutions"
            );
            assertTrue("Revoir getNbSolutions (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getNbSolutions (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getNbSolutions (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getNbSolutions (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getNbSolutions (Retour)", x.getReturnType().equals(int.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getNbSolutions");
        }
    }

    @Test
    public void p000000000_testMethodEquationgetX() {
        System.out.println("Test Method Equation.getX");
        Class<?> classRef = cf.equations.Equation.class;
        Class<?> classToTest = Equation.class;
        for (int i = 0; i < 100; ++i) {
            try {
                StringBuilder msg = new StringBuilder("revoir Equation.getX() --> ");
                boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "getX");
                assertTrue(msg.toString(), result);
            } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
                fail("revoir Equation.getX()");
            }
        }
    }

    @Test
    public void p000000000_testMethodEquationgetNbSolutions() {
        System.out.println("Test Method Equation.getNbSolutions");
        Class<?> classRef = cf.equations.Equation.class;
        Class<?> classToTest = Equation.class;
        for (int i = 0; i < 100; ++i) {
            try {
                StringBuilder msg = new StringBuilder("revoir Equation.getNbSolutions() --> ");
                boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "getNbSolutions");
                assertTrue(msg.toString(), result);
            } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
                fail("revoir Equation.getNbSolutions()");
            }
        }
    }

}
