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
    Cellule [][] Grille;
    final static int MAXLIGNE = 6;
    final static int MAXCOLONNE = 7;
    final static int QUATUORGAGNANT = 5;
    
    public Grille (){
    Grille = new Cellule [MAXLIGNE][MAXCOLONNE];
}
    //plein de fautes
    //se mettre d'accord de comment est codé num_colonne 0à6 ou 1à7
    //pareil pour les lignes
    
    
    //je propose   Grille = new Cellule [abscisse][ordonnee]
    
    
    
    
    //Méthodes
    
    
public boolean ajouterJetonDansColonne(Jeton Jeton,int num_colonne) {// ajoute	 le	 jeton	 dans	 la	 colonne	 ciblée,	 sur	 la	 cellule	vide	la	plus	basse. Renvoie	faux	si	la	colonne	était	pleine.
int i=0;
boolean rep =false; //ne jamais oublier d'int à false
    for (i=MAXLIGNE-1; i>0; i--) {
        if (Grille [i][num_colonne].jetonCourant == null) {
           Grille [i][num_colonne].jetonCourant = Jeton; // Grille [i][7] est de classe cellule
           // au besoin pour forcer l'arre^t de la boucle i=num_colonne;
           rep = true;
           break;
        }
    }
    if (i == 0){
        System.out.println("la colonne était pleine");
        rep = false;
    }
    return rep;
}







public boolean etreRemplie() { //renvoie	vrai	si	la	grille	est	pleine
boolean rep = true;

int i=0;
int j=0;
while (j<MAXCOLONNE) {
    while (i<MAXLIGNE) {
 
        if (Grille [i][j].jetonCourant == null) {
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
        Grille [i][j] = new Cellule();
        i++;
        
        }
    i=0;
    j++;
}
}



public void afficherGrilleSurConsole() {//fonction d’affichage de la grille sur	la	console.	Doit	 faire apparaitre	les	couleurs,	et	les	trous	noirs.
    
    Cellule rep;
    for (int i=0; i < MAXLIGNE; i++) { //à rappeler que la ligne du haut de la grille est de coordonées i=0
        for (int j =0;j < MAXCOLONNE; j++)
        {
         
         if (Grille [i][j].jetonCourant != null)
         {
           System.out.print(Grille [i][j].jetonCourant.couleur.substring(0,1));
           
         }
         else if (Grille [i][j].trouNoir != false)
         {
             System.out.print("X");
             
         }
         else if (Grille [i][j].desintegrateur != false)
         {
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



public boolean celluleOccupee(int num_ligne, int num_colonne)	{//renvoie	vrai	si	la	cellule	de	coordonnées	données	est	occupée	 par	un	jeton.
    boolean rep = false;
    if (Grille [num_ligne][num_colonne].jetonCourant != null) {
    rep = true;
    }
    return rep;
}



public String lireCouleurDuJeton(int num_ligne, int num_colonne) {//renvoie	la	couleur	du	jeton	de	la	cellule	ciblée.
    String rep = null;
    if (Grille [num_ligne][num_colonne].jetonCourant != null) {
    rep = Grille [num_ligne][num_colonne].jetonCourant.couleur;
    }
    return rep;    
}


public boolean etreGagnantePourJoueur(Joueur J1) {//renvoie vrai si la grille est gagnante	pour le joueue passé en paramètre,c’est-à-dire	 que	 4	 pions	 de	 sa	 couleur	 sont	 alignés	 en	 ligne,	 en	 colonne	ou	en	diagonale.
    boolean rep = false;  
    for (int i=0; i < MAXLIGNE; i++) { 
        for (int j =0;j < MAXCOLONNE-QUATUORGAGNANT; j++){    
             if (verifierLaLigne(i, j) ||verifierLaColonne(i, j) || verifierD1(i, j) || verifierD2(i, j) ){
        rep = true;
        System.out.println("Gangnééééééééééééééé");
      }
        }
            }
    return rep;    
}




private  boolean verifierLaLigne (int num_ligne , int num_colonne){
    boolean Lrep = true ;   
   
            for (int k=0; k<QUATUORGAGNANT && 0<(num_ligne+k) && (num_ligne+k)<MAXLIGNE && 0<(num_colonne) && (num_colonne)<MAXCOLONNE ; k++){
                 if (Grille [num_ligne][num_colonne].jetonCourant != Grille [num_ligne+k][num_colonne].jetonCourant && Grille [num_ligne][num_colonne].jetonCourant!= null) { 
                 Lrep = false; //changement 170 == en != donc 167 171 !=
            }    
                 if (Grille [num_ligne][num_colonne].jetonCourant == null){ 
                 Lrep = false;
            }
        }
       return Lrep;  
    }

private boolean verifierLaColonne (int num_ligne , int num_colonne){
    boolean Crep = true ;   
   
    for (int k=0; k<QUATUORGAGNANT && 0<(num_ligne) && (num_ligne)<MAXLIGNE && 0<(num_colonne+k) && (num_colonne+k)<MAXCOLONNE ; k++){
        if (Grille [num_ligne][num_colonne].jetonCourant != Grille [num_ligne][num_colonne+k].jetonCourant && Grille [num_ligne][num_colonne].jetonCourant != null){ 
           Crep = false;
        }
        if (Grille [num_ligne][num_colonne].jetonCourant == null){ 
                 Crep = false;
            }
      }      
       return Crep;  
    }

private boolean verifierD1 (int num_ligne , int num_colonne){
    boolean D1rep = true ;   
   
    for (int k=0; k<QUATUORGAGNANT && 0<(num_ligne+k) && (num_ligne+k)<MAXLIGNE && 0<(num_colonne+k) && (num_colonne+k)<MAXCOLONNE ; k++){
        if (Grille [num_ligne][num_colonne].jetonCourant != Grille [num_ligne+k][num_colonne+k].jetonCourant && Grille [num_ligne][num_colonne].jetonCourant!= null){ 
           D1rep = false;
        }
        if (Grille [num_ligne][num_colonne].jetonCourant == null){ 
                 D1rep = false;
            }
      }      
       return D1rep;  
    }

private boolean verifierD2 (int num_ligne , int num_colonne){
    boolean D2rep = true ;   
   
    for (int k = 0; k<QUATUORGAGNANT && 0<(num_ligne-k) && (num_ligne-k)<MAXLIGNE && 0<(num_colonne+k) && (num_colonne+k)<MAXCOLONNE ; k++){
        if (Grille [num_ligne][num_colonne].jetonCourant != Grille [num_ligne-k][num_colonne+k].jetonCourant && Grille [num_ligne][num_colonne].jetonCourant!= null){ 
           D2rep = false;
        }
        if (Grille [num_ligne][num_colonne].jetonCourant == null){ 
                 D2rep = false;
            }
      }      
       return D2rep;  
    }



public void tasserGrille(int num_ligne,int num_colonne) {//lorsqu’un	jeton	est	capturé	ou	détruit,	tasse	la	grille	en	décalant	de	 une	ligne	les	jetons	situés	au	dessus	de	la	cellule	libérée.
    for (int i=0; i < MAXLIGNE; i++) {
        for (int j =0;j < MAXCOLONNE; j++){
        if (Grille [num_ligne][num_colonne].jetonCourant == null && Grille [num_ligne][num_colonne+1].jetonCourant != null) {
         Grille [num_ligne][num_colonne].jetonCourant = Grille [num_ligne][num_colonne+1].jetonCourant;
         Grille [num_ligne][num_colonne+1].jetonCourant = null;
        }
        }
    }
}


public boolean colonneRemplie (int num_colonne ){//!!!!! ajouter un paramètre oublié !!!!! renvoie	vrai	si	la	colonne	est	remplie	(on	ne	peut	y	jouer	un	Jeton)
    if (Grille [0][num_colonne].jetonCourant != null) {//revoir codage ligne
        //revoir s'il faut scanner toute la colonne
        return true;
    }
    else {
        return false;
    }    
}


public boolean placerTrouNoir(int num_ligne, int num_colonne){//ajoute	 un	 trou	 noir	 à	 l’endroit	 indiqué	 et	 retourne	 vrai	 si	 l’ajout	s’est	bien	passé,	ou	faux	sinon	(exemple :	trou	noir	déjà	présent)
    if (Grille [num_ligne][num_colonne].trouNoir != false){
        System.out.println("Il n'y a de place que pour un seul Trou Noir - le TrouNoir ");
        return false;
    }
    else {
    Grille [num_ligne][num_colonne].trouNoir = true;  //à changer si plusieurs éléments sur la même case impossible  
    return true;
    }
}

public boolean placerDesintegrateur(int num_ligne, int num_colonne){//ajoute	un	désintégrateur	à	l’endroit	indiqué	et	retourne	 vrai	si	l’ajout	s’est	bien	passé,	ou	faux	sinon	(exemple :	désintégrateur	déjà	présent)

    if (Grille [num_ligne][num_colonne].desintegrateur != false){
        System.out.println("Il n'y a de place que pour un seul Désingueur - le Désingueur ");
        return false;
    }
    else {
    Grille [num_ligne][num_colonne].desintegrateur = true;  //à changer si plusieurs éléments sur la même case impossible  
    return true;
    }
}



public boolean suppression (int num_ligne, int num_colonne) {//	supprime	 le	 jeton	 de	 la	 cellule	 visée.	 Renvoie	 vrai	 si	 la	 suppression	s’est	bien	déroulée,	ou	faux	autrement	(jeton	absent)
    if (Grille [num_ligne][num_colonne].jetonCourant != null){
        Grille [num_ligne][num_colonne].jetonCourant = null;
        System.out.println("Suppression de jeton réuissi");
        return true;
    }
    else {
    return false;
    }   
}



public Jeton recupererJeton(int num_ligne, int num_colonne) {//enlève	le	jeton	de	la	cellule	visée	et	renvoie	une	référence	vers	ce	jeton.
//je c pas encore à quoi ça va servir
//encours d'élaboration

Jeton qqc = null; //pour sauvergarder le jeton.courant de la celulle en question
qqc = Grille [num_ligne][num_colonne].jetonCourant; //au pire ce sera null

suppression ( num_ligne,  num_colonne);
return qqc;

//sujet à débat

/*
if (Grille [num_ligne][num_colonne].jetonCourant != null){
        Joueur.ajouterJeton.jetonCourant;
}
    return Grille [num_ligne][num_colonne].jetonCourant;   */
}
    
    
 
    
}