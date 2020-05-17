package mp01;

import java.time.LocalDate;

public class Sprzedawca extends Pracownik {

	public Integer id_sprzedawcy = Extension.getCount(this.getClass());

	public Sprzedawca(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres,
			LocalDate dataUrodzenia, LocalDate dataOd, LocalDate dataDo, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, dataUrodzenia, dataOd, dataDo, pesel);

	}

	public Sprzedawca(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres,
			LocalDate dataUrodzenia, LocalDate dataOd, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, dataUrodzenia, dataOd, pesel);

	}

	public String toString() {
		if (dataDo != null) {

			return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString() + " " + dataOd
					+ " " + dataDo + "  " + rodzajUmowy + " " + pesel + " " + id_sprzedawcy;
		} else {
			return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString() + " " + dataOd
					+ "  " + rodzajUmowy + " " + pesel + " " + id_sprzedawcy;
		}
	}

}
