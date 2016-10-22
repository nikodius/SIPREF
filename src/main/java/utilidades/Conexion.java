/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
     private static Connection conexion = null;

    private static void conectar() throws MiExcepcion {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sipref", "auto", "admin123");
        } catch (SQLException sqlException) {
            throw new MiExcepcion("Error al conectar a BD", sqlException);
        } catch (Exception exception) {
            throw new MiExcepcion("Error al conectar a BD", exception);
        }
    }
    //constructor
    private Conexion() {
    }
    //singleton
    public static Connection getInstance() throws MiExcepcion {
        if (conexion == null) {
            conectar();
        }
        return conexion;
    }
    
}
