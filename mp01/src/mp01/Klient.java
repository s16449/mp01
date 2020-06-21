package mp01;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import mp01.Sklep.Koszyk;

public class Klient extends Osoba {

	protected String login, haslo, numerNip;
	protected Integer id_klienta = +Extension.getCount(this.getClass());
	protected Double result = null;
	private List<Double> suma_zakupow = new ArrayList<>();
	private List<Klient> listaKlientow = new ArrayList<>();
	private List<Koszyk> koszyki = new ArrayList<>();
	private File file = new File("save.obj");
	private Map<String, Zamowienie> kwalifikowana = new TreeMap<>();

	public Klient(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, String login,
			String haslo, String numerNip) throws FileNotFoundException, IOException {

		super(imie, nazwisko, nr_telefonu, adresEmail, adres);
		// this.id_klienta = id_klienta;
		this.login = login;
		this.haslo = haslo;
		this.numerNip = numerNip;
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		Koszyk.writeExtent(out);
		out.close();
		Klient.showExtent(Klient.class);

	}

	public Klient(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, String login,
			String haslo) throws FileNotFoundException, IOException {

		super(imie, nazwisko, nr_telefonu, adresEmail, adres);
		// this.id_klienta = id_klienta;
		this.login = login;
		this.haslo = haslo;
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		Koszyk.writeExtent(out);
		out.close();

	}

	public String toString() {

		if (numerNip != null) {
			return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString() + " "
					+ id_klienta + " " + login + " " + haslo + " " + numerNip;
		} else {
			return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString() + " "
					+ id_klienta + " " + login + " " + haslo;

		}

	}

	public void dodajSumeZakupow(Double suma) {
		result = +suma;
		System.out.println(result + " suma " + suma);
		suma_zakupow.add(suma); // blad nie sumuje sumy zakupow
	}

	public Double zwrocSumeZakupowKlienta() {
		return result;
	}

	
	
	public void dodajZmowienie(Zamowienie zamowienie) {
		if (!kwalifikowana.isEmpty()) {

			if (!kwalifikowana.containsKey(zamowienie.nr_zamowienia)) {
				kwalifikowana.put(zamowienie.nr_zamowienia, zamowienie);
				zamowienie.ustawKlienta(this);
			}
		} else {
			kwalifikowana.put(zamowienie.nr_zamowienia, zamowienie);
			zamowienie.ustawKlienta(this);
		}

	}

	public Zamowienie znajdzZamowienie(String numer) throws Exception {
		if (!kwalifikowana.containsKey(numer)) {
			throw new Exception("Brak zamowienia o numerze " + numer);
			// System.out.println("Brak zamowienia o numerze " + numer);
			// return
		}
		System.out.println("znaleziono zamowienie o nr " + numer);
		return kwalifikowana.get(numer);
	}

	public void usunZamowienie(Zamowienie zamowienie) {
		if (kwalifikowana.containsKey(zamowienie.zwrocNrZamowienia())) {
			kwalifikowana.remove(zamowienie.zwrocNrZamowienia(), zamowienie);
			zamowienie.usunKlienta(this);
		}

	}
	public void pokazZamowienia()
	{
		for (Map.Entry<String, Zamowienie> entry : kwalifikowana.entrySet()) {
			
			System.out.println(entry.getKey().toString() + entry.getValue().toString());
		}
	}

	public String zwrocLogin() {
		return login;
	}

	public String zwrocHaslo() {
		return haslo;
	}
	
	public void dodajKoszyk(Koszyk kosz)
	{
		koszyki.add(kosz);
	}
	
	public List<Koszyk> getKoszykList()
	{
		return koszyki;
	}

}
