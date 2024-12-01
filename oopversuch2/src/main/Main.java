package main;


import gui.FahrradControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new FahrradControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
