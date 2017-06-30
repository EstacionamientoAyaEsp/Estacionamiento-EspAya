/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 19052403-5
 */
@Stateless
public class RegistroFacade extends AbstractFacade<Registro> implements RegistroFacadeLocal {

    @PersistenceContext(unitName = "Estacionamiento_EspAya-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistroFacade() {
        super(Registro.class);
    }
    
    @Override
    public List<Registro> listadoVehiculos (boolean estado){
        Query q; // Objeto Query
        q =getEntityManager().createQuery("select a from Registro a where a.retirado="+estado+" order by a.id desc");
        
        //Se busca en la clase no en la tabla
        List<Registro> listaRegistros = q.getResultList();
        // Asigna resultado de la consulta a la 
        return listaRegistros;
    }

    public int obtenerID (String ppu){
        Query q; // Objeto Query
        q =getEntityManager().createQuery("select a.id from Registro a where a.retirado=0 and a.ppu='"+ppu+"'");  
        
        int ident = (int) q.getSingleResult();
        
        return ident;
        
    }
    
    
}
