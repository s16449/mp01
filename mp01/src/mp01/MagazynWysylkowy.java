package mp01;

import java.util.LinkedList;

public class MagazynWysylkowy extends Extension{

	private static MagazynWysylkowy instancja = null;

	LinkedList<Zamowienie> listaZamowienOczekujacych = new LinkedList<>();
	LinkedList<Zamowienie> listaZamowienWyslanych = new LinkedList<>();

	private MagazynWysylkowy() {
	
	};

	public static MagazynWysylkowy getInstanceOf() {
		if (instancja == null) {
			instancja = new MagazynWysylkowy();
		}
		return instancja;
	}

	public void dodajDoListy(Zamowienie zamowienie) {
		listaZamowienOczekujacych.add(zamowienie);
	}

	public void pokazListeZamowien() {
		for (Zamowienie ls : listaZamowienOczekujacych) {
			System.out.println(ls + " OCZEKUJACE ");
		}
		for (Zamowienie ls : listaZamowienWyslanych) {
			System.out.println(ls + " WYSLANE ");
		}
	}

	public void wyslijZamowienia() {
		for (Zamowienie ls : listaZamowienOczekujacych) {
			if (ls.sprawdzZatwierdzenie()) {
				listaZamowienWyslanych.add(ls);
			
			}
		}listaZamowienOczekujacych.clear();;
	}
	
	public String toString()
	{
		return "Magazyn Wysylkowy";
	}

}
