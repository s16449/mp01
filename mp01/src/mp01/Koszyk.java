package mp01;

import java.util.HashMap;
import java.util.Map;

public class Koszyk extends Extension {

	private static Integer id_koszyk = 1;

	Map<Produkt, Double> koszykMap = new HashMap<>();
	Sklep sklep;

	public Koszyk(Sklep sklep) {
		this.sklep = sklep;
		id_koszyk++;
	}

	public void dodajDoKoszyka(Produkt produkt, Double ilosc) {
		if (sklep.pobierzProdukt(produkt, ilosc) != null && sklep.pobierzCene(produkt, ilosc) != null) {
			koszykMap.put(sklep.pobierzProdukt(produkt, ilosc), sklep.pobierzCene(produkt, ilosc));
			sklep.usunPobraneIlosci(produkt, ilosc);
		}
	}

	public void pokazZawartoscKoszyka() {
		System.out.println("zawartosc");
		if (!koszykMap.containsKey(null)) {
			for (Map.Entry<Produkt, Double> entry : koszykMap.entrySet()) {
				System.out.println(entry.getKey().toString() + entry.getValue());
			}
		}
	}

	public Integer zwrocIdKoszyka() {
		return id_koszyk;
	}

}
