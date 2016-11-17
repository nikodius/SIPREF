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
    if (sesion.getAttribute("user") == null) {
        response.sendRedirect("GestionLogin");
    } else {
        usuario = (UsuarioDTO) sesion.getAttribute("user");
    }
%>
<div class="cajaPrincipal">
     <div align="left"><a href="PreguntasRespuestas"><img src="images/back.png" alt="back"/></a></div>
    <form  method="post" action="PreguntasRespuestas?new">
        <input type="hidden" id="idUser" name="idUser" value="<%=usuario.getId()%>">
        <input type="hidden" id="user" name="user" value="<%=usuario.getUser()%>">
        <div class="form-group">
            <label for="inputQuestion">Pregunta</label>
            <input type="text" class="form-control" id="inputQuestion" maxlength="200" name="inputQuestion" required>
        </div>
        <div class="form-group">
            <label for="inputAnswer">Respuesta</label>
            <input type="text" class="form-control" id="inputAnswer" name="inputAnswer" maxlength="250" required>
        </div>
        <div class="form-group">
            <label for="inputInicio">Inicio Vigencia</label>
            <input type="date" class="form-control" id="inputInicio" name="inputInicio" required>
        </div>
        <div class="form-group">
            <label for="inputFin">Fin Vigencia</label>
            <input type="date" class="form-control" id="inputFin" name="inputFin" required>
        </div>
        <input class="btn btn-primary" type="submit" name="new" id="new" value="Crear"/>
    </form>
</div>

<jsp:include page="_footer.jsp" />
