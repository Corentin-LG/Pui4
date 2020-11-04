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
    private Joueur [] listeJoueurs; //tableau	des	deux	joueurs	de	la	partie
    private Joueur joueurCourant; //désigne	le	joueur	courant	à	tout	moment	de	la	partie
    private Grille grilledejeu ;    //changement par le prof 
    public final static int NOMBREJETONTOTAL = 21;
    //donc liste de jeton ?...

    public Partie (){
        this.grilledejeu = new Grille ();
        this.listeJoueurs = new Joueur [2];
    }


    public void attribuerCouleursAuxJoueurs() {//attribue	des	couleurs	aux	joueurs
        
        Random choix = new Random ();
        int valeur = choix.nextInt(1);
        switch (valeur) {
            case 0 : this.listeJoueurs[0].affecterCouleur("Rouge");
                    this.listeJoueurs[1].affecterCouleur("Jaune");
                    break;
            case 1 : this.listeJoueurs[0].affecterCouleur("Jaune");
                    this.listeJoueurs[1].affecterCouleur("Rouge");
                    break;
            default :
                break;
        }        
    }

    public void initialiserPartie() {//crée	la	grille,	la	vide	si	elle	existait	déjà,	place	les	trous	noirs	et	les desintegrateurs	
        this.grilledejeu.viderGrille();
        //grilledejeu.afficherGrilleSurConsole(); //débugage : ça passe
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Joueur 1 : ");       
        Joueur J1 = new Joueur(sc.nextLine());
        System.out.println("Joueur 2 : ");   
        Joueur J2 = new Joueur(sc.nextLine());       
        this.listeJoueurs[0] = J1;
        this.listeJoueurs[1] = J2;
        
        attribuerCouleursAuxJoueurs();
        
        for (int i = 0; i<NOMBREJETONTOTAL; i++){
            Jeton Je1 = new Jeton(listeJoueurs[0].getCouleur());
            Jeton Je2 = new Jeton(listeJoueurs[1].getCouleur());
            
            J1.ajouterJeton(Je1);
            J2.ajouterJeton(Je2);
            J1.incrementationNbJetonsRestant();
            J2.incrementationNbJetonsRestant();
        }
    
        // Random choix = new Random ();             /////ca bloque là
        // for (int k= 0; k< 3; k++) {      
        //     this.grilledejeu.placerTrouNoir(choix.nextInt(Grille.MAXLIGNE),choix.nextInt(Grille.MAXCOLONNE));
        // }
        
        // Random r = new Random ();           
        // for (int k= 0; k< 3; k++) {    
        //     grilledejeu.placerDesintegrateur(r.nextInt(Grille.MAXLIGNE),r.nextInt(Grille.MAXCOLONNE));
        // }
        
        //grilledejeu.afficherGrilleSurConsole(); //jusqu'ici c top
    } 

    public Joueur ProchainJoueur (Joueur un_joueur) {
        if (this.listeJoueurs[0] == this.joueurCourant){
            return this.listeJoueurs[1];
        }
        return this.listeJoueurs[0];
    }

    public void téléporteurs () {//crée	les	jetons	et	les	attribue	aux	aux	joueurs	correspondants.
    
    }   

    public void debuterPartie() {//lance	la	partie
        initialiserPartie();                             // initialisation de la partie, avec choix du nom des joueurs, affectation des jetons et de leur couleur.
        this.grilledejeu.afficherGrilleSurConsole();          // affichage de la grille de jeu, vide, avec les trous et desintegrateur.
        this.joueurCourant = listeJoueurs[1];                 // on initialise le joueur J2 comme etant le "premier" joueur . on pourrait ecrire "joueurCourant = listeJoueurs[listeJoueurs.length-1];"
        //System.out.println("le joueur actuel est : " + joueurCourant.getNom()); //validéééée
        
        while (this.grilledejeu.etreGagne() != true)  {
            this.joueurCourant = ProchainJoueur (joueurCourant);
            
            System.out.println("le joueur qui joue c : " + joueurCourant.getNom()); //ici ça marche
            
            System.out.println("Dans quelle colonne ajouter le jeton ?");
            
            
            Scanner sc = new Scanner(System.in);                 // Joueur J1 = new Joueur(sc.nextLine());
            int a = sc.nextInt();
            
            
            
            while (a>7){
                System.out.println("Il n'y a que 7 colonnes");
                sc = new Scanner(System.in);                 // Joueur J1 = new Joueur(sc.nextLine());
                a = sc.nextInt();
            }
            boolean jetonposee;
            jetonposee = this.grilledejeu.ajouterJetonDansColonne (this.joueurCourant.getListeJetons()[this.joueurCourant.getNombreJetonsRestant()-1] , a-1); //on a dû faire -1 ici car ça voulait pas dans la méthode en question dans la classe Grille
            /*jetonposee = this.grilledejeu.ajouterJetonDansColonne (this.joueurCourant.getListeJetons()[this.joueurCourant.getNombreJetonsRestant()-1] , a);
            jetonposee = this.grilledejeu.ajouterJetonDansColonne (this.joueurCourant.getListeJetons()[this.joueurCourant.getNombreJetonsRestant()-1] , a+1);
            jetonposee = this.grilledejeu.ajouterJetonDansColonne (this.joueurCourant.getListeJetons()[this.joueurCourant.getNombreJetonsRestant()-1] , a+2);*/
            this.grilledejeu.etreGagne();
            while (! jetonposee){
                sc = new Scanner(System.in);                 // Joueur J1 = new Joueur(sc.nextLine());
                a = sc.nextInt();
                while (a>7){
                    System.out.println("Il n'y a que 7 colonnes");
                    sc = new Scanner(System.in);                 // Joueur J1 = new Joueur(sc.nextLine());
                    a = sc.nextInt();
                }

                //jetonposee = this.grilledejeu.ajouterJetonDansColonne (this.joueurCourant.getListeJetons()[this.joueurCourant.getNombreJetonsRestant()-1] , a-1); //on a dû faire -1 ici car ça voulait pas dans la méthode en question dans la classe Grille
                //System.out.println(jetonposee);
                jetonposee = this.grilledejeu.ajouterJetonDansColonne (this.joueurCourant.getListeJetons()[this.joueurCourant.getNombreJetonsRestant()-1] , a);
            jetonposee = this.grilledejeu.ajouterJetonDansColonne (this.joueurCourant.getListeJetons()[this.joueurCourant.getNombreJetonsRestant()-1] , a+1);
            jetonposee = this.grilledejeu.ajouterJetonDansColonne (this.joueurCourant.getListeJetons()[this.joueurCourant.getNombreJetonsRestant()-1] , a+2);
                
            }
            this.grilledejeu.afficherGrilleSurConsole();
            
            /* System.out.println("le joueur qui joue c : " + joueurCourant.getNom());
            System.out.println("Deuxieme essaie");
            a = sc.nextInt();
            grilledejeu.ajouterJetonDansColonne (joueurCourant.listeJetons[joueurCourant.nombreJetonsRestant-1] , a-1);
            System.out.println(joueurCourant.nombreJetonsRestant);
            grilledejeu.afficherGrilleSurConsole();   
            System.out.println("le joueur qui joue c : " + joueurCourant.getNom()); */
        }
    }
}
