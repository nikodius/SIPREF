/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.HistorialDTO;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class HistorialDAO {
    
    PreparedStatement statement;
    ResultSet rs;
    String mensaje = "";
    
    public ArrayList<HistorialDTO> listarHistorial(Connection conexion) throws MiExcepcion {
        ArrayList<HistorialDTO> listaHIstorial = new ArrayList();
        try {
            String query = "SELECT  Usuario, accion, fecha "
                    + "FROM historial;";
            statement = conexion.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                HistorialDTO history = new HistorialDTO();
                history.setUsuario(rs.getString(1));
                history.setAccion(rs.getString(2));
                history.setFecha(rs.getString(3));
                listaHIstorial.add(history);
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        //devolvemos el arreglo
        return listaHIstorial;
    }

    public String crearRegistro(HistorialDTO historial, Connection conexion) {
        int resultado = 0;
        String respuesta = "";
        String sql = "INSERT INTO historial(usuario, accion, fecha) VALUES (?, ?, ?)";
        try {
            statement = conexion.prepareStatement(sql);
            statement.setString(1, historial.getUsuario());
            statement.setString(2, historial.getAccion());
            statement.setString(3, historial.getFecha());
            resultado = statement.executeUpdate();
            if (resultado != 0) {
                respuesta = "registrado";

            } else {
                respuesta = "NO se registro";
            }

        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
            respuesta = "error al insertar";
        }
        return respuesta;
    }
}
