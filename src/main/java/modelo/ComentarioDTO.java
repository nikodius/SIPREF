/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;

/**
 *
 * @author UserQV
 */
public class ComentarioDTO {
    
    private int idComentario;
    private String contenido;
    private String fechaComentario;
    private String nombreComentarista;
    private String emailComentarista;
    private int idPadre;
    private int idPreguntaRespuesta;

    public ComentarioDTO() {
    }

    public ComentarioDTO(int idComentario, String contenido, String fechaComentario, String nombreComentarista, String emailComentarista, int idPadre, int idPreguntaRespuesta) {
        this.idComentario = idComentario;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
        this.nombreComentarista = nombreComentarista;
        this.emailComentarista = emailComentarista;
        this.idPadre = idPadre;
        this.idPreguntaRespuesta = idPreguntaRespuesta;
    }

    
    
    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(String fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public String getNombreComentarista() {
        return nombreComentarista;
    }

    public void setNombreComentarista(String nombreComentarista) {
        this.nombreComentarista = nombreComentarista;
    }

    public String getEmailComentarista() {
        return emailComentarista;
    }

    public void setEmailComentarista(String emailComentarista) {
        this.emailComentarista = emailComentarista;
    }

    public int getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(int idPadre) {
        this.idPadre = idPadre;
    }

    public int getIdPreguntaRespuesta() {
        return idPreguntaRespuesta;
    }

    public void setIdPreguntaRespuesta(int idPreguntaRespuesta) {
        this.idPreguntaRespuesta = idPreguntaRespuesta;
    }
    
    
    
}
