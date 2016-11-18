<%-- 
    Document   : index
    Created on : 18/10/2016, 09:07:59 AM
    Author     : NicolasRG
--%>

<%@page import="modelo.HistorialDTO"%>
<%@page import="modelo.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="_header.jsp" />
<link rel="stylesheet" href="css/jquery.dataTables.min.css">
<script src="js/jquery.dataTables.min.js"></script>
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
<script>
    $(document).ready(function () {
        $("#mensaje").fadeOut(7000);
        $('#tableUser').DataTable({
            language: {
                url: 'js/Spanish.json'
            }
        });
    });
</script>
<div class="row cajaPrincipal">
    <nav>
        <ul>
            <li><a href="PreguntasRespuestas">Preguntas Respuestas</a></li>
            <li><a href="Autores">Permiso Aprobación</a></li>
            <li><a href="GestionUsuarios">Usuarios</a></li>
            <li><a class="active" href="Historial">Historial Modificaciones</a></li>
        </ul>
    </nav>
    <br/>
    <!--div align="left"><a href="PreguntasRespuestas"><img src="images/back.png" alt="back"/></a></div> <br-->
    <% if (request.getParameter("msg") != null) { %>
    <div id="mensaje" align="center" class="alert alert-info"><%out.print(request.getParameter("msg"));%></div>
    <% }%>
    <%if (request.getAttribute("listHistory") != null) {
            List<HistorialDTO> lista = (ArrayList) request.getAttribute("listHistory");
    %>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="tableUser" >
        <thead>
            <tr>
                <th>Usuario</th>
                <th>Accion</th>
                <th>Fecha</th>
            </tr>
        </thead>
        <tbody> 
            <%
                for (HistorialDTO hdto : lista) {
            %>
            <tr>
                <td><%=hdto.getUsuario()%></td>
                <td><%=hdto.getAccion()%></td>
                <td><%=hdto.getFecha()%></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <%}%>
</div>

<jsp:include page="_footer.jsp" />
