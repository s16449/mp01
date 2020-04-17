package mp01;

import java.util.Date;

public class Sprzedawca extends Pracownik {

	public Integer id_sprzedawcy = Extension.getCount(this.getClass());

	public Sprzedawca(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, int umowa,
			Date dataOd, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, umowa, dataOd, pesel);
		

	}

	public String toString() {
		return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString() + " " + rodzajUmowy
				+ " " + dataOd + "  " + pesel + " " + id_sprzedawcy;
	}

}
