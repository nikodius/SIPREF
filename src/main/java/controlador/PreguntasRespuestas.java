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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            facadePR = new FachadaPreguntas();
            try (PrintWriter out = response.getWriter()) {
                if (request.getParameter("view") != null) {
                    ListarPreguntas(request, response);
                } else if (request.getParameter("add") != null) {
                    request.getRequestDispatcher("newFAQ.jsp").forward(request, response);
                } else if (request.getParameter("new") != null) {
                    nuevaPregunta(request, response);
                } else if (request.getParameter("deactivate") != null) {
                    desactivarPregunta(request, response);
                } else if (request.getParameter("approve") != null) {
                    aprobarPregunta(request, response);
                } else if (request.getParameter("disapprove") != null) {
                    desaprobarPregunta(request, response);
                } else if (request.getParameter("active") != null) {
                    activarPregunta(request, response);
                } else if (request.getParameter("editId") != null) {
                    redirectEditarPregunta(request, response);
                } else if (request.getParameter("edit") != null) {
                    actualizarPregunta(request, response);
                } 
            }
        } catch (MiExcepcion ex) {
            response.sendRedirect("index.jsp?er=" + ex.getMessage());
        }
    }

    public void ListarPreguntas(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ArrayList<PreguntaRespuestaDTO> listaPreguntas = (ArrayList)facadePR.listarPreguntas();
            request.setAttribute("listPreguntas", listaPreguntas);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("index.jsp?er=" + ex.getMessage());
        }
    }
       
    public void nuevaPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
//            PreguntaRespuestaDTO dto = dtoFactory.crearPreguntaRespuesta();
            PreguntaRespuestaDTO dto = new PreguntaRespuestaDTO();
            dto.setPregunta(request.getParameter("inputQuestion"));
            dto.setRespuesta(request.getParameter("inputAnswer"));
            dto.setInicioVigencia(request.getParameter("inputInicio"));
            dto.setFinVigencia(request.getParameter("inputFin"));
            dto.setFecha(String.valueOf(Utilities.getFechaActual()));
            String respuesta = facadePR.insertarRespuesta(dto);
            response.sendRedirect("PreguntasRespuestas?view&msg="+respuesta);
        } catch (MiExcepcion ex) {
            Logger.getLogger(PreguntasRespuestas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desactivarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String respuesta = "";
        try {
            String id = request.getParameter("deactivate");
            respuesta = facadePR.cambiarEstadoPreguntaRespuesta(id, 3);
        } catch (MiExcepcion ex) {
            respuesta = "error: " + ex.getMessage();
        }
        response.sendRedirect("PreguntasRespuestas?view");
    }
    
    public void activarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String respuesta = "";
        try {
            String id = request.getParameter("active");
            respuesta = facadePR.cambiarEstadoPreguntaRespuesta(id, 1);
        } catch (MiExcepcion ex) {
            respuesta = "error: " + ex.getMessage();
        }
        response.sendRedirect("PreguntasRespuestas?view");
    }
    
    public void aprobarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String respuesta = "";
        try {
            String id = request.getParameter("approve");
            respuesta = facadePR.cambiarEstadoPreguntaRespuesta(id, 2);
        } catch (MiExcepcion ex) {
            respuesta = "error: " + ex.getMessage();
        }
        response.sendRedirect("PreguntasRespuestas?view");
    }
    
    public void desaprobarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String respuesta = "";
        try {
            String id = request.getParameter("disapprove");
            respuesta = facadePR.cambiarEstadoPreguntaRespuesta(id, 1);
        } catch (MiExcepcion ex) {
            respuesta = "error: " + ex.getMessage();
        }
        response.sendRedirect("PreguntasRespuestas?view");
    }
    
    public void redirectEditarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("editId"));
            PreguntaRespuestaDTO pr = facadePR.detallesPreguntaRespuesta(id);
            request.setAttribute("preguntaRespuesta", pr);
            request.getRequestDispatcher("editFAQ.jsp").forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("index.jsp?er=" + ex.getMessage());
        }
    }
    
    public void actualizarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String respuesta = "";
        try {
            PreguntaRespuestaDTO pr = new PreguntaRespuestaDTO(request.getParameter("inputQuestion"),request.getParameter("inputAnswer"),request.getParameter("inputInicio"),request.getParameter("inputFin"));
            respuesta = facadePR.editarPreguntaRespuesta(pr, Integer.parseInt(request.getParameter("idPr")));
        } catch (Exception ex) {
            respuesta = "error, no se pudo actualizar";
        }
        response.sendRedirect("PreguntasRespuestas?view&msg="+respuesta);
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
