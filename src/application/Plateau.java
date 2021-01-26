package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Plateau {
	// Variables 
	private ArrayList<Tuiles> plateau;  // listera les tuiles dans le but de les positionner sur le plateau


    // Constructeurs 
	public Plateau() {
		//Creation des elements de la classe plateau qui permettra d'afficher sur le plateau les elements suivants : 
		this.plateau = new ArrayList<Tuiles>();
		this.plateau.add(new Tuiles("TLestrade","TLestrade90","TLestrade180","TLestrade270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TBert","TBert90","TBert180","TBert270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TGoodley","TGoodley90","TGoodley180","TGoodley270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TGull","TGull90","TGull180","TGull270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TLane","TLane90","TLane180","TLane270","Middle_verso","Middle_verso","Middle_verso","Middle_verso"));
		this.plateau.add(new Tuiles("TMadame","TMadame90","TMadame180","TMadame270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TPizer","TPizer90","TPizer180","TPizer270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TSmith","TSmith90","TSmith180","TSmith270","Verso","Verso90","Verso180","Verso270"));
		this.plateau.add(new Tuiles("TStealthy","TStealthy90","TStealthy180","TStealthy270","Verso","Verso90","Verso180","Verso270"));
		
		
		ArrayList<String> positionnement = new ArrayList<String>();							//tableau qui contient les positions (ne sert que pour l'initialisation du tableau)
		for (int k =1; k<9;k++){positionnement.add(Integer.toString(k));}				

		
		int indexMax= positionnement.size();

		for (int k = 1; k<9; k++) {
			//on pioche aléatoire dans les positions et on les attributs aux tuiles
			int index = (int)(Math.random()*indexMax);
			this.plateau.get(k).setPosition(Integer.parseInt(positionnement.get(index)));
			positionnement.remove(index);
			indexMax--;
		}
		
		for (int k = 0; k<9; k++){	
			//on donne des angles aléatoire aux tuiles
			if (k!=1 && k!=3 && k!=6){
				Random r = new Random();
				this.plateau.get(k).setAngle(r.nextInt(4));			//chiffre aleatoire entre 0 et 3 inclus
			}
			this.plateau.get(k).setImageAffichee(this.plateau.get(k).getImage(this.plateau.get(k).getAngle()));		//definis l'image qui doit etre affichee
		}

		//on tri le ArrayList en fonction de position
		Comparator<Tuiles> compareByPosition = (Tuiles tuile1, Tuiles tuile2) -> Integer.toString(tuile1.getPosition()).compareTo(Integer.toString(tuile2.getPosition()));
		Collections.sort(this.plateau,compareByPosition);

		//Gestion des trois cas murs face aux inspecteurs
		this.plateau.get(1).setAngle(1);
		this.plateau.get(1).setImageAffichee(this.plateau.get(1).getImage(this.plateau.get(1).getAngle()));
		this.plateau.get(3).setAngle(3);
		this.plateau.get(3).setImageAffichee(this.plateau.get(3).getImage(this.plateau.get(3).getAngle()));
		this.plateau.get(6).setAngle(0);
		this.plateau.get(6).setImageAffichee(this.plateau.get(6).getImage(this.plateau.get(6).getAngle()));
	} 
	
	
	public void PivoterTuiles(Tuiles tuile){
		//on ajoute +1 a l'angle. On fait bien attenntion de traiter les deux cas possibles (tuile face recto ou face verso)
		if (tuile.getAngle() < 4){
			tuile.setAngle((tuile.getAngle()+1)%4);
		}else{
			tuile.setAngle(((tuile.getAngle()+1)%4)+4);
		}
		tuile.setImageAffichee(tuile.getImage(tuile.getAngle()));
	}

	public void IntervertirTuiles(Tuiles tuile1,Tuiles tuile2) {
		// Methode pour intervertir deux tuiles apres l'utilisation du jeton action "echange" 	
		int pos1 = tuile1.getPosition();
		int pos2 = tuile2.getPosition();
		//on switch leur position 
		plateau.get(pos1).setPosition(pos2);
		plateau.get(pos2).setPosition(pos1);

		Collections.swap(plateau, pos1, pos2);	//on echange leurs position dans le plateau
	}
	
	public ArrayList<Tuiles> getPlateau() {
		//Pour récupérer le plateau
		return plateau;
	}

	
}