package Factory;

import modelo.*;


/**
 * Interface Abstract factory operaciones
 * @author NiKo
 */
public interface Factory {
    
    PreguntaRespuestaDTO crearPreguntaRespuesta(String pregunta, String respuesta, String inicio, String fin, String fecha, int idUser);
    PreguntaRespuestaDTO crearPreguntaRespuesta(String pregunta, String respuesta, String inicio, String fin); 
    HistorialDTO crearHistorial(String usuario, String accion, String fecha); 
    LoginDTO crearLogin(String user, String pass); 
    ComentarioDTO crearComentario(String contenido, String nombre, String email, int idPregunta, String fecha); 
    UsuarioDTO crearUsuario(String nombre, String apellido, String telefono, String email, int idEstado, int idRol, String user); 
}
