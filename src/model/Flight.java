package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Random;

public class Flight implements Comparable<Flight>{
	
	private String date;
	private LocalTime hour;
	private String airLine;
	private String nFlight;
	private String destiny;
	private int gate;
	
	public final static String PATH_AIRLINES = "Data/Airlines.txt";
	public final static String PATH_CITIES = "Data/Cities.txt";
	
	
	public Flight() throws IOException {
		
		randomDate();
		randomTime();
		randomAirLine1();
		this.nFlight = randomFlight();
		randomDestiny();
		this.gate = (int)(Math.random()* 10) + 1;
	}
	
	private void randomAirLine1() throws IOException {
		FileReader fr = new FileReader(new File(PATH_AIRLINES));
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String[] parts = new String[17];
		while(line != null) {
			parts = line.split(" ");	
			
			line = br.readLine();
		}
		
		Random r = new Random();
		
		int i = r.nextInt(17);
		
		this.airLine = parts[i];
		
		br.close();
		fr.close();
	}
	
	private String randomFlight() {
		String number = "";
		Random r = new Random();
		
		for (int i = 0; i < 5; i++) {
			if (i < 2) {
				number += (char)(r.nextInt(26) + 65);
			}else {
				number += r.nextInt(10);
			}
		}
		
		return number;
	}
	
	private void randomDestiny() throws IOException {
		FileReader fr = new FileReader(new File(PATH_CITIES));
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		String[] parts = new String[90];
		while(line != null) {
			parts = line.split(" ");	
			
			line = br.readLine();
		}
		
		Random r = new Random();
		
		int i = r.nextInt(90);
		
		this.destiny = parts[i];
		
		br.close();
		fr.close();
	}
	
	public void randomDate() {
		Random r = new Random();

        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set (r.nextInt(3)+2018, r.nextInt(12)+1, r.nextInt(30)+1);
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        this.date = sdf.format(unaFecha.getTime());
	}
	
	public void randomTime() {
		
		Random random = new Random();
		
		LocalTime time = LocalTime.of(random.nextInt(24), random.nextInt(60), random.nextInt(60));
		this.hour = time;
	}
	
	public String getDate() {
		return date;
	}

	public LocalTime getHour() {
		return hour;
	}

	public String getAirLine() {
		return airLine;
	}

	public String getnFlight() {
		return nFlight;
	}

	public String getDestiny() {
		return destiny;
	}

	public int getGate() {
		return gate;
	}
	
	public String getConvertedHour() {
		String hour1 = "";
		LocalTime lt = hour;
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
    	hour1 = h + ":" + m + " " + p;
    	
    	return hour1;
	}

	@Override
	public int compareTo(Flight otherFlight) {
		int comparation;
		if(airLine.compareTo(otherFlight.airLine)<0) {
			comparation = -1;
		}else if(airLine.compareTo(otherFlight.airLine)>0) {
			comparation = 1;
		}else {
			comparation = 0;
		}
		return comparation;
	}
	
}
