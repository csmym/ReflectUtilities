/*
 * @author : Yvan Maillot (yvan.maillot@uha.fr)
 */
package rf.fractions;

/**
 *
 * @author yvan
 */
// TODO La classe Fraction ne doit pas pouvoir être dérivée 
public class Fraction {

    // TODO Deux attributs entiers numérateur et dénominateur (la classe doit être immuable)

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

 

    /* TODO Un constructeur à un paramètre entier pour le numérateur, le 
    dénominateur étant considéré égal à 1.
    
    Quelques exemples :
    
    new Fraction(1) => 1/1
    new Fraction(-4) => -4/1
    new Fraction(0) => 0/1
    
    */   


    // TODO Le constructeur par défaut qui crée la fraction 0/1

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

    // TODO La méthode d'instance inverse() qui retourne l'inverse de cette fraction 

    // TODO La méthode d'instance plus(Fraction f) qui retourne cette fraction + f

    // TODO La méthode d'instance fois(Fraction f) qui retourne cette fraction * f

    // TODO La méthode d'instance moins(Fraction f) qui retourne cette fraction - f

    // TODO La méthode d'instance diviséPar(Fraction f) qui retourne cette fraction / f

}
