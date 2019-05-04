/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package tests;

import reflect.ReflectUtilities;
import java.lang.reflect.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author yvan
 */
public class ATest {

    @Test
    public void p0100_checkFielda() {
        System.out.println("Check attribut a");
        try {
            Field x = A.class.getDeclaredField("a");
            assertTrue("Revoir  (Modificateurs)", Modifier.isFinal(2) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(2) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(2) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(2) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(2) == Modifier.isStatic(x.getModifiers()));
            assertTrue("", x.getType().equals(int.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("");
        }
    }

    @Test
    public void p0200_checkFieldB() {
        System.out.println("Check attribut B");
        try {
            Field x = A.class.getDeclaredField("B");
            assertTrue("Revoir  (Modificateurs)", Modifier.isFinal(20) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(20) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(20) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(20) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(20) == Modifier.isStatic(x.getModifiers()));
            assertTrue("", x.getType().equals(char.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("");
        }
    }

    @Test
    public void p0300_checkFieldC() {
        System.out.println("Check attribut C");
        try {
            Field x = A.class.getDeclaredField("C");
            assertTrue("Revoir  (Modificateurs)", Modifier.isFinal(24) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(24) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(24) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(24) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(24) == Modifier.isStatic(x.getModifiers()));
            assertTrue("", x.getType().equals(String.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("");
        }
    }

    @Test
    public void p0400_checkFieldd() {
        System.out.println("Check attribut d");
        try {
            Field x = A.class.getDeclaredField("d");
            assertTrue("Revoir  (Modificateurs)", Modifier.isFinal(2) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(2) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(2) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(2) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(2) == Modifier.isStatic(x.getModifiers()));
            assertTrue("", x.getType().equals(double.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("");
        }
    }

    @Test
    public void checkConstructorA() {
        System.out.println("");
        try {
            Constructor x = A.class.getDeclaredConstructor();
            assertTrue("Revoir  (Modificateurs)", Modifier.isFinal(1) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("");
        }
    }

    @Test
    public void p00600_checkSettera() {
        System.out.println("Check setter a");
        System.out.println("Check setter a");
        try {
            Method x = A.class.getDeclaredMethod("setA", int.class);
            assertTrue("Revoir setA", x.getReturnType().equals(void.class));
            Object o = ReflectUtilities.randomValue(A.class);
            int v = (int) ReflectUtilities.randomValue(int.class);
            for (int i = 0; i < 100; ++i) {
                ReflectUtilities.getFromMethodTA(
                        A.class,
                        o,
                        "setA",
                        int.class,
                        v
                );
                assertTrue("Revoir setA", ReflectUtilities.getAttribut(
                        A.class,
                        o,
                        "a"
                ).equals(v));
            }
        } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
            fail("Revoir setA");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            fail("Il manque un constructeur pour tester setA");
        }
    }

    @Test
    public void p00900_checkSetterd() {
        System.out.println("Check setter d");
        System.out.println("Check setter d");
        try {
            Method x = A.class.getDeclaredMethod("setD", double.class);
            assertTrue("Revoir setD", x.getReturnType().equals(void.class));
            Object o = ReflectUtilities.randomValue(A.class);
            double v = (double) ReflectUtilities.randomValue(double.class);
            for (int i = 0; i < 100; ++i) {
                ReflectUtilities.getFromMethodTA(
                        A.class,
                        o,
                        "setD",
                        double.class,
                        v
                );
                assertTrue("Revoir setD", ReflectUtilities.getAttribut(
                        A.class,
                        o,
                        "d"
                ).equals(v));
            }
        } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
            fail("Revoir setD");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            fail("Il manque un constructeur pour tester setD");
        }
    }
}
