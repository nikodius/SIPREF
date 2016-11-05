<!--
    Document   : index
    Created on : 23/10/2016, 09:07:59 AM
    Author     : Jairo Medina
-->
<html> 
    <head>
        <!--script>
            function nobackbutton() {
                window.location.hash = "no-back-button";
                window.location.hash = "Again-No-back-button"; //chrome
                window.onhashchange = function () {
                    window.location.hash = "no-back-button";
                };
            }
        </script-->
        <title>SIPREF</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estilosIndex.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css">
        <!--jsp:include page="_header.jsp" /-->
    </head>

    <%
        HttpSession miSession = request.getSession();
    %>
    <body role="document" onload="if ('Navigator' == navigator.appName)
                document.forms[0].reset();
            nobackbutton()">  
        <div class="container" role="dialog">   
            <div class="modal-dialog-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button class="btn btn-lg pull-right"><a href="Consultar"><i><strong>CONSULTAR EN SIPREF </strong></i></a></button>
                        <button class="btn btn-lg pull-left"><a modal-header-btn href="login.jsp"><strong>GESTIONAR SIPREF</strong></a></button>
                    </div>
                      <div class="modal-header">
                        <img src="images/Portada.PNG" alt="logo" width="1100" height="600"/>
                        <img src="images/Portada2a.PNG" alt="logo" width="1100" height="600"/>
                        <img src="images/Portada3.PNG" alt="logo" width="1100" height="600"/>
                        <img src="images/Portada4.PNG" alt="logo" width="1100" height="600"/>
                        <img src="images/Portada5.PNG" alt="logo" width="1100" height="600"/>
                        <img src="images/Portada6.PNG" alt="logo" width="1100" height="600"/>
                        <img src="images/Portada7.PNG" alt="logo" width="1100" height="600"/>
                        <img src="images/Portada8.PNG" alt="logo" width="1100" height="300"/>
                        
                    </div>
                </div>
            </div>
        </div>

    </body>


    

</html>