package application;

public class Cartes {
    
	//Variables pour les cartes
	
	private final String nom; // nom de la personne sur la carte alibi
    private final int nbTemps; // nombre de sablier sur la carte alibi

    public Cartes(String nom, int nbTemps) {
        // constructeur
        this.nom = nom;
        this.nbTemps = nbTemps;
    }
 
    // Getters
    
    public String getNom() {
        /** sert a obtenir le nom de la carte alibi */
        return this.nom;
    }

    public int getTemps() {
        /** sert a obtenir le nombre de temps sur la carte alibi */
        return this.nbTemps;
    }
}
