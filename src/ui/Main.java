package ui;

import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Airport;

public class Main extends Application{
	

	public static void main(String[] args) throws IOException {
		/*Airport a = new Airport(10);
		System.out.println(a.report());
		Scanner s = new Scanner(System.in);
		String i = s.nextLine();
		a.print(a.searchByDestiny(i));*/
		launch(args);
		
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