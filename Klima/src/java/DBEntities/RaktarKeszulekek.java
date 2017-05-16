/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBEntities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gery
 */
@Entity
@Table(name = "raktarkeszulekek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RaktarKeszulekek.findAll", query = "SELECT r FROM RaktarKeszulekek r")
    , @NamedQuery(name = "RaktarKeszulekek.findById", query = "SELECT r FROM RaktarKeszulekek r WHERE r.id = :id")
    , @NamedQuery(name = "RaktarKeszulekek.findByArres", query = "SELECT r FROM RaktarKeszulekek r WHERE r.arres = :arres")
    , @NamedQuery(name = "RaktarKeszulekek.findByFoglaltmennyiseg", query = "SELECT r FROM RaktarKeszulekek r WHERE r.foglaltmennyiseg = :foglaltmennyiseg")
    , @NamedQuery(name = "RaktarKeszulekek.findByMennyiseg", query = "SELECT r FROM RaktarKeszulekek r WHERE r.mennyiseg = :mennyiseg")
    , @NamedQuery(name = "RaktarKeszulekek.findByMinimalismennyiseg", query = "SELECT r FROM RaktarKeszulekek r WHERE r.minimalismennyiseg = :minimalismennyiseg")
    , @NamedQuery(name = "RaktarKeszulekek.findBySzabadmennyiseg", query = "SELECT r FROM RaktarKeszulekek r WHERE r.szabadmennyiseg = :szabadmennyiseg")
    , @NamedQuery(name = "RaktarKeszulekek.findByRaktarIdOrKeszulekId", query = "SELECT r FROM RaktarKeszulekek r WHERE r.raktarId = :rid or r.keszulekId = :kid")
})
public class RaktarKeszulekek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "arres")
    private BigInteger arres;
    @Column(name = "foglaltmennyiseg")
    private Integer foglaltmennyiseg;
    @Column(name = "mennyiseg")
    private Integer mennyiseg;
    @Column(name = "minimalismennyiseg")
    private Integer minimalismennyiseg;
    @Column(name = "szabadmennyiseg")
    private Integer szabadmennyiseg;
    @JoinColumn(name = "keszulek_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Keszulekek keszulekId;
    @JoinColumn(name = "raktar_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Raktar raktarId;

    public RaktarKeszulekek() {
    }

    public RaktarKeszulekek(Integer id) {
        this.id = id;
    }

    public RaktarKeszulekek(Integer id, BigInteger arres) {
        this.id = id;
        this.arres = arres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getArres() {
        return arres;
    }

    public void setArres(BigInteger arres) {
        this.arres = arres;
    }

    public Integer getFoglaltmennyiseg() {
        return foglaltmennyiseg;
    }

    public void setFoglaltmennyiseg(Integer foglaltmennyiseg) {
        this.foglaltmennyiseg = foglaltmennyiseg;
    }

    public Integer getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(Integer mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public Integer getMinimalismennyiseg() {
        return minimalismennyiseg;
    }

    public void setMinimalismennyiseg(Integer minimalismennyiseg) {
        this.minimalismennyiseg = minimalismennyiseg;
    }

    public Integer getSzabadmennyiseg() {
        return szabadmennyiseg;
    }

    public void setSzabadmennyiseg(Integer szabadmennyiseg) {
        this.szabadmennyiseg = szabadmennyiseg;
    }

    public Keszulekek getKeszulekId() {
        return keszulekId;
    }

    public void setKeszulekId(Keszulekek keszulekId) {
        this.keszulekId = keszulekId;
    }

    public Raktar getRaktarId() {
        return raktarId;
    }

    public void setRaktarId(Raktar raktarId) {
        this.raktarId = raktarId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RaktarKeszulekek)) {
            return false;
        }
        RaktarKeszulekek other = (RaktarKeszulekek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.RaktarKeszulekek[ id=" + id + " ]";
    }
    
}
