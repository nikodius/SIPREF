/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author NicolasRG
 */
public class PreguntaRespuestaDTO {
    
    private int id;
    private String pregunta;
    private String respuesta;
    private String fecha;
    private String inicioVigencia;
    private String finVigencia;
    private int idUsuario;
    private int idFacultad; 
    private String estado;
    private ArrayList<DiscucionPreguntaRespuestaDTO> discuciones;

    public PreguntaRespuestaDTO(){
        
    }
    
    public PreguntaRespuestaDTO(int id, String pregunta, String respuesta, String fecha, String inicioVigencia, String finVigencia, int idUsuario, int idFacultad, String estado, ArrayList<DiscucionPreguntaRespuestaDTO> discuciones) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.fecha = fecha;
        this.inicioVigencia = inicioVigencia;
        this.finVigencia = finVigencia;
        this.idUsuario = idUsuario;
        this.idFacultad = idFacultad;
        this.estado = estado;
        this.discuciones = discuciones;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(String inicioVigencia) {
        this.inicioVigencia = inicioVigencia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(String finVigencia) {
        this.finVigencia = finVigencia;
    }

    public ArrayList<DiscucionPreguntaRespuestaDTO> getDiscuciones() {
        return discuciones;
    }

    public void setDiscuciones(ArrayList<DiscucionPreguntaRespuestaDTO> discuciones) {
        this.discuciones = discuciones;
    }
    
    
    
}