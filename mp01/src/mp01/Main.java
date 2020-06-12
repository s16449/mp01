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

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mp01.Sklep.Koszyk;

public class Main extends Application {

	public static void main(String[] args) throws Exception {
		
		List<Sklep> sklepLista = new ArrayList<Sklep>();
		List<MagazynWysylkowy> magazynLista = new ArrayList<MagazynWysylkowy>();
		Sklep sklep = null;
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
//			sklepLista = Sklep.getExtent(Sklep.class);
//			for (Sklep ss : sklepLista) {
//				sklep = ss;
//			}
		} else {
			System.out.println("Brak pliku - tworze nowa instancje.");
		//	sklep = Sklep.getInstanceOf();
			magazynWysylkowy = MagazynWysylkowy.getInstanceOf();
		}
		
		Klient kl = new Klient("Stefan", "Burczymucha", "503-232-211", "stefeg@gmail.com", new Adres(), "stef",
				"bohnia");
		Klient kl2 = new Klient("Czeslaw", "Burczymucha", "503-222-111", "czesio@gmail.com",
				new Adres("Opaczewska 33 m 33", "Warszawa", "02-442"), "czes", "czeslaw", "512-1233-12312");

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
//			sklepLista = Sklep.getExtent(Sklep.class);
//			for (Sklep ss : sklepLista) {
//				sklep = ss;
//			}
		} else {
			//sklep = Sklep.getInstanceOf();
			magazynWysylkowy = MagazynWysylkowy.getInstanceOf();
		}
		System.out.println("Stan po wgraniu pliku :");
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		Osoba.writeExtent(out);

		out.close();
		Osoba.showExtent(Klient.class);
		Osoba.showExtent(Sprzedawca.class);
		Osoba.showExtent(Koszyk.class);

		launch(args);
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