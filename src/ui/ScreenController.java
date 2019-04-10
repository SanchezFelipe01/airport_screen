package ui;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ScreenController {
	
	@FXML
	private GridPane gridPane;
	
	@FXML
	private ScrollPane scrollPane;
	
    @FXML
    private Label hour;

    @FXML
    private TextField newNumber;

    @FXML
    void SortByGate(ActionEvent event) {

    }

    @FXML
    void newList(ActionEvent event) {
    	initialize();
    }

    @FXML
    void sortByAirline(ActionEvent event) {

    }

    @FXML
    void sortByDate(ActionEvent event) {

    }

    @FXML
    void sortByDestiny(ActionEvent event) {

    }

    @FXML
    void sortByFlight(ActionEvent event) {

    }

    @FXML
    void sortByTime(ActionEvent event) {

    }
    
    @FXML
    public void initialize() {
    	convertedHour();
    }
    
    public void convertedHour() {
    	LocalTime lt = LocalTime.now();
    	String p = "AM";
    	String h = "";
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
