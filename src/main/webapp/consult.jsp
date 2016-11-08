<%-- 
    Document   : consult
    Created on : 4/11/2016, 03:31:33 PM
    Author     : UserQV
--%>

<%@page import="modelo.ComentarioDTO"%>
<%@page import="modelo.PreguntaRespuestaDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="_header.jsp" />
<link rel="stylesheet" type="text/css" href="css/acordion.css">
<link rel="stylesheet" type="text/css" href="css/comentarios.css">
<script>
    $(document).ready(function () {
        $("#mensaje").fadeOut(7000);
    });
</script>

<div class="row cajaPrincipal">
    <% if (request.getParameter("msg") != null) { %>
    <div id="mensaje" align="center" class="alert alert-info"><%out.print(request.getParameter("msg"));%></div>
    <% }%>
    <h2>Preguntas Frecuentes</h2>
    <br>
    <%if (request.getAttribute("listPreguntas") != null) {
            List<PreguntaRespuestaDTO> lista = (ArrayList) request.getAttribute("listPreguntas");
            for (PreguntaRespuestaDTO pdto : lista) {
    %>
    <button class="accordion"><%=pdto.getPregunta()%><i class="fa fa-plus pull-right"></i></button>
    <div class="panel">
        <br/>
        <p><%=pdto.getRespuesta()%></p>
        <br/>
        <% List<ComentarioDTO> listaComentarios = pdto.getComentarios();%>
        <p style="text-align:right; margin-right: 5%;">Comentarios: <%=listaComentarios.size()%></p> 
        <%for (ComentarioDTO cdto : listaComentarios) {
        %>
        <div class="comments-container">
            <ul id="comments-list" class="comments-list">
                <li>
                    <div class="comment-main-level">
                        <!-- Contenedor del Comentario -->
                        <div class="comment-box">
                            <div class="comment-head">
                                <h6 class="comment-name by-author"><%=cdto.getNombreComentarista()%></h6>
                                <span><%=cdto.getFechaComentario()%></span>
                            </div>
                            <div class="comment-content">
                                <%=cdto.getContenido()%>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <% }%>
        <br/>
        <h2>Déjanos tu comentario</h2>
        <br>
        <form  method="post" action="Comentarios">
            <input type="hidden" class="form-control" id="idPR" name="idPR" value="<%=pdto.getId()%>">

            <div class="form-group">
                <label for="name">Nombre</label>
                <input type="text" class="form-control" id="name" name="name" maxlength="60" required>
            </div>
            <div class="form-group">
                <label for="name">Email</label>
                <input type="email" class="form-control" id="mail" name="mail" maxlength="80" required>
            </div>
            <div class="form-group">
                <label for="coment">Comentario</label>
                <textarea class="form-control" id="coment" rows="4" cols="50" name="coment" maxlength="250" required></textarea>
            </div>
            <div style="margin: 0% 10% 0% 10%;">
                <button type="submit" id="sendComent" name="sendComent" class="btn btn-primary btn-block">Comentar</button>
                <br>
            </div>
        </form>
    </div>
    <%}%>
    <%}%>
</div>
<script>
    var acc = document.getElementsByClassName("accordion");
    var i;

    for (i = 0; i < acc.length; i++) {
        acc[i].onclick = function () {
            if ($(this).children('i').hasClass('fa-plus')) {
                $(this).children('i').removeClass("fa-plus").addClass("fa-minus");
            } else {
                $(this).children('i').removeClass("fa-minus").addClass("fa-plus");
            }
            this.classList.toggle("active");
            this.nextElementSibling.classList.toggle("show");
        }
    }
</script>
<jsp:include page="_footer.jsp" />

