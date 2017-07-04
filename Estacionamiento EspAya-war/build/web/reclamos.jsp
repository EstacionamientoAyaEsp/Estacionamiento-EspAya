<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sugerencias y Reclamos</title>
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/reclamos.css" rel="stylesheet">
        <style type="text/css">
            i{color: red}
        </style>
    </head>
    <body>
        <%@include file="insert/NavvarFb.html" %>
        <div class="panel panel-info" >
            <div class="panel-heading">
                <h3 class="panel-title">Reclamos</h3>
            </div>
            <div class="panel-body">
                <form class="form-inline" action="reclamos.do" method="POST">
                    <div class="form-group">
                        <label for="exampleInputName2">Nombre<i>* </i></label>
                        <input type="text" class="form-control" id="exampleInputName2" name="nombre" maxlength="14" required>
                        <label for="exampleInputName2">Apellido<i>* </i></label>
                        <input type="text" class="form-control" id="exampleInputName2" name="apellido" maxlength="50" required>
                        <label for="exampleInputName2">Placa Patente<i>* </i></label>
                        <input type="text" class="form-control" id="exampleInputName2" name="ppu" placeholder="AAAA11" maxlength="6" required>
                    </div>
                    <br/>
                    <br/>
                    <div class="form-group">
                        <label for="exampleInputEmail2">Correo Electronico (e-mail)<i>* </i></label>
                        <input type="email" class="form-control" id="exampleInputEmail2" placeholder="correo@domino.com" 
                               name="email" placeholder="correo@domino.com" placeholder="correo@domino.com" required>
                        <label for="selectTipoMensaje">Tipo de mensaje</label>
                        <select class="form-control" name="tipoMensaje" id="selectTipoMensaje">
                            <option value="reclamo">Reclamo</option>
                            <option value="sugerencia">Sugerencia</option>
                            <option value="consulta">Consulta</option>
                            <option value="otro">Otro</option>
                        </select>
                    </div>
                    <br/>
                    <br/>
                    <div class="form-group">
                        <label for="mensaje">Ingrese su mensaje<i>* </i></label>
                        <br>
                        <textarea class="form-control" rows="5" cols="60" maxlength="1000" required name="mensaje" id="mensaje"></textarea>
                    </div>
                    <br/>
                    <label for="requerido"><i>* </i> Indica que es requerido</label>
                    <p class="bg-warning" id="requerido"></p>
                    <br/>
                    <br/>
                    <div align="center">
                        <button type="submit" class="btn btn-primary">Enviar</button>
                        <button type="reset" class="btn btn-danger">Limpiar Formulario</button>
                    </div>
                </form>
            </div>
        </div>		
    </body>
</html>