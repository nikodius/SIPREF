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
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class ComentariosDAO implements ModeloDAO {

    PreparedStatement statement;
    ResultSet rs;

    @Override
    public ArrayList<Object> listarTodosFiltro(Connection conexion, int id) throws MiExcepcion {
        ArrayList<Object> listaComentarios = new ArrayList();
        try {
            String query = "SELECT  Id_comentario, Contenido_comentario, Nombre_presona_comenta, Email_persona_comenta, Id_pregunta_respuesta, Fecha_comentario, activo "
                    + "FROM comentario WHERE Id_pregunta_respuesta=?;";
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                ComentarioDTO comentario = new ComentarioDTO();
                comentario.setIdComentario(rs.getInt(1));
                comentario.setContenido(rs.getString(2));
                comentario.setNombreComentarista(rs.getString(3));
                comentario.setEmailComentarista(rs.getString(4));
                comentario.setIdPreguntaRespuesta(rs.getInt(5));
                comentario.setFechaComentario(rs.getString(6));
                comentario.setActivo(Integer.parseInt(rs.getString(7)) == 1 ? true : false);
                listaComentarios.add(comentario);
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        return listaComentarios;
    }

    @Override
    public String crearRegistro(Object dto, Connection conexion) {
        ComentarioDTO comentario = (ComentarioDTO) dto;
        int resultado = 0;
        String respuesta = "";
        String sql = "INSERT INTO comentario(Contenido_comentario, Fecha_comentario, Nombre_presona_comenta, Email_persona_comenta, Id_pregunta_respuesta) VALUES (?, ?, ?, ?, ?)";
        try {
            Random r = new Random();
            statement = conexion.prepareStatement(sql);
            statement.setString(1, comentario.getContenido());
            statement.setString(2, String.valueOf(comentario.getFechaComentario()));
            statement.setString(3, comentario.getNombreComentarista());
            statement.setString(4, comentario.getEmailComentarista());
            statement.setInt(5, comentario.getIdPreguntaRespuesta());
            resultado = statement.executeUpdate();
            if (resultado != 0) {
                respuesta = "comentario registrado";

            } else {
                respuesta = "NO se registro el comentario";
            }

        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
            respuesta = "error al insertar el comentario";
        }
        return respuesta;
    }

    @Override
    public String editar(Connection conexion, Object dto, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String cambiarEstado(String id, Connection conexion, int estado) {
        int resultado = 0;
        String respuesta = "";
        String sql = "UPDATE comentario set activo=? "
                + "WHERE Id_comentario = ?;";
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

    @Override
    public ArrayList<Object> listarTodo(Connection conexion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object seleccionarUno(Connection conexion, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
