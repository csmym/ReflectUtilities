/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package reflect;

import checker.Checker;
import exceptions.NoSimpleConstructor;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * @author yvan
 */
public class ReflectUtilities {

    private static Random R = new Random();

    /**
     * Retourne par introspection le résultat de l'invocation d'une méthode avec
     * ses arguments.
     *
     * @param c la classe à laquelle la méthode appartient
     * @param o l'objet sur lequel s'application la méthode
     * @param methodName le nom de la méthode
     * @param pv une liste de couples (type et sa valeur)
     * @return le résultat de l'invocation
     * @throws java.lang.NoSuchMethodException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     */
    public static Object getFromMethodTA(Class<?> c, Object o, String methodName, Object... pv) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        StringBuilder methodNameAndArgs = new StringBuilder(methodName);
        methodNameAndArgs.append("(");

        Class<?>[] params = new Class<?>[pv.length / 2];
        Object[] values = new Object[pv.length / 2];
        int k = 0;
        for (int i = 0; i < pv.length; i += 2) {
            params[k] = (Class<?>) pv[i];
            methodNameAndArgs.append(params[k].getSimpleName()).append(", ");
            values[k++] = pv[i + 1];
        }
        methodNameAndArgs.append(")");
        Method method = c.getDeclaredMethod(methodName, params);
        return method.invoke(o, values);

    }

    /**
     * Retourne dans une chaine de caractères le résultat à l'écran de
     * l'invocation d'une méthode avec ses arguments.
     *
     * @param c la classe à laquelle la méthode appartient
     * @param o l'objet sur lequel s'application la méthode
     * @param methodName le nom de la méthode
     * @param pv une liste de valeurs (dont les types sont déduits)
     * @return le résultat de l'invocation
     */
    public static String getFromMethodTASystemOut(Class<?> c, Object o, String methodName, Object... pv) throws FileNotFoundException, IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        PrintStream out = System.out;
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            System.setOut(new PrintStream(bos));
            getFromMethodTA(c, o, methodName, pv);
            return bos.toString();
        } catch (IllegalArgumentException ex) {
            return "";
        } finally {
            System.setOut(out);
        }
    }

    /**
     * Retourne par introspection le résultat de l'invocation d'une méthode avec
     * ses arguments.
     *
     * @param c la classe à laquelle la méthode appartient
     * @param o l'objet sur lequel s'application la méthode
     * @param methodName le nom de la méthode
     * @param pv une liste de valeurs (dont les types sont déduits)
     * @return le résultat de l'invocation
     */
    public static Object getFromMethod(Class<?> c, Object o, String methodName, Object... pv) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object[] coupletv = new Object[2 * pv.length];
        int k = 0;
        for (int i = 0; i < pv.length; i++) {
            coupletv[k++] = pv[i].getClass();
            coupletv[k++] = pv[i];
        }
        return getFromMethodTA(c, o, methodName, coupletv);
    }

    public static void setAttribut(Class<?> c, Object o, String nom, Object v) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        Field fnom = c.getDeclaredField(nom);
        fnom.setAccessible(true);
        fnom.set(o, v);

    }

    public static Object getAttribut(Class<?> c, Object o, String nom) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        Field fnom = c.getDeclaredField(nom);
        fnom.setAccessible(true);
        return fnom.get(o);

    }

    public static boolean checkIfMutable(Object o1, Method m) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, FileNotFoundException {
        Object o2 = clone(o1);
        m.setAccessible(true);

        for (int i = 0; i < 100; i++) {
            PrintStream out = System.out;
            PrintStream err = System.err;
            System.setOut(new PrintStream("tmpout"));
            System.setErr(new PrintStream("tmperr"));
            m.invoke(o2, fillParametersArray(m));
            System.setOut(out);
            System.setErr(err);

            if (!equals(o1, o2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isASetter(Method m, Class<?> C) {
        try {
            Constructor<?> c = C.getConstructor();
            c.setAccessible(true);
            Object o = c.newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        }
        return true;
    }

    public static boolean thereIsSetter(Class<?> C) {
        return Arrays.stream(C.getMethods())
                .anyMatch(m -> m.getName().startsWith("set"))
                || Arrays.stream(C.getDeclaredMethods())
                        .filter(m -> !Modifier.isPrivate(m.getModifiers()))
                        .anyMatch(m -> m.getName().startsWith("set"));
    }

    public static boolean isMutable(Class<?> C) {
        return thereIsSetter(C)
                || Arrays.stream(C.getDeclaredFields())
                        .anyMatch(
                                p -> !Modifier.isPrivate(p.getModifiers())
                                && (!Modifier.isFinal(p.getModifiers())
                                || (!p.getType().isPrimitive()
                                && isMutable(p.getType())))
                        )
                || Arrays.stream(C.getFields())
                        .anyMatch(
                                p -> !Modifier.isPrivate(p.getModifiers())
                                && (!Modifier.isFinal(p.getModifiers())
                                || (!p.getType().isPrimitive()
                                && isMutable(p.getType())))
                        );

    }

    public static boolean checkAttributsForMutability(Class<?> c) {
        return Arrays.stream(c.getDeclaredFields())
                .anyMatch(
                        p -> !Modifier.isPrivate(p.getModifiers())
                        && (!Modifier.isFinal(p.getModifiers())
                        || (!p.getType().isPrimitive()
                        && isMutable(p.getType())))
                )
                || Arrays.stream(c.getFields())
                        .anyMatch(
                                p -> !Modifier.isPrivate(p.getModifiers())
                                && (!Modifier.isFinal(p.getModifiers())
                                || (!p.getType().isPrimitive()
                                && isMutable(p.getType())))
                        );
    }

    public static boolean checkIfMutable(Class<?> c) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, FileNotFoundException {

        Object o1 = randomValue(c);
        for (Method m : c.getDeclaredMethods()) {
            if (!Modifier.isStatic(m.getModifiers())) {
                if (checkIfMutable(o1, m)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Object clone(Object o1, Class<?> c2) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, NoSuchFieldException {
        Object o2 = randomValue(c2);
        for (Field f1 : o1.getClass().getDeclaredFields()) {
            Field f2 = c2.getDeclaredField(f1.getName());
            f1.setAccessible(true);
            f2.setAccessible(true);
            if (f2.getType() == f1.getType()) {
                f2.set(o2, f1.get(o1));
            } else {
                f2.set(o2, clone(f1.get(o1), f2.getType()));
            }
        }
        return o2;
    }

    public static Object clone(Object o) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Object co = randomValue(o.getClass());
        for (Field f : o.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            f.set(co, f.get(o));
        }
        return co;
    }

    public static boolean equals(Object o1, Object o2) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        return equals(o1, o2, false);
    }

    public static boolean equals(Object o1, Object o2, boolean isPrimitive) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        if (!o1.getClass().getSimpleName().equals(o2.getClass().getSimpleName())) {
            return false;
        } else if (o1.getClass().isPrimitive() || isPrimitive) {
            return o1.equals(o2);
        } else {
            for (Field f1 : o1.getClass().getDeclaredFields()) {
                try {
                    Field f2 = o2.getClass().getDeclaredField(f1.getName());
                    if (!Modifier.isStatic(f1.getModifiers())) {
                        f1.setAccessible(true);
                        f2.setAccessible(true);
                        if (!equals(f1.get(o1), f2.get(o2), f1.getType().isPrimitive())) {
                            return false;
                        }
                    }
                } catch (NoSuchFieldException | SecurityException ex) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean allParametersArePrimitive(Constructor<?> c) {
        return Arrays.stream(c.getParameterTypes())
                .allMatch(p -> p.isPrimitive());
    }

    public static Constructor<?> getOneConstructor(Class<?> c) {
        return Arrays.stream(c.getConstructors())
                .filter(p -> p.getParameterCount() > 0)
                .findFirst().get();
    }

    public static Constructor<?> getOneSimpleConstructor(Class<?> c) throws NoSimpleConstructor {
        try {
            return Arrays.stream(c.getConstructors())
                    .filter(p -> allParametersArePrimitive(p))
                    .findFirst().get();
        } catch (NoSuchElementException ex) {
            throw new NoSimpleConstructor();
        }
    }

    public static Object[] fillParametersArray(Executable k) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Object[] values = (Object[]) Array.newInstance(Object.class,
                k.getParameterCount());
        Class<?>[] paramtypes = k.getParameterTypes();
        for (int i = 0; i < values.length; i++) {
            if (paramtypes[i] == char.class) {
                values[i] = (char) R.nextInt();

            } else {
                Array.set(values, i, randomValue(paramtypes[i]));
            }
        }
        return values;
    }

    public static int randomInt(int min, int max, boolean notNul) {
        int r = min + R.nextInt(max - min + 1);
        if (notNul) {
            while (r == 0) {
                r = min + R.nextInt(max - min + 1);
            }
        }
        return r;
    }

    public static int randomInt(int min, int max) {
        return randomInt(min, max, false);
    }

    public static Object randomValue(Class<?> c) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        if (c == void.class) {
            return null;

        } else if (c == boolean.class) {
            return R.nextBoolean();

        } else if (c == int.class
                || c == byte.class) {
            return R.nextInt();

        } else if (c == char.class) {
            return (char) R.nextInt();

        } else if (c == long.class) {
            return R.nextLong();

        } else if (c == double.class) {
            return R.nextDouble();

        } else if (c == float.class) {
            return R.nextFloat();
        } else {
            Constructor<?> k = null;
            try {
                k = c.getDeclaredConstructor();
            } catch (NoSuchMethodException | SecurityException ex1) {
                try {
                    k = c.getConstructor();
                } catch (NoSuchMethodException | SecurityException ex2) {
                    try {
                        k = getOneSimpleConstructor(c);
                    } catch (NoSimpleConstructor ex) {
                        k = getOneConstructor(c);
                    }
                }
            }
            if (k != null) {
                k.setAccessible(true);
                Object o = k.newInstance(fillParametersArray(k));
                for (Field f : c.getDeclaredFields()) {
                    if (!Modifier.isStatic(f.getModifiers())) {
                        f.setAccessible(true);
                        f.set(o, randomValue(f.getType()));
                    }
                }
                return o;

            }
            return null;
        }
    }

    public static boolean isCheckedException(Class<?> crt) {
        while (crt != Object.class) {
            if (crt == RuntimeException.class) {
                return false;
            }
            if (crt == Exception.class) {
                return true;
            }
            crt = crt.getSuperclass();
        }
        return false;
    }

    public static boolean isCheckedException(Throwable cause) {
        Class<?> crt = cause.getClass();
        while (crt != Throwable.class) {
            if (crt == RuntimeException.class) {
                return false;
            }
            crt = crt.getSuperclass();
        }
        return true;
    }

    public static boolean sameResult(StringBuilder msg, Class<?> c1, Class<?> c2, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Object o1 = ReflectUtilities.randomValue(c1);
        Object o2 = ReflectUtilities.clone(o1, c2);
        Method m1 = o1.getClass().getDeclaredMethod(methodName, parameterTypes);
        Method m2 = o2.getClass().getDeclaredMethod(methodName, parameterTypes);
        Object[] param = new Object[parameterTypes.length];
        for (int i = 0; i < param.length; ++i) {
            param[i] = randomValue(parameterTypes[i]);
        }
        Object r1 = m1.invoke(o1, param);
        Object r2 = m2.invoke(o2, param);
        msg.append(o1).append(" <> ").append(o2);
        try {
            r1.getClass().getDeclaredMethod("equals", Object.class);
            return r1.equals(r2);
        } catch (NoSuchMethodException ex) {
            return ReflectUtilities.equals(r1, r2);
        }
    }

    public static boolean sameResult(Object o1, Object o2, String methodName, Object... param) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object r1 = getFromMethod(o1.getClass(), o1, methodName, param);
        Object r2 = getFromMethod(o2.getClass(), o2, methodName, param);
        return ReflectUtilities.equals(r1, r2);
    }

    public static boolean sameResultTA(Object o1, Object o2, String methodName, Object... param) throws NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object r1 = getFromMethodTA(o1.getClass(), o1, methodName, param);
        Object r2 = getFromMethodTA(o2.getClass(), o2, methodName, param);
        return ReflectUtilities.equals(r1, r2);
    }

    static class A {

        double x;
    }

    static class B {

        double x;
    }

}
