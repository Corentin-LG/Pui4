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
    private Jeton jetonCourant; //référence	vers	le	jeton	occupant	la	cellule,	ou	null
    private boolean trouNoir; //indique	ou	non	la	présence	d’un	trou	noir
    private boolean desintegrateur ;//indique	ou	non	la	présence	d’un	désintégrateur



    //Méthodes :
    public Cellule () {//construteur	initialisant	les	attributs	avec	des	valeurs	par	défaut
        this.jetonCourant = null;
        this.trouNoir = false;
        this.desintegrateur = false;
    }
    
    public Jeton getJetonCourant(){
        return this.jetonCourant;
    }

    public void setJetonCourant(Jeton jeton){
        this.jetonCourant = jeton;
    }

    public boolean isTrouNoir(){
        return this.trouNoir;
    }

    public boolean isDesintegrateur(){
        return this.desintegrateur;
    }

    public void setTrouNoir(boolean value){
        this.trouNoir = value;
    }

    public void setDesintegrateur(boolean value){
        this.desintegrateur = value;
    }
        
    public boolean affecterJeton(Jeton jeton) {//ajoute	le	jeton	en	paramètre	à	la	cellule,	et	retourne	vrai	si	l’ajout	s’est	bien	passé,	ou	faux	sinon	(ex :	jeton	déjà	présent)
        if (this.jetonCourant != null) {
            System.out.println("jeton déjà présent");
            return false;   
        }

        else {
            this.jetonCourant = jeton;
            return true;
        }
    }

    public boolean recupererJeton() { //renvoie	une	référence	vers	le	jeton	de	la	cellule
        //créé à parti de récup désint !!!!!!!!!!!!!!!!!
        if (this.jetonCourant != null) {
            this.jetonCourant = null;
            return true;   
        }

        else {
            System.out.println("pas de jeton à récupérer");
            return false;
        }
    }

    public boolean supprimerJeton(Jeton Jeton){ //supprime	le	jeton et	renvoie	vrai	si	la	suppression	s’est	bien	passée,	ou	faux	autrement (ex :	pas	de	jeton	présent)

        if (this.jetonCourant == null) {
            System.out.println("pas de jeton présent");
            return false;   
        }

        else {
            this.jetonCourant = null;
            return true;
        }
    }



    public boolean placerTrouNoir() {//ajoute	un	trou	noir	à	l’endroit	indiqué	et	retourne	vrai	si l’ajout	s’est	 bien	passé,	ou	faux	sinon	(exemple :	trou	noir	déjà	présent)
        //le fait de ne pas mettre trouNoir en paramètre fait que les trouNoir deviennent vert
        if (! this.isTrouNoir()) { //la je teste l'attribut d'un objet de classe cellule
            System.out.println("trou noir déjà présent");
            return false;   
        }

        else {
            this.trouNoir = true; //la je modifie la valeur de mon attribut de mon objet de classe cellule
            return true;
        }
    }


    public boolean placerDesintegrateur()	{//ajoute	un	désintégrateur	à	l’endroit	indiqué	et	retourne	vrai	 si	l’ajout	s’est	bien	passé,	ou	faux	sinon	(exemple :	désintégrateur	déjà	présent)
        if (! this.isDesintegrateur()) { //la je teste l'attribut d'un objet de classe cellule
            System.out.println("désintégrateur déjà présent");
            return false;   
        }

        else {
            this.desintegrateur = true; //la je modifie la valeur de mon attribut de mon objet de classe cellule
            return true;
        }        
    }

    public String lireCouleurDuJeton() {//renvoie	la	couleur	du	jeton	occupant	la	cellule
        return this.jetonCourant.lireCouleur();
    }

    public boolean recupererDesintegrateur	 () {	 // supprime	 le	 désintégrateur	 présent	 de	 la	 cellule,	 et	 renvoie	vrai,	ou	faux	sinon	(exemple :	pas	de	désintégrateur	présent)
        if (! this.isDesintegrateur()) {
            this.desintegrateur = false;
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

        if (! this.isTrouNoir()) {
            System.out.println("brouuuuuuu !!! - le TrouNoir");
            this.jetonCourant = null;
            return true;   
        }

        else {
            System.out.println("Je sui pas là... - le TrouNoir");
            return false;
        }
    }


    @Override
    public boolean equals(Object e){
        boolean res = false;
        if ((e != null) && (e.getClass() == this.getClass())){
            Cellule j = (Cellule) e;
            if (j.getJetonCourant() == null){
            }
            else if (this.getJetonCourant() == null){
            }
            else{
                res = j.getJetonCourant().equals(this.getJetonCourant());
            }
        }
        return res;
    }

    @Override
    public String toString(){
        if (this.getJetonCourant() == null){
            return "Pas de couleur";
        }
        else{
            return this.getJetonCourant().lireCouleur();
        }
    }
}