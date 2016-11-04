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
import java.util.Random;
import modelo.ComentarioDTO;
import modelo.PreguntaRespuestaDTO;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class ComentariosDAO {

    PreparedStatement statement;
    ResultSet rs;
    String mensaje = "";

    public ArrayList<ComentarioDTO> listarTodo(Connection conexion) throws MiExcepcion {
        ArrayList<ComentarioDTO> listaPreguntas = new ArrayList();
        try {
            String query = "SELECT  Id_comentario, Contenido_comentario, Nombre_persona_comentario, Email_persona_comentario, Id_padre_comentario, Id_pregunta_respuesta FROM comentario;";
            statement = conexion.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                ComentarioDTO comentario = new ComentarioDTO();
                comentario.setIdComentario(rs.getInt(1));
                comentario.setContenido(rs.getString(2));
                comentario.setNombreComentarista(rs.getString(3));
                comentario.setEmailComentarista(rs.getString(4));
                comentario.setIdPadre(rs.getInt(5));
                comentario.setIdPreguntaRespuesta(rs.getInt(6));
                listaPreguntas.add(comentario);
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        //devolvemos el arreglo
        return listaPreguntas;

    }

    public String crearRegistro(ComentarioDTO comentario, Connection conexion) {
        int resultado = 0;
        String respuesta = "";
        String sql = "INSERT INTO comentario(Contenido_comentario, Fecha_comentario, Nombre_persona_comentario, Email_persona_comentario, Id_padre_comentario, Id_pregunta_respuesta) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Random r = new Random();
            statement = conexion.prepareStatement(sql);
            statement.setString(1, comentario.getContenido());
            statement.setString(2, String.valueOf(comentario.getFechaComentario()));
            statement.setString(3, comentario.getNombreComentarista());
            statement.setString(4, comentario.getEmailComentarista());
            statement.setInt(5, comentario.getIdPadre());
            statement.setInt(6, comentario.getIdPreguntaRespuesta());
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
        String sql = "DELETE FROM comentario WHERE Id_comentario=?";
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
