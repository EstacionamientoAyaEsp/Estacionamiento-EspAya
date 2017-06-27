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
            
}
