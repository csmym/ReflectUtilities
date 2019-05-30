/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cf.geom;

import java.lang.reflect.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import reflect.ReflectUtilities;

import rf.geom.Point;
/**
 *
 * @author yvan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointTest {

    @Test
    public void p000001000_checkPointFieldX() {
        System.out.println("Check attribut x");
        try {
            Field x = Point.class.getDeclaredField("x");
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
    public void p000001000_checkPointFieldY() {
        System.out.println("Check attribut y");
        try {
            Field x = Point.class.getDeclaredField("y");
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
    public void p000002000_checkConstructorPointdoubledouble() {
        System.out.println("Présence Constructeur de cf.geom.Point");
        try {
            Constructor x = Point.class.getDeclaredConstructor(
                    double.class,
                    double.class
            );
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Constructeur de cf.geom.Point");
        }
    }

    @Test
    public void p000003000_checkMethodPointgetY() {
        System.out.println("getY");
        try {
            Method x = Point.class.getDeclaredMethod("getY"
            );
            assertTrue("Revoir getY (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getY (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getY (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getY (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getY (Retour)", x.getReturnType().equals(double.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getY");
        }
    }

    @Test
    public void p000004000_checkMethodPointsetYdouble() {
        System.out.println("setY");
        try {
            Method x = Point.class.getDeclaredMethod("setY",
                     double.class);
            assertTrue("Revoir setY (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir setY (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir setY (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir setY (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir setY (Retour)", x.getReturnType().equals(void.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir setY");
        }
    }

    @Test
    public void p000004000_checkMethodPointsetXdouble() {
        System.out.println("setX");
        try {
            Method x = Point.class.getDeclaredMethod("setX",
                     double.class);
            assertTrue("Revoir setX (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir setX (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir setX (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir setX (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir setX (Retour)", x.getReturnType().equals(void.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir setX");
        }
    }

    @Test
    public void p000003000_checkMethodPointgetX() {
        System.out.println("getX");
        try {
            Method x = Point.class.getDeclaredMethod("getX"
            );
            assertTrue("Revoir getX (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getX (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getX (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getX (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getX (Retour)", x.getReturnType().equals(double.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getX");
        }
    }

    @Test
    public void p000005000_checkMethodPointtoString() {
        System.out.println("toString");
        try {
            Method x = Point.class.getDeclaredMethod("toString"
            );
            assertTrue("Revoir toString (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir toString (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir toString (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir toString (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir toString (Retour)", x.getReturnType().equals(String.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir toString");
        }
    }

    @Test
    public void p000007000_checkSetterPointx() {
        System.out.println("Check setter x");
        try {
            Method x = Point.class.getDeclaredMethod("setX", double.class);
            assertTrue("Revoir setX", x.getReturnType().equals(void.class));
            Object o = ReflectUtilities.randomValue(Point.class);
            for (int i = 0; i < 100; ++i) {
                double v = (double) ReflectUtilities.randomValue(double.class);
                ReflectUtilities.getFromMethodTA(
                        Point.class,
                        o,
                        "setX",
                        double.class,
                        v
                );
                assertTrue("Revoir setX", ReflectUtilities.getAttribut(
                        Point.class,
                        o,
                        "x"
                ).equals(v));
            }
        } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
            fail("Revoir setX");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            fail("setX incorrect");
        }
    }

    @Test
    public void p000007000_checkSetterPointy() {
        System.out.println("Check setter y");
        try {
            Method x = Point.class.getDeclaredMethod("setY", double.class);
            assertTrue("Revoir setY", x.getReturnType().equals(void.class));
            Object o = ReflectUtilities.randomValue(Point.class);
            for (int i = 0; i < 100; ++i) {
                double v = (double) ReflectUtilities.randomValue(double.class);
                ReflectUtilities.getFromMethodTA(
                        Point.class,
                        o,
                        "setY",
                        double.class,
                        v
                );
                assertTrue("Revoir setY", ReflectUtilities.getAttribut(
                        Point.class,
                        o,
                        "y"
                ).equals(v));
            }
        } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
            fail("Revoir setY");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            fail("setY incorrect");
        }
    }

    @Test
    public void p000006000_checkGetterPointX() {
        System.out.println("Check getter x");
        try {
            for (int i = 0; i < 100; ++i) {
                Object o = ReflectUtilities.randomValue(Point.class);
                Object attr = ReflectUtilities.getAttribut(Point.class, o, "x");
                Object getAttr = ReflectUtilities.getFromMethod(Point.class, o, "getX");
                assertTrue("Revoir getX", ReflectUtilities.equals(attr, getAttr));
            }
        } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
            fail("Revoir getX");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            fail("getX incorrect");
        }
    }

    @Test
    public void p000006000_checkGetterPointY() {
        System.out.println("Check getter y");
        try {
            for (int i = 0; i < 100; ++i) {
                Object o = ReflectUtilities.randomValue(Point.class);
                Object attr = ReflectUtilities.getAttribut(Point.class, o, "y");
                Object getAttr = ReflectUtilities.getFromMethod(Point.class, o, "getY");
                assertTrue("Revoir getY", ReflectUtilities.equals(attr, getAttr));
            }
        } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
            fail("Revoir getY");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            fail("getY incorrect");
        }
    }

    @Test
    public void p000010000_testMethodPointtoString() {
        System.out.println("Test Method Point.toString");
        Class<?> classRef = cf.geom.Point.class;
        Class<?> classToTest = Point.class;
        for (int i = 0; i < 100; ++i) {
            try {
                StringBuilder msg = new StringBuilder("revoir Point.toString() --> ");
                boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "toString");
                assertTrue(msg.toString(), result);
            } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
                fail("revoir Point.toString()");
            }
        }
    }

}
