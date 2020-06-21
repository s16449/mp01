package mp01;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ZmianaAdresuController {

    @FXML
    private TextField kodText;

    @FXML
    private Button zapisziWrocButton;

    @FXML
    private TextField miejscowoscText;

    @FXML
    private CheckBox akceptCheck;

    @FXML
    private Button wrocButton;

    @FXML
    private TextField ulicaText;

    @FXML
    void zapiszIwroc(ActionEvent event) throws IOException {
    	Parent platnosc = FXMLLoader.load(getClass().getResource("Platnosc.fxml"));
		Scene platnoscViewScene = new Scene(platnosc);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(platnoscViewScene);
		window.show();
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
