package application;

public class Inspecteurs {
	
	// ICI variables à definir pour les inspecteurs 
	private String position;
	private String nom;       
	
	public Inspecteurs(String nom) {     // On definit ici le constructeur de la classe Inspecteurs
		this.nom = nom;
			if (nom=="Sherlock"){
				this.position="04";
			}else if (nom=="Watson"){
				this.position="12";
			}else{
				this.position="08";
			}
	}

	public void setPosition(String position){
		this.position = position; 
	}

	public String getPosition(){
		return this.position;
	}
}
