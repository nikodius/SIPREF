/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.util.ArrayList;
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
public class HistorialDAOTest {
    
    public HistorialDAOTest() {
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
     * Test of listarTodo method, of class HistorialDAO.
     */
    @Test
    public void testListarTodo() throws Exception {
        System.out.println("listarTodo");
        Connection conexion = null;
        HistorialDAO instance = new HistorialDAO();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.listarTodo(conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearRegistro method, of class HistorialDAO.
     */
    @Test
    public void testCrearRegistro() {
        System.out.println("crearRegistro");
        Object dto = null;
        Connection conexion = null;
        HistorialDAO instance = new HistorialDAO();
        String expResult = "";
        String result = instance.crearRegistro(dto, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class HistorialDAO.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        Connection conexion = null;
        Object dto = null;
        int id = 0;
        HistorialDAO instance = new HistorialDAO();
        String expResult = "";
        String result = instance.editar(conexion, dto, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstado method, of class HistorialDAO.
     */
    @Test
    public void testCambiarEstado() {
        System.out.println("cambiarEstado");
        String id = "";
        Connection conexion = null;
        int estado = 0;
        HistorialDAO instance = new HistorialDAO();
        String expResult = "";
        String result = instance.cambiarEstado(id, conexion, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodosFiltro method, of class HistorialDAO.
     */
    @Test
    public void testListarTodosFiltro() {
        System.out.println("listarTodosFiltro");
        Connection conexion = null;
        int id = 0;
        HistorialDAO instance = new HistorialDAO();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.listarTodosFiltro(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarUno method, of class HistorialDAO.
     */
    @Test
    public void testSeleccionarUno() {
        System.out.println("seleccionarUno");
        Connection conexion = null;
        int id = 0;
        HistorialDAO instance = new HistorialDAO();
        Object expResult = null;
        Object result = instance.seleccionarUno(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
