
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : controlVehicular
    Created on : 09-06-2017, 22:54:24
    Author     : Ikaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:h="http://xmlns.jcp.org/jsf/html" xmlns:f="http://xmlns.jcp.org/jsf/core">
    <head>
        <!-- Meta -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Control de Vehículos</title>
        <!-- CSS -->
        <link href="css/semantic.min.css" rel="stylesheet">
        <!-- JS -->
        <script src="js/funciones.js" type="text/javascript"></script>
        <!-- Icon -->
        <link rel="icon" href="http://localhost:8080/Estacionamiento_EspAya-war/img/tipo-estacionamiento.png" sizes="32x32" />
    </head>
    <body>
        <%@include file="insert/NavvarFb.html" %>
        <form method="post" style="text-align: center" action="ingresaVehiculo" class="ui massive form">
            <div class="inline massive field">
                <label>Registro Placa Patente
                    <input type="text" id="Placa_Patente" name="Placa_Patente" placeholder="AAAA11" minlength="6" maxlength="6" style="text-transform: uppercase" onkeyup="javascript:this.value=this.value.toUpperCase();" required>
                </label>
            </div>
            <div>
                <input type="submit" value="Entrada" class="massive positive ui button" >
                <input type="submit" value="Salida" onclick="form.action = 'salidaVehiculo';" class="massive negative ui button">
            </div>
        </form>
        <br>
        <br>                
        <form method="get" action="listadoVehiculos" style="text-align: center">
            <input type="submit" value="Registros" class="massive teal ui button">
        </form>  
    </body>    
</html>
