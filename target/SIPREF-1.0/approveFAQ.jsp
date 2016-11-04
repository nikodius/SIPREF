<%-- 
    Document   : approveFAQ
    Created on : 25/10/2016, 11:35:26 AM
    Author     : UserQV
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.PreguntaRespuestaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="_header.jsp" />

<div class="row cajaPrincipal">
    <!--table class = "table table-striped table-bordered table-hover table-condensed" id="listarNotas" >
        <thead>
            <tr>
                <th></th>
                <th>Pregunta</th>
                <th>Respuesta</th>
            </tr>
        </thead>
        <tbody> 
            <tr>
                <td><input type="checkbox" name="prn" value="idPrn"></td>
                <td>Pregunta n</td>
                <td>Respuesta n</td>
            </tr>
        </tbody>
    </table -->
    <%if (request.getAttribute("listPreguntas") != null) {
            List<PreguntaRespuestaDTO> lista = (ArrayList) request.getAttribute("listPreguntas");
    %>
    <table class = "table table-striped table-bordered table-hover table-condensed" id="listarNotas" >
        <thead>
            <tr>
                <th></th>
                <th>Pregunta</th>
                <th>Respuesta</th>
                <th>Inicio Vigencia</th>
                <th>Fin Vigencia</th>
                <th>Estado</th>
                <th></th>
            </tr>
        </thead>
        <tbody> 
            <%
                for (PreguntaRespuestaDTO pdto : lista) {
            %>
            <tr>
                <td><input type="checkbox" name="prn" value="<%=pdto.getId()%>"></td>
                <td><%=pdto.getPregunta()%></td>
                <td><%=pdto.getRespuesta()%></td>
                <td><%=pdto.getInicioVigencia()%></td>
                <td><%=pdto.getFinVigencia()%></td>
                <td><%=pdto.getEstado()%></td>
                <td><a href="PreguntasRespuestas?idApprove=<% out.print(pdto.getId());%>">Aprobar</a></td>
            </tr>
            <%}%>
        </tbody>
    </table>
    <%}%>
    <input class="btn btn-primary" type="submit" name="approved" id="new" value="Aprobar"/>
</div>

<jsp:include page="_footer.jsp" />
