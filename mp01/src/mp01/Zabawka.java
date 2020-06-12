package mp01;

public class Zabawka extends Produkt {

	private Integer idProduktu = 20000 + Extension.getCount(this.getClass());
	protected String kategoria = "Zabawka";

	public Zabawka(Producent producent, String nazwa_produktu, String jednostka_miary) {
		super(producent, nazwa_produktu, jednostka_miary);
		if (jednostka_miary != "szt") {
			;
		}
	}

	public Zabawka(String nazwa_produktu, String jednostka_miary) {
		super(nazwa_produktu, jednostka_miary);
		if (jednostka_miary != "szt") {
			;
		}
	}

	public String toString() {
		if (producent != null) {
			return idProduktu + " " + nazwa_produktu + " " + producent.toString() + " " + jednostka_miary;
		} else {
			return idProduktu + " " + nazwa_produktu + " " + "brak podanego producenta" + " " + jednostka_miary;
		}
	}

	public String getKategoria() {
		return kategoria;
	}
}
