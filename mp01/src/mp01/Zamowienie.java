package mp01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mp01.Sklep.Koszyk;

public class Zamowienie extends Extension {

	public String nr_zamowienia; // zmiana daty bedzie zaimplementowana
	private boolean zatwierdzenie = false;
	private Integer count = Extension.getCount(this.getClass());

	// private List<String> forma_platnosci = new ArrayList<>(); // przelew, blik,
	// payu; => dodac implementacje
	String forma_platnosci;
	private static List<Klient> listaKlientow = new ArrayList<>();
	private LocalDate dataZamowienia, dataDostawy, dataLocal = LocalDate.now(); // data dostawy bedzie tez
																				// zaimplementowana

	private ArrayList<Sklep> sklepLista;

	private Klient klient;
	private Koszyk koszyk;

	// musi byc klient

	public Zamowienie(Klient klient, Koszyk kosz, String forma_platnosci, LocalDate dataZamowienia) {
		this.klient = klient;
		this.koszyk = kosz;
		this.forma_platnosci = forma_platnosci; // => dodac implementacje i zmienna
		// przechowujaca platnosc
		this.dataZamowienia = dataZamowienia;
		nr_zamowienia = "Z/" + count + "/" + LocalDate.now().getYear();
		klient.dodajZmowienie(this);

	}

//	public Zamowienie(Koszyk kosz, String forma_platnosci, LocalDate dataZamowienia) {
//		
//		this.koszyk = kosz;
//		// this.forma_platnosci = forma_platnosci; => dodac implementacje i zmienna
//		// przechowujaca platnosc
//		this.dataZamowienia = dataZamowienia;
//		
//
//	}

	public void akceptujZamowienie() {

		zatwierdzenie = true;
		dataDostawy = dataLocal.plusDays(4);
		System.out.println("Zaakceptowano zamowenie nr : " + nr_zamowienia + ", dnia : " + dataLocal
				+ ", Przwidywana data dostawy : " + dataDostawy);
		klient.dodajSumeZakupow(koszyk.zwrocKosztKoszyka());
		if (!listaKlientow.contains(klient)) {
			listaKlientow.add(klient);
		}
	}

	public boolean sprawdzZatwierdzenie() {
		return zatwierdzenie;
	}

	public String toString() {
		if (nr_zamowienia != null) {
			return "Zamowienie nr : " + nr_zamowienia + " " + klient.toString() + " " + koszyk.zwrocIdKoszyka() + " "
					+ forma_platnosci + " " + dataZamowienia;
		} else {
			return "Zamowienie nr : " + " Oczekuje na akceptacjê, " + klient.toString() + " " + koszyk.zwrocIdKoszyka()
					+ " " + forma_platnosci + " " + dataZamowienia;
		}
	}

	public Double podliczZamowienie() {
		Double cena = 0.0;
		return cena;
	}

	public void pokazNajlepszegoKlienta() { // najdrozsze zakupy

		if (!listaKlientow.isEmpty()) {

			Double result = 0.0;
			Klient klient = null;
			for (Klient kl : listaKlientow) {
				if (kl.zwrocSumeZakupowKlienta() > result) {
					result = kl.zwrocSumeZakupowKlienta();
					klient = kl;
				}

			}
			System.out.println("Klientem ktory zrobil najdrozsze zakupy jest : " + klient + " suma o wartosci : "
					+ result + " PLN");
		}
	}

	public String zwrocNrZamowienia() {
		return nr_zamowienia;
	}

	public void ustawKlienta(Klient klient) {

		if (klient == null) {
			this.klient = klient;
			this.klient.dodajZmowienie(this);
		}
	}

	public void usunKlienta(Klient klient) {
		if (this.klient == klient) {
			this.klient.usunZamowienie(this);
			this.klient = null;
		}
	}

}
