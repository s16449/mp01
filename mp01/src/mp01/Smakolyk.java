package mp01;

public class Smakolyk extends Produkt {
	
	private Integer idProduktu = 30000 + Extension.getCount(this.getClass());
		
	public Smakolyk(Producent producent, String nazwa_produktu, String jednostka_miary) {
		super(producent, nazwa_produktu, jednostka_miary);
	}
	
	public String toString()
	{
		return idProduktu + " " + nazwa_produktu + " " + producent + " " + jednostka_miary;
	}

}
