package Utilidad;

import Enums.TipoVehiculo;
import java.util.ArrayList;

public class Orden {
    //atributos de la clase orden donde se usan sus datos y 2 listas importantes para filtrar datos y obtener
    //informes especificos
    private String codigoCliente;
    private String fecha;
    private double total;
    private Vehiculo vehiculo;
    private String tecnico;
    private ArrayList<Servicio> registroServicio;
    private ArrayList<Integer> registroCantidades;
   
    //mconstructor de la clase orden
    public Orden(String codigoCliente, String fecha, double total, Vehiculo vehiculo, ArrayList<Servicio> registroServicio, ArrayList<Integer> registroCantidades) {
        this.codigoCliente = codigoCliente;
        this.fecha = fecha;
        this.total = total;
        this.vehiculo = vehiculo;
        this.registroServicio = registroServicio;
        this.registroCantidades = registroCantidades;
    }
    //getters y setters
    public String getFecha() {
        return fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public ArrayList<Servicio> getRegistroServicio() {
        return registroServicio;
    }

    public ArrayList<Integer> getRegistroCantidades() {
        return registroCantidades;
    }

    public String getTecnico() {
        return tecnico;
    }
    
    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }
    
    
    
    
    
    
}
