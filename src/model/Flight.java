package model;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Random;

public class Flight {
	
	private String date;
	private LocalTime hour;
	private String airLine;
	private String nFlight;
	private String Destiny;
	private int gate;
	
	public final static String AVIANCA = "Avianca";
	public final static String LAN = "Lan";
	public final static String IBERIA = "Iberia";
	public final static String FLY = "Fly";
	
	public final static String BOGOTA = "Bogota";
	public final static String MIAMI = "Miami";
	public final static String MADRID = "Madrid";
	public final static String TOKIO = "Tokio";
	public final static String NEWYORK = "New York";
	public final static String DUBAI = "Dubai";
	public final static String PARIS = "Paris";
	public final static String BERLIN = "Berlin";
	
	
	public Flight() {
		
		randomDate();
		randomTime();
		this.airLine = randomAirLine();
		this.nFlight = randomFlight();
		this.Destiny = randomDestiny();
		this.gate = (int)(Math.random()* 10) + 1;
	}
	
	private String randomAirLine() {
		String airLine = "";
		int i = (int)(Math.random()*4) + 1;
		switch (i) {
		case 1:
			airLine = AVIANCA;
			break;
		
		case 2:
			airLine = LAN;
			break;
			
		case 3:
			airLine = IBERIA;
			break;
			
		case 4: 
			airLine = FLY;
			break;

		default:
			break;
		}
		
		return airLine;
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
	
	private String randomDestiny() {
		String city = "";
		int i = (int)(Math.random()*4) + 1;
		switch (i) {
		case 1:
			city = BOGOTA;
			break;
		
		case 2:
			city = MIAMI;
			break;
			
		case 3:
			city = MADRID;
			break;
			
		case 4: 
			city = TOKIO;
			break;
		
		case 5:
			city = NEWYORK;
			break;
		
		case 6:
			city = DUBAI;
			break;
			
		case 7:
			city = PARIS;
			break;
			
		case 8: 
			city = BERLIN;
			break;

		default:
			break;
		}
		
		return city;
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
		return Destiny;
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
	
}
