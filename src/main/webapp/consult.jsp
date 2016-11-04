<%-- 
    Document   : consult
    Created on : 4/11/2016, 03:31:33 PM
    Author     : UserQV
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
   <%if (request.getAttribute("listPreguntas") != null) {
            List<PreguntaRespuestaDTO> lista = (ArrayList) request.getAttribute("listPreguntas");
    %>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="listarNotas" >
        <thead>
            <tr>
                <th>Pregunta</th>
                <th>Respuesta</th>
            </tr>
        </thead>
        <tbody> 
            <%
                for (PreguntaRespuestaDTO pdto : lista) {
            %>
            <tr>
                <td><%=pdto.getPregunta()%></td>
                <td><%=pdto.getRespuesta()%></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <%}%>
</div>

<jsp:include page="_footer.jsp" />

