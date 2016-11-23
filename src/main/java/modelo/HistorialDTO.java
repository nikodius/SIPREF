/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * clase modelo dto historial
 */
public class HistorialDTO {
    
    private int id;
    private String usuario;
    private String accion;
    private String fecha;

    public HistorialDTO(String usuario, String accion, String fecha) {
        this.usuario = usuario;
        this.accion = accion;
        this.fecha = fecha;
    }

    public HistorialDTO() {
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
