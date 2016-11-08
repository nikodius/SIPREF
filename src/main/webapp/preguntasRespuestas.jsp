<%-- 
    Document   : index
    Created on : 18/10/2016, 09:07:59 AM
    Author     : NicolasRG
--%>

<%@page import="modelo.PreguntaRespuestaDTO"%>
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
    <%if (request.getAttribute("listPreguntas") != null) {
            List<PreguntaRespuestaDTO> lista = (ArrayList) request.getAttribute("listPreguntas");
    %>
    
    <div><a href="Autores">Permiso aprobacion</a></div>
    
    <div align="right"><a href="PreguntasRespuestas?add"><img src="images/add.png" id="imgEX" alt="Modificar Registro"/></a></div>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="listarNotas" >
        <thead>
            <tr>
                <th>Pregunta</th>
                <th>Respuesta</th>
                <th>Inicio Vigencia</th>
                <th>Fin Vigencia</th>
                <th>Estado</th>
                <th>Editar</th>
                <th>Aprobar</th>
                <th>Activar</th>
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
                <td>
                    <a href="PreguntasRespuestas?editId=<% out.print(pdto.getId());%>"><img src="images/edit.png" id="imgEX" alt="Modificar Registro"/></a>
                </td>

                <% if (pdto.getCodigoEstado() == 1) {%>
                <td><a href="PreguntasRespuestas?approve=<% out.print(pdto.getId());%>"><img src="images/approve.png" alt="approve"/></a></td>
                        <%} else if (pdto.getCodigoEstado() == 2) {%>
                <td><a href="PreguntasRespuestas?disapprove=<% out.print(pdto.getId());%>"><img src="images/disapprove.png" alt="disapprove"/></a></td>
                        <%} else {%>
                <td></td>
                <%}%>

                <% if (pdto.getCodigoEstado() == 3) {%>
                <td><a href="PreguntasRespuestas?active=<% out.print(pdto.getId());%>"><img src="images/activate.png" alt="activate"/></a></td> 
                        <%} else {%>
                <td><a href="PreguntasRespuestas?deactivate=<% out.print(pdto.getId());%>"><img src="images/disactivate.png" alt="disactivate"/></a></td>
                        <%}%>

            </tr>
            <%}%>
        </tbody>
    </table>
    <%}%>
</div>

<jsp:include page="_footer.jsp" />
