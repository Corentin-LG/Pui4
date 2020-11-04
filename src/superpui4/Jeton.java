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
public class Jeton {
    
    //Attributs :	
String couleur; // :	couleur	affectée	au	joueur

    //Méthodes :
public Jeton (String couleur) {
//:	constructeur	initialisant	la	couleur	du	jeton avec	le	paramètre	
this.couleur = couleur;
        }   
public String lireCouleur(){
//:renvoie la	couleur	du	jeton 
return couleur; //je suis dans la classe, je n'ai pas besoin de mettre "Jeton."
        }
}
