package Factory;

import modelo.*;

/**
 * Implementacion AbstractFactory operaciones
 *
 * @author NiKo
 */
public class FactoryDTO implements Factory {

    @Override
    public PreguntaRespuestaDTO crearPreguntaRespuesta() {
        return new PreguntaRespuestaDTO();
    }

    @Override
    public HistorialDTO crearHistorial() {
        return new HistorialDTO();
    }

    @Override
    public LoginDTO crearLogin() {
        return new LoginDTO();
    }

    @Override
    public ComentarioDTO crearComentario() {
        return new ComentarioDTO();
    }

    @Override
    public UsuarioDTO crearUsuario() {
        return new UsuarioDTO();
    }

   

}
