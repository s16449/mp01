package mp01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sklep extends Extension {

	private static Sklep instancja = null;

	Map<Produkt, Double> listaProduktow = new HashMap<>();
	Map<Produkt, Double> dostepnaIlosc = new HashMap<>();
	ArrayList<Produkt> usunieteZoferty = new ArrayList<>();
	Integer count = 0;

	private Sklep() {

	};

	public static Sklep getInstanceOf() {

		if (instancja == null) {

			instancja = new Sklep();

		}
		return instancja;
	}

	public void dodajProdukt(Produkt produkt, Double cena) {
		this.listaProduktow.put(produkt, cena);
		count++;
	}

	public void usunProdukt(Produkt produkt) {
		this.usunieteZoferty.add(produkt);
		this.listaProduktow.remove(produkt);
		this.dostepnaIlosc.remove(produkt);
	}

	public void dodajIloscProduktu(Produkt produkt, Double ilosc) {

		this.dostepnaIlosc.put(produkt, ilosc);
	}

	public void pokazListeProduktow() {
		for (Map.Entry<Produkt, Double> entry : listaProduktow.entrySet()) {
			System.out.println("Produkt : " + entry.getKey() + ", Cena : " + entry.getValue().doubleValue() + " PLN");
		}
	}

	public void pokazDostepnaIloscProduktow() {
		for (Map.Entry<Produkt, Double> entry : dostepnaIlosc.entrySet()) {
			System.out.println("Produkt : " + entry.getKey() + ", Ilosc : " + entry.getValue() + " "
					+ entry.getKey().jednostka_miary);
		}
	}

	public void pokazDostepnaIloscProduktow(Produkt produkt) {
		for (Map.Entry<Produkt, Double> entry : dostepnaIlosc.entrySet()) {
			if (entry.getKey().getNazwaProduktu() == produkt.getNazwaProduktu()) {
				System.out.println("Dostepna ilosc danego Produktu : " + entry.getKey() + ", Ilosc : "
						+ entry.getValue() + " " + entry.getKey().jednostka_miary);
			}
		}

	}

	public void zmienCeneProduktu(Produkt produkt, Double cena) {
		this.listaProduktow.replace(produkt, cena);
	}

	public void zmienIloscProduktu(Produkt produkt, Double ilosc) {
		this.dostepnaIlosc.replace(produkt, ilosc);
	}

	public Double zwrocCeneProduku(Produkt produkt) {
		return this.listaProduktow.get(produkt);
	}

	public Double zwrocLiczbeDostepnegoProduktu(Produkt produkt) {
		return this.dostepnaIlosc.get(produkt);
	}

	public Produkt pobierzProdukt(Produkt produkt, Double ilosc) {

		for (Map.Entry<Produkt, Double> entry : dostepnaIlosc.entrySet()) {
			if (entry.getKey().getNazwaProduktu() == produkt.getNazwaProduktu() && entry.getValue() >= ilosc) {
				return entry.getKey();
			}
		}
		return null;
	}

	public Double pobierzCene(Produkt produkt, Double ilosc) {
		for (Map.Entry<Produkt, Double> entry : listaProduktow.entrySet()) {
			if (entry.getKey().getNazwaProduktu() == produkt.getNazwaProduktu() && entry.getValue() >= ilosc) {

				return entry.getValue();
			}
		}
		return null;
	}

	public void usunPobraneIlosci(Produkt produkt, Double ilosc) {
		for (Map.Entry<Produkt, Double> entry : dostepnaIlosc.entrySet()) {
			if (entry.getKey().getNazwaProduktu() == produkt.getNazwaProduktu() && entry.getValue() >= ilosc) {
				this.dostepnaIlosc.replace(produkt, entry.getValue() - ilosc);
			}
		}
	}

	public String toString() {
		return "Sklep dla zwierzakow, ilosc produktow w asortymencie = " + count;
	}
}
