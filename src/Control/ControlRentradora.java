
package Control;
import Modelo.*;
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
    
    public ControlRentradora (Automovil automovilModelo, Reporte reporteModelo, Login vistaLogin, TablaAutos vistaAutos, VistaConfirmacion vistaConfirmacion, VistaPrincipal vistaPrincipal){
        this.automovilModelo = automovilModelo;
        this.reporteModelo = reporteModelo;
        this.vistaAutos = vistaAutos;
        this.vistaConfirmacion = vistaConfirmacion;
        this.vistaLogin = vistaLogin;
        this.vistaPrincipal = vistaPrincipal;
        
        this.vistaLogin.getjButton1().addActionListener(this);
        
    }
    
    public ControlRentradora(Login vistaLogin){
        this.vistaLogin = vistaLogin;
    }

    public void actionPerformed(ActionEvent e) {
        //Login
        if(vistaLogin.getjButton1() == e.getSource()){
            System.out.println("puto");
            if (vistaLogin.getContraseña().equals("admin")){
                vistaPrincipal.setVisible(true);
                vistaLogin.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrecto" + ".", ".", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Agregar
        if(vistaPrincipal.getBotonAgregar() == e.getSource()){
        
        }
        //Rentar
        if(vistaPrincipal.getBotonRentar() == e.getSource()){
            
        }
        //Reporte
        if(vistaPrincipal.getBotonGenerar() == e.getSource()){
            
        }
    }
}
