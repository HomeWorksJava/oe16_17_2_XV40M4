/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBEntities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gery
 */
@Entity
@Table(name = "rendelesraktarra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RendelesRaktarra.findAll", query = "SELECT r FROM RendelesRaktarra r")
    , @NamedQuery(name = "RendelesRaktarra.findById", query = "SELECT r FROM RendelesRaktarra r WHERE r.id = :id")
    , @NamedQuery(name = "RendelesRaktarra.findByFoglaltmennyiseg", query = "SELECT r FROM RendelesRaktarra r WHERE r.foglaltmennyiseg = :foglaltmennyiseg")
    , @NamedQuery(name = "RendelesRaktarra.findByMennyiseg", query = "SELECT r FROM RendelesRaktarra r WHERE r.mennyiseg = :mennyiseg")
    , @NamedQuery(name = "RendelesRaktarra.findByMikorra", query = "SELECT r FROM RendelesRaktarra r WHERE r.mikorra = :mikorra")
    , @NamedQuery(name = "RendelesRaktarra.findByRendelesDatuma", query = "SELECT r FROM RendelesRaktarra r WHERE r.rendelesDatuma = :rendelesDatuma")
    , @NamedQuery(name = "RendelesRaktarra.findByRange", query = "SELECT r FROM RendelesRaktarra r WHERE r.rendelesDatuma between :tol and :ig")
})
public class RendelesRaktarra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "foglaltmennyiseg")
    private Integer foglaltmennyiseg;
    @Column(name = "mennyiseg")
    private Integer mennyiseg;
    @Column(name = "mikorra")
    @Temporal(TemporalType.DATE)
    private Date mikorra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rendeles_datuma")
    @Temporal(TemporalType.DATE)
    private Date rendelesDatuma;
    
    @JoinColumn(name = "keszulek_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Keszulekek keszulekId;
    
    @JoinColumn(name = "raktar_id", referencedColumnName = "id")    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Raktar raktarId;

    public RendelesRaktarra() {
    }

    public RendelesRaktarra(Integer id) {
        this.id = id;
    }

    public RendelesRaktarra(Integer id, Date rendelesDatuma) {
        this.id = id;
        this.rendelesDatuma = rendelesDatuma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getMikorra() {
        return mikorra;
    }

    public void setMikorra(Date mikorra) {
        this.mikorra = mikorra;
    }

    public Date getRendelesDatuma() {
        return rendelesDatuma;
    }

    public void setRendelesDatuma(Date rendelesDatuma) {
        this.rendelesDatuma = rendelesDatuma;
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
        if (!(object instanceof RendelesRaktarra)) {
            return false;
        }
        RendelesRaktarra other = (RendelesRaktarra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.RendelesRaktarra[ id=" + id + " ]";
    }
    
}
