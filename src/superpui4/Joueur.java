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
public class Joueur {
    //Attributs :	

    private String nom; //nom	du	joueur
    private String couleur; //couleur	affectée	au	joueur
    private Jeton [] listeJetons;//tableau	décrivant	les	jetons	encore	en	possession	du	joueur
    private int nombreDesintegrateurs;//nombre	de	désintégrateurs	actuellement	en	possession
    private int nombreJetonsRestant; //nombre	 de	 jetons	 restant	 en	 possession	 du	 joueur,	correspondant	à	la	taille	effective	de	ListeJetons
    

    
    
    public Joueur (String nomDuJoueur) {
        this.nom = nomDuJoueur;
        this.couleur = null;
        this.listeJetons = new Jeton [Partie.NOMBREJETONTOTAL]; //il fauvra peut-être initialiser le nbr de jeton en début de partie
        this.nombreDesintegrateurs = 0;
        this.nombreJetonsRestant = 0 ;   
    }    
    
    //methodes

    public String getCouleur(){
        return this.couleur;
    }

    public String getNom(){
        return this.nom;
    }

    public Jeton [] getListeJetons(){
        return this.listeJetons;
    }

    public int getNombreJetonsRestant(){
        return this.nombreJetonsRestant;
    }

    public void incrementationNbJetonsRestant(){
        this.nombreJetonsRestant ++;
    }

    public void decrementationNbJetonsRestant(){
        this.nombreJetonsRestant --;
    }
    
    public void affecterCouleur(String couleurAffecte){//affecte	la	couleur en	paramètre	au	joueur
        this.couleur = couleurAffecte; // on peut aussi ecrire " this.couleur = couleur ;" si on avait appelé le parametre de la methode ainsi.
    }


    public boolean ajouterJeton(Jeton jeton) {//ajoute	le	jeton	passé	en	paramètre	à	la	liste	des	jetons
        for (int i = 0; i<Partie.NOMBREJETONTOTAL; i++){
            this.listeJetons [i] = jeton; //je voudrais des jetons d'une couleur spécifique : il faut revoir
        }
        return true; //pas de false ?
    }
    public void obtenirDesintegrateur(){//incrémente	le	nombre	de	désintégrateurs	du	joueur
        this.nombreDesintegrateurs ++;
    }

    public boolean utiliserDesintegrateur() {// décrémente	 le	 nombre	 de	 désintégrateurs	 et	 confirme l’utilisation	de	ce	dernier,	ou	renvoie	faux	s’il	ne	restait	plus	de	désintégrateurs.
        if (this.nombreDesintegrateurs > 0){
            this.nombreDesintegrateurs --;
            return true;
        }
        else {
            return false;
        }
    }
}