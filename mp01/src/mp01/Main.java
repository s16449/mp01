package mp01;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Main {

	public static void main(String[] args) {
		
		Klient kl = new Klient("Mariusz", "Polak", "505-082-694", "mariuszpolak83@gmail.com", new Adres("Ry¿owa 48","Warszawa","02-442"), 1, "maniek", "bohnia", null);
		try {
			Sprzedawca sp = new Sprzedawca("Pawel", "pela", "443-232-232", "pelek@jdsg.sd", new Adres(), 1, "1992.11.12");
		System.out.println(sp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(kl);
	}

}
