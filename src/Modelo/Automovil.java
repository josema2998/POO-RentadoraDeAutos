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
    private String Tipo;
    private int Modelo;
    private int Puertas;
    private boolean Disponibilidad;
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

    public String getTipo() {
        return Tipo;
    }

    public int getModelo() {
        return Modelo;
    }

    public int getPuertas() {
        return Puertas;
    }

    public boolean isDisponibilidad() {
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

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setModelo(int Modelo) {
        this.Modelo = Modelo;
    }

    public void setPuertas(int Puertas) {
        this.Puertas = Puertas;
    }

    public void setDisponibilidad(boolean Disponibilidad) {
        this.Disponibilidad = Disponibilidad;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
    
}
