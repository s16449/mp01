package mp01;

import java.util.HashMap;
import java.util.Map;

public class Koszyk extends Extension {

	private Integer id_koszyk = Extension.getCount(this.getClass());

	Map<Produkt, Double> koszykMap = new HashMap<>();
	Sklep sklep;
	Integer iloscProduktow = 0;
	Double koszt = 0.0;

	public Koszyk(Sklep sklep) {
		System.out.println(id_koszyk + " id koszyka");
		this.sklep = sklep;
		
	}

	public void dodajDoKoszyka(Produkt produkt, Double ilosc) {
		if (sklep.pobierzProdukt(produkt, ilosc) != null && sklep.pobierzCene(produkt, ilosc) != null) {
			koszykMap.put(sklep.pobierzProdukt(produkt, ilosc), sklep.pobierzCene(produkt, ilosc));
			sklep.usunPobraneIlosci(produkt, ilosc); //ale tylko po akcjeptacji zamowienia
			koszt += sklep.zwrocCeneProduku(produkt) * ilosc;
		}
	}

	public void pokazZawartoscKoszyka() {
		System.out.println("zawartosc");
		if (!koszykMap.containsKey(null)) {
			for (Map.Entry<Produkt, Double> entry : koszykMap.entrySet()) {
				iloscProduktow++;
				System.out.println(entry.getKey().toString() + entry.getValue());
			}
		}
	}
	
	public Double pokazKosztKoszyka()
	{
		return koszt;
	}

	public Integer zwrocIdKoszyka() {
		return this.id_koszyk;
	}
	
	public String toString()
	{
		return "id Koszyka " + id_koszyk + ", zawartosc produktow w koszyku : " + iloscProduktow + ", laczna cena : " + koszt;
	}

}
