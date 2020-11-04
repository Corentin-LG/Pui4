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

public class Grille {
    private Cellule [][] grille;
    final static int MAXLIGNE = 6;
    final static int MAXCOLONNE = 7;
    
    public Grille (){
        // matrice de 6 lignes et 7 colonnes
        this.grille = new Cellule [MAXLIGNE][MAXCOLONNE];
         for (int i = 0; i < MAXLIGNE; i++){
             for (int j = 0; j < MAXCOLONNE; j++){
                 this.grille[i][j] = new Cellule();
             }
         }
    }


    //je propose grille = new matrice()


    //Méthodes    
    
    public boolean ajouterJetonDansColonne(Jeton Jeton,int num_colonne) {// ajoute	 le	 jeton	 dans	 la	 colonne	 ciblée,	 sur	 la	 cellule	vide	la	plus	basse. Renvoie	faux	si	la	colonne	était	pleine.
        int i=0;
        
        for (i=MAXLIGNE-1; i>=0; i--) {
            // Integer lil = i;
            // Integer lol = num_colonne;
            // System.out.println(lil.toString()+","+lol.toString());
            if (this.getCellule(i, num_colonne).getJetonCourant() == null) {
                this.getCellule(i, num_colonne).setJetonCourant(Jeton); // Grille [i][7] est de classe cellule
            return true;
            }
        }
        System.out.println("la colonne était pleine");
        return false;
    }


    public boolean etreRemplie() { //renvoie	vrai	si	la	grille	est	pleine
        boolean rep = true;

        int i=0;
        int j=0;
        while (j<MAXCOLONNE) {
            while (i<MAXLIGNE) {
                if (this.getCellule(i, j).getJetonCourant() == null) {
                    rep = false;
                }
                i++;                
            }
            i=0;
            j++;
        }
        return rep;
    }


    public void viderGrille() {//vide	la	grille
        int i=0;
        int j=0;
        while (j<MAXCOLONNE) {
            while (i<MAXLIGNE) {
                this.setCellule(i, j,new Cellule());
                i++;
            }
            i=0;
            j++;
        }
    }


    public void afficherGrilleSurConsole() {//fonction d’affichage de la grille sur	la	console. Doit faire apparaitre les couleurs, et les trous noirs.

        for (int i=0; i < MAXLIGNE; i++) { //à rappeler que la ligne du haut de la grille est de coordonées i=0
            for (int j =0;j < MAXCOLONNE; j++){
                if (this.getCellule(i, j).getJetonCourant() != null)
                {
                    System.out.print(this.lireCouleurDuJeton(i, j).substring(0,1));
                }
                else if (! this.getCellule(i, j).isTrouNoir()){
                    System.out.print("X");
                }
                else if (! this.getCellule(i, j).isDesintegrateur()){
                    System.out.print("$");
                }
                else 
                {
                System.out.print("O");
                }
            }
        System.out.println("\n");  
        }
    }


    public Cellule getCellule(int i, int j){
        return this.grille[i][j];
    }


    public void setCellule(int i, int j, Cellule value){
        this.grille[i][j] = value;
    }


    public boolean celluleOccupee(int num_ligne, int num_colonne)	{//renvoie	vrai	si	la	cellule	de	coordonnées	données	est	occupée	 par	un	jeton.
        return this.getCellule(num_ligne,num_colonne).getJetonCourant() != null;
    }


    public String lireCouleurDuJeton(int num_ligne, int num_colonne) {//renvoie	la	couleur	du	jeton	de	la	cellule	ciblée.
        if (this.getCellule(num_ligne,num_colonne).getJetonCourant() != null) {
            return this.getCellule(num_ligne,num_colonne).getJetonCourant().lireCouleur();
        }
        return null;
    }


    public boolean etreGagne() {//renvoie vrai si la grille est gagnante,c’est-à-dire que 4	pions de meme couleur sont alignés en ligne, en colonne	ou en diagonale.
        boolean lig = verifierLignes();
        System.out.println("lig "+lig);
        boolean col = verifierColonnes();
        System.out.println("col "+col);
        boolean d1 = verifierD1();
        System.out.println("d1 "+d1);
        boolean d2 = verifierD2();
        System.out.println("d2 "+d2);
        return lig || col || d1 || d2;
    }


        private  boolean verifierLignes (){
        int horszone = 0;
        int compteur = 0;
        for(int num_ligne =0; num_ligne<MAXLIGNE;num_ligne++){
            for(int num_colonne =0; num_colonne<MAXCOLONNE;num_colonne++){ //si -1 alors n'atteint jamais max colonne-1
                if (this.lireCouleurDuJeton(num_ligne,num_colonne) != null){ //si la cellule trouvée à un jeton non nul
                    for (int k=1; k <4 ; k++ ){ //déplacement de 1 à 3 vers la gauche
                        horszone = num_colonne + k; //condition limite
                        if (horszone < MAXCOLONNE) { 
                           /* if (num_colonne==MAXCOLONNE-1){
                System.out.println(this.lireCouleurDuJeton(num_ligne,num_colonne));
                }
                else {
                    System.out.print(this.lireCouleurDuJeton(num_ligne,num_colonne));
                }*/
                            if (this.lireCouleurDuJeton(num_ligne,num_colonne+k) != null && this.lireCouleurDuJeton(num_ligne,num_colonne+k).equals(this.lireCouleurDuJeton(num_ligne,num_colonne))) {
                                compteur ++;
                                //System.out.println("Notre merveilleux compteur dit : "+compteur);
                                if (compteur == 3) {
                                        return true;
                                    }
                                }                  
                            else {
                                compteur = 0;
                                //System.out.println("break compteur 0");
                                break; //casser horszone puis for k car 1 des jetons de la même ligne est différent ou null 
                                }
                        } //condition de horzone
                        else {
                            compteur = 0;//mega important, si horszone non respecté il faut arrêter le compteur
                            //System.out.println("break xhiiiiiiiii");
                            break; //casser for k car condition non respecté
                        }
                    }
                }
            }
        }
    return false; //si tout est cassé à chaques cellule des 42 du tableau
    }

    private boolean verifierColonnes (){
        int horszone = 0;
        int compteur = 0;
        for(int num_colonne =0; num_colonne<MAXCOLONNE;num_colonne++){
            for(int num_ligne =0; num_ligne<MAXLIGNE;num_ligne++){ //r
                if (this.lireCouleurDuJeton(num_ligne,num_colonne) != null){ //si la cellule trouvée à un jeton non nul
                    for (int k=1; k <4 ; k++ ){ //déplacement de 1 à 3 vers la gauche
                        horszone = num_ligne + k; //condition limite
                        if (horszone < MAXLIGNE) { 
                          /*  if (num_ligne==MAXLIGNE-1){
               System.out.println(this.lireCouleurDuJeton(num_ligne,num_colonne));
                }
                else {
                    System.out.print(this.lireCouleurDuJeton(num_ligne,num_colonne));
                }*/
                            if (this.lireCouleurDuJeton(num_ligne+k,num_colonne) != null && this.lireCouleurDuJeton(num_ligne+k,num_colonne).equals(this.lireCouleurDuJeton(num_ligne,num_colonne))) {
                                compteur ++;
                                //System.out.println("Notre merveilleux compteur dit : "+compteur);
                                if (compteur == 3) {
                                        return true;
                                    }
                                }                  
                            else {
                                compteur = 0;
                                //System.out.println("break compteur 0");
                                break; //casser horszone puis for k car 1 des jetons de la même ligne est différent ou null 
                                }
                        }
                        else {
                            compteur = 0;
                            //System.out.println("break xhiiiiiiiii");
                            break; //casser for k car condition non respecté
                        }
                    }
                }
            }
        }
    return false; //si tout est cassé à chaques cellule des 42 du tableau
    }
    
    private boolean verifierD1(){
        int horszoneL = 0;
        int horszoneC = 0;
        int compteur = 0;
        for(int num_colonne =0; num_colonne<MAXCOLONNE;num_colonne++){
            for(int num_ligne =0; num_ligne<MAXLIGNE;num_ligne++){ //r
                if (this.lireCouleurDuJeton(num_ligne,num_colonne) != null){ //si la cellule trouvée à un jeton non nul
                    for (int k=1; k <4 ; k++ ){ //déplacement de 1 à 3 vers la gauche
                        horszoneL = num_ligne - k;
                        horszoneC = num_colonne + k;
                        //System.out.println("c'est le jeton : "+this.lireCouleurDuJeton(num_ligne,num_colonne)+" de ligne "+(num_ligne+1)+" et de colonne "+(num_colonne+1));
                        //ligne du dessus la best pour voir le repère de la grille
                        if (horszoneL < MAXLIGNE  && horszoneC < MAXCOLONNE) {
                            if (this.lireCouleurDuJeton(num_ligne-k,num_colonne+k) != null && this.lireCouleurDuJeton(num_ligne-k,num_colonne+k).equals(this.lireCouleurDuJeton(num_ligne,num_colonne))) {
                                compteur ++;
                                //System.out.println("Notre merveilleux compteur dit : "+compteur);
                                if (compteur == 3) {
                                        return true;
                                    }
                                }                 
                            else {
                                compteur = 0;
                                //System.out.println("break compteur ☺");
                                break; 
                                }
                        }
                        else {
                            compteur = 0;
                            //System.out.println("break xhiiiiiiiii");
                            break; //casser for k car condition non respecté
                        }
                    }
                }
            }
        }
    return false; //si tout est cassé à chaques cellule des 42 du tableau
    }

    private boolean verifierD2(){
        int horszoneL = 0;
        int horszoneC = 0;
        int compteur = 0;
        for(int num_colonne =0; num_colonne<MAXCOLONNE;num_colonne++){
            for(int num_ligne =0; num_ligne<MAXLIGNE;num_ligne++){ //r
                if (this.lireCouleurDuJeton(num_ligne,num_colonne) != null){
                    for (int k=1; k <4 ; k++ ){
                        horszoneL = num_ligne - k;
                        horszoneC = num_colonne - k;
                        System.out.println("c'est le jeton : "+this.lireCouleurDuJeton(num_ligne,num_colonne)+" de ligne "+(num_ligne+1)+" et de colonne "+(num_colonne+1));
                        if (0<horszoneL && horszoneL< MAXLIGNE  && 0<horszoneC && horszoneC<MAXCOLONNE ) {
                            if (this.lireCouleurDuJeton(num_ligne-k,num_colonne-k) != null && this.lireCouleurDuJeton(num_ligne-k,num_colonne-k).equals(this.lireCouleurDuJeton(num_ligne,num_colonne))) {
                                compteur ++;
                                System.out.println("Notre merveilleux compteur dit : "+compteur);
                                if (compteur == 3) {
                                        return true;
                                    }
                                }                 
                            else {
                                compteur = 0;
                                System.out.println("break compteur ☺");
                                break; 
                                }
                        }
                        else {
                            compteur = 0;
                            System.out.println("break xhiiiiiiiii");
                            break;
                        }
                    }
                }
            }
        }
    return false;
    }


    public void tasserGrille(int num_ligne,int num_colonne) {//lorsqu’un	jeton	est	capturé	ou	détruit,	tasse	la	grille	en	décalant	de	 une	ligne	les	jetons	situés	au	dessus	de	la	cellule	libérée.
        for (int i=0; i < MAXLIGNE; i++) {
            for (int j =0;j < MAXCOLONNE; j++){
                if (this.getCellule(num_ligne,num_colonne).getJetonCourant() == null && this.getCellule(num_ligne,num_colonne+1).getJetonCourant() != null) {
                    this.getCellule(num_ligne,num_colonne).setJetonCourant(this.getCellule(num_ligne,num_colonne+1).getJetonCourant());
                    this.getCellule(num_ligne,num_colonne+1).setJetonCourant(null);
                }
            }
        }
    }


    public boolean colonneRemplie (int num_colonne ){//!!!!! ajouter un paramètre oublié !!!!! renvoie	vrai	si	la	colonne	est	remplie	(on	ne	peut	y	jouer	un	Jeton)
        if (this.getCellule(0,num_colonne).getJetonCourant() != null) {//revoir codage ligne
            //revoir s'il faut scanner toute la colonne
            return true;
        }
        else {
            return false;
        }    
    }


    public boolean placerTrouNoir(int num_ligne, int num_colonne){//ajoute	 un	 trou	 noir	 à	 l’endroit	 indiqué	 et	 retourne	 vrai	 si	 l’ajout	s’est	bien	passé,	ou	faux	sinon	(exemple :	trou	noir	déjà	présent)
        if (this.getCellule(num_ligne,num_colonne).isTrouNoir() != false){
            System.out.println("Il n'y a de place que pour un seul Trou Noir - le TrouNoir ");
            return false;
        }
        else {
            this.getCellule(num_ligne,num_colonne).setTrouNoir(true);  //à changer si plusieurs éléments sur la même case impossible  
            return true;
        }
    }

    public boolean placerDesintegrateur(int num_ligne, int num_colonne){//ajoute	un	désintégrateur	à	l’endroit	indiqué	et	retourne	 vrai	si	l’ajout	s’est	bien	passé,	ou	faux	sinon	(exemple :	désintégrateur	déjà	présent)

        if (this.getCellule(num_ligne,num_colonne).isDesintegrateur() != false){
            System.out.println("Il n'y a de place que pour un seul Désingueur - le Désingueur ");
            return false;
        }
        else {
            this.getCellule(num_ligne,num_colonne).setDesintegrateur(true);  //à changer si plusieurs éléments sur la même case impossible  
            return true;
        }
    }


    public boolean suppression (int num_ligne, int num_colonne) {//	supprime	 le	 jeton	 de	 la	 cellule	 visée.	 Renvoie	 vrai	 si	 la	 suppression	s’est	bien	déroulée,	ou	faux	autrement	(jeton	absent)
        if (this.getCellule(num_ligne,num_colonne).getJetonCourant() != null){
            this.getCellule(num_ligne,num_colonne).setJetonCourant(null);
            System.out.println("Suppression de jeton réuissi");
            return true;
        }
        else {
            return false;
        }  
    }
}



// public Jeton recupererJeton(int num_ligne, int num_colonne) {//enlève	le	jeton	de	la	cellule	visée	et	renvoie	une	référence	vers	ce	jeton.
// //je c pas encore à quoi ça va servir
// //encours d'élaboration

// // Jeton qqc = null; //pour sauvergarder le jeton.courant de la celulle en question
// // qqc = Grille .getCe