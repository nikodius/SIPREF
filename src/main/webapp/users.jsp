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
    if (sesion.getAttribute("user") != null) {
        usuario = (UsuarioDTO) sesion.getAttribute("user");
        if (usuario.getIdRol() != 1) {
            response.sendRedirect("PreguntasRespuestas");
        }
    } else {
        response.sendRedirect("GestionLogin");
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
    <nav>
        <ul>
            <li><a href="PreguntasRespuestas">Preguntas Respuestas</a></li>
            <li><a href="Autores">Permiso Aprobación</a></li>
            <li><a class="active" href="GestionUsuarios">Usuarios</a></li>
            <li><a href="Historial">Historial Modificaciones</a></li>
        </ul>
    </nav>
    <br>
    <% } %>

    <%if (request.getAttribute("listUsuarios") != null) {
            List<UsuarioDTO> lista = (ArrayList) request.getAttribute("listUsuarios");
    %>
    <div align="right"><a href="GestionUsuarios?add"><img src="images/add.png" id="imgEX" alt="Modificar Registro"/> Nuevo Usuario</a></div>
    <br/>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="tablerPR" >
        <thead>
            <tr>
                <th>Usuario</th>
                <th>Rol</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Telefono</th>
                <th>Email</th>
                <th>Estado</th>
                <th>Editar</th>
                <th>Activar</th>
            </tr>
        </thead>
        <tbody> 
            <%
                for (UsuarioDTO udto : lista) {
            %>
            <tr>
                <td><%=udto.getUser()%></td>
                <td><%=udto.getRol()%></td>
                <td><%=udto.getNombre()%></td>
                <td><%=udto.getApellido()%></td>
                <td><%=udto.getTelefono()%></td>
                <td><%=udto.getEmail()%></td>
                <td><%=udto.getEstado()%></td>
                <td>
                    <a href="GestionUsuarios?editId=<% out.print(udto.getId());%>"><img src="images/edit.png" id="imgEX" alt="Modificar Registro"/></a>
                </td>
                <% if (udto.getIdEstado() == 1) {%>
                <td><a href="GestionUsuarios?desactivate=<% out.print(udto.getId());%>&nameUser=<% out.print(udto.getUser());%>&user=<% out.print(usuario.getUser());%>"><img src="images/disactivate.png" alt="disactivate"/></a></td>
                        <%} else {%>
                <td><a href="GestionUsuarios?active=<% out.print(udto.getId());%>&nameUser=<% out.print(udto.getUser());%>&user=<% out.print(usuario.getUser());%>"><img src="images/activate.png" alt="activate"/></a></td> 

                <%}%>
            </tr>
            <%}%>
        </tbody>
    </table>
    <%}%>
</div>

<jsp:include page="_footer.jsp" />
