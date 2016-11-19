/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.UsuarioDTO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nico
 */
public class UsuarioDAOTest {
    
    public UsuarioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listarUsuarios method, of class UsuarioDAO.
     */
    @Test
    public void testListarUsuarios() throws Exception {
        System.out.println("listarUsuarios");
        Connection conexion = null;
        UsuarioDAO instance = new UsuarioDAO();
        ArrayList<UsuarioDTO> expResult = null;
        ArrayList<UsuarioDTO> result = instance.listarUsuarios(conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarAutores method, of class UsuarioDAO.
     */
    @Test
    public void testListarAutores() throws Exception {
        System.out.println("listarAutores");
        Connection conexion = null;
        UsuarioDAO instance = new UsuarioDAO();
        ArrayList<UsuarioDTO> expResult = null;
        ArrayList<UsuarioDTO> result = instance.listarAutores(conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detallesUsuarioModificar method, of class UsuarioDAO.
     */
    @Test
    public void testDetallesUsuarioModificar() throws Exception {
        System.out.println("detallesUsuarioModificar");
        Connection conexion = null;
        int id = 0;
        UsuarioDAO instance = new UsuarioDAO();
        UsuarioDTO expResult = null;
        UsuarioDTO result = instance.detallesUsuarioModificar(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testEditarUsuario() {
        System.out.println("editarUsuario");
        Connection conexion = null;
        UsuarioDTO user = null;
        int id = 0;
        UsuarioDAO instance = new UsuarioDAO();
        String expResult = "";
        String result = instance.editarUsuario(conexion, user, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstadoAprobacion method, of class UsuarioDAO.
     */
    @Test
    public void testCambiarEstadoAprobacion() {
        System.out.println("cambiarEstadoAprobacion");
        String id = "";
        Connection conexion = null;
        int estado = 0;
        UsuarioDAO instance = new UsuarioDAO();
        String expResult = "";
        String result = instance.cambiarEstadoAprobacion(id, conexion, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detallesUsuarioLogin method, of class UsuarioDAO.
     */
    @Test
    public void testDetallesUsuarioLogin() throws Exception {
        System.out.println("detallesUsuarioLogin");
        Connection conexion = null;
        String user = "";
        UsuarioDAO instance = new UsuarioDAO();
        UsuarioDTO expResult = null;
        UsuarioDTO result = instance.detallesUsuarioLogin(conexion, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of IngresarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testIngresarUsuario() {
        System.out.println("IngresarUsuario");
        UsuarioDTO IngUsu = null;
        Connection conexion = null;
        UsuarioDAO instance = new UsuarioDAO();
        String expResult = "";
        String result = instance.IngresarUsuario(IngUsu, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstadoUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testCambiarEstadoUsuario() {
        System.out.println("cambiarEstadoUsuario");
        String id = "";
        Connection conexion = null;
        int estado = 0;
        UsuarioDAO instance = new UsuarioDAO();
        String expResult = "";
        String result = instance.cambiarEstadoUsuario(id, conexion, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
