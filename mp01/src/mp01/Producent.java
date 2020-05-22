package mp01;

import java.awt.List;
import java.util.ArrayList;

public class Producent extends Exception {

	private Integer id_producenta;
	private String nazwa;
	private ArrayList<String> serieProduktow = new ArrayList<>();
	private ArrayList<Produkt> listaProduktow;
	private String nazwaProduktu;

	public Producent(String nazwa) {
		id_producenta++;
		this.nazwa = nazwa;
		 this.listaProduktow = new ArrayList<Produkt>();
	}

	public void dodajSerie(String seria) {
		if (!serieProduktow.contains(seria)) {
			serieProduktow.add(seria);
		}
	}
	
	public void usunSerie(String seria)
	{
		if (serieProduktow.contains(seria)) {
			serieProduktow.remove(seria);
		}
	}
	
	public String toString()
	{
		return "Id producenta : " + id_producenta + ", Nazwa : " + nazwa;
	}

}
