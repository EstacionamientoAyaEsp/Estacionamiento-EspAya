<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="http://localhost:8080/Estacionamiento_EspAya-war/img/tipo-estacionamiento.png" sizes="32x32" />
        <title>Calcular Estacionamiento</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--<link href="css/bootstrap.min.css" rel="stylesheet">*\  -->
        <link href="css/style.css" rel="stylesheet">
        <script src="js/dates.js" type="text/javascript"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
        <link href="css/fonts.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="insert/NavvarFb.html" %>
        <%@include file="insert/menulateralfb.html" %>
        <div class="col-sm-8 col-md-8" >
            <div class="contColap xs-margin-top-30 xs-margin-bottom-30 contBlock">
                <div class="ContItem" rol-item="item-1">
                    <div id="simulador">
                        <div id="titulo">
                            <span class="barra">¿Quieres simular tu estacionamiento?</span>		
                        </div>
                        <div id="tiempo-aproximado">
                            <span class="subtitulo">
                                <img class="ico-titulo" src="img/calendario.png" alt="" title="">
                                Tiempo aproximado de estadía									</span>
                            <div class="left">
                                <span class="fecha-txt">Fecha y hora de Ingreso</span>
                                <div id="datetimepicker2" class="input-append">
                                    <input class="ico-fecha add-on" type="date"  id="fecha_ini" name="fecha_ini" data-format="dd/MM/yyyy">
                                </div>  
                                <div id="datetimepicker3" class="input-append">  
                                    <input class="ico-reloj add-on" type="time" id="hora_ini" name="hora_ini" data-format="hh:mm">
                                </div>
                            </div>
                            <div class="left">
                                <span class="fecha-txt">Fecha y hora de Salida</span>
                                <div id="datetimepicker5" class="input-append">
                                    <input class="ico-fecha add-on" type="date" id="fecha_fin" name="fecha_fin" data-format="dd/MM/yyyy">
                                </div>  
                                <div id="datetimepicker4" class="input-append">  
                                    <input class="ico-reloj add-on" type="time" id="hora_fin" name="hora_fin" data-format="hh:mm">
                                </div>
                                <div class="clear"></div>
                                <br>
                                <div class="tiempo-estimado">
                                    <span>Tiempo estimado : </span><span class="tiempo-a-calcular" id="tiempo_estimado">0 días, 0 horas, 0 minutos</span>
                                </div>
                            </div>
                            <div style="clear:both;"></div>
                            <span class="error" style="text-align: center;margin:0 0 4% 0;"></span>                                    
                        
                        </div>
                        <div style="clear:both;"></div>
                        
                            <div id="col-resultado">
                                <div class="boton-simular">
                                    <a class="btn-simular" href="javascript:;" onclick="calculaTiempo()+calculaValor()">Simular</a>
                                    
                                   </div>
                                <div class="clp">
                                    <h4 >CLP $</h4> <span class="monto" id="monto">--</span>
                                </div>                                  
                            </div>
                        </div>
                        <div style="clear:both;"></div>
                    </div>
                </div>                            
            </div>
        </div> 

        
        
        
    </body>
</html>

