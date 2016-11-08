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
import modelo.PreguntaRespuestaDTO;
import modelo.UsuarioDTO;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class UsuarioDAO {
    
    PreparedStatement statement;
    ResultSet rs;
    String mensaje = "";
    
    public ArrayList<UsuarioDTO> listarAutores(Connection conexion) throws MiExcepcion {
        ArrayList<UsuarioDTO> listaAutores = new ArrayList();
        try {
            String query = "SELECT Id_usuario, Nombre_usuario, Apellido_usuario, Telefono_usuario, Email_usuario, Id_rol, Aprobar_pregunta_usuario "
                    + "FROM usuario "
                    + "WHERE Id_rol=2;";
            statement = conexion.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                UsuarioDTO autor = new UsuarioDTO();
                autor.setId(rs.getInt(1));
                autor.setNombre(rs.getString(2));
                autor.setApellido(rs.getString(3));
                autor.setTelefono(rs.getString(4));
                autor.setEmail(rs.getString(5));
                autor.setIdRol(rs.getInt(6));
                autor.setAprobarPregunta(rs.getInt(7)==1?true:false);
                listaAutores.add(autor);
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        //devolvemos el arreglo
        return listaAutores;
    }
    
    public String cambiarEstadoAprobacion(String id, Connection conexion, int estado) {
        int resultado = 0;
        String respuesta = "";
        String sql = "UPDATE usuario set Aprobar_pregunta_usuario=? "
                + "WHERE Id_usuario = ?;";
        try {
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, estado);
            statement.setString(2, id);

            resultado = statement.executeUpdate();

            //comprobar si se ejecuto la instruccion en sql
            if (resultado != 0) {
                respuesta = "cambiada correctamente";

            } else {
                respuesta = "se ha cambiado";
            }

        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
        }
        return respuesta;
    }
}
