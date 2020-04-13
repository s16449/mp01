package mp01;

public class Klient extends Osoba {

	private String login, haslo, numerNip;
	private int id_klienta;
	public Klient(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, int id_klienta,
			String login, String haslo, String numerNip) {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres);
		this.id_klienta = id_klienta;
		this.login = login;
		this.haslo = haslo;
		this.numerNip = numerNip;

	}

	public String toString() {
		return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString() + " "
					+ id_klienta + " " + login + " " + haslo + " " + numerNip;
	
	}

}
