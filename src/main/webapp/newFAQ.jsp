<%-- 
    Document   : createFAQ
    Created on : 21/10/2016, 12:10:48 PM
    Author     : UserQV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="index.jsp" />
<div style="padding: 2% 10% 5% 10%;">
<form  method="post" action="PreguntasRespuestas">
    <div class="form-group">
        <label for="inputQuestion">Pregunta</label>
        <input type="text" class="form-control" id="inputQuestion" name="inputQuestion">
    </div>
    <div class="form-group">
        <label for="inputAnswer">Respuesta</label>
        <input type="text" class="form-control" id="inputAnswer" name="inputAnswer">
    </div>
    <div class="form-group">
        <label for="inputInicio">Inicio Vigencia</label>
        <input type="date" class="form-control" id="inputInicio" name="inputInicio">
    </div>
    <div class="form-group">
        <label for="inputFin">Fin Vigencia</label>
        <input type="date" class="form-control" id="inputFin" name="inputFin">
    </div>
    <input class="btn btn-primary" type="submit" name="new" id="new" value="Nueva FAQ"/>
</form>
    </div>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CREAR FAQ</h1>
        <form>
            <div class="form-group">
                <label for="inputQuestion">Pregunta</label>
                <input type="text" class="form-control" id="inputQuestion">
            </div>
            <div class="form-group">
                <label for="inputAnswer">Respuesta</label>
                <input type="password" class="form-control" id="inputAnswer">
            </div>
             <input class="btn btn-primary" type="submit" name="new" id="new" value="Nueva FAQ"/>
        </form>
    </body>
</html> -->
