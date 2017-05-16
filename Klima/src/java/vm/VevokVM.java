/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import DBEntities.Vevok;
import SessionBeans.VevokFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "vevokvm")
@SessionScoped
public class VevokVM extends BaseVM<Vevok> implements Serializable {

    @Inject
    VevokFacade vf;

    public VevokVM() {
        ujItem = new Vevok();
        keresendoItem = new Vevok();
        keresettItems = new ArrayList<Vevok>();
        ListedItems = new ArrayList<Vevok>();
    }

    @Override
    public List getfindAll() {
        return vf.findV();
    }

    @Override
    public void AddNewItem() {
        vf.create(ujItem);
    }

    @Override
    public void DeleteItem(Vevok t) {
        vf.remove(t);
    }

    @Override
    public void EditItem(Vevok t) {
        setUjItem(t);
        setEdit(true);
    }

    @Override
    public void CancelEdit() {
        setEdit(false);
        ujItem = new Vevok();
    }

    @Override
    public void SaveEdit() {        
        vf.edit(ujItem);
        setEdit(false);        
    }

    @Override
    public void Kereses() {
        HashMap<String, Object> params = new HashMap<>();      
        params.put("email", "%"+keresendoItem.getEmail()+"%");
        params.put("telefon", "%"+keresendoItem.getTelefon()+"%");
        params.put("nev", "%"+keresendoItem.getNev()+"%");
        keresettItems = vf.Kereses(params);
    }
}
