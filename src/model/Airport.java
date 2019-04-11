package model;

import java.util.Arrays;

public class Airport {
	
	private Flight[] flights;
	
//___________________________________________________________________________________
	
	public Airport(int n) {
		flights = new Flight[n];

		for (int i = 0; i < flights.length; i++) {
			flights[i] = new Flight();
		}
		
	}
	
//______________________________________________________________________________________
	
	public Flight[] getFlights() {
		return flights;
	}
	
//________________________________________________________________________________________
	
	public void sortByDate() { //Selection Sorting
		for (int I = 0; I < flights.length-1; I++) {
			String date = flights[I].getDate();
			int minPosition = I;
			
			for (int J = I+1; J < flights.length; J++) {
				String currentDate = flights[J].getDate();
				if(currentDate.compareTo(date) < 0) {
					date = currentDate;
					minPosition = J;
				}
			}
			
			Flight temp = flights[minPosition];
			flights[minPosition] = flights[I];
			flights[I] = temp;
		}
	}
	
//____________________________________________________________________________________________
	
	public void sortByHour() { //Insertion sorting
		
		for (int I = 1; I < flights.length; I++) {
			for (int J = I; J > 0 && flights[J-1].getHour().compareTo(flights[J].getHour()) == 1; J--) {
				Flight temp = flights[J];
				flights[J] = flights[J-1];
				flights[J-1] = temp;
			}
		}
		
	}
//_________________________________________________________________________________________
	
	public void sortByGate() { //Bubble sorting 
		
		for(int i = 0; i < flights.length - 1; i++)
        {
            for(int j = 0; j < flights.length - 1; j++)
            {
                if (flights[j].getGate() > flights[j + 1].getGate())
                {
                    Flight temp = flights[j+1];
                    flights[j+1] = flights[j];
                    flights[j] = temp;
                }
            }
        }      
		
	}
	
//_________________________________________________________________________________________
	
	public void sortByAirLine() {
		
		Arrays.sort(flights);
		
	}
//_________________________________________________________________________________________
	
	public void sortByFlightNumber() {
		
		Arrays.sort(flights,new FlightsNumberComparator());
		
	}
	
//__________________________________________________________________________________________
	
	public void sortByDestiny() {
		Arrays.sort(flights,new FlightsDestinyComparator());
	}
	
//___________________________________________________________________________________________
	
	public String report() {
		String msg = "DATE		HOUR		AIRLINE		FLIGHT		DESTINY		GATE" + "\n";
		
		for (int i = 0; i < flights.length; i++) {
			msg += flights[i].getDate() + "\t" + flights[i].getConvertedHour() + "\t\t" + flights[i].getAirLine() + "\t\t" + flights[i].getnFlight() + "\t\t" + flights[i].getDestiny() + "\t\t" + flights[i].getGate() + "\n";
		}
		
		return msg;
		
	}
	
}
