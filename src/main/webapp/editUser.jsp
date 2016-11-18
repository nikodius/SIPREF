<%-- 
    Document   : editFAQ
    Created on : 4/11/2016, 12:10:06 PM
    Author     : Niko
--%>

<%@page import="modelo.UsuarioDTO"%>
<%@page import="facade.FachadaPreguntas"%>
<%@page import="modelo.PreguntaRespuestaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="_header.jsp" />
<% response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
    HttpSession sesion = request.getSession(false);
    UsuarioDTO usuario = new UsuarioDTO();
    if (sesion.getAttribute("user") != null) {
        usuario = (UsuarioDTO) sesion.getAttribute("user");
        if (usuario.getIdRol() != 1) {
            response.sendRedirect("PreguntasRespuestas");
        }
    } else {
        response.sendRedirect("GestionLogin");
    }
%>
<%if (request.getAttribute("usuario") != null) {
        UsuarioDTO usMod = (UsuarioDTO) request.getAttribute("usuario");
%>

<div class="cajaPrincipal">
    <div align="left"><a href="GestionUsuarios"><img src="images/back.png" alt="back"/></a></div>
    <form  method="post" action="GestionUsuarios?edit">
        <input type="hidden" name="id" id="id" value="<%=usMod.getId()%>">
        <input type="hidden" id="user" name="user" value="<%=usuario.getUser()%>">
        <div class="row">
            <div class="form-group">
                <label for="nombresUsuario" class="col-lg-1 control-label" >Nombres</label>
                <div class="col-lg-5">
                    <input type="text" class="form-control" id="nombresUsuario" name="nombresUsuario" placeholder="Nombres Usuario" tabindex="1" required
                           value="<%=usMod.getNombre()%>">
                </div>
            </div>
            <div class="form-group">
                <label for="apellidosUsuario" class="col-lg-1 control-label">Apellidos</label>
                <div class="col-lg-5">
                    <input type="text" class="form-control" id="apellidosUsuario" name="apellidosUsuario" placeholder="Apellidos Usuario" tabindex="2" required
                           value="<%=usMod.getApellido() %>">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="telefonoUsuario" class="col-lg-1 control-label">Telefono</label>
                <div class="col-lg-5">
                    <input type="text" class="form-control" id="telefonoUsuario" name="telefonoUsuario" placeholder="Telefono Usuario" tabindex="3" required
                           value="<%=usMod.getTelefono() %>">
                </div>
            </div>
            <div class="form-group">
                <label for="correoUsuario" class="col-lg-1 control-label">Correo Electronico</label>
                <div class="col-lg-5">
                    <input type="email" class="form-control" id="correoUsuario" name="correoUsuario" placeholder="Correo Electronico" tabindex="4" required
                           value="<%=usMod.getEmail() %>">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="estadoUsuario" class="col-lg-1 control-label">Estado</label>
                <div class="col-lg-5">
                    <select class="form-control" id="estadoUsuario" name="estadoUsuario" tabindex="5" required>
                        <option value="1" <% if(usMod.getIdEstado()==1){ %> selected <% } %>>Activo</option>
                        <option value="2" <% if(usMod.getIdEstado()==2){ %> selected <% } %>>Inactivo</option>
                    </select>   
                </div>
            </div>
            <div class="form-group">
                <label for="rolUsuario" class="col-lg-1 control-label">Rol</label>
                <div class="col-lg-5">
                    <select class="form-control" id="rolUsuario" name="rolUsuario" tabindex="6" required="">
                        <option value="2" <% if(usMod.getIdRol()==2){ %> selected <% } %>>Autor</option>
                        <option value="1" <% if(usMod.getIdRol()==1){ %> selected <% } %>>Administrador</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="usuarioLogin" class="col-lg-1 control-label">Usuario Directorio Activo</label>
                <div class="col-lg-5">
                    <input type="text" class="form-control" id="usuarioLogin" name="usuarioLogin" placeholder="Usuario" tabindex="8" required
                           value="<%=usMod.getUser() %>">
                </div>
            </div>
        </div><br>
        <%if(!usMod.getUser().equals("admin")){%>
        <div class="contenedor-botones">
            <button class="btn btn-primary" type="submit" name="enviar" value="Actualizar" tabindex="9">Actualizar</button>
        </div>
        <%}%>
    </form>
    <%}%>
</div>

<jsp:include page="_footer.jsp" />
