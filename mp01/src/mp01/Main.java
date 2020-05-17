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

public class Main {

	public static void main(String[] args) throws Exception {

		List<Sklep> sklepLista = new ArrayList<Sklep>();
		List<MagazynWysylkowy> magazynLista = new ArrayList<MagazynWysylkowy>();
		Sklep sklep = null;
		MagazynWysylkowy magazynWysylkowy = null;
		File file = new File("save.obj");
		boolean wlacz = true;
		Zamowienie zamowienie = null;
		// Karma karma1;
		Zabawka pilka = new Zabawka("Tivo", "pilka", "szt");
		// {
		Karma karma1 = new Karma("Brit", "Brit Care Junior Large Breed", "kg");
		// } catch (Exception e) {
		// System.out.println(e);
		// }

		Karma karma2 = new Karma("Brit", "Brit Care Adult Medium Breed", "kg");
		Smakolyk smaczekMini = new Smakolyk("Brit", "Endurance", "opakowanie");

		// to musi byc na starcie bo singleton nie zadziala
		if (file.exists()) {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			Sklep.readExtent(in);
			System.out.println("Plik zaladowany.");
			in.close();
			magazynLista = MagazynWysylkowy.getExtent(MagazynWysylkowy.class);
			for (MagazynWysylkowy mw : magazynLista) {
				magazynWysylkowy = mw;
			}
			sklepLista = Sklep.getExtent(Sklep.class);
			for (Sklep ss : sklepLista) {
				sklep = ss;
			}
		} else {
			System.out.println("Brak pliku - tworze nowa instancje.");
			sklep = Sklep.getInstanceOf();
			magazynWysylkowy = MagazynWysylkowy.getInstanceOf();
		}

		Scanner keyboard = new Scanner(System.in);
		while (wlacz) {
			System.out.println(
					"\nDokonaj wyboru numeru z klawiatury:\n1.Implementacja danych.\n2.Wczytaj Dane z pliku.\n3.Zapisz Dane do pliku.\n4.Wyjdz.\n5.Kasuj plik.\n6.Wyslij zamowienia.\n7.Dodaj zamowienie.\n8.Podglad zamowien w magazynie i ich stanu.\n9.Dodaj rzeczy do sklepu.");

			String test = keyboard.nextLine();
			switch (test) {
			case "1":

				Klient kl = new Klient("Stefan", "Burczymucha", "503-232-211", "stefeg@gmail.com",
						new Adres("Opaczewska 33 m 33", "Warszawa", "02-442"), "stef", "bohnia");
				Klient kl2 = new Klient("Czeslaw", "Burczymucha", "503-222-111", "czesio@gmail.com",
						new Adres("Opaczewska 33 m 33", "Warszawa", "02-442"), "czes", "czeslaw", "512-1233-12312");

				Sprzedawca sp = new Sprzedawca("Pawel", "pela", "443-232-232", "pelek@jdsg.sd", new Adres(),
						LocalDate.of(1990, 2, 1), LocalDate.now(), LocalDate.of(2020, 9, 1), "234234234");
				Sprzedawca sp2 = new Sprzedawca("Roman", "tos", "323-131-111", "romek@jdsg.sd", new Adres("Parzeniwska 12", "Pruszków","03-121"),
						LocalDate.of(1990, 2, 1), LocalDate.now(), "234234234");
				
				
				System.out.println(sp);
				
				Koszyk kosz = new Koszyk(sklep);
				kosz.dodajDoKoszyka(karma1, 1.0);
				kosz.dodajDoKoszyka(pilka, 444.0); // to wiadomo nie przechodzi
				kosz.dodajDoKoszyka(pilka, 4.0); // wiadomo ze nie doda 4.5 sztuki pilki , ale to bedzie zweryfikowane
													// przy gui;
				kosz.pokazZawartoscKoszyka();
				System.out.println("koszt koszyka : " + kosz.zwrocKosztKoszyka());

				zamowienie = new Zamowienie(kl, kosz, "blik", LocalDate.now());

				zamowienie.akceptujZamowienie();

				System.out.println("\n-------------PO DODANIU PRODUKTOW : CENY --------------");
				sklep.pokazListeProduktow();
				System.out.println("\n-------------PO DODANIU PRODUKTOW : ILOSCI --------------");
				sklep.pokazDostepnaIloscProduktow();
				System.out.println("\n----------Dostepna ilosc dla karma1 ----------------");
				sklep.pokazDostepnaIloscProduktow(karma1);
				break;
			case "2":
				if (file.exists())

				{
					ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
					Sklep.readExtent(in);
					System.out.println("file load");
					in.close();

					magazynLista = MagazynWysylkowy.getExtent(MagazynWysylkowy.class);
					for (MagazynWysylkowy mw : magazynLista) {
						magazynWysylkowy = mw;

					}
					sklepLista = Sklep.getExtent(Sklep.class);
					for (Sklep ss : sklepLista) {
						sklep = ss;
					}
				} else {
					sklep = Sklep.getInstanceOf();
					magazynWysylkowy = MagazynWysylkowy.getInstanceOf();
				}
				System.out.println("Stan po wgraniu pliku :");
				Osoba.showExtent(Klient.class);
				Osoba.showExtent(Sprzedawca.class);
				Osoba.showExtent(Koszyk.class);

				break;
			case "3":
				ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
				Osoba.writeExtent(out);

				out.close();
				break;
			case "4":
				wlacz = false;
				keyboard.close();

				break;
			case "5":
				file.delete();
				System.out.println("Plik usuniety.");
				break;
			case "6":
				magazynWysylkowy.wyslijZamowienia();
				break;
			case "7":

				if (zamowienie != null) {
					magazynWysylkowy.dodajDoListy(zamowienie);
					zamowienie.akceptujZamowienie();
					
				}
				zamowienie.pokazNajlepszegoKlienta();
				break;
			case "8":
				magazynWysylkowy.pokazListeZamowien();
				break;
			case "9":
				sklep.dodajProdukt(pilka, 32.12);
				sklep.dodajProdukt(smaczekMini, 19.90);
				sklep.dodajProdukt(karma1, 159.99);
				sklep.dodajProdukt(karma2, 149.99);
				sklep.dodajIloscProduktu(pilka, 5.0);
				sklep.dodajIloscProduktu(karma1, 14.9);
				sklep.dodajIloscProduktu(karma2, 14.9 * 3);
				sklep.dodajIloscProduktu(smaczekMini, 30.0);
				break;

			}
		}
	}
}
