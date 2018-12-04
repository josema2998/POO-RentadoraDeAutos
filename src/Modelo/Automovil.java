/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author arman
 */
public class Automovil {
    
    private String Nombre;
    private String Marca;
    private String Placa;
    private int Id;
    private int Modelo;
    private int Puertas;
    private int Disponibilidad;
    private double Precio;

    public String getNombre() {
        return Nombre;
    }

    public String getMarca() {
        return Marca;
    }

    public String getPlaca() {
        return Placa;
    }


    public int getModelo() {
        return Modelo;
    }

    public int getPuertas() {
        return Puertas;
    }

    public int getDisponibilidad() {
        return Disponibilidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }


    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }

    public void setPuertas(int Puertas) {
        this.Puertas = Puertas;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        if(Disponibilidad == true){
        this.Disponibilidad = 1;
        }else{
        this.Disponibilidad = 0;
        }
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
    public Automovil(){
    }
    
    public Automovil( String nombre,String placa, int modelo, int puertas, boolean estado, double precio){
        this.Nombre=nombre;
        this.Placa=placa;
        this.Modelo=modelo;
        this.Puertas=puertas;
        if(estado == true){
        this.Disponibilidad = 1;
        }else{
        this.Disponibilidad = 0;
        }
        this.Precio=precio;
    }
    
}
