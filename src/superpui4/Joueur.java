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

    String nom; //nom	du	joueur
    String couleur; //couleur	affectée	au	joueur
    Jeton [] listeJetons;//tableau	décrivant	les	jetons	encore	en	possession	du	joueur
    int nombreDesintegrateurs;//nombre	de	désintégrateurs	actuellement	en	possession
    int nombreJetonsRestant; //nombre	 de	 jetons	 restant	 en	 possession	 du	 joueur,	correspondant	à	la	taille	effective	de	ListeJetons
    

    
    
    public Joueur (String nomDuJoueur) {
    nom = nomDuJoueur;
    couleur = null;
    listeJetons = new Jeton [Partie.NOMBREJETONTOTAL]; //il fauvra peut-être initialiser le nbr de jeton en début de partie
    nombreDesintegrateurs = 0;
    nombreJetonsRestant = 0 ;   
            
    }    
    
    //methodes
    
public void affecterCouleur(String couleurAffecte){//affecte	la	couleur en	paramètre	au	joueur
    couleur = couleurAffecte; // on peut aussi ecrire " this.couleur = couleur ;" si on avait appelé le parametre de la methode ainsi.

   }


public boolean ajouterJeton(Jeton jeton) {//ajoute	le	jeton	passé	en	paramètre	à	la	liste	des	jetons
    for (int i = 0; i<Partie.NOMBREJETONTOTAL; i++){
       listeJetons [i] = jeton; //je voudrais des jetons d'une couleur spécifique : il faut revoir
    }
return true; //pas de false ?
}
public void obtenirDesintegrateur(){//incrémente	le	nombre	de	désintégrateurs	du	joueur
    nombreDesintegrateurs ++;
}

public boolean utiliserDesintegrateur() {// décrémente	 le	 nombre	 de	 désintégrateurs	 et	 confirme l’utilisation	de	ce	dernier,	ou	renvoie	faux	s’il	ne	restait	plus	de	désintégrateurs.
    if (nombreDesintegrateurs > 0){
    nombreDesintegrateurs --;
    return true;}
    else {
        return false;
    }
}



}