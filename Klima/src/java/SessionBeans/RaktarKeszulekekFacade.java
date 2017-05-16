/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DBEntities.RaktarKeszulekek;
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
public class RaktarKeszulekekFacade extends AbstractFacade<RaktarKeszulekek> {

    @PersistenceContext(unitName = "KlimaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RaktarKeszulekekFacade() {
        super(RaktarKeszulekek.class);
    }
     public List<RaktarKeszulekek> findRK() {
       HashMap<String,Object> params = new HashMap<>();               
       return (List<RaktarKeszulekek>)getEntities("RaktarKeszulekek.findAll", params);
    }  
    public List<RaktarKeszulekek> Kereses(HashMap<String,Object> params){        
       return (List<RaktarKeszulekek>)getEntities("RaktarKeszulekek.findByRaktarIdOrKeszulekId", params);
    }
}
