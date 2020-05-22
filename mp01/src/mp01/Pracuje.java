package mp01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Pracuje extends Extension{

	private Sprzedawca sprzedawca;
	private Sklep sklep;
	private LocalDate dataOd;
	private LocalDate dataDo;
	
	private ArrayList<Sprzedawca> listaSprzedawcow;
	private ArrayList<Sklep> listaSklepow;
	
	public Pracuje(Sprzedawca sprzedawca, Sklep sklep, LocalDate dataOd,LocalDate dataDo)
	{
		this.sprzedawca = sprzedawca;
		this.sklep=sklep;
		this.dataOd = dataOd;
		this.dataDo = dataDo;
	}
	
	public String toString()
	{
		return "Sprzedawca : " + sprzedawca.toString() + " pracuje na sklepie : " + sklep.toString() ;
	}
	
	
}
