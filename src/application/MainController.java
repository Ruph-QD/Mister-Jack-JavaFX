package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable{
	@FXML private BorderPane borderPane;
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

	private Plateau plateau;
	private ArrayList<Tuiles> listeTuiles;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1){
		/**Initialisation du projet */
		disableAll();
	}
	
	public void pushed(ActionEvent e) {
		/**Lorsqu'on appuie sur un bouton qui a la méthode pushed */
		System.out.println("yop");
	}

	public void nouvellePartie(ActionEvent e) {
		/**Lance une nouvelle partie */
		disableAll() ; 
		this.plateau = new Plateau(); 						//créer le plateau
		this.listeTuiles = this.plateau.getPlateau();
		for (Tuiles tuile : this.listeTuiles){				//parcours les tuiles du plateau
			switch (tuile.getPosition()) {
				/*
					les différents case servent à identifier le bouton auquel il faut changer le style
					on est obligé de remove tous les style possible
					puis d'ajouter le style souhaité
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


		this.button04.getStyleClass().add("Sherlock");							//on ajoute sherlock
		this.button08.getStyleClass().add("Tobi");								//on ajoute Tobi
		this.button12.getStyleClass().add("Watson");							//on ajoute watson
	}
	public void disableAll(){
		/**Disable tous les bouton du plateau */
		button0.setDisable(true);
		button1.setDisable(true);
		button2.setDisable(true);
		button3.setDisable(true);
		button3.setDisable(true);
		button4.setDisable(true);
		button5.setDisable(true);
		button6.setDisable(true);
		button7.setDisable(true);
		button8.setDisable(true);
		button01.setDisable(true);
		button02.setDisable(true);
		button03.setDisable(true);
		button04.setDisable(true);
		button05.setDisable(true);
		button06.setDisable(true);
		button07.setDisable(true);
		button08.setDisable(true);
		button09.setDisable(true);
		button10.setDisable(true);
		button11.setDisable(true);
		button12.setDisable(true);
	}

	public void tournerTuiles(ActionEvent e){
		
		
	}
}


