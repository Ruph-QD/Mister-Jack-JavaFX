package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable{
	@FXML private BorderPane borderPane;
//on recupere les textField et le bouton MrJack
	@FXML private Label joueurActu;
	@FXML private TextField fieldJack;
	@FXML private TextField fieldInspe;
	@FXML private Button MrJack;
//on recupere les boutons du plateau
/*		01|02|03
	12 |1 |2 |3 |04
	11 |8 |0 |4 |05
	10 |7 |6 |7 |06
		09|08|07
*/
	@FXML private Button button0;
	@FXML private Button button1;
	@FXML private Button button2;
	@FXML private Button button3;
	@FXML private Button button4;
	@FXML private Button button5;
	@FXML private Button button6;
	@FXML private Button button7;
	@FXML private Button button8;
	@FXML private Button button01;
	@FXML private Button button02;
	@FXML private Button button03;
	@FXML private Button button04;
	@FXML private Button button05;
	@FXML private Button button06;
	@FXML private Button button07;
	@FXML private Button button08;
	@FXML private Button button09;
	@FXML private Button button10;
	@FXML private Button button11;
	@FXML private Button button12;
//on récupère les boutons actions
	@FXML private Button action11; 				//bouton intervertir tuiles
	@FXML private Button action12;				//bouton tourner tuiles
	@FXML private Button action21;				//bouton deplacer tobi
	@FXML private Button action22;				//bouton deplacer Watson
	@FXML private Button action31;				//bouton deplacer Sherlock
	@FXML private Button action32;				//bouton piocher cartes
	@FXML private Button action41;				//bouton choix de deplacement
	@FXML private Button action42;				//bouton tourner tuile
//bouton de validation d'action
	@FXML private Button bValider;
//poour stocker les joueurs
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueurActuel;
//pour stocker les inspecteurs
	private Inspecteurs Tobi;
	private Inspecteurs Sherlock;
	private Inspecteurs Watson;

	private Plateau plateau;
	private ArrayList<Tuiles> listeTuiles;
	private Pioche pioche;
	private int tours;
	private int jetonsUtilise;

	private int jetonSelect;
	private ArrayList<Button> tuileSelectionne;

	private boolean carteMrJackVisible = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		/**Initialisation du projet */
		disableAll();
	}
	
	@FXML
	public void seeJack(ActionEvent e) {
		/**Permet de voir qui est MrJack*/
		this.MrJack.getStyleClass().removeAll("Alibi","Lestrade","Bert","Pizer","Smith","Lane","Madame","Stealthy","Goodley","Gull");
		this.MrJack.getStyleClass().add( this.carteMrJackVisible ? "Alibi" : joueur1.getAlibi() );
		this.carteMrJackVisible = (this.carteMrJackVisible ? false : true);
	}

	@FXML
	public void nouvellePartie(ActionEvent e) {
		/**Lance une nouvelle partie */
		disableAll(); 										//on desactive tous les boutons 

		//Creation des joueurs
		this.joueur1 = new Joueur( ((this.fieldJack.getText()=="" ) ? "MrJack" : this.fieldJack.getText()), "MrJack");				//si le champs est vide, on donne le nom par défault
		this.joueur2 = new Joueur( ((this.fieldInspe.getText()=="" ) ? "Inspecteur" : this.fieldInspe.getText()), "Inspecteur"); 	//si le champs est vide, on donne le nom par défault

		//Creation de la pioche
		this.pioche= new Pioche();
		this.pioche.Piocher(this.joueur1); 					//pour donner la carte alibi sous lequel MrJack est cachée
		this.MrJack.setDisable(false);
		//Creation du jeu
		this.plateau = new Plateau(); 						//créer le plateau
		this.listeTuiles = this.plateau.getPlateau();
		for (Tuiles tuile : this.listeTuiles){				//parcours les tuiles du plateau
			switch (tuile.getPosition()) {
				/*
					les differentes cases servent a identifier le bouton pour lequel il faut changer le style
					on est oblige de remove tous les style possible
					puis d'ajouter le style souhaite
				*/
				case 0:
					this.button0.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button0.getStyleClass().add(tuile.getImageAffichee());
					break;
				case 1:
					this.button1.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button1.getStyleClass().add(tuile.getImageAffichee());
					break;
				case 2:
					this.button2.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button2.getStyleClass().add(tuile.getImageAffichee());
					break;
				case 3:
					this.button3.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button3.getStyleClass().add(tuile.getImageAffichee());
					break;
				case 4:
					this.button4.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button4.getStyleClass().add(tuile.getImageAffichee());
					break;
				case 5:
					this.button5.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button5.getStyleClass().add(tuile.getImageAffichee());
					break;
				case 6:
					this.button6.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button6.getStyleClass().add(tuile.getImageAffichee());
					break;
				case 7:
					this.button7.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button7.getStyleClass().add(tuile.getImageAffichee());
					break;
				case 8:
					this.button8.getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270");
					this.button8.getStyleClass().add(tuile.getImageAffichee());
					break;
			}
		}
	//partie creation des inspecteurs et 
		this.Tobi = new Inspecteurs("Tobi");
		this.Sherlock = new Inspecteurs("Sherlock");
		this.Watson = new Inspecteurs("Watson");

		this.button01.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button02.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button03.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button04.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button05.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button06.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button07.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button08.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button09.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button10.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button11.getStyleClass().removeAll("Sherlock","Tobi","Watson");
		this.button12.getStyleClass().removeAll("Sherlock","Tobi","Watson");

		this.button04.getStyleClass().add("Sherlock");							
		this.button08.getStyleClass().add("Tobi");								
		this.button12.getStyleClass().add("Watson");							
		


		this.tours = 1;
		Button[] cInspecteurs = {this.button01,this.button02,this.button03,this.button04,this.button05,this.button06,this.button07,this.button08,this.button09,this.button10,this.button11,this.button12};
		this.jetonsUtilise = 0;
		nouveauTour();
		this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est en train de jouer");
		this.tuileSelectionne=new ArrayList<Button>();
	}
	@FXML
	public void nouveauTour(){
		int[] hazard = {RandInt(0,1),RandInt(0,1),RandInt(0,1),RandInt(0,1)};			//on g�n�re les jetons al�atoirements
		if (hazard[0] == 0) {action11.setDisable(false);}else {action12.setDisable(false);}
		if (hazard[1] == 0) {action21.setDisable(false);}else {action22.setDisable(false);}
		if (hazard[2] == 0) {action31.setDisable(false);}else {action32.setDisable(false);}
		if (hazard[3] == 0) {action41.setDisable(false);}else {action42.setDisable(false);}
		
		if (this.tours%2 == 0) {joueurActuel = joueur1;}else {joueurActuel = joueur2;}
	}
	
	@FXML
	public void utiliserJetons(ActionEvent e){
		switch(this.jetonsUtilise) {
		
			case 0:
				this.joueurActuel = (this.joueurActuel==this.joueur1 ? this.joueur2 : this.joueur1);
				this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est entrain de jouer");
				//if (this.tours%2 == 1) {joueurActuel = joueur1;}else {joueurActuel = joueur2;}
				//le bouton marque valider
				this.jetonsUtilise++;
				this.bValider.setDisable(true);
				break;
			case 1:
				//if (this.tours%2 == 1) {joueurActuel = joueur1;}else {joueurActuel = joueur2;}
				//le bouton marque valider
				this.jetonsUtilise++;
				this.bValider.setDisable(true);
				break;
			case 2:
				this.joueurActuel = (this.joueurActuel==this.joueur1 ? this.joueur2 : this.joueur1);
				this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est entrain de jouer");
				//if (this.tours%2 == 0) {joueurActuel = joueur1;}else {joueurActuel = joueur2;}
				//le bouton marque fin de tours
				this.jetonsUtilise++;
				this.bValider.setDisable(true);
				break;
			case 3:
				this.joueurActuel = (this.joueurActuel==this.joueur1 ? this.joueur2 : this.joueur1);
				this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est entrain de jouer");
				this.jetonsUtilise = 0;
				this.tours++;
				nouveauTour();
				this.bValider.setDisable(true);
				break;
		}
	}

	@FXML
	public void disableAll(){
		/**Disable tous les boutons */
		button0.setDisable(true);button1.setDisable(true);button2.setDisable(true);button3.setDisable(true);button3.setDisable(true);button4.setDisable(true);button5.setDisable(true);button6.setDisable(true);button7.setDisable(true);button8.setDisable(true);
		button01.setDisable(true);button02.setDisable(true);button03.setDisable(true);button04.setDisable(true);button05.setDisable(true);button06.setDisable(true);button07.setDisable(true);button08.setDisable(true);button09.setDisable(true);button10.setDisable(true);button11.setDisable(true);button12.setDisable(true);
		action11.setDisable(true);action12.setDisable(true);action21.setDisable(true);action22.setDisable(true);action31.setDisable(true);action32.setDisable(true);action41.setDisable(true);action42.setDisable(true);
		bValider.setDisable(true);
		MrJack.setDisable(true);
	}

	@FXML
	public void enableTuiles(boolean bool){
		button0.setDisable(!bool);button1.setDisable(!bool);button2.setDisable(!bool);button3.setDisable(!bool);button3.setDisable(!bool);button4.setDisable(!bool);button5.setDisable(!bool);button6.setDisable(!bool);button7.setDisable(!bool);button8.setDisable(!bool);
	}
	
	@FXML
	public void disableTuilesInspect(boolean bool){
		button01.setDisable(true);button02.setDisable(true);button03.setDisable(true);button04.setDisable(true);button05.setDisable(true);button06.setDisable(true);button07.setDisable(true);button08.setDisable(true);button09.setDisable(true);button10.setDisable(true);button11.setDisable(true);button12.setDisable(true);
	}
	
	@FXML
	public void intervertirTuiles(ActionEvent e) {  // Methode pour intervertir deux tuiles lorsqu'on a appuye sur le jeton action intervertir tuiles
		this.jetonSelect=11;
		enableTuiles(true);
		action11.setDisable(true);
	}
	
	@FXML
	public void tournerTuiles1(ActionEvent e){ // Methode pour tourner les tuiles apres avoir appuyer sur le jeton tourner tuiles
		this.jetonSelect=12;
		bValider.setDisable(false);
		enableTuiles(true);
		action12.setDisable(true);
	}
	
	@FXML
	public void deplacerTobi(ActionEvent e) {  // Methode pour deplacer inspecteur Tobi de une ou deux cases apres avoir appuye sur son jeton
		this.jetonSelect=21;

		String position = this.Tobi.getPosition();
		
		String pos1 ="01";
		String pos2 ="01";

		if ((Integer.parseInt(position) +1)<10){
			pos1 = ("0"+Integer.toString((Integer.parseInt(position) +1)));
		}else if ((Integer.parseInt(position) +1) == 13) {
			pos1 = "01";
		}else{
			pos1 = Integer.toString(((Integer.parseInt(position) +1)));
		}

		if ((Integer.parseInt(position) +2)<10){
			pos2 = ("0"+Integer.toString((Integer.parseInt(position) +2)));
		}else if ((Integer.parseInt(position) +2) == 13) {
			pos2 = "01";
		}else if ((Integer.parseInt(position) +2) == 14) {
			pos2 = "02";
		}else{
			pos2 = Integer.toString(((Integer.parseInt(position) +2)));
		}

		((Button) borderPane.lookup("#button"+pos1)).setDisable(false);
		((Button) borderPane.lookup("#button"+pos2)).setDisable(false);

		bValider.setDisable(false);
		action21.setDisable(true);
	}
	
	@FXML
	public void deplacerWatson(ActionEvent e) {   // Methode pour deplacer inspecteur Watson de une ou deux cases apres avoir appuye sur son jeton
		this.jetonSelect=22;
		
		String position = this.Watson.getPosition();

		String pos1 ="01";
		String pos2 ="01";

		if ((Integer.parseInt(position) +1)<10){
			pos1 = ("0"+Integer.toString((Integer.parseInt(position) +1)));
		}else if ((Integer.parseInt(position) +1) == 13) {
			pos1 = "01";
		}else{
			pos1 = Integer.toString(((Integer.parseInt(position) +1)));
		}

		if ((Integer.parseInt(position) +2)<10){
			pos2 = ("0"+Integer.toString((Integer.parseInt(position) +2)));
		}else if ((Integer.parseInt(position) +2) == 13) {
			pos2 = "01";
		}else if ((Integer.parseInt(position) +2) == 14) {
			pos2 = "02";
		}else{
			pos2 = Integer.toString(((Integer.parseInt(position) +2)));
		}

		((Button) borderPane.lookup("#button"+pos1)).setDisable(false);
		((Button) borderPane.lookup("#button"+pos2)).setDisable(false);
		
		bValider.setDisable(false);
		action22.setDisable(true);
	}
	
	@FXML
	public void deplacerSherlock(ActionEvent e) {  // Methode pour deplacer inspecteur Sherlock de une ou deux cases apres avoir appuye sur son jeton
		this.jetonSelect=31;
		
		String position = this.Sherlock.getPosition();

		String pos1 ="01";
		String pos2 ="01";

		if ((Integer.parseInt(position) +1)<10){
			pos1 = ("0"+Integer.toString((Integer.parseInt(position) +1)));
		}else if ((Integer.parseInt(position) +1) == 13) {
			pos1 = "01";
		}else{
			pos1 = Integer.toString(((Integer.parseInt(position) +1)));
		}

		if ((Integer.parseInt(position) +2)<10){
			pos2 = ("0"+Integer.toString((Integer.parseInt(position) +2)));
		}else if ((Integer.parseInt(position) +2) == 13) {
			pos2 = "01";
		}else if ((Integer.parseInt(position) +2) == 14) {
			pos2 = "02";
		}else{
			pos2 = Integer.toString(((Integer.parseInt(position) +2)));
		}

		((Button) borderPane.lookup("#button"+pos1)).setDisable(false);
		((Button) borderPane.lookup("#button"+pos2)).setDisable(false);
		
		bValider.setDisable(false);
		action31.setDisable(true);
	}
	
	@FXML
	public void piocherCartes(ActionEvent e) {  // Methode pour piocher une carte alibi apres avoir appuye sur le jeton action piocher 
		this.jetonSelect=32;
		this.pioche.Piocher(this.joueurActuel);
		//for(int k =0;k<this.pioche.getCartes().size();k++){System.out.println(this.pioche.getCartes().get(k).getNom());}
		// If Mr Jack -> Rajouter des sabliers 
		// If Inspecteur -> On innocente le perso pioche et on tourne sa carte
		action32.setDisable(true);
		this.jetonsUtilise++;
		this.joueurActuel=(this.jetonsUtilise==1 || this.jetonsUtilise==3 ? (this.joueurActuel == this.joueur1 ? this.joueur2 : this.joueur1) : this.joueurActuel);
		this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est entrain de jouer");
	}
	
	@FXML
	public void choixDeplacement(ActionEvent e) {  // Methode pour deplacer au choix un des trois inspecteurs
		this.jetonSelect=41;
		bValider.setDisable(false);
		action41.setDisable(true);
	}
	
	@FXML
	public void tournerTuiles2(ActionEvent e){ // Methode pour tourner les tuiles apres avoir appuyer sur le jeton tourner tuiles
		this.jetonSelect=12;
		bValider.setDisable(false);
		enableTuiles(true);
		action42.setDisable(true);
	}
	
	@FXML 
	public void pushed(ActionEvent e){
		switch(jetonSelect) {
			case 11:
				//intervertir Tuiles
				if (tuileSelectionne.size()>0){
					this.tuileSelectionne.add((Button)e.getSource());
					String style0 = this.tuileSelectionne.get(0).getStyleClass().get(2);
					String style1 = this.tuileSelectionne.get(1).getStyleClass().get(2);
		
					this.tuileSelectionne.get(0).getStyleClass().removeAll(style0);
					this.tuileSelectionne.get(1).getStyleClass().removeAll(style1);
		
					this.tuileSelectionne.get(0).getStyleClass().add(style1);
					this.tuileSelectionne.get(1).getStyleClass().add(style0);
					
					int numero0 = this.tuileSelectionne.get(0).getId().charAt(this.tuileSelectionne.get(0).getId().length()-1) - '0';
					int numero1 = this.tuileSelectionne.get(1).getId().charAt(this.tuileSelectionne.get(1).getId().length()-1) - '0';

					plateau.IntervertirTuiles(this.listeTuiles.get(numero0), this.listeTuiles.get(numero1));

					this.jetonSelect = 0;
					this.jetonsUtilise++;
					enableTuiles(false);
					this.tuileSelectionne.clear();
					System.out.println(this.jetonsUtilise);
				}else{
					this.tuileSelectionne.add((Button)e.getSource());
					this.tuileSelectionne.get(0).setDisable(true);
				}
				System.out.println();
				break;
			case 12:
				//tourner Tuiles
				enableTuiles(true);
				((Button)e.getSource()).setDisable(false);
				this.jetonsUtilise++;
				enableTuiles(false);
				this.tuileSelectionne.clear();
				System.out.println(this.jetonsUtilise);
				break;
			case 21:
				//déplacer Tobi
				String oldPositionTobi = this.Tobi.getPosition();
				String newPositionTobi = Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-2)-'0') + Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-1)-'0');
				this.Tobi.setPosition(newPositionTobi);

				((Button)e.getSource()).getStyleClass().add("Tobi");
				((Button) borderPane.lookup("#button"+oldPositionTobi)).getStyleClass().removeAll("Tobi");
				disableTuilesInspect(true);
				break;
			case 22:
				//deplacer Watson
				String oldPositionWatson = this.Watson.getPosition();
				String newPositionWatson = Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-2)-'0') + Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-1)-'0');
				this.Watson.setPosition(newPositionWatson);

				((Button)e.getSource()).getStyleClass().add("Watson");
				((Button) borderPane.lookup("#button"+oldPositionWatson)).getStyleClass().removeAll("Watson");
				disableTuilesInspect(true);
				break;
			case 31:
				// deplacer Sherlock
				String oldPositionSherlock = this.Sherlock.getPosition();
				String newPositionSherlock = Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-2)-'0') + Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-1)-'0');
				this.Sherlock.setPosition(newPositionSherlock);

				((Button)e.getSource()).getStyleClass().add("Sherlock");
				((Button) borderPane.lookup("#button"+oldPositionSherlock)).getStyleClass().removeAll("Sherlock");
				disableTuilesInspect(true);
				break;
			case 32:
				break;
			case 41:
				break;	
		}
		
	}

	private static int RandInt(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
	}
	
	
	
	
}


