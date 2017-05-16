/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DBEntities.Megrendelesek;
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
public class MegrendelesekFacade extends AbstractFacade<Megrendelesek> {

    @PersistenceContext(unitName = "KlimaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MegrendelesekFacade() {
        super(Megrendelesek.class);
    }
     public List<Megrendelesek> findM() {
       HashMap<String,Object> params = new HashMap<>();               
       return (List<Megrendelesek>)getEntities("Megrendelesek.findAll", params);
    }  
     public List<Megrendelesek> Kereses(HashMap<String,Object> params){        
       return (List<Megrendelesek>)getEntities("Megrendelesek.findByCimAndVevoid", params);
    }
}
