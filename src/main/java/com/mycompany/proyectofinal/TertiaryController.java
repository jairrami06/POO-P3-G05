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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Sistema;
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
    
    private ObservableList<Cliente> clientes;

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
            clientes = FXCollections.observableArrayList();
            TableView<Cliente> tbTabla = new TableView<>();
            TableColumn colCedula = new TableColumn("Cedula");
            TableColumn colNombre = new TableColumn("Nombre");
            TableColumn colDireccion = new TableColumn("Direccion");
            TableColumn colTelefono = new TableColumn("Telefono");
            TableColumn colTipo = new TableColumn("Tipo");
            tbTabla.getColumns().addAll(colCedula,colNombre,colDireccion,colTelefono,colTipo);
            colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
            colCedula.setCellValueFactory(new PropertyValueFactory("codigo"));
            colDireccion.setCellValueFactory(new PropertyValueFactory("direccion"));
            colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
            if(o instanceof Empresarial){
                colTipo.setText("Empresarial");
            }else if(o instanceof Personal){
                colTipo.setText("Personal");
            }
            clientes.addAll(Sistema.cargarClientes());
            tbTabla.setItems(clientes);
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
