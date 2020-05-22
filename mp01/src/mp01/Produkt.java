package mp01;

public abstract class Produkt extends Extension{
	
	
	public String nazwa_produktu,jednostka_miary,opis;
	public Producent producent;
	public Integer idProduktu;
	
	//jednostka miary bedzie generowana z boxa z okreslonymi mozliwosciami zaznaczenia;
	
	public Produkt(Producent producent, String nazwa_produktu, String jednostka_miary)
	{
	
		this.producent = producent;
		this.nazwa_produktu = nazwa_produktu;
		this.jednostka_miary= jednostka_miary;
		
	}
	
	public void setProducent(Producent producent)
	{
		if(producent!=null)
		{
			this.producent = producent;
		}
	}
	
	public void dodajEdytujOpis(String opis) {
		
		this.opis = opis;
	};
	
	public String pobierzOpis()
	{
		return opis;
	}
	
	public void pokazOpis()
	{
		System.out.println(opis);
	}
	
	public String getNazwaProduktu()
	{
		return nazwa_produktu;
	}
	
	public String toString()
	{
		return idProduktu + " " + nazwa_produktu + " " + producent.toString() + " " + jednostka_miary;
	}

}
