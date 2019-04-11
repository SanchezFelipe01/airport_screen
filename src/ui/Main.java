package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Airport;

public class Main extends Application{
	

	public static void main(String[] args) {
		Airport a = new Airport(10);
		System.out.println(a.report());
		a.sortByDestiny();
		//a.sortByFlightNumber();
		//a.sortByAirLine();
		//a.sortByGate();
		//a.sortByHour();
		//a.sortByDate();
		System.out.println(a.report());
		//launch(args);
		
	}
	
	@Override
	public void start(Stage stage)throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("Screen.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Airport");
		stage.setScene(scene);
		stage.show();
	}

}