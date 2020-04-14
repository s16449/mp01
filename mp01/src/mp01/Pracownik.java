package mp01;

import java.util.Date;

public abstract class Pracownik extends Osoba {
	
	public String pesel;
	int umowa;
	String info1 = "na czas nie okre�lony";
	String info2 = "na czas okre�lony";
	//SimpleDateFormat dataFormat;
	//Date dataZatrudnienia;
	Date dataOd;
	Date dataDo;
	public String rodzajUmowy;
	
	///dataDo;
	
	public Pracownik(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, int umowa, Date dataOd, String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres);
		if(umowa > 2 | umowa < 1)
		{
		throw new Exception("mog� byc tylko dwie wartosci : 1 lub 2 ");
		}
		this.umowa = umowa;
		this.pesel = pesel;
		this.dataOd = dataOd;
		rodzajUmowy = umowa>1?info2:info1;
		//dataFormat = new SimpleDateFormat("yyyy.MM.dd");
		//dataZatrudnienia = dataFormat.parse(dataOd);
		
	}
		
}
