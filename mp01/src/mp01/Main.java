package mp01;

import java.io.BufferedOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

import java.util.List;
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
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import mp01.Sklep.Koszyk;

public class Main extends Application {

	public static void main(String[] args) throws Exception {

		List<Sklep> sklepLista = new ArrayList<Sklep>();
		List<MagazynWysylkowy> magazynLista = new ArrayList<MagazynWysylkowy>();
		List<Koszyk> koszykList = new ArrayList<>();
		Sklep sklep = null;
		Koszyk kosz = null;
		MagazynWysylkowy magazynWysylkowy = null;
		File file = new File("save.obj");
		boolean wlacz = true;
		Zamowienie zamowienie = null;

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
				if (ss.pobierzNazwe().equals("Zoo"))
					sklep = ss;
				koszykList.addAll(Koszyk.getExtent(Koszyk.class));
				for (Koszyk k : koszykList) {
					if (k.zwrocIdKoszyka().equals(1)) {
						kosz = k;
					}
				}

			}

		} else {
			System.out.println("Brak pliku - tworze nowa instancje.");
			// sklep = Sklep.getInstanceOf();
			magazynWysylkowy = MagazynWysylkowy.getInstanceOf();
			sklep = new Sklep("Zoo");
			kosz = sklep.utworzKoszyk();
		}

		Klient kl = new Klient("Stefan", "Burczymucha", "503-232-211", "stefeg@gmail.com", new Adres(), "stef",
				"bohnia");
		Klient kl2 = new Klient("Czeslaw", "Burczymucha", "503-222-111", "czesio@gmail.com",
				new Adres("Opaczewska 33 m 33", "Warszawa", "02-442"), "czes", "czeslaw", "512-1233-12312");

		

		Producent pr1 = new Producent("Brit");
		System.out.println(pr1.toString());
		Producent pr2 = new Producent("Taste of the Wild");
		System.out.println(pr2.toString());
		Producent pr3 = new Producent("Carnilove");
		System.out.println(pr3.toString());
		Producent pr4 = new Producent("KONG");
		Producent pr5 = new Producent("Fit&Fun");
		
		Karma kr1 = new Karma(pr1, "Adult Large Breed : Lamb & Rice", "kilogram");
		Karma kr2 = new Karma(pr1, "Junior Large Breed : Salmon & Herring ", "kilogram");
		Karma kr3 = new Karma(pr1, "Adult Medium Breed : Lamb & Rice ", "kilogram");
		Karma kr4 = new Karma(pr1, "Senior All Breed : Salmon & Herring", "kilogram");
		Karma kr5 = new Karma(pr1, "Adult Medium Breed : Lamb & Rice", "kilogram");
		Karma kr6 = new Karma(pr2, "Pacific Stream", "kilogram");
		Karma kr7 = new Karma(pr2, "Wetlands", "kilogram");
		Karma kr8 = new Karma(pr2, "SouthWest Canyon", "kilogram");
		Karma kr9 = new Karma(pr2, "Sierra Mountain", "kilogram");

		Smakolyk sm1 = new Smakolyk(pr1, "Mineral Hum Puppy", "opakowanie");
		Smakolyk sm2 = new Smakolyk(pr1, "Meat Snacks : Pure Salmon Slices", "opakowanie");
		Smakolyk sm3 = new Smakolyk(pr1, "Endurance : Lamb enriched with Banana", "opakowanie");
		Smakolyk sm4 = new Smakolyk(pr1, "Antiparasitic  : Salmon enriched with Chamomile", "opakowanie");
		Smakolyk sm5 = new Smakolyk(pr3, "Snack Dog Duck & Rosemary", "opakowanie");
		Smakolyk sm6 = new Smakolyk(pr3, "Snack Fresh Soft Quail + Oregano", "opakowanie");
		Smakolyk sm7 = new Smakolyk(pr3, "Snack Dog Trout & Dill", "opakowanie");

		Zabawka zb1 = new Zabawka(pr4, "Goodie Bone Puppy", "Sztuka");
		Zabawka zb2 = new Zabawka(pr5, "Pi³ka tenisowa", "Sztuka");
		Zabawka zb3 = new Zabawka(pr4, "Zabawka dla szczeni¹t Puppy S", "Sztuka");
		Zabawka zb4 = new Zabawka(pr4, "Frisbee czerwone", "Sztuka");
		
		sklep.dodajProdukt(zb1, 19.50);
		sklep.dodajProdukt(zb2, 2.50);
		sklep.dodajProdukt(zb3, 22.70);
		sklep.dodajProdukt(zb4, 39.50);
		sklep.dodajIloscProduktu(zb1, 12.0);
		sklep.dodajIloscProduktu(zb2, 43.0);
		sklep.dodajIloscProduktu(zb3, 10.0);
		sklep.dodajIloscProduktu(zb4, 8.0);
		
		
		
		
		sklep.dodajProdukt(sm1, 11.0);
		sklep.dodajProdukt(sm2, 12.0);
		sklep.dodajProdukt(sm3, 12.0);
		sklep.dodajProdukt(sm4, 12.0);
		sklep.dodajProdukt(sm5, 9.0);
		sklep.dodajProdukt(sm6, 9.0);
		sklep.dodajProdukt(sm7, 9.0);
		sklep.dodajIloscProduktu(sm1, 100.0);
		sklep.dodajIloscProduktu(sm2, 190.0);
		sklep.dodajIloscProduktu(sm3, 70.0);
		sklep.dodajIloscProduktu(sm4, 50.0);
		sklep.dodajIloscProduktu(sm5, 40.0);
		sklep.dodajIloscProduktu(sm6, 120.0);
		sklep.dodajIloscProduktu(sm7, 129.0);

		
		
		sklep.dodajProdukt(kr1, 10.0);
		sklep.dodajProdukt(kr2, 12.0);
		sklep.dodajProdukt(kr3, 11.50);
		sklep.dodajProdukt(kr4, 12.50);
		sklep.dodajProdukt(kr5, 9.50);

		sklep.dodajProdukt(kr6, 14.00);
		sklep.dodajProdukt(kr7, 15.50);
		sklep.dodajProdukt(kr8, 19.00);
		sklep.dodajProdukt(kr9, 19.90);

		sklep.dodajIloscProduktu(kr1, 140.0);
		sklep.dodajIloscProduktu(kr2, 100.0);
		sklep.dodajIloscProduktu(kr3, 200.0);
		sklep.dodajIloscProduktu(kr4, 340.0);
		sklep.dodajIloscProduktu(kr5, 200.0);

		sklep.dodajIloscProduktu(kr6, 180.0);
		sklep.dodajIloscProduktu(kr7, 290.0);
		sklep.dodajIloscProduktu(kr8, 300.0);
		sklep.dodajIloscProduktu(kr9, 233.0);

		sklep.pokazListeProduktow();
		
		
		System.out.println("======================================");
		sklep.utworzTabele(sm1);
		sklep.utworzTabele(sm2);
		sklep.utworzTabele(sm3);
		sklep.utworzTabele(sm4);
		sklep.utworzTabele(sm5);
		sklep.utworzTabele(sm6);
		sklep.utworzTabele(sm7);
		sklep.utworzTabele(kr1);
		sklep.utworzTabele(kr2);
		sklep.utworzTabele(kr3);
		sklep.utworzTabele(kr4);
		sklep.utworzTabele(kr5);
		sklep.utworzTabele(kr6);
		sklep.utworzTabele(kr7);
		sklep.utworzTabele(kr8);
		sklep.utworzTabele(kr9);
		sklep.utworzTabele(zb1);
		sklep.utworzTabele(zb2);
		sklep.utworzTabele(zb3);
		sklep.utworzTabele(zb4);
//		
		
		
	
		//Tabela.showExtent(Tabela.class);
		//sklep.pokazDostepnaIloscProduktow(sm7);
		System.out.println("======================================");

		launch(args);

		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		Koszyk.writeExtent(out);
	
		out.close();
	
		System.out.println("zapisano");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("Login.fxml"));
		Parent root = loader.load();
		// LoginController loginController = loader.getController();
		primaryStage.setTitle("Sklep z artyku³ami dla zwierz¹t");
		// primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(true);
		primaryStage.centerOnScreen();
		primaryStage.show();

	}
}