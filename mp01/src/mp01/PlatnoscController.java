package mp01;

import java.io.IOException;
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
import javafx.stage.Stage;
import mp01.Sklep.Koszyk;

public class PlatnoscController {
	private List<Sklep> listaSklep = new ArrayList<>();
	private List<Koszyk> koszykList = new ArrayList<>();
	private Sklep sklep;
	private Koszyk kosz;
	@FXML
	private Button ZmianaAdresuuDostawyButton;

	@FXML
	private Button wrocButton;

	@FXML
	private CheckBox AkceptCheck;

	@FXML
	private Label sumaZakupowLabel;

	@FXML
	private Button DokonajPlatnosciButton;

	@FXML
	private Label loginLabel;

	@FXML
	private Label iloscProduktowLabel;

	@FXML
	void initialize() {
		loginLabel.setText("Zalogowano : " + LoginController.getKlient());
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
		sumaZakupowLabel.setText("Suma zakupów : " + kosz.zwrocKosztKoszyka().toString() + " PLN");
		iloscProduktowLabel.setText("Iloœæ produktów w koszyku : " + kosz.zwrocListeZakupow().size());
	}

	@FXML
	void dokonajPlatnosci(ActionEvent event) throws IOException {

		if (AkceptCheck.isSelected()) {
			Parent wyborPlat = FXMLLoader.load(getClass().getResource("WyborPlatnosci.fxml"));
			Scene wyborPlatnoscViewScene = new Scene(wyborPlat);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(wyborPlatnoscViewScene);
			window.show();

		}

	}

	@FXML
	void akceptacja(ActionEvent event) {

	}

	@FXML
	void adresDostawy(ActionEvent event) {

	}

	@FXML
	void wroc(ActionEvent event) throws IOException {

		Parent koszyk = FXMLLoader.load(getClass().getResource("Koszyk.fxml"));
		Scene koszykViewScene = new Scene(koszyk);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(koszykViewScene);
		window.show();
	}

}
