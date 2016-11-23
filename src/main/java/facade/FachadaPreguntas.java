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
 * Fachada de daos preguntas y respuestas
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

    /**
     * metodo para insertar FAQ
     * @param prdto
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String insertarFAQ(PreguntaRespuestaDTO prdto) throws MiExcepcion {
        return prdao.crearRegistro(prdto, conexion);
    }

    /**
     * metodo para listar FAQ 
     * @return
     * @throws MiExcepcion 
     */
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

    /**
     * metodo para listar FAQ de consulta
     * @return
     * @throws MiExcepcion 
     */
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

    /**
     * metodo para listar comentarios
     * @param id
     * @return
     * @throws MiExcepcion 
     */
    public List<Object> listarComentarios(int id) throws MiExcepcion {
        ArrayList<Object> comentarios = cdao.listarTodosFiltro(conexion, id);
        return comentarios;
    }

    /**
     * metodo para cambiar estado FAQ
     * @param id
     * @param estado
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String cambiarEstadoPreguntaRespuesta(String id, int estado) throws MiExcepcion {
        return prdao.cambiarEstado(id, conexion, estado);
    }

    /**
     * metodo para ver detalles FAQ
     * @param id
     * @return
     * @throws MiExcepcion 
     */
    public Object detallesPreguntaRespuesta(int id) throws MiExcepcion {
        return prdao.seleccionarUno(conexion, id);
    }

    /**
     * metodo para editar FAQ
     * @param pr
     * @param id
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String editarPreguntaRespuesta(PreguntaRespuestaDTO pr, int id) throws MiExcepcion {
        return prdao.editar(conexion, pr, id);
    }

    /**
     * metodo para insertar comentario
     * @param cdto
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String insertarComentario(ComentarioDTO cdto) throws MiExcepcion {
        return cdao.crearRegistro(cdto, conexion);
    }

    /**
     * metodo para cambiar estado comentario
     * @param id
     * @param estado
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String cambiarEstadoComentario(String id, int estado) throws MiExcepcion {
        return cdao.cambiarEstado(id, conexion, estado);
    }

    /**
     * metodo para insertar historial
     * @param hdto
     * @return
     * @throws MiExcepcion 
     */
    public synchronized String insertarHistorial(HistorialDTO hdto) throws MiExcepcion {
        return hdao.crearRegistro(hdto, conexion);
    }

    /**
     * metodo para listar historial
     * @return
     * @throws MiExcepcion 
     */
    public List<Object> listarHistorial() throws MiExcepcion {
        ArrayList<Object> historial = hdao.listarTodo(conexion);
        return historial;
    }
}
