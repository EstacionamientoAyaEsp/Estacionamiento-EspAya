/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 19052403-5
 */
@Local
public interface RegistroFacadeLocal {

    void create(Registro registro);

    void edit(Registro registro);

    void remove(Registro registro);

    Registro find(Object id);

    List<Registro> findAll();

    List<Registro> findRange(int[] range);

    int count();

    public int obtenerID(String ppu);

    public List<Registro> listadoVehiculosEntrado(boolean estado);

    public List<Registro> listadoVehiculosInverso();
    
}
