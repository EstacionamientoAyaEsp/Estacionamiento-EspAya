/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import javax.ejb.Local;

/**
 *
 * @author Ikaro
 */
@Local
public interface DatosVehiculosLocal {
    
    public String obtenerHora ();
    
    public String obtenerFecha();

    public int cotizaMontoServicio(String fechaIni, String horaIni, String fechaFin, String horaFin);

    public String tiempoEstadia(String fechaIni, String horaIni, String fechaFin, String horaFin);

    public String borrarNull(String x);

    public String eliminaEdita(boolean e);

    public String borrarCero(int e);

    public boolean realizaCambio(String fechaAccion, String horaAccion, String fechaSistema, String horaSistema);
            
}
