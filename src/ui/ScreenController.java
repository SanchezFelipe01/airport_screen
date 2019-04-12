package ui;

import java.io.IOException;
import java.time.LocalTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
    private TextField sHour;
    
    @FXML
    private TextField sMinutes;
    
    @FXML
    private TextField ampm;
    
    @FXML
    private TextField value;

    @FXML
    void newList(ActionEvent event) throws IOException {
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
    	VBox vbox = new VBox();
    	Label l = new Label();
    	String i = value.getText();
    	Long time1 = System.currentTimeMillis();
    	l.setText(airport.print(airport.searchByAirLine(i)));
    	Long time2 = System.currentTimeMillis();
    	vbox.getChildren().add(l);
    	
    	String st = String.valueOf(time2-time1);
    	time.setText(st);
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void searchByDate(ActionEvent event) {
    	VBox vbox = new VBox();
    	Label l;   	
    	l = new Label();
    	Long time1 = System.currentTimeMillis();
    	l.setText(airport.searchByDate(value.getText()));
    	Long time2 = System.currentTimeMillis();
    	vbox.getChildren().add(l);
    	
    	String st = String.valueOf(time2-time1);
    	time.setText(st);
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void searchByDestiny(ActionEvent event) {
    	VBox vbox = new VBox();
    	Label l = new Label();
    	String i = value.getText();
    	Long time1 = System.currentTimeMillis();
    	l.setText(airport.print(airport.searchByDestiny(i)));
    	Long time2 = System.currentTimeMillis();
    	vbox.getChildren().add(l);
    	
    	String st = String.valueOf(time2-time1);
    	time.setText(st);
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void searchByFlight(ActionEvent event) {
    	VBox vbox = new VBox();
    	
    	Label l;
    	
    	l = new Label();
    	Long time1 = System.currentTimeMillis();
    	l.setText(airport.searchByFlightNumber(value.getText()));
    	Long time2 = System.currentTimeMillis();
    	vbox.getChildren().add(l);
    	
    	String st = String.valueOf(time2-time1);
    	time.setText(st);
    	
    	scrollPane.setContent(vbox);
    }

    @FXML
    void searchByTime(ActionEvent event) {
    	VBox vbox = new VBox();
    	
    	Label l;
    	
    	l = new Label();
    	int h = Integer.valueOf(sHour.getText());
    	int m = Integer.valueOf(sMinutes.getText());
    	String d = ampm.getText();
    	Long time1 = System.currentTimeMillis();
    	l.setText(airport.searchByHour(h, m, d));
    	Long time2 = System.currentTimeMillis();
    	vbox.getChildren().add(l);
    	
    	String st = String.valueOf(time2-time1);
    	time.setText(st);
    	
    	scrollPane.setContent(vbox);
    }
    
    @FXML
    void SearchByGate(ActionEvent event) {
    	VBox vbox = new VBox();
    	Label l = new Label();
    	int i = Integer.valueOf(value.getText());
    	Long time1 = System.currentTimeMillis();
    	l.setText(airport.print(airport.searchByGate(i)));
    	Long time2 = System.currentTimeMillis();
    	vbox.getChildren().add(l);
    	
    	String st = String.valueOf(time2-time1);
    	time.setText(st);
    	
    	scrollPane.setContent(vbox);
    }
    
    @FXML
    public void initialize() throws IOException {
    	convertedHour();
    	airport = new Airport(100);
    	airport.sortByHour();
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
