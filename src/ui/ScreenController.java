package ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Airport;

public class ScreenController {
	
	private Airport airport;
	
	@FXML
	private ScrollPane scrollPane;
	
    @FXML
    private Label hour;

    @FXML
    private TextField newNumber;

    @FXML
    void SortByGate(ActionEvent event) {
    	
    	convertedHour();
    	airport.sortByGate();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void newList(ActionEvent event) {
    	convertedHour();
    }

    @FXML
    void sortByAirline(ActionEvent event) {
    	convertedHour();
    	airport.sortByAirLine();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByDate(ActionEvent event) {
    	convertedHour();
    	airport.sortByDate();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByDestiny(ActionEvent event) {
    	convertedHour();
    	airport.sortByDestiny();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByFlight(ActionEvent event) {
    	convertedHour();
    	airport.sortByFlightNumber();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByTime(ActionEvent event) {
    	convertedHour();
    	airport.sortByHour();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
    	
    	scrollPane.setContent(vbox);
    }
    
    @FXML
    void searchByAirline(ActionEvent event) {

    }

    @FXML
    void searchByDate(ActionEvent event) {

    }

    @FXML
    void searchByDestiny(ActionEvent event) {

    }

    @FXML
    void searchByFlight(ActionEvent event) {

    }

    @FXML
    void searchByTime(ActionEvent event) {

    }
    
    @FXML
    void SearchByGate(ActionEvent event) {

    }
    
    @FXML
    public void initialize() {
    	convertedHour();
    	airport = new Airport(100);
    	airport.sortByDate();
    	VBox vbox = new VBox();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
    	
    	scrollPane.setContent(vbox);
    	
    }
    
    public void convertedHour() {
    	LocalTime lt = LocalTime.now();
    	String p = "AM";
    	String h = String.valueOf(lt.getHour());
    	String m = String.valueOf(lt.getMinute());
    	
    	if (lt.getHour() > 12) {
			p = "PM";
			h = String.valueOf(lt.getHour()-12);
		}
    	if (lt.getMinute() < 10) {
			m = "0" + String.valueOf(lt.getMinute());
		}
    	hour.setText(h + ":" + m + " " + p);
    }
    

}
