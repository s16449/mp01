package mp01;

public class Karma extends Produkt {

private Integer idProduktu = 10000 + Extension.getCount(this.getClass());
	protected String kategoria = "Karma";
	public Karma(Producent producent, String nazwa_produktu, String jednostka_miary) throws ZlaJednostkaException {
		super(producent, nazwa_produktu, jednostka_miary);

		if (jednostka_miary != "kilogram") {
			throw new ZlaJednostkaException();
		}
	}

	public Karma(String nazwa_produktu, String jednostka_miary) throws ZlaJednostkaException {
		super(nazwa_produktu, jednostka_miary);

		if (jednostka_miary != "kilogram") {
			throw new ZlaJednostkaException();
		}
	}

	public String toString() {

		if (producent != null) {
			return idProduktu + " " + nazwa_produktu + " " + producent.toString() + " " + jednostka_miary;
		} else {
			return idProduktu + " " + nazwa_produktu + " " + "brak podanego producenta" + " " + jednostka_miary;
		}
	}
	
	public String getKategoria()
	{
		return kategoria;
	}

}
