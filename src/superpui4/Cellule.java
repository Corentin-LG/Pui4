/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpui4;

/**
 *
 * @author cocol
 */
public class Cellule {
    //Attributs :	
Jeton jetonCourant; //référence	vers	le	jeton	occupant	la	cellule,	ou	null
boolean trouNoir; //indique	ou	non	la	présence	d’un	trou	noir
boolean desintegrateur ;//indique	ou	non	la	présence	d’un	désintégrateur



     //Méthodes :
public Cellule () {//construteur	initialisant	les	attributs	avec	des	valeurs	par	défaut
 jetonCourant = null;
 trouNoir = false;
 desintegrateur = false;
 
 
}    
    
    
    
    
    
    
public boolean affecterJeton(Jeton Jeton) {//ajoute	le	jeton	en	paramètre	à	la	cellule,	et	retourne	vrai	si	l’ajout	s’est	bien	passé,	ou	faux	sinon	(ex :	jeton	déjà	présent)
if (jetonCourant != null) {
    System.out.println("jeton déjà présent");
    return false;   
}

else {
    jetonCourant = Jeton;
    return true;
}
}



public boolean recupererJeton() { //renvoie	une	référence	vers	le	jeton	de	la	cellule
//créé à parti de récup désint !!!!!!!!!!!!!!!!!
if (jetonCourant != null) {
    jetonCourant = null;
    return true;   
}

else {
    System.out.println("pas de jeton à récupérer");
    return false;
}
       
}




public boolean supprimerJeton(Jeton Jeton){ //supprime	le	jeton et	renvoie	vrai	si	la	suppression	s’est	bien	passée,	ou	faux	autrement (ex :	pas	de	jeton	présent)

if (jetonCourant == null) {
    System.out.println("pas de jeton présent");
    return false;   
}

else {
    jetonCourant = null;
    return true;
}
}



public boolean placerTrouNoir() {//ajoute	un	trou	noir	à	l’endroit	indiqué	et	retourne	vrai	si l’ajout	s’est	 bien	passé,	ou	faux	sinon	(exemple :	trou	noir	déjà	présent)
//le fait de ne pas mettre trouNoir en paramètre fait que les trouNoir deviennent vert
if (trouNoir != false) { //la je teste l'attribut d'un objet de classe cellule
    System.out.println("trou noir déjà présent");
    return false;   
}

else {
    trouNoir = true; //la je modifie la valeur de mon attribut de mon objet de classe cellule
    return true;
}

}


public boolean placerDesintegrateur()	{//ajoute	un	désintégrateur	à	l’endroit	indiqué	et	retourne	vrai	 si	l’ajout	s’est	bien	passé,	ou	faux	sinon	(exemple :	désintégrateur	déjà	présent)
if (desintegrateur != false) { //la je teste l'attribut d'un objet de classe cellule
    System.out.println("désintégrateur déjà présent");
    return false;   
}

else {
    desintegrateur = true; //la je modifie la valeur de mon attribut de mon objet de classe cellule
    return true;
}
    
}    
    
    
    
    
public boolean presenceTrouNoir() {//renvoie	vrai	si	un	trou	noir	est	présent	sur	la	cellule

if (trouNoir != false) {
    System.out.println("je suis là - le TrouNoir");
    return false;   
}

else {
    return true;
}
}



public boolean presenceDesintegrateur()	{//renvoie	vrai	si	un	desintégrateur	est	présent	sur	la	cellule
if (desintegrateur != false) {
    System.out.println("je suis là - le desintegrateur");
    return false;   
}

else {
    return true;
}
}



public String lireCouleurDuJeton() {//renvoie	la	couleur	du	jeton	occupant	la	cellule
return jetonCourant.couleur;
}

public boolean recupererDesintegrateur	 () {	 // supprime	 le	 désintégrateur	 présent	 de	 la	 cellule,	 et	 renvoie	vrai,	ou	faux	sinon	(exemple :	pas	de	désintégrateur	présent)
if (desintegrateur != false) {
    desintegrateur = false;
    return true;   
}

else {
    System.out.println("pas de désintégrateur à récupérer");
    return false;
}
}

public boolean activerTrouNoir() {
//active	 le	 trou	 noir :	 le	trou	 noir	 engloutit	 le	 jeton	 et	 disparait.
    //Retourne	vrai	si	tout	s’est	correctement	déroulé,	ou	faux	sinon	(pas	de	trou	noir)

if (trouNoir != false) {
    System.out.println("brouuuuuuu !!! - le TrouNoir");
    jetonCourant = null;
    return true;   
}

else {
        System.out.println("Je sui pas là... - le TrouNoir");
    return false;
}
}




}