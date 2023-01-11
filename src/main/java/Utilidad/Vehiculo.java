package Utilidad;

import Enums.TipoVehiculo;

public class Vehiculo {
    //atributos de la clase
    private String placa;
    private TipoVehiculo tipo_vehiculo;
    //constructor de la clase
    public Vehiculo(String placa, TipoVehiculo tipo_vehiculo) {
        this.placa = placa;
        this.tipo_vehiculo = tipo_vehiculo;
    }
    
    public Vehiculo(){
        
    }

    public String getPlaca() {
        return placa;
    }

    public TipoVehiculo getTipo_vehiculo() {
        return tipo_vehiculo;
    }
}
