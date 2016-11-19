/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.util.ArrayList;
import modelo.HistorialDTO;
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
     * Test of listarHistorial method, of class HistorialDAO.
     */
    @org.junit.Test
    public void testListarHistorial() throws Exception {
        System.out.println("listarHistorial");
        Connection conexion = null;
        HistorialDAO instance = new HistorialDAO();
        ArrayList<HistorialDTO> expResult = null;
        ArrayList<HistorialDTO> result = instance.listarHistorial(conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearRegistro method, of class HistorialDAO.
     */
    @org.junit.Test
    public void testCrearRegistro() {
        System.out.println("crearRegistro");
        HistorialDTO historial = null;
        Connection conexion = null;
        HistorialDAO instance = new HistorialDAO();
        String expResult = "";
        String result = instance.crearRegistro(historial, conexion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
