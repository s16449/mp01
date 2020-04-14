package mp01;

public class Zabawka extends Produkt {

	private static Integer count = 20000;
	private Integer idProduktu;
	
	public Zabawka(String producent, String nazwa_produktu, String jednostka_miary) throws ZlaJednostkaException {
		super(producent, nazwa_produktu, jednostka_miary);

		idProduktu = count++;
		
		if (jednostka_miary != "szt") {
			throw new ZlaJednostkaException();
		}
	}
	
	public String toString()
	{
		return idProduktu + " " + nazwa_produktu + " " + producent + " " + jednostka_miary;
	}

}
