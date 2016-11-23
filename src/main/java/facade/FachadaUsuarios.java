/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import modelo.LoginDTO;
import modelo.UsuarioDTO;
import persistencia.LoginDAO;
import persistencia.UsuarioDAO;
import utilidades.Conexion;
import utilidades.MiExcepcion;

/**
 * Fachada daos usuarios
 */
public class FachadaUsuarios {
    
    LoginDAO ldao;
    UsuarioDAO udao;
    Connection conexion;

    public FachadaUsuarios() throws MiExcepcion {
        ldao = new LoginDAO();
        udao = new UsuarioDAO();
        conexion = Conexion.getInstance();
    }

    /**
     * metodo para el login
     * @param ldto
     * @return
     * @throws SQLException 
     */
    public LoginDTO login(LoginDTO ldto) throws SQLException{
        return ldao.Login(ldto, conexion);
    }
    
    /**
     * metodo para listar autores
     * @return
     * @throws MiExcepcion 
     */
    public List<UsuarioDTO> listarAutores() throws MiExcepcion{
        return udao.listarAutores(conexion);
    }
    
    /**
     * metodo cambiar estado aprobacion del autor
     * @param id
     * @param estado
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String cambiarEstadoAprobarPregunta(String id, int estado) throws MiExcepcion{
        return udao.cambiarEstadoAprobacion(id, conexion, estado);
    }
    
    /**
     * metodo para detalles de usuario en login
     * @param user
     * @return
     * @throws MiExcepcion 
     */
    public UsuarioDTO detallesUsuarioLogin(String user) throws MiExcepcion{
        return udao.detallesUsuarioLogin(conexion, user);
    }
    
    /**
     * metodo para listar usuarios
     * @return
     * @throws MiExcepcion 
     */
    public List<Object> listarUsuarios() throws MiExcepcion{
        return udao.listarTodo(conexion);
    }
    
    /**
     * metodo para insertar usuario
     * @param urdto
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String insertarUsuario(UsuarioDTO urdto) throws MiExcepcion{
        return udao.crearRegistro(urdto, conexion);
    }
    
    /**
     * metodo para cambiar estado usuario
     * @param id
     * @param estado
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String cambiarEstadoUsuario(String id, int estado) throws MiExcepcion{
        return udao.cambiarEstado(id, conexion, estado);
    }
    
    /**
     * metodo para detalles usuario a modificar
     * @param id
     * @return
     * @throws MiExcepcion 
     */
    public Object detallesUsuarioModificar(int id) throws MiExcepcion{
        return udao.seleccionarUno(conexion, id);
    }
    
    /**
     * metodo editar usuario
     * @param pr
     * @param id
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String editarUsuario(UsuarioDTO pr, int id) throws MiExcepcion{
        return udao.editar(conexion, pr, id);
    }
}
