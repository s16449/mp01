package mp01;

import java.util.Date;

public class Sprzedawca extends Pracownik {

	public static int id_sprzedawcy = 0;

	public Sprzedawca(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, int umowa,
			Date dataOd, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, umowa, dataOd, pesel);
		id_sprzedawcy++;

	}

	public String toString() {
		return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString() + " " + rodzajUmowy
				+ " " + dataOd + "  " + pesel + " " + id_sprzedawcy;
	}

}
