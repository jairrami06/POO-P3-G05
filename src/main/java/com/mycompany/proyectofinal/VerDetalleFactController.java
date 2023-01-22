/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

import Utilidad.Factura;
import Utilidad.Orden;
import Utilidad.Servicio;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jaira
 */
public class VerDetalleFactController implements Initializable {
    Factura f = TertiaryController.facturaDetalle;
    @FXML
    private Label txtEmpresas;
    @FXML
    private Label txtPeriodo;
    @FXML
    private TableColumn<Orden, String> clmPlaca;
    @FXML
    private TableColumn<Orden, String> clmFecha;
    @FXML
    private TableColumn<Orden, String> clmVehiculo;
    @FXML
    private TableColumn<Orden, String> clmServicio;
    @FXML
    private TableColumn<Orden, Integer> clmCantidad;
    @FXML
    private TableColumn<Orden, Double> clmTotal;
    @FXML
    private TableView<Orden> tblDetalle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtEmpresas.setText(f.getCodigoEmpresa());
        txtPeriodo.setText(f.getPeriodo());
        clmPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        clmFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        clmVehiculo.setCellValueFactory(new PropertyValueFactory<>("tipovehiculo"));
        clmServicio.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        clmCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        clmTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        
      
        tblDetalle.getItems().setAll(f.getOrdenes());
  
    }    

    @FXML
    private void salir(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
}
