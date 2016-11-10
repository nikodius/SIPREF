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
<script>
    $(document).ready(function () {
        $("#mensaje").fadeOut(7000);
    });
</script>
<div class="row cajaPrincipal">
    <% if (request.getParameter("msg") != null) { %>
    <div id="mensaje" align="center" class="alert alert-info"><%out.print(request.getParameter("msg"));%></div>
    <% }%>
    <%if (request.getAttribute("listAutores") != null) {
            List<UsuarioDTO> lista = (ArrayList) request.getAttribute("listAutores");
    %>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="listar" >
        <thead>
            <tr>
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