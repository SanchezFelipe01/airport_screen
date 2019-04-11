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
    private Label time;
	
	@FXML
	private ScrollPane scrollPane;
	
    @FXML
    private Label hour;

    @FXML
    private TextField newNumber;

    @FXML
    void newList(ActionEvent event) {
    	convertedHour();
    	int n = Integer.valueOf(newNumber.getText());
    	airport = new Airport(n);
    	
    	airport.sortByDate();
    	VBox vbox = new VBox();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
    	
    	scrollPane.setContent(vbox);
    }
    
    @FXML
    void SortByGate(ActionEvent event) {
    	
    	convertedHour();
    	Long time1 = System.currentTimeMillis();
    	airport.sortByGate();
    	Long time2 = System.currentTimeMillis();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
		String st = String.valueOf(time2-time1);
		
    	time.setText(st);
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByAirline(ActionEvent event) {
    	convertedHour();
    	Long time1 = System.currentTimeMillis();
    	airport.sortByAirLine();
    	Long time2 = System.currentTimeMillis();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
		String st = String.valueOf(time2-time1);
		
    	time.setText(st);
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByDate(ActionEvent event) {
    	convertedHour();
    	Long time1 = System.currentTimeMillis();
    	airport.sortByDate();
    	Long time2 = System.currentTimeMillis();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
		String st = String.valueOf(time2-time1);
    	
		time.setText(st);
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByDestiny(ActionEvent event) {
    	convertedHour();
    	Long time1 = System.currentTimeMillis();
    	airport.sortByDestiny();
    	Long time2 = System.currentTimeMillis();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
		String st = String.valueOf(time2-time1);
    	
		time.setText(st);
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByFlight(ActionEvent event) {
    	convertedHour();
    	Long time1 = System.currentTimeMillis();
    	airport.sortByFlightNumber();
    	Long time2 = System.currentTimeMillis();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
		String st = String.valueOf(time2-time1);
		
    	time.setText(st);
    	scrollPane.setContent(vbox);
    }

    @FXML
    void sortByTime(ActionEvent event) {
    	convertedHour();
    	Long time1 = System.currentTimeMillis();
    	airport.sortByHour();
    	Long time2 = System.currentTimeMillis();
    	VBox vbox = new VBox();
    	vbox.getChildren().clear();
    	Label l;
    	
    	l = new Label();
    	l.setText(airport.report());
		vbox.getChildren().add(l);
		
		String st = String.valueOf(time2-time1);
    	
		time.setText(st);
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
