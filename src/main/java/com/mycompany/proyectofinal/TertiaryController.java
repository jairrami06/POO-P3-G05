/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.proyectofinal;

import modelo.ClienteJuego;
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
import java.util.HashSet;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import usuario.*;
/**
 * FXML Controller class
 *
 * @author jaira
 */

public class TertiaryController implements Initializable {
    
    private Usuario user = PrimaryController.user;
    private Object o = SecondaryController.o;
    public static Orden ordenDetalle;
    public static Factura facturaDetalle;
    
    
    @FXML
    private Label lblFiltrarpor;
    @FXML
    private Label lblCodigo;
    @FXML
    private Label lblFecha;
    @FXML
    private Label lblCliente;
    @FXML
    private Button btnVerDetalle;
    @FXML
    private TextField tfFiltroCliente;
    @FXML
    private TextField tfFiltroFecha;
    @FXML
    private TextField tfFiltroCodigo;
    @FXML
    private Label lblTitulo;
    @FXML
    private Button btnAtras;
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

    ObservableList<Orden> filtroOrden;
    ObservableList<Orden> filtroOrden2;
    ObservableList<Orden> filtroOrden3;
    ArrayList<Orden> ordenes;
    @FXML
    private TableView<Orden> tblOrdenes;
    @FXML
    private TableColumn<Orden, Integer> columnCodigo;
    @FXML
    private TableColumn<Orden, String> columnFecha;
    @FXML
    private TableColumn<Orden, String> columnNomCliente;
    @FXML
    private TableColumn<Orden, Double> columnTotalPagar;
    @FXML
    private TextArea txtReporteInsumo;
    @FXML
    private Button btnReporte;
    
    private ArrayList<Factura> facturas;
    @FXML
    private Button btnNuevaFactura;
    @FXML
    private TableView<Factura> tblFactura;
    @FXML
    private TableColumn<Factura, String> clmEmpresa;
    @FXML
    private TableColumn<Factura, String> clmPeriodo;
    @FXML
    private TableColumn<Factura, Double> clmTotalAPagar;
    @FXML
    private Button btnDetalleFact;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        filtroOrden = FXCollections.observableArrayList();
        filtroOrden2 = FXCollections.observableArrayList();
        filtroOrden3 = FXCollections.observableArrayList();
        llenarTabla(o,user);
    }

    @FXML
    private void switchToSecondary() throws IOException {
       App.setRoot("secondary");
    }
      
    public void llenarTabla(Object o, Usuario u){
        if(u instanceof Admin){
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
                lblTitulo.setText("Resultados del juego de memoria");
                btnEditar.setVisible(false);
                btnAgregar.setVisible(false);
                btnEliminar.setVisible(false);
            
                clientesjuego = new ArrayList();
                tblClientesJuego.setVisible(true);

                columnNombreCJ.setCellValueFactory(new PropertyValueFactory<>("nombre"));
                columnFechaCJ.setCellValueFactory(new PropertyValueFactory<>("fecha"));
                columnAciertosCJ.setCellValueFactory(new PropertyValueFactory<>("aciertos"));
                columnFallosCJ.setCellValueFactory(new PropertyValueFactory<>("fallos"));
                columnTiempoCJ.setCellValueFactory(new PropertyValueFactory<>("tiempojuego"));
            
                clientesjuego.addAll(ClienteJuego.cargarClientesJuego("data/ClientesJuego.ser"));
                tblClientesJuego.getItems().setAll(clientesjuego);
            }
        }else if(u instanceof Tecnico){
            if (o instanceof Servicio){
                lblFiltrarpor.setVisible(true);
                lblCodigo.setVisible(true);
                lblFecha.setVisible(true);
                lblCliente.setVisible(true);
                tblOrdenes.setVisible(true);
                btnEditar.setVisible(false);
                btnAgregar.setVisible(false);
                btnEliminar.setVisible(false);
                tfFiltroCodigo.setVisible(true);
                tfFiltroCliente.setVisible(true);
                tfFiltroFecha.setVisible(true);
                btnVerDetalle.setVisible(true);
                lblTitulo.setText("Consultar orden de servicios");
                
                columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codOrden"));
                columnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
                columnNomCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
                columnTotalPagar.setCellValueFactory(new PropertyValueFactory<>("total"));
                ordenes = new ArrayList();
                ordenes.addAll(Orden.cargarOrdenes("data/ordenes.ser"));
                tblOrdenes.getItems().setAll(ordenes);
            }else if (o instanceof Cliente){
                btnEditar.setVisible(false);
                btnAgregar.setVisible(false);
                btnEliminar.setVisible(false);
                lblTitulo.setText("Reportar falta de insumos");
                txtReporteInsumo.setVisible(true);
                btnReporte.setVisible(true);          
            }
        }else if(u instanceof Cobranza){
            if(o instanceof Servicio){
                lblTitulo.setText("Factura a empresas");
                btnEditar.setVisible(false);
                btnAgregar.setVisible(false);
                btnEliminar.setVisible(false);
                btnNuevaFactura.setVisible(true);
                btnDetalleFact.setVisible(true);
                tblFactura.setVisible(true);
                clmTotalAPagar.setCellValueFactory(new PropertyValueFactory<>("total"));
                clmPeriodo.setCellValueFactory(new PropertyValueFactory<>("periodo"));
                clmEmpresa.setCellValueFactory(new PropertyValueFactory<>("codigoEmpresa"));
                
                facturas = Factura.cargarFacturas("data/Facturas.ser");
                tblFactura.getItems().setAll(facturas);
                
            }else if(o instanceof Cliente){
   
            }else if(o instanceof Orden){
                lblTitulo.setText("Reporte de ingresos por servicio");
            }
           
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
    
    @FXML
    private void filtrarFecha(ActionEvent event) throws IOException{
        String filtroFec = tfFiltroFecha.getText();
        
        if(filtroFec.isEmpty()){
            tblOrdenes.getItems().setAll(ordenes);
        }else{
            filtroOrden3.clear();
            for(Orden ord: ordenes){
                if(ord.getFecha().contains(filtroFec)){
                    filtroOrden3.add(ord);
                }
            }
            tblOrdenes.setItems(filtroOrden3);
        }    
    }
        
    @FXML
    private void filtrarCodigo(ActionEvent event) throws IOException{
        String filtroCod = tfFiltroCodigo.getText();
        
        if(filtroCod.isEmpty()){
            tblOrdenes.getItems().setAll(ordenes);
        }else{
            filtroOrden2.clear();
            for(Orden ord: ordenes){
                if(String.valueOf(ord.getCodOrden()).contains(filtroCod)){
                    filtroOrden2.add(ord);
                }
            }
            tblOrdenes.setItems(filtroOrden2);
        }    
    }
        
    @FXML
    private void filtrarCliente(ActionEvent event) throws IOException{
        String filtroNombre = tfFiltroCliente.getText();
        
        if(filtroNombre.isEmpty()){
            tblOrdenes.getItems().setAll(ordenes);
        }else{
            filtroOrden.clear();
            for(Orden ord: ordenes){
                if(ord.getNombreCliente().contains(filtroNombre)){
                    filtroOrden.add(ord);
                }
            }
            tblOrdenes.setItems(filtroOrden);
        }
    }

    @FXML
    private void enviarReporte(ActionEvent event) {
        App.email.add(txtReporteInsumo.getText());
        mostrarAlerta(Alert.AlertType.CONFIRMATION,"Email enviado");
        
    }
    
    public void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle("Resultado de operacion");
        alert.setHeaderText("Notificacion");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }    

    @FXML
    private void detalleOrden(ActionEvent event) throws IOException {
        Orden o = tblOrdenes.getSelectionModel().getSelectedItem();
        
        if(o != null){
            ordenDetalle = o;
            App.setRoot("VerDetalle");
        }
    }

    @FXML
    private void nuevaFact(ActionEvent event) throws IOException {
        App.setRoot("nuevFact"); 
    }

    @FXML
    private void detalleFact(ActionEvent event) throws IOException {
        Factura f = tblFactura.getSelectionModel().getSelectedItem();
        
        if(o != null){
            facturaDetalle = f;
            App.setRoot("VerDetalleFact"); 
        }      
    }
    
        
}
