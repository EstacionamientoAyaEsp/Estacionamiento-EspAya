/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.text.ParseException;
import javax.ejb.Local;

/**
 *
 * @author Ikaro
 */
@Local
public interface CotizacionBeanLocal {

    String cotizaTiempoSer(String fechaIni, String horaIni, String fechaFin, String horaFin);

    String cotizaMontoSer(String fechaIni, String horaIni, String fechaFin, String horaFin);
    
}
