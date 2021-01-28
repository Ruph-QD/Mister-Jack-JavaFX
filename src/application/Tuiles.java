package application;

public class Tuiles {
	//Nous avons decide d'enregister les images avec leur rotations car cela est plus simple a gerer au lieu de le faire directement avec l'interface graphique
	private String recto;
	private String recto90;
	private String recto180;
	private String recto270;
	private String verso;
	private String verso90;
	private String verso180;
    private String verso270;
    private String imageAffichee;
	private int position; //entre 1 et 9 pris aleatoirement pour identifier sur quel case se situe la tuile
	private int angle;	//l'angle va de 0 a 3 (recto, recto90, recto180, recto270) puis de 4 à 7 (verso, verso90, verso180, verso270). On trouve directement l'image grace a l'angle
	
	public Tuiles(String recto, String recto90, String recto180, String recto270, String verso, String verso90, String verso180, String verso270) {      // On definit le constructeur de la classe Tuiles
		this.recto = recto;
		this.recto90 = recto90;
		this.recto180 = recto180;
		this.recto270 = recto270;
		this.verso = verso;
		this.verso90 = verso90;
		this.verso180 = verso180;
		this.verso270 = verso270;
		position = 0;
	}
	
	public void setPosition(int position) {      	
		this.position = position;
	}
	
	public int getPosition() {	
		return this.position;
	}

	public void setAngle(int angle) {
		this.angle = angle;	
	}
	
	public int getAngle() {
		return this.angle;
	}

	public String getImage(int num){
		//retourne l'image correpsondante au numero demande
		switch (num) {
		case 0:
			return this.recto;
		case 1:
			return this.recto90;
		case 2:
			return this.recto180;
		case 3:
			return this.recto270;
		case 4:
			return this.verso;
		case 5:
			return this.verso90;
		case 6:
			return this.verso180;
		case 7:
			return this.verso270;
		default :
			return this.recto;
		}
	}
	
	public void setImageAffichee(String image){
        this.imageAffichee=image;
	}
	public String getImageAffichee(){
		return this.imageAffichee;
	}

	public int getMur(){
		/**Return la position du mur qui marche de la meme maniere que l'angle (de 0 a 4), 4 etant pas de mur */
		return (this.verso == "TLane" && this.angle > 3 ? 4 : this.angle%4);
	}

}
