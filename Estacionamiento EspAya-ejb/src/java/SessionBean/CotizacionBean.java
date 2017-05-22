/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.util.Date;
import javax.ejb.Stateless;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ikaro
 */
@Stateless
public class CotizacionBean implements CotizacionBeanLocal {

    
/*function calculaValor (){
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
    var ValorMinuto;
    //var chkBox=document.getElementById("enLinea").checked;
    
    if (minutos<31){
        valorMinuto=500;
    }else{
        valorMinuto=minutos*16;
    }

    var total= valorDia+valorHora+valorMinuto;
    
    /*if (chkBox === true){
        total=total+250;
    }*/

    @Override
    public String cotizaTiempoSer(String fechaIni, String horaIni, String fechaFin, String horaFin) {
        
    String inicio= fechaIni+" "+horaIni+":00";
    String fin= fechaFin+" "+horaFin+":00";
    
    SimpleDateFormat ini = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
    
    
    Date d1=null;
    Date d2=null;

        try {
            d1=ini.parse(inicio);
            d2=ini.parse(fin);
        } catch (ParseException ex) {
            Logger.getLogger(CotizacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    long minutos=d2.getTime() - d1.getTime();
    
    long tiempoMinutos=minutos/(1000*60);

    int dias= (int)((tiempoMinutos/60)/24);
    int horas =(int) ((tiempoMinutos - dias*60*24)/60);
    minutos= (int) (tiempoMinutos-(dias*60*24)-(horas*60));
    
    String numDias;
    
    if (dias<2){
        numDias= dias + " día,";
    }else{
        numDias= dias + " días,";
    }
    if (dias<1){
        numDias="";
    }  

    String numHoras;
    
    if (horas<2){
        numHoras= horas + " hora,";
    }else{
        numHoras= horas + " horas,";
    }
    if (horas<1){
        numHoras="";
    }  
    
    String numMinutos;
    
    if (minutos<2){
        numMinutos= minutos + " minuto.";
    }else{
        numMinutos= minutos + " minutos.";
    }
    if (minutos<1){
        numMinutos="";
    }  
            
    String  tiempo_estimado =numDias+" "+numHoras+" "+numMinutos;

    return tiempo_estimado;
    
    
    }

    @Override
    public String cotizaMontoSer(String fechaIni, String horaIni, String fechaFin, String horaFin) {
            String inicio= fechaIni+" "+horaIni+":00";
    String fin= fechaFin+" "+horaFin+":00";
    
    SimpleDateFormat ini = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
    
    
    Date d1=null;
    Date d2=null;

        try {
            d1=ini.parse(inicio);
            d2=ini.parse(fin);
        } catch (ParseException ex) {
            Logger.getLogger(CotizacionBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    long minutos=d2.getTime() - d1.getTime();
    
    long tiempoMinutos=minutos/(1000*60);

    int dias= (int)((tiempoMinutos/60)/24);
    int horas =(int) ((tiempoMinutos - dias*60*24)/60);
    int tMinutos= (int) (tiempoMinutos-(dias*60*24)-(horas*60));
    
    int valorDia = dias*15000;
    int valorHora = horas*1000;
    int valorMinuto=tMinutos;
        
    if (minutos<31){
        valorMinuto=500;
    }else{
        valorMinuto=tMinutos*16;
    }

    int total= valorDia+valorHora+valorMinuto;
    
            
    String  monto = String.valueOf(total);

    return monto;
    }
    
    





    
        
}
    

