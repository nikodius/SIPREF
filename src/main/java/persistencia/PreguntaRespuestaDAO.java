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

    public PreguntaRespuestaDTO detallesPreguntaRespuesta(Connection conexion, int id) throws MiExcepcion {
        PreguntaRespuestaDTO pr = new PreguntaRespuestaDTO();
        try {
            String query = "SELECT  Id_pregunta_respuesta, Contenido_pregunta, Contenido_respuesta, Fecha_creacion, inicio_vigencia, fin_vigencia, Nombre_estado, Id_estado_pregunta  "
                    + "FROM pregunta_respuesta "
                    + "INNER JOIN estado_pregunta_respuesta ON(pregunta_respuesta.Id_estado_pregunta=estado_pregunta_respuesta.Id_estado_pregunta_respuesta)"
                    + "WHERE Id_pregunta_respuesta=?";
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                pr.setId(rs.getInt(1));
                pr.setPregunta(rs.getString(2));
                pr.setRespuesta(rs.getString(3));
                pr.setFecha(rs.getString(4));
                pr.setInicioVigencia(rs.getString(5));
                pr.setFinVigencia(rs.getString(6));
                pr.setEstado(rs.getString(7));
                pr.setCodigoEstado(rs.getInt(8));
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        //devolvemos el arreglo
        return pr;

    }

    public ArrayList<PreguntaRespuestaDTO> listarTodo(Connection conexion) throws MiExcepcion {
        ArrayList<PreguntaRespuestaDTO> listaPreguntas = new ArrayList();
        try {
            String query = "SELECT  Id_pregunta_respuesta, Contenido_pregunta, Contenido_respuesta, Fecha_creacion, inicio_vigencia, fin_vigencia, Nombre_estado, Id_estado_pregunta  "
                    + "FROM pregunta_respuesta "
                    + "INNER JOIN estado_pregunta_respuesta ON(pregunta_respuesta.Id_estado_pregunta=estado_pregunta_respuesta.Id_estado_pregunta_respuesta)"
                    + "ORDER BY Id_pregunta_respuesta DESC";
            statement = conexion.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                PreguntaRespuestaDTO pr = new PreguntaRespuestaDTO();
                pr.setId(rs.getInt(1));
                pr.setPregunta(rs.getString(2));
                pr.setRespuesta(rs.getString(3));
                pr.setFecha(rs.getString(4));
                pr.setInicioVigencia(rs.getString(5));
                pr.setFinVigencia(rs.getString(6));
                pr.setEstado(rs.getString(7));
                pr.setCodigoEstado(rs.getInt(8));
                listaPreguntas.add(pr);
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        //devolvemos el arreglo
        return listaPreguntas;
    }

    public ArrayList<PreguntaRespuestaDTO> listarParaConsultas(Connection conexion) throws MiExcepcion {
        ArrayList<PreguntaRespuestaDTO> listaPreguntas = new ArrayList();
        try {
            String query = "SELECT Id_pregunta_respuesta, Contenido_pregunta, Contenido_respuesta "
                    + "FROM pregunta_respuesta "
                    + "INNER JOIN estado_pregunta_respuesta ON(pregunta_respuesta.Id_estado_pregunta=estado_pregunta_respuesta.Id_estado_pregunta_respuesta) "
                    + "WHERE Id_estado_pregunta <> 1 AND CURDATE() between inicio_vigencia and fin_vigencia "
                    + "ORDER BY Id_pregunta_respuesta DESC;";
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
        String sql = "INSERT INTO pregunta_respuesta(Contenido_pregunta, Contenido_respuesta, inicio_vigencia,  fin_vigencia, Fecha_creacion, Id_estado_pregunta) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Random r = new Random();
            statement = conexion.prepareStatement(sql);
            statement.setString(1, prDto.getPregunta());
            statement.setString(2, prDto.getRespuesta());
            statement.setString(3, prDto.getInicioVigencia());
            statement.setString(4, prDto.getFinVigencia());
            statement.setString(5, prDto.getFecha());
            //estado por defecto incativa
            statement.setInt(6, 1);
            resultado = statement.executeUpdate();
            if (resultado != 0) {
                respuesta = "Registro correcto";

            } else {
                respuesta = "NO se pudo registrar";
            }

        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
            respuesta = "Error, NO se pudo registrar";
        }
        return respuesta;
    }

    public String cambiarEstadoPregunta(String id, Connection conexion, int estado) {
        int resultado = 0;
        String respuesta = "";
        System.out.println("ID: " + id);
        String sql = "UPDATE pregunta_respuesta set Id_estado_pregunta=? "
                + "WHERE Id_pregunta_respuesta = ?;";
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

    public String editarPreguntaRespuesta(Connection conexion, PreguntaRespuestaDTO pr, int id) {
        int resultado = 0;
        String respuesta = "";
        String sql = "UPDATE pregunta_respuesta set Contenido_pregunta=?, Contenido_respuesta=?, inicio_vigencia=?, fin_vigencia=? "
                + "WHERE Id_pregunta_respuesta = ?;";
        try {
            statement = conexion.prepareStatement(sql);
            statement.setString(1, pr.getPregunta());
            statement.setString(2, pr.getRespuesta());
            statement.setString(3, pr.getInicioVigencia());
            statement.setString(4, pr.getFinVigencia());
            statement.setInt(5, id);

            resultado = statement.executeUpdate();

            //comprobar si se ejecuto la instruccion en sql
            if (resultado != 0) {
                respuesta = "cambiada correctamente";

            } else {
                respuesta = "se ha cambiado";
            }

        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
            respuesta = "error, no se modifico";
        }
        return respuesta;
    }
}
