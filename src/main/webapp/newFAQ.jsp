<%-- 
    Document   : createFAQ
    Created on : 21/10/2016, 12:10:48 PM
    Author     : Niko
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="_header.jsp" />
<div class="cajaPrincipal">
     <div align="left"><a href="PreguntasRespuestas?view"><img src="images/back.png" alt="back"/></a></div>
    <form  method="post" action="PreguntasRespuestas">
        <div class="form-group">
            <label for="inputQuestion">Pregunta</label>
            <input type="text" class="form-control" id="inputQuestion" maxlength="200" name="inputQuestion" required>
        </div>
        <div class="form-group">
            <label for="inputAnswer">Respuesta</label>
            <input type="text" class="form-control" id="inputAnswer" name="inputAnswer" maxlength="250" required>
        </div>
        <div class="form-group">
            <label for="inputInicio">Inicio Vigencia</label>
            <input type="date" class="form-control" id="inputInicio" name="inputInicio" required>
        </div>
        <div class="form-group">
            <label for="inputFin">Fin Vigencia</label>
            <input type="date" class="form-control" id="inputFin" name="inputFin" required>
        </div>
        <input class="btn btn-primary" type="submit" name="new" id="new" value="Crear"/>
    </form>
</div>

<jsp:include page="_footer.jsp" />
