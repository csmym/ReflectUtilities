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

import rf.geom.Segment;
import rf.geom.Point;
/**
 *
 * @author yvan
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SegmentTest {
   
@Test
public void p000020000_checkSegmentFieldP1() {
   System.out.println("Check attribut p1");
   try {
        Field x = Segment.class.getDeclaredField("p1");
        assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(2) == Modifier.isPrivate(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(2) == Modifier.isProtected(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(2) == Modifier.isPublic(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(2) == Modifier.isStatic(x.getModifiers()));
        assertTrue("", x.getType().equals(Point.class));
   } catch (NoSuchFieldException | SecurityException ex) {
        fail("");
   }
}

@Test
public void p000020000_checkSegmentFieldP2() {
   System.out.println("Check attribut p2");
   try {
        Field x = Segment.class.getDeclaredField("p2");
        assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(2) == Modifier.isPrivate(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(2) == Modifier.isProtected(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(2) == Modifier.isPublic(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(2) == Modifier.isStatic(x.getModifiers()));
        assertTrue("", x.getType().equals(Point.class));
   } catch (NoSuchFieldException | SecurityException ex) {
        fail("");
   }
}


@Test
public void p000021000_checkConstructorSegmentPointPoint() {
   System.out.println("Présence Constructeur de cf.geom.Segment");
   try {
        Constructor x = Segment.class.getDeclaredConstructor(
           Point.class,
           Point.class
        );
        assertTrue("Revoir  (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
        assertTrue("Revoir  (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
   } catch (NoSuchMethodException | SecurityException ex) {
        fail("Constructeur de cf.geom.Segment");
   }
}


@Test
public void p000022000_checkMethodSegmentgetP1() {
   System.out.println("getP1");
   try {
        Method x = Segment.class.getDeclaredMethod("getP1"
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
public void p000023000_checkMethodSegmentsetP1Point() {
   System.out.println("setP1");
   try {
        Method x = Segment.class.getDeclaredMethod("setP1"
          , Point.class        );
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
public void p000022000_checkMethodSegmentgetP2() {
   System.out.println("getP2");
   try {
        Method x = Segment.class.getDeclaredMethod("getP2"
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
public void p000023000_checkMethodSegmentsetP2Point() {
   System.out.println("setP2");
   try {
        Method x = Segment.class.getDeclaredMethod("setP2"
          , Point.class        );
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
public void p000024000_checkMethodSegmentgetLongueur() {
   System.out.println("getLongueur");
   try {
        Method x = Segment.class.getDeclaredMethod("getLongueur"
        );
        assertTrue("Revoir getLongueur (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
        assertTrue("Revoir getLongueur (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
        assertTrue("Revoir getLongueur (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
        assertTrue("Revoir getLongueur (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        assertTrue("Revoir getLongueur (Retour)", x.getReturnType().equals(double.class));
   } catch (NoSuchMethodException | SecurityException ex) {
        fail("Revoir getLongueur");
   }
}

@Test
public void p000025000_checkMethodSegmenttoString() {
   System.out.println("toString");
   try {
        Method x = Segment.class.getDeclaredMethod("toString"
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
public void p000027000_checkSetterSegmentp1() {
   System.out.println("Check setter p1");
   try {
        Method x = Segment.class.getDeclaredMethod("setP1", Point.class);
        assertTrue("Revoir setP1", x.getReturnType().equals(void.class));
        Object o = ReflectUtilities.randomValue(Segment.class);
        for(int i = 0; i < 100; ++i) {
            Point v = (Point) ReflectUtilities.randomValue(Point.class);
            ReflectUtilities.getFromMethodTA(
                 Segment.class,
                 o,
                 "setP1",
                 Point.class,
                 v
            );
            assertTrue("Revoir setP1",                                         ReflectUtilities.getAttribut(
                                           Segment.class, 
                                           o, 
                                           "p1"
                                        ).equals(v));
        }
   } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
        fail("Revoir setP1");
   } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        fail("setP1 incorrect");
   }
}

@Test
public void p000027000_checkSetterSegmentp2() {
   System.out.println("Check setter p2");
   try {
        Method x = Segment.class.getDeclaredMethod("setP2", Point.class);
        assertTrue("Revoir setP2", x.getReturnType().equals(void.class));
        Object o = ReflectUtilities.randomValue(Segment.class);
        for(int i = 0; i < 100; ++i) {
            Point v = (Point) ReflectUtilities.randomValue(Point.class);
            ReflectUtilities.getFromMethodTA(
                 Segment.class,
                 o,
                 "setP2",
                 Point.class,
                 v
            );
            assertTrue("Revoir setP2",                                         ReflectUtilities.getAttribut(
                                           Segment.class, 
                                           o, 
                                           "p2"
                                        ).equals(v));
        }
   } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
        fail("Revoir setP2");
   } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        fail("setP2 incorrect");
   }
}


@Test
public void p000026000_checkGetterSegmentP1() {
   System.out.println("Check getter p1");
   try {
     for(int i = 0; i < 100; ++i) {
         Object o = ReflectUtilities.randomValue(Segment.class); 
         Object attr = ReflectUtilities.getAttribut(Segment.class, o, "p1");
         Object getAttr = ReflectUtilities.getFromMethod(Segment.class, o, "getP1");
         assertTrue("Revoir getP1", ReflectUtilities.equals(attr, getAttr));
     }
   } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
        fail("Revoir getP1");
   } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        fail("getP1 incorrect");
   }
}

@Test
public void p000026000_checkGetterSegmentP2() {
   System.out.println("Check getter p2");
   try {
     for(int i = 0; i < 100; ++i) {
         Object o = ReflectUtilities.randomValue(Segment.class); 
         Object attr = ReflectUtilities.getAttribut(Segment.class, o, "p2");
         Object getAttr = ReflectUtilities.getFromMethod(Segment.class, o, "getP2");
         assertTrue("Revoir getP2", ReflectUtilities.equals(attr, getAttr));
     }
   } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
        fail("Revoir getP2");
   } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        fail("getP2 incorrect");
   }
}


@Test
public void p000028000_testMethodSegmentgetLongueur() {
   System.out.println("Test Method Segment.getLongueur");
   Class<?> classRef = cf.geom.Segment.class;
   Class<?> classToTest = Segment.class;
   for (int i = 0; i < 100; ++i) {
      try {
         StringBuilder msg = new StringBuilder("revoir Segment.getLongueur() --> ");
         boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "getLongueur");
         assertTrue(msg.toString(), result);
      } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
         fail("revoir Segment.getLongueur()");
      }
   }
}

@Test
public void p000028000_testMethodSegmenttoString() {
   System.out.println("Test Method Segment.toString");
   Class<?> classRef = cf.geom.Segment.class;
   Class<?> classToTest = Segment.class;
   for (int i = 0; i < 100; ++i) {
      try {
         StringBuilder msg = new StringBuilder("revoir Segment.toString() --> ");
         boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, "toString");
         assertTrue(msg.toString(), result);
      } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {
         fail("revoir Segment.toString()");
      }
   }
}
    
}
