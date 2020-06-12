package mp01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DecisionController {

    @FXML
    private Button zawarotscKoszyka;

    @FXML
    private Label suma;

    @FXML
    private Button wyszukaj;

    @FXML
    private TextField poleWyszukiwania;
    @FXML
    private Label helloLabel;
    @FXML
    private Button pokazOferte;

    @FXML
	void initialize() {
    	helloLabel.setText("Witaj : " + LoginController.getKlient());
	
	}
    
    @FXML
    void pokazOferteSklepu(ActionEvent event) throws IOException {
    	Parent oferta = FXMLLoader.load(getClass().getResource("OfertaSklepu.fxml"));
		Scene ofertaViewScene = new Scene(oferta);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(ofertaViewScene);
		window.show();
    }

    @FXML
    void koszyk(ActionEvent event) throws IOException {

    	Parent koszyk = FXMLLoader.load(getClass().getResource("Koszyk.fxml"));
		Scene koszykViewScene = new Scene(koszyk);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(koszykViewScene);
		window.show();
    }

   
            
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
		if(event.getCode().equals(KeyCode.ENTER))
		{
			System.out.println(poleWyszukiwania.getText());
			poleWyszukiwania.clear();
			Parent wyszukaj = FXMLLoader.load(getClass().getResource("Wyniki_szukania.fxml"));
			Scene wyszukajViewScene = new Scene(wyszukaj);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(wyszukajViewScene);
			window.show();
		}
	}
    
    @FXML
    void wyszukaj(ActionEvent event) throws IOException {

    	Parent wyszukaj = FXMLLoader.load(getClass().getResource("Wyniki_szukania.fxml"));
		Scene wyszukajViewScene = new Scene(wyszukaj);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(wyszukajViewScene);
		window.show();
    }

	
}
