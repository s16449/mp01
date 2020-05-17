package mp01;

public abstract class Osoba extends Extension{

	protected String imie, nazwisko;
	protected String nr_telefonu;
	protected String adresEmail;
	protected Adres adres = new Adres();

	public Osoba(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres) {
	
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nr_telefonu = nr_telefonu;
		this.adresEmail = adresEmail;
		this.adres = adres;
	}
	
	
}
