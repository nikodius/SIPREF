/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.ComentarioDTO;
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
     * Test of listarComentarios method, of class ComentariosDAO.
     */
    @Test
    public void testListarComentarios() throws Exception {
        System.out.println("listarComentarios");
        Connection conexion = null;
        int id = 0;
        ComentariosDAO instance = new ComentariosDAO();
        ArrayList<ComentarioDTO> expResult = null;
        ArrayList<ComentarioDTO> result = instance.listarComentarios(conexion, id);
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
        ComentarioDTO comentario = null;
        Connection conexion = null;
        ComentariosDAO instance = new ComentariosDAO();
        String expResult = "";
        String result = instance.crearRegistro(comentario, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarRegistro method, of class ComentariosDAO.
     */
    @Test
    public void testEliminarRegistro() {
        System.out.println("eliminarRegistro");
        String id = "";
        Connection conexion = null;
        ComentariosDAO instance = new ComentariosDAO();
        String expResult = "";
        String result = instance.eliminarRegistro(id, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambiarEstadoComentario method, of class ComentariosDAO.
     */
    @Test
    public void testCambiarEstadoComentario() {
        System.out.println("cambiarEstadoComentario");
        String id = "";
        Connection conexion = null;
        int estado = 0;
        ComentariosDAO instance = new ComentariosDAO();
        String expResult = "";
        String result = instance.cambiarEstadoComentario(id, conexion, estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
