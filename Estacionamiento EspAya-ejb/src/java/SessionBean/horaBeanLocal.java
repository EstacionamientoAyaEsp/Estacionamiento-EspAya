/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.util.Calendar;
import javax.ejb.Local;

/**
 *
 * @author 19052403-5
 */
@Local
public interface horaBeanLocal {
    Calendar obtenerFecha();
    
}
