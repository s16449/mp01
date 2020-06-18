package mp01;

public class Tabela extends Extension{
	
	protected String nazwa;
	protected String kategoria;
	protected String jednostka;
	protected Double ilosc,cena;
	
	

	public Tabela(String nazwa, String kategoria, String jednostka, Double ilosc, Double cena) {
		super();
		this.nazwa = nazwa;
		this.kategoria = kategoria;
		this.jednostka = jednostka;
		this.ilosc = ilosc;
		this.cena = cena;
	}

	public String getNazwa() {
		return nazwa;
	}
	
	public void dodajIlosc(Double db)
	{
		ilosc += db;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public String getJednostka() {
		return jednostka;
	}

	public void setJednostka(String jednostka) {
		this.jednostka = jednostka;
	}

	public Double getIlosc() {
		return ilosc;
	}

	public void setIlosc(Double ilosc) {
		this.ilosc = ilosc;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}
	
	public String toString()
	{
		return nazwa;
	}
}
