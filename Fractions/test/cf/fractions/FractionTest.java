/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package cf.fractions;

import static org.junit.Assert.*;
import java.lang.reflect.*;
import java.util.Arrays;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import reflect.ReflectUtilities;


import rf.fractions.Fraction;

/**
 *
 * @author yvan
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FractionTest {
 
    @Test
    public void p000001000_checkClassFraction() {
        System.out.println("check class Fraction");
        assertTrue("Modificateurs de Fraction. Bien relire l'énoncé (Héritage)", Fraction.class.getSuperclass().equals(Object.class));
        Class<?> x = Fraction.class;
        assertTrue("Revoir Modificateurs de Fraction. Bien relire l'énoncé (Modificateurs)", Modifier.isAbstract(17) == Modifier.isAbstract(x.getModifiers()));
        assertTrue("Revoir Modificateurs de Fraction. Bien relire l'énoncé (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
        assertTrue("Revoir Modificateurs de Fraction. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
    }

    @Test
    public void p000002000_checkFractionFieldNumérateur() {
        System.out.println("Check attribut numérateur");
        try {
            Field x = Fraction.class.getDeclaredField("numérateur");
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(17) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(17) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Les attributs. Bien relire l'énoncé", x.getType().equals(int.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("Les attributs. Bien relire l'énoncé");
        }
    }

    @Test
    public void p000002000_checkFractionFieldDénominateur() {
        System.out.println("Check attribut dénominateur");
        try {
            Field x = Fraction.class.getDeclaredField("dénominateur");
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(17) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(17) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Les attributs. Bien relire l'énoncé", x.getType().equals(int.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("Les attributs. Bien relire l'énoncé");
        }
    }

    @Test
    public void p000003000_checkConstructorFractionintint() {
        System.out.println("Présence Le constructeur à deux paramètres. Bien relire l'énoncé");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor(
                    int.class,
                    int.class
            );
            assertTrue("Revoir Le constructeur à deux paramètres. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres. Bien relire l'énoncé (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Le constructeur à deux paramètres. Bien relire l'énoncé");
        }
    }
    
    
    @Test
    public void p000003100_testConstructeurIntInt() {
        System.out.println("Test constructeur à deux paramètres");
        try {
            Constructor c = Fraction.class.getConstructor(int.class, int.class);
            int n, d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-50, 50);
                d = ReflectUtilities.randomInt(-50, 50);
                //System.out.println(n + "/" + d);
                try {
                    cf.fractions.Fraction fok = new cf.fractions.Fraction(n, d);
                    Fraction ftotest = (Fraction) c.newInstance(n, d);
                    assertTrue("Revoir constructeurIntInt. Bien relire l'énoncé", ReflectUtilities.equals(fok, ftotest));
                } catch (cf.exceptions.DénominateurNul ex) {
                    try {
                        c.newInstance(n, d);
                        fail("Devrait lancer une exception. Bien relire l'énoncé");
                    } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException | InvocationTargetException ex2) {
                        assertTrue("Une exception devrait être lancée. Bien relire l'énoncé", d == 0);
                    }
                }
            }
            try {
                c.newInstance(1, 0);
                fail("Devrait lancer une exception contrôlée");
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException ex2) {
                assertTrue("Devrait lancer une exception contrôlée", ReflectUtilities.isCheckedException(ex2.getCause()));
            }
        } catch (Exception ex) {
            fail("Revoir constructeurIntInt");
        }
    }


    @Test
    public void p000004000_checkConstructorFractionint() {
        System.out.println("Présence Le constructeur à un paramètre. Bien relire l'énoncé");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor(
                    int.class
            );
            assertTrue("Revoir Le constructeur à un paramètre. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre. Bien relire l'énoncé (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Le constructeur à un paramètre. Bien relire l'énoncé");
        }
    }
    
    
    @Test
    public void p000004100_testConstructeurInt() {
        System.out.println("Test constructeur à un paramètre");
        try {
            Constructor c = Fraction.class.getConstructor(int.class);
            int n;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-50, 50);
                cf.fractions.Fraction fok = new cf.fractions.Fraction(n);
                Fraction ftotest = (Fraction) c.newInstance(n);
                assertTrue("Revoir constructeurInt", ReflectUtilities.equals(fok, ftotest));
            }
        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }


    @Test
    public void p000005000_checkConstructorFraction() {
        System.out.println("Présence Le constructeur par défaut. Bien relire l'énoncé");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor();
            assertTrue("Revoir Le constructeur par défaut. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut. Bien relire l'énoncé (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Le constructeur par défaut. Bien relire l'énoncé");
        }
    }

    @Test
    public void p000005100_testConstructeur() {
        System.out.println("Test constructeur par défaut");
        try {
            Constructor c = Fraction.class.getConstructor();

            cf.fractions.Fraction fok = new cf.fractions.Fraction();
            Fraction ftotest = (Fraction) c.newInstance();
            //assertTrue("Revoir constructeur", ReflectUtilities.equals(fok, ftotest));
            assertTrue("Revoir constructeur", ReflectUtilities.getAttribut(ftotest.getClass(), ftotest, "numérateur").equals(0));
            System.out.println("---->" + ReflectUtilities.getAttribut(ftotest.getClass(), ftotest, "numérateur"));
            assertTrue("Revoir constructeur", ReflectUtilities.getAttribut(ftotest.getClass(), ftotest, "dénominateur").equals(1));
            System.out.println("---->" + ReflectUtilities.getAttribut(ftotest.getClass(), ftotest, "dénominateur"));

        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }

    @Test
    public void p000005200_testConstructeur() {
        System.out.println("Test constructeur par défaut");
        try {
            Constructor c = Fraction.class.getConstructor();

            cf.fractions.Fraction fok = new cf.fractions.Fraction();
            Fraction ftotest = (Fraction) c.newInstance();
            assertTrue("Revoir constructeur", ReflectUtilities.equals(fok, ftotest));

        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }

    @Test
    public void p000006000_checkMethodFractionaffiche() {
        System.out.println("affiche()");
        try {
            Method x = Fraction.class.getDeclaredMethod("affiche"
            );
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir affiche() (Retour)", x.getReturnType().equals(void.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir affiche()");
        }
    }
    @Test
    public void p000006100_testAffiche() {
        System.out.println("Test affiche()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok = new cf.fractions.Fraction(n, d);
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                String s1 = ReflectUtilities.getFromMethodTASystemOut(cf.fractions.Fraction.class, fok, "affiche");
                String s2 = ReflectUtilities.getFromMethodTASystemOut(Fraction.class, ftotest, "affiche");
                
                assertEquals(s1.trim(), s2.trim());
            }
        } catch (Exception ex) {
            fail("affiche()");
        }
    }


    @Test
    public void p000007000_checkMethodFractionopposé() {
        System.out.println("opposé()");
        try {
            Method x = Fraction.class.getDeclaredMethod("opposé"
            );
            assertTrue("Revoir signature opposé() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature opposé() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature opposé() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature opposé() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature opposé() (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature opposé()");
        }
    }

    @Test
    public void p000007100_testOpposé() {
        System.out.println("Test opposé()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok = new cf.fractions.Fraction(n, d).opposé();
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                ftotest = (Fraction) ReflectUtilities.getFromMethod(Fraction.class, ftotest, "opposé");
                assertTrue("opposé()", ReflectUtilities.equals(fok, ftotest));
            }
            assertTrue("Êtes-vous sûr que la méthode opposé() doive lancer une exception contrôlée ?",
                    Arrays.stream(Fraction.class.getDeclaredMethod("opposé").getExceptionTypes())
                            .filter(p -> ReflectUtilities.isCheckedException(p)).count() == 0);
        } catch (Exception ex) {
            fail("opposé()");
        }
    }

    @Test
    public void p000008000_checkMethodFractioninverse() {
        System.out.println("inverse()");
        try {
            Method x = Fraction.class.getDeclaredMethod("inverse"
            );
            assertTrue("Revoir signature inverse() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature inverse() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature inverse() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature inverse() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature inverse() (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature inverse()");
        }
    }
    
    @Test
    public void p000008100_testInverse() {
        System.out.println("Test inverse()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok = new cf.fractions.Fraction(n, d).inverse();
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                ftotest = (Fraction) ReflectUtilities.getFromMethod(Fraction.class, ftotest, "inverse");
                assertTrue("inverse()", ReflectUtilities.equals(fok, ftotest));
            }
        } catch (cf.exceptions.InversionFractionNulle ex) {
            Throwable ex3;
            Throwable ex4;
            try {
                Fraction.class.getConstructor(int.class, int.class).newInstance(1, 0);
            } catch (InvocationTargetException ex2) {
                ex3 = ex2.getCause();
                try {
                    Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(0, 1);
                    ftotest = (Fraction) ReflectUtilities.getFromMethod(Fraction.class, ftotest, "inverse");
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
    public void p000009000_checkMethodFractionplusFraction() {
        System.out.println("plus(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("plus",
                     Fraction.class);
            assertTrue("Revoir signature plus(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature plus(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature plus(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature plus(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature plus(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature plus(Fraction f)");
        }
    }

    @Test
    public void p000009100_testPlus() {
        System.out.println("Test plus()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok1 = new cf.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok2 = new cf.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("Revoir plus() : ", ReflectUtilities.equals(
                        fok1.plus(fok2),
                        ReflectUtilities.getFromMethod(Fraction.class, ftotest1, "plus", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode plus() doive lancer une exception contrôlée ?",
                    Arrays.stream(Fraction.class.getDeclaredMethod("plus", Fraction.class).getExceptionTypes())
                            .filter(p -> ReflectUtilities.isCheckedException(p)).count() == 0);
        } catch (Exception ex) {
            fail("Revoir plus()");
        }
    }

    @Test
    public void p000010000_checkMethodFractionfoisFraction() {
        System.out.println("fois(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("fois",
                     Fraction.class);
            assertTrue("Revoir signature fois(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature fois(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature fois(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature fois(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature fois(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature fois(Fraction f)");
        }
    }

    @Test
    public void p000010100_testFois() {
        System.out.println("Test fois()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok1 = new cf.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok2 = new cf.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("Revoir fois() : ", ReflectUtilities.equals(
                        fok1.fois(fok2),
                        ReflectUtilities.getFromMethod(Fraction.class, ftotest1, "fois", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode fois() doive lancer une exception contrôlée ?",
                    Arrays.stream(Fraction.class.getDeclaredMethod("fois", Fraction.class).getExceptionTypes())
                            .filter(p -> ReflectUtilities.isCheckedException(p)).count() == 0);

        } catch (Exception ex) {
            fail("Revoir fois()");
        }
    }

    @Test
    public void p000011000_checkMethodFractionmoinsFraction() {
        System.out.println("moins(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("moins",
                     Fraction.class);
            assertTrue("Revoir signature moins(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature moins(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature moins(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature moins(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature moins(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature moins(Fraction f)");
        }
    }

    @Test
    public void p000011100_testMoins() {
        System.out.println("Test moins()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok1 = new cf.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok2 = new cf.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("Revoir moins() : ", ReflectUtilities.equals(
                        fok1.moins(fok2),
                        ReflectUtilities.getFromMethod(Fraction.class, ftotest1, "moins", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode moins() doive lancer une exception contrôlée ?",
                    Arrays.stream(Fraction.class.getDeclaredMethod("moins", Fraction.class).getExceptionTypes())
                            .filter(p -> ReflectUtilities.isCheckedException(p)).count() == 0);

        } catch (Exception ex) {
            fail("Revoir moins()");
        }
    }

    @Test
    public void p000012000_checkMethodFractiondiviséParFraction() {
        System.out.println("diviséPar(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("diviséPar",
                     Fraction.class);
            assertTrue("Revoir signature diviséPar(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature diviséPar(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature diviséPar(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature diviséPar(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature diviséPar(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature diviséPar(Fraction f)");
        }
    }
    
    @Test
    public void p000012100_testDiviséPar() {
        System.out.println("Test diviséPar()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok1 = new cf.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = ReflectUtilities.randomInt(-10, 10, true);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok2 = new cf.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("Revoir diviséPar() : ", ReflectUtilities.equals(
                        fok1.diviséPar(fok2),
                        ReflectUtilities.getFromMethod(Fraction.class, ftotest1, "diviséPar", ftotest2)));
            }

            compareTroisExceptions();

        } catch (Exception ex) {
            fail("Revoir diviséPar() ");
        }
    }

    @Test
    public void p000014000_testImmuable() {
        System.out.println("Test d'immuabilité");
        assertFalse("Fraction devrait être immuable", ReflectUtilities.isMutable(Fraction.class));
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
            Object zero = Fraction.class.getDeclaredConstructor().newInstance();
            ReflectUtilities.getFromMethod(Fraction.class, zero, "inverse");
            //Fraction.class.getDeclaredConstructor().newInstance().inverse();
        } catch (InvocationTargetException ex2) {
            t2 = ex2.getCause();
        } catch (Exception ex) {
            t2 = ex;
        }
        try {
            Fraction zero = Fraction.class.getDeclaredConstructor().newInstance();
            //Fraction.class.getDeclaredConstructor(int.class).newInstance(1).diviséPar(zero);
            Constructor c = Fraction.class.getDeclaredConstructor(int.class);
            Object un = c.newInstance(1);
            ReflectUtilities.getFromMethod(Fraction.class, un, "diviséPar", zero);
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

    /*
    
    @Test
    public void p000001000_checkClassFraction() {
        System.out.println("check class Fraction");
        assertTrue("Modificateurs de Fraction. Bien relire l'énoncé (Héritage)", Fraction.class.getSuperclass().equals(Object.class));
        Class<?> x = Fraction.class;
        assertTrue("Revoir Modificateurs de Fraction. Bien relire l'énoncé (Modificateurs)", Modifier.isAbstract(17) == Modifier.isAbstract(x.getModifiers()));
        assertTrue("Revoir Modificateurs de Fraction. Bien relire l'énoncé (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
        assertTrue("Revoir Modificateurs de Fraction. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
    }

    @Test
    public void p000002000_checkFractionFieldNumérateur() {
        System.out.println("Check attribut numérateur");
        try {
            Field x = Fraction.class.getDeclaredField("numérateur");
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(17) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(17) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Les attributs. Bien relire l'énoncé", x.getType().equals(int.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("Les attributs. Bien relire l'énoncé");
        }
    }

    @Test
    public void p000002000_checkFractionFieldDénominateur() {
        System.out.println("Check attribut dénominateur");
        try {
            Field x = Fraction.class.getDeclaredField("dénominateur");
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isFinal(17) == Modifier.isFinal(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(17) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(17) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Les attributs. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(17) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Les attributs. Bien relire l'énoncé", x.getType().equals(int.class));
        } catch (NoSuchFieldException | SecurityException ex) {
            fail("Les attributs. Bien relire l'énoncé");
        }
    }

    @Test
    public void p000003000_checkConstructorFractionintint() {
        System.out.println("Présence Le constructeur à deux paramètres. Bien relire l'énoncé");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor(
                    int.class,
                    int.class
            );
            assertTrue("Revoir Le constructeur à deux paramètres. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur à deux paramètres. Bien relire l'énoncé (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Le constructeur à deux paramètres. Bien relire l'énoncé");
        }
    }
    
    
    @Test
    public void p000003100_testConstructeurIntInt() {
        System.out.println("Test constructeur à deux paramètres");
        try {
            Constructor c = Fraction.class.getConstructor(int.class, int.class);
            int n, d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-50, 50);
                d = ReflectUtilities.randomInt(-50, 50);
                //System.out.println(n + "/" + d);
                try {
                    cf.fractions.Fraction fok = new cf.fractions.Fraction(n, d);
                    Fraction ftotest = (Fraction) c.newInstance(n, d);
                    assertTrue("Revoir constructeurIntInt. Bien relire l'énoncé", ReflectUtilities.equals(fok, ftotest));
                } catch (DénominateurNul ex) {
                    try {
                        c.newInstance(n, d);
                        fail("Devrait lancer une exception. Bien relire l'énoncé");
                    } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException | InvocationTargetException ex2) {
                        assertTrue("Une exception devrait être lancée. Bien relire l'énoncé", d == 0);
                    }
                }
            }
            try {
                c.newInstance(1, 0);
                fail("Devrait lancer une exception contrôlée");
            } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException ex2) {
                assertTrue("Devrait lancer une exception contrôlée", ReflectUtilities.isCheckedException(ex2.getCause()));
            }
        } catch (Exception ex) {
            fail("Revoir constructeurIntInt");
        }
    }


    @Test
    public void p000004000_checkConstructorFractionint() {
        System.out.println("Présence Le constructeur à un paramètre. Bien relire l'énoncé");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor(
                    int.class
            );
            assertTrue("Revoir Le constructeur à un paramètre. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur à un paramètre. Bien relire l'énoncé (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Le constructeur à un paramètre. Bien relire l'énoncé");
        }
    }
    
    
    @Test
    public void p000004100_testConstructeurInt() {
        System.out.println("Test constructeur à un paramètre");
        try {
            Constructor c = Fraction.class.getConstructor(int.class);
            int n;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-50, 50);
                cf.fractions.Fraction fok = new cf.fractions.Fraction(n);
                Fraction ftotest = (Fraction) c.newInstance(n);
                assertTrue("Revoir constructeurInt", ReflectUtilities.equals(fok, ftotest));
            }
        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }


    @Test
    public void p000005000_checkConstructorFraction() {
        System.out.println("Présence Le constructeur par défaut. Bien relire l'énoncé");
        try {
            Constructor x = Fraction.class.getDeclaredConstructor();
            assertTrue("Revoir Le constructeur par défaut. Bien relire l'énoncé (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut. Bien relire l'énoncé (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut. Bien relire l'énoncé (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir Le constructeur par défaut. Bien relire l'énoncé (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Le constructeur par défaut. Bien relire l'énoncé");
        }
    }

    @Test
    public void p000005100_testConstructeur() {
        System.out.println("Test constructeur par défaut");
        try {
            Constructor c = Fraction.class.getConstructor();

            cf.fractions.Fraction fok = new cf.fractions.Fraction();
            Fraction ftotest = (Fraction) c.newInstance();
            //assertTrue("Revoir constructeur", ReflectUtilities.equals(fok, ftotest));
            assertTrue("Revoir constructeur", ReflectUtilities.getAttribut(ftotest.getClass(), ftotest, "numérateur").equals(0));
            System.out.println("---->" + ReflectUtilities.getAttribut(ftotest.getClass(), ftotest, "numérateur"));
            assertTrue("Revoir constructeur", ReflectUtilities.getAttribut(ftotest.getClass(), ftotest, "dénominateur").equals(1));
            System.out.println("---->" + ReflectUtilities.getAttribut(ftotest.getClass(), ftotest, "dénominateur"));

        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }

    @Test
    public void p000005200_testConstructeur() {
        System.out.println("Test constructeur par défaut");
        try {
            Constructor c = Fraction.class.getConstructor();

            cf.fractions.Fraction fok = new cf.fractions.Fraction();
            Fraction ftotest = (Fraction) c.newInstance();
            assertTrue("Revoir constructeur", ReflectUtilities.equals(fok, ftotest));

        } catch (Exception ex) {
            fail("Revoir constructeurInt");
        }
    }

    @Test
    public void p000006000_checkMethodFractionaffiche() {
        System.out.println("affiche()");
        try {
            Method x = Fraction.class.getDeclaredMethod("affiche"
            );
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir affiche() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir affiche() (Retour)", x.getReturnType().equals(void.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir affiche()");
        }
    }
    @Test
    public void p000006100_testAffiche() {
        System.out.println("Test affiche()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok = new cf.fractions.Fraction(n, d);
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                String s1 = ReflectUtilities.getFromMethodTASystemOut(cf.fractions.Fraction.class, fok, "affiche");
                String s2 = ReflectUtilities.getFromMethodTASystemOut(Fraction.class, ftotest, "affiche");
                
                assertEquals(s1.trim(), s2.trim());
            }
        } catch (Exception ex) {
            fail("affiche()");
        }
    }


    @Test
    public void p000007000_checkMethodFractionopposé() {
        System.out.println("opposé()");
        try {
            Method x = Fraction.class.getDeclaredMethod("opposé"
            );
            assertTrue("Revoir signature opposé() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature opposé() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature opposé() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature opposé() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature opposé() (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature opposé()");
        }
    }

    @Test
    public void p000007100_testOpposé() {
        System.out.println("Test opposé()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok = new cf.fractions.Fraction(n, d).opposé();
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                ftotest = (Fraction) ReflectUtilities.getFromMethod(Fraction.class, ftotest, "opposé");
                assertTrue("opposé()", ReflectUtilities.equals(fok, ftotest));
            }
            assertTrue("Êtes-vous sûr que la méthode opposé() doive lancer une exception contrôlée ?",
                    Arrays.stream(Fraction.class.getDeclaredMethod("opposé").getExceptionTypes())
                            .filter(p -> ReflectUtilities.isCheckedException(p)).count() == 0);
        } catch (Exception ex) {
            fail("opposé()");
        }
    }

    @Test
    public void p000008000_checkMethodFractioninverse() {
        System.out.println("inverse()");
        try {
            Method x = Fraction.class.getDeclaredMethod("inverse"
            );
            assertTrue("Revoir signature inverse() (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature inverse() (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature inverse() (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature inverse() (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature inverse() (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature inverse()");
        }
    }
    
    @Test
    public void p000008100_testInverse() {
        System.out.println("Test inverse()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok = new cf.fractions.Fraction(n, d).inverse();
                Fraction ftotest = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);
                ftotest = (Fraction) ReflectUtilities.getFromMethod(Fraction.class, ftotest, "inverse");
                assertTrue("inverse()", ReflectUtilities.equals(fok, ftotest));
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
                    ftotest = (Fraction) ReflectUtilities.getFromMethod(Fraction.class, ftotest, "inverse");
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
    public void p000009000_checkMethodFractionplusFraction() {
        System.out.println("plus(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("plus",
                     Fraction.class);
            assertTrue("Revoir signature plus(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature plus(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature plus(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature plus(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature plus(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature plus(Fraction f)");
        }
    }

    @Test
    public void p000009100_testPlus() {
        System.out.println("Test plus()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok1 = new cf.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok2 = new cf.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("plus() : ", ReflectUtilities.equals(
                        fok1.plus(fok2),
                        ReflectUtilities.getFromMethod(Fraction.class, ftotest1, "plus", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode plus() doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredMethod("plus", Fraction.class).getExceptionTypes())
                            .filter(p -> ReflectUtilities.isCheckedException(p)).count() == 0);
        } catch (Exception ex) {
            fail("plus()");
        }
    }

    @Test
    public void p000010000_checkMethodFractionfoisFraction() {
        System.out.println("fois(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("fois",
                     Fraction.class);
            assertTrue("Revoir signature fois(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature fois(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature fois(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature fois(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature fois(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature fois(Fraction f)");
        }
    }

    @Test
    public void p000010100_testFois() {
        System.out.println("Test fois()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok1 = new cf.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok2 = new cf.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("fois() : ", ReflectUtilities.equals(
                        fok1.fois(fok2),
                        ReflectUtilities.getFromMethod(Fraction.class, ftotest1, "fois", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode fois() doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredMethod("fois", Fraction.class).getExceptionTypes())
                            .filter(p -> ReflectUtilities.isCheckedException(p)).count() == 0);

        } catch (Exception ex) {
            fail("fois()");
        }
    }

    @Test
    public void p000011000_checkMethodFractionmoinsFraction() {
        System.out.println("moins(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("moins",
                     Fraction.class);
            assertTrue("Revoir signature moins(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature moins(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature moins(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature moins(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature moins(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature moins(Fraction f)");
        }
    }

    @Test
    public void p000011100_testMoins() {
        System.out.println("Test moins()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok1 = new cf.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok2 = new cf.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("moins() : ", ReflectUtilities.equals(
                        fok1.moins(fok2),
                        ReflectUtilities.getFromMethod(Fraction.class, ftotest1, "moins", ftotest2)));
            }
            assertTrue("Êtes-vous sûr que la méthode moins() doive lancer une exception contrôlée",
                    Arrays.stream(Fraction.class.getDeclaredMethod("moins", Fraction.class).getExceptionTypes())
                            .filter(p -> ReflectUtilities.isCheckedException(p)).count() == 0);

        } catch (Exception ex) {
            fail("moins()");
        }
    }

    @Test
    public void p000012000_checkMethodFractiondiviséParFraction() {
        System.out.println("diviséPar(Fraction f)");
        try {
            Method x = Fraction.class.getDeclaredMethod("diviséPar",
                     Fraction.class);
            assertTrue("Revoir signature diviséPar(Fraction f) (Modificateurs)", Modifier.isPrivate(1) == Modifier.isPrivate(x.getModifiers()));
            assertTrue("Revoir signature diviséPar(Fraction f) (Modificateurs)", Modifier.isProtected(1) == Modifier.isProtected(x.getModifiers()));
            assertTrue("Revoir signature diviséPar(Fraction f) (Modificateurs)", Modifier.isPublic(1) == Modifier.isPublic(x.getModifiers()));
            assertTrue("Revoir signature diviséPar(Fraction f) (Modificateurs)", Modifier.isStatic(1) == Modifier.isStatic(x.getModifiers()));
            assertTrue("Revoir signature diviséPar(Fraction f) (Retour)", x.getReturnType().equals(Fraction.class));
        } catch (NoSuchMethodException | SecurityException ex) {
            fail("Revoir signature diviséPar(Fraction f)");
        }
    }
    
    @Test
    public void p000012100_testDiviséPar() {
        System.out.println("Test diviséPar()");
        try {
            int n;
            int d;
            for (int i = 0; i < 100; ++i) {
                n = ReflectUtilities.randomInt(-10, 10);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok1 = new cf.fractions.Fraction(n, d);
                Fraction ftotest1 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                n = ReflectUtilities.randomInt(-10, 10, true);
                d = ReflectUtilities.randomInt(-10, 10, true);
                cf.fractions.Fraction fok2 = new cf.fractions.Fraction(n, d);
                Fraction ftotest2 = Fraction.class.getConstructor(int.class, int.class).newInstance(n, d);

                assertTrue("diviséPar() : ", ReflectUtilities.equals(
                        fok1.diviséPar(fok2),
                        ReflectUtilities.getFromMethod(Fraction.class, ftotest1, "diviséPar", ftotest2)));
            }

            compareTroisExceptions();

        } catch (Exception ex) {
            fail("diviséPar() ");
        }
    }

    @Test
    public void p1400_testImmuable() {
        System.out.println("Test d'immuabilité");
        assertFalse("Fraction devrait être immuable", ReflectUtilities.isMutable(Fraction.class));
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
            Object zero = Fraction.class.getDeclaredConstructor().newInstance();
            ReflectUtilities.getFromMethod(Fraction.class, zero, "inverse");
            //Fraction.class.getDeclaredConstructor().newInstance().inverse();
        } catch (InvocationTargetException ex2) {
            t2 = ex2.getCause();
        } catch (Exception ex) {
            t2 = ex;
        }
        try {
            Fraction zero = Fraction.class.getDeclaredConstructor().newInstance();
            //Fraction.class.getDeclaredConstructor(int.class).newInstance(1).diviséPar(zero);
            Constructor c = Fraction.class.getDeclaredConstructor(int.class);
            Object un = c.newInstance(1);
            ReflectUtilities.getFromMethod(Fraction.class, un, "diviséPar", zero);
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
*/   
    
}
