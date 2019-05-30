/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cf.geom;

import java.lang.reflect.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import reflect.ReflectUtilities;

import ec.geom.Segment;
import ec.geom.Point;
import ec.geom.Triangle;

/**
 *
 * @author yvan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TriangleTest {

    @Test
    public void p000030000_checkTriangleFieldC1() {
        System.out.println("Check attribut c1");
        try {
            Field x = Triangle.class.getDeclaredField("c1");
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(2) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(2) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(2) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(2) == Modifier.isStatic(x.getModifiers()));
            assertTrue("", x.getType().equals(Segment.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("");
        }
    }

    @Test
    public void p000030000_checkTriangleFieldC2() {
        System.out.println("Check attribut c2");
        try {
            Field x = Triangle.class.getDeclaredField("c2");
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(2) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(2) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(2) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(2) == Modifier.isStatic(x.getModifiers()));
            assertTrue("", x.getType().equals(Segment.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("");
        }
    }

    @Test
    public void p000030000_checkTriangleFieldC3() {
        System.out.println("Check attribut c3");
        try {
            Field x = Triangle.class.getDeclaredField("c3");
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(2) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(2) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(2) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(2) == Modifier.isStatic(x.getModifiers()));
            assertTrue("", x.getType().equals(Segment.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("");
        }
    }

    @Test
    public void p000031000_checkConstructorTrianglePointPointPoint() {
        System.out.println("Présence Constructeur de cf.geom.Triangle");
        try {
            Constructor x = Triangle.class.getDeclaredConstructor(
                    Point.class,
                    Point.class,
                    Point.class
            );
            assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Constructeur de cf.geom.Triangle");
        }
    }

    @Test
    public void p000032000_checkMethodTrianglegetP1() {
        System.out.println("getP1");
        try {
            Method x = Triangle.class.getDeclaredMethod("getP1"
            );
            assertTrue("Revoir getP1 (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getP1 (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getP1 (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getP1 (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getP1 (Retour)", x.getReturnType().equals(Point.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getP1");
        }
    }

    @Test
    public void p000033000_checkMethodTrianglesetP1Point() {
        System.out.println("setP1");
        try {
            Method x = Triangle.class.getDeclaredMethod("setP1",
                    Point.class);
            assertTrue("Revoir setP1 (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir setP1 (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir setP1 (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir setP1 (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir setP1 (Retour)", x.getReturnType().equals(void.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir setP1");
        }
    }

    @Test
    public void p000032000_checkMethodTrianglegetP2() {
        System.out.println("getP2");
        try {
            Method x = Triangle.class.getDeclaredMethod("getP2"
            );
            assertTrue("Revoir getP2 (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getP2 (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getP2 (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getP2 (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getP2 (Retour)", x.getReturnType().equals(Point.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getP2");
        }
    }

    @Test
    public void p000033000_checkMethodTrianglesetP2Point() {
        System.out.println("setP2");
        try {
            Method x = Triangle.class.getDeclaredMethod("setP2",
                    Point.class);
            assertTrue("Revoir setP2 (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir setP2 (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir setP2 (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir setP2 (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir setP2 (Retour)", x.getReturnType().equals(void.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir setP2");
        }
    }

    @Test
    public void p000032000_checkMethodTrianglegetP3() {
        System.out.println("getP3");
        try {
            Method x = Triangle.class.getDeclaredMethod("getP3"
            );
            assertTrue("Revoir getP3 (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getP3 (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getP3 (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getP3 (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getP3 (Retour)", x.getReturnType().equals(Point.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getP3");
        }
    }

    @Test
    public void p000033000_checkMethodTrianglesetP3Point() {
        System.out.println("setP3");
        try {
            Method x = Triangle.class.getDeclaredMethod("setP3",
                    Point.class);
            assertTrue("Revoir setP3 (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir setP3 (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir setP3 (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir setP3 (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir setP3 (Retour)", x.getReturnType().equals(void.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir setP3");
        }
    }

    @Test
    public void p000034000_checkMethodTrianglegetPerimetre() {
        System.out.println("getPerimetre");
        try {
            Method x = Triangle.class.getDeclaredMethod("getPerimetre"
            );
            assertTrue("Revoir getPerimetre (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getPerimetre (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getPerimetre (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getPerimetre (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getPerimetre (Retour)", x.getReturnType().equals(double.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getPerimetre");
        }
    }

    @Test
    public void p000034000_checkMethodTrianglegetBaryCentre() {
        System.out.println("getBaryCentre");
        try {
            Method x = Triangle.class.getDeclaredMethod("getBaryCentre"
            );
            assertTrue("Revoir getBaryCentre (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getBaryCentre (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getBaryCentre (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getBaryCentre (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getBaryCentre (Retour)", x.getReturnType().equals(Point.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getBaryCentre");
        }
    }

    @Test
    public void p000034000_checkMethodTrianglegetSurface() {
        System.out.println("getSurface");
        try {
            Method x = Triangle.class.getDeclaredMethod("getSurface"
            );
            assertTrue("Revoir getSurface (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir getSurface (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir getSurface (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir getSurface (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir getSurface (Retour)", x.getReturnType().equals(double.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir getSurface");
        }
    }

    @Test
    public void p000034000_checkMethodTriangletoString() {
        System.out.println("toString");
        try {
            Method x = Triangle.class.getDeclaredMethod("toString"
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
    public void p000037000_testMethodTrianglegetPerimetre() {
        System.out.println("Test Method Triangle.getPerimetre");
        Class<?> classRef = cf.geom.Triangle.class;
        Class<?> classToTest = Triangle.class;
        for (int i = 0; i < 100; ++i) {
            try {
                StringBuilder msg = new StringBuilder("revoir Triangle.getPerimetre() --> ");
                boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "getPerimetre");
                assertTrue(msg.toString(), result);
            } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
                fail("revoir Triangle.getPerimetre()");
            }
        }
    }

    @Test
    public void p000037000_testMethodTrianglegetBaryCentre() {
        System.out.println("Test Method Triangle.getBaryCentre");
        Class<?> classRef = cf.geom.Triangle.class;
        Class<?> classToTest = Triangle.class;
        for (int i = 0; i < 100; ++i) {
            try {
                StringBuilder msg = new StringBuilder("revoir Triangle.getBaryCentre() --> ");
                boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "getBaryCentre");
                assertTrue(msg.toString(), result);
            } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
                fail("revoir Triangle.getBaryCentre()");
            }
        }
    }

    @Test
    public void p000037000_testMethodTrianglegetSurface() {
        System.out.println("Test Method Triangle.getSurface");
        Class<?> classRef = cf.geom.Triangle.class;
        Class<?> classToTest = Triangle.class;
        for (int i = 0; i < 100; ++i) {
            try {
                StringBuilder msg = new StringBuilder("revoir Triangle.getSurface() --> ");
                boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "getSurface");
                assertTrue(msg.toString(), result);
            } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
                fail("revoir Triangle.getSurface()");
            }
        }
    }

    @Test
    public void p000038000_testMethodTriangletoString() {
        System.out.println("Test Method Triangle.toString");
        Class<?> classRef = cf.geom.Triangle.class;
        Class<?> classToTest = Triangle.class;
        for (int i = 0; i < 100; ++i) {
            try {
                StringBuilder msg = new StringBuilder("revoir Triangle.toString() --> ");
                boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "toString");
                assertTrue(msg.toString(), result);
            } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
                fail("revoir Triangle.toString()");
            }
        }
    }

}
