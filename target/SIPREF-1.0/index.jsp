<%-- 
    Document   : index
    Created on : 18/10/2016, 09:07:59 AM
    Author     : NicolasRG
--%>

<%@page import="modelo.PreguntaRespuestaDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <title>SIPREF</title>
    </head>
    <body>
        
        <div style="padding: 2% 10% 5% 10%;" class="row">
            <div align="center">SIPREF</div>
            <% if (request.getParameter("er") != null) {
                    out.print(request.getParameter("er"));
                }%>
         <!--   <form name="form" id="form"  method="post" action="PreguntasRespuestas" >
                <div style="padding-bottom: 2%;" align="center" class="col-md-12">
                    <input class="btn btn-primary" type="submit" name="Ingresar" id="ingresar" value="Ver FAQs"/>
                </div>
            </form>-->
            
            <nav>
                <ul>
                    <li><a title="Opcion 1" href="PreguntasRespuestas?view">Ver FAQS</a></li>
                    <li><a title="Opcion 2" href="newFAQ.jsp">CrearFAQ</a></li>
                </ul>
            </nav>
            
            
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
    </body>
</html>
