package mp01;

public class Karma extends Produkt {

	private Integer idProduktu = 10000 + Extension.getCount(this.getClass());
	
	
	
	public Karma(Producent producent, String nazwa_produktu, String jednostka_miary) throws ZlaJednostkaException {
		super(producent, nazwa_produktu, jednostka_miary);
						
		if (jednostka_miary != "kg") {
			throw new ZlaJednostkaException();
		}
	}
	
	public String toString()
	{
		return idProduktu + " " + nazwa_produktu + " " + producent + " " + jednostka_miary;
	}

}
