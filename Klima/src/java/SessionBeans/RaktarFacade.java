/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DBEntities.Raktar;
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
public class RaktarFacade extends AbstractFacade<Raktar> {

    @PersistenceContext(unitName = "KlimaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //@Override
    public void remove2(Raktar r){
       // em.remove(r);
        em.remove(em.contains(r) ? r : em.merge(r));
    }
    public RaktarFacade() {
        super(Raktar.class);
    }
     public List<Raktar> findAllR() {
       HashMap<String,Object> params = new HashMap<>();               
       return (List<Raktar>)getEntities("Raktar.findAll", params);
    }  
    //ez is az abstractfacadeban abstract
    public List<Raktar> Kereses(HashMap<String, Object> params) {
         return (List<Raktar>)getEntities("Raktar.findByHelyLeiras", params);
    }
}
