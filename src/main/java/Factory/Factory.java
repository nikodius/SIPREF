package Factory;

import modelo.*;


/**
 * Interface Abstract factory operaciones
 * @author NiKo
 */
public interface Factory {
    
    PreguntaRespuestaDTO crearPreguntaRespuesta(); 
    HistorialDTO crearHistorial(); 
    LoginDTO crearLogin(); 
    ComentarioDTO crearComentario(); 
    UsuarioDTO crearUsuario(); 
}
