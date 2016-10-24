/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import java.sql.Connection;
import java.util.List;
import modelo.PreguntaRespuestaDTO;
import persistencia.PreguntaRespuestaDAO;
import utilidades.Conexion;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class FachadaPreguntas {
    
    PreguntaRespuestaDAO prdao;
    Connection conexion;
    
    public FachadaPreguntas() throws MiExcepcion {
        prdao = new PreguntaRespuestaDAO();
        conexion = Conexion.getInstance();
    }
    
    public synchronized String insertarRespuesta(PreguntaRespuestaDTO prdto) throws MiExcepcion{
        return prdao.crearRegistro(prdto, conexion);
    }
    
    public List<PreguntaRespuestaDTO> listarPreguntas() throws MiExcepcion{
        return prdao.listarTodo(conexion);
    }
    
    public String eliminarPreguntaRespuesta(String id) throws MiExcepcion{
        return prdao.eliminarRegistro(id, conexion);
    }
}
