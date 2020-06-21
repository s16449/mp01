package mp01;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import mp01.Sklep.Koszyk;

public class WyborPlatnosciController {
	private List<Sklep> listaSklep = new ArrayList<>();
	private List<Koszyk> koszykList = new ArrayList<>();
	private List<Zamowienie> zamowienieList = new ArrayList<>();
	private List<Klient> listaKlientow = new ArrayList<>();
	private Sklep sklep;
	private Koszyk kosz;
	private Klient klient;

	@FXML
	private Label loginInfoLabel;

	@FXML
	private CheckBox przelewCheck;

	@FXML
	private Button platnoscButton;

	@FXML
	private CheckBox payuCheck;

	@FXML
	private Label sumaZakupowLabel;

	@FXML
	private Label produktywKoszykuLabel;

	@FXML
	private Label zamowienieLabel;

	@FXML
	private CheckBox blikCheck;

	@FXML
	private CheckBox akceptCheck;

	@FXML
	private CheckBox odbiorCheck;

	@FXML
	private Button wrocButton;
	@FXML
	private RadioButton payuRadio;

	@FXML
	private RadioButton blikRadio;

	@FXML
	private RadioButton przelewRadio;

	@FXML
	private RadioButton przyOdbRadio;

	@FXML
	void initialize() {
		
		zamowienieLabel.setVisible(false);
		loginInfoLabel.setText("Zalogowano : " + LoginController.getKlient());
		listaSklep.addAll(Sklep.getExtent(Sklep.class));

		if (!listaSklep.isEmpty()) {
			for (Sklep sk : listaSklep) {
				if (sk.pobierzNazwe().equals("Zoo")) {
					sklep = sk;
					koszykList.addAll(Koszyk.getExtent(Koszyk.class));
					for (Koszyk k : koszykList) {
						if (k.zwrocIdKoszyka().equals(1)) {
							kosz = k;
						}
					}
				}
			}
		}
		listaKlientow.addAll(Klient.getExtent(Klient.class));
		for (Klient kl : listaKlientow) {
			if (kl.zwrocLogin().equals(LoginController.getKlient())) {
				klient = kl;
			}

		}
		klient.pokazZamowienia();
		System.out.println(klient.zwrocSumeZakupowKlienta());
		sumaZakupowLabel.setText("Suma zakupów : " + kosz.zwrocKosztKoszyka().toString() + " PLN");
		produktywKoszykuLabel.setText("Iloœæ produktów w koszyku : " + kosz.zwrocListeZakupow().size());
	}

	@FXML
	void dokonajPlatnosci(ActionEvent event) {
		String platnosc = "inne";
		if (akceptCheck.isSelected()) {

			if (blikCheck.isSelected()) {
				platnosc = "BLIK";
			} else if (odbiorCheck.isSelected()) {
				platnosc = "Odbior Osobisty";
			} else if (payuCheck.isSelected()) {
				platnosc = "PayU";
			} else if (przelewCheck.isSelected()) {
				platnosc = "Pzelew";
			}

			Zamowienie zm = new Zamowienie(klient, kosz, platnosc, LocalDate.now());
			System.out.println(zm);
			kosz.czyscListe();
			zamowienieLabel.setText("Twój numer zamówienia : " + zm.zwrocNrZamowienia());
			zamowienieLabel.setVisible(true);
			Zamowienie.showExtent(Zamowienie.class);

		}

	}

	@FXML
	void wroc(ActionEvent event) throws IOException {

		Parent platnosc = FXMLLoader.load(getClass().getResource("Platnosc.fxml"));
		Scene platnoscViewScene = new Scene(platnosc);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(platnoscViewScene);
		window.show();
	}

}