/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author Ikaro
 */
@Stateless
public class DatosVehiculos implements DatosVehiculosLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public String obtenerFecha (){
        Calendar hoy = Calendar.getInstance();
        
        int dia=hoy.get(Calendar.DAY_OF_MONTH);
        int mes=hoy.get(Calendar.MONTH);
        int anio=hoy.get(Calendar.YEAR);
        
        String fecha=dia+"-"+mes+"-"+anio;
        
        return fecha;
        
}
    
    @Override
    public String obtenerHora (){
        Calendar horario = Calendar.getInstance();
        
        int hora=horario.get(Calendar.HOUR_OF_DAY);
        int minuto=horario.get(Calendar.MINUTE);
        int segundo=horario.get(Calendar.SECOND);
        
        String horaServ = hora+":"+minuto+":"+segundo;

        
        return horaServ;
               
}
    public int cotizaMontoServicio(String fechaIni, String horaIni, String fechaFin, String horaFin) {
    String inicio= fechaIni+" "+horaIni;
    String fin= fechaFin+" "+horaFin;
    
    SimpleDateFormat ini = new SimpleDateFormat ("d-M-yyyy H:m:ss");
    
    Date d1=null;
    Date d2=null;

        try {
            d1=ini.parse(inicio);
            d2=ini.parse(fin);
        } catch (ParseException ex){
            
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
    
    return total;
    }
  
    public String tiempoEstadia(String fechaIni, String horaIni, String fechaFin, String horaFin) {
        
    String inicio= fechaIni+" "+horaIni;
    String fin= fechaFin+" "+horaFin;
    
    SimpleDateFormat ini = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
    
    
    Date d1=null;
    Date d2=null;

        try {
            d1=ini.parse(inicio);
            d2=ini.parse(fin);
        } catch (ParseException ex) {
         
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
            
    String  tiempoEstacionado =numDias+" "+numHoras+" "+numMinutos;

    return tiempoEstacionado;
    
    
    }
  
    public String borrarNull (String x){
        if (x==null){
            x="";
        }
        
        return x;
    }
    
    public String eliminaEdita (boolean e){
        String texto="";
        if(e==false){
            texto="Eliminar Registro";
        }else {
            texto="Modificar Salida";
        }
        return texto;
    }
    
    public String borrarCero (int e){
        String valor="";
        if(e==0){
            valor="-";
        }else {
            valor=String.valueOf(e);
        }
        return valor;
    }
    
}
