
package SessionBean;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.ejb.Stateless;

/**
 *
 * @author 19052403-5
 */
@Stateless
public class horaBean implements horaBeanLocal {
    public Calendar obtenerFecha(){
    Calendar fechahora = new GregorianCalendar();
    return fechahora;
    }
}
