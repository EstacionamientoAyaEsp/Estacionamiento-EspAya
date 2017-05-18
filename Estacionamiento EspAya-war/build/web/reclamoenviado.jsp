<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/reclamos.css" rel="stylesheet">
        <title>Reclamos y sugerencias</title>
    </head>
    <body>
        <%@include file="insert/NavvarFb.html" %>
        <%@include file="insert/menulateralfb.html" %>
        <p style="padding-left: 201px;"><%=request.getAttribute("textoNombre")%> <%= request.getAttribute("textoApellido")%> tu <%= request.getAttribute("textoTipoMensaje")%> se envio con exito</p>
        <br/>
        <fieldset style="padding-left: 201px;"><legend>Detalle del envio</legend>
            <ul>
                <li>Correo Electronico: <%= request.getAttribute("textoEmail")%></li>
                <li>Placa Patente: <%= request.getAttribute("textoPpu")%></li>
            </ul>
            Mensaje:
            <fieldset>
                <%= request.getAttribute("textoMensaje")%>
            </fieldset>	

        </fieldset>
        <br>
        <br>
        <a href="/WebEstacionamiento/reclamos.jsp" style="padding-left: 201px;">Volver a la pagina principal</a>
    </body>
</html>