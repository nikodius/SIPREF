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
public class ComentariosDAOTest {
    
    public ComentariosDAOTest() {
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
     * Test of listarTodosFiltro method, of class ComentariosDAO.
     */
    @Test
    public void testListarTodosFiltro() throws Exception {
        System.out.println("listarTodosFiltro");
        Connection conexion = null;
        int id = 0;
        ComentariosDAO instance = new ComentariosDAO();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.listarTodosFiltro(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearRegistro method, of class ComentariosDAO.
     */
    @Test
    public void testCrearRegistro() {
        System.out.println("crearRegistro");
        Object dto = null;
        Connection conexion = null;
        ComentariosDAO instance = new ComentariosDAO();
        String expResult = "";
        String result = instance.crearRegistro(dto, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class ComentariosDAO.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        Connection conexion = null;
        Object dto = null;
        int id = 0;
        ComentariosDAO instance = new ComentariosDAO();
        String expResult = "";
        String result = instance.editar(conexion, dto, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstado method, of class ComentariosDAO.
     */
    @Test
    public void testCambiarEstado() {
        System.out.println("cambiarEstado");
        String id = "";
        Connection conexion = null;
        int estado = 0;
        ComentariosDAO instance = new ComentariosDAO();
        String expResult = "";
        String result = instance.cambiarEstado(id, conexion, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodo method, of class ComentariosDAO.
     */
    @Test
    public void testListarTodo() {
        System.out.println("listarTodo");
        Connection conexion = null;
        ComentariosDAO instance = new ComentariosDAO();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.listarTodo(conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarUno method, of class ComentariosDAO.
     */
    @Test
    public void testSeleccionarUno() {
        System.out.println("seleccionarUno");
        Connection conexion = null;
        int id = 0;
        ComentariosDAO instance = new ComentariosDAO();
        Object expResult = null;
        Object result = instance.seleccionarUno(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
