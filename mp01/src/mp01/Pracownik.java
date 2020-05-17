package mp01;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pracownik extends Osoba {

	public String pesel;
	int umowa;
	private String info1 = "na czas nie okreœlony";
	private String info2 = "na czas okreœlony";
	private  Integer wiek = 18; // do weryfikacji

	protected LocalDate dataOd, dataDo;
	protected LocalDate dataUrodzenia;
	protected String rodzajUmowy;

	public Pracownik(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres,
			LocalDate dataUrodzenia, LocalDate dataOd, LocalDate dataDo, String pesel) {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres);
		Period period = Period.between(dataUrodzenia, dataOd);
		Period period2 = Period.between(dataOd, dataDo);
		if (period2.getMonths() < 3) {
			System.out.println("Umowa nie moze byc krotsza niz 3 miesiace");
		}
		if (period.getYears() < wiek) {
			System.out.println("Pracownik musi miec minimum 18 lat ! ");
		} else {
			this.rodzajUmowy = info2;
			this.pesel = pesel;
			this.dataUrodzenia = dataUrodzenia;
			this.dataOd = dataOd;
			this.dataDo = dataDo;

		}
	}

	public Pracownik(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres,
			LocalDate dataUrodzenia, LocalDate dataOd, String pesel) {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres);
		Period period = Period.between(dataUrodzenia, dataOd);
		if (period.getYears() < 18) {
			System.out.println("Pracownik musi miec 18 lat ! ");
		} else {

			this.rodzajUmowy = info1;
			this.pesel = pesel;
			this.dataUrodzenia = dataUrodzenia;
			this.dataOd = dataOd;
		}

	}

}
