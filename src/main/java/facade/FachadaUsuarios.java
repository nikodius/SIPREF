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
 *
 * @author UserQV
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

    public LoginDTO login(LoginDTO ldto) throws SQLException{
        return ldao.Login(ldto, conexion);
    }
    
    public List<UsuarioDTO> listarAutores() throws MiExcepcion{
        return udao.listarAutores(conexion);
    }
    
    public String cambiarEstadoAprobarPregunta(String id, int estado) throws MiExcepcion{
        return udao.cambiarEstadoAprobacion(id, conexion, estado);
    }
    
    public UsuarioDTO detallesUsuarioLogin(String user) throws MiExcepcion{
        return udao.detallesUsuarioLogin(conexion, user);
    }
    
    public List<Object> listarUsuarios() throws MiExcepcion{
        return udao.listarTodo(conexion);
    }
    
    public String insertarUsuario(UsuarioDTO urdto) throws MiExcepcion{
        return udao.crearRegistro(urdto, conexion);
    }
    
    public String cambiarEstadoUsuario(String id, int estado) throws MiExcepcion{
        return udao.cambiarEstado(id, conexion, estado);
    }
    
    public Object detallesUsuarioModificar(int id) throws MiExcepcion{
        return udao.seleccionarUno(conexion, id);
    }
    
    public String editarUsuario(UsuarioDTO pr, int id) throws MiExcepcion{
        return udao.editar(conexion, pr, id);
    }
}
