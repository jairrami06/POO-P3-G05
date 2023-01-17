package com.mycompany.proyectofinal;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.Cliente;
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
    private void switchToMemoria(ActionEvent event) throws IOException{
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("memoria.fxml"));
        MemoriaController ct = new MemoriaController();

        fxmlLoader.setController(ct);
        Pane root = (Pane) fxmlLoader.load();
       
        
        App.changeRoot(root);
    }
    
    @FXML
    private void InicioSesion(ActionEvent event) throws IOException{
        ArrayList<Usuario> usuarios = Usuario.cargarUsuarios();
        Object evt = event.getSource();
        if(evt.equals(btnIniciarSesion)){
            String usuario = tfUsuario.getText();
            String contra = pfContra.getText();
            
            int inicio = Usuario.iniciarSesion(usuario,contra);
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
