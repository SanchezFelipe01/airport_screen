package model;

import java.util.Comparator;

public class FlightsNumberComparator implements Comparator<Flight>{

	@Override
	public int compare(Flight flight1, Flight flight2) {
		int comparation;
		String n1 = flight1.getnFlight();
		String n2 = flight2.getnFlight();
		
		if(n1.compareTo(n2)<0) {
			comparation = -1;
		}else if(n1.compareTo(n2)>0) {
			comparation = 1;
		}else {
			comparation = 0;
		}
			
		return comparation;
	}

}
