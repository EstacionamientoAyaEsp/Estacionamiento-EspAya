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
        <link href="css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/reclamos.css" rel="stylesheet">
        <title>Boleta de Pago Estacionamiento</title>
    </head>
    <body>
        <%@include file="insert/NavvarFb.html" %>
        <div align="center" class="ui piled massive segment">
            <h1 class="ui header">Detalle de Uso de Estacionamiento</h1>
            <br>
            <div class="ui center aligned segment massive">
                <p>Fecha Entrada: <%= request.getAttribute("fechaInicio")%></p>
                <p>Hora Entrada: <%= request.getAttribute("horaInicio")%></p>
                <p>Fecha Salida: <%= request.getAttribute("fechaTermino")%></p>
                <p>Hora Salida: <%= request.getAttribute("horaTermino")%></p>
                <br>
                <p>Tiempo de Estadia: <%= request.getAttribute("tiempoUso")%></p>
            </div>
            <div>
                Monto a cancelar: $ <%= request.getAttribute("aPagar")%> pesos.
            </div>
            <br>
            <br>
            <a href="/Estacionamiento_EspAya-war/calcular.jsp">Volver a la pagina principal</a>
        </div>
    </body>
</html>
