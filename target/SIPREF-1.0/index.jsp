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
        <div style="padding: 2% 20% 5% 20%;" class="row">
            <% if (request.getParameter("er") != null) {
                    out.print(request.getParameter("er"));
                }%>
         <!--   <form name="form" id="form"  method="post" action="PreguntasRespuestas" >
                <div style="padding-bottom: 2%;" align="center" class="col-md-12">
                    <input class="btn btn-primary" type="submit" name="Ingresar" id="ingresar" value="Ver FAQs"/>
                </div>
            </form>-->
            
            
            
            
            <%if (request.getAttribute("listPreguntas") != null) {
                    List<PreguntaRespuestaDTO> lista = (ArrayList) request.getAttribute("listPreguntas");
            %>
            <table class = "table table-striped table-bordered table-hover table-condensed" id="listarNotas" >
                <thead>
                    <tr>
                        <th>Pregunta</th>
                        <th>Respuesta</th>
                        <th></th>
                    </tr>
                    <%
                        for (PreguntaRespuestaDTO pdto : lista) {
                    %>
                    <tr>
                        <td><%=pdto.getPregunta()%></td>
                        <td><%=pdto.getRespuesta()%></td>
                        <td><a href="PreguntasRespuestas?id=<% out.print(pdto.getId());%>">eliminar</a></td>
                    </tr>
                    <%}%>
                </thead>
                <tbody> 
                </tbody>
            </table>
            <%}%>
        </div>
            
<jsp:include page="_footer.jsp" />
