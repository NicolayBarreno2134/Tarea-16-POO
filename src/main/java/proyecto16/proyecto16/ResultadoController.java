package proyecto16.proyecto16;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultadoController {

    @FXML private Label lblPuntaje;
    @FXML private Label lblCorrectas;
    @FXML private Label lblIncorrectas;

    public void setResultados(int puntaje, int correctas, int incorrectas) {
        lblPuntaje.setText("Puntaje: " + puntaje + " / 20");
        lblCorrectas.setText("✅ Respuestas correctas: " + correctas);
        lblIncorrectas.setText("❌ Respuestas incorrectas: " + incorrectas);
    }

    @FXML
    private void cerrar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Encuesta.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Encuesta");

            EncuestaController ctrl = loader.getController();
            ctrl.disableEncuesta();

            stage.show();

            Stage actual = (Stage) lblPuntaje.getScene().getWindow();
            actual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}