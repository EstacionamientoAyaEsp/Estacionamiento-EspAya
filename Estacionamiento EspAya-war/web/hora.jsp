<%-- 
    Document   : hora
    Created on : 22-06-2017, 17:16:40
    Author     : camilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Refresh" content="3;url=http://localhost:8080/Estacionamiento_EspAya-war/">
        <script language="JavaScript">
            

            function actualizaReloj() {

                marcacion = horaBean.setFecha();
                Hora = marcacion.getHours();
                Minutos = marcacion.getMinutes();
                Segundos = marcacion.getSeconds();
                if (Hora <= 9)
                    ;
                Hora = "0" + Hora;
                if (Minutos <= 9)
                    Minutos = "0" + Minutos;
                if (Segundos <= 9)
                    Segundos = "0" + Segundos;
                var Dia = new Array("Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");
                var Mes = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
                var Hoy = new Date();
                var Anio = Hoy.getFullYear();
                var Fecha = "Hoy es " + Dia[Hoy.getDay()] + ", " + Hoy.getDate() + " de " + Mes[Hoy.getMonth()] + " de " + Anio + ", a las ";
                var Inicio, Script, Final, Total;
                Inicio = "<font size=3 color=red>";
                Script = Fecha + Hora + ":" + Minutos + ":" + Segundos;
                Final = "</font>";
                Total = Inicio + Script + Final;
                document.getElementById('Fecha_Reloj').innerHTML = Total;
                setTimeout("actualizaReloj()", 1000);
            }
            
        </script>
        

    <body onload="actualizaReloj()">
        <table border=0 cellpadding=0 cellspacing=0>
            <tr>
                <td id="Fecha_Reloj"></td>
            <h1>Se ha registrado el vehiculo patente XXXX21, a las</h1><p id="Fecha_Reloj"</p>
                
                
            </h1>
            </tr>
        </table>
    </body>
</html>
