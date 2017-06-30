
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
  
        <script src="js/funciones.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Control de Vehículos</title>
        <link rel="icon" href="http://localhost:8080/Estacionamiento_EspAya-war/img/tipo-estacionamiento.png" sizes="32x32" />
        <title>Calcular Estacionamiento</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/fonts.css" rel="stylesheet">

    </head>

        
    <body>
        <%@include file="insert/NavvarFb.html" %>
        <%@include file="insert/menulateralfb.html" %>
        <form method="post" style="text-align: center" action="ingresaVehiculo">
            <p>
                <br>
                <br>
            <label>Registro Placa Patente
                <input type="text" id="Placa_Patente" name="Placa_Patente" placeholder="AAAA11" minlength="6" maxlength="6" required>
            </label>
            </p>

            <p>
                <input type="submit" value="Entrada" >
                    
            </p>
            
            <p>
                <input type="submit" value="Salida" onclick="form.action='salidaVehiculo';">
            </p>
            
        </form>
                <br>
                <br>                
                <p>
                <form method="get" action="listadoVehiculos" style="text-align: center">
                    <input type="submit" value="Registros">
                </form>
                </p>    
     

            <p>
            <details close style="text-align: center">
                <summary>Registro de Vehículo</summary>
                <table border="5" aling="center"> 
                    <tr> 
                        <td bgcolor="Skyblue"> <font color="white"> ID </font> </td>
                    <th> PPU </td>
                    <th> FECHA INGRESO </th>
                    <th> HORA INGRESO </th>
                    <th> FECHA SALIDA </th>
                    <th> HORA SALIDA </th>
                    <th> MONTO A CANCELAR </th>
                    <th> ELIMINAR </th>
                    </tr>

                </table>
            </details>
    </body>    
    
</html>
