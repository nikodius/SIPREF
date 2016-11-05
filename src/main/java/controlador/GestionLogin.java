/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
import persistencia.LoginDAO;
import utilidades.Conexion;
import utilidades.MiExcepcion;
/**
 *
 * @author Nico
 */
public class GestionLogin extends HttpServlet {

    Connection conexion;
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
            LoginDTO objLoginDTO = new LoginDTO();
            LoginDAO objLoginDAO = new LoginDAO();
            HttpSession miSession = request.getSession();

            if (request.getParameter("enviar").equals("Ingresar")) {
                String usuario = request.getParameter("nombreUsuario");
                String contrasenia = request.getParameter("contraseniaUsuario");

                objLoginDTO.setNombreUsuario(usuario);
                objLoginDTO.setContraseniaUsuario(contrasenia);
                objLoginDTO = objLoginDAO.Login(objLoginDTO, conexion);
                //objLoginDTO = objLoginDAO.Login(objLoginDTO);
                System.out.println("NOMBRE: " + objLoginDTO.getNombreUsuario());

                if (objLoginDTO.getNombreUsuario().equals("No en contrado")) {
                    String mensaje = "1";
                    miSession.setAttribute("mensaje", mensaje);
                    response.sendRedirect("login.jsp");
                } else {
                    miSession.setAttribute("usuario", objLoginDTO);

                    /*if (objLoginDTO.getIdRol() == 10) {//Administrador
                        response.sendRedirect("Vistas/frmAdministrador.jsp");
                    } else if (objLoginDTO.getIdRol() == 20) {//Autor
                        response.sendRedirect("Vistas/frmAutor.jsp");
                    } */
                        response.sendRedirect("PreguntasRespuestas?view");
                    }
                    //De lo contrario vamos a la página errorLogin.jsp
            }
        } catch (MiExcepcion ex) {
            Logger.getLogger(GestionLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestionLogin.class.getName()).log(Level.SEVERE, null, ex);
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
