package mp01;

public class Smakolyk extends Produkt {

	private Integer idProduktu = 30000 + Extension.getCount(this.getClass());

	public Smakolyk(Producent producent, String nazwa_produktu, String jednostka_miary) {
		super(producent, nazwa_produktu, jednostka_miary);
	}

	public Smakolyk(String nazwa_produktu, String jednostka_miary) {
		super(nazwa_produktu, jednostka_miary);
	}

	public String toString() {
		if (producent != null) {
			return idProduktu + " " + nazwa_produktu + " " + producent.toString() + " " + jednostka_miary;
		} else {
			return idProduktu + " " + nazwa_produktu + " " + "brak podanego producenta" + " " + jednostka_miary;
		}
	}
}
