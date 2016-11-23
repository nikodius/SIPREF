package Factory;

import modelo.*;

/**
 * Implementacion factory DTO
 * usada por controladores, se encarga de crear objetos tipo DTO
 *
 */
public class FactoryDTO implements Factory {

    /**
     * metodo para crear PreguntasRespuestasDTO FAQ
     * @param pregunta
     * @param respuesta
     * @param inicio
     * @param fin
     * @param fecha
     * @param idUser
     * @return 
     */
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

    /**
     * metodo para crear PreguntasRespuestasDTO FAQ
     * @param pregunta
     * @param respuesta
     * @param inicio
     * @param fin
     * @return 
     */
    @Override
    public PreguntaRespuestaDTO crearPreguntaRespuesta(String pregunta, String respuesta, String inicio, String fin) {
        PreguntaRespuestaDTO pr = new PreguntaRespuestaDTO();
        pr.setPregunta(pregunta);
        pr.setRespuesta(respuesta);
        pr.setInicioVigencia(inicio);
        pr.setFinVigencia(fin);
        return pr;
    }

    /**
     * metodo para crear HistorialDTO
     * @param usuario
     * @param accion
     * @param fecha
     * @return 
     */
    @Override
    public HistorialDTO crearHistorial(String usuario, String accion, String fecha) {
        return new HistorialDTO(usuario, accion, fecha);
    }

    /**
     *  metodo para crear loginlDTO
     * @param user
     * @param pass
     * @return 
     */
    @Override
    public LoginDTO crearLogin(String user, String pass) {
        LoginDTO ldto = new LoginDTO();
        ldto.setNombreUsuario(user);
        ldto.setContraseniaUsuario(pass);
        return ldto;
    }

    /**
     *  metodo para crear ComentarioDTO
     * @param contenido
     * @param nombre
     * @param email
     * @param idPregunta
     * @param fecha
     * @return 
     */
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

    /**
     *  metodo para crear UsuarioDTO
     * @param nombre
     * @param apellido
     * @param telefono
     * @param email
     * @param idEstado
     * @param idRol
     * @param user
     * @return 
     */
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
