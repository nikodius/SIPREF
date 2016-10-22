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
import java.util.List;
import java.util.Random;
import modelo.PreguntaRespuestaDTO;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class PreguntaRespuestaDAO {
    
    PreparedStatement statement;
    ResultSet rs;
    String mensaje = "";
    
    public ArrayList<PreguntaRespuestaDTO> listarTodo(Connection conexion) throws MiExcepcion {
        ArrayList<PreguntaRespuestaDTO> listaPreguntas = new ArrayList();
        try {
            String query = "SELECT  Id_pregunta_respuesta, Contenido_pregunta, Contenido_respuesta FROM pregunta_respuesta;";
            statement = conexion.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                PreguntaRespuestaDTO pr = new PreguntaRespuestaDTO();
                pr.setId(rs.getInt(1));
                pr.setPregunta(rs.getString(2));
                pr.setRespuesta(rs.getString(3));
                listaPreguntas.add(pr);
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        //devolvemos el arreglo
        return listaPreguntas;

    }
    
    public String crearRegistro(PreguntaRespuestaDTO prDto, Connection conexion) {
        int resultado = 0;
        String respuesta = "";
        String sql = "INSERT INTO pregunta_respuesta(Id_pregunta_respuesta, Contenido_pregunta, Contenido_respuesta) VALUES (?, ?, ?)";
        try {
            Random r = new Random();
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, r.nextInt());
            statement.setString(2, prDto.getPregunta());
            statement.setString(3, prDto.getRespuesta());
            resultado = statement.executeUpdate();
            if (resultado != 0) {
                respuesta = "registrada";

            } else {
                respuesta = "NO se ha registrado";
            }

        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
        }
        return respuesta;
    }
    
    public String eliminarRegistro(String id, Connection conexion) {
        int resultado = 0;
        String respuesta = "";
        System.out.println("ID: " + id);
        String sql = "DELETE FROM pregunta_respuesta WHERE Id_pregunta_respuesta=?";
        try {
            statement = conexion.prepareStatement(sql);
            statement.setString(1, id);

            resultado = statement.executeUpdate();

            //comprobar si se ejecuto la instruccion en sql
            if (resultado != 0) {
                respuesta = "eliminado correctamente";

            } else {
                respuesta = "se ha eliminado";
            }

        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
        }
        return respuesta;
    }
}
