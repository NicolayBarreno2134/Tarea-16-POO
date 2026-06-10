package proyecto16.proyecto16;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class EncuestaController {

    @FXML private RadioButton r1a, r1b, r1c, r1d;
    @FXML private RadioButton r2a, r2b, r2c, r2d;
    @FXML private RadioButton r3a, r3b, r3c, r3d;
    @FXML private RadioButton r4a, r4b, r4c, r4d;
    @FXML private Label lblError;

    private ToggleGroup grupo1, grupo2, grupo3, grupo4;

    @FXML
    public void initialize() {
        grupo1 = new ToggleGroup();
        r1a.setToggleGroup(grupo1);
        r1b.setToggleGroup(grupo1);
        r1c.setToggleGroup(grupo1);
        r1d.setToggleGroup(grupo1);

        grupo2 = new ToggleGroup();
        r2a.setToggleGroup(grupo2);
        r2b.setToggleGroup(grupo2);
        r2c.setToggleGroup(grupo2);
        r2d.setToggleGroup(grupo2);

        grupo3 = new ToggleGroup();
        r3a.setToggleGroup(grupo3);
        r3b.setToggleGroup(grupo3);
        r3c.setToggleGroup(grupo3);
        r3d.setToggleGroup(grupo3);

        grupo4 = new ToggleGroup();
        r4a.setToggleGroup(grupo4);
        r4b.setToggleGroup(grupo4);
        r4c.setToggleGroup(grupo4);
        r4d.setToggleGroup(grupo4);
    }

    @FXML
    private void calcular() {
        if (grupo1.getSelectedToggle() == null ||
                grupo2.getSelectedToggle() == null ||
                grupo3.getSelectedToggle() == null ||
                grupo4.getSelectedToggle() == null) {
            lblError.setText("Por favor responde todas las preguntas.");
            return;
        }

        int correctas = 0;
        if (grupo1.getSelectedToggle() == r1a) correctas++; // Donkey Kong
        if (grupo2.getSelectedToggle() == r2a) correctas++; // Atari 2600
        if (grupo3.getSelectedToggle() == r3b) correctas++; // 1980
        if (grupo4.getSelectedToggle() == r4b) correctas++; // Defender la Tierra

        int incorrectas = 4 - correctas;
        int puntaje = correctas * 5;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Resultado.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Resultado");

            ResultadoController ctrl = loader.getController();
            ctrl.setResultados(puntaje, correctas, incorrectas);

            stage.show();

            Stage actual = (Stage) lblError.getScene().getWindow();
            actual.close();

        } catch (Exception e) {
            lblError.setText("Error al cargar resultados.");
        }
    }

    @FXML
    public void disableEncuesta() {
        // Pregunta 1
        r1a.setDisable(true);
        r1b.setDisable(true);
        r1c.setDisable(true);
        r1d.setDisable(true);

        // Pregunta 2
        r2a.setDisable(true);
        r2b.setDisable(true);
        r2c.setDisable(true);
        r2d.setDisable(true);

        // Pregunta 3
        r3a.setDisable(true);
        r3b.setDisable(true);
        r3c.setDisable(true);
        r3d.setDisable(true);

        // Pregunta 4
        r4a.setDisable(true);
        r4b.setDisable(true);
        r4c.setDisable(true);
        r4d.setDisable(true);



    }

    @FXML
    private void cerrarEncuesta() {
        Stage stage = (Stage) lblError.getScene().getWindow();
        stage.close();
    }

}
