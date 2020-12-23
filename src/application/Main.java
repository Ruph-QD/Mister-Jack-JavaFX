package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
		primaryStage.setTitle("Mr Jack Pocket");

		Scene Mainscene = new Scene(root);
		Mainscene.getStylesheets().add(getClass().getResource("application.css").toString());

		primaryStage.setScene(Mainscene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
