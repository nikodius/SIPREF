<%-- 
    Document   : editFAQ
    Created on : 4/11/2016, 12:10:06 PM
    Author     : Niko
--%>

<%@page import="modelo.ComentarioDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
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
<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<script src="js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tablerPR').DataTable({
            language: {
                url: 'js/Spanish.json'
            }
        });
    });
</script>
<%if (request.getAttribute("listaComentarios") != null) {
        List<ComentarioDTO> lista = (ArrayList) request.getAttribute("listaComentarios");
%>
<div class="cajaPrincipal">
    <div align="left"><a href="PreguntasRespuestas"><img src="images/back.png" alt="back"/></a></div>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="tablerPR" >
        <thead>
            <tr>
                <th>Comentario</th>
                <th>Responsable</th>
                <th>Email</th>
                <th>Fecha</th>
                <th>Estado</th>
                <th>Cambiar Estado</th>
            </tr>
        </thead>
        <tbody> 
            <%
                for (ComentarioDTO pdto : lista) {
            %>
            <tr>
                <td><%=pdto.getContenido()%></td>
                <td><%=pdto.getNombreComentarista()%></td>
                <td><%=pdto.getEmailComentarista()%></td>
                <td><%=pdto.getFechaComentario()%></td>
                <td><%=pdto.isActivo() ? "Activo" : "Inactivo"%></td>
                <% if (pdto.isActivo()) {%>
                <td><a href="Comentarios?disapprove=<% out.print(pdto.getIdComentario());%>"><img src="images/disapprove.png" alt="disapprove"/></a></td>
                        <%} else {%>
                <td><a href="Comentarios?approve=<% out.print(pdto.getIdComentario());%>"><img src="images/approve.png" alt="approve"/></a></td>
                        <%} %>
            </tr>
            <%}%>
        </tbody>
    </table>


    <%}%>
</div>

<jsp:include page="_footer.jsp" />
