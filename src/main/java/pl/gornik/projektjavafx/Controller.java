package pl.gornik.projektjavafx;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField txtName, txtSurname, txtPressure, txtWeight, txtHeight, txtCategory;

    @FXML
    private Spinner<Integer> spnAge;

    @FXML
    private Button btnSubmit1, btnSubmit2, btnSubmit3, btnSubmit4, btnClose;

    @FXML
    private ChoiceBox<String> chUrine;

    @FXML
    private ToggleGroup radBlood;

    @FXML
    private RadioButton radBlood1, radBlood2, radBlood3, radBlood4;

    @FXML
    private ListView<String> lisResults;

    @FXML
    private Slider sldCategory;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextArea txtOpinion1, txtOpinion2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[a-zA-Z]*")) {
                txtName.setText(newValue);
            } else {
                txtName.setText(oldValue);
            }
        });

        txtSurname.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches("[a-zA-Z]*")) {
                txtSurname.setText(newValue);
            } else {
                txtSurname.setText(oldValue);
            }
        });

        txtPressure.textProperty().addListener((observable, oldValue, newValue) -> {
            String regex = "^\\d{1,3}/\\d{1,2}$";

            if (newValue.matches(regex)) {
                txtPressure.setText(newValue);
            } else {
                txtPressure.setText(oldValue);
            }
        });

        txtWeight.textProperty().addListener((observable, oldValue, newValue) -> {
            String regex = "^\\d{0,3}(\\.\\d{0,2})?$";

            if (newValue.matches(regex)) {
                txtWeight.setText(newValue);
            } else {
                txtWeight.setText(oldValue);
            }
        });

        txtHeight.textProperty().addListener((observable, oldValue, newValue) -> {
            String regex = "^\\d{0,3}(\\.\\d{0,2})?$";

            if (newValue.matches(regex)) {
                txtHeight.setText(newValue);
            } else {
                txtHeight.setText(oldValue);
            }
        });

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(18, 60, 18);
        spnAge.setValueFactory(valueFactory);

        chUrine.getItems().addAll("W normie", "Zbyt ciemna barwa", "Zbyt jasna barwa");

        chUrine.setValue("W normie");


        btnSubmit1.setOnAction(event -> {
            String name = txtName.getText();
            String surname = txtSurname.getText();
            Integer age = spnAge.getValue();

            String result = "Imię: " + name + ", Nazwisko: " + surname + ", Wiek: " + age;
            lisResults.getItems().add(result);

            tabPane.getSelectionModel().selectNext();

            txtName.clear();
            txtSurname.clear();
        });


        btnSubmit2.setOnAction(event -> {
            String pressure = txtPressure.getText();
            String weight = txtWeight.getText();
            String height = txtHeight.getText();


        String result = "Ciśnienie: " + pressure + ", Waga: " + weight + ", Wzrost: " + height;
        lisResults.getItems().add(result);

            tabPane.getSelectionModel().selectNext();

            txtPressure.clear();
            txtWeight.clear();
            txtHeight.clear();
    });

        btnSubmit3.setOnAction(event -> {
            RadioButton selectedRadioButton = (RadioButton) radBlood.getSelectedToggle();
            String bloodSelected;
            if (selectedRadioButton != null) {
                bloodSelected = selectedRadioButton.getText();
            } else {
                bloodSelected = "Nie wybrano";
            }

            String urineSelected = chUrine.getValue();

            String result = "Krew: " + bloodSelected + ", Mocz: " + urineSelected;
            lisResults.getItems().add(result);

            tabPane.getSelectionModel().selectNext();

            if (radBlood.getSelectedToggle() != null) {
                radBlood.getSelectedToggle().setSelected(false);
            }

            if (!chUrine.getItems().isEmpty()) {
                chUrine.setValue(chUrine.getItems().get(0));
            }
        });

        btnSubmit4.setOnAction(event -> {
            String opinion1 = txtOpinion1.getText();
            String opinion2 = txtOpinion2.getText();

            String result1 = "Opinia psychiatry: " + opinion1;
            String result2 = "Opinia neurologa: " + opinion2;
            lisResults.getItems().add(result1);
            lisResults.getItems().add(result2);

            tabPane.getSelectionModel().selectNext();

            txtOpinion1.clear();
            txtOpinion2.clear();
        });

        sldCategory.valueProperty().addListener((observable, oldValue, newValue) -> {
            int categoryValue = newValue.intValue();

            char categoryLetter = (char) ('E' - (categoryValue - 1));

            txtCategory.setText(String.valueOf(categoryLetter));
        });

        btnClose.setOnAction(event -> Platform.exit());



    }
}
