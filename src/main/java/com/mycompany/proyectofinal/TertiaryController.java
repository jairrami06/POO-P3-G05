/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

import Enums.TipoCliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import modelo.*;
import Utilidad.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author jaira
 */
public class TertiaryController implements Initializable {

    private Object o = SecondaryController.o;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnAtras;
    @FXML
    private HBox hbxPrincipal;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    
    private ArrayList<Cliente> clientes;
    @FXML
    private TableView<Cliente> tblClientes;
    @FXML
    private TableColumn<Cliente, String> columnCedulaC;
    @FXML
    private TableColumn<Cliente, String> columnNombreC;
    @FXML
    private TableColumn<Cliente, String> columnDireccionC;
    @FXML
    private TableColumn<Cliente, String> columnTelefonoC;
    @FXML
    private TableColumn<Cliente, TipoCliente> columnTipoC;
    
    
    private ArrayList<Proveedor> proveedores;
    @FXML
    private TableView<Proveedor> tblProveedores;
    @FXML
    private TableColumn<Proveedor, String> columnCedulaP;
    @FXML
    private TableColumn<Proveedor, String> columnNombreP;
    @FXML
    private TableColumn<Proveedor, String> columnDireccionP;
    @FXML
    private TableColumn<Proveedor, String> columnTelefonoP;
    
    private ArrayList<Servicio> servicios;
    @FXML
    private TableView<Servicio> tblServicios;
    @FXML
    private TableColumn<Servicio, Integer> columnCodigoS;
    @FXML
    private TableColumn<Servicio, String> columnNombreS;
    @FXML
    private TableColumn<Servicio, Double> columnPrecioS;
    
    private ArrayList<ClienteJuego> clientesjuego;
    @FXML
    private TableView<ClienteJuego> tblClientesJuego;
    @FXML
    private TableColumn<ClienteJuego, String> columnNombreCJ;
    @FXML
    private TableColumn<ClienteJuego, Date> columnFechaCJ;
    @FXML
    private TableColumn<ClienteJuego, String> columnTiempoCJ;
    @FXML
    private TableColumn<ClienteJuego, Integer> columnAciertosCJ;
    @FXML
    private TableColumn<ClienteJuego, Integer> columnFallosCJ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        llenarTabla(o);
    }

    @FXML
    private void switchToSecondary() throws IOException {
       App.setRoot("secondary");
    }
      
    public void llenarTabla(Object o){
        if(o instanceof Cliente){
            lblTitulo.setText("Administrar Clientes");
            clientes = new ArrayList();
            tblClientes.setVisible(true);
      
            columnCedulaC.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            columnNombreC.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            columnDireccionC.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            columnTelefonoC.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            columnTipoC.setCellValueFactory(new PropertyValueFactory<>("tipo"));
          
            clientes.addAll(Cliente.cargarClientes("data/Clientes.ser"));
            tblClientes.getItems().setAll(clientes);

        }else if(o instanceof Proveedor){
            lblTitulo.setText("Administrar Proveedores");
            proveedores = new ArrayList();
            tblProveedores.setVisible(true);
            
            columnCedulaP.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            columnNombreP.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            columnDireccionP.setCellValueFactory(new PropertyValueFactory<>("direccion"));
            columnTelefonoP.setCellValueFactory(new PropertyValueFactory<>("telefono"));
            
            proveedores.addAll(Proveedor.cargarProveedores("data/Proveedores.ser"));
            tblProveedores.getItems().setAll(proveedores);
            
        }else if(o instanceof Servicio){
            lblTitulo.setText("Administrar Servicios");
            servicios = new ArrayList();
            tblServicios.setVisible(true);
            
            columnCodigoS.setCellValueFactory(new PropertyValueFactory<>("codigo"));
            columnNombreS.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            columnPrecioS.setCellValueFactory(new PropertyValueFactory<>("precio"));
            
            
            servicios.addAll(Servicio.cargarServicios("data/Servicios.ser"));
            tblServicios.getItems().setAll(servicios);
        }else if(o instanceof ClienteJuego){
            btnEditar.setVisible(false);
            btnAgregar.setVisible(false);
            btnEliminar.setVisible(false);
            clientesjuego = new ArrayList();
            ClienteJuego cj = (ClienteJuego) o;
            lblTitulo.setText("Clientes del juego");
            clientesjuego = new ArrayList();
            tblClientesJuego.setVisible(true);
            clientesjuego.add(cj);
            
            columnNombreCJ.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            columnFechaCJ.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            columnAciertosCJ.setCellValueFactory(new PropertyValueFactory<>("aciertos"));
            columnFallosCJ.setCellValueFactory(new PropertyValueFactory<>("fallos"));
            columnTiempoCJ.setCellValueFactory(new PropertyValueFactory<>("tiempojuego"));
            tblClientesJuego.getItems().setAll(clientesjuego);
        }
        
    }

    @FXML
    private void mostrarVentana(ActionEvent event) throws IOException{
        if(o instanceof Cliente){
        //App.setRoot("nuevo");
        //se carga el fxml de nueva ventana
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("datos.fxml"));//no tiene el controlador especificado
        DatosController ct = new DatosController();

        fxmlLoader.setController(ct);//se asigna el controlador
        VBox root = (VBox) fxmlLoader.load();//carga los objetos del fxml
       
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        //ct.llenarCombo(Departamento.cargarDepartamentos(App.pathDep));
        
        //asignar el nodo raiz a la escena
        App.changeRoot(root);
        
        }
        else if(o instanceof Proveedor){
            //App.setRoot("nuevo");
        //se carga el fxml de nueva ventana
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("datos2.fxml"));//no tiene el controlador especificado
        Datos2Controller ct = new Datos2Controller();

        fxmlLoader.setController(ct);//se asigna el controlador
        VBox root = (VBox) fxmlLoader.load();//carga los objetos del fxml
       
        //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
        //ct.llenarCombo(Departamento.cargarDepartamentos(App.pathDep));
        
        //asignar el nodo raiz a la escena
        App.changeRoot(root);
        }
        
        else{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("datos3.fxml"));//no tiene el controlador especificado
            Datos3Controller ct = new Datos3Controller();

            fxmlLoader.setController(ct);//se asigna el controlador
            VBox root = (VBox) fxmlLoader.load();//carga los objetos del fxml
       
            //luego que el fxml ha sido cargado puedo utilizar el controlador para realizar cambios
            //ct.llenarCombo(Departamento.cargarDepartamentos(App.pathDep));
        
            //asignar el nodo raiz a la escena
            App.changeRoot(root);
        }
    }
    
    
    
    @FXML
    private void editar() throws IOException {
        if(o instanceof Cliente){
            Cliente c = (Cliente) tblClientes.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("datos.fxml"));//no tiene el controlador especificado
            DatosController ct = new DatosController();

            fxmlLoader.setController(ct);//se asigna el controlador

            VBox root = (VBox) fxmlLoader.load();
            ct.llenarCampos(c);
            App.changeRoot(root);
        }
        else if(o instanceof Proveedor){
            Proveedor p = (Proveedor) tblProveedores.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("datos2.fxml"));//no tiene el controlador especificado
            Datos2Controller ct = new Datos2Controller();

            fxmlLoader.setController(ct);//se asigna el controlador

            VBox root = (VBox) fxmlLoader.load();
            ct.llenarCampos(p);
            App.changeRoot(root);
        }
        else{
            Servicio s = (Servicio) tblServicios.getSelectionModel().getSelectedItem();
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("datos3.fxml"));//no tiene el controlador especificado
            Datos3Controller ct = new Datos3Controller();

            fxmlLoader.setController(ct);//se asigna el controlador

            VBox root = (VBox) fxmlLoader.load();
            ct.llenarCampos(s);
            App.changeRoot(root);
        }

    }
    
    @FXML
    private void elimnar() throws IOException {
        if(o instanceof Cliente){
            Cliente c = (Cliente) tblClientes.getSelectionModel().getSelectedItem();
        
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Alert");
            //alert.setHeaderText("Resultado de la operación");
            alert.setContentText("¿Estas seguro que deseas eliminar este cliente?");
        
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                int ind = clientes.indexOf(c);
                clientes.remove(ind);
            }
        }else if(o instanceof Proveedor){
            Proveedor p = (Proveedor) tblProveedores.getSelectionModel().getSelectedItem();
        
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Alert");
            //alert.setHeaderText("Resultado de la operación");
            alert.setContentText("¿Estas seguro que deseas eliminar este cliente?");
        
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                //No borrar de la lista si no, ya no mostrarlo en el table view
                int ind = proveedores.indexOf(p);
                proveedores.remove(ind);
            }
        }
        else{
            Servicio s = (Servicio) tblServicios.getSelectionModel().getSelectedItem();
        
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Alert");
            //alert.setHeaderText("Resultado de la operación");
            alert.setContentText("¿Estas seguro que deseas eliminar este servicio?");
        
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK){
                int ind = servicios.indexOf(s);
                servicios.remove(ind);
            }
        }
        
        
    }
    
}
