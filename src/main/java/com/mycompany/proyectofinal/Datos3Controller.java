/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

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
import modelo.Proveedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author oweny
 */
public class Datos3Controller implements Initializable {

    @FXML
    private Label lblTitulo;
    @FXML
    private TextField txtCodigo;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtPrecio;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void guardarServicio(ActionEvent event) {
        ArrayList<Servicio> servicios = Servicio.cargarServicios("data/Servicios.ser");
        Servicio s;
        if(txtCodigo.getText().equals("")){
            int codigoX = servicios.size() + 1;
            s = new Servicio(codigoX,txtNombre.getText(), Double.valueOf(txtPrecio.getText()));
        }
        else{
            s = new Servicio(Integer.valueOf(txtCodigo.getText()),txtNombre.getText(), Double.valueOf(txtPrecio.getText()));
        }
        
        
         
        if (servicios.contains(s)){
            int ind = servicios.indexOf(s);
            servicios.set(ind, s);
        }else{
            servicios.add(s);//agregar empleado a la lista
        }
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Servicios.ser"))){
            out.writeObject(servicios);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva servicio agregado exitosamente");

            alert.showAndWait();
            App.setRoot("tertiary");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }
    }

    @FXML
    private void switchToTertiary(ActionEvent event) throws IOException {
        App.setRoot("tertiary");
    }
    
    public void llenarCampos(Servicio s){
        lblTitulo.setText("Editar Servicio");
        txtCodigo.setEditable(false);
        txtCodigo.setText(String.valueOf(s.getCodigo()));
        txtNombre.setText(s.getNombre());
        txtPrecio.setText(String.valueOf(s.getPrecio()));
        
    }

}
