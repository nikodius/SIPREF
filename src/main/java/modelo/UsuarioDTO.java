/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 * clase modelo dto usuario
 */
public class UsuarioDTO {
    
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private int idEstado;
    private String estado;
    private int idRol;
    private String rol;
    private boolean aprobarPregunta;
    private String user;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String nombre, String apellido, String telefono, String email, int idEstado, int idRol, String user) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.idEstado = idEstado;
        this.idRol = idRol;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isAprobarPregunta() {
        return aprobarPregunta;
    }

    public void setAprobarPregunta(boolean aprobarPregunta) {
        this.aprobarPregunta = aprobarPregunta;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
}
