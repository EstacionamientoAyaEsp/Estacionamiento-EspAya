/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author 19052403-5
 */
@Stateless
public class PersonalFacade extends AbstractFacade<Personal> implements PersonalFacadeLocal {

    @PersistenceContext(unitName = "Estacionamiento_EspAya-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public String buscarContrasena(String rut){
        Query q;
        q = getEntityManager().createQuery("select contrasena from Personal p where p.rut ="+rut);
        String contrasena = q.getParameter("contrasena")+"";
        return contrasena;
    }

    public PersonalFacade() {
        super(Personal.class);
    }
    
}
