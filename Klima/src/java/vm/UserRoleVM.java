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
@ManagedBean(name = "userrolevm")
@SessionScoped
public class UserRoleVM extends BaseVM<Userroles> implements Serializable {

    @Inject
    UsersFacade uf;
    @Inject
    UserrolesFacade urf;

    public UserRoleVM() {
        ujItem = new Userroles();
        keresendoItem = new Userroles();
        keresettItems = new ArrayList<Userroles>();
        ListedItems = new ArrayList<Userroles>();
    }


    @Override
    public List<Userroles> getfindAll() {
        return urf.findAlluserroles();
    }

    @Override
    public void EditItem(Userroles t) {
        ujItem = t;
        setEdit(true);

    }

    @Override
    public void SaveEdit() {
        urf.edit(ujItem);
    }

    @Override
    public void AddNewItem() {
        urf.create(ujItem);
    }

    @Override
    public void DeleteItem(Userroles t) {
        urf.remove(t);
    }

    @Override
    public void Kereses() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CancelEdit() {
        setEdit(false);
        ujItem = new Userroles();
    }
}
