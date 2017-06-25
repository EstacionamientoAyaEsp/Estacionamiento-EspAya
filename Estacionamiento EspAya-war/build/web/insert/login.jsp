<%-- 
    Document   : login
    Created on : 13-05-2017, 16:19:54
    Author     : camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <link href="//s.latamstatic.com/layout/ui/3/css/global.min.css" rel="stylesheet">
        <link href="//s.latamstatic.com/layout/ui/3/css/latam-mu.min.css" rel="stylesheet">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/dashboard.css" rel="stylesheet">
        
        <script src="../js/ventana.js" type="text/javascript"></script>
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <%@include file="NavvarFb.html" %>
        <%@include file="menulateralfb.html" %>
        <div class="row">
            <div class="col-xs-12 col-md-6 col-md-offset-3 col-lg-6 col-lg-6">
                <div class="box-white row">
                    <div class="page-heading login-heading">
                        <h1>Ingresa a tu cuenta</h1>
                    </div>
                    <div class="col-xs-12 col-md-10 col-sm-10 col-sm-offset-1">
                        <form class="form" action="" method="post" name="login_form" id="login_form">
                            
                            <div class="form-group login">
                                <label for="login" aria-hidden="true">Rut de Empleado</label>
                                <input name="login" type="text" placeholder="Run sin puntos ni Digito Verificador" maxlength="8" id="login" class="form-control">
                                </div>
                            <div class="form-group password">
                                <label for="password" aria-hidden="true">Clave</label>
                                <input name="password" type="password" id="password" class="form-control">
                                </div>
                            <button id="btnEnter" name="enter" type="submit" class="btn-flat flat-large first-level btn-block" onclick="ventanaEmer()">
                                <span>Ingresar</span>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
