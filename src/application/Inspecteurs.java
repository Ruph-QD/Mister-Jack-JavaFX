package application;

public class Inspecteurs {
	
	// ICI variables à définir pour les inspecteurs 
	private int position;
	private String nom;       
	
	public Inspecteurs(String nom) {     // On définit ici le constructeur de la classe Inspecteurs
		this.nom = nom;
			if (nom=="Holmes"){
				this.position=11;
			}else if (nom=="Watson"){
				this.position=3;
			}else{
				this.position=7;
			}
	}

	public void Avancer(int nombre){
		/**On fait avancer l'inspecteur de nombre cases */
		this.position = (this.position + nombre) %12; 	//les cases vont de 0 à 11 d'où %12
	}

	public int getPosition(){
		return this.position;
	}

	/*
	public String[] AppelATemoin(){
		//TODO:à faire
	}
	*/
}
