/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import DBEntities.Keszulekek;
import SessionBeans.KeszulekekFacade;
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
@ManagedBean(name = "keszulekekvm")
@SessionScoped
public class KeszulekVM extends BaseVM<Keszulekek> implements Serializable {

    @Inject
    KeszulekekFacade kf;

    public KeszulekVM() {
        ujItem = new Keszulekek();
        keresendoItem = new Keszulekek();
        keresettItems = new ArrayList<Keszulekek>();
        ListedItems = new ArrayList<Keszulekek>();
    }

    @Override
    public List<Keszulekek> getfindAll() {
        return kf.findK();
    }

    @Override
    public void EditItem(Keszulekek t) {
        setUjItem(t);
        setEdit(true);
    }

    @Override
    public void SaveEdit() {
        kf.edit(ujItem);
    }

    @Override
    public void AddNewItem() {
        kf.create(ujItem);
    }

    @Override
    public void CancelEdit() {
        setEdit(false);
        ujItem = new Keszulekek();
    }

    @Override
    public void DeleteItem(Keszulekek t) {
        kf.remove(t);
    }

    @Override
    public void Kereses() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("gyarto", "%" + keresendoItem.getGyarto() + "%");
        params.put("kivitel", "%" + keresendoItem.getKivitel() + "%");
        params.put("elnevezes", "%" + keresendoItem.getElnevezes() + "%");
        keresettItems = kf.Kereses(params);
    }
}
