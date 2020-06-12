package mp01;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class RejestracjaController {
	Boolean utworzone = false;

	@FXML
	private Label pozytywnyWynik;

	@FXML
	private Button zatwierdz;

	@FXML
	private TextField ulicaField;

	@FXML
	private Circle redCircle;

	@FXML
	private Label negatywnyWynik;

	@FXML
	private TextField emailFiled;

	@FXML
	private Button wroc;

	@FXML
	private TextField numerField;

	@FXML
	private TextField nazwiskoField;

	@FXML
	private TextField kodField;

	@FXML
	private TextField hasloField;

	@FXML
	private TextField loginField;

	@FXML
	private Circle greenCircle;

	@FXML
	private TextField imieField;

	@FXML
	private TextField miejscowoscField;

	@FXML
	private TextField nipField;

	@FXML
	void initialize() {
		pozytywnyWynik.setVisible(false);
		redCircle.setVisible(false);
		greenCircle.setVisible(false);
		negatywnyWynik.setVisible(false);

	}

	@FXML
	void zatwierdzDane(ActionEvent event) throws FileNotFoundException, IOException {
		if (utworzone == false) {
			if (!imieField.getText().toString().isEmpty() && !nazwiskoField.getText().toString().isEmpty()
					&& !emailFiled.getText().toString().isEmpty() && !numerField.getText().toString().isEmpty()
					&& !loginField.getText().toString().isEmpty() && !hasloField.getText().toString().isEmpty()) {

				Klient klient = new Klient(imieField.getText().toString(), nazwiskoField.getText().toString(),
						numerField.getText().toString(), emailFiled.getText().toString(), new Adres(),
						loginField.getText().toString(), hasloField.getText().toString(),
						nipField.getText().toString());
				System.out.println(klient.toString());
				greenCircle.setVisible(true);
				pozytywnyWynik.setVisible(true);
				redCircle.setVisible(false);
				negatywnyWynik.setVisible(false);
				utworzone = true;

			} else if (!imieField.getText().toString().isEmpty() && !nazwiskoField.getText().toString().isEmpty()
					&& !emailFiled.getText().toString().isEmpty() && !numerField.getText().toString().isEmpty()
					&& !loginField.getText().toString().isEmpty() && !hasloField.getText().toString().isEmpty()
					&& !ulicaField.getText().toString().isEmpty() && !miejscowoscField.getText().toString().isEmpty()
					&& !kodField.getText().toString().isEmpty()) {

				Klient klient = new Klient(imieField.getText().toString(), nazwiskoField.getText().toString(),
						numerField.getText().toString(), emailFiled.getText().toString(),
						new Adres(ulicaField.getText().toString(), miejscowoscField.getText().toString(),
								kodField.getText().toString()),
						loginField.getText().toString(), hasloField.getText().toString(),
						nipField.getText().toString());
				System.out.println(klient.toString());
				greenCircle.setVisible(true);
				pozytywnyWynik.setVisible(true);
				redCircle.setVisible(false);
				negatywnyWynik.setVisible(false);
				utworzone = true;

			} else {
				greenCircle.setVisible(false);
				pozytywnyWynik.setVisible(false);
				redCircle.setVisible(true);
				negatywnyWynik.setVisible(true);
			}
		}

		if (utworzone == true) {
			imieField.setEditable(false);
			nazwiskoField.setEditable(false);
			emailFiled.setEditable(false);
			numerField.setEditable(false);
			loginField.setEditable(false);
			hasloField.setEditable(false);
			ulicaField.setEditable(false);
			miejscowoscField.setEditable(false);
			kodField.setEditable(false);
			nipField.setEditable(false);
		}

	}

	@FXML
	void wrocDoEkranuLogowania(ActionEvent event) throws IOException {

		if (utworzone == true) {
			LoginController.setKlient(loginField.getText().toString());
			Parent oferta = FXMLLoader.load(getClass().getResource("Decyzja.fxml"));
			Scene ofertaViewScene = new Scene(oferta);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(ofertaViewScene);
			window.show();

		} else {
			Parent oferta = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene ofertaViewScene = new Scene(oferta);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(ofertaViewScene);
			window.show();
		}
	}

}
