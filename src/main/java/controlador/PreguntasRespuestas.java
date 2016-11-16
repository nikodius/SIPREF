/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Factory.DTOFactory;
import facade.FachadaPreguntas;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ComentarioDTO;
import modelo.PreguntaRespuestaDTO;
import utilidades.MiExcepcion;
import utilidades.Utilities;

/**
 *
 * @author UserQV
 */
public class PreguntasRespuestas extends HttpServlet {

    FachadaPreguntas facadePR;
    DTOFactory dtoFactory;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            facadePR = new FachadaPreguntas();
            ListarPreguntas(request, response);
        } catch (MiExcepcion | UnsupportedEncodingException | ServletException ex) {
            response.sendRedirect("PreguntasRespuestas?msg=" + ex.getMessage());
        }
    }

    public void ListarPreguntas(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getQueryString() == null || request.getParameter("msg") != null) {
            ArrayList<PreguntaRespuestaDTO> listaPreguntas = (ArrayList) facadePR.listarPreguntas();
            request.setAttribute("listPreguntas", listaPreguntas);
            request.getRequestDispatcher("preguntasRespuestas.jsp").forward(request, response);
        } else {
            redireccionNuevaFAQ(request, response);
        }
    }

    public void redireccionNuevaFAQ(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, MiExcepcion {
        if (request.getParameter("add") != null) {
            request.getRequestDispatcher("newFAQ.jsp").forward(request, response);
        } else {
            nuevaPregunta(request, response);
        }
    }

    public void nuevaPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("new") != null) {
            PreguntaRespuestaDTO dto = new PreguntaRespuestaDTO();
            dto.setPregunta(request.getParameter("inputQuestion"));
            dto.setRespuesta(request.getParameter("inputAnswer"));
            dto.setInicioVigencia(request.getParameter("inputInicio"));
            dto.setFinVigencia(request.getParameter("inputFin"));
            dto.setFecha(String.valueOf(Utilities.getFechaActual()));
            dto.setIdUsuario(Integer.parseInt(request.getParameter("idUser")));
            String respuesta = facadePR.insertarRespuesta(dto);
            response.sendRedirect("PreguntasRespuestas?msg=" + respuesta);
        } else {
            desactivarPregunta(request, response);
        }
    }

    public void desactivarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("deactivate") != null) {
            String id = request.getParameter("deactivate");
            facadePR.cambiarEstadoPreguntaRespuesta(id, 3);
            response.sendRedirect("PreguntasRespuestas");
        } else {
            activarPregunta(request, response);
        }
    }

    public void activarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("active") != null) {
            String id = request.getParameter("active");
            facadePR.cambiarEstadoPreguntaRespuesta(id, 1);
            response.sendRedirect("PreguntasRespuestas");
        } else {
            aprobarPregunta(request, response);
        }
    }

    public void aprobarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("approve") != null) {
            String id = request.getParameter("approve");
            facadePR.cambiarEstadoPreguntaRespuesta(id, 2);
            response.sendRedirect("PreguntasRespuestas");
        } else {
            desaprobarPregunta(request, response);
        }
    }

    public void desaprobarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("disapprove") != null) {
            String id = request.getParameter("disapprove");
            facadePR.cambiarEstadoPreguntaRespuesta(id, 1);
            response.sendRedirect("PreguntasRespuestas");
        } else {
            redirectEditarPregunta(request, response);
        }
    }

    public void redirectEditarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("editId") != null) {
            int id = Integer.parseInt(request.getParameter("editId"));
            PreguntaRespuestaDTO pr = facadePR.detallesPreguntaRespuesta(id);
            request.setAttribute("preguntaRespuesta", pr);
            request.getRequestDispatcher("editFAQ.jsp").forward(request, response);
        } else {
            redirectComentariosPregunta(request, response);
        }
    }
    
    public void redirectComentariosPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("commentsId") != null) {
            int id = Integer.parseInt(request.getParameter("commentsId"));
            Comentarios.idComment = id;
            List<ComentarioDTO> comentarios = facadePR.listarComentarios(id);
            request.setAttribute("listaComentarios", comentarios);
            request.getRequestDispatcher("comments.jsp").forward(request, response);
        } else {
            actualizarPregunta(request, response);
        }
    }

    public void actualizarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion {
        String respuesta = "";
        if (request.getParameter("edit") != null) {
            PreguntaRespuestaDTO pr = new PreguntaRespuestaDTO(request.getParameter("inputQuestion"), request.getParameter("inputAnswer"), request.getParameter("inputInicio"), request.getParameter("inputFin"));
            respuesta = facadePR.editarPreguntaRespuesta(pr, Integer.parseInt(request.getParameter("idPr")));
            response.sendRedirect("PreguntasRespuestas?&msg=" + respuesta);
        } else {
            response.sendRedirect("PreguntasRespuestas");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
