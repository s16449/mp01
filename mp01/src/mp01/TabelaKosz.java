package mp01;

public class TabelaKosz extends Tabela {

	public TabelaKosz(String nazwa, String kategoria, String jednostka, Double ilosc, Double cena) {
		super(nazwa, kategoria, jednostka, ilosc, cena);
		
	}
	
	
	public String toString()
	{
		return nazwa;
	}
	
	public void dodajIlosc(Double db)
	{
		ilosc += db;
	}
	
	public void usunIlosc(Double db)
	{
		ilosc -= db;
	}
	

}
