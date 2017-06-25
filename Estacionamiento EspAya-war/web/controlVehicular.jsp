<%-- 
    Document   : controlVehicular
    Created on : 09-06-2017, 22:54:24
    Author     : Ikaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
  
        <script src="js/funciones.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Control de Vehículos</title>


    </head>

        
    <body>
        
        <form name="datos" action="post">
            <p>
            <label>Registro Placa Patente
                <input type="text" id="Placa_Patente" name="Placa_Patente" placeholder="AAAA11" minlength="6" maxlength="6" required>
            </label>
            </p>
            
            <p>
                <input type="submit" value="Salida">
            </p>

            <p>
                <input type="submit" value="Entrada">
            </p>
            
            <p>
            <details open>
                <summary>Registro de Vehículo</summary>
                <ul id="registroVeh" type="Square"  > 
                </ul>
            </details>
                    
            </p>
            
        </form>
    </body>    
    
</html>
