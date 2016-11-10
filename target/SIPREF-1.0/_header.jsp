<%-- 
    Document   : _header
    Created on : 24/10/2016, 03:48:01 PM
    Author     : UserQV
--%>

<%@page import="modelo.UsuarioDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/estilos.css">
        <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css">
        <script src="js/jquery-3.1.1.js"></script>
        <title>SIPREF</title>
    </head>
    <body>
        <div align="center" id="centrado">
            <header>
                <% response.setHeader("Cache-Control", "no-cache");
                    response.setHeader("Cache-Control", "no-store");
                    response.setDateHeader("Expires", 0);
                    HttpSession sesion = request.getSession(false);
                    UsuarioDTO usuario = new UsuarioDTO();
                    if (sesion.getAttribute("user") == null) {
                        response.sendRedirect("GestionLogin");
                    } else {
                        usuario = (UsuarioDTO) sesion.getAttribute("user");
                    }
                %> 

                <div class="container" role="dialog">   
                    <div class="modal-dialog-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <div class="row">
                                    <center>
                                        <div class="col-xs-12 col-sm-2">
                                            <img src="images/Logo.PNG" alt="logo" width="150" height="80"/>
                                        </div>
                                        <div class="col-xs-10 col-sm-8">
                                            <h5 class=""><strong>SISTEMA DE INFORMACION DE PREGUNTAS Y RESPUESTAS FRECUENTES</strong></h5>
                                            <h4>SIPREF</h4>
                                        </div>
                                        <div class="col-xs-2 col-sm-2">
                                            <div id="datos" align="center" class="">
                                                
                                                    <span>Bienvenido <% out.print(usuario.getUser());%></span><br>
                                                    <span>Rol <% out.print(usuario.getRol());%></span>
                                                
                                                <form name="logout" action="GestionLogin" id="form1">
                                                    <input id="salir" type="submit" name="logout" class="btn btn-danger" value="Cerrar Sesión"/>
                                                </form>
                                            </div>
                                        </div>
                                    </center>
                                </div>    
                            </div> 
                        </div>
                    </div>         
                </div>
            </header>

