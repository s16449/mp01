package mp01;


public class Sprzedawca extends Pracownik {

	public static int id_sprzedawcy = 0 ;

	
	public Sprzedawca(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, int umowa,
			String dataOd) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, umowa, dataOd);
		id_sprzedawcy++;
		
		
	}
	
	public String toString()
	{
		return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString()+ " " +  rodzajUmowy + " " +  dataZatrudnienia+ "  " + id_sprzedawcy;
	}

}
