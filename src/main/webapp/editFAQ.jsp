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
    if (sesion.getAttribute("user") == null) {
        response.sendRedirect("GestionLogin");
    } else {
        usuario = (UsuarioDTO) sesion.getAttribute("user");
    }
%>
<%if (request.getAttribute("preguntaRespuesta") != null) {
        PreguntaRespuestaDTO pr = (PreguntaRespuestaDTO) request.getAttribute("preguntaRespuesta");
%>

<div class="cajaPrincipal">
    <div align="left"><a href="PreguntasRespuestas"><img src="images/back.png" alt="back"/></a></div>
    <form  method="post" action="PreguntasRespuestas?edit">
        <input type="hidden" name="idPr" id="idPr" value="<%=pr.getId()%>">
        <input type="hidden" id="user" name="user" value="<%=usuario.getUser()%>">
        <div class="form-group">
            <label for="inputQuestion">Pregunta</label>
            <input type="text" class="form-control" id="inputQuestion" name="inputQuestion" value="<%=pr.getPregunta()%>" required>
        </div>
        <div class="form-group">
            <label for="inputAnswer">Respuesta</label>
            <input type="text" class="form-control" id="inputAnswer" name="inputAnswer" value="<%=pr.getRespuesta()%>" required>
        </div>
        <div class="form-group">
            <label for="inputInicio">Inicio Vigencia</label>
            <input type="date" class="form-control" id="inputInicio" name="inputInicio" value="<%=pr.getInicioVigencia()%>">
        </div>
        <div class="form-group">
            <label for="inputFin">Fin Vigencia</label>
            <input type="date" class="form-control" id="inputFin" name="inputFin" value="<%=pr.getFinVigencia()%>">
        </div>
        <input class="btn btn-primary" type="submit" name="edit" id="edit" value="Actualizar"/>
    </form>
        <%}%>
</div>

<jsp:include page="_footer.jsp" />
