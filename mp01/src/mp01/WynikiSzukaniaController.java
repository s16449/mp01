package mp01;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mp01.Sklep.Koszyk;

public class WynikiSzukaniaController {

	private List<Sklep> listaSklep = new ArrayList<>();
	private ObservableList<Tabela> oferta = FXCollections.observableArrayList();
	private ObservableList<Tabela> wyswietl = FXCollections.observableArrayList();
	private List<Tabela> ekstensje = new ArrayList<>();
	private List<Koszyk> koszykList = new ArrayList<>();
	private Sklep skl;
	private Klient klient;
	private Koszyk kosz;
	@FXML
	private Button dodajDoKoszykaButton;

	@FXML
	private TableColumn<Tabela, Double> cenaColumn;

	@FXML
	private Label zalogowanyLabel;

	@FXML
	private Button zobaczOpisButton;

	@FXML
	private TableColumn<Tabela, String> nazwaColumn;

	@FXML
	private Button pokazZawartoscKoszykaButton;

	@FXML
	private Button wrocButton;

	@FXML
	private TableColumn<Tabela, String> jednostkaColumn;

	@FXML
	private TableColumn<Tabela, String> kategoriaColumn;

	@FXML
	private Label iloscZakupowLabel;

	@FXML
	private Label sumaZakupowLabel;

	@FXML
	private TableColumn<Tabela, Double> iloscColumn;

	@FXML
	private TableView<Tabela> tableView;

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

		sumaZakupowLabel.setText("Suma zakupów : " + kosz.zwrocKosztKoszyka().toString() + " PLN");
		iloscZakupowLabel.setText("Iloœæ produktów w koszyku : " + kosz.zwrocListeZakupow().size());

		nazwaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("nazwa"));
		kategoriaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("kategoria"));
		jednostkaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("jednostka"));
		iloscColumn.setCellValueFactory(new PropertyValueFactory<Tabela, Double>("ilosc"));
		cenaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, Double>("cena"));

		tableView.setItems(getOferta());

	}

	public ObservableList<Tabela> getOferta() {
		wyswietl.clear();
		String szukanie = DecisionController.getPoleSzukania();
		System.out.println(szukanie);
		oferta = FXCollections.observableArrayList(Tabela.getExtent(Tabela.class));
		for (Tabela tb : oferta) {
			if (tb.getNazwa().toLowerCase().contains(szukanie.toLowerCase())) {
				wyswietl.add(tb);
				System.out.println(tb);
				// return wyswietl;
			}
		}
		if (!wyswietl.isEmpty()) {
			return wyswietl;
		}
		return oferta;

	}

	@FXML
	void DodajDoKoszyka(ActionEvent event) {
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
				System.out.println("niedodaje");
			}
			sumaZakupowLabel.setText("Suma zakupów : " + kosz.zwrocKosztKoszyka().toString() + " PLN");
			iloscZakupowLabel.setText("Iloœæ produktów w koszyku : " + kosz.zwrocListeZakupow().size());
			tableView.refresh();
		}

	}

	@FXML
	void wroc(ActionEvent event) throws IOException {
		Parent decyzja = FXMLLoader.load(getClass().getResource("Decyzja.fxml"));
		Scene decyzjaViewScene = new Scene(decyzja);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(decyzjaViewScene);
		window.show();
	}

	@FXML
	void ZobaczOpis(ActionEvent event) {

	}

	@FXML
	void pokazZawartoscKoszyka(ActionEvent event) throws IOException {
		Parent koszyk = FXMLLoader.load(getClass().getResource("Koszyk.fxml"));
		Scene koszykViewScene = new Scene(koszyk);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(koszykViewScene);
		window.show();
	}

}
