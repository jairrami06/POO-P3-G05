/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

import Enums.TipoCliente;
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
import javafx.scene.control.TextField;
import modelo.Cliente;

import modelo.Proveedor;

/**
 * FXML Controller class
 *
 * @author oweny
 */
public class Datos2Controller implements Initializable {
    
    @FXML
    private Label lblTitulo;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    private void switchToTertiary(ActionEvent event) throws IOException{
        App.setRoot("tertiary");
    }
    
    @FXML
    private void guardarProveedor(ActionEvent event){
        ArrayList<Proveedor> proveedores = Proveedor.cargarProveedores("data/Proveedores.ser");
        
        Proveedor p = new Proveedor(txtCedula.getText(),txtNombre.getText(),txtDireccion.getText(),
                txtTelefono.getText());
        
        if (proveedores.contains(p)){
            int ind = proveedores.indexOf(p);
            proveedores.set(ind, p);
        }else{
            proveedores.add(p);//agregar empleado a la lista
        }
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Proveedores.ser"))){
            out.writeObject(proveedores);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva proveedor agregado exitosamente");

            alert.showAndWait();
            App.setRoot("tertiary");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }
        
        
    }
    
    public void llenarCampos(Proveedor p){
        lblTitulo.setText("Editar Proveedor");
        txtCedula.setEditable(false);
        txtCedula.setText(p.getCodigo());
        txtNombre.setText(p.getNombre());
        txtDireccion.setText(p.getDireccion());
        txtTelefono.setText(p.getTelefono());
        
    }
        
  
}
