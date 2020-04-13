package mp01;

public class Magazynier extends Pracownik {
	public static int id_magazyniera = 0 ;
	
	
	public Magazynier(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, int umowa,
			String dataOd) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, umowa, dataOd);
		id_magazyniera++;
		
		
	}
	
	public String toString()
	{
		return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString()+ " " +  rodzajUmowy + " " +  dataZatrudnienia+ "  " + id_magazyniera;
	}

}

