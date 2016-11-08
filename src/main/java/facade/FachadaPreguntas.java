/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import modelo.ComentarioDTO;
import modelo.PreguntaRespuestaDTO;
import modelo.UsuarioDTO;
import persistencia.ComentariosDAO;
import persistencia.PreguntaRespuestaDAO;
import persistencia.UsuarioDAO;
import utilidades.Conexion;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class FachadaPreguntas {
    
    PreguntaRespuestaDAO prdao;
    ComentariosDAO cdao;
    UsuarioDAO udao;
    Connection conexion;
        
    public FachadaPreguntas() throws MiExcepcion {
        prdao = new PreguntaRespuestaDAO();
        cdao = new ComentariosDAO();
        udao = new UsuarioDAO();
        conexion = Conexion.getInstance();
    }
    
    public synchronized String insertarRespuesta(PreguntaRespuestaDTO prdto) throws MiExcepcion{
        return prdao.crearRegistro(prdto, conexion);
    }
    
    public List<PreguntaRespuestaDTO> listarPreguntas() throws MiExcepcion{
        return prdao.listarTodo(conexion);
    }
    
    public List<PreguntaRespuestaDTO> listarPreguntasConsultas() throws MiExcepcion{
        List<PreguntaRespuestaDTO> preguntas = prdao.listarParaConsultas(conexion);
        for(PreguntaRespuestaDTO pr : preguntas){
            ArrayList<ComentarioDTO> comentarios = cdao.listarComentarios(conexion, pr.getId());
            pr.setComentarios(comentarios);
        }
        return preguntas;
    }
     
    public String cambiarEstadoPreguntaRespuesta(String id, int estado) throws MiExcepcion{
        return prdao.cambiarEstadoPregunta(id, conexion, estado);
    }
      
    public PreguntaRespuestaDTO detallesPreguntaRespuesta(int id) throws MiExcepcion{
        return prdao.detallesPreguntaRespuesta(conexion, id);
    }
    
    public String editarPreguntaRespuesta(PreguntaRespuestaDTO pr, int id) throws MiExcepcion{
        return prdao.editarPreguntaRespuesta(conexion, pr, id);
    }
    
    public String insertarComentario(ComentarioDTO cdto) throws MiExcepcion{
        return cdao.crearRegistro(cdto, conexion);
    }
    
}
