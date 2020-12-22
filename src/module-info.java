module Test {
	requires javafx.controls;
	requires javafx.fxml;
	
	requires transitive javafx.base;
	requires transitive javafx.graphics;
	
	opens application to javafx.fxml;
	exports application to javafx.graphics;
}