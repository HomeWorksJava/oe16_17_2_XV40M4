/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DBEntities.Userroles;
import DBEntities.Users;
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
public class UserrolesFacade extends AbstractFacade<Userroles> {

    @PersistenceContext(unitName = "KlimaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserrolesFacade() {
        super(Userroles.class);
    }
     public Userroles findUserRole(String username) {
       HashMap<String,Object> params = new HashMap<>();        
       params.put("username", username);
       return ((List<Userroles>)getEntity("Userroles.findByUsername", params)).get(0);
    }  
      public List<Userroles> findAlluserroles() {
       HashMap<String,Object> params = new HashMap<>();               
       return (List<Userroles>)getEntities("Userroles.findAll", params);
    }  
}
