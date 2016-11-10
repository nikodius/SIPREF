/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.Connection;
import java.util.List;
import modelo.UsuarioDTO;
import persistencia.UsuarioDAO;
import utilidades.Conexion;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class FachadaUsuarios {
    
    UsuarioDAO udao;
    Connection conexion;
        
    public FachadaUsuarios() throws MiExcepcion {
        udao = new UsuarioDAO();
        conexion = Conexion.getInstance();
    }

    public List<UsuarioDTO> listarAutores() throws MiExcepcion{
        return udao.listarAutores(conexion);
    }
    
    public String cambiarEstadoAprobarPregunta(String id, int estado) throws MiExcepcion{
        return udao.cambiarEstadoAprobacion(id, conexion, estado);
    }
    
    public UsuarioDTO detallesUsuario(String user) throws MiExcepcion{
        return udao.detallesUsuario(conexion, user);
    }
}
