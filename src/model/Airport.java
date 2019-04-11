package model;

import java.io.IOException;
import java.util.Arrays;

public class Airport {
	
	private Flight[] flights;
	
//___________________________________________________________________________________
	
	public Airport(int n) throws IOException {
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
		String msg = "DATE		HOUR		AIRLINE			FLIGHT		DESTINY		GATE" + "\n";
		
		for (int i = 0; i < flights.length; i++) {
			msg += flights[i].getDate() + "\t" + flights[i].getConvertedHour() + "\t\t" + flights[i].getAirLine() + "\t\t\t" + flights[i].getnFlight() + "\t\t" + flights[i].getDestiny() + "\t\t" + flights[i].getGate() + "\n";
		}
		
		return msg;
		
	}

//__________________________________________________________________________________________
	
	public String searchByDate(String date) {
		
		String msg = "Can not find the flight";
		Flight flight;
		int index = -1;
		boolean found = false;
		
		for(int I = 0; I < flights.length && found == false; I++) {
        	if (flights[I].getDate().equals(date)) {
				index = I;
				found = true;
			}
     
        }
		
		if (index != -1) {
			
			flight = flights[index];
			msg = flight.getDate() + "\t" + flight.getHour() + "\t" + flight.getAirLine() + "\t" + flight.getnFlight() + "\t" + flight.getDestiny() + "\t" + flight.getGate();
		}
		return msg;
		
	}
//_____________________________________________________________________________________________
	
	public String searchByHour(int h, int m) {
		String msg = "Can not find the flight";
		Flight flight;
		int index = -1;
		boolean found = false;
		
		for(int I = 0; I < flights.length && found == false; I++) {
        	if (flights[I].getHour().getHour() == h && flights[I].getHour().getMinute() == m) {
				index = I;
				found = true;
			}
     
        }
		
		if (index != -1) {
		
			flight = flights[index];
			msg = flight.getDate() + "\t" + flight.getHour() + "\t" + flight.getAirLine() + "\t" + flight.getnFlight() + "\t" + flight.getDestiny() + "\t" + flight.getGate();
		}

		return msg;
	}
//_____________________________________________________________________________________________
	
	public String searchByGate(int gate) {
		
		sortByGate();
		
		String msg = "Can not find the flight";
		Flight flight;
		int index = -1;
		
		int low = 0;
        int high = flights.length-1;
        
        while (low<=high) {
			
        	int mid = (low+high) / 2;
        	if (flights[mid].getGate() < gate) {
				low = mid + 1;
			}else if (flights[mid].getGate() > gate) {
				high = mid - 1;				
			}else {
				index = mid;
			}
		}
        
        if (index != -1) {
			
        	flight = flights[index];
        	msg = flight.getDate() + "\t" + flight.getHour() + "\t" + flight.getAirLine() + "\t" + flight.getnFlight() + "\t" + flight.getDestiny() + "\t" + flight.getGate();
        	System.out.println(msg);
        }
        return msg;
	}
//_______________________________________________________________________________________________
	
	public String searchByAirLine(String airLine) {
		sortByAirLine();
		String msg = "Can not find the flight";
		Flight flight;
		int index = -1;
		
		int low = 0;
        int high = flights.length-1;
        
        while (low<=high) {
			
        	int mid = (low+high) / 2;
        	if (flights[mid].getAirLine().compareTo(airLine) < 0) {
				low = mid + 1;
			}else if (flights[mid].getAirLine().compareTo(airLine) > 0) {
				high = mid - 1;				
			}else {
				index = mid;
			}
		}
        
        if (index != -1) {
			
        	flight = flights[index];
        	msg = flight.getDate() + "\t" + flight.getHour() + "\t" + flight.getAirLine() + "\t" + flight.getnFlight() + "\t" + flight.getDestiny() + "\t" + flight.getGate();
        
        }
        System.out.println(msg);
        return msg;
	}
//________________________________________________________________________________________________
	
	public String searchByDestiny(String destiny) {
		
		sortByDestiny();
		
		String msg = "Can not find the flight";
		Flight flight;
		int index = -1;
		
		int low = 0;
        int high = flights.length-1;
        
        while (low<=high) {
			
        	int mid = (low+high) / 2;
        	if (flights[mid].getDestiny().compareTo(destiny) < 0) {
				low = mid + 1;
			}else if (flights[mid].getDestiny().compareTo(destiny) > 0) {
				high = mid - 1;				
			}else {
				index = mid;
			}
		}
        
        if (index != -1) {
			
        	flight = flights[index];
        	msg = flight.getDate() + "\t" + flight.getHour() + "\t" + flight.getAirLine() + "\t" + flight.getnFlight() + "\t" + flight.getDestiny() + "\t" + flight.getGate();
        
        }
        System.out.println(msg);
        return msg;
		
	}
//________________________________________________________________________________________________
	
	public String searchByFlightNumber(String flightNumber) {
		
		String msg = "Can not find the flight";
		Flight flight;
		int index = -1;
		boolean found = false;
		
		for(int I = 0; I < flights.length && found == false; I++) {
        	if (flights[I].getnFlight().equalsIgnoreCase(flightNumber)) {
				index = I;
				found = true;
			}
     
        }
		
		if (index != -1) {
			
			flight = flights[index];
			msg = flight.getDate() + "\t" + flight.getHour() + "\t" + flight.getAirLine() + "\t" + flight.getnFlight() + "\t" + flight.getDestiny() + "\t" + flight.getGate();
			
		}
		
		return msg;
	}
//________________________________________________________________________________________________
}














