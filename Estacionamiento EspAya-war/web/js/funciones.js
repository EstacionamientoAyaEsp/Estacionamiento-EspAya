
function calculaTiempo (){
    fechaIni = document.getElementById("fecha_ini").value;
    fechaFin = document.getElementById("fecha_fin").value;
    
    fechaIni=fechaIni.split("-");
    fechaFin=fechaFin.split("-");
    
    horaIni = document.getElementById("hora_ini").value;
    horaFin = document.getElementById("hora_fin").value;
    
    hIni=(horaIni).split(":");
    hFin=(horaFin).split(":");

    fecha= new Date(fechaIni[0],fechaIni[1]-1,fechaIni[2],hIni[0],hIni[1],"00");
    fecha2= new Date(fechaFin[0],fechaFin[1]-1,fechaFin[2],hFin[0],hFin[1],"00");
    
    var minutos=fecha2-fecha;
    
    minutos=minutos/(1000*60);
    
    var dias= parseInt((minutos/60)/24);
    var horas = parseInt((minutos - dias*60*24)/60);
    var minutos= minutos-(dias*60*24)-(horas*60);
    
    var numDias;
    
    if (dias<2){
        numDias= dias + " día,";
    }else{
        numDias= dias + " días,";
    }
    if (dias<1){
        numDias="";
    }  

    var numHoras;
    
    if (horas<2){
        numHoras= horas + " hora,";
    }else{
        numHoras= horas + " horas,";
    }
    if (horas<1){
        numHoras="";
    }  
    
    var numMinutos;
    
    if (minutos<2){
        numMinutos= minutos + " minuto.";
    }else{
        numMinutos= minutos + " minutos.";
    }
    if (minutos<1){
        numMinutos="";
    }
    var tiempo = numDias+" "+numHoras+" "+numMinutos;
            
    document.getElementById('tiempo_estimado').innerHTML =tiempo;
    return tiempo;
    
}

function calculaValor (){
    calculaTiempo();
    fechaIni = document.getElementById("fecha_ini").value;
    fechaFin = document.getElementById("fecha_fin").value;
    
    fechaIni=fechaIni.split("-");
    fechaFin=fechaFin.split("-");
    
    horaIni = document.getElementById("hora_ini").value;
    horaFin = document.getElementById("hora_fin").value;
    
    hIni=(horaIni).split(":");
    hFin=(horaFin).split(":");

    fecha= new Date(fechaIni[0],fechaIni[1]-1,fechaIni[2],hIni[0],hIni[1],"00");
    fecha2= new Date(fechaFin[0],fechaFin[1]-1,fechaFin[2],hFin[0],hFin[1],"00");
    
    var minutos=fecha2-fecha;
    
    minutos=minutos/(1000*60);
    
    var dias= parseInt((minutos/60)/24);
    var horas = parseInt((minutos - dias*60*24)/60);
    var minutos= minutos-(dias*60*24)-(horas*60);
    
        
    var valorDia = dias*15000;
    var valorHora = horas*1000;
    var valorMinuto = minutos*15;
    //var chkBox=document.getElementById("enLinea").checked;
    var total= valorDia+valorHora+valorMinuto;
    
    /*if (chkBox === true){
        total=total+250;
    }*/

    
    document.getElementById('monto').innerHTML = total;
    
}


function fechaActual (){
    
    var fechaAct = new Date();
    
    var dia =fechaAct.getDate();
    var mes= fechaAct.getMonth()+1;
    var anio=fechaAct.getFullYear();
    
    if(dia<10){
        dia="0"+dia;
    }
    if(mes<10){
        mes="0"+mes;
    }
    
    muestraFecha=(dia+'-'+mes+'-'+anio);
    
    
    document.getElementById('fechaTermino').value=muestraFecha;
      
}

function horaActual (){
    
    var horaAct = new Date();
    
    var hora =horaAct.getHours();
    var minutos= horaAct.getMinutes();
    //var segundos = horaAct.getSeconds();
    
    if(hora<10){
        hora="0"+hora;
    }
    if(minutos<10){
        minutos="0"+minutos;
    }
    /*if(segundos<10){
        segundos="0"+segundos;
    }*/
        
    var muestraHora=(hora+':'+minutos);
    
    document.getElementById('hora-registro').value=muestraHora;
   
      
}
function horaServer(){
    var horaServ= new Date();
    var hora=horaServ.getHours();
    return hora;
}

function minutoServer(){
    var minutoServ= new Date();
    var minutos=minutoServ.getMinutes();
    return minutos;
}

function segundosServer(){
    var segundosServ= new Date();
    var segundos=segundosServ.getSeconds();
    return segundos;
}
    
function mueveReloj(){
    
    relojServlet = document.getElementById("hora_serv");
    relojServer=(relojServer).split(":");
  
    var hora=relojServer[0];
    var minutos=relojServer[1];
    var segundos=relojServer[2];
 
    segundos=segundos++;
    if (segundos===60){
        segundos=0;
        minutos=minutos++;
        if(minutos===60){
            minutos=0;
            hora=hora++;
            if(hora===24){
                hora=0;
            }
        }
    }
    
    //var segundosCero= agregaCero(segundos);
    //var minutosCero= agregaCero(minutos);
    
    var muestraHora=hora+':'+minutos+':'+segundos;
        
    document.getElementById('hora_serv').value=muestraHora;
        
        }
        
        function accion(){
            setInterval(mueveReloj,1000);
        }

  function agregaCero (i){
      if (i<10){
          i="0"+1;
      }
      return i;
      }

