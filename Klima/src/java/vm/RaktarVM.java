/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import DBEntities.Raktar;
import SessionBeans.RaktarFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "raktarvm")
@SessionScoped
public class RaktarVM extends BaseVM<Raktar> implements Serializable {

    @Inject
    RaktarFacade rf;

    public RaktarVM() {
        ujItem = new Raktar();
        keresendoItem = new Raktar();
        keresettItems = new ArrayList<Raktar>();
        ListedItems = new ArrayList<Raktar>();
    }

    @Override
    public List<Raktar> getfindAll() {
        return rf.findAllR();
    }

    @Override
    public void AddNewItem() {
        rf.create(ujItem);
    }

    @Override
    public void DeleteItem(Raktar t) {
        rf.remove(t);
    }

    @Override
    public void EditItem(Raktar t) {
        setUjItem(t);
        setEdit(true);
    }

    @Override
    public void CancelEdit() {
        setEdit(false);
        ujItem = new Raktar();
    }

    @Override
    public void SaveEdit() {        
        rf.edit(ujItem);
        setEdit(false);
    }

    @Override
    public void Kereses() {
        HashMap<String, Object> params = new HashMap<>();
        if (keresendoItem.getHely().isEmpty()) {
            keresendoItem.setHely("%");
        }
        if (keresendoItem.getLeiras().isEmpty()) {
            keresendoItem.setLeiras("%");
        }

        params.put("hely", keresendoItem.getHely());
        params.put("leiras", keresendoItem.getLeiras());
        keresettItems = rf.Kereses(params);
    }
}
