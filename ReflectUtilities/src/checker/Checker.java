package checker;

import tags.ToCheck;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import tags.CheckModifier;
import tags.GetterToCheck;
import tags.SetterToCheck;
import tags.ToCompare;

/**
 *
 * @author yvan
 */
public class Checker {
    /**
     * SB contient un texte qui le contenu du fichier de test
     */
    private final StringBuilder SB;
    /**
     * MSBall associe un nom de méthode de test à son contenu.
     * Toutes les méthodes de test s'y trouvent.
 Il est même possible d'enrichir MSBall d'un checker à l'autre
     */
    private final Map<String, StringBuilder> MSBall;
    // public final Map<String, StringBuilder> MSB;
    private final Formatter F;
    // La classe testée.
    private final Class<?> C;

    private Checker(Class<?> c, Map<String, StringBuilder> msb) {
        MSBall = msb;
        // MSB = new TreeMap<>();
        SB = new StringBuilder();
        F = new Formatter(SB);
        C = c;
        check();
    }

    public Checker(Class<?> c) {
        this(c, new TreeMap<String, StringBuilder>());
    }
    
    public Checker(Class<?> c, Checker chk) {
        this(c, chk.MSBall);
    }

    private void f(String format, Formatter f, Object... o) {
        f.format(format, o);
        F.format(format, o);
    }

    private final void check() {
        //SB = new StringBuilder();
        //F = new Formatter(SB);
        ToCheck annotation = C.getAnnotation(ToCheck.class);
        if (annotation != null) {
            checkClass(annotation);
        }
        // --- Attributs 
        checkFields();
        // --- Constructeurs 
        checkConstructors();
        // --- Méthodes 
        checkMethods();
        // --- Setters 
        checkSetters();
        // --- Getters 
        checkGetters();
        // --- Méthodes 
        testMethods();
    }

    /**
     * Écrit le test unitaire dont le but est de vérifier 
     *      - l'exactitude du nom de cette classe,
     *      - de ses modificateurs,
     *      - de sa super classe.
     * @param toCheck l'annotation qui annote cette classe.
     */
    public void checkClass(ToCheck toCheck) {
        String testMethodName = String.format("p%06d000_checkClass%s()", toCheck.priority(), C.getSimpleName());       
        
        // sb contiendra à la fin de la méthode le code complet du test unitaire
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        f("\n@Test\n", formatter);
        f("public void %s {\n", formatter, testMethodName);
        f("   System.out.println(\"check class %s\");\n", formatter, C.getSimpleName());
        f("   assertTrue(\"%s\", %s.class.getSuperclass().equals(%s.class));\n", formatter,
                toCheck.value() + " (Héritage)",
                C.getSimpleName(),
                C.getSuperclass().getSimpleName());
        f("   Class<?> x = %s.class;\n", formatter, C.getSimpleName());
        checkModifiers(toCheck.value(), C.getModifiers(), toCheck.modifiers(), formatter);
        /* #### TRAVAUX EN COURS #### */// checkImplementations(toCheck);
        f("}\n", formatter);
        
        MSBall.put(testMethodName, sb);
        //MSB.put(testMethodName, sb);
    }
    /* #### TRAVAUX EN COURS #### */
    public void checkImplementations(ToCheck toCheck, Formatter formatter) {
        List<Class<?>> implementations = Arrays.stream(C.getInterfaces())
                .sorted((i1, i2) -> i1.getName().compareTo(i2.getName()))
                .collect(Collectors.toList());
        f("   List<Class<?>> implementations = Arrays.stream(x.getInterfaces())\n", formatter);
    }

    private void checkConstructor(Constructor<?> c, ToCheck toCheck) {
        String msg = toCheck.value().isEmpty() ? "Constructeur de " + c.getName() : toCheck.value();
        StringBuilder params = Arrays.stream(c.getParameterTypes())
                .map(x -> x.getSimpleName().replaceAll("\\[\\]", "Array"))
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);
          
        String testMethodName = String.format("p%06d000_checkConstructor%s%s()", toCheck.priority(), C.getSimpleName(), params.toString());       
        
        // sb contiendra à la fin de la méthode le code complet du test unitaire
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        
        f("\n@Test\n", formatter);
        f("public void %s {\n", formatter, testMethodName);
        f("   System.out.println(\"Présence %s\");\n", formatter, msg);
        f("   try {\n", formatter);
        f("        Constructor x = %s.class.getDeclaredConstructor(\n", formatter, C.getSimpleName());
        if (c.getParameterCount() > 0) {
            Class<?>[] tparam = c.getParameterTypes();
            f("           %s.class", formatter, tparam[0].getSimpleName());
            for (int i = 1; i < tparam.length; ++i) {
                f(",\n           %s.class", formatter, tparam[i].getSimpleName());
            }
        }
        f("\n        );\n", formatter);
        //f("        assertTrue(\"\", c.getModifiers() == %d);\n", c.getModifiers());
        checkModifiers(toCheck.value(), c.getModifiers(), toCheck.modifiers(), formatter);

        f("   } catch (NoSuchMethodException | SecurityException ex) {\n", formatter);
        f("        fail(\"%s\");\n", formatter, msg);
        f("   }\n", formatter);
        f("}\n", formatter);

        ToCompare toCompare = c.getAnnotation(ToCompare.class);
        if (toCompare != null) {
            compareConstructor(c, toCheck, toCompare);
        }
        
        MSBall.put(testMethodName, sb);
        //MSB.put(testMethodName, sb);
    }

    public void checkConstructors() {
        SB.append('\n');
        Arrays.stream(C.getDeclaredConstructors())
                .filter(c -> c.getAnnotation(ToCheck.class) != null)
                .forEach((c) -> {
                    checkConstructor(c, c.getAnnotation(ToCheck.class));
                });
    }

    /** 
     * TRAVAUX EN COURS. Pour l'instant ne compare rien, Fait la même chose que
     * check
     * @param c
     * @param toCheck
     * @param toCompare 
     */
    private void compareConstructor(Constructor<?> c, ToCheck toCheck, ToCompare toCompare) {
        String msg = toCheck.value().isEmpty() ? "Constructeur de " + c.getName() : toCheck.value();
        
        StringBuilder params = Arrays.stream(c.getParameterTypes())
                .map(x -> x.getSimpleName().replaceAll("\\[\\]", "Array"))
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);
               
        String testMethodName = String.format("p%06d000_testConstructor%s%s()", toCompare.priority(), C.getSimpleName(), params.toString());       
        
        
        // sb contiendra à la fin de la méthode le code complet du test unitaire
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        
        f("\n@Test\n", formatter);
        f("public void %s {\n", formatter, testMethodName);
                     
        f("   System.out.println(\"Test %s\");\n", formatter, msg);
        f("   try {\n", formatter);
        f("        Constructor x = %s.class.getDeclaredConstructor(\n", formatter, C.getSimpleName());
        if (c.getParameterCount() > 0) {
            Class<?>[] tparam = c.getParameterTypes();
            f("           %s.class", formatter, tparam[0].getSimpleName());
            for (int i = 1; i < tparam.length; ++i) {
                f(",\n           %s.class", formatter, tparam[i].getSimpleName());
            }
        }
        f("\n        );\n", formatter);
        //f("        assertTrue(\"\", c.getModifiers() == %d);\n", c.getModifiers());
        checkModifiers(toCheck.value(), c.getModifiers(), toCheck.modifiers(), formatter);

        f("   } catch (NoSuchMethodException | SecurityException ex) {\n", formatter);
        f("        fail(\"%s\");\n", formatter, msg);
        f("   }\n", formatter);
        f("}\n", formatter);
        
        
        MSBall.put(testMethodName, sb);
        //MSB.put(testMethodName, sb);
    }

    public void testMethods() {
        SB.append('\n');
        Arrays.stream(C.getDeclaredMethods())
                .filter(m -> m.getAnnotation(ToCompare.class) != null)
                .forEach(m -> {
                    ToCompare toCompare = m.getAnnotation(ToCompare.class);
                    testMethod(m, toCompare);
                });
    }

    private void testMethod(Method m, ToCompare toCompare) {
                       
        String testMethodName = String.format("p%06d000_testMethod%s%s()", toCompare.priority(), C.getSimpleName(), m.getName());       
        
        // sb contiendra à la fin de la méthode le code complet du test unitaire
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        
        f("\n@Test\n", formatter); 
        f("public void %s {\n", formatter, testMethodName);

        f("   System.out.println(\"Test Method %s.%s\");\n", formatter, C.getSimpleName(), m.getName());
        f("   Class<?> classRef = %s.class;\n", formatter, toCompare.value().getName());
        f("   Class<?> classToTest = %s.class;\n", formatter, C.getSimpleName());
        f("   for (int i = 0; i < 100; ++i) {\n", formatter);
        f("      try {\n", formatter);
        f("         StringBuilder msg = new StringBuilder(\"revoir %s.%s() --> \");\n", formatter, C.getSimpleName(), m.getName());
        f("         boolean result = ReflectUtilities.sameResult(msg, classRef, classToTest, \"%s\");\n", formatter, m.getName());
        f("         assertTrue(msg.toString(), result);\n", formatter);
        f("      } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException | IllegalAccessException | InstantiationException ex) {\n", formatter);        
        f("         fail(\"revoir %s.%s()\");\n", formatter, C.getSimpleName(), m.getName());
        f("      }\n", formatter);     
        f("   }\n", formatter);      
        f("}\n", formatter); 
                
        MSBall.put(testMethodName, sb);
        //MSB.put(testMethodName, sb);
    }

    public void checkFields() {
        SB.append('\n');

        Arrays.stream(C.getDeclaredFields())
                .filter(x -> x.getAnnotation(ToCheck.class) != null)
                .forEach(c -> {
                    checkField(c, c.getAnnotation(ToCheck.class));
                });

    }

    /**
     * Vérifie le champ f de la classe testée
     * @param f
     * @param toCheck 
     */
    private void checkField(Field f, ToCheck toCheck) {
                       
        String testMethodName = String.format("p%06d000_check%sField%s()", toCheck.priority(), C.getSimpleName(), initial(f.getName()));       
        
        // sb contiendra à la fin de la méthode le code complet du test unitaire
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        
        f("\n@Test\n", formatter);
        f("public void %s {\n", formatter, testMethodName);

        f("   System.out.println(\"Check attribut %s\");\n", formatter, f.getName());
        f("   try {\n", formatter);
        f("        Field x = %s.class.getDeclaredField(\"%s\");\n", formatter, C.getSimpleName(), f.getName());
        checkModifiers(toCheck.value(), f.getModifiers(), toCheck.modifiers(), formatter);
        f("        assertTrue(\"%s\", x.getType().equals(%s.class));\n", formatter, toCheck.value(), f.getType().getSimpleName());
        f("   } catch (NoSuchFieldException | SecurityException ex) {\n", formatter);
        f("        fail(\"%s\");\n", formatter, toCheck.value());
        f("   }\n", formatter);
        f("}\n", formatter);
                
        MSBall.put(testMethodName, sb);
        //MSB.put(testMethodName, sb);
    }

    public void checkSetters() {
        SB.append('\n');

        Arrays.stream(C.getDeclaredFields())
                .filter(x -> x.getAnnotation(SetterToCheck.class) != null)
                .forEach(f -> {
                    checkSetter(f, f.getAnnotation(SetterToCheck.class));
                });

    }

    private void checkSetter(Field f, SetterToCheck toCheck) {        
               
        String testMethodName = String.format("p%06d000_checkSetter%s%s()", toCheck.priority(), C.getSimpleName(), f.getName());       
        
        // sb contiendra à la fin de la méthode le code complet du test unitaire
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        
        f("\n@Test\n", formatter);
        f("public void %s {\n", formatter, testMethodName);
        f("   System.out.println(\"Check setter %s\");\n", formatter, f.getName());
        f("   try {\n", formatter);
        f("        Method x = %s.class.getDeclaredMethod(\"set%s\", %s.class);\n", formatter,
                C.getSimpleName(),
                initial(f.getName()),
                f.getType().getSimpleName());
        f("        assertTrue(\"Revoir set%s\", x.getReturnType().equals(void.class));\n", formatter,
                initial(f.getName()));
        f("        Object o = ReflectUtilities.randomValue(%s.class);\n", formatter,
                C.getSimpleName());
        f("        for(int i = 0; i < 100; ++i) {\n", formatter);
        f("            %1$s v = (%1$s) ReflectUtilities.randomValue(%1$s.class);\n", formatter,
                f.getType().getSimpleName());
        f("            ReflectUtilities.getFromMethodTA(\n", formatter);
        f("                 %s.class,\n", formatter, C.getSimpleName());
        f("                 o,\n", formatter);
        f("                 \"set%s\",\n", formatter, initial(f.getName()));
        f("                 %s.class,\n", formatter, f.getType().getSimpleName());
        f("                 v\n", formatter);
        f("            );\n", formatter);
        f("            assertTrue(\"Revoir set%s\", ", formatter, initial(f.getName()));
        f("                                        ReflectUtilities.getAttribut(\n", formatter);
        f("                                           %s.class, \n", formatter, C.getSimpleName());
        f("                                           o, \n", formatter);
        f("                                           \"%s\"\n", formatter, f.getName());
        f("                                        ).equals(v));\n", formatter);
        f("        }\n", formatter);
        f("   } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {\n", formatter);
        f("        fail(\"Revoir set%s\");\n", formatter, initial(f.getName()));
        f("   } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {\n", formatter);
        f("        fail(\"set%s incorrect\");\n", formatter, initial(f.getName()));
        f("   }\n", formatter);
        f("}\n", formatter);
        
                
        MSBall.put(testMethodName, sb);        
        //MSB.put(testMethodName, sb);
        
    }

    public void checkGetters() {
        SB.append('\n');

        Arrays.stream(C.getDeclaredFields())
                .filter(x -> x.getAnnotation(GetterToCheck.class) != null)
                .forEach(f -> {
                    checkGetter(f, f.getAnnotation(GetterToCheck.class));
                });

    }

    private void checkGetter(Field f, GetterToCheck toCheck) {
        /*           
            for (int i = 0; i < 100; ++i) {
                Object o = ReflectUtilities.randomValue(Point.class);
                Object attr = ReflectUtilities.getAttribut(Point.class, o, "x");
                Object getAttr = ReflectUtilities.getFromMethod(Point.class, o, "getX");
                assertTrue("Revoir getX", ReflectUtilities.equals(attr, getAttr));
            }
        } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {
            fail("Revoir getX");
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            fail("Il manque un constructeur pour tester getX");
        }
    }*/
        String className = C.getSimpleName() + ".class";
        String attributName = f.getName();
        String getterName = "get" + initial(f.getName());

                               
        String testMethodName = String.format("p%06d000_checkGetter%s%s()", toCheck.priority(), C.getSimpleName(), initial(f.getName()));       
        
        // sb contiendra à la fin de la méthode le code complet du test unitaire
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        
        f("\n@Test\n", formatter);
        f("public void %s {\n", formatter, testMethodName);
        
        f("   System.out.println(\"Check getter %s\");\n", formatter, attributName);
        f("   try {\n", formatter);
        f("     for(int i = 0; i < 100; ++i) {\n", formatter);
        f("         Object o = ReflectUtilities.randomValue(%s); \n", formatter, className);
        f("         Object attr = ReflectUtilities.getAttribut(%s, o, \"%s\");\n", formatter, className, attributName);
        f("         Object getAttr = ReflectUtilities.getFromMethod(%s, o, \"%s\");\n", formatter, className, getterName);
        f("         assertTrue(\"Revoir %s\", ReflectUtilities.equals(attr, getAttr));\n", formatter, getterName);
        f("     }\n", formatter);
        f("   } catch (SecurityException | NoSuchMethodException | NoSuchFieldException ex) {\n", formatter);
        f("        fail(\"Revoir %s\");\n", formatter, getterName);
        f("   } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {\n", formatter);
        f("        fail(\"%s incorrect\");\n", formatter, getterName);
        f("   }\n", formatter);
        f("}\n", formatter);
                
        MSBall.put(testMethodName, sb);      
        //MSB.put(testMethodName, sb);
    }

    /**
     * Affiche (grâce à f) tous les tests relatives aux modificateurs.
     *
     * @param msg
     * @param modifier
     * @param modifiers
     */
    private void checkModifiers(String msg, long modifier, CheckModifier[] modifiers, Formatter formatter) {
        for (CheckModifier cm : modifiers) {
            f("        " + cm.toString(), formatter, msg, modifier);
        }
    }

    public void checkMethods() {
        SB.append('\n');
        Arrays.stream(C.getDeclaredMethods())
                .filter(m -> m.getAnnotation(ToCheck.class) != null)
                .forEach(m -> {
                    ToCheck toCheck = m.getAnnotation(ToCheck.class);
                    checkMethod(m, toCheck);
                });
    }

    private void checkMethod(Method m, ToCheck toCheck) {
        String msg = toCheck.value();
        msg = msg.isEmpty() ? m.getName() : msg;
        
        StringBuilder params = Arrays.stream(m.getParameterTypes())
                .map(x -> x.getSimpleName().replaceAll("\\[\\]", "Array"))
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append);
        
                             
        String testMethodName = String.format("p%06d000_checkMethod%s%s%s()", toCheck.priority(), C.getSimpleName(), m.getName(), params.toString());       
        
        // sb contiendra à la fin de la méthode le code complet du test unitaire
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        
        f("\n@Test\n", formatter);
        f("public void %s {\n", formatter, testMethodName);

        f("   System.out.println(\"%s\");\n", formatter, msg);
        f("   try {\n", formatter);
        f("        Method x = %s.class.getDeclaredMethod(\"%s\"\n", formatter, C.getSimpleName(), m.getName());
        if (m.getParameterCount() > 0) {
            Class<?>[] tparam = m.getParameterTypes();
            f("          , %s.class", formatter, tparam[0].getSimpleName());
            for (int i = 1; i < tparam.length; ++i) {
                f(",\n           %s.class", formatter, tparam[i].getSimpleName());
            }
        }
        f("        );\n", formatter);
        checkModifiers(msg, m.getModifiers(), toCheck.modifiers(), formatter);
        //f("        assertTrue(\"Revoir %s (Modificateurs)\", c.getModifiers() == %d);\n", msg, m.getModifiers());
        f("        assertTrue(\"Revoir %s (Retour)\", x.getReturnType().equals(%s.class));\n", formatter, msg, m.getReturnType().getSimpleName());
        f("   } catch (NoSuchMethodException | SecurityException ex) {\n", formatter);
        f("        fail(\"Revoir %s\");\n", formatter, msg);
        f("   }\n", formatter);
        f("}\n", formatter);
                
        MSBall.put(testMethodName, sb);      
        //MSB.put(testMethodName, sb);
    }

    @Override
    public String toString() {
        return SB.toString();
    }

    private String initial(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    
    /*public String getTUofThatCkassOrderByName() {
        StringBuilder sb = new StringBuilder();
        MSB.keySet().forEach((name) -> {
            sb.append(MSB.get(name));
        });
        return sb.toString();
    }*/
    
    public String getAllTUOrderByName() {
        StringBuilder sb = new StringBuilder();
        MSBall.keySet().forEach((name) -> {
            sb.append(MSBall.get(name));
        });
        return sb.toString();
    }
}
