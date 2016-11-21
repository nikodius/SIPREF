/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utilidades.MiExcepcion;

/**
 *
 * @author UserQV
 */
public interface ModeloDAO {

    public ArrayList<Object> listarTodo(Connection conexion) throws MiExcepcion;
    
    public ArrayList<Object> listarTodosFiltro(Connection conexion, int id) throws MiExcepcion;

    public Object seleccionarUno(Connection conexion, int id) throws MiExcepcion;

    public String crearRegistro(Object dto, Connection conexion) throws MiExcepcion;
    
    public String editar(Connection conexion, Object dto, int id) throws MiExcepcion;
    
    public String cambiarEstado(String id, Connection conexion, int estado) throws MiExcepcion;

}
