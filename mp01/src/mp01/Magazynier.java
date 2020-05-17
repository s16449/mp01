package mp01;

import java.time.LocalDate;

public class Magazynier extends Pracownik {
	public Integer id_magazyniera = Extension.getCount(this.getClass());

	public Magazynier(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres,
			LocalDate dataUrodzenia, LocalDate dataOd, LocalDate dataDo, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, dataUrodzenia, dataOd, dataDo, pesel);
		// id_magazyniera++;

	}
	
	public Magazynier(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres,
			LocalDate dataUrodzenia, LocalDate dataOd, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, dataUrodzenia, dataOd, pesel);
		// id_magazyniera++;

	}

	public String toString() {
		return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString() + " " + dataOd
				+ " " + dataDo + "  " + rodzajUmowy + " " + pesel + " " + id_magazyniera;
	}

}
