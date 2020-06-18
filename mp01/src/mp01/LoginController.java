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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mp01.Sklep.Koszyk;

public class LoginController {

	private List<Klient> lista = new ArrayList<>();
	private Boolean zezwolenie = null;
	private static String klient = null;
	private List<Koszyk> listaKoszykow = new ArrayList<>(Koszyk.getExtent(Koszyk.class));
	@FXML
	private PasswordField passField;

	@FXML
	private Button registerButton;

	@FXML
	private Button loginButton;

	@FXML
	private TextField loginField;

	@FXML
	private Button zawarotscKoszyka;

	@FXML
	private Label suma;

	@FXML
	private Button wyszukaj;

	@FXML
	private TextField poleWyszukiwania;

	@FXML
	void initialize() {
		for(Koszyk k : listaKoszykow)
		{
			k.czyscListe();
		}
		// wyszukaj.setText("Dodaj do koszyka");
		// suma.setText("Ssss");
	}

	@FXML
	void registerWindow(ActionEvent event) throws IOException {
		Parent rejestracja = FXMLLoader.load(getClass().getResource("Rejestracja.fxml"));
		Scene rejestracjaViewScene = new Scene(rejestracja);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(rejestracjaViewScene);
		window.show();
	}

	@FXML
	void goToDecisionWindow(ActionEvent event) throws IOException {
		
	lista.addAll(Klient.getExtent(Klient.class));

		for (Klient ls : lista) {
			System.out.println(passField.getText().toString());
			System.out.println(ls.zwrocLogin() + " " + ls.zwrocHaslo());
			

			if (ls.zwrocHaslo().equals(passField.getText().toString())
					&& ls.zwrocLogin().equals(loginField.getText().toString())) {

				
				klient = ls.zwrocLogin();
				zezwolenie = true;
				
			}
		}
		if(zezwolenie!=null) {
			Parent decyzja = FXMLLoader.load(getClass().getResource("Decyzja.fxml"));
			Scene decyzjaViewScene = new Scene(decyzja);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(decyzjaViewScene);
			window.show();
		
		}

	}
	public static String getKlient() {
		return klient;
	}
	public static void setKlient(String name) {
		klient = name;
	}
	
}
