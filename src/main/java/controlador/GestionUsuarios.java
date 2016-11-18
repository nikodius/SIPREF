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
import modelo.HistorialDTO;
import modelo.UsuarioDTO;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
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

    public void ListarUsuarios(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getQueryString() == null || request.getParameter("msg") != null) {
            ArrayList<UsuarioDTO> listaPreguntas = (ArrayList) facadeUser.listarUsuarios();
            request.setAttribute("listUsuarios", listaPreguntas);
            request.getRequestDispatcher("users.jsp").forward(request, response);
        } else {
            redireccionNewUser(request, response);
        }
    }

    public void redireccionNewUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, MiExcepcion {
        if (request.getParameter("add") != null) {
            request.getRequestDispatcher("newUser.jsp").forward(request, response);
        } else {
            nuevoUsuario(request, response);
        }
    }

    public void nuevoUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("new") != null) {
            UsuarioDTO objUsuarioDTO = dtoFactory.crearUsuario();
            objUsuarioDTO.setNombre(request.getParameter("nombresUsuario"));
            objUsuarioDTO.setApellido(request.getParameter("apellidosUsuario"));
            objUsuarioDTO.setTelefono(request.getParameter("telefonoUsuario"));
            objUsuarioDTO.setEmail(request.getParameter("correoUsuario"));
            objUsuarioDTO.setIdEstado(Integer.parseInt(request.getParameter("estadoUsuario")));
            objUsuarioDTO.setIdRol(Integer.parseInt(request.getParameter("rolUsuario")));
            objUsuarioDTO.setUser(request.getParameter("usuarioLogin"));
            String respuesta = facadeUser.insertarUsuario(objUsuarioDTO);
            //historial
            HistorialDTO hdto = new HistorialDTO(request.getParameter("user"), "creo nuevo Usuario: " + request.getParameter("usuarioLogin"), String.valueOf(new Date()));
            facadePR.insertarHistorial(hdto);
            response.sendRedirect("GestionUsuarios?msg=" + respuesta);
        } else {
            desactivarUsuario(request, response);
        }
    }
    
    public void desactivarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("desactivate") != null) {
            String id = request.getParameter("desactivate");
            facadeUser.cambiarEstadoUsuario(id, 2);
            response.sendRedirect("GestionUsuarios");
            HistorialDTO hdto = new HistorialDTO(request.getParameter("user"), "inactivó al usuario: " + request.getParameter("nameUser"), String.valueOf(new Date()));
            facadePR.insertarHistorial(hdto);
        } else {
            activarUsuario(request, response);
        }
    }

    public void activarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("active") != null) {
            String id = request.getParameter("active");
            facadeUser.cambiarEstadoUsuario(id, 1);
            response.sendRedirect("GestionUsuarios");
            HistorialDTO hdto = new HistorialDTO(request.getParameter("user"), "activo al usuario: " + request.getParameter("nameUser"), String.valueOf(new Date()));
            facadePR.insertarHistorial(hdto);
        } else {
            redirectEditarUsuario(request, response);
        }
    }
    
    public void redirectEditarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion, ServletException {
        if (request.getParameter("editId") != null) {
            int id = Integer.parseInt(request.getParameter("editId"));
            UsuarioDTO us = facadeUser.detallesUsuarioModificar(id);
            request.setAttribute("usuario", us);
            request.getRequestDispatcher("editUser.jsp").forward(request, response);
        } else {
            actualizarUsuario(request, response);
        }
    }
    
    public void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, MiExcepcion {
        String respuesta = "";
        if (request.getParameter("edit") != null) {
            UsuarioDTO objUsuarioDTO = dtoFactory.crearUsuario();
            objUsuarioDTO.setNombre(request.getParameter("nombresUsuario"));
            objUsuarioDTO.setApellido(request.getParameter("apellidosUsuario"));
            objUsuarioDTO.setTelefono(request.getParameter("telefonoUsuario"));
            objUsuarioDTO.setEmail(request.getParameter("correoUsuario"));
            objUsuarioDTO.setIdEstado(Integer.parseInt(request.getParameter("estadoUsuario")));
            objUsuarioDTO.setIdRol(Integer.parseInt(request.getParameter("rolUsuario")));
            objUsuarioDTO.setUser(request.getParameter("usuarioLogin"));
            respuesta = facadeUser.editarUsuario(objUsuarioDTO, Integer.parseInt(request.getParameter("id")));
            response.sendRedirect("GestionUsuarios?&msg=" + respuesta);
            HistorialDTO hdto = new HistorialDTO(request.getParameter("user"), "edito al usuario: " + request.getParameter("usuarioLogin"), String.valueOf(new Date()));
            facadePR.insertarHistorial(hdto);
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
