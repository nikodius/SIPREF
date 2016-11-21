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
 * @author UserQV
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
     * Test of listarTodo method, of class UsuarioDAO.
     */
    @Test
    public void testListarTodo() throws Exception {
        System.out.println("listarTodo");
        Connection conexion = null;
        UsuarioDAO instance = new UsuarioDAO();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.listarTodo(conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarUno method, of class UsuarioDAO.
     */
    @Test
    public void testSeleccionarUno() throws Exception {
        System.out.println("seleccionarUno");
        Connection conexion = null;
        int id = 0;
        UsuarioDAO instance = new UsuarioDAO();
        Object expResult = null;
        Object result = instance.seleccionarUno(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearRegistro method, of class UsuarioDAO.
     */
    @Test
    public void testCrearRegistro() throws Exception {
        System.out.println("crearRegistro");
        Object dto = null;
        Connection conexion = null;
        UsuarioDAO instance = new UsuarioDAO();
        String expResult = "";
        String result = instance.crearRegistro(dto, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class UsuarioDAO.
     */
    @Test
    public void testEditar() throws Exception {
        System.out.println("editar");
        Connection conexion = null;
        Object dto = null;
        int id = 0;
        UsuarioDAO instance = new UsuarioDAO();
        String expResult = "";
        String result = instance.editar(conexion, dto, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstado method, of class UsuarioDAO.
     */
    @Test
    public void testCambiarEstado() throws Exception {
        System.out.println("cambiarEstado");
        String id = "";
        Connection conexion = null;
        int estado = 0;
        UsuarioDAO instance = new UsuarioDAO();
        String expResult = "";
        String result = instance.cambiarEstado(id, conexion, estado);
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
     * Test of listarTodosFiltro method, of class UsuarioDAO.
     */
    @Test
    public void testListarTodosFiltro() throws Exception {
        System.out.println("listarTodosFiltro");
        Connection conexion = null;
        int id = 0;
        UsuarioDAO instance = new UsuarioDAO();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.listarTodosFiltro(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
