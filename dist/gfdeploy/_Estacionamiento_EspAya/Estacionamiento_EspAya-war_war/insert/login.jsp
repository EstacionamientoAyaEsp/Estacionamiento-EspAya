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
        <title>Iniciar Seción</title>
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
                            <input type="hidden" name="cm_target_action" value="www.latam.com/es_cl/">
                            <div class="form-group login">
                                <label for="login" aria-hidden="true">Patente de vehiculo</label>
                                <input name="login" type="text" placeholder="AAAA00 / AA0000" maxlength="6" id="login" class="form-control" aria-required="true" aria-invalid="false" aria-describedby="pLogin-error-block" aria-label="Escribe tu nombre de usuario o n&uacute;mero de socio.">
                                <p class="error-block hidden text-left" id="pLogin-error-block"></p>
                            </div>
                            <div class="form-group password">
                                <label for="password" aria-hidden="true">Clave</label>
                                <input name="password" type="password" id="password" class="form-control" aria-required="true" aria-invalid="false" aria-describedby="pPassword-error-block" aria-label="Escribe tu contrase&ntilde;a.">
                                <p class="error-block hidden text-left" id="pPassword-error-block"></p>
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
