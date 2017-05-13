<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Reclamos y sugerencias</title>
    </head>
    <body>
        <p><%= request.getAttribute("textoNombre")%> <%= request.getAttribute("textoApellido")%> tu <%= request.getAttribute("textoTipoMensaje")%> se envio con exito</p>
        <br/>
        <fieldset><legend>Detalle del envio</legend>
            <ul>
                <li>Correo Electronico: <%= request.getAttribute("textoEmail")%></li>
                <li>Placa Patente: <%= request.getAttribute("textoPpu")%></li>
            </ul>
            Mensaje:
            <fieldset>
                <%= request.getAttribute("textoMensaje")%>
            </fieldset>	

        </fieldset>
        <p align="center"><video src="/WebEstacionamiento/main.mp4" autoplay="autoplay" loop="loop" ></video></p>
        <br>
        <br>
        <a href="/WebEstacionamiento/reclamos.jsp">Volver a la pagina principal</a>
    </body>
</html>