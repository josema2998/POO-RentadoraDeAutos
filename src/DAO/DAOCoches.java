
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Modelo.Automovil;

public class DAOCoches extends DAOGeneral<Automovil>{
    public DAOCoches() {
    }

    public int agregar(Automovil e) throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "INSERT INTO coches (nombre_coches, placa_coche, modelo_coche, num_puertas, estado_coche, precio_dia )"+
                "VALUES ("+"'"+ e.getNombre()+ "'"+",'" + e.getPlaca().toString() + "','"+
                e.getModelo()+ "','"+ e.getPuertas()+ "','"+ e.getDisponibilidad()+ "',"+ e.getPrecio()+")";
        System.out.println(orden);
        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int eliminar(String condicion)throws SQLException{
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "DELETE FROM coches WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public int modificar(Automovil e, String condicion)throws SQLException {
        int numFilas = 0;
        Connection con = getConeccion();

        String orden = "UPDATE coches SET " +
                " nombre_coches="+e.getNombre()+"',"+
                "placa_coche= " + e.getPlaca() + "',"+
                " modelo_coche = "+ e.getModelo()+ "',"+
                " num_puertas= " + e.getPuertas()+"',"+
                " estado_coche= "+ e.getDisponibilidad()+"',"+
                " precio_dia= "+ e.getPrecio()+
                " WHERE "+condicion;

        Statement sentencia = con.createStatement();
        numFilas = sentencia.executeUpdate(orden);
        sentencia.close();
        cerrarConeccion(con);
        return numFilas;
    }

    public ArrayList<Automovil> consultar(String condicion) throws SQLException{
        ArrayList<Automovil> lista = new ArrayList<Automovil>();
        Automovil e;
        Connection con = getConeccion();
        String orden = "SELECT * FROM Clientes " +
                (condicion==null || condicion.length()==0 ? "":"WHERE " + condicion);
        Statement sentencia = con.createStatement();
        ResultSet rs = sentencia.executeQuery( orden );
        while (rs.next()) {
            e = new Automovil(rs.getString("nombre_coches"),rs.getString("placa_cohe"),rs.getInt("modelo_coche"),
            rs.getInt("num_puertas"),rs.getBoolean("estado_coche"),rs.getDouble("precio_dia"));
            lista.add( e );
        }
        sentencia.close();
        cerrarConeccion(con);
        return lista;
    }    
}
