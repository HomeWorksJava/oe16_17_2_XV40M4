/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;


import DBEntities.RendelesRaktarra;

import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gery
 */
@Stateless
public class RendelesRaktarraFacade extends AbstractFacade<RendelesRaktarra> {

    @PersistenceContext(unitName = "KlimaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RendelesRaktarraFacade() {
        super(RendelesRaktarra.class);
    }
    public List<RendelesRaktarra> findAllRR() {
       HashMap<String,Object> params = new HashMap<>();               
       return (List<RendelesRaktarra>)getEntities("RendelesRaktarra.findAll", params);
    }  
     public List<RendelesRaktarra> Kereses(HashMap<String,Object> params){        
       return (List<RendelesRaktarra>)getEntities("RendelesRaktarra.findByRange", params);
    }
    
}
