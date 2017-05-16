/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import DBEntities.Userroles;
import DBEntities.Users;
import SessionBeans.UserrolesFacade;
import SessionBeans.UsersFacade;
import Usersthings.Sha256;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "uservm")
@SessionScoped
public class UserVM extends BaseVM<Users> implements Serializable {

    @Inject
    UsersFacade uf;
    @Inject
    UserrolesFacade urf;

    public UserVM() {
        ujItem = new Users();
        keresendoItem = new Users();
        keresettItems = new ArrayList<Users>();
        ListedItems = new ArrayList<Users>();
    }

    @Override
    public List<Users> getfindAll() {
        return uf.findAlluser();
    }

    @Override
    public void EditItem(Users t) {
        ujItem = t;
        setEdit(true);
    }

    @Override
    public void SaveEdit() {
        Sha256 sha = new Sha256(ujItem.getPasswd());
        String pass = sha.getSha256();
        ujItem.setPasswd(pass);
        uf.edit(ujItem);
        setEdit(false);
    }

    @Override
    public void AddNewItem() {
        Sha256 sha = new Sha256(ujItem.getPasswd());
        String pass = sha.getSha256();
        ujItem.setPasswd(pass);
        uf.create(ujItem);
    }

    @Override
    public void DeleteItem(Users t) {
        uf.remove(t);
    }

    @Override
    public void Kereses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CancelEdit() {
        setEdit(false);
        ujItem = new Users();
    }
}
