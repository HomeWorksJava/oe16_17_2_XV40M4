/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import DBEntities.Keszulekek;
import DBEntities.Raktar;
import DBEntities.RendelesRaktarra;
import SessionBeans.KeszulekekFacade;
import SessionBeans.RaktarFacade;
import SessionBeans.RendelesRaktarraFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
@ManagedBean(name = "rendelesraktarrakvm")
@SessionScoped
public class RendelesRaktarraVM extends BaseVM<RendelesRaktarra> implements Serializable {

    @Inject
    RendelesRaktarraFacade rrf;
    @Inject
    KeszulekekFacade kf;
    @Inject
    RaktarFacade rf;
    private Date tol = new Date();
    private Date ig = new Date();
     private int raktarid;
    private int keszulekid;
    public RendelesRaktarraVM() {
        ujItem = new RendelesRaktarra();
        keresendoItem = new RendelesRaktarra();
        keresettItems = new ArrayList<RendelesRaktarra>();
        ListedItems = new ArrayList<RendelesRaktarra>();
    }

    @Override
    public List<RendelesRaktarra> getfindAll() {
        List<RendelesRaktarra> a = rrf.findAllRR();
        return a;
    }

    @Override
    public void EditItem(RendelesRaktarra t) {
        raktarid = t.getRaktarId().getId();
        keszulekid = t.getKeszulekId().getId();
        setUjItem(t);        
        setEdit(true);
    }

    @Override
    public void SaveEdit() {
        rrf.edit(ujItem);
    }

    @Override
    public void AddNewItem() {                
        Date date=Calendar.getInstance().getTime();
        Map<String, Object> vp = new HashMap<>();
        vp.put("id", getKeszulekid());
        Map<String, Object> kp = new HashMap<>();
        kp.put("id", getRaktarid());
        Raktar v = ((List<Raktar>) rf.getEntities("Raktar.findById", vp)).get(0);
        Keszulekek k = ((List<Keszulekek>) kf.getEntities("Keszulekek.findById", kp)).get(0);
        ujItem.setRaktarId(v);
        ujItem.setKeszulekId(k);     
        ujItem.setRendelesDatuma(date);
        rrf.create(ujItem);
    }

    @Override
    public void CancelEdit() {
        setEdit(false);
        ujItem = new RendelesRaktarra();
    }

    @Override
    public void DeleteItem(RendelesRaktarra t) {
        rrf.remove(t);
    }

    @Override
    public void Kereses() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("tol", getTol());
        params.put("ig", getIg());
        keresettItems = rrf.Kereses(params);
    }

    /**
     * @return the tol
     */
    public Date getTol() {
        return tol;
    }

    /**
     * @param tol the tol to set
     */
    public void setTol(Date tol) {
        this.tol = tol;
    }

    /**
     * @return the ig
     */
    public Date getIg() {
        return ig;
    }

    /**
     * @param ig the ig to set
     */
    public void setIg(Date ig) {
        this.ig = ig;
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
}
