package mp01;

public class Adres extends Extension{

	private String ulica, miejscowosc, kod_pocztowy;

	public Adres() {
	};

	public Adres(String ulica, String miejscowosc, String kod_pocztowy) {
		this.ulica = ulica;
		this.miejscowosc = miejscowosc;
		this.kod_pocztowy = kod_pocztowy;
	}

	public String toString() {
		
		if(weryfikacjaAdresu()) {
		return ulica + " " + miejscowosc + " " + kod_pocztowy;
		}else {
			return "Prosze podac adres !" ;
		}
			
	}

	public boolean weryfikacjaAdresu() {
		if (ulica != null & miejscowosc != null & kod_pocztowy != null)
			return true;
		else
			return false;

	}

	public void setAdres(String ulica, String miejscowosc, String kod_pocztowy) {
		this.ulica = ulica;
		this.miejscowosc = miejscowosc;
		this.kod_pocztowy = kod_pocztowy;
	}

}
