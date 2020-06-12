package mp01;

public abstract class Produkt extends Extension {

	protected String nazwa_produktu, jednostka_miary, opis, kategoria;
	protected Producent producent;
	private Integer idProduktu;

	// jednostka miary bedzie generowana z boxa z okreslonymi mozliwosciami
	// zaznaczenia

	// asocjacja * do 1 - strona wiele

	public Produkt(Producent producent, String nazwa_produktu, String jednostka_miary) {

		if (producent != null) {
			this.producent = producent;
			producent.dodajProduktdoListy(this);
		}
		this.nazwa_produktu = nazwa_produktu;
		this.jednostka_miary = jednostka_miary;

	}

	public Produkt(String nazwa_produktu, String jednostka_miary) {

		this.nazwa_produktu = nazwa_produktu;
		this.jednostka_miary = jednostka_miary;

	}

	public void setProducent(Producent producent) {
		if (producent != null) {
			if (producent != null) {
				this.producent = producent;
				producent.dodajProduktdoListy(this);
			}
		}
	}

	// zwolnienie nazwy producenta

	public void zwolnijNazweProducenta(Producent producent) {
		if (this.producent == producent) {
			this.producent.usunProduktZlisty(this);
			this.producent = null;
			
			System.out.println("usunieto" + producent.toString());
		}
	}

	public void dodajEdytujOpis(String opis) {

		this.opis = opis;
	};

	public String pobierzOpis() {
		return opis;
	}

	public void pokazOpis() {
		System.out.println(opis);
	}

	public String getNazwaProduktu() {
		return nazwa_produktu;
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
	
	public String getJednostka()
	{
		return jednostka_miary;
	}
}
