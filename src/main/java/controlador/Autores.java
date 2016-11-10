/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Factory.DTOFactory;
import facade.FachadaPreguntas;
import facade.FachadaUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioDTO;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public class Autores extends HttpServlet {

    FachadaUsuarios facadeU;
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
            facadeU = new FachadaUsuarios();
            listarAutores(request, response);
        } catch (MiExcepcion ex) {
            response.sendRedirect("Autor?msg=" + ex.getMessage());
        }
    }

    public void listarAutores(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getQueryString() == null || request.getParameter("msg") != null) {
            ArrayList<UsuarioDTO> listaAutores = (ArrayList) facadeU.listarAutores();
            request.setAttribute("listAutores", listaAutores);
            request.getRequestDispatcher("authorize.jsp").forward(request, response);
        } else {
            aprobarPregunta(request, response);
        }
    }

    public void aprobarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("approve") != null) {
            String id = request.getParameter("approve");
            facadeU.cambiarEstadoAprobarPregunta(id, 1);
            response.sendRedirect("Autores");
        } else {
            desaprobarPregunta(request, response);
        }
    }

    public void desaprobarPregunta(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("disapprove") != null) {
            String id = request.getParameter("disapprove");
            facadeU.cambiarEstadoAprobarPregunta(id, 0);
            response.sendRedirect("Autores");
        } else {
            response.sendRedirect("Autores");
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
