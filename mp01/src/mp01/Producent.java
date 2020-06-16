package mp01;

import java.util.ArrayList;

public class Producent extends Extension {

	private Integer id_producenta =0+ Extension.getCount(this.getClass());
	private String nazwa;
	private ArrayList<String> serieProduktow = new ArrayList<>();
	private ArrayList<Produkt> listaProduktow;
	private String nazwaProduktu;

	// asocjacja 1 do * strona 1

	public Producent(String nazwa) {
		
		this.nazwa = nazwa;
		this.listaProduktow = new ArrayList<Produkt>();
	}

	public void dodajSerie(String seria) {
		if (!serieProduktow.contains(seria)) {
			serieProduktow.add(seria);
		}
	}

	public void usunSerie(String seria) {
		if (serieProduktow.contains(seria)) {
			serieProduktow.remove(seria);
		}
	}

	// dodawanie produktu do listy

	public void dodajProduktdoListy(Produkt produkt) {
		if (!listaProduktow.contains(produkt)) {
			listaProduktow.add(produkt);
			produkt.setProducent(this);
		}
	}

	public void wyswListeProduktow() {
		if (!listaProduktow.isEmpty()) {
			for (Produkt pp : listaProduktow) {
				System.out.println(pp);
			}
		}
	}

	// usuwanie produktu z listy

	public void usunProduktZlisty(Produkt produkt) {
		if (listaProduktow.contains(produkt)) {
			listaProduktow.remove(produkt);
			produkt.zwolnijNazweProducenta(this);
			System.out.println("usuwam");
		}
	}

	public String toString() {
		return "Id producenta : " + id_producenta + ", Nazwa : " + nazwa;
	}

}
