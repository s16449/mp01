package mp01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Main  {

	public static void main(String[] args)
			throws ZlaJednostkaException, FileNotFoundException, IOException, ClassNotFoundException {
		DataCheck dc = new DataCheck();
		System.out.println(dc.getCurrentFullData());
		Sklep sklep = Sklep.getInstanceOf();

		MagazynWysylkowy magazynWysylkowy = MagazynWysylkowy.getInstanceOf();

		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new
		FileInputStream("save.obj")));
	Sklep.readExtent(in);
	 System.out.println("file load");
		 in.close();
		Klient.getExtent(Karma.class);
		 Osoba.showExtent(Klient.class);
		 Osoba.showExtent(Zabawka.class);
		 Osoba.showExtent(Sklep.class);
		// Osoba.showExtent(Zabawka.class);
		

		 

	//	Klient kl = new Klient("Mariusz", "Polak", "503-232-211", "mariuszp@gmail.com",
	//			new Adres("Opaczewska 55 m 33", "Warszawa", "02-442"), 1, "maniek", "bohnia", null);
/*
		Sprzedawca sp;
		try {
			sp = new Sprzedawca("Pawel", "pela", "443-232-232", "pelek@jdsg.sd", new Adres(), 1, new Date(0),
					"234234234");
			System.out.println(sp);

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println(kl);

		Zabawka pilka = new Zabawka("Tivo", "pilka", "szt");
		Karma karma1 = new Karma("Brit", "Brit Care Junior Large Breed", "kg");
		Karma karma2 = new Karma("Brit", "Brit Care Adult Medium Breed", "kg");
		Smakolyk smaczekMini = new Smakolyk("Brit", "Endurance", "opakowanie");

		sklep.dodajProdukt(pilka, 32.12);
		sklep.dodajProdukt(smaczekMini, 19.90);
		sklep.dodajProdukt(karma1, 159.99);
		sklep.dodajProdukt(karma2, 149.99);
		sklep.dodajIloscProduktu(pilka, 20.0);
		sklep.dodajIloscProduktu(karma1, 14.9);
		sklep.dodajIloscProduktu(karma2, 14.9 * 3);
		sklep.dodajIloscProduktu(smaczekMini, 30.0);

		Koszyk kosz = new Koszyk();
		kosz.dodajDoKoszyka(karma2, 6.0);
		kosz.dodajDoKoszyka(pilka, 444.0);
		kosz.dodajDoKoszyka(pilka, 4.0);

		kosz.pokazZawartoscKoszyka();

		Zamowienie zamowienie = new Zamowienie(kl, kosz, "blik", new Date(0));
		System.out.println(zamowienie.toString());
		zamowienie.akceptujZamowienie();

		System.out.println("--------------------MAGAZYN--------------");
		magazynWysylkowy.dodajDoListy(zamowienie);
		magazynWysylkowy.pokazListeZamowien();
		magazynWysylkowy.wyslijZamowienia();
		System.out.println("--------------------MAGAZYN--------------");

		System.out.println("--------------------MAGAZYN PO WYSLANIU--------------");
	
		magazynWysylkowy.pokazListeZamowien();
		System.out.println("--------------------MAGAZYN PO WYSLANIU--------------");

		System.out.println("\n-------------PO DODANIU PRODUKTOW Z CENAMI --------------");
		sklep.pokazListeProduktow();
		System.out.println("\n----------PO DODANIU ILOSCI ----------------");
		sklep.pokazDostepnaIloscProduktow();

		sklep.zmienCeneProduktu(pilka, 245.0);
		System.out.println("\n--------------- PO ZMIANIE CENY ------------");
		sklep.pokazListeProduktow();

		// sklep.usunProdukt(karma1);
		System.out.println("\n--------------- PO USUNIECIU PRODUKTU	Z OFERTY ------------");
		sklep.pokazListeProduktow();
	*/
		System.out.println("\n----------ILOSCI ----------------");
		sklep.pokazDostepnaIloscProduktow();

		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("save.obj")));
		Osoba.writeExtent(out);
		out.close();
		

	}
}
