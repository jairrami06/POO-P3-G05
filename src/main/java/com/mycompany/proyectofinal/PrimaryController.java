package com.mycompany.proyectofinal;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.Sistema;
import usuario.*;

public class PrimaryController {
    
    protected static Usuario user;
    
    @FXML
    private TextField tfUsuario;
    
    @FXML
    private PasswordField pfContra;
    
    @FXML
    private Button btnIniciarSesion;
    
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void InicioSesion(ActionEvent event) throws IOException{
        ArrayList<Usuario> usuarios = Sistema.cargarUsuarios();
        Object evt = event.getSource();
        if(evt.equals(btnIniciarSesion)){
            String usuario = tfUsuario.getText();
            String contra = pfContra.getText();
            
            int inicio = Sistema.iniciarSesion(usuario,contra);
            if(inicio != -1){
                user = usuarios.get(inicio);
                switchToSecondary();
            }else{
               mostrarAlerta(Alert.AlertType.ERROR,"Usuario o contraseña incorrectos");
            }
            
        }
    }
    
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);

        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
