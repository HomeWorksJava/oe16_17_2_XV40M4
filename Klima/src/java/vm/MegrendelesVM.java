/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import DBEntities.Keszulekek;
import DBEntities.Megrendelesek;
import DBEntities.Vevok;
import SessionBeans.KeszulekekFacade;
import SessionBeans.MegrendelesekFacade;
import SessionBeans.VevokFacade;
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
@ManagedBean(name = "megrendelesvm")
@SessionScoped
public class MegrendelesVM extends BaseVM<Megrendelesek> implements Serializable {

    @Inject
    MegrendelesekFacade mf;
    @Inject
    VevokFacade vf;
    @Inject
    KeszulekekFacade kf;
    private int keszulekId;
    private int vevoId;
    private int keresettvevoId;

    public MegrendelesVM() {
        ujItem = new Megrendelesek();
        keresendoItem = new Megrendelesek();
        keresettItems = new ArrayList<Megrendelesek>();
        ListedItems = new ArrayList<Megrendelesek>();
    }

    @Override
    public List<Megrendelesek> getfindAll() {
        return mf.findM();
    }

    @Override
    public void EditItem(Megrendelesek t) {
        setUjItem(t);
        vevoId = t.getVevoId().getId();
        keszulekId = t.getKeszulekId().getId();
        setEdit(true);
    }

    @Override
    public void SaveEdit() {       
        mf.edit(ujItem);
    }

    @Override
    public void AddNewItem() {
        Map<String, Object> vp = new HashMap<>();
        vp.put("id", getVevoId());
        Map<String, Object> kp = new HashMap<>();
        kp.put("id", getKeszulekId());
        Vevok v = ((List<Vevok>) vf.getEntities("Vevok.findById", vp)).get(0);
        Keszulekek k = ((List<Keszulekek>) kf.getEntities("Keszulekek.findById", kp)).get(0);
        ujItem.setVevoId(v);
        ujItem.setKeszulekId(k);
        mf.create(ujItem);
    }

    @Override
    public void DeleteItem(Megrendelesek t) {
        mf.remove(t);
    }

    @Override
    public void Kereses() {
        HashMap<String, Object> params = new HashMap<>();        
        Map<String, Object> vp = new HashMap<>();
        vp.put("id", getKeresettvevoId());        
        Vevok v = ((List<Vevok>) vf.getEntities("Vevok.findById", vp)).get(0);                
        params.put("vevoid", v);
        params.put("mc", "%"+keresendoItem.getMegrendelescim()+"%");
        keresettItems = mf.Kereses(params);
    }

    @Override
    public void CancelEdit() {
        setEdit(false);
        ujItem = new Megrendelesek();
    }
    /**
     * @return the keszulekId
     */
    public int getKeszulekId() {
        return keszulekId;
    }

    /**
     * @param keszulekId the keszulekId to set
     */
    public void setKeszulekId(int keszulekId) {
        this.keszulekId = keszulekId;
    }

    /**
     * @return the vevoId
     */
    public int getVevoId() {
        return vevoId;
    }

    /**
     * @param vevoId the vevoId to set
     */
    public void setVevoId(int vevoId) {
        this.vevoId = vevoId;
    }

    /**
     * @return the keresettvevoId
     */
    public int getKeresettvevoId() {
        return keresettvevoId;
    }

    /**
     * @param keresettvevoId the keresettvevoId to set
     */
    public void setKeresettvevoId(int keresettvevoId) {
        this.keresettvevoId = keresettvevoId;
    }
}
