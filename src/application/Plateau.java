package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		
		for (int k = 0; k<9; k++){	
			
			if (k!=1 && k!=3 && k!=6)
			{
				Random r = new Random();
				this.plateau.get(k).setAngle(r.nextInt(4));																//prend un angle aléatoire entre 0 et 3 inclus
				//this.plateau.get(k).setImageAffichee(this.plateau.get(k).getImage(0));
			}
			this.plateau.get(k).setImageAffichee(this.plateau.get(k).getImage(this.plateau.get(k).getAngle()));		//définis l'image qui doit être affichée
		}
		
		//Gestion des trois cas murs face � inspecteurs
		int nume = 0;
		for (int k = 0; k<9; k++) {if (this.plateau.get(k).getPosition() == 1) {nume = k;}}
		this.plateau.get(nume).setAngle(1);
		this.plateau.get(nume).setImageAffichee(this.plateau.get(nume).getImage(this.plateau.get(nume).getAngle()));
		for (int k = 0; k<9; k++) {if (this.plateau.get(k).getPosition() == 3) {nume = k;}}
		this.plateau.get(nume).setAngle(3);
		this.plateau.get(nume).setImageAffichee(this.plateau.get(nume).getImage(this.plateau.get(nume).getAngle()));
		for (int k = 0; k<9; k++) {if (this.plateau.get(k).getPosition() == 6) {nume = k;}}
		this.plateau.get(nume).setAngle(0);
		this.plateau.get(nume).setImageAffichee(this.plateau.get(nume).getImage(this.plateau.get(nume).getAngle()));
		             
		Comparator<Tuiles> compareByPosition = (Tuiles tuile1, Tuiles tuile2) -> Integer.toString(tuile1.getPosition()).compareTo(Integer.toString(tuile2.getPosition()));
		Collections.sort(this.plateau,compareByPosition);
	} 
	
	
		public void PivoterTuiles(Tuiles tuile) {
		tuile.setAngle((tuile.getAngle()+1)%4);
		tuile.setImageAffichee(tuile.getImage(tuile.getAngle()));
		}

		public void IntervertirTuiles(Tuiles tuile1,Tuiles tuile2) {   // Methode pour intervertir deux tuiles apres l'utilisation du jeton action "echange" 	
		int pos1 = tuile1.getPosition();
		int pos2 = tuile2.getPosition();
	
		plateau.get(pos1).setPosition(pos2);
		plateau.get(pos2).setPosition(pos1);
	
		Collections.swap(plateau, pos1, pos2);
		}
	
	public ArrayList<Tuiles> getPlateau() {
			return plateau;
	}

	
}			