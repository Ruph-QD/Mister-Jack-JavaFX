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
	10 |7 |6 |5 |06
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
	private Joueur joueur1;						//MrJack
	private Joueur joueur2;						//Inspecteur
	private Joueur joueurActuel;
//pour stocker les inspecteurs
	private Inspecteurs Tobi;
	private Inspecteurs Sherlock;
	private Inspecteurs Watson;
	private int reset = 0;

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
		for (int k =0;k<9;k++){
				/*		
					on est oblige de remove tous les style possible
					puis d'ajouter le style souhaite
				*/
			((Button) borderPane.lookup("#button"+Integer.toString(k))).getStyleClass().removeAll("TBert","TBert90","TBert180","TBert270","TGoodley","TGoodley90","TGoodley180","TGoodley270","TGull","TGull90","TGull180","TGull270","TLane","TLane90","TLane180","TLane270","TLestrade","TLestrade90","TLestrade180","TLestrade270","TMadame","TMadame90","TMadame180","TMadame270","TPizer","TPizer90","TPizer180","TPizer270","TSmith","TSmith90","TSmith180","TSmith270","TStealthy","TStealthy90","TStealthy180","TStealthy270","Verso","Verso90","Verso180","Verso270","Middle_verso");
			((Button) borderPane.lookup("#button"+Integer.toString(k))).getStyleClass().add(listeTuiles.get(k).getImageAffichee());
		}
	//partie creation des inspecteurs et des boutons associés
		this.Tobi = new Inspecteurs("Tobi");
		this.Sherlock = new Inspecteurs("Sherlock");
		this.Watson = new Inspecteurs("Watson");

		for(int k =1;k<13;k++){
			((Button) borderPane.lookup("#button"+(k<10 ? '0'+Integer.toString(k) : Integer.toString(k)))).getStyleClass().removeAll("Sherlock","Tobi","Watson");
		}
		this.button04.getStyleClass().add("Sherlock");							
		this.button08.getStyleClass().add("Tobi");								
		this.button12.getStyleClass().add("Watson");							
		
		this.tours = 0;
		this.jetonsUtilise = 0;
		nouveauTour();
		this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est en train de jouer");
		this.tuileSelectionne=new ArrayList<Button>();
		//this.listeTuiles.get(1).setAngle(0);
		//appelTemoin();
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
	
	public void finduJeu() {
		System.out.println("GAME OVER");
		if (this.tours==8) {
			this.joueurActu.setText("BRAVO aux inspecteurs qui GAGNENT cette partie");
		}else {
			this.joueurActu.setText("BRAVO à Mr Jack qui GAGNE cette partie");
		};
	}

	@FXML
	public void Validation(ActionEvent e){
		enableTuiles(false);
		utiliserJetons();
	}
	
	public void utiliserJetons(){
		System.out.println("B activé");
		switch(this.jetonsUtilise) {
		
			case 0:
				this.joueurActuel = (this.joueurActuel==this.joueur1 ? this.joueur2 : this.joueur1);
				this.joueurActu.setText("C'est à " + this.joueurActuel.getNom() + " de jouer");
				this.jetonsUtilise++;
				this.bValider.setDisable(true);
				break;
			case 1:
				this.jetonsUtilise++;
				this.bValider.setDisable(true);
				break;
			case 2:
				this.joueurActuel = (this.joueurActuel==this.joueur1 ? this.joueur2 : this.joueur1);
				this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est entrain de jouer");
				this.jetonsUtilise++;
				this.bValider.setDisable(true);
				break;
			case 3:
				this.joueurActuel = (this.joueurActuel==this.joueur1 ? this.joueur2 : this.joueur1);
				this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est entrain de jouer");
				this.jetonsUtilise = 0;
				this.tours++;
				appelTemoin();
				if (this.tours<8 && this.joueur1.getTemps()<8) {nouveauTour();}else {finduJeu();}
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
		button01.setDisable(bool);button02.setDisable(bool);button03.setDisable(bool);button04.setDisable(bool);button05.setDisable(bool);button06.setDisable(bool);button07.setDisable(bool);button08.setDisable(bool);button09.setDisable(bool);button10.setDisable(bool);button11.setDisable(bool);button12.setDisable(bool);
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

		if (reset == 0) {action21.setDisable(true);}else {this.reset=0;} //condition pour le choix des inspecteurs
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
		
		if (reset == 0) {action22.setDisable(true);}else {this.reset=0;} //condition pour le choix des inspecteurs
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
		
		if (reset == 0) {action31.setDisable(true);}else {this.reset=0;} //condition pour le choix des inspecteurs
	}
	
	@FXML
	public void piocherCartes(ActionEvent e) {  // Methode pour piocher une carte alibi apres avoir appuye sur le jeton action piocher 
		this.jetonSelect=32;
		this.pioche.Piocher(this.joueurActuel);
		//for(int k=0;k<this.pioche.getCartes().size();k++){System.out.println(this.pioche.getCartes().get(k).getNom());}
		// If Mr Jack -> Rajouter des sabliers 
		// If Inspecteur -> On innocente le perso pioche et on tourne sa carte
		action32.setDisable(true);
		//this.joueurActuel=(this.jetonsUtilise==1 || this.jetonsUtilise==3 ? (this.joueurActuel == this.joueur1 ? this.joueur2 : this.joueur1) : this.joueurActuel);
		//this.joueurActu.setText("le joueur " + this.joueurActuel.getNom() + " est entrain de jouer");
		utiliserJetons();
	}
	
	@FXML
	public void choixDeplacement(ActionEvent e) {  // Methode pour deplacer au choix un des trois inspecteurs
		this.jetonSelect=41;
		action41.setDisable(true);

		String positionS = this.Sherlock.getPosition();
		String positionW = this.Watson.getPosition();
		String positionT = this.Tobi.getPosition();
		
		((Button) borderPane.lookup("#button"+positionS)).setDisable(false);
		((Button) borderPane.lookup("#button"+positionW)).setDisable(false);
		((Button) borderPane.lookup("#button"+positionT)).setDisable(false);
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
					enableTuiles(false);
					this.tuileSelectionne.clear();
					utiliserJetons();
				}else{
					this.tuileSelectionne.add((Button)e.getSource());
					this.tuileSelectionne.get(0).setDisable(true);
				}
				break;
				
			case 12:
				//tourner Tuiles
				enableTuiles(false);
				((Button)e.getSource()).setDisable(false);
				
				int numeroTuile = ((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-1)-'0';
				int nouvelAngle = (this.listeTuiles.get(numeroTuile).getAngle()+1);
				if (nouvelAngle == 4) {nouvelAngle=0;}
				if (nouvelAngle == 8) {nouvelAngle=4;}
				this.listeTuiles.get(numeroTuile).setAngle(nouvelAngle);
				this.listeTuiles.get(numeroTuile).setImageAffichee(this.listeTuiles.get(numeroTuile).getImage(nouvelAngle));
				
				((Button)e.getSource()).getStyleClass().removeAll(((Button)e.getSource()).getStyleClass().get(2));
				((Button)e.getSource()).getStyleClass().add(this.listeTuiles.get(numeroTuile).getImageAffichee());
				break;
				
			case 21:
				//déplacer Tobi
				String oldPositionTobi = this.Tobi.getPosition();
				String newPositionTobi = Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-2)-'0') + Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-1)-'0');
				this.Tobi.setPosition(newPositionTobi);

				((Button)e.getSource()).getStyleClass().add("Tobi");
				((Button) borderPane.lookup("#button"+oldPositionTobi)).getStyleClass().removeAll("Tobi");
				disableTuilesInspect(true);
				utiliserJetons();
				break;
			case 22:
				//deplacer Watson
				String oldPositionWatson = this.Watson.getPosition();
				String newPositionWatson = Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-2)-'0') + Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-1)-'0');
				this.Watson.setPosition(newPositionWatson);

				((Button)e.getSource()).getStyleClass().add("Watson");
				((Button) borderPane.lookup("#button"+oldPositionWatson)).getStyleClass().removeAll("Watson");
				disableTuilesInspect(true);
				utiliserJetons();
				break;
			case 31:
				// deplacer Sherlock
				String oldPositionSherlock = this.Sherlock.getPosition();
				String newPositionSherlock = Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-2)-'0') + Integer.toString(((Button)e.getSource()).getId().charAt(((Button)e.getSource()).getId().length()-1)-'0');
				this.Sherlock.setPosition(newPositionSherlock);

				((Button)e.getSource()).getStyleClass().add("Sherlock");
				((Button) borderPane.lookup("#button"+oldPositionSherlock)).getStyleClass().removeAll("Sherlock");
				disableTuilesInspect(true);
				utiliserJetons();
				break;
			case 41:
				//choisir inspecteurs
				String nomInspecteur = ((Button)e.getSource()).getStyleClass().get(2);
				if (nomInspecteur.equals("Tobi")){
					this.reset=1;
					this.action21.fire();
				}else if(nomInspecteur.equals("Sherlock")){
					this.reset=1;
					this.action31.fire();
				}else{
					this.reset=1;
					this.action22.fire();
				}
				break;	
		}
		
	}

	public void appelTemoin(){
		/**Réalise l'appel à témoin */
		//On parcourt les positions des inspecteurs et on regarde suivant leur position si la tuile est visible et si Mr est sur cette carte donc visible
		String[] positionInsp = {this.Watson.getPosition(), this.Tobi.getPosition(), this.Sherlock.getPosition()};
		ArrayList<Tuiles> tuilesVisibles = new ArrayList<Tuiles>();
		boolean mrJackVisible = false;
		for (int k=0; k<3;k++){
			switch (Integer.parseInt(positionInsp[k])) {
				case 1:
					if (this.listeTuiles.get(1).getMur() !=2){
						tuilesVisibles.add(this.listeTuiles.get(1));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(1).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(1).getMur() !=0 && this.listeTuiles.get(8).getMur() !=2){
							tuilesVisibles.add(this.listeTuiles.get(8));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(8).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(8).getMur() !=0 && this.listeTuiles.get(7).getMur() !=2){
								tuilesVisibles.add(this.listeTuiles.get(7));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(7).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 2:
					if (this.listeTuiles.get(2).getMur() !=2){
						tuilesVisibles.add(this.listeTuiles.get(2));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(2).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(2).getMur() !=0 && this.listeTuiles.get(0).getMur() !=2){
							tuilesVisibles.add(this.listeTuiles.get(0));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(0).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(0).getMur() !=0 && this.listeTuiles.get(6).getMur() !=2){
								tuilesVisibles.add(this.listeTuiles.get(6));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(6).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 3:
					if (this.listeTuiles.get(3).getMur() !=2){
						tuilesVisibles.add(this.listeTuiles.get(3));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(3).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(3).getMur() !=0 && this.listeTuiles.get(4).getMur() !=2){
							tuilesVisibles.add(this.listeTuiles.get(4));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(4).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(4).getMur() !=0 && this.listeTuiles.get(5).getMur() !=2){
								tuilesVisibles.add(this.listeTuiles.get(5));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(5).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 4:
					if (this.listeTuiles.get(3).getMur() !=3){
						tuilesVisibles.add(this.listeTuiles.get(3));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(3).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(3).getMur() !=1 && this.listeTuiles.get(2).getMur() !=3){
							tuilesVisibles.add(this.listeTuiles.get(2));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(2).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(2).getMur() !=1 && this.listeTuiles.get(1).getMur() !=3){
								tuilesVisibles.add(this.listeTuiles.get(1));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(1).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 5:
					if (this.listeTuiles.get(4).getMur() !=3){
						tuilesVisibles.add(this.listeTuiles.get(4));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(4).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(4).getMur() !=1 && this.listeTuiles.get(0).getMur() !=3){
							tuilesVisibles.add(this.listeTuiles.get(0));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(0).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(0).getMur() !=1 && this.listeTuiles.get(8).getMur() !=3){
								tuilesVisibles.add(this.listeTuiles.get(8));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(8).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 6:
					if (this.listeTuiles.get(5).getMur() !=3){
						tuilesVisibles.add(this.listeTuiles.get(5));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(5).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(5).getMur() !=1 && this.listeTuiles.get(6).getMur() !=3){
							tuilesVisibles.add(this.listeTuiles.get(6));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(6).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(6).getMur() !=1 && this.listeTuiles.get(7).getMur() !=3){
								tuilesVisibles.add(this.listeTuiles.get(7));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(7).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 7:
					if (this.listeTuiles.get(5).getMur() !=0){
						tuilesVisibles.add(this.listeTuiles.get(5));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(5).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(5).getMur() !=2 && this.listeTuiles.get(4).getMur() !=0){
							tuilesVisibles.add(this.listeTuiles.get(4));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(4).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(4).getMur() !=2 && this.listeTuiles.get(3).getMur() !=0){
								tuilesVisibles.add(this.listeTuiles.get(3));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(3).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 8:
					if (this.listeTuiles.get(6).getMur() !=0){
						tuilesVisibles.add(this.listeTuiles.get(6));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(6).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(6).getMur() !=2 && this.listeTuiles.get(0).getMur() !=0){
							tuilesVisibles.add(this.listeTuiles.get(0));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(0).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(0).getMur() !=2 && this.listeTuiles.get(2).getMur() !=0){
								tuilesVisibles.add(this.listeTuiles.get(2));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(2).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 9:
					if (this.listeTuiles.get(7).getMur() !=0){
						tuilesVisibles.add(this.listeTuiles.get(7));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(7).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(7).getMur() !=2 && this.listeTuiles.get(8).getMur() !=0){
							tuilesVisibles.add(this.listeTuiles.get(8));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(8).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(8).getMur() !=2 && this.listeTuiles.get(1).getMur() !=0){
								tuilesVisibles.add(this.listeTuiles.get(1));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(1).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 10:
					if (this.listeTuiles.get(7).getMur() !=1){
						tuilesVisibles.add(this.listeTuiles.get(7));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(7).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(7).getMur() !=3 && this.listeTuiles.get(6).getMur() !=1){
							tuilesVisibles.add(this.listeTuiles.get(6));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(6).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(6).getMur() !=3 && this.listeTuiles.get(5).getMur() !=1){
								tuilesVisibles.add(this.listeTuiles.get(5));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(5).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 11:
					if (this.listeTuiles.get(8).getMur() !=1){
						tuilesVisibles.add(this.listeTuiles.get(8));
						mrJackVisible = (!mrJackVisible && this.listeTuiles.get(8).getImage(0).equals("T"+joueur1.getAlibi()));
						if (this.listeTuiles.get(8).getMur() !=3 && this.listeTuiles.get(0).getMur() !=1){
							tuilesVisibles.add(this.listeTuiles.get(0));
							mrJackVisible = (!mrJackVisible && this.listeTuiles.get(0).getImage(0).equals("T"+joueur1.getAlibi()));
							if (this.listeTuiles.get(0).getMur() !=3 && this.listeTuiles.get(4).getMur() !=1){
								tuilesVisibles.add(this.listeTuiles.get(4));
								mrJackVisible = (!mrJackVisible && this.listeTuiles.get(4).getImage(0).equals("T"+joueur1.getAlibi()));
							}
						}
					}
					break;
				case 12:
					if (this.listeTuiles.get(1).getMur() !=1){
						tuilesVisibles.add(this.listeTuiles.get(1));
						mrJackVisible = (mrJackVisible==false ? this.listeTuiles.get(1).getImage(0).equals("T"+joueur1.getAlibi()) : true);
						if (this.listeTuiles.get(1).getMur() !=3 && this.listeTuiles.get(2).getMur() !=1){
							tuilesVisibles.add(this.listeTuiles.get(2));
							mrJackVisible = (mrJackVisible==false ? this.listeTuiles.get(2).getImage(0).equals("T"+joueur1.getAlibi()) : true);
							if (this.listeTuiles.get(2).getMur() !=3 && this.listeTuiles.get(3).getMur() !=1){
								tuilesVisibles.add(this.listeTuiles.get(3));
								mrJackVisible = (mrJackVisible==false ? this.listeTuiles.get(3).getImage(0).equals("T"+joueur1.getAlibi()) : true);
							}
						}
					}
					break;
				default:
					System.out.println("erreur appelTemoin");
			}
		}
		String ancienneImage;
		if (!mrJackVisible){
			for (int k =0; k<tuilesVisibles.size();k++){
				if(tuilesVisibles.get(k).getAngle()<4){	
					tuilesVisibles.get(k).setAngle(tuilesVisibles.get(k).getAngle()+4);
					ancienneImage = tuilesVisibles.get(k).getImageAffichee();
					tuilesVisibles.get(k).setImageAffichee(tuilesVisibles.get(k).getImage(tuilesVisibles.get(k).getAngle()));
					((Button) borderPane.lookup("#button"+ Integer.toString(tuilesVisibles.get(k).getPosition()))).getStyleClass().removeAll(ancienneImage);
					((Button) borderPane.lookup("#button"+ Integer.toString(tuilesVisibles.get(k).getPosition()))).getStyleClass().addAll(tuilesVisibles.get(k).getImageAffichee());
				}
			}
		}else{
			for (int k =0;k<listeTuiles.size();k++){
				if(!tuilesVisibles.contains(listeTuiles.get(k))){
					listeTuiles.get(k).setAngle(listeTuiles.get(k).getAngle()+4);
					ancienneImage = listeTuiles.get(k).getImageAffichee();
					listeTuiles.get(k).setImageAffichee(listeTuiles.get(k).getImage(listeTuiles.get(k).getAngle()));
					((Button) borderPane.lookup("#button"+ Integer.toString(listeTuiles.get(k).getPosition()))).getStyleClass().removeAll(ancienneImage);
					((Button) borderPane.lookup("#button"+ Integer.toString(listeTuiles.get(k).getPosition()))).getStyleClass().addAll(listeTuiles.get(k).getImageAffichee());
				}
			}
			this.joueur1.addTemps(1);
		}
		tuilesVisibles.clear();
		System.out.println("temps : "+this.joueur1.getTemps());
	}

	private static int RandInt(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");}
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
	}
	
	
}
