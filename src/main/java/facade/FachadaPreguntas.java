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
import modelo.HistorialDTO;
import modelo.PreguntaRespuestaDTO;
import modelo.UsuarioDTO;
import persistencia.ComentariosDAO;
import persistencia.HistorialDAO;
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
    HistorialDAO hdao;
    Connection conexion;

    public FachadaPreguntas() throws MiExcepcion {
        prdao = new PreguntaRespuestaDAO();
        cdao = new ComentariosDAO();
        udao = new UsuarioDAO();
        hdao = new HistorialDAO();
        conexion = Conexion.getInstance();
    }

    public synchronized String insertarRespuesta(PreguntaRespuestaDTO prdto) throws MiExcepcion {
        return prdao.crearRegistro(prdto, conexion);
    }

    public List<PreguntaRespuestaDTO> listarPreguntas() throws MiExcepcion {
        List<Object> dto = prdao.listarTodo(conexion);
        List<PreguntaRespuestaDTO> preguntas = new ArrayList();
        for (Object mDTO : dto) {
            preguntas.add((PreguntaRespuestaDTO) mDTO);
        }
        for (PreguntaRespuestaDTO pr : preguntas) {
            ArrayList<Object> objects = cdao.listarTodosFiltro(conexion, pr.getId());
            ArrayList<ComentarioDTO> comentarios = new ArrayList();
            for (Object object : objects) {
                comentarios.add((ComentarioDTO) object);
            }
            pr.setComentarios(comentarios);
        }
        return preguntas;
    }

    public List<PreguntaRespuestaDTO> listarPreguntasConsultas() throws MiExcepcion {
        List<PreguntaRespuestaDTO> preguntas = prdao.listarParaConsultas(conexion);
        for (PreguntaRespuestaDTO pr : preguntas) {
            ArrayList<Object> objects = cdao.listarTodosFiltro(conexion, pr.getId());
            ArrayList<ComentarioDTO> comentarios = new ArrayList();
            for (Object object : objects) {
                comentarios.add((ComentarioDTO) object);
            }
            pr.setComentarios(comentarios);
        }
        return preguntas;
    }

    public List<Object> listarComentarios(int id) throws MiExcepcion {
        ArrayList<Object> comentarios = cdao.listarTodosFiltro(conexion, id);
        return comentarios;
    }

    public String cambiarEstadoPreguntaRespuesta(String id, int estado) throws MiExcepcion {
        return prdao.cambiarEstado(id, conexion, estado);
    }

    public Object detallesPreguntaRespuesta(int id) throws MiExcepcion {
        return prdao.seleccionarUno(conexion, id);
    }

    public String editarPreguntaRespuesta(PreguntaRespuestaDTO pr, int id) throws MiExcepcion {
        return prdao.editar(conexion, pr, id);
    }

    public String insertarComentario(ComentarioDTO cdto) throws MiExcepcion {
        return cdao.crearRegistro(cdto, conexion);
    }

    public String cambiarEstadoComentario(String id, int estado) throws MiExcepcion {
        return cdao.cambiarEstado(id, conexion, estado);
    }

    public String insertarHistorial(HistorialDTO hdto) throws MiExcepcion {
        return hdao.crearRegistro(hdto, conexion);
    }

    public List<Object> listarHistorial() throws MiExcepcion {
        ArrayList<Object> historial = hdao.listarTodo(conexion);
        return historial;
    }
}
