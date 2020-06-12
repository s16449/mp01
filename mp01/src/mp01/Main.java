package mp01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import mp01.Sklep.Koszyk;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		Klient kl = new Klient("Stefan", "Burczymucha", "503-232-211", "stefeg@gmail.com",
				new Adres(), "stef", "bohnia");
		Klient kl2 = new Klient("Czeslaw", "Burczymucha", "503-222-111", "czesio@gmail.com",
				new Adres("Opaczewska 33 m 33", "Warszawa", "02-442"), "czes", "czeslaw", "512-1233-12312");

		Sprzedawca sp = new Sprzedawca("Pawel", "pela", "443-232-232", "pelek@jdsg.sd", new Adres(),
				LocalDate.of(1990, 2, 1), LocalDate.now(), LocalDate.of(2020, 9, 1), "234234234");
		Sprzedawca sp2 = new Sprzedawca("Roman", "tos", "323-131-111", "romek@jdsg.sd", new Adres("Parzeniwska 12", "Pruszków","03-121"),
				LocalDate.of(1990, 2, 1), LocalDate.now(), "234234234");
		
		Sklep sklep = new Sklep("pierwszy");
		System.out.println(sp);
		
		Koszyk kosz = sklep.utworzKoszyk();
//		kosz.dodajDoKoszyka(karma1, 1.0);
//		kosz.dodajDoKoszyka(pilka, 444.0); // to wiadomo nie przechodzi
//		kosz.dodajDoKoszyka(pilka, 4.0); // wiadomo ze nie doda 4.5 sztuki pilki , ale to bedzie zweryfikowane
//											// przy gui;
		kosz.pokazZawartoscKoszyka();
		System.out.println("koszt koszyka : " + kosz.zwrocKosztKoszyka());

		Zamowienie zamowienie = new Zamowienie(kl, kosz, "blik", LocalDate.now());
		System.out.println(zamowienie.toString());
		System.out.println(zamowienie.zwrocNrZamowienia());
		
		zamowienie.akceptujZamowienie();
		System.out.println(zamowienie.sprawdzZatwierdzenie());
		Producent produc = new Producent("Kosmos");
		Karma prod = new Karma(produc,"pilka","kg"); 
		produc.wyswListeProduktow();
		
		Pracuje pracuje = new Pracuje(sp, sklep, LocalDate.now(), LocalDate.of(2020, 12, 1));
		
		//produc.usunProduktZlisty(prod);
		System.out.println(prod.toString());
		
	
		
		System.out.println(prod.toString());
		System.out.println(pracuje.toString());
		try {
		kl.znajdzZamowienie(zamowienie.nr_zamowienia);	
		kl.znajdzZamowienie("Z/1/20220");		
		kl.usunZamowienie(zamowienie);
		kl.znajdzZamowienie(zamowienie.nr_zamowienia);
		}catch (Exception e)
		{
			System.out.println(e);
		}
		
		
	}
}