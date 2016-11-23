<%-- 
    Document   : index
    Created on : 18/10/2016, 09:07:59 AM
    Author     : NicolasRG
--%>

<%@page import="modelo.UsuarioDTO"%>
<%@page import="modelo.PreguntaRespuestaDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<script src="js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tablerPR').DataTable({
            language: {
                url: 'js/Spanish.json'
            }
        });
        $("#mensaje").fadeOut(7000);
    });
</script>
<div class="row cajaPrincipal">
    <% if (request.getParameter("msg") != null) { %>
    <div id="mensaje" align="center" class="alert alert-info"><%out.print(request.getParameter("msg"));%></div>
    <% }%>

    <% if (usuario.getIdRol() == 1) {%>
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="navbar-brand visible-xs">Menú</span>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul>
                <li><a class="active" href="PreguntasRespuestas">Preguntas Respuestas</a></li>
                <li><a href="Autores">Permiso Aprobación</a></li>
                <li><a href="GestionUsuarios">Usuarios</a></li>
                <li><a href="Historial">Historial Modificaciones</a></li>
            </ul>
        </div>
    </nav>
    <br/>
    <% } %>

    <%if (request.getAttribute("listPreguntas") != null) {
            List<PreguntaRespuestaDTO> lista = (ArrayList) request.getAttribute("listPreguntas");
    %>
    <div align="right"><a href="PreguntasRespuestas?add"><img src="images/add.png" id="imgEX" alt="Modificar Registro"/> Nueva Pregunta</a></div>
    <br/>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="tablerPR" >
        <thead>
            <tr>
                <th>Pregunta</th>
                <th>Respuesta</th>
                <th>Inicio Vigencia</th>
                <th>Fin Vigencia</th>
                <th>Estado</th>
                <th>Autor</th>
                <th>Editar</th>
                <th>Comentarios</th>
                    <% if (usuario.isAprobarPregunta()) { %>
                <th>Aprobar</th>
                    <% } %>
                    <% if (usuario.getIdRol() == 1) {%>
                <th>Publicar</th>
                    <% } %>
            </tr>
        </thead>
        <tbody> 
            <%
                for (PreguntaRespuestaDTO pdto : lista) {
            %>
            <tr>
                <td><%=pdto.getPregunta()%></td>
                <td><%=pdto.getRespuesta()%></td>
                <td><%=pdto.getInicioVigencia()%></td>
                <td><%=pdto.getFinVigencia()%></td>
                <td><%=pdto.getEstado()%></td>
                <td><%=pdto.getUsuario()%></td>
                <td>
                    <a href="PreguntasRespuestas?editId=<% out.print(pdto.getId());%>"><img src="images/edit.png" id="imgEX" alt="Modificar Registro"/></a>
                </td>
                <td>
                    <a href="PreguntasRespuestas?commentsId=<% out.print(pdto.getId());%>"><img src="images/comment.png" id="imgEX" alt="Modificar Registro"/> <% out.print(pdto.getComentarios().size());%></a>
                </td>

                <% if (usuario.isAprobarPregunta()) {
                        if (pdto.getCodigoEstado() == 1) {%>
                <td><a href="PreguntasRespuestas?approve=<% out.print(pdto.getId());%>&pregunta=<% out.print(pdto.getPregunta());%>&user=<% out.print(usuario.getUser());%>"><img src="images/approve.png" alt="approve"/></a></td>
                        <%} else if (pdto.getCodigoEstado() == 2) {%>
                <td><a href="PreguntasRespuestas?disapprove=<% out.print(pdto.getId());%>&pregunta=<% out.print(pdto.getPregunta());%>&user=<% out.print(usuario.getUser());%>"><img src="images/disapprove.png" alt="disapprove"/></a></td>
                        <%} else { %>
                <td></td>
                <%}
                    } %>

                <% if (usuario.getIdRol() == 1) {%>     
                <% if (pdto.getCodigoEstado() == 3) {%>
                <td><a href="PreguntasRespuestas?active=<% out.print(pdto.getId());%>&pregunta=<% out.print(pdto.getPregunta());%>&user=<% out.print(usuario.getUser());%>"><img src="images/activate.png" alt="activate"/></a></td> 
                        <%} else {%>
                <td><a href="PreguntasRespuestas?deactivate=<% out.print(pdto.getId());%>&pregunta=<% out.print(pdto.getPregunta());%>&user=<% out.print(usuario.getUser());%>"><img src="images/disactivate.png" alt="disactivate"/></a></td>
                        <%}%>
                        <%}%>
            </tr>
            <%}%>
        </tbody>
    </table>
    <%}%>
</div>

<jsp:include page="_footer.jsp" />
