package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// on charge le fichier fxml
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		primaryStage.setTitle("Mr Jack Pocket");
		// on charge le fichier css
		Scene Mainscene = new Scene(root);
		Mainscene.getStylesheets().add(getClass().getResource("application.css").toString());
		// on affiche la fenetre
		primaryStage.setScene(Mainscene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
