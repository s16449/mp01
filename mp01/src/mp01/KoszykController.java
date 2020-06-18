package mp01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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

public class KoszykController {

	private Klient klient;
	private ArrayList<Klient> lista = new ArrayList<>();
	private List<Sklep> listaSklep = new ArrayList<>();
	private List<Koszyk> koszykList = new ArrayList<>();
	private List<TabelaKosz> ekstensje = new ArrayList<>();
	private Sklep sklep;
	private Koszyk kosz;
	@FXML
	private Button usunZkoszykaButton;

	@FXML
	private Button platnosc;

	@FXML
	private TableColumn<TabelaKosz, Double> cenaColumn;

	@FXML
	private Button zobaczOpisButton;
	@FXML
	private Label zalogowanyLabel;

	@FXML
	private TableColumn<TabelaKosz, String> nazwaColumn;

	@FXML
	private Label iloscProdWkoszykuLabel;

	@FXML
	private TableView<TabelaKosz> tabelaKoszyka;

	@FXML
	private TableColumn<TabelaKosz, String> jednostkaColumn;

	@FXML
	private TableColumn<TabelaKosz, String> kategoriaColumn;

	@FXML
	private Button wroc;

	@FXML
	private Label sumaZakupowLabel;

	@FXML
	private TableColumn<TabelaKosz, Double> iloscColumn;

	@FXML
	private Label idKoszyka;
	ObservableList<TabelaKosz> koszView = FXCollections.observableArrayList();

	int count = 1;

	@FXML
	void initialize() {

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
		zalogowanyLabel.setText("Witaj : " + LoginController.getKlient());

		lista.addAll(Klient.getExtent(Klient.class));

		for (Klient ls : lista) {
			if (ls.zwrocLogin().equals(LoginController.getKlient())) {
				klient = ls;
			}
		}

		System.out.println(klient.toString());
		for (Koszyk k : koszykList) {

			System.out.println(k.toString());
			;

		}
		nazwaColumn.setCellValueFactory(new PropertyValueFactory<TabelaKosz, String>("nazwa"));
		kategoriaColumn.setCellValueFactory(new PropertyValueFactory<TabelaKosz, String>("kategoria"));
		jednostkaColumn.setCellValueFactory(new PropertyValueFactory<TabelaKosz, String>("jednostka"));
		iloscColumn.setCellValueFactory(new PropertyValueFactory<TabelaKosz, Double>("ilosc"));
		cenaColumn.setCellValueFactory(new PropertyValueFactory<TabelaKosz, Double>("cena"));

		tabelaKoszyka.setItems(setKoszyk(kosz.zwrocListeZakupow()));
		Integer rows = tabelaKoszyka.getItems().size();
		iloscProdWkoszykuLabel.setText("Iloœæ produktów w koszyku : " + rows.toString());

	}

	@FXML
	void wstecz(ActionEvent event) throws IOException {

		Parent decyzja = FXMLLoader.load(getClass().getResource("Decyzja.fxml"));
		Scene decyzjaViewScene = new Scene(decyzja);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(decyzjaViewScene);
		window.show();
	}

	public ObservableList<TabelaKosz> setKoszyk(List<TabelaKosz> tab) {

		for (Tabela t : tab) {
			koszView.add(new TabelaKosz(t.getNazwa(), t.getKategoria(), t.getJednostka(), t.getIlosc(), t.getCena()));
		}

		return koszView;

	}

	public ObservableList<TabelaKosz> removeKoszyk(List<Tabela> tab) {

		for (Tabela t : tab) {
			koszView.remove(t);
		}

		return koszView;

	}

	@FXML
	void usunZkoszyka(ActionEvent event) {

		TabelaKosz tabk = null;
		if (!kosz.zwrocListeZakupow().isEmpty()) {
			for (TabelaKosz tk : kosz.zwrocListeZakupow()) {
				if (tk.getNazwa().equals(tabelaKoszyka.getSelectionModel().getSelectedItem().toString())) {
					tabk = tk;
				}
			}
		}
		if (tabk != null) {

			kosz.usunZlisty(tabk, tabk.getIlosc());

		}
		sumaZakupowLabel.setText("Suma zakupów : " + kosz.zwrocKosztKoszyka().toString() + " PLN");

		iloscProdWkoszykuLabel.setText("Iloœæ produktów w koszyku : " + kosz.zwrocListeZakupow().size());
		tabelaKoszyka.refresh();
		
	}

	@FXML
	void zobaczOpis(ActionEvent event) {

	}

	@FXML
	void przejdzDoPlatnosci(ActionEvent event) throws IOException {
		Parent platnosc = FXMLLoader.load(getClass().getResource("Platnosc.fxml"));
		Scene platnoscViewScene = new Scene(platnosc);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(platnoscViewScene);
		window.show();
	}

}
