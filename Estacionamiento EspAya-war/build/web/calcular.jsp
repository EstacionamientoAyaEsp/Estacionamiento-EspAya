<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="http://localhost:8080/Estacionamiento_EspAya-war/img/tipo-estacionamiento.png" sizes="32x32" />
        <title>Calcular Estacionamiento</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/dates.js" type="text/javascript"></script>
        <script src="js/funciones.js" type="text/javascript"></script>

    </head>
    <body>
        <%@include file="insert/NavvarFb.html" %>
        <form class="ui form massive" name="frm_cotiza" method="POST" action="boletaServlet">
            <div class="massive green ui secondary segment">
                <div>
                    <div class="ui teal massive inverted segment center aligned">
                        <div class="ui header">¿Quieres simular tu estacionamiento?</div>		
                    </div>
                    <div class="massive teal ui secondary segment">
                        <span >
                            <img src="img/calendario.png" alt="" title="">
                            Tiempo aproximado de estadía
                        </span>
                        <div class="two fields">
                            <span>Fecha y hora de Ingreso</span>
                            <div class="ui corner labeled input field">
                                <input  type="date"  id="fecha_ini" name="fecha_ini" data-format="dd/MM/yyyy" required="">
                                <div class="ui teal corner label">
                                    <i class="asterisk icon"></i>
                                </div>
                            </div>  
                            <div class="ui corner labeled input field">  
                                <input type="time" id="hora_ini" name="hora_ini" data-format="hh:mm" required="">
                                <div class="ui teal corner label">
                                    <i class="asterisk icon"></i>
                                </div>
                            </div>
                        </div>
                        <div class="two fields">
                            <span>Fecha y hora de Salida</span>
                            <div class="ui corner labeled input field">
                                <input type="date" id="fecha_fin" name="fecha_fin" data-format="dd/MM/yyyy" required="">
                                <div class="ui teal corner label">
                                    <i class="asterisk icon"></i>
                                </div>
                            </div>  
                            <div class="ui corner labeled input field">  
                                <input type="time" id="hora_fin" name="hora_fin" data-format="hh:mm">
                                <div class="ui teal corner label">
                                    <i class="asterisk icon"></i>
                                </div>
                            </div>
                            <br>  
                        </div>
                        <div align="center">
                            <span>Tiempo estimado : </span><span id="tiempo_estimado">0 días, 0 horas, 0 minutos</span>
                        </div>
                        <div style="clear:both;"></div>
                        <span style="text-align: center;margin:0 0 4% 0;"></span>                                    
                    </div>
                    <div style="clear:both;"></div>

                    <div align="center">
                        <div>
                            <a class="ui massive primary button" href="javascript:;" onclick="calculaTiempo() + calculaValor()">Simular</a>
                            <br>
                        </div>
                        <div>
                            <br>
                        </div>
                        <div  align="center">
                            <span>CLP $</span><span id="monto">--</span>
                        </div>
                    </div>
                </div>
                <div align="center">
                    <br>
                    <br>  
                    <button type="submit" class="btn btn-primary">Emitir Presupuesto</button>
                </div>
            </div>                            
        </form>        
    </body>
</html>

