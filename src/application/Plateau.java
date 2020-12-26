package application;

import java.util.ArrayList;
import java.util.Collections;

public class Plateau {
	// Variables 
	private ArrayList<Tuiles> plateau;  // listera les tuiles dans le but de les positionner sur le plateau


    // Constructeurs 
	public Plateau() {                    //Creation des elements de la classe plateau qui permettra d'afficher sur le plateau les elements suivants : 
		this.plateau = new ArrayList<Tuiles>();
		this.plateau.add(new Tuiles("../districts/TLestrade.png","../districts/TLestradeR90.png","../districts/TLestradeR180.png","../districts/TLestradeR270.png","../districts/Middle_verso.png","../districts/Middle_verso.png","../districts/Middle_verso.png","../districts/Middle_verso.png",0));
		this.plateau.add(new Tuiles("../districts/TBert.png","../districts/TBertR90.png","../districts/TBertR180.png","../districts/TBertR270.png","../districts/Verso.png","../districts/VersoR90.png","../districts/VersoR180.png","../districts/VersoR270.png"));
		this.plateau.add(new Tuiles("../districts/TGoodley.png","../districts/TGoodleyR90.png","../districts/TGoodley180.png","../districts/TGoodleyR270.png","../districts/Verso.png","../districts/VersoR90.png","../districts/VersoR180.png","../districts/VersoR270.png"));
		this.plateau.add(new Tuiles("../districts/TGull.png","../districts/TGullR90.png","../districts/TGullR180.png","../districts/TGullR270.png","../districts/Verso.png","../districts/VersoR90.png","../districts/VersoR180.png","../districts/VersoR270.png"));
		this.plateau.add(new Tuiles("../districts/TLane.png","../districts/TLaneR90.png","../districts/TLaneR180.png","../districts/TLaneR270.png","../districts/Verso.png","../districts/VersoR90.png","../districts/VersoR180.png","../districts/VersoR270.png"));
		this.plateau.add(new Tuiles("../districts/TMadame.png","../districts/TMadameR90.png","../districts/TMadameR180.png","../districts/TMadameR270.png","../districts/Verso.png","../districts/VersoR90.png","../districts/VersoR180.png","../districts/VersoR270.png"));
		this.plateau.add(new Tuiles("../districts/TPizer.png","../districts/TPizerR90.png","../districts/TPizerR180.png","../districts/TPizerR270.png","../districts/Verso.png","../districts/VersoR90.png","../districts/VersoR180.png","../districts/VersoR270.png"));
		this.plateau.add(new Tuiles("../districts/TSmith.png","../districts/TSmithR90.png","../districts/TSmithR180.png","../districts/TSmithR270.png","../districts/Verso.png","../districts/VersoR90.png","../districts/VersoR180.png","../districts/VersoR270.png"));
		this.plateau.add(new Tuiles("../districts/TStealthy.png","../districts/TStealthyR90.png","../districts/TStealthyR180.png","../districts/TStealthyR270.png","../districts/Verso.png","../districts/VersoR90.png","../districts/VersoR180.png","../districts/VersoR270.png"));
		
		
		ArrayList<String> positionnement = new ArrayList<String>();
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
				int index = (int)(Math.random()*indexMax);                                                          // Parcours le placerTuile, placerTuile.get(k) on a la k-ieme Tuile
	        	this.plateau.get(k).setPosition(Integer.parseInt(positionnement.get(index)));
				positionnement.remove(index);
				indexMax--;
	        } 
	        for (int k = 0; k<9; k++)	 {	
				this.plateau.get(k).setAngle((int)(Math.random()*3));
				this.plateau.get(k).setImageAffichee(this.plateau.get(k).getImage(0));
				//this.plateau.get(k).setImageAffichee(this.plateau.get(k).getImage((int)Math.random()*3));	
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