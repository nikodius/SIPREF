<%-- 
    Document   : index
    Created on : 18/10/2016, 09:07:59 AM
    Author     : NicolasRG
--%>

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
    if (sesion.getAttribute("user") == null) {
        response.sendRedirect("GestionLogin");
    } else {
        usuario = (UsuarioDTO) sesion.getAttribute("user");
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
            <li><a class="active" href="Autores">Permiso Aprobación</a></li>
            <li><a href="#">Usuarios</a></li>
            <li><a href="#">Historial Modificaciones</a></li>
        </ul>
    </nav>
    <br/>
    <!--div align="left"><a href="PreguntasRespuestas"><img src="images/back.png" alt="back"/></a></div> <br-->
    <% if (request.getParameter("msg") != null) { %>
    <div id="mensaje" align="center" class="alert alert-info"><%out.print(request.getParameter("msg"));%></div>
    <% }%>
    <%if (request.getAttribute("listAutores") != null) {
            List<UsuarioDTO> lista = (ArrayList) request.getAttribute("listAutores");
    %>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="tableUser" >
        <thead>
            <tr>
                <th>Usuario</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
                <th>Email</th>
                <th>Permiso Aprobacion</th>
                <th>Cambiar Permiso</th>
            </tr>
        </thead>
        <tbody> 
            <%
                for (UsuarioDTO pdto : lista) {
            %>
            <tr>
                <td><%=pdto.getUser()%></td>
                <td><%=pdto.getNombre()%></td>
                <td><%=pdto.getApellido()%></td>
                <td><%=pdto.getTelefono()%></td>
                <td><%=pdto.getEmail()%></td>
                <td><%=pdto.isAprobarPregunta() ? "Puede aprobar" : "NO puede aprobar"%></td>
                <% if (pdto.isAprobarPregunta()) {%>
                <td><a href="Autores?disapprove=<% out.print(pdto.getId());%>"><img src="images/disapprove.png" alt="disapprove"/></a></td>
                        <%} else {%>
                <td><a href="Autores?approve=<% out.print(pdto.getId());%>"><img src="images/approve.png" alt="approve"/></a></td>
                        <%}%>
            </tr>
            <%}%>
        </tbody>
    </table>
    <%}%>
</div>

<jsp:include page="_footer.jsp" />
