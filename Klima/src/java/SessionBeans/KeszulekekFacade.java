/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DBEntities.Keszulekek;
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
public class KeszulekekFacade extends AbstractFacade<Keszulekek> {

    @PersistenceContext(unitName = "KlimaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KeszulekekFacade() {
        super(Keszulekek.class);
    }
    public List<Keszulekek> findK() {
       HashMap<String,Object> params = new HashMap<>();               
       return (List<Keszulekek>)getEntities("Keszulekek.findAll", params);
    }  
    public List<Keszulekek> Kereses(HashMap<String,Object> params){        
       return (List<Keszulekek>)getEntities("Keszulekek.findByGyartoKivitelElnevezes", params);
    }
}
