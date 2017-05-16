/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import DBEntities.Keszulekek;
import DBEntities.Raktar;
import DBEntities.RaktarKeszulekek;
import SessionBeans.KeszulekekFacade;
import SessionBeans.RaktarFacade;
import SessionBeans.RaktarKeszulekekFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

/**
 *
 * @author Gery
 */
@ManagedBean(name = "raktarKeszulekvm")
@SessionScoped
public class RaktarKeszulekVM extends BaseVM<RaktarKeszulekek> implements Serializable {

    @Inject
    RaktarKeszulekekFacade rkf;
    @Inject
    KeszulekekFacade kf;
    @Inject
    RaktarFacade rf;
    private int raktarid;
    private int keszulekid;
    private int raktarid_search;
    private int keszulekid_search;
    public RaktarKeszulekVM() {
        ujItem = new RaktarKeszulekek();
        keresendoItem = new RaktarKeszulekek();
        keresettItems = new ArrayList<RaktarKeszulekek>();
        ListedItems = new ArrayList<RaktarKeszulekek>();
    }

    public List<RaktarKeszulekek> findRK() {
        return rkf.findRK();
    }

    @Override
    public List<RaktarKeszulekek> getfindAll() {
        return rkf.findRK();
    }

    @Override
    public void EditItem(RaktarKeszulekek t) {
        setUjItem(t);
        setEdit(true);
    }

    @Override
    public void SaveEdit() {
        rkf.edit(ujItem);
    }

    @Override
    public void AddNewItem() {
        Map<String, Object> vp = new HashMap<>();
        vp.put("id", getKeszulekid());
        Map<String, Object> kp = new HashMap<>();
        kp.put("id", getRaktarid());
        Raktar v = ((List<Raktar>) rf.getEntities("Raktar.findById", vp)).get(0);
        Keszulekek k = ((List<Keszulekek>) kf.getEntities("Keszulekek.findById", kp)).get(0);
        ujItem.setRaktarId(v);
        ujItem.setKeszulekId(k);        
        rkf.create(ujItem);
    }

    @Override
    public void CancelEdit() {
        setEdit(false);
        ujItem = new RaktarKeszulekek();
    }

    @Override
    public void DeleteItem(RaktarKeszulekek t) {
        rkf.remove(t);
    }

    @Override
    public void Kereses() {
        HashMap<String, Object> params = new HashMap<>();
        //params.put("rid", raktarid_search);
        //params.put("kid", keszulekid_search);
        
        Map<String, Object> vp = new HashMap<>();
        vp.put("id", raktarid_search);
        Map<String, Object> kp = new HashMap<>();
        kp.put("id", keszulekid_search);
        Raktar v = ((List<Raktar>) rf.getEntities("Raktar.findById", vp)).get(0);
        Keszulekek k = ((List<Keszulekek>) kf.getEntities("Keszulekek.findById", kp)).get(0);
        params.put("rid", v);
        params.put("kid", k);
        keresettItems = rkf.Kereses(params);
    }

    /**
     * @return the raktarid
     */
    public int getRaktarid() {
        return raktarid;
    }

    /**
     * @param raktarid the raktarid to set
     */
    public void setRaktarid(int raktarid) {
        this.raktarid = raktarid;
    }

    /**
     * @return the keszulekid
     */
    public int getKeszulekid() {
        return keszulekid;
    }

    /**
     * @param keszulekid the keszulekid to set
     */
    public void setKeszulekid(int keszulekid) {
        this.keszulekid = keszulekid;
    }

    /**
     * @return the raktarid_search
     */
    public int getRaktarid_search() {
        return raktarid_search;
    }

    /**
     * @param raktarid_search the raktarid_search to set
     */
    public void setRaktarid_search(int raktarid_search) {
        this.raktarid_search = raktarid_search;
    }

    /**
     * @return the keszulekid_search
     */
    public int getKeszulekid_search() {
        return keszulekid_search;
    }

    /**
     * @param keszulekid_search the keszulekid_search to set
     */
    public void setKeszulekid_search(int keszulekid_search) {
        this.keszulekid_search = keszulekid_search;
    }
}
