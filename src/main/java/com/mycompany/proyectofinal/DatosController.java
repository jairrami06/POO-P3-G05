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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelo.*;


/**
 * FXML Controller class
 *
 * @author jaira
 */
public class DatosController implements Initializable {

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
    @FXML
    private RadioButton rbPersonal;
    @FXML
    private RadioButton rbEmpresarial;
    @FXML
    ToggleGroup tipo;

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
    private void guardarCliente(ActionEvent event) {
        ArrayList<Cliente> clientes = Cliente.cargarClientes("data/Clientes.ser");
        RadioButton selectedRadioButton = (RadioButton) tipo.getSelectedToggle();
        String tipo = selectedRadioButton.getText();
        
        Cliente c = new Cliente(txtCedula.getText(),txtNombre.getText(),txtDireccion.getText(),
                txtTelefono.getText(),TipoCliente.valueOf(tipo));
        
        if (clientes.contains(c)){
            int ind = clientes.indexOf(c);
            clientes.set(ind, c);
        }else{
            clientes.add(c);//agregar empleado a la lista
        }
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Clientes.ser"))){
            out.writeObject(clientes);
            out.flush();

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva cliente agregado exitosamente");

            alert.showAndWait();
            App.setRoot("tertiary");

        } catch (IOException ex) {
            System.out.println("IOException:" + ex.getMessage());
        }

    }
    
    public void llenarCampos(Cliente c){
        lblTitulo.setText("Editar Cliente");
        txtCedula.setEditable(false);
        txtCedula.setText(c.getCodigo());
        txtNombre.setText(c.getNombre());
        txtDireccion.setText(c.getDireccion());
        txtTelefono.setText(c.getTelefono());
        
        if (c.getTipo().equals(TipoCliente.Personal))
            rbPersonal.setSelected(true);
        else
            rbEmpresarial.setSelected(true);
    }
        
}

