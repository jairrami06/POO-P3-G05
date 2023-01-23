/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

import Utilidad.Orden;
import Utilidad.Servicio;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author jaira
 */
public class VerDetalleController implements Initializable {

    Orden o = TertiaryController.ordenDetalle;
    
    
    @FXML
    private Label txtOrden;
    @FXML
    private Label txtCliente;
    @FXML
    private Label txtFecha;
    @FXML
    private Label txtTotal;
    @FXML
    private Label txtPlaca;
    @FXML
    private Label txtTipoVehiculo;
    @FXML
    private TableView<Orden> tblDetalle;
    @FXML
    private TableColumn<Orden, String> clmServicio;
    @FXML
    private TableColumn<Orden, Double> clmPrecio;
    @FXML
    private TableColumn<Orden, Integer> clmCantidad;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        txtOrden.setText(String.valueOf(o.getCodOrden()));
        txtCliente.setText(o.getNombreCliente());
        txtFecha.setText(o.getFecha());
        txtPlaca.setText(o.getPlaca());
        txtTotal.setText(String.valueOf(o.getTotal()));
        txtTipoVehiculo.setText(o.getTipovehiculo());
        clmServicio.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        clmPrecio.setCellValueFactory(new PropertyValueFactory<>("precioServ"));
        clmCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tblDetalle.getItems().setAll(o);
        
    }  

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
}
