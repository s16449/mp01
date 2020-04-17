package mp01;

import java.util.Date;

public abstract class Pracownik extends Osoba {

	public String pesel;
	int umowa;
	String info1 = "na czas nie okreœlony";
	String info2 = "na czas okreœlony";
	// SimpleDateFormat dataFormat;
	// Date dataZatrudnienia;
	Date dataOd;
	Date dataDo;
	public String rodzajUmowy;

	/// dataDo;

	public Pracownik(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, int umowa,
			Date dataOd, String pesel) {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres);
		if (umowa > 2 | umowa < 1) {
			System.out.println("mog¹ byc tylko dwie wartosci : 1 lub 2 - PRACOWNIK NIE DODANY !!!");
		} else {
			this.umowa = umowa;
			this.pesel = pesel;
			this.dataOd = dataOd;
			rodzajUmowy = umowa > 1 ? info2 : info1;
			// dataFormat = new SimpleDateFormat("yyyy.MM.dd");
			// dataZatrudnienia = dataFormat.parse(dataOd);
		}
	}

}
