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
import modelo.UsuarioDTO;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class UsuarioDAO implements ModeloDAO {

    PreparedStatement statement;
    ResultSet rs;

    @Override
    public ArrayList<Object> listarTodo(Connection conexion) throws MiExcepcion {
        ArrayList<Object> listaUsuarios = new ArrayList();
        try {
            String query = "SELECT Id_usuario, Nombre_usuario, Apellido_usuario, Telefono_usuario, Email_usuario, "
                    + "roles.Nombre_rol, Aprobar_pregunta_usuario, user, usuario.id_estado_usuario, estado_usuario.estado "
                    + "FROM usuario "
                    + "INNER JOIN roles ON(usuario.Id_rol=roles.Id_rol) "
                    + "INNER JOIN estado_usuario ON(usuario.id_estado_usuario=estado_usuario.Id) "
                    + "WHERE user <> 'admin' "
                    + "ORDER BY Id_usuario DESC;";
            statement = conexion.prepareStatement(query);
            rs = statement.executeQuery();
            while (rs.next()) {
                UsuarioDTO user = new UsuarioDTO();
                user.setId(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setApellido(rs.getString(3));
                user.setTelefono(rs.getString(4));
                user.setEmail(rs.getString(5));
                user.setRol(rs.getString(6));
                user.setAprobarPregunta(rs.getInt(7) == 1 ? true : false);
                user.setUser(rs.getString(8));
                user.setIdEstado(rs.getInt(9));
                user.setEstado(rs.getString(10));
                listaUsuarios.add(user);
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        //devolvemos el arreglo
        return listaUsuarios;
    }

    @Override
    public Object seleccionarUno(Connection conexion, int id) throws MiExcepcion {
        UsuarioDTO userDTO = new UsuarioDTO();
        try {
            String query = "SELECT Id_usuario, Nombre_usuario, Apellido_usuario, Telefono_usuario, Email_usuario,"
                    + "id_estado_usuario, Id_rol, user FROM usuario "
                    + "WHERE Id_usuario=?";
            statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                userDTO.setId(rs.getInt(1));
                userDTO.setNombre(rs.getString(2));
                userDTO.setApellido(rs.getString(3));
                userDTO.setTelefono(rs.getString(4));
                userDTO.setEmail(rs.getString(5));
                userDTO.setIdEstado(rs.getInt(6));
                userDTO.setIdRol(rs.getInt(7));
                userDTO.setUser(rs.getString(8));
            }
        } catch (SQLException sqlexception) {
            throw new MiExcepcion("Error " + sqlexception, sqlexception);
        }
        //devolvemos el arreglo
        return userDTO;
    }

    @Override
    public String crearRegistro(Object dto, Connection conexion) throws MiExcepcion {
        UsuarioDTO IngUsu = (UsuarioDTO) dto;
        String rta = "";
        try {
            statement = conexion.prepareStatement("INSERT INTO usuario(Nombre_usuario, Apellido_usuario, Telefono_usuario, Email_usuario,"
                    + "id_estado_usuario, Id_rol, user) VALUES (?,?,?,?,?,?,?)");
            statement.setString(1, IngUsu.getNombre());
            statement.setString(2, IngUsu.getApellido());
            statement.setString(3, IngUsu.getTelefono());
            statement.setString(4, IngUsu.getEmail());
            statement.setInt(5, IngUsu.getIdEstado());
            statement.setInt(6, IngUsu.getIdRol());
            statement.setString(7, IngUsu.getUser());

            int resultado = statement.executeUpdate();
            if (resultado == 0) {
                rta = "No se pudo registrar el usuario";//Mensaje No.6

            } else {
                rta = "Usuario Registrado";//Mensaje No.5
            }

        } catch (SQLException sqle) {
            rta = sqle.getMessage();
        }
        return rta;
    }

    @Override
    public String editar(Connection conexion, Object dto, int id) throws MiExcepcion {
        UsuarioDTO user = (UsuarioDTO) dto;
        int resultado = 0;
        String respuesta = "";
        String sql = "UPDATE usuario set Nombre_usuario=?, Apellido_usuario=?, Telefono_usuario=?, Email_usuario=?, "
                + "id_estado_usuario=?, Id_rol=?, user=? "
                + "WHERE Id_usuario = ?;";
        try {
            statement = conexion.prepareStatement(sql);
            statement.setString(1, user.getNombre());
            statement.setString(2, user.getApellido());
            statement.setString(3, user.getTelefono());
            statement.setString(4, user.getEmail());
            statement.setInt(5, user.getIdEstado());
            statement.setInt(6, user.getIdRol());
            statement.setString(7, user.getUser());
            statement.setInt(8, id);

            resultado = statement.executeUpdate();

            //comprobar si se ejecuto la instruccion en sql
            if (resultado != 0) {
                respuesta = "Modificado Correctamente";

            } else {
                respuesta = "NO se ha modificado";
            }

        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
            respuesta = "error, no se modifico";
        }
        return respuesta;
    }

    @Override
    public String cambiarEstado(String id, Connection conexion, int estado) throws MiExcepcion {
        int resultado = 0;
        String respuesta = "";
        String sql = "UPDATE usuario set id_estado_usuario=? "
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

    public ArrayList<UsuarioDTO> listarAutores(Connection conexion) throws MiExcepcion {
        ArrayList<UsuarioDTO> listaAutores = new ArrayList();
        try {
            String query = "SELECT Id_usuario, Nombre_usuario, Apellido_usuario, Telefono_usuario, Email_usuario, Id_rol, Aprobar_pregunta_usuario, user "
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
                autor.setAprobarPregunta(rs.getInt(7) == 1 ? true : false);
                autor.setUser(rs.getString(8));
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

    public UsuarioDTO detallesUsuarioLogin(Connection conexion, String user) throws MiExcepcion {
        UsuarioDTO userDTO = new UsuarioDTO();
        try {
            String query = "SELECT  Id_usuario, Nombre_usuario, Apellido_usuario, Telefono_usuario, id_estado_usuario, usuario.Id_rol, Nombre_rol, Aprobar_pregunta_usuario, user "
                    + "FROM usuario INNER JOIN roles ON(usuario.Id_rol=roles.Id_rol)"
                    + "WHERE user = ?";
            statement = conexion.prepareStatement(query);
            statement.setString(1, user);
            rs = statement.executeQuery();
            if (rs.next()) {
                userDTO.setId(rs.getInt(1));
                userDTO.setNombre(rs.getString(2));
                userDTO.setApellido(rs.getString(3));
                userDTO.setTelefono(rs.getString(4));
                userDTO.setIdEstado(rs.getInt(5));
                userDTO.setIdRol(rs.getInt(6));
                userDTO.setRol(rs.getString(7));
                userDTO.setAprobarPregunta(rs.getInt(8) == 0 ? false : true);
                userDTO.setUser(rs.getString(9));
            } else {
                //si no lo encuentra lo deja como inactivo
                userDTO.setIdEstado(2);
            }
        } catch (SQLException ex) {
            System.out.println("Error de MySQL: " + ex.getMessage());
        }
        return userDTO;
    }

    @Override
    public ArrayList<Object> listarTodosFiltro(Connection conexion, int id) throws MiExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
