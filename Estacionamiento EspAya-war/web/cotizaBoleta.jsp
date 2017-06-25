<%-- 
    Document   : cotizaBoleta
    Created on : 22-05-2017, 10:28:00
    Author     : Ikaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/reclamos.css" rel="stylesheet">
        <title>Boleta de Pago Estacionamiento</title>
    </head>
    <body>
        <%@include file="insert/NavvarFb.html" %>
        <%@include file="insert/menulateralfb.html" %>
        <div style="align-content: center">
        <p style="padding-left: 201px;"></p>
        <br/>
        <fieldset style="padding-left: 35%;"><legend>Detalle de Uso de Estacionamiento</legend>
            <ul>
                <li>Fecha Entrada: <%= request.getAttribute("fechaInicio")%></li>
                <li>Hora Entrada: <%= request.getAttribute("horaInicio")%></li>
                <li>Fecha Salida: <%= request.getAttribute("fechaTermino")%></li>
                <li>Hora Salida: <%= request.getAttribute("horaTermino")%></li>
                </br>
                <li>Tiempo de Estadia: <%= request.getAttribute("tiempoUso")%></li>
            </ul>
            
            <fieldset>
            Monto a cancelar: $ <%= request.getAttribute("aPagar")%> pesos.
            </fieldset>	

        </fieldset>
        <br>
        <br>
        <a href="/Estacionamiento_EspAya-war/calcular.jsp" style="padding-left: 35%;">Volver a la pagina principal</a>
    </div>
        </body>
</html>
