package model;

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
	
	
	
//_________________________________________________________________________________________
	
	public String report() {
		String msg = "DATE		HOUR		AIRLINE		FLIGHT		DESTINY		GATE" + "\n";
		
		for (int i = 0; i < flights.length; i++) {
			msg += flights[i].getDate() + "\t" + flights[i].getConvertedHour() + "\t\t" + flights[i].getAirLine() + "\t\t" + flights[i].getnFlight() + "\t\t" + flights[i].getDestiny() + "\t\t" + flights[i].getGate() + "\n";
		}
		
		return msg;
		
	}
	
}
