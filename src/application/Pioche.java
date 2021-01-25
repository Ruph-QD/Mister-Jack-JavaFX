package application;

import java.util.ArrayList;

public class Pioche {
    private ArrayList<Cartes> enJeu; //listera le nom des cartes encore en jeu

    public Pioche(){
        //on créé notre pioche qui contient toutes les cartes possibles
        this.enJeu = new ArrayList<Cartes>();
        this.enJeu.add(new Cartes("Lestrade",0));
        this.enJeu.add(new Cartes("Bert",    1));
        this.enJeu.add(new Cartes("Pizer",   1));
        this.enJeu.add(new Cartes("Smith",   1));
        this.enJeu.add(new Cartes("Lane",    1));
        this.enJeu.add(new Cartes("Madame",  2));
        this.enJeu.add(new Cartes("Stealthy",1));
        this.enJeu.add(new Cartes("Goodley", 0));
        this.enJeu.add(new Cartes("Gull",    1));
    }
    
    public String Piocher(Joueur joueur){
        /**Sert à piocher une carte dans le paquet. S'il s'agit de la première fois, la carte est l'identité de MrJack.
         * Sinon on ajoute le temps sur la carte (MRJack) ou retourne le nom d'une tuile (Inspecteur)*/
        int indexMax= this.enJeu.size();                //on récupère la taille du paquet
        int index = (int)(Math.random()*indexMax);      //on prendsd un entier aléatoire

        int temps=this.enJeu.get(index).getTemps();     //on recupere le temps de la carte
        String nom = this.enJeu.get(index).getNom();    //on recupere le nom de la carte

        this.enJeu.remove(index);       //on enleve la carte du paquet
        if (indexMax==9) {              //première fois qu'on pioche dans le paquet
            joueur.setAlibi(nom);       //on definit le nom de carte du joueur MrJack
            return null;
        }
        else if (joueur.isMrJack()) {   //si le joueur est MrJack
            joueur.addTemps(temps);     //on ajoute le nombre de sablier 
            return null;
        }else{
            return nom;                 //on retourne le temps qui se trouve sur la carte
        }
    }

    public ArrayList<Cartes> getCartes(){
        /**Permet d'obtenir le paquet de carte */
        return this.enJeu;
    }
}