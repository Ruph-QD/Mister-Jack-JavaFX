package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class MainController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	public void pushed(ActionEvent e) {
		System.out.println("yop");
	}

}
