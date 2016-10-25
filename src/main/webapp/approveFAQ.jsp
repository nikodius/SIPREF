<%-- 
    Document   : approveFAQ
    Created on : 25/10/2016, 11:35:26 AM
    Author     : UserQV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="_header.jsp" />

<div class="row cajaPrincipal">
    <table class = "table table-striped table-bordered table-hover table-condensed" id="listarNotas" >
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
    </table>
    <input class="btn btn-primary" type="submit" name="approved" id="new" value="Aprobar"/>
</div>

<jsp:include page="_footer.jsp" />
