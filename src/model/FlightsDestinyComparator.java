package model;

import java.util.Comparator;

public class FlightsDestinyComparator implements Comparator<Flight>{

	@Override
	public int compare(Flight flight1, Flight flight2) {
		int comparation;
		String d1 = flight1.getDestiny();
		String d2 = flight2.getDestiny();
		
		if(d1.compareTo(d2)<0) {
			comparation = -1;
		}else if(d1.compareTo(d2)>0) {
			comparation = 1;
		}else {
			comparation = 0;
		}
			
		return comparation;
	}

}