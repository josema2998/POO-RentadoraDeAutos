
package Control;
import Modelo.*;
import Vista.VistaAgregar;
import vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlRentradora implements ActionListener{
    
    private Automovil automovilModelo;
    private Reporte reporteModelo;
    private Login vistaLogin;
    private TablaAutos vistaAutos;
    private VistaConfirmacion vistaConfirmacion;
    private VistaPrincipal vistaPrincipal;
    private VistaAgregar vistaAgregar;

    public ControlRentradora(Login vistaLogin, TablaAutos vistaAutos, VistaConfirmacion vistaConfirmacion, VistaPrincipal vistaPrincipal, Automovil automovilModelo, Reporte reporteModelo, VistaAgregar vistaAgregar) {
        this.automovilModelo = automovilModelo;
        this.reporteModelo = reporteModelo;
        this.vistaAutos = vistaAutos;
        this.vistaConfirmacion = vistaConfirmacion;
        this.vistaLogin = vistaLogin;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaAgregar = vistaAgregar;
        
        this.vistaLogin.getjButton1().addActionListener(this);
        this.vistaPrincipal.getBotonRentar().addActionListener(this);
        this.vistaPrincipal.getBotonAgregar().addActionListener(this);
    } 

    public void actionPerformed(ActionEvent e) {
        //Login
        if(vistaLogin.getjButton1() == e.getSource()){
            if (vistaLogin.getContraseña().getText().equals("admin")){
                vistaPrincipal.setVisible(true);
                vistaLogin.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrecto" + ".", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Agregar
        if(vistaPrincipal.getBotonAgregar() == e.getSource()){
            String Nombre,Placa,Modelo,Puertas,Precio;
            vistaAgregar.setVisible(true);
            vistaPrincipal.setVisible(false);
            
            Nombre = vistaAgregar.getTextoNombre().getText();
            Placa = vistaAgregar.getTextoPlaca().getText();
            Modelo = vistaAgregar.getTextoModelo().getText();
            Puertas = vistaAgregar.getTextoPuertas().getText();
            Precio = vistaAgregar.getTextoPrecio().getText();
            
            automovilModelo.setNombre(Nombre);
            automovilModelo.setPlaca(Placa);
            automovilModelo.setModelo(0);
            automovilModelo.setPuertas(0);
            automovilModelo.setPrecio(0);
        }
        //Rentar
        if(vistaPrincipal.getBotonRentar() == e.getSource()){
            vistaAutos.setVisible(true);
            vistaPrincipal.setVisible(false);
        }
        //Reporte
        if(vistaPrincipal.getBotonGenerar() == e.getSource()){
            
        }
        //
    }
}
