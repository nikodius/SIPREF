/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.PreguntaRespuestaDTO;
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
public class PreguntaRespuestaDAOTest {
    
    public PreguntaRespuestaDAOTest() {
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
     * Test of listarTodo method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testListarTodo() throws Exception {
        System.out.println("listarTodo");
        Connection conexion = null;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.listarTodo(conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seleccionarUno method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testSeleccionarUno() throws Exception {
        System.out.println("seleccionarUno");
        Connection conexion = null;
        int id = 0;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        Object expResult = null;
        Object result = instance.seleccionarUno(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearRegistro method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testCrearRegistro() throws Exception {
        System.out.println("crearRegistro");
        Object dto = null;
        Connection conexion = null;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        String expResult = "";
        String result = instance.crearRegistro(dto, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testEditar() throws Exception {
        System.out.println("editar");
        Connection conexion = null;
        Object dto = null;
        int id = 0;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        String expResult = "";
        String result = instance.editar(conexion, dto, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstado method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testCambiarEstado() throws Exception {
        System.out.println("cambiarEstado");
        String id = "";
        Connection conexion = null;
        int estado = 0;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        String expResult = "";
        String result = instance.cambiarEstado(id, conexion, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarParaConsultas method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testListarParaConsultas() throws Exception {
        System.out.println("listarParaConsultas");
        Connection conexion = null;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        ArrayList<PreguntaRespuestaDTO> expResult = null;
        ArrayList<PreguntaRespuestaDTO> result = instance.listarParaConsultas(conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodosFiltro method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testListarTodosFiltro() throws Exception {
        System.out.println("listarTodosFiltro");
        Connection conexion = null;
        int id = 0;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        ArrayList<Object> expResult = null;
        ArrayList<Object> result = instance.listarTodosFiltro(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
