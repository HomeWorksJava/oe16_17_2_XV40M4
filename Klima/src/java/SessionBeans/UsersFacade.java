/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeans;

import DBEntities.Users;
import DBEntities.Vevok;
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
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "KlimaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }

    public Users findUser(String username) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("username", username);
        List<Users> userlist = ((List<Users>) getEntity("Users.findByUsername", params));
        if (userlist.isEmpty()) {
            return new Users();
        } else {
            return userlist.get(0);
        }
    }
    public List<Users> findAlluser() {
       HashMap<String,Object> params = new HashMap<>();               
       return (List<Users>)getEntities("Users.findAll", params);
    }  
}
