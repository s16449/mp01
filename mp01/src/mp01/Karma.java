package mp01;

public class Karma extends Produkt {

	private static Integer count = 10000;
	
	
	
	public Karma(String producent, String nazwa_produktu, String jednostka_miary) throws ZlaJednostkaException {
		super(producent, nazwa_produktu, jednostka_miary);
		
		idProduktu = count++;
		
		if (jednostka_miary != "kg") {
			throw new ZlaJednostkaException();
		
		}
	}
	
	public String toString()
	{
		return idProduktu + " " + nazwa_produktu + " " + producent + " " + jednostka_miary;
	}

}
