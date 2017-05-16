/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBEntities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gery
 */
@Entity
@Table(name = "raktar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Raktar.findAll", query = "SELECT r FROM Raktar r")
    , @NamedQuery(name = "Raktar.findByHely", query = "SELECT r FROM Raktar r WHERE r.hely = :hely")
    , @NamedQuery(name = "Raktar.findById", query = "SELECT r FROM Raktar r WHERE r.id = :id")
    , @NamedQuery(name = "Raktar.findByTerulet", query = "SELECT r FROM Raktar r WHERE r.terulet = :terulet")
    , @NamedQuery(name = "Raktar.findByLeiras", query = "SELECT r FROM Raktar r WHERE r.leiras = :leiras")    
})
public class Raktar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "hely")
    private String hely;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "terulet")
    private Integer terulet;
    @Size(max = 250)
    @Column(name = "leiras")
    private String leiras;
    @OneToMany(mappedBy = "raktarId")
    private List<RaktarKeszulekek> raktarKeszulekekList;
    @OneToMany(mappedBy = "raktarId")
    private List<RendelesRaktarra> rendelesRaktarraList;

    public Raktar() {
    }

    public Raktar(Integer id) {
        this.id = id;
    }

    public String getHely() {
        return hely;
    }

    public void setHely(String hely) {
        this.hely = hely;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTerulet() {
        return terulet;
    }

    public void setTerulet(Integer terulet) {
        this.terulet = terulet;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    @XmlTransient
    public List<RaktarKeszulekek> getRaktarKeszulekekList() {
        return raktarKeszulekekList;
    }

    public void setRaktarKeszulekekList(List<RaktarKeszulekek> raktarKeszulekekList) {
        this.raktarKeszulekekList = raktarKeszulekekList;
    }

    @XmlTransient
    public List<RendelesRaktarra> getRendelesRaktarraList() {
        return rendelesRaktarraList;
    }

    public void setRendelesRaktarraList(List<RendelesRaktarra> rendelesRaktarraList) {
        this.rendelesRaktarraList = rendelesRaktarraList;
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
        if (!(object instanceof Raktar)) {
            return false;
        }
        Raktar other = (Raktar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Raktar[ id=" + id + " ]";
    }
    
}
