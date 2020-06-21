package mp01;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mp01.Sklep.Koszyk;

public class OfertaSklepuController {

	private List<Sklep> listaSklep = new ArrayList<>();
	private ObservableList<Tabela> oferta = FXCollections.observableArrayList();
	private ObservableList<Tabela> wyswietl = FXCollections.observableArrayList();
	private List<Koszyk> koszykList = new ArrayList<>();
	private List<Tabela> ekstensje = new ArrayList<>();
	private Sklep skl;
	private Klient klient;
	private Koszyk kosz;
	private Tabela tabela;
	@FXML
	private Button dodajDoKoszykaButton;

	@FXML
	private Label zalogowanyLabel;

	@FXML
	private TableColumn<Tabela, Double> cenaColumn;

	@FXML
	private TableColumn<Tabela, String> nazwaColumn;

	@FXML
	private CheckBox zabawkaCheck;

	@FXML
	private TableView<Tabela> tableView;

	@FXML
	private Label idKoszykaLabel;

	@FXML
	private Label ileProduktuWkoszykuLabel;

	@FXML
	private CheckBox karmaCheck;

	@FXML
	private Button wrocButton;

	@FXML
	private TableColumn<Tabela, String> jednostkaColumn;

	@FXML
	private TableColumn<Tabela, String> kategoriaColumn;

	@FXML
	private Button zobaczOpisProduktuButton;

	@FXML
	private CheckBox smakolykCheck;

	@FXML
	private Label sumaZakupowLabel;

	@FXML
	private TableColumn<Tabela, Double> iloscColumn;

	@FXML
	private Button wyswietlCheckButton;

	@FXML
	void initialize() {

		klient = Klient.getKlientFromExtention(LoginController.getKlient());

		System.out.println(klient.toString() + " zalogowany ");
		zalogowanyLabel.setText("Zalogowany : " + LoginController.getKlient());
		listaSklep.addAll(Sklep.getExtent(Sklep.class));
		if (!listaSklep.isEmpty()) {
			for (Sklep sk : listaSklep) {
				if (sk.pobierzNazwe().equals("Zoo")) {
					skl = sk;
					koszykList.addAll(Koszyk.getExtent(Koszyk.class));
					for (Koszyk k : koszykList) {
						if (k.zwrocIdKoszyka().equals(1)) {
							kosz = k;
						}
					}
				}
			}
		}

		ileProduktuWkoszykuLabel.setText("Iloœæ produktów w koszyku : " + kosz.zwrocListeZakupow().size());
		nazwaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("nazwa"));
		kategoriaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("kategoria"));
		jednostkaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("jednostka"));
		iloscColumn.setCellValueFactory(new PropertyValueFactory<Tabela, Double>("ilosc"));
		cenaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, Double>("cena"));

		tableView.setItems(getOferta());

	}

	public ObservableList<Tabela> getOferta() {
		oferta = FXCollections.observableArrayList(Tabela.getExtent(Tabela.class));
		return oferta;

	}

	@FXML
	void wyswietlCheckWtableView(ActionEvent event) {
		wyswietl.clear();
		if (karmaCheck.isSelected() || zabawkaCheck.isSelected() || smakolykCheck.isSelected()) {
			if (karmaCheck.isSelected()) {
				for (Tabela of : oferta) {
					if (of.getKategoria().equals("Karma")) {
						wyswietl.add(of);
					}
				}
			}
			if (zabawkaCheck.isSelected()) {
				for (Tabela of : oferta) {
					if (of.getKategoria().equals("Zabawka")) {
						wyswietl.add(of);
					}
				}
			}
			if (smakolykCheck.isSelected()) {
				for (Tabela of : oferta) {
					if (of.getKategoria().equals("Smako³yk")) {
						wyswietl.add(of);
					}
				}
			}

			tableView.setItems(wyswietl);
		} else
			tableView.setItems(getOferta());

	}

	@FXML
	void dodajDoKoszyka(ActionEvent event) { // bedzie dodawal tylko po jednej jednostce
		Tabela tab = null;
		Produkt produkt = null;

		ekstensje.clear();

		// Karma.showExtent(Karma.class);
		ekstensje.addAll(Tabela.getExtent(Tabela.class));
		for (Tabela tb : ekstensje) {
			if (tb.getNazwa().equals(tableView.getSelectionModel().getSelectedItem().toString())) {

				produkt = skl.zwrocProdukt(tableView.getSelectionModel().getSelectedItem().toString());
				tab = tb;
				if (tab.getIlosc() >= 1) {

					tab.setIlosc(tab.getIlosc() - 1.0);
				}

			}
		}

		if (tab != null) {
			TabelaKosz temp = null;
			for (TabelaKosz ttt : kosz.zwrocListeZakupow()) {
				if (ttt.getNazwa().equals(tab.getNazwa())) {
					temp = ttt;
				}
			}
			if (tab.getIlosc() >0) {
				if (temp != null) {
					temp.dodajIlosc(1.0);
				} else {
					kosz.dodajDoListy(
							new TabelaKosz(tab.getNazwa(), tab.getKategoria(), tab.getJednostka(), 1.0, tab.getCena()));
				}

				kosz.dodajDoKoszyka(produkt, 1.0);
			}
			sumaZakupowLabel.setText("Suma zakupów : " + kosz.zwrocKosztKoszyka().toString() + " PLN");
			ileProduktuWkoszykuLabel.setText("Iloœæ produktów w koszyku : " + kosz.zwrocListeZakupow().size());
			tableView.refresh();
		}
	}

	@FXML
	void zobaczOpisProduktu(ActionEvent event) {

		System.out.println(tableView.getSelectionModel().getSelectedItem().toString());
	}

	@FXML
	void wroc(ActionEvent event) throws IOException {
		Parent decyzja = FXMLLoader.load(getClass().getResource("Decyzja.fxml"));
		Scene decyzjaViewScene = new Scene(decyzja);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(decyzjaViewScene);
		window.show();
	}

}
