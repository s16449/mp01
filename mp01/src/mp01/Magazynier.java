package mp01;

import java.util.Date;

public class Magazynier extends Pracownik {
	public Integer id_magazyniera = Extension.getCount(this.getClass());
	
	
	public Magazynier(String imie, String nazwisko, String nr_telefonu, String adresEmail, Adres adres, int umowa,
			Date dataOd,String pesel) throws Exception {
		super(imie, nazwisko, nr_telefonu, adresEmail, adres, umowa, dataOd,pesel );
		id_magazyniera++;
		
		
	}
	
	public String toString()
	{
		return imie + " " + nazwisko + " " + nr_telefonu + " " + adresEmail + " " + adres.toString()+ " " +  rodzajUmowy + " " +  dataOd+ "  " + pesel + " " + id_magazyniera;
	}

}

