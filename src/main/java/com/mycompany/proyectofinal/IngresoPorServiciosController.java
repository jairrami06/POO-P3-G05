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

/**
 * FXML Controller class
 *
 * @author jaira
 */
public class IngresoPorServiciosController implements Initializable {

    @FXML
    private TextField tfMes;
    @FXML
    private TextField tfAnio;
    @FXML
    private TableView<Orden> tblReporteServicio;
    @FXML
    private TableColumn<Orden, String> clmServicio;
    @FXML
    private TableColumn<Orden, Double> clmTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clmServicio.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        clmTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }    

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void generarReporte(ActionEvent event) {
        ArrayList<Orden> ordenes = Orden.cargarOrdenes("data/ordenes.ser");
        ArrayList<Servicio> servicios = Servicio.cargarServicios("data/Servicios.ser");
        
        String mes = tfMes.getText();
        String anio = tfAnio.getText();
        
        ArrayList<Orden> ordenesIgual = new ArrayList<>();
        
        
        
        for(Servicio s: servicios){
            double cont = 0;
            for(Orden o: ordenes){
                if(mes.equals(o.getFecha().substring(3,5)) && anio.equals(o.getFecha().substring(6))){
                    if(o.getCodigoServicio() == (s.getCodigo())){
                        cont += o.getTotal();
                    }
                }
            }
            ordenesIgual.add(new Orden(s.getNombre(),cont,""));
        }

        this.tblReporteServicio.getItems().setAll(ordenesIgual);
    }
    
    
}
