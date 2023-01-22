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
    private TableView<Servicio> tblDetalle;
    @FXML
    private TableColumn<Servicio, String> clmServicio;
    @FXML
    private TableColumn<Servicio, String> clmPrecio;
    @FXML
    private TableView<Integer> tblCantidad;
    @FXML
    private TableColumn<Integer, Integer> clmCantidad;
    @FXML
    private TableView<Double> tblSubtotal;
    @FXML
    private TableColumn<Double, Double> clmSubtotal;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Double> subtotales = new ArrayList();
        
        txtOrden.setText(String.valueOf(o.getCodOrden()));
        txtCliente.setText(o.getNombreCliente());
        txtFecha.setText(o.getFecha());
        txtPlaca.setText(o.getPlaca());
        txtTotal.setText(String.valueOf(o.getTotal()));
        txtTipoVehiculo.setText(o.getTipovehiculo());
      
        clmServicio.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        clmPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        
        
        tblDetalle.getItems().setAll(o.getRegistroServicio());
        tblCantidad.getItems().setAll(o.getRegistroCantidades());
        for(int i = 0; i < o.getRegistroServicio().size(); i++){
            double x = o.getRegistroServicio().get(i).getPrecio() * o.getRegistroCantidades().get(i);
            subtotales.add(x);
        }
        
        tblSubtotal.getItems().setAll(subtotales);
        
        
    }  

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
}
