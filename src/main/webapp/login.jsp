<!DOCTYPE html>
<!--
    Document   : index
    Created on : 23/10/2016, 09:07:59 AM
    Author     : Jairo Medina
-->
<html>
    <head>
        <title>SIPREF</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilosIndex.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script src="js/bootstrap.js"></script>
        <!--jsp:include page="_header.jsp" /-->
        <script>
            $(document).ready(function () {
                $("#mensaje").fadeOut(7000);
            });
        </script>
    </head>
    <body role="document" onload="if ('Navigator' == navigator.appName)
                document.forms[0].reset();
            nobackbutton()">     
        <div class="container" role="dialog">   
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="row">
                            <center>
                                <div class="col-xs-12 col-sm-3">
                                    <a href="http://www.poli.edu.co/"><img src="images/Logo.PNG" alt="logo" width="150" height="80"/></a>
                                </div>
                                <div class="col-xs-12 col-sm-9">
                                    <h4 class=""><strong>SISTEMA DE INFORMACION DE PREGUNTAS Y RESPUESTAS FRECUENTES</strong></h4>
                                    <h4><strong>SIPREF</strong></h4>
                                </div>
                            </center>
                        </div>    
                    </div> 
                    <div class="modal-body">
                        <% if (request.getParameter("msg") != null) { %>
                        <div id="mensaje" align="center" class="alert alert-warning"><%out.print(request.getParameter("msg"));%></div>
                        <% }%>
                        <form class="form-horizontal login-form" name="formularioInicio" method="post" action="GestionLogin?send">
                            <div class="form-group control-group">
                                <label for="nombreUsuario"></label>
                                <div class="input-group">
                                    <span class="input-group-addon glyphicon glyphicon-user"></span>
                                    <input class="form-control" name="nombreUsuario" id="nombreUsuario" type="text"  placeholder= "Usuario" tabindex="1" required maxlength="35"  title="Digite su usuario" autocomplete="off" autofocus="">    
                                </div>
                            </div>
                            <div class="form-group control-group">
                                <label for="contraseniaUsuario"></label>
                                <div class="input-group">
                                    <span class="input-group-addon glyphicon glyphicon-lock"></span>
                                    <input class="form-control" name="contraseniaUsuario" id="contraseniaUsuario" type="password"  placeholder= "Contrase�a" tabindex="2" required maxlength="45"  title="Digite su contrase�a" autocomplete="off">
                                </div>
                            </div>
                            <div>
                                <article class="post clearfix">
                                    <div align="center" class="contenedor-botones">
                                        <!--button class="btn btn-primary" type="submit" name="enviar" value="Ingresar">Iniciar Sesi�n <span class="glyphicon glyphicon-ok-sign"></span></button-->
                                        <button class="btn btn-lg btn-primary pull" type="submit" name="enviar" value="Ingresar" tabindex="3">Iniciar Sesi�n <i class="fa fa-arrow-circle-right"></i></button>
                                    </div>
                                </article>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <div align="center" class="col-xs-12" id="texto">
                            SIPREF - Proyecto Politecnico Grancolombiano
                        </div>
                    </div>
                </div>
            </div>         
        </div>
        <script type="text/javascript" src="js/jquery.js"></script> <!--lo cree JM PRIMERO-->
    </body>
</html>