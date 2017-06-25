
window.onload = function (){
    obtenerFecha();
    obtenerHora();
};

function obtenerFecha(){
    var date = new Date();
    var dia = date.getDate();
    var mes = date.getMonth()+ 1;
    var anio= date.getFullYear();
    if(dia < 10 ){
        dia = "0"+date;
    }
    if (mes < 10){
        mes = "0" + mes;
    }
    document.getElementById('fecha_ini').value = anio+"-"+mes+"-"+dia;
}

function obtenerHora(){
    var date = new Date();
    var hora = date.getHours();
    var min = date.getMinutes();
    if (hora < 10){
        hora = "0"+ hora;
    }
    if (min < 10){
        min = "0"+ min;
    }
    document.getElementById('hora_ini').value = hora+":"+min;
}



