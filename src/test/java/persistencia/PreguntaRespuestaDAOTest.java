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
 * @author Nico
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
     * Test of detallesPreguntaRespuesta method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testDetallesPreguntaRespuesta() throws Exception {
        System.out.println("detallesPreguntaRespuesta");
        Connection conexion = null;
        int id = 0;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        PreguntaRespuestaDTO expResult = null;
        PreguntaRespuestaDTO result = instance.detallesPreguntaRespuesta(conexion, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarTodo method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testListarTodo() throws Exception {
        System.out.println("listarTodo");
        Connection conexion = null;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        ArrayList<PreguntaRespuestaDTO> expResult = null;
        ArrayList<PreguntaRespuestaDTO> result = instance.listarTodo(conexion);
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
     * Test of crearRegistro method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testCrearRegistro() {
        System.out.println("crearRegistro");
        PreguntaRespuestaDTO prDto = null;
        Connection conexion = null;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        String expResult = "";
        String result = instance.crearRegistro(prDto, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstadoPregunta method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testCambiarEstadoPregunta() {
        System.out.println("cambiarEstadoPregunta");
        String id = "";
        Connection conexion = null;
        int estado = 0;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        String expResult = "";
        String result = instance.cambiarEstadoPregunta(id, conexion, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarPreguntaRespuesta method, of class PreguntaRespuestaDAO.
     */
    @Test
    public void testEditarPreguntaRespuesta() {
        System.out.println("editarPreguntaRespuesta");
        Connection conexion = null;
        PreguntaRespuestaDTO pr = null;
        int id = 0;
        PreguntaRespuestaDAO instance = new PreguntaRespuestaDAO();
        String expResult = "";
        String result = instance.editarPreguntaRespuesta(conexion, pr, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
