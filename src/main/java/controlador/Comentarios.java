/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Factory.FactoryDTO;
import facade.FachadaPreguntas;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utilidades.MiExcepcion;
import utilidades.Utilities;

/**
 *
 * @author Nico
 */
@WebServlet(name = "Comentarios", urlPatterns = {"/Comentarios"})
public class Comentarios extends HttpServlet {

    FachadaPreguntas facadePR;
    FactoryDTO dtoFactory;
    public static int idComment;

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
            dtoFactory = new FactoryDTO();
            nuevoComentario(request, response);
        } catch (MiExcepcion ex) {
            response.sendRedirect("Consultar?msg=" + ex.getMessage());
        }
    }

    public void nuevoComentario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("sendComent") != null) {
            String respuesta = facadePR.insertarComentario(dtoFactory.crearComentario(request.getParameter("coment"), request.getParameter("name"), request.getParameter("mail"), Integer.parseInt(request.getParameter("idPR")), String.valueOf(Utilities.getFechaActual())));
            response.sendRedirect("Consultar?msg=" + respuesta);
        } else {
            aprobarComentario(request, response);
        }
    }

    public void aprobarComentario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("approve") != null) {
            String id = request.getParameter("approve");
            facadePR.cambiarEstadoComentario(id, 1);
            facadePR.insertarHistorial(dtoFactory.crearHistorial(request.getParameter("user"), "aprobó el comentario: " + request.getParameter("comentario"), String.valueOf(new Date())));
            response.sendRedirect("PreguntasRespuestas?commentsId=" + idComment);
        } else {
            desaprobarComentario(request, response);
        }
    }

    public void desaprobarComentario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("disapprove") != null) {
            String id = request.getParameter("disapprove");
            facadePR.cambiarEstadoComentario(id, 0);
            facadePR.insertarHistorial(dtoFactory.crearHistorial(request.getParameter("user"), "desaprobó el comentario: " + request.getParameter("comentario"), String.valueOf(new Date())));
            response.sendRedirect("PreguntasRespuestas?commentsId=" + idComment);
        } else {
            response.sendRedirect("Consultar");
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
