package application;

import java.util.ArrayList;

public class Pioche {
    private ArrayList<Cartes> enJeu; //listera le nom des cartes encore en jeu

    public Pioche(){
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
        /**Sert à piocher une carte dans le paquet et return le temps sur la carte(MRJack) ou retourne une tuile (Inspecteur)*/
        int indexMax= this.enJeu.size();
        int index = (int)(Math.random()*indexMax);

        int temps=this.enJeu.get(index).getTemps();     //on recupere le temps de la carte
        String nom = this.enJeu.get(index).getNom();    //on recupere le nom de la carte

        this.enJeu.remove(index);       //on enleve la carte du paquet
        if (indexMax==9) {
            joueur.setAlibi(nom);       //on definit le nom de carte du joueur MrJack
            return null;                //ici le nom sur la carte n'est pas important
        }
        else if (joueur.isMrJack()) {   //si le joueur est MrJack
            joueur.addTemps(temps);     //on ajoute le nombre de sablier 
            return null;                //ici le nom sur la carte n'est pas important
        }else{
            return nom;                 //on retourne le temps qui se trouve sur la carte
        }
    }

    public ArrayList<Cartes> getCartes(){
        return this.enJeu;
    }
}