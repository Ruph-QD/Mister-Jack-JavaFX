package application;

public class Joueur {
	private String nomJoueur; 	//le pseudo du joueur
	private String role;		//Le rôle du joueur (MrJack ou Inspecteur)
	private String alibi;		//Le nom sous lequel est caché MrJack
	private int temps;			//Le nombre de sablier du joueur
	
	public Joueur(String nomJoueur, String role) {
		this.nomJoueur=nomJoueur;
		this.role=role;
		this.alibi= null;
		this.temps=0;
	}

	public void setAlibi(String alibi) {
		this.alibi= alibi;
	}

	public String getNom() {
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
		return (this.alibi);
	}

	public int getTemps(){
		return this.temps;
	}

	public void addTemps(int nombre){
		this.temps+=nombre;
	}
}
