package mp01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sklep {

	private static Sklep instancja = null;

	Map<Produkt, Double> listaProduktow = new HashMap<>();
	Map<Produkt, Double> dostepnaIlosc = new HashMap<>();
	ArrayList<Produkt> usunieteZoferty = new ArrayList<>();

	private Sklep() {
	};

	public static Sklep getInstanceOf() {
		if (instancja == null) {
			instancja = new Sklep();
		}
		return instancja;
	}

	public void dodajProdukt(Produkt produkt, Double cena) {
		listaProduktow.put(produkt, cena);
	}

	public void usunProdukt(Produkt produkt) {
		usunieteZoferty.add(produkt);
		listaProduktow.remove(produkt);
		dostepnaIlosc.remove(produkt);
	}

	public void dodajIloscProduktu(Produkt produkt, Double ilosc) {

		dostepnaIlosc.put(produkt, ilosc);
	}

	public void pokazListeProduktow() {
		for (Map.Entry<Produkt, Double> entry : listaProduktow.entrySet()) {
			System.out.println("Produkt : " + entry.getKey() + ", Cena : " + entry.getValue() + " PLN");
		}
	}

	public void pokazDostepnaIloscProduktow() {
		for (Map.Entry<Produkt, Double> entry : dostepnaIlosc.entrySet()) {
			System.out.println("Produkt : " + entry.getKey() + ", Ilosc : " + entry.getValue() + " "
					+ entry.getKey().jednostka_miary);
		}
	}

	public void zmienCeneProduktu(Produkt produkt, Double cena) {
		listaProduktow.replace(produkt, cena);
	}

	public void zmienIloscProduktu(Produkt produkt, Double ilosc) {
		dostepnaIlosc.replace(produkt, ilosc);
	}

	public Double zwrocLiczbeDostepnegoProduktu(Produkt produkt) {
		return dostepnaIlosc.get(produkt);
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
	
	public void usunPobraneIlosci(Produkt produkt, Double ilosc)
	{
		for (Map.Entry<Produkt, Double> entry : dostepnaIlosc.entrySet()) {
			if (entry.getKey().getNazwaProduktu() == produkt.getNazwaProduktu() && entry.getValue() >= ilosc) {
				dostepnaIlosc.replace(produkt, entry.getValue() - ilosc);
				
			}

		}
	}
}
