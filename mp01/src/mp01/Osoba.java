package mp01;

public abstract class Osoba {

	public String imie, nazwisko, nr_telefonu, adresEmail;
	public Adres adres = new Adres();

	public Osoba(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres) {
		
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nr_telefonu = nr_telefonu;
		this.adresEmail = adresEmail;
		this.adres = adres;
	}
	
	
}
