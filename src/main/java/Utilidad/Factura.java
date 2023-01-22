/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidad;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jaira
 */
public class Factura implements Serializable{
    private String codigoEmpresa;
    private String periodo;
    private Double total;
    private ArrayList<Orden> ordenes;
    private static ArrayList<Factura> facturas = new ArrayList();

    public Factura(String codigoEmpresa, String periodo, Double total, ArrayList<Orden> ordenes) {
        this.codigoEmpresa = codigoEmpresa;
        this.periodo = periodo;
        this.ordenes = ordenes;
        this.total = obtenertotal();
    }
    
    public double obtenertotal(){
        total = 0.0;
        for(Orden o: ordenes){
            total += o.getTotal();
        }
        return total;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public String getPeriodo() {
        return periodo;
    }

    public Double getTotal() {
        return total;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }
    
    public static ArrayList<Factura> cargarFacturas(String ruta) {
        ArrayList<Factura> facturasN = new ArrayList<>();
        
       //leer la lista de facturas del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            facturasN = (ArrayList<Factura>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return facturasN;
    }
    
    public static void guardarFacturas(Factura s){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data/Facturas.ser"))){
            facturas.add(s);
            out.writeObject(facturas);
        }catch(FileNotFoundException e1){
            System.out.println(e1);
        }catch(IOException e2){
            System.out.println(e2);
        }catch(Exception e3){
            System.out.println(e3);
        }
    }
    
    
}
