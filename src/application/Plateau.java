package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Plateau {
	// Variables 
	private ArrayList<Tuiles> plateau;  // listera les tuiles dans le but de les positionner sur le plateau


    // Constructeurs 
	public Plateau() {                    //Creation des elements de la classe plateau qui permettra d'afficher sur le plateau les elements suivants : 
		this.plateau = new ArrayList<Tuiles>();
		this.plateau.add(new Tuiles("TLestrade","TLestrade90","TLestrade180","TLestrade270","Verso","Verso90","Verso180","Verso270",0));
		this.plateau.add(new Tuiles("TBert","TBert90","TBert180","TBert270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TGoodley","TGoodley90","TGoodley180","TGoodley270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TGull","TGull90","TGull180","TGull270","Versog","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TLane","TLane90","TLane180","TLane270","Middle_verso","Middle_verso","Middle_verso","Middle_verso"));
		this.plateau.add(new Tuiles("TMadame","TMadame90","TMadame180","TMadame270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TPizer","TPizer90","TPizer180","TPizer270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TSmith","TSmith90","TSmith180","TSmith270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TStealthy","TStealthy90","TStealthy180","TStealthy270","Verso","Verso90","Verso180","Verso270"));
		
		
		ArrayList<String> positionnement = new ArrayList<String>();				//tableau qui contient les positions (ne sert que pour l'initialisation du tableau)
			positionnement.add("1");
			positionnement.add("2");
			positionnement.add("3");
			positionnement.add("4");
			positionnement.add("5");
			positionnement.add("6");
			positionnement.add("7");
			positionnement.add("8");
		
			
			int indexMax= positionnement.size();
	        for (int k = 1; k<9; k++) { 
				int index = (int)(Math.random()*indexMax);                                                        		// Parcours le placerTuile, placerTuile.get(k) on a la k-ieme Tuile
	        	this.plateau.get(k).setPosition(Integer.parseInt(positionnement.get(index)));
				positionnement.remove(index);
				indexMax--;
	        } 
	        for (int k = 0; k<9; k++)	 {	
				Random r = new Random();
				this.plateau.get(k).setAngle(r.nextInt(4));																//prend un angle aléatoire entre 0 et 3 inclus
				//this.plateau.get(k).setImageAffichee(this.plateau.get(k).getImage(0));
				this.plateau.get(k).setImageAffichee(this.plateau.get(k).getImage(this.plateau.get(k).getAngle()));		//définis l'image qui doit être affichée
	        }        
	}
	// Methodes 
		public void PivoterTuiles(Tuiles tuiles,int indice_de_rotation) {         // Cette m�thode sert � tourner la tuile qu'on selectionne avec le jeton action correspondant (indice_de_rotation : si = 1 alors tourner de 90�, si = 2 alors tourner de 180�, si = 3 alors tourner de 270�)
		// Si on a clique sur le jeton action, alors il faut cliquer sur une tuile qui est prise en parametre dans la methode pour ensuite choisir l'indice de rotation. 
			for (int n = 0; n < 150; n = n+4) {         				 // Cette boucle for permet � l'utilisateur de pouvoir effectuer plusieurs tours de rotation.
				if (indice_de_rotation == 0+n) {       					 // Si l'indice de rotation est egal a 0 alors on affiche que la tuile n'a pas ete tournee.
					System.out.println("L'image n'a pas �t� tourn�e.");
				}
				else if (indice_de_rotation == 1+n) {   				// Si l'indice de rotation est egal a 1 alors on affiche que la tuile a ete tournee de 90 degres.
					System.out.println("L'image a �t� tourn�e de 90 degr�s.");
				}
				else if (indice_de_rotation == 2+n) {				   // Si l'indice de rotation est egal a 2 alors on affiche que la tuile a ete tournee de 180 degres.	
				   System.out.println("L'image a �t� tourn�e de 180 degr�s.");	
				} 
				else if (indice_de_rotation == 3+n) {                 // Si l'indice de rotation est egal a 3 alors on affiche que la tuile a ete tournee de 270 degres.
			  	  System.out.println("L'image a �t� tourn�e de 270 degr�s.");
			    }
			}
		}
		
		public void IntervertirTuiles(int position_Tuile1,int position_Tuile2) {   // Methode pour intervertir deux tuiles apres l'utilisation du jeton action "echange" 	
			if (position_Tuile1 == position_Tuile2) {     // Si les deux tuiles sont egales il est impossible de les intervertir	
				System.out.println("Il est impossible d'intervertir une tuile avec elle m�me.");
		    }else {	
				plateau.get(position_Tuile1).setPosition(position_Tuile2);
				plateau.get(position_Tuile2).setPosition(position_Tuile1);
						
					Collections.swap(plateau, position_Tuile1, position_Tuile2); //ca maxime ca vient d'o� ? i.p
					System.out.println(position_Tuile1 + " intervertie avec " + position_Tuile2);
			}				
		}
		
		public ArrayList<Tuiles> getPlateau() {
			return plateau;
		}
}			