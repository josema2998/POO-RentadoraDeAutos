
package Control;
import DAO.DAOCoches;
import Modelo.*;
import Vista.VistaAgregar;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlRentradora implements ActionListener{
    
    private Automovil automovilModelo;
    private Reporte reporteModelo;
    private Login vistaLogin;
    private TablaAutos vistaAutos;
    private VistaPrincipal vistaPrincipal;
    private VistaAgregar vistaAgregar;
    
    public ControlRentradora(Login vistaLogin, TablaAutos vistaAutos, VistaPrincipal vistaPrincipal, Automovil automovilModelo, Reporte reporteModelo, VistaAgregar vistaAgregar) {
        this.automovilModelo = automovilModelo;
        this.reporteModelo = reporteModelo;
        this.vistaAutos = vistaAutos;
        this.vistaLogin = vistaLogin;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaAgregar = vistaAgregar;
        
        this.vistaLogin.getjButton1().addActionListener(this);
        this.vistaAgregar.getAgregar().addActionListener(this);
        this.vistaPrincipal.getBotonRentar().addActionListener(this);
        this.vistaPrincipal.getBotonAgregar().addActionListener(this);
        this.vistaAutos.getBotonEliminar().addActionListener(this);
        this.vistaAutos.getBotonRentaAuto().addActionListener(this);
        this.vistaAutos.getBotonRegresar1().addActionListener(this);
        this.vistaAgregar.getBotonRegresar2().addActionListener(this);
        this.vistaLogin.getBotonRegresar3().addActionListener(this);
        this.vistaAutos.getDevolver().addActionListener(this);
        this.vistaPrincipal.getBotonGenerar().addActionListener(this);
    }    

    public void actionPerformed(ActionEvent e) {
//        //Login
//        if(vistaLogin.getjButton1() == e.getSource()){
//            if (vistaLogin.getContraseña().getText().equals("admin")){
//                vistaPrincipal.setVisible(true);
//                vistaLogin.setVisible(false);
//            }else{
//                JOptionPane.showMessageDialog(null, "Incorrecto" + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
//            }
//        }
        //Agregar
        if(vistaPrincipal.getBotonAgregar() == e.getSource()){
            vistaPrincipal.setVisible(false);
            vistaLogin.setVisible(true);           
        }
        
        if(vistaLogin.getjButton1() == e.getSource()){
            if (vistaLogin.getContraseña().getText().equals("admin")){
                vistaAgregar.setVisible(true);
                vistaLogin.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrecto" + ".", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        if(vistaAgregar.getAgregar() == e.getSource()){
             vistaLogin.setVisible(true);
            String Nombre,Placa;
            int Modelo = 0,Puertas=0;
            double Precio=0;
            boolean valido=true;
            Nombre = vistaAgregar.getTextoNombre().getText();
            Placa = vistaAgregar.getTextoPlaca().getText();
            try{
             Modelo = Integer.parseInt(vistaAgregar.getTextoModelo().getText());
            }catch(NumberFormatException x){
                valido = false;
            }
            try{
             Puertas = Integer.parseInt(vistaAgregar.getTextoPuertas().getText());
            }catch(NumberFormatException y){
                valido = false;
            }
            
            try{
             Precio = Double.parseDouble(vistaAgregar.getTextoPrecio().getText());
            }catch(NumberFormatException y){
                valido = false;
            }
           
            automovilModelo.setNombre(Nombre);
            automovilModelo.setPlaca(Placa);
            automovilModelo.setModelo(String.valueOf(Modelo));
            automovilModelo.setPuertas(String.valueOf(Puertas));
            automovilModelo.setDisponibilidad(true);
            automovilModelo.setPrecio(Precio);
            
            DAOCoches coche = new DAOCoches();
            if(valido == true){
                try {
                    coche.agregar(automovilModelo);
                    JOptionPane.showMessageDialog(vistaAutos, "Accion correcta, AGREGADO", "Agregado", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(vistaAutos, "Ocurrio un ERROR NO AGREGADO", "Error", JOptionPane.WARNING_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(vistaAutos, "Datos No Validos", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
        //Eliminar de la base de datos
        if (vistaAutos.getBotonEliminar() == e.getSource()){
                vistaAutos.getTextoEliminar().getText();
                DAOCoches auto = new DAOCoches(); 
            try {
                auto.eliminar(" placa_coche =" +  "'"+vistaAutos.getTextoEliminar().getText()+"'");
                JOptionPane.showMessageDialog(vistaAutos, "Accion correcta, ELIMINADO", "ELIMINADO", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(vistaAutos, "Ocurrio un ERROR - NO ELIMINADO", "Error", JOptionPane.WARNING_MESSAGE);
            }  
        }
        //Rentar en la tabla
        if(vistaAutos.getBotonRentaAuto() == e.getSource()){
            vistaAutos.getTextoRentar().getText();
            DAOCoches auto = new DAOCoches();
            automovilModelo.setDisponibilidad(false);
            try{
                auto.modificar(automovilModelo," placa_coche =" +  "'"+vistaAutos.getTextoRentar().getText()+"'");
                JOptionPane.showMessageDialog(vistaAutos, "Accion correcta, RENTADO", "RENTA", JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(vistaAutos, "Ocurrio un ERROR - NO PUDO SER MODIFICADO", "Error", JOptionPane.INFORMATION_MESSAGE); 
            }
        }
        
        if(vistaAutos.getDevolver() == e.getSource()){
            vistaAutos.getTextoDevolver().getText();
            DAOCoches auto = new DAOCoches();
            automovilModelo.setDisponibilidad(true);
            try{
                auto.modificar(automovilModelo," placa_coche =" +  "'"+vistaAutos.getTextoDevolver().getText()+"'");
                JOptionPane.showMessageDialog(vistaAutos, "Accion correcta, DEVUELTO", "RENTA", JOptionPane.INFORMATION_MESSAGE);
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(vistaAutos, "Ocurrio un ERROR - NO PUDO SER MODIFICADO", "Error", JOptionPane.WARNING_MESSAGE); 
            }
        }
        
        
        //Muestra la tabla para rRentar
        if(vistaPrincipal.getBotonRentar() == e.getSource()){
            vistaAutos.setVisible(true);
            vistaPrincipal.setVisible(false);
               //tabla 
        ArrayList <Automovil> coches = new ArrayList();
        DAOCoches auto = new DAOCoches(); 
        try {
         coches = auto.consultar("estado_coche = 1");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vistaAutos, "Ocurrio un ERROR - NO SE PUDO ACCEDER A LA BASE DE DATOS", "Error", JOptionPane.WARNING_MESSAGE);
        }

        
        for (int i=0; i< coches.size(); i++ ){
            vistaAutos.getTablaAutos().setValueAt(coches.get(i).getNombre(), i, 0);
            vistaAutos.getTablaAutos().setValueAt(coches.get(i).getPlaca(), i, 1);
            vistaAutos.getTablaAutos().setValueAt(coches.get(i).getModelo(), i, 2);
            vistaAutos.getTablaAutos().setValueAt(coches.get(i).getPuertas(), i, 3);
            vistaAutos.getTablaAutos().setValueAt(coches.get(i).getDisponibilidad(), i, 4);
            vistaAutos.getTablaAutos().setValueAt(coches.get(i).getPrecio(), i, 5);
            
        }
           
            
        }
        
       
        //Reporte
        
        if(vistaPrincipal.getBotonGenerar() == e.getSource()){
            
            ArrayList <Automovil> coches = new ArrayList();
        DAOCoches auto = new DAOCoches(); 
        try {
         coches = auto.consultar("estado_coche = 0");
        } catch (SQLException ex) {
            Logger.getLogger(ControlRentradora.class.getName()).log(Level.SEVERE, null, ex);
        }
            String ruta = "C:\\reporte.txt";
            File archivo = new File(ruta);
            BufferedWriter bw ;
        if(archivo.exists()) {
                try {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    for(int i=0;i<coches.size();i++){
                    bw.write(coches.get(i).getNombre()+ "   "+coches.get(i).getPlaca() + "   " + coches.get(i).getPrecio() + '\n');
                    }
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlRentradora.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        } else {
                try {
                    bw = new BufferedWriter(new FileWriter(archivo));
                     bw.write("Acabo de crear el fichero de texto.");
                     bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ControlRentradora.class.getName()).log(Level.SEVERE, null, ex);
                }
           
        }
        
    }
            
        
        
        
        //Botones regresar
        if(vistaAutos.getBotonRegresar1() == e.getSource()){
            vistaPrincipal.setVisible(true);
            vistaAutos.setVisible(false);
        }
        if(vistaAgregar.getBotonRegresar2() == e.getSource()){
            vistaPrincipal.setVisible(true);
            vistaAgregar.setVisible(false);
        }
        if(vistaLogin.getBotonRegresar3() == e.getSource()){
            vistaPrincipal.setVisible(true);
            vistaLogin.setVisible(false);
        }
    }
}

