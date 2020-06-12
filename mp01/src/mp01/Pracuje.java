package mp01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Pracuje extends Extension{

	private Sprzedawca sprzedawca;
	private Sklep sklep;
	private LocalDate dataOd;
	private LocalDate dataDo;
	
	
	public Pracuje(Sprzedawca sprzedawca, Sklep sklep, LocalDate dataOd,LocalDate dataDo)
	{
		this.sprzedawca = sprzedawca;
		this.sklep=sklep;
		sklep.dodajPracuje(this);
		sprzedawca.dodajPracuje(this);
		this.dataOd = dataOd;
		this.dataDo = dataDo;
	}
	
	public Pracuje(LocalDate dataOd,LocalDate dataDo)
	{
		
		this.dataOd = dataOd;
		this.dataDo = dataDo;
	}
	
	public void ustawSprzedawce(Sprzedawca sprzedawca)
	{
		if(sprzedawca==null)
		{
			this.sprzedawca = sprzedawca;
			
			
		}
	}
	
	public void usunSprzedawce(Sprzedawca sprzedawca)
	{
		if(this.sprzedawca==sprzedawca)
		{
			this.sprzedawca = null;
		}
	}
	
	public void ustawSklep(Sklep sklep)
	{
		if(sklep==null)
		{
			this.sklep = sklep;
			this.sklep.dodajPracuje(this);
		}
	}
	
	public void usunSklep(Sklep sklep)
	{
		if(this.sklep==sklep)
		{
			this.sklep = null;
			this.sklep.usunPracuje(this);
		}
	}
	

	public String toString()
	{
		return "Sprzedawca : " + sprzedawca.toString() + " pracuje na sklepie : " + sklep.toString() ;
	}
	
	
}
