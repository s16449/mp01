package mp01;

import java.util.Date;

public class Zamowienie extends Extension{

	private String nr_zamowienia; // zmiana daty bedzie zaimplementowana
	private boolean zatwierdzenie = false;
	private Integer count = Extension.getCount(this.getClass());

	private String forma_platnosci; // przelew, blik, payu;
	Date dataZamowienia, dataDostawy; // data dostawy bedzie tez zaimplementowana
	private Klient klient;
	private Koszyk koszyk;

	public Zamowienie(Klient klient, Koszyk koszyk, String forma_platnosci, Date dataZamowienia) {
		this.klient = klient;
		this.koszyk = koszyk;
		this.forma_platnosci = forma_platnosci;
		this.dataZamowienia = dataZamowienia;
		nr_zamowienia = "Z/" + count + "/2020";
		
	}

	public void akceptujZamowienie() {
		zatwierdzenie = true;
	}
	
	public boolean sprawdzZatwierdzenie()
	{
		return zatwierdzenie;
	}

	public String toString() {
		return "Zamowienie nr : " + nr_zamowienia + " " + klient.toString() + " " + koszyk.zwrocIdKoszyka() + " "
				+ forma_platnosci + " " + dataZamowienia;
	}
	
	public Double podliczZamowienie()
	{
		Double cena = 0.0;
		return cena;
	}

}
