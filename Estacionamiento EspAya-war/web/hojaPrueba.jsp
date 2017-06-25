<%-- 
    Document   : hojaPrueba
    Created on : 15-06-2017, 16:58:01
    Author     : Ikaro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head> 
<title>Reloj con Javascript</title> 
<script language="JavaScript"> 
 
    
    function mueveReloj(){ 
      	momentoActual = new Date();
        hora = momentoActual.getHours() ;
   	minuto = momentoActual.getMinutes() ;
   	segundo = momentoActual.getSeconds() ;


   	horaImprimible = hora + ":" + minuto + " : " + segundo ;

   	document.form_reloj.reloj.value=horaImprimible;
        
   	setTimeout("mueveReloj()",5000) ;
        
} 

</script> 
</head> 

<body onload="mueveReloj()"> 

Vemos aquí el reloj funcionando... 

<form name="form_reloj"> 
<input type="text" name="reloj" size="10" id="xxx"> 
</form> 

</body> 
</html>
