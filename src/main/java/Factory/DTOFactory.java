package Factory;

import modelo.PreguntaRespuestaDTO;

/**
 * Implementacion AbstractFactory operaciones
 *
 * @author NiKo
 */
public class DTOFactory implements Factory {

    @Override
    public PreguntaRespuestaDTO crearPreguntaRespuesta() {
        return new PreguntaRespuestaDTO();
    }

   

}
