/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package main;

import checker.Checker;

/**
 *
 * @author yvan
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("// ---- Point -----");
        System.out.println(new Checker(cf.geom.Point.class));
        System.out.println("// ---- Segment -----");
        System.out.println(new Checker(cf.geom.Segment.class));
        System.out.println("// ---- Triangle -----");
        System.out.println(new Checker(cf.geom.Triangle.class));
    }
}
