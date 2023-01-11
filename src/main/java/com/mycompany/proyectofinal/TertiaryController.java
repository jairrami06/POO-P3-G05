/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import modelo.*;
import Utilidad.*;
import java.io.IOException;
import javafx.scene.control.TableColumn;
/**
 * FXML Controller class
 *
 * @author jaira
 */
public class TertiaryController implements Initializable {

    private Object o = SecondaryController.o;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnAtras;
    @FXML
    private HBox hbxPrincipal;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarTabla(o);
    }

    @FXML
    private void switchToSecondary() throws IOException {
       App.setRoot("secondary");
    }
    
    public void llenarTabla(Object o){
        if(o instanceof Cliente){
            TableView<Cliente> tbTabla = new TableView<>();
            TableColumn colCedula = new TableColumn("Cedula");
            TableColumn colNombre = new TableColumn("Nombre");
            TableColumn colDireccion = new TableColumn("Direccion");
            TableColumn colTelefono = new TableColumn("Telefono");
            TableColumn colTipo = new TableColumn("Tipo");
            tbTabla.getColumns().addAll(colCedula,colNombre,colDireccion,colTelefono,colTipo);
            hbxPrincipal.getChildren().add(tbTabla);
        }else if(o instanceof Servicio){
            TableView<Servicio> tbTabla;
            TableColumn colCedula;
            TableColumn colNombre;
            TableColumn colDireccion;
            TableColumn colTelefono;
        }else if(o instanceof Proveedor){
            TableView<Proveedor> tbTabla;
        }
    }
    
}
