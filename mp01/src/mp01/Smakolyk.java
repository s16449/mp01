package mp01;

public class Smakolyk extends Produkt {
	
	private static Integer count = 30000;
	private Integer idProduktu;
	
	public Smakolyk(String producent, String nazwa_produktu, String jednostka_miary) {
		super(producent, nazwa_produktu, jednostka_miary);
		idProduktu = count++;

	}
	
	public String toString()
	{
		return idProduktu + " " + nazwa_produktu + " " + producent + " " + jednostka_miary;
	}

}
