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
	}
	
	public void pushed(ActionEvent e) {
		System.out.println("yop");
	}

	public void nouvellePartie(ActionEvent e) {
		this.plateau = new Plateau();
		this.listeTuiles = this.plateau.getPlateau();
		//this.button0.setStyle("-fx-background-image: url('TBert.png');");
		//this.button0.getStyleClass().add("TStealthy");
		for (Tuiles tuile : this.listeTuiles){			
			System.out.println(tuile.getImageAffichee());
			switch (tuile.getPosition()) {
				case 0:
					this.button0.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button0.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					break;
				case 1:
					this.button1.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button1.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					break;
				case 2:
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					this.button2.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button2.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					break;
				case 3:
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					this.button3.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button3.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					break;
				case 4:
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					this.button4.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button4.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					break;
				case 5:
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					this.button5.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button5.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					break;
				case 6:
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					this.button6.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button6.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					break;
				case 7:
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					this.button7.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button7.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					break;
				case 8:
					//this.button0.setStyle("-fx-background-image: url("+tuile.getImageAffichee()+");-fx-background-size: cover;");
					this.button8.getStyleClass().removeAll("TBert","TGoodley","TGull","TLane","TLestrade","TMadame","TPizer","TSmith","TStealthy");
					this.button8.getStyleClass().add(tuile.convert(tuile.getImageAffichee()));
					break;
			}
		}
		System.out.println("finis");
	}

}
