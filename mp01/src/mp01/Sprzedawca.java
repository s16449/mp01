package mp01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sprzedawca extends Pracownik {

	public Integer id_sprzedawcy = Extension.getCount(this.getClass());
	private List<Pracuje> listaPracuje;
	public Pracuje pracuje;

	public Sprzedawca(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres,
			LocalDate dataUrodzenia, LocalDate dataOd, LocalDate dataDo, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, dataUrodzenia, dataOd, dataDo, pesel);
		this.listaPracuje = new ArrayList<Pracuje>();
	}

	public Sprzedawca(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres,
			LocalDate dataUrodzenia, LocalDate dataOd, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, dataUrodzenia, dataOd, pesel);
		this.listaPracuje = new ArrayList<Pracuje>();
	}

	public void dodajPracuje(Pracuje pracuje) {
		if (!listaPracuje.contains(pracuje)) {
			listaPracuje.add(pracuje);
			pracuje.ustawSprzedawce(this);

		}
	}

	public void usunPracuje(Pracuje pracuje) {
		if (!listaPracuje.isEmpty()) {
			if (listaPracuje.contains(pracuje)) {
				listaPracuje.remove(pracuje);
				pracuje.usunSprzedawce(this);
			}
		}
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
