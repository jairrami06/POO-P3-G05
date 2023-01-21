/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

import Enums.TipoVehiculo;
import Utilidad.Orden;
import Utilidad.Servicio;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelo.*;
/**
 * FXML Controller class
 *
 * @author oweny
 */
public class Datos4Controller implements Initializable {
    
    @FXML
    private Label lblTitulo;
    private TextField txtCodigo;
    private TextField txtNombre;
    private TextField txtPrecio;
    @FXML
    private TextField txtFecha;
    @FXML
    private ComboBox<Cliente> cmbCliente;
    @FXML
    private ComboBox cmbVehiculo;
    @FXML
    private Button bntaggser;
    @FXML
    private ComboBox<Servicio> cmbServicio;
    @FXML
    private TextField txtCantidad;
    ArrayList<Servicio> servicios = Servicio.cargarServicios();
    ArrayList<Cliente> clientes = Cliente.cargarClientes("data/Clientes.ser");
    ArrayList<Servicio> serviciosorden;
    ArrayList<Integer> cantidades;
    double total = 0;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cantidades = new ArrayList();
        serviciosorden = new ArrayList();
        TipoVehiculo[] tv = TipoVehiculo.values();
        cmbVehiculo.getItems().addAll(tv);
        for(Servicio s: servicios){ cmbServicio.getItems().add(s);}
        for(Cliente c: clientes){ cmbCliente.getItems().add(c);}    
    }    

    @FXML
    private void switchToTertiary(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void agregarServicio(ActionEvent event) {      
        Servicio s = (Servicio) cmbServicio.getValue();
        int cant = Integer.valueOf(txtCantidad.getText());
        serviciosorden.add(s);
        cantidades.add(cant);
        total += s.getPrecio()*cant;
        cmbServicio.setValue(null);
        txtCantidad.clear();     
    }

    @FXML
    private void guardarOrden(ActionEvent event) {
        ArrayList<Orden> ordenes = Orden.cargarOrdenes();
        int cod = ordenes.size();
        Cliente c = (Cliente) cmbCliente.getValue();
        int ind = clientes.indexOf(c);
        Cliente cli = clientes.get(ind);
        String fecha = txtFecha.getText();
        String tipov = String.valueOf(cmbVehiculo.getValue());
        Orden nuevao = new Orden(cod,cli.getCodigo(),fecha,cli.getNombre(),total,tipov,String.valueOf(cmbVehiculo.getValue()),serviciosorden,cantidades);
        ordenes.add(nuevao);  
               
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/ordenes.ser"))){
            out.writeObject(ordenes);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva orden agregada exitosamente");

            alert.showAndWait();
            txtFecha.clear();
            serviciosorden.clear();
            cantidades.clear();
            total = 0;
            cmbCliente.setValue(null);
            cmbVehiculo.setValue(null);
            

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }       
                
    }

}
