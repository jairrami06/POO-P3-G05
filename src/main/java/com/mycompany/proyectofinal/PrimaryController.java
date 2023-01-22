package com.mycompany.proyectofinal;

import Utilidad.Factura;
import Utilidad.Orden;
import Utilidad.Servicio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modelo.Cliente;
import usuario.*;

public class PrimaryController implements Initializable{
    
    protected static Usuario user;
    
    @FXML
    private TextField tfUsuario;
    
    @FXML
    private PasswordField pfContra;
    
    @FXML
    private Button btnIniciarSesion;
    
    @FXML
    private Button btnMemoria;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    
    
    
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
