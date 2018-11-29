package Modelo;

import java.util.ArrayList;

public class Reporte {
    private String Tipo;
    private ArrayList<String> ListaCochesRentados;
    private Double TotalGanancias;

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public ArrayList<String> getListaCochesRentados() {
        return ListaCochesRentados;
    }

    public void setListaCochesRentados(ArrayList<String> ListaCochesRentados) {
        this.ListaCochesRentados = ListaCochesRentados;
    }

    public Double getTotalGanancias() {
        return TotalGanancias;
    }

    public void setTotalGanancias(Double TotalGanancias) {
        this.TotalGanancias = TotalGanancias;
    }
    
}
