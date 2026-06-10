package proyecto16.proyecto16;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController {

    @FXML private Label tituloLabel;
    @FXML private Label usuarioLabel;
    @FXML private Label contraseñaLabel;
    @FXML private Label rolLabel;
    @FXML private TextField usuarioTextField;
    @FXML private TextField contraseñaTextField;
    @FXML private ComboBox<String> rolComboBox;

    @FXML
    private void ingresar(ActionEvent event) throws IOException {
        String usuario = usuarioTextField.getText();
        String contraseña = contraseñaTextField.getText();
        String rol = rolComboBox.getValue();

        if (usuario.isEmpty() || contraseña.isEmpty() || rol == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Llene todos los campos");
            alert.showAndWait();
            return;
        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        if (rol.equals("Administrador")) {
            if (usuario.equals("Admin") && contraseña.equals("123")) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Administrador.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
                return;
            } else {
                usuarioTextField.clear();
                contraseñaTextField.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error de credenciales");
                alert.setHeaderText(null);
                alert.setContentText("Credenciales inválidas");
                alert.showAndWait();
                return;
            }
        }

        if (rol.equals("Cajero")) {
            if (usuario.equals("Cajero") && contraseña.equals("456")) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Cajero.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
                stage.show();
                return;
            } else {
                usuarioTextField.clear();
                contraseñaTextField.clear();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error de credenciales");
                alert.setHeaderText(null);
                alert.setContentText("Credenciales inválidas");
                alert.showAndWait();
                return;

            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error de Selección");
        alert.setHeaderText(null);
        alert.setContentText("Ingrese bien el rol");
        alert.showAndWait();
    }

    @FXML
    private void salir(){
        System.exit(0);
    }
    @FXML
    private void initialize(){
        rolComboBox.getItems().addAll("Administrador","Cajero");
    }



}
