/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Factory.FactoryDTO;
import facade.FachadaPreguntas;
import facade.FachadaUsuarios;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuarioDTO;
import utilidades.MiExcepcion;

/**
 * Controlador para gestionar usuarios 
 */
public class GestionUsuarios extends HttpServlet {

    FachadaUsuarios facadeUser;
    FachadaPreguntas facadePR;
    FactoryDTO dtoFactory;

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
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            facadeUser = new FachadaUsuarios();
            facadePR = new FachadaPreguntas();
            dtoFactory = new FactoryDTO();
            ListarUsuarios(request, response);
        } catch (MiExcepcion | UnsupportedEncodingException ex) {
            response.sendRedirect("GestionUsuarios?msg=" + ex.getMessage());
        }
    }

    /**
     * peticion listar usuarios
     * @param request
     * @param response
     * @throws IOException
     * @throws MiExcepcion
     * @throws ServletException 
     */
    public void ListarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getQueryString() == null || request.getParameter("msg") != null) {
            ArrayList<UsuarioDTO> listaPreguntas = (ArrayList) facadeUser.listarUsuarios();
            request.setAttribute("listUsuarios", listaPreguntas);
            request.getRequestDispatcher("users.jsp").forward(request, response);
        } else {
            redireccionNewUser(request, response);
        }
    }

    /**
     * peticion redireccion a nuevo usuario
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * @throws MiExcepcion 
     */
    public void redireccionNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, MiExcepcion {
        if (request.getParameter("add") != null) {
            request.getRequestDispatcher("newUser.jsp").forward(request, response);
        } else {
            nuevoUsuario(request, response);
        }
    }

    /**
     * peticion crear nuevo usuario
     * @param request
     * @param response
     * @throws IOException
     * @throws MiExcepcion
     * @throws ServletException 
     */
    public void nuevoUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("new") != null) {
            String respuesta = facadeUser.insertarUsuario(dtoFactory.crearUsuario(request.getParameter("nombresUsuario"), request.getParameter("apellidosUsuario"), request.getParameter("telefonoUsuario"), request.getParameter("correoUsuario"), Integer.parseInt(request.getParameter("estadoUsuario")), Integer.parseInt(request.getParameter("rolUsuario")), request.getParameter("usuarioLogin")));
            facadePR.insertarHistorial(dtoFactory.crearHistorial(request.getParameter("user"), "creo nuevo Usuario: " + request.getParameter("usuarioLogin"), String.valueOf(new Date())));
            response.sendRedirect("GestionUsuarios?msg=" + respuesta);
        } else {
            desactivarUsuario(request, response);
        }
    }

    /**
     * peticion desactivar un usuario
     * @param request
     * @param response
     * @throws IOException
     * @throws MiExcepcion
     * @throws ServletException 
     */
    public void desactivarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("desactivate") != null) {
            String id = request.getParameter("desactivate");
            facadeUser.cambiarEstadoUsuario(id, 2);
            facadePR.insertarHistorial(dtoFactory.crearHistorial(request.getParameter("user"), "inactivó al usuario: " + request.getParameter("nameUser"), String.valueOf(new Date())));
            response.sendRedirect("GestionUsuarios");
        } else {
            activarUsuario(request, response);
        }
    }

    /**
     * peticion acticar un usuario
     * @param request
     * @param response
     * @throws IOException
     * @throws MiExcepcion
     * @throws ServletException 
     */
    public void activarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("active") != null) {
            String id = request.getParameter("active");
            facadeUser.cambiarEstadoUsuario(id, 1);
            facadePR.insertarHistorial(dtoFactory.crearHistorial(request.getParameter("user"), "activo al usuario: " + request.getParameter("nameUser"), String.valueOf(new Date())));
            response.sendRedirect("GestionUsuarios");
        } else {
            redirectEditarUsuario(request, response);
        }
    }

    /**
     * peticion redireccionar editar usuario
     * @param request
     * @param response
     * @throws IOException
     * @throws MiExcepcion
     * @throws ServletException 
     */
    public void redirectEditarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("editId") != null) {
            int id = Integer.parseInt(request.getParameter("editId"));
            Object us = facadeUser.detallesUsuarioModificar(id);
            request.setAttribute("usuario", us);
            request.getRequestDispatcher("editUser.jsp").forward(request, response);
        } else {
            actualizarUsuario(request, response);
        }
    }

    /**
     * peticion para actualizar un usuario
     * @param request
     * @param response
     * @throws IOException
     * @throws MiExcepcion 
     */
    public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion {
        String respuesta = "";
        if (request.getParameter("edit") != null) {
            respuesta = facadeUser.editarUsuario(dtoFactory.crearUsuario(request.getParameter("nombresUsuario"), request.getParameter("apellidosUsuario"), request.getParameter("telefonoUsuario"), request.getParameter("correoUsuario"), Integer.parseInt(request.getParameter("estadoUsuario")), Integer.parseInt(request.getParameter("rolUsuario")), request.getParameter("usuarioLogin")), Integer.parseInt(request.getParameter("id")));
            facadePR.insertarHistorial(dtoFactory.crearHistorial(request.getParameter("user"), "edito al usuario: " + request.getParameter("usuarioLogin"), String.valueOf(new Date())));
            response.sendRedirect("GestionUsuarios?&msg=" + respuesta);
        } else {
            response.sendRedirect("GestionUsuarios");
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
