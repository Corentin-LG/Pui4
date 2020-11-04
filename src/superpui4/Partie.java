/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superpui4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author cocol
 */
public class Partie {
    //Attributs :	
Joueur [] listeJoueurs; //tableau	des	deux	joueurs	de	la	partie
Joueur joueurCourant; //désigne	le	joueur	courant	à	tout	moment	de	la	partie
Grille grilledejeu ;    //changement par le prof 
public final static int NOMBREJETONTOTAL = 21;
//donc liste de jeton ?...

public Partie (){
    grilledejeu = new Grille ();
    listeJoueurs = new Joueur [2];
}


public void attribuerCouleursAuxJoueurs() {//attribue	des	couleurs	aux	joueurs
    
Random choix = new Random ();
int valeur;
valeur = choix.nextInt(1);
switch (valeur) {
    case 0 : listeJoueurs[0].couleur ="Rouge";
             listeJoueurs[1].couleur ="Jaune";
            break;
    case 1 : listeJoueurs[0].couleur ="Jaune";
             listeJoueurs[1].couleur ="Rouge";
            break;
    default :
        break;
        
}        

}

public void initialiserPartie() {//crée	la	grille,	la	vide	si	elle	existait	déjà,	place	les	trous	noirs	et	les desintegrateurs	
       grilledejeu.viderGrille();
       //grilledejeu.afficherGrilleSurConsole(); //débugage : ça passe
       
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Joueur 1 : ");       
       Joueur J1 = new Joueur(sc.nextLine());
       System.out.println("Joueur 2 : ");   
       Joueur J2 = new Joueur(sc.nextLine());       
       listeJoueurs[0] = J1;
       listeJoueurs[1] = J2;
       
       attribuerCouleursAuxJoueurs();
       
       for (int i = 0; i<NOMBREJETONTOTAL; i++){
          Jeton Je1 = new Jeton(listeJoueurs[0].couleur);
          Jeton Je2 = new Jeton(listeJoueurs[1].couleur);
          
          J1.ajouterJeton(Je1);
          J2.ajouterJeton(Je2);
          J1.nombreJetonsRestant++;
          J2.nombreJetonsRestant++;

      }  
  
       Random choix = new Random ();             /////ca bloque là
       for (int k= 0; k< 3; k++) {      
            grilledejeu.placerTrouNoir (choix.nextInt(Grille.MAXLIGNE),choix.nextInt(Grille.MAXCOLONNE));
                   }
       
       Random r = new Random ();           
       for (int k= 0; k< 3; k++) {    
            grilledejeu.placerDesintegrateur(r.nextInt(Grille.MAXLIGNE),r.nextInt(Grille.MAXCOLONNE));
                    }
       
       //grilledejeu.afficherGrilleSurConsole(); //jusqu'ici c top
} 

Joueur ProchainJoueur (Joueur un_joueur) {
    if (listeJoueurs[0] == joueurCourant){
        return listeJoueurs[1];
    }
    return listeJoueurs[0];
}

public void téléporteurs () {//crée	les	jetons	et	les	attribue	aux	aux	joueurs	correspondants.
 
}   

public void debuterPartie() {//lance	la	partie
    initialiserPartie();                             // initialisation de la partie, avec choix du nom des joueurs, affectation des jetons et de leur couleur.
    grilledejeu.afficherGrilleSurConsole();          // affichage de la grille de jeu, vide, avec les trous et desintegrateur.
    joueurCourant = listeJoueurs[1];                 // on initialise le joueur J2 comme etant le "premier" joueur . on pourrait ecrire "joueurCourant = listeJoueurs[listeJoueurs.length-1];"
    //System.out.println("le joueur actuel est : " + joueurCourant.nom); //validéééée
    
    while (grilledejeu.etreGagnantePourJoueur(joueurCourant) != true)  {
       joueurCourant = ProchainJoueur (joueurCourant);
       
       System.out.println("le joueur qui joue c : " + joueurCourant.nom); //ici ça marche
       
       System.out.println("Dans quelle colonne ajouter le jeton ?");
       
       
       Scanner sc = new Scanner(System.in);                 // Joueur J1 = new Joueur(sc.nextLine());
       int a = sc.nextInt();
       grilledejeu.ajouterJetonDansColonne (joueurCourant.listeJetons[joueurCourant.nombreJetonsRestant-1] , a-1); //on a dû faire -1 ici car ça voulait pas dans la méthode en question dans la classe Grille
       /*grilledejeu.ajouterJetonDansColonne (joueurCourant.listeJetons[joueurCourant.nombreJetonsRestant-1] , a);
       grilledejeu.ajouterJetonDansColonne (joueurCourant.listeJetons[joueurCourant.nombreJetonsRestant-1] , a+1);
       grilledejeu.ajouterJetonDansColonne (joueurCourant.listeJetons[joueurCourant.nombreJetonsRestant-1] , a+2);*/
       
       
       grilledejeu.afficherGrilleSurConsole();
       
       
       
       
       /* System.out.println("le joueur qui joue c : " + joueurCourant.nom);
       System.out.println("Deuxieme essaie");
       a = sc.nextInt();
       grilledejeu.ajouterJetonDansColonne (joueurCourant.listeJetons[joueurCourant.nombreJetonsRestant-1] , a-1);
       System.out.println(joueurCourant.nombreJetonsRestant);
       grilledejeu.afficherGrilleSurConsole();   
       System.out.println("le joueur qui joue c : " + joueurCourant.nom); */
        
        
    } 
    
}


}
