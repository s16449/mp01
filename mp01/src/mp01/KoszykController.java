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
	private List<Koszyk> koszykList = new ArrayList<>();

	@FXML
	private Button usunZkoszyka;

	@FXML
	private Button platnosc;

	@FXML
	private TableColumn<Tabela, Double> cenaColumn;

	@FXML
	private Label zalogowanyLabel;

	@FXML
	private TableColumn<Tabela, String> nazwaColumn;

	@FXML
	private Label iloscProdWkoszykuLabel;

	@FXML
	private TableView<Tabela> tabelaKoszyka;

	@FXML
	private TableColumn<Tabela, String> jednostkaColumn;

	@FXML
	private TableColumn<Tabela, String> kategoriaColumn;

	@FXML
	private Button wroc;

	@FXML
	private Label sumaZakupowLabel;

	@FXML
	private TableColumn<Tabela, Double> iloscColumn;

	@FXML
	private Label idKoszyka;
	ObservableList<Tabela> kosz = FXCollections.observableArrayList();
	@FXML
	private Button zobaczOpis;

	@FXML
	void initialize() {

		Sklep sklep = new Sklep("zoo");
		zalogowanyLabel.setText("Witaj : " + LoginController.getKlient());

		lista.addAll(Klient.getExtent(Klient.class));
//		Koszyk koszyczek = sklep.utworzKoszyk();
//		koszykList.add(koszyczek);
//		if(!Koszyk.getExtent(Koszyk.class).isEmpty()) {
//		koszykList.addAll(Koszyk.getExtent(Koszyk.class));
//		}
		for (Klient ls : lista) {
			if (ls.zwrocLogin().equals(LoginController.getKlient())) {
				klient = ls;
			}
		}

	

//		
//		idKoszyka.setText("Id koszyka : " + koszyczek.zwrocIdKoszyka().toString());
//		sumaZakupowLabel.setText(koszyczek.zwrocKosztKoszyka().toString());
		System.out.println(klient.toString());
	for (Koszyk k : koszykList) {
			
				System.out.println(k.toString());;
		
		}
		nazwaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("nazwa"));
		kategoriaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("kategoria"));
		jednostkaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, String>("jednostka"));
		iloscColumn.setCellValueFactory(new PropertyValueFactory<Tabela, Double>("ilosc"));
		cenaColumn.setCellValueFactory(new PropertyValueFactory<Tabela, Double>("cena"));

		tabelaKoszyka.setItems(getKoszyk());

	}

	@FXML
	void wstecz(ActionEvent event) throws IOException {

		Parent decyzja = FXMLLoader.load(getClass().getResource("Decyzja.fxml"));
		Scene decyzjaViewScene = new Scene(decyzja);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(decyzjaViewScene);
		window.show();
	}

	public void setKoszyk(ArrayList<Tabela> tab) {

		for (Tabela t : tab) {
			kosz.add(t);
		}
		kosz.add(new Tabela("asd", "assaas", "jednostka", 2.2, 22.2));

	}

	public ObservableList<Tabela> getKoszyk() {
		// ObservableList<Tabela> kosz = FXCollections.observableArrayList();
		kosz.add(new Tabela("asd", "assaas", "jednostka", 2.2, 22.2));
		return kosz;
	}

}
