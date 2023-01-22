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
import usuario.Tecnico;
import usuario.Usuario;
/**
 * FXML Controller class
 *
 * @author oweny
 */
public class Datos4Controller implements Initializable {
    
    Usuario u = PrimaryController.user;
    
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
    private ComboBox<Servicio> cmbServicio;
    @FXML
    private TextField txtCantidad;
    ArrayList<Servicio> servicios = Servicio.cargarServicios("data/Servicios.ser");
    ArrayList<Cliente> clientes = Cliente.cargarClientes("data/Clientes.ser");
    ArrayList<Servicio> serviciosorden;
    ArrayList<Integer> cantidades;
    double total = 0;
    @FXML
    private TextField tfPlaca;
    
    
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
    private void guardarOrden(ActionEvent event) {
        ArrayList<Orden> ordenes = Orden.cargarOrdenes("data/Ordenes.ser");
        Servicio s = (Servicio) cmbServicio.getValue();
        int cant = Integer.valueOf(txtCantidad.getText());
        int cod = ordenes.size();
        Cliente c = (Cliente) cmbCliente.getValue();
        int ind = clientes.indexOf(c);
        Cliente cli = clientes.get(ind);
        String fecha = txtFecha.getText();
        String tipov = String.valueOf(cmbVehiculo.getValue());
     
        total += s.getPrecio()*cant;
        Orden nuevao = new Orden(cod,cli.getCodigo(),fecha,cli.getNombre(),total,tipov,tfPlaca.getText(),s.getCodigo(),cant,s.getNombre(),u.getNombre());
        ordenes.add(nuevao);  
        Tecnico t = (Tecnico) u;
        t.getOrdenesTecnico().add(nuevao);
        cmbServicio.setValue(null);
        txtCantidad.clear();   
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
            tfPlaca.clear();
            

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }       
                
    }

}
