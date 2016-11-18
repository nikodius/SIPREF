<%-- 
    Document   : createFAQ
    Created on : 21/10/2016, 12:10:48 PM
    Author     : Niko
--%>

<%@page import="modelo.UsuarioDTO"%>
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
<div class="cajaPrincipal">
    <div align="left"><a href="GestionUsuarios"><img src="images/back.png" alt="back"/></a></div>
    <form  method="post" action="GestionUsuarios?new">
        <input type="hidden" id="idUser" name="idUser" value="<%=usuario.getId()%>">
        <input type="hidden" id="user" name="user" value="<%=usuario.getUser()%>">
        <div class="row">
            <div class="form-group">
                <label for="nombresUsuario" class="col-lg-1 control-label" >Nombres</label>
                <div class="col-lg-5">
                    <input type="text" class="form-control" id="nombresUsuario" name="nombresUsuario" placeholder="Nombres Usuario" tabindex="1" required>
                </div>
            </div>
            <div class="form-group">
                <label for="apellidosUsuario" class="col-lg-1 control-label">Apellidos</label>
                <div class="col-lg-5">
                    <input type="text" class="form-control" id="apellidosUsuario" name="apellidosUsuario" placeholder="Apellidos Usuario" tabindex="2" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="telefonoUsuario" class="col-lg-1 control-label">Telefono</label>
                <div class="col-lg-5">
                    <input type="text" class="form-control" id="telefonoUsuario" name="telefonoUsuario" placeholder="Telefono Usuario" tabindex="3" required>
                </div>
            </div>
            <div class="form-group">
                <label for="correoUsuario" class="col-lg-1 control-label">Correo Electronico</label>
                <div class="col-lg-5">
                    <input type="email" class="form-control" id="correoUsuario" name="correoUsuario" placeholder="Correo Electronico" tabindex="4" required>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="estadoUsuario" class="col-lg-1 control-label">Estado</label>
                <div class="col-lg-5">
                    <select class="form-control" id="estadoUsuario" name="estadoUsuario" tabindex="5" required>
                        <option value="1">Activo</option>
                        <option value="2">Inactivo</option>
                    </select>   
                </div>
            </div>
            <div class="form-group">
                <label for="rolUsuario" class="col-lg-1 control-label">Rol</label>
                <div class="col-lg-5">
                    <select class="form-control" id="rolUsuario" name="rolUsuario" tabindex="6" required="">
                        <option value="2">Autor</option>
                        <option value="1">Administrador</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label for="usuarioLogin" class="col-lg-1 control-label">Usuario Directorio Activo</label>
                <div class="col-lg-5">
                    <input type="text" class="form-control" id="usuarioLogin" name="usuarioLogin" placeholder="Usuario" tabindex="8" required="">
                </div>
            </div>
        </div><br>
        <div class="contenedor-botones">
            <button class="btn btn-primary" type="submit" name="enviar" value="Guardar" tabindex="9">Crear</button>
        </div>
    </form>
</div>

<jsp:include page="_footer.jsp" />
