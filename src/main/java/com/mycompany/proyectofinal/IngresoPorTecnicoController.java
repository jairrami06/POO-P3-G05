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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import usuario.Tecnico;
import usuario.Usuario;

/**
 * FXML Controller class
 *
 * @author jaira
 */
public class IngresoPorTecnicoController implements Initializable {

    @FXML
    private TextField tfMes;
    @FXML
    private TextField tfAnio;
    @FXML
    private TableView<Orden> tblReporteServicio;
    @FXML
    private TableColumn<Orden, String> clmTecnico;
    @FXML
    private TableColumn<Orden, Double> clmTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clmTecnico.setCellValueFactory(new PropertyValueFactory<>("tecnico"));
        clmTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }

    @FXML
    private void generarReporte(ActionEvent event) {
        ArrayList<Orden> ordenes = Orden.cargarOrdenes("data/ordenes.ser");
        ArrayList<Usuario> usuarios = Usuario.cargarUsuarios();
        ArrayList<Tecnico> tecnicos = new ArrayList();
        for(Usuario u: usuarios){
            if(u instanceof Tecnico){
                Tecnico t = (Tecnico) u;
                tecnicos.add(t);
            }
        }
        
        
        String mes = tfMes.getText();
        String anio = tfAnio.getText();
        
        ArrayList<Orden> ordenesIgual = new ArrayList<>();
        
        
        
        for(Tecnico tec: tecnicos){
            double cont = 0;
            for(Orden o: ordenes){
                if(mes.equals(o.getFecha().substring(3,5)) && anio.equals(o.getFecha().substring(6))){
                    if(o.getTecnico().equals((tec.getNombre()))){
                        cont += o.getTotal();
                    }
                }
            }
            ordenesIgual.add(new Orden("",cont,tec.getNombre()));
        }

        this.tblReporteServicio.getItems().setAll(ordenesIgual);
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }
    
}
