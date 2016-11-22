/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

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
public class ActiveDirectoryTest {
    
    public ActiveDirectoryTest() {
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
     * Test of UserAuth method, of class ActiveDirectory.
     */
    @Test
    public void testUserAuth() throws Exception {
        System.out.println("UserAuth");
        String user = "";
        String psw = "";
        boolean expResult = false;
        boolean result = ActiveDirectory.UserAuth(user, psw);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
