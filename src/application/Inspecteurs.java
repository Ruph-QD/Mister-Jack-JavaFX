package application;

public class Inspecteurs {

	// Variable pour les inspecteurs
	
	private String position;   // sert a stocker la position de l'inspecteur
	private String nom;       // sert a stocker le nom de l'inspecteur

	public Inspecteurs(String nom) { // On definit ici le constructeur de la classe Inspecteurs
		this.nom = nom;
		if (nom == "Sherlock") {
			this.position = "04";
		} else if (nom == "Watson") {
			this.position = "12";
		} else {
			this.position = "08";
		}
	}

	// Setters et Getters
	
	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return this.position;
	}
}
