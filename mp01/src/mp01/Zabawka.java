package mp01;

public class Zabawka extends Produkt {

	private Integer idProduktu = 20000 + Extension.getCount(this.getClass());
	
	
	public Zabawka(Producent producent, String nazwa_produktu, String jednostka_miary) {
		super(producent, nazwa_produktu, jednostka_miary);
		if (jednostka_miary != "szt") {
			;
		}
	}
	
	public String toString()
	{
		return idProduktu + " " + nazwa_produktu + " " + producent + " " + jednostka_miary;
	}

}
