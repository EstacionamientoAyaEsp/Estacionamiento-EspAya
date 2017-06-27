/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.util.Calendar;
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
    
}
