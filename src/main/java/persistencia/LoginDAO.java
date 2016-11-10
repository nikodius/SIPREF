/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.LoginDTO;
import utilidades.Conexion;

/**
 *
 * @author Jairo Medina 2016-10-24
 */
public class LoginDAO {
    PreparedStatement statement = null;
    ResultSet rs = null;
    String mensaje = "";

    public LoginDTO Login(LoginDTO validaUsu, Connection conexion) throws SQLException {
        LoginDTO user = new LoginDTO();
        try {
            String query = "SELECT * from directorioactivo where nombreUsuario=? AND ContraseniaUsuario=?;";
            statement = conexion.prepareStatement(query);
            statement.setString(1, validaUsu.getNombreUsuario());
            statement.setString(2, validaUsu.getContraseniaUsuario());

            rs = statement.executeQuery();

            if (rs.next()) {
                user.setIdUsuario(rs.getInt("idUsuario"));
                user.setNombreUsuario(rs.getString("nombreUsuario"));
                user.setContraseniaUsuario(rs.getString("contraseniaUsuario"));
                user.setIdRol(rs.getInt("idRol"));
                user.setValido(true);
            } else {
                user.setValido(false);
            }
        } catch (SQLException sqle) {
            System.out.println("ERROR: "+sqle.getMessage());
        }
        return user;
    }
}
