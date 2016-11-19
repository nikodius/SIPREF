package Factory;

import modelo.*;

/**
 * Implementacion AbstractFactory operaciones
 *
 * @author NiKo
 */
public class FactoryDTO implements Factory {

    @Override
    public PreguntaRespuestaDTO crearPreguntaRespuesta(String pregunta, String respuesta, String inicio, String fin, String fecha, int idUser) {
        PreguntaRespuestaDTO pr = new PreguntaRespuestaDTO();
        pr.setPregunta(pregunta);
        pr.setRespuesta(respuesta);
        pr.setInicioVigencia(inicio);
        pr.setFinVigencia(fin);
        pr.setFecha(fecha);
        pr.setIdUsuario(idUser);
        return pr;
    }

    @Override
    public PreguntaRespuestaDTO crearPreguntaRespuesta(String pregunta, String respuesta, String inicio, String fin) {
        PreguntaRespuestaDTO pr = new PreguntaRespuestaDTO();
        pr.setPregunta(pregunta);
        pr.setRespuesta(respuesta);
        pr.setInicioVigencia(inicio);
        pr.setFinVigencia(fin);
        return pr;
    }

    @Override
    public HistorialDTO crearHistorial(String usuario, String accion, String fecha) {
        return new HistorialDTO(usuario, accion, fecha);
    }

    @Override
    public LoginDTO crearLogin(String user, String pass) {
        LoginDTO ldto = new LoginDTO();
        ldto.setNombreUsuario(user);
        ldto.setContraseniaUsuario(pass);
        return ldto;
    }

    @Override
    public ComentarioDTO crearComentario(String contenido, String nombre, String email, int idPregunta, String fecha) {
        ComentarioDTO coment = new ComentarioDTO();
        coment.setContenido(contenido);
        coment.setNombreComentarista(nombre);
        coment.setEmailComentarista(email);
        coment.setIdPreguntaRespuesta(idPregunta);
        coment.setFechaComentario(fecha);
        return coment;
    }

    @Override
    public UsuarioDTO crearUsuario(String nombre, String apellido, String telefono, String email, int idEstado, int idRol, String user) {
        UsuarioDTO objUsuarioDTO = new UsuarioDTO();
        objUsuarioDTO.setNombre(nombre);
        objUsuarioDTO.setApellido(apellido);
        objUsuarioDTO.setTelefono(telefono);
        objUsuarioDTO.setEmail(email);
        objUsuarioDTO.setIdEstado(idEstado);
        objUsuarioDTO.setIdRol(idRol);
        objUsuarioDTO.setUser(user);
        return objUsuarioDTO;
    }
}
