package pl.gornik.projektjavafx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField txtName, txtSurname, txtPressure, txtWeight, txtHeight;

    @FXML
    private Spinner<Integer> spnAge;

    @FXML
    private Button btnSubmit1, btnSubmit2, btnSubmit3;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(18, 60, 18);
        spnAge.setValueFactory(valueFactory);

        btnSubmit1.setOnAction(event -> {

        });
    }
}
