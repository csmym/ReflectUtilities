/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package ec.fractions;

import cf.exceptions.SituationImpossible;
import ec.exceptions.DivisionParUneFractionNulle;
import ec.exceptions.DénominateurNul;
import ec.exceptions.InversionFractionNulle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yvan
 */
// TODO La classe Fraction ne doit pas pouvoir être dérivée 
public final class Fraction {

    // TODO Deux attributs entiers numérateur et dénominateur (la classe doit être immuable)
    public final int numérateur, dénominateur;

    // Méthode qui calcule le plus grand diviseur commun à a et b
    private static int pgcd(int a, int b) {
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    // Méthode qui calcule le plus petit multiple commun à a et b
    private static int ppcm(int a, int b) {
        return (a * b) / pgcd(a, b);
    }

    /* TODO Un constructeur à deux paramètres entiers pour le numérateur et le 
    dénominateur. Attention, la fraction doit être réduite mais également 
    l'éventuel signe négatif doit être au numérateur.
    
    Quelques exemples :
    new Fraction(1, 2) => 1/2
    new Fraction(2, 4) => 1/2 (aussi)
    new Fraction(-1, 2) => -1/2
    new Fraction(1, -2) => -1/2
    new Fraction(1, 0) lance une exception DénominateurNul
     */
    public Fraction(int numérateur, int dénominateur) throws DénominateurNul {
        if (dénominateur == 0) {
            throw new DénominateurNul();
        }
        int pgcd = pgcd(numérateur, dénominateur);
        numérateur /= pgcd;
        dénominateur /= pgcd;
        if (dénominateur < 0) {
            numérateur = -numérateur;
            dénominateur = -dénominateur;
        }
        this.numérateur = numérateur;
        this.dénominateur = dénominateur;
    }

    /* TODO Un constructeur à un paramètre entier pour le numérateur, le 
    dénominateur étant considéré égal à 1.
    
    Quelques exemples :
    
    new Fraction(1) => 1/1
    new Fraction(-4) => -4/1
    new Fraction(0) => 0/1
    
     */
    public Fraction(int numérateur) {
        this.numérateur = numérateur;
        this.dénominateur = 1;
    }

    // TODO Le constructeur par défaut qui crée la fraction 0/1
    public Fraction() {
        this(0);
    }

    public void affiche() {
        /* TODO Afficher la fraction sur la sortie standard de la façon suivante :
        <numérateur>/<dénominateur>
        Il faut traiter les cas particuliers si le numérateur est égal à 1 ou
        le numérateur est égal à 0.
        Quelques exemples :
        new Fraction(1, 2).afficher() => 1/2
        new Fraction(2, 4).afficher() => 1/2
        new Fraction(-1, 2).afficher() => -1/2
        new Fraction(1, -2).afficher() => -1/2
        new Fraction(1).afficher() => 1
        new Fraction(-4).afficher() => -4
        new Fraction(0).afficher() => 0
         */
        if (numérateur == 0 || dénominateur == 1) {
            System.out.print(numérateur);
        } else {
            System.out.print(numérateur + "/" + dénominateur);
        }
    }

    /*
    Attention, cet exercice est plus compliqué qu'il n'y parait. Il ne
    s'agit pas simplement d'écrire l'addition entre deux fractions (par exemple).
    Ça, je sais que vous savez le faire.
    Non, le but de l'exercice est de bien réfléchir au traitement des exceptions.
    Il faut, selon les cas, appliquer l'une des trois stratégies de gestion des
    exceptions vues en cours.
    Pour répondre correctement à cette problématique, il faut vous mettre à
    la place d'un développeur (autre que vous) qui utiliserait votre classe
    Fraction. Comment jugerait-il l'exception lancer ? Est-elle pertinente ?
     */
    // TODO La méthode d'instance opposé() qui retourne l'opposé de cette fraction
    public Fraction opposé() {
        try {
            return new Fraction(-numérateur, dénominateur);
        } catch (DénominateurNul ex) {
            throw new IllegalStateException();
        }
    }

    // TODO La méthode d'instance inverse() qui retourne l'inverse de cette fraction
    public Fraction inverse() throws InversionFractionNulle {
        try {
            return new Fraction(dénominateur, numérateur);
        } catch (DénominateurNul ex) {
            throw new InversionFractionNulle();
        }
    }

    // TODO La méthode d'instance plus(Fraction f) qui retourne cette fraction + f
    public Fraction plus(Fraction fraction) {
        int ppcm = ppcm(dénominateur, fraction.dénominateur);
        try {
            return new Fraction(numérateur * ppcm / dénominateur + fraction.numérateur * ppcm / fraction.dénominateur, ppcm);
        } catch (DénominateurNul ex) {
            throw new SituationImpossible();
        }
    }

    // TODO La méthode d'instance fois(Fraction f) qui retourne cette fraction * f
    public Fraction fois(Fraction fraction) {
        try {
            return new Fraction(numérateur * fraction.numérateur, dénominateur * fraction.dénominateur);
        } catch (DénominateurNul ex) {
            throw new IllegalStateException();
        }
    }
    // TODO La méthode d'instance moins(Fraction f) qui retourne cette fraction - f
    public Fraction moins(Fraction fraction) {
        return this.plus(fraction.opposé());
    }
    // TODO La méthode d'instance diviséPar(Fraction f) qui retourne cette fraction / f
    public Fraction diviséPar(Fraction fraction) throws DivisionParUneFractionNulle {
        try {
            return this.fois(fraction.inverse());
        } catch (InversionFractionNulle ex) {
            throw new DivisionParUneFractionNulle();
        }
    }
}
