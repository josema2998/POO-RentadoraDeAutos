/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Control.ControlRentradora;
import DAO.DAOCoches;
import Modelo.Automovil;
import java.sql.SQLException;
import vista.*;
import Modelo.*;
import Vista.VistaAgregar;

/**
 *
 * @author Jose Manuel Patron
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        double precio = 12.04;
//        int modelo =2015;
//        String nombre= "versa";
//        Automovil auto = new Automovil(nombre,"yxk-123",modelo,4,true,precio);
//        DAOCoches dao = new DAOCoches();
////        dao.agregar(auto);
//        String condicion = " placa_coche =" + "'yxk-123'" ;
//       dao.eliminar(condicion);

        Login vistaLogin = new Login();
        TablaAutos vistaAutos = new TablaAutos();
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        Automovil automovilModelo = new Automovil();
        Reporte reporteModelo = new Reporte();
        VistaAgregar vistaAgregar = new VistaAgregar();
        
        ControlRentradora control = new ControlRentradora(vistaLogin,vistaAutos,vistaPrincipal,automovilModelo,reporteModelo,vistaAgregar);
        vistaPrincipal.setVisible(true);
    
    }
    
}
