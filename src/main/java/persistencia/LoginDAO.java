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
        LoginDTO unUsuarioNew = new LoginDTO();
        boolean existeUsuario = false;

        try {
            String query = "SELECT * from directorioactivo where nombreUsuario=? AND ContraseniaUsuario=?;";
            statement = conexion.prepareStatement(query);
            statement.setString(1, validaUsu.getNombreUsuario());
            statement.setString(2, validaUsu.getContraseniaUsuario());

            rs = statement.executeQuery();

            if (rs.next()) {
                unUsuarioNew.setIdUsuario(rs.getInt("idUsuario"));
                unUsuarioNew.setNombreUsuario(rs.getString("nombreUsuario"));
                unUsuarioNew.setContraseniaUsuario(rs.getString("contraseniaUsuario"));
                unUsuarioNew.setIdRol(rs.getInt("idRol"));
            } else {
                unUsuarioNew.setNombreUsuario("No en contrado");
            }
        } catch (SQLException sqle) {
            System.out.println("ERROR: "+sqle.getMessage());
        }
        return unUsuarioNew;
    }
}
