package application;

public class Joueur {
	private String nomJoueur; 	//le pseudo du joueur
	private String role;		//Le role du joueur (MrJack ou Inspecteur)
	private String alibi;		//Le nom sous lequel est cache MrJack
	private int temps;			//Le nombre de sablier du joueur
	
	public Joueur(String nomJoueur, String role) {
		//constructeur
		this.nomJoueur=nomJoueur;
		this.role=role;
		this.alibi= null;
		this.temps=0;
	}

	public void setAlibi(String alibi) {
		//sert à donner un alibi à MrJAck
		this.alibi= alibi;
	}

	public String getNom() {
		//retourne le nom du joueur
		return (this.nomJoueur);
	}
	
	public boolean isMrJack() {
		/**Return true si le joueur en question est MrJack et false s'il s'agot d'un inspecteur */
		if (this.role=="MrJack"){
			return true;
		}else{
			return false;
		}
	}
	
	public String getAlibi() {
		//retourne l'alibi pour MrJack
		return (this.alibi);
	}

	public int getTemps(){
		//sert à obtenir le temps qu'a MrJack
		return this.temps;
	}

	public void addTemps(int nombre){
		//sert à augmenter de "nombre" le temps de MrJack
		this.temps+=nombre;
	}
}
