package com.mycompany.proyectofinal;

import modelo.ClienteJuego;
import Enums.TipoCliente;
import Utilidad.Orden;
import Utilidad.Servicio;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import usuario.*;
import modelo.*;

public class SecondaryController {
    
    protected static Object o;
    Usuario user = PrimaryController.user;
    @FXML
    private Button btn1;    
    @FXML
    private Button btn2; 
    @FXML
    private Button btn3;      
    @FXML
    private Label lblPrincipal;
    @FXML
    private Button btnCerrarSesion;
    @FXML
    private Button btn4;
    @FXML
    private Button btn7;
    @FXML
    private Button btn5;
    @FXML
    private Button btn8;
    @FXML
    private Button btn6;
    @FXML
    private Button btn9;
    @FXML
    private Button btnVisJuego;
    
    public void initialize() {
        modificacionMenu(user);
        
    }
    

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    public void modificacionMenu(Usuario user){
        if(user instanceof Admin){
            lblPrincipal.setText("Bienvenido "+user.getNombre());
            btn1.setVisible(true);
            btn2.setVisible(true);
            btn3.setVisible(true);
            btnVisJuego.setVisible(true);
        }else if (user instanceof Cobranza){
            lblPrincipal.setText("Bienvenido "+user.getNombre());
            btn4.setVisible(true);
            btn5.setVisible(true);
            btn6.setVisible(true);
        }else if (user instanceof Tecnico){         
            lblPrincipal.setText("Bienvenido "+user.getNombre());
            btn7.setVisible(true);
            btn8.setVisible(true);
            btn9.setVisible(true);
        }
    }

    @FXML
    private void boton1(ActionEvent event) throws IOException {
       o = new Cliente("","","","",TipoCliente.Personal);
       App.setRoot("tertiary");
    }

    @FXML
    private void boton2(ActionEvent event) throws IOException {
        o = new Proveedor("","","","");
        App.setRoot("tertiary");
    }
    
    @FXML
    private void boton3(ActionEvent event) throws IOException {
        o = new Servicio();
        App.setRoot("tertiary");
    }


    @FXML
    private void boton4(ActionEvent event) {
    }

    @FXML
    private void boton7(ActionEvent event) throws IOException {
        o = new Servicio();
        App.setRoot("tertiary");    
    }

    @FXML
    private void boton5(ActionEvent event) {
    }

    @FXML
    private void boton8(ActionEvent event) throws IOException {
        o = new Orden();
        App.setRoot("datos4");
    }

    @FXML
    private void boton6(ActionEvent event) {
    }

    @FXML
    private void boton9(ActionEvent event) throws IOException {
        o = new Cliente();
        App.setRoot("tertiary"); 
        
    }
    
    @FXML
    private void juego(ActionEvent event) throws IOException {
        o = new ClienteJuego();
        App.setRoot("tertiary");
    }
}