/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import facade.FachadaUsuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.LoginDTO;
import modelo.UsuarioDTO;
import persistencia.LoginDAO;
import utilidades.Conexion;
import utilidades.MiExcepcion;

/**
 *
 * @author Nico
 */
public class GestionLogin extends HttpServlet {

    Connection conexion;
    FachadaUsuarios facadeUser;

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
        request.setCharacterEncoding("UTF-8"); //Para que reconozca caracteres especiales y tildes
        try (PrintWriter out = response.getWriter()) {
            conexion = Conexion.getInstance();
            facadeUser = new FachadaUsuarios();
            redireccionLogin(request, response);
        } catch (MiExcepcion | SQLException ex) {
            response.sendRedirect("GestionLogin?msg=" + ex.getMessage());
        }
    }

    public void redireccionLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, MiExcepcion, SQLException {
        if (request.getQueryString() == null || request.getParameter("msg") != null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            login(request, response);
        }
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, MiExcepcion, SQLException {
        if (request.getParameter("enviar") != null) {
            LoginDTO objLoginDTO = new LoginDTO();
            LoginDAO objLoginDAO = new LoginDAO();
            String respuesta = "";
            String usuario = request.getParameter("nombreUsuario");
            String contrasenia = request.getParameter("contraseniaUsuario");
            objLoginDTO.setNombreUsuario(usuario);
            objLoginDTO.setContraseniaUsuario(contrasenia);
            objLoginDTO = objLoginDAO.Login(objLoginDTO, conexion);
            if (objLoginDTO.isValido()) {
                UsuarioDTO user = facadeUser.detallesUsuario(objLoginDTO.getNombreUsuario());
                //valida usuario activo
                if (user.getIdEstado() == 1) {
                    HttpSession sesion = request.getSession(true);
                    sesion.setAttribute("user", user);
                    //Autor
//                    if (user.getIdRol() == 2) {
//                        response.sendRedirect("PreguntasRespuestas");
//                    }
                    response.sendRedirect("PreguntasRespuestas");
                } else{
                    respuesta = "No se encontro el ususario en la aplicacion";
                    response.sendRedirect("GestionLogin?msg=" + respuesta);
                }
            } else {
                respuesta = "Datos de usuario incorrectos";
                response.sendRedirect("GestionLogin?msg=" + respuesta);
            }
            //De lo contrario vamos a la página errorLogin.jsp
        } else {
            logout(request, response);
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("logout") != null) {
            HttpSession sesion = request.getSession(false);
            sesion.invalidate();
            sesion = null;
            response.sendRedirect("index.jsp");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
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
