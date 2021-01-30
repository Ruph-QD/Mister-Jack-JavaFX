package application;

public class Joueur {
	
	//Variables de la classe Joueur
	
	private String nomJoueur;	// Variable qui stocke le pseudo du joueur
	private String role; 		// Variable qui stocke le role du joueur (MrJack ou Inspecteur)
	private String alibi; 		// Variable qui stocke le nom sous lequel est cache MrJack
	private int temps; 			// Variable qui stocke le nombre de sablier du joueur

	public Joueur(String nomJoueur, String role) {
		// constructeur
		this.nomJoueur = nomJoueur;
		this.role = role;
		this.alibi = null;
		this.temps = 0;
	}

	
	// Setters et Getters
	
	public void setAlibi(String alibi) {
		// sert a attribuer un alibi a MrJAck
		this.alibi = alibi;
	}

	public String getNom() {
		// retourne le nom du joueur
		return (this.nomJoueur);
	}

	public boolean isMrJack() {
		/**
		 * Return true si le joueur en question est MrJack et false s'il s'agit d'un
		 * inspecteur
		 */
		return this.role == "MrJack";
	}

	public String getAlibi() {
		// retourne l'alibi pour MrJack
		return (this.alibi);
	}

	public int getTemps() {
		// sert a obtenir le temps qu'a MrJack
		return this.temps;
	}

	public void addTemps(int nombre) {
		// sert a augmenter de "nombre" le temps de MrJack
		this.temps += nombre;
	}
}
