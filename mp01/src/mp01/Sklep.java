package mp01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sklep extends Extension {

	//private static Sklep instancja = null;

	private Map<Produkt, Double> listaProduktow = new HashMap<>();
	private Map<Produkt, Double> dostepnaIlosc = new HashMap<>();
	private ArrayList<Produkt> usunieteZoferty = new ArrayList<>();
	private Integer count = 0;
	private ArrayList<Zamowienie> listaZamowien;
	private Integer idSklepu=1;
	private Pracuje pracuje;
	private String nazwa;
	private List<Pracuje> listaPracuje;
	
 	
	private List<Koszyk> koszyki = new ArrayList<>();

	

	public Sklep(String nazwa) {//getInstanceOf() {

		this.nazwa=nazwa;
		idSklepu++;
		this.listaPracuje= new ArrayList<Pracuje>();
	}
	public void usunKoszyk(Koszyk koszyk)
	{
		if(!koszyki.isEmpty())
		{
			if(koszyki.contains(koszyk))
			koszyki.remove(koszyk);
		}
	}
	
	public Koszyk utworzKoszyk()
	{
		Koszyk koszyk = new Koszyk();
		koszyki.add(koszyk);
		return koszyk;
	}

	public void dodajProdukt(Produkt produkt, Double cena_netto) {
		
		
		this.listaProduktow.put(produkt, cena_netto); //mo¿na tutaj zastosowaæ przeliczenie na netto - metoda wykomentowana;
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
	
//	public Double cenaBrutto(Double cena)
//	{
//		return cena += cena*(22/100.0);
//	}
	
	private Sklep zwrocSklep()
	{
		return this;
	}
	
	public void dodajPracuje(Pracuje pracuje)
	{
		if(!listaPracuje.contains(pracuje))
		{
			listaPracuje.add(pracuje);
			pracuje.ustawSklep(this);
					
		}
	}
	
	public void usunPracuje(Pracuje pracuje)
	{
		if(!listaPracuje.isEmpty())
		{
			if(listaPracuje.contains(pracuje))
			{
				listaPracuje.remove(pracuje);
				pracuje.usunSklep(this);
			}
		}
	}
	
	protected class Koszyk extends Extension {

		private Integer id_koszyk = 1; // Extension.getCount(this.getClass());

		private Map<Produkt, Double> koszykMap = new HashMap<>();
		private Sklep sklep;
		private Integer iloscProduktow = 0;
		private Double koszt = 0.0;

		private Koszyk() {
			id_koszyk++;
			System.out.println(id_koszyk + " id koszyka");
			this.sklep = zwrocSklep();
			
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
		
		public Double zwrocKosztKoszyka()
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

	
	
}
