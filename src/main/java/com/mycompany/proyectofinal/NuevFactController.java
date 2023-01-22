/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

import Enums.TipoCliente;
import Utilidad.Factura;
import Utilidad.Orden;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author jaira
 */
public class NuevFactController implements Initializable {
    private ArrayList<Cliente> clientes = Cliente.cargarClientes("data/Clientes.ser");
    private ArrayList<Cliente> empresas;
    double total;
    @FXML
    private ComboBox<Cliente> cmbEmpresa;
    @FXML
    private ComboBox<String> cmbMes;
    @FXML
    private TextField tfanio;
    
    private String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        empresas = new ArrayList();
        for(Cliente c: clientes){
            if(c.getTipo().equals(TipoCliente.Empresarial)){
                empresas.add(c);
            }
        }  
        
        cmbEmpresa.getItems().addAll(empresas);
        cmbMes.getItems().addAll(meses);
        
    }    

    @FXML
    private void generarFactura(ActionEvent event) {
        ArrayList<Orden> ordenes = Orden.cargarOrdenes("data/ordenes.ser");
        String anio = tfanio.getText();
        String mes = mesennum();
        Cliente empresa = cmbEmpresa.getValue();

 

        ArrayList<Orden> ordenesEncontradas = new ArrayList<>();
        Double pagoFinal = 50.0;
        int cont = 0;
        for (Orden orden : ordenes) {
            final boolean cumpleCodigo = empresa.getCodigo().equals(orden.getCodigoCliente());
            final boolean cumpleAnio = anio.equals(orden.getFecha().substring(6));
            final boolean cumpleMes = mes.equals(orden.getFecha().substring(3,5));
            if (cumpleCodigo && cumpleAnio && cumpleMes) {
                pagoFinal += orden.getTotal();
                ordenesEncontradas.add(orden);
                
                cont++;
            }
        }
        if(!ordenesEncontradas.isEmpty()){
        Factura nuevaf = new Factura(empresa.getCodigo(),cmbMes.getValue()+" "+anio,total,ordenesEncontradas);
        Factura.guardarFacturas(nuevaf);
        

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva factura generada exitosamente");

            alert.showAndWait();
            
            cmbMes.setValue(null);
            cmbEmpresa.setValue(null);
            tfanio.clear();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("No se encuentran ordenes para la fecha seleccionada");
            alert.showAndWait();
        }
    
    }
    
    /*
    @FXML
    private void generarFactura(ActionEvent event) {
        boolean realizado = false;
        double total = 0;
        ArrayList<Orden> ordcliente = new ArrayList();
        String anio = tfanio.getText();
        String mes = mesennum();
        Cliente eselect = (Cliente) cmbEmpresa.getValue();
        ArrayList<Orden> ordenes = Orden.cargarOrdenes("data/ordenes.ser");
        for(Orden o: ordenes){
            String fechaorden = o.getFecha().substring(3);
            total += o.getTotal();
            if((o.getCodigoCliente().equals(eselect.getCodigo())) && fechaorden.equals(mes+"-"+anio)){
                ordcliente.add(o);
                
            }
        }
        if(!ordcliente.isEmpty()){
        Factura nuevaf = new Factura(eselect.getCodigo(),cmbMes.getValue()+" "+anio,total,ordcliente);
        Factura.guardarFacturas(nuevaf);
        

            //mostrar informacion
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("Nueva factura generada exitosamente");

            alert.showAndWait();
            
            cmbMes.setValue(null);
            cmbEmpresa.setValue(null);
            tfanio.clear();
        }else{
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Resultado de la operación");
            alert.setContentText("No se encuentran ordenes para la fecha seleccionada");
            alert.showAndWait();
        
        }
    }*/

    @FXML
    private void salir(ActionEvent event) throws IOException {
        App.setRoot("secondary");
        
        
    }
    
    private String mesennum(){
    String mes = cmbMes.getValue();
    String mesennum = "";
        switch (mes) {
            case "Enero":
                mesennum = "01";
                break;
            case "Febrero":
                mesennum = "02";
                break;
            case "Marzo":
                mesennum = "03";
                break;
            case "Abril":
                mesennum = "04";
                break;
            case "Mayo":
                mesennum = "05";
                break;
            case "Junio":
                mesennum = "06";
                break;
            case "Julio":
                mesennum = "07";
                break;
            case "Agosto":
                mesennum = "08";
                break;
            case "Septiembre":
                mesennum = "09";
                break;
            case "Octubre":
                mesennum = "10";
                break;
            case "Noviembre":
                mesennum = "11";
                break;
            case "Diciembre":
                mesennum = "12";
                break;
            default:
                break;
        }
    return mesennum;
    }
    
    
}
