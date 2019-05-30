/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package fractions;

import caseinedev.IntrospectionUtilities;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import solution.exceptions.DivisionParUneFractionNulle;
import solution.exceptions.DénominateurNul;
import solution.exceptions.InversionFractionNulle;

/**
 *
 * @author yvan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FractionTest {

    @Test
    public void p0100_checkClassFraction() {
        System.out.println("check class Fraction");
        assertTrue("Modificateurs de Fraction (Héritage)", Fraction.class.getSuperclass().equals(Object.class));
        Class<?> x = Fraction.class;
        assertTrue("Revoir Modificateurs de Fraction (Modificateurs)", Modifier.isAbstract(17) == Modifier.isAbstract(x.getModifiers()));
        assertTrue("Revoir Modificateurs de Fraction (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
        assertTrue("Revoir Modificateurs de Fraction (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
    }

    @Test
    public void p0200_checkFieldnumérateur() {
        System.out.println("Check attribut numérateur");
        try {
            Field x = Fraction.class.getDeclaredField("numérateur");
            assertTrue("Revoir Les attributs (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir Les attributs (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Les attributs (Modificateurs)", Modifier.isProtected(17) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Les attributs (Modificateurs)", Modifier.isPrivate(17) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Les attributs", x.getType().equals(int.class));
        } catch (Exception ex) {
            fail("Les attributs");
        }
    }

    @Test
    public void p0200_checkFielddénominateur() {
        System.out.println("Check attribut dénominateur");
        try {
            Field x = Fraction.class.getDeclaredField("dénominateur");
            assertTrue("Revoir Les attributs (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir Les attributs (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Les attributs (Modificateurs)", Modifier.isProtected(17) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Les attributs (Modificateurs)", Modifier.isPrivate(17) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Les attributs", x.getType().equals(int.class));
        } catch (Exception ex) {
            fail("Les attributs");
        }
    }

    @Test
    public void p0500_checkConstructorFraction() {
        System.out.println("Le constructeur par défaut");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor();
            assertTrue("Revoir Le constructeur par défaut (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            
            assertTrue("Êtes-vous sûr que le constructeur par défaut doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredConstructor().getExceptionTypes())
                            .filter(p -> IntrospectionUtilities.isCheckedException(p)).count() == 0);
        } catch (Exception ex) {
            fail("Le constructeur par défaut");
        }
    }

    @Test
    public void p0300_checkConstructorFractionintint() {
        System.out.println("Le constructeur à deux paramètres");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor(
                    int.class,
                    int.class
            );
            assertTrue("Revoir Le constructeur à deux paramètres (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (Exception ex) {
            fail("Le constructeur à deux paramètres");
        }
    }

    @Test
    public void p0400_checkConstructorFractionint() {
        System.out.println("Le constructeur à un paramètre");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor(
                    int.class
            );
            assertTrue("Revoir Le constructeur à un paramètre (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));

            assertTrue("Êtes-vous sûr que le constructeur à un paramètre doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredConstructor(int.class).getExceptionTypes())
                            .filter(p -> IntrospectionUtilities.isCheckedException(p)).count() == 0);
        } catch (Exception ex) {
            fail("Le constructeur à un paramètre");
        }
    }

    @Test
    public void p0900_checkMethodplusFraction() {
        System.out.println("plus(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("plus",
                    Fraction.class);
            assertTrue("Revoir plus(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir plus(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir plus(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir plus(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir plus(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (Exception ex) {
            fail("Revoir plus(Fraction f)");
        }
    }

    @Test
    public void p0600_checkMethodaffiche() {
        System.out.println("affiche()");
        try {
            Method x = Fraction.class.getDeclaredMethod("affiche"
            );
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir affiche() (Retour)", x.getReturnType().equals(void.class));
        } catch (Exception ex) {
            fail("Revoir affiche()");
        }
    }

    @Test
    public void p0700_checkMethodopposé() {
        System.out.println("opposé()");
        try {
            Method x = Fraction.class.getDeclaredMethod("opposé"
            );
            assertTrue("Revoir opposé() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir opposé() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir opposé() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir opposé() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir opposé() (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (Exception ex) {
            fail("Revoir opposé()");
        }
    }

    @Test
    public void p0800_checkMethodinverse() {
        System.out.println("inverse()");
        try {
            Method x = Fraction.class.getDeclaredMethod("inverse"
            );
            assertTrue("Revoir inverse() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir inverse() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir inverse() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir inverse() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir inverse() (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (Exception ex) {
            fail("Revoir inverse()");
        }
    }

    @Test
    public void p1000_checkMethodfoisFraction() {
        System.out.println("fois(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("fois",
                    Fraction.class);
            assertTrue("Revoir fois(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir fois(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir fois(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir fois(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir fois(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (Exception ex) {
            fail("Revoir fois(Fraction f)");
        }
    }

    @Test
    public void p1100_checkMethodmoinsFraction() {
        System.out.println("moins(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("moins",
                    Fraction.class);
            assertTrue("Revoir moins(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir moins(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir moins(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir moins(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir moins(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (Exception ex) {
            fail("Revoir moins(Fraction f)");
        }
    }

    @Test
    public void p1200_checkMethoddiviséParFraction() {
        System.out.println("diviséPar(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("diviséPar",
                    Fraction.class);
            assertTrue("Revoir diviséPar(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir diviséPar(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir diviséPar(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir diviséPar(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir diviséPar(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (Exception ex) {
            fail("Revoir diviséPar(Fraction f)");
        }
    }

    @Test
    public void p1300_testConstructeurIntInt() {
        System.out.println("Test constructeur à deux paramètres");
        try {
            Constructor c = Fraction.class.getConstructor(int.class, int.class);
            int n, d;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-50, 50);
                d = IntrospectionUtilities.randomInt(-50, 50);
                //System.out.println(n + "/" + d);
                try {
                    solution.fractions.Fraction fok = new solution.fractions.Fraction(n, d);
                    Fraction ftotest = (Fraction) c.newInstance(n, d);
                    assertTrue("Revoir constructeurIntInt", IntrospectionUtilities.equals(fok, ftotest));
                } catch (DénominateurNul ex) {
                    try {
                        c.newInstance(n, d);
                        fail("Devrait lancer une exception");
                    } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException | InvocationTargetException ex2) {
                        assertTrue("Une exception devrait être lancée", d == 0);
                    }
                }
            }
            try {
                c.newInstance(1, 0);
                fail("Devrait lancer une exception contrôlée");
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException ex2) {
                assertTrue("Devrait lancer une exception contrôlée", IntrospectionUtilities.isCheckedException(ex2.getCause()));
            }
        } catch (Exception ex) {
            fail("Revoir constructeurIntInt");
        }
    }

    @Test
    public void p1310_testConstructeurInt() {
        System.out.println("Test constructeur à un paramètre");
        try {
            Constructor c = Fraction.class.getConstructor(int.class);
            int n;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-50, 50);
                solution.fractions.Fraction fok = new solution.fractions.Fraction(n);
                Fraction ftotest = (Fraction) c.newInstance(n);
                assertTrue("Revoir constructeurInt", IntrospectionUtilities.equals(fok, ftotest));
            }
        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }

    @Test
    public void p1320_testConstructeur() {
        System.out.println("Test constructeur par défaut");
        try {
            Constructor c = Fraction.class.getConstructor();

            solution.fractions.Fraction fok = new solution.fractions.Fraction();
            Fraction ftotest = (Fraction) c.newInstance();
            //assertTrue("Revoir constructeur", IntrospectionUtilities.equals(fok, ftotest));
            assertTrue("Revoir constructeur", IntrospectionUtilities.getAttribut(ftotest.getClass(), ftotest, "numérateur").equals(0));
            System.out.println("---->" + IntrospectionUtilities.getAttribut(ftotest.getClass(), ftotest, "numérateur"));
            assertTrue("Revoir constructeur", IntrospectionUtilities.getAttribut(ftotest.getClass(), ftotest, "dénominateur").equals(1));
            System.out.println("---->" + IntrospectionUtilities.getAttribut(ftotest.getClass(), ftotest, "dénominateur"));

        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }

    @Test
    public void p1330_testConstructeur() {
        System.out.println("Test constructeur par défaut");
        try {
            Constructor c = Fraction.class.getConstructor();

            solution.fractions.Fraction fok = new solution.fractions.Fraction();
            Fraction ftotest = (Fraction) c.newInstance();
            assertTrue("Revoir constructeur", IntrospectionUtilities.equals(fok, ftotest));

        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }

    @Test
    public void p1400_testImmuable() {
        System.out.println("Test d'immuabilité");
        assertFalse("Fraction devrait être immuable", IntrospectionUtilities.isMutable(Fraction.class));
    }

    @Test
    public void p1500_testAffiche() {
        System.out.println("Test affiche()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok = new solution.fractions.Fraction(n, d);
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                String s1 = IntrospectionUtilities.getFromMethodTASystemOut(solution.fractions.Fraction.class, fok, "affiche");
                String s2 = IntrospectionUtilities.getFromMethodTASystemOut(Fraction.class, ftotest, "affiche");
                assertEquals(s1, s2);
            }
        } catch (Exception ex) {
            fail("affiche()");
        }
    }

    @Test
    public void p1510_testOpposé() {
        System.out.println("Test opposé()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok = new solution.fractions.Fraction(n, d).opposé();
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                ftotest = (Fraction) IntrospectionUtilities.getFromMethod(Fraction.class, ftotest, "opposé");
                assertTrue("opposé()", IntrospectionUtilities.equals(fok, ftotest));
            }
                assertTrue("Êtes-vous sûr que la méthode opposé() doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredMethod("opposé").getExceptionTypes())
                            .filter(p -> IntrospectionUtilities.isCheckedException(p)).count() == 0);
        } catch (Exception ex) {
            fail("affiche()");
        }
    }

    @Test
    public void p1520_testInverse() {
        System.out.println("Test inverse()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok = new solution.fractions.Fraction(n, d).inverse();
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                ftotest = (Fraction) IntrospectionUtilities.getFromMethod(Fraction.class, ftotest, "inverse");
                assertTrue("inverse()", IntrospectionUtilities.equals(fok, ftotest));
            }
        } catch (InversionFractionNulle ex) {
            Throwable ex3;
            Throwable ex4;
            try {
                Fraction.class.getConstructor(int.class, int.class).newInstance(1, 0);
            } catch (InvocationTargetException ex2) {
                ex3 = ex2.getCause();
                try {
                    Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(0, 1);
                    ftotest = (Fraction) IntrospectionUtilities.getFromMethod(Fraction.class, ftotest, "inverse");
                } catch (InvocationTargetException ex10) {
                    ex4 = ex10.getCause();
                    assertTrue(ex3.getClass() + " n'est pas logique quand on inverse une fraction", ex4.getClass() != ex3.getClass());
                } catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InstantiationException ex1) {
                    fail("inverse()");
                }
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException ex1) {
                fail("inverse()");
            }
        } catch (Exception ex) {
            fail("inverse()");
        }
    }

    @Test
    public void p1530_testPlus() {
        System.out.println("Test plus()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok1 = new solution.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok2 = new solution.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("plus() : ", IntrospectionUtilities.equals(
                        fok1.plus(fok2),
                        IntrospectionUtilities.getFromMethod(Fraction.class, ftotest1, "plus", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode plus() doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredMethod("plus", Fraction.class).getExceptionTypes())
                            .filter(p -> IntrospectionUtilities.isCheckedException(p)).count() == 0);
        } catch (Exception ex) {
            fail("plus()");
        }
    }

    @Test
    public void p1530_testFois() {
        System.out.println("Test fois()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok1 = new solution.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok2 = new solution.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("fois() : ", IntrospectionUtilities.equals(
                        fok1.fois(fok2),
                        IntrospectionUtilities.getFromMethod(Fraction.class, ftotest1, "fois", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode fois() doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredMethod("fois", Fraction.class).getExceptionTypes())
                            .filter(p -> IntrospectionUtilities.isCheckedException(p)).count() == 0);

        } catch (Exception ex) {
            fail("fois()");
        }
    }

    @Test
    public void p1540_testMoins() {
        System.out.println("Test moins()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok1 = new solution.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok2 = new solution.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("moins() : ", IntrospectionUtilities.equals(
                        fok1.moins(fok2),
                        IntrospectionUtilities.getFromMethod(Fraction.class, ftotest1, "moins", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode moins() doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredMethod("moins", Fraction.class).getExceptionTypes())
                            .filter(p -> IntrospectionUtilities.isCheckedException(p)).count() == 0);

        } catch (Exception ex) {
            fail("moins()");
        }
    }

    @Test
    public void p1550_testDiviséPar() {
        System.out.println("Test diviséPar()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = IntrospectionUtilities.randomInt(-10, 10);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok1 = new solution.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = IntrospectionUtilities.randomInt(-10, 10, true);
                d = IntrospectionUtilities.randomInt(-10, 10, true);
                solution.fractions.Fraction fok2 = new solution.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("diviséPar() : ", IntrospectionUtilities.equals(
                        fok1.diviséPar(fok2),
                        IntrospectionUtilities.getFromMethod(Fraction.class, ftotest1, "diviséPar", ftotest2)));
            }

            compareTroisExceptions();

        } catch (Exception ex) {
            fail("diviséPar() ");
        }
    }

    private void compareTroisExceptions() {
        Throwable t1 = null, t2 = null, t3 = null;
        try {
            Fraction.class.getDeclaredConstructor(int.class, int.class).newInstance(1, 0);
        } catch (InvocationTargetException ex1) {
            t1 = ex1.getCause();
        } catch (Exception ex) {
            fail("diviséPar()");
        }
        try {
            Fraction.class.getDeclaredConstructor().newInstance().inverse();
        } catch (InvocationTargetException ex2) {
            t2 = ex2.getCause();
        } catch (Exception ex) {
            t2 = ex;
        }
        try {
            Fraction zero = Fraction.class.getDeclaredConstructor().newInstance();
            Fraction.class.getDeclaredConstructor(int.class).newInstance(1).diviséPar(zero);
            Constructor c = Fraction.class.getDeclaredConstructor(int.class);
            Object un = c.newInstance(1);
            IntrospectionUtilities.getFromMethod(Fraction.class, un, "diviséPar", zero);
        } catch (InvocationTargetException ex3) {
            t3 = ex3.getCause();
        } catch (Exception ex) {
            t3 = ex;
        }
        try {
            assertTrue(t3.getClass() + " n'est pas logique quand on divise 2 fractions", t3.getClass() != t1.getClass());
            assertTrue(t3.getClass() + " n'est pas logique quand on divise 2 fractions", t3.getClass() != t2.getClass());
        } catch (Exception ex) {
            fail("diviséPar()");
        }
    }
}
