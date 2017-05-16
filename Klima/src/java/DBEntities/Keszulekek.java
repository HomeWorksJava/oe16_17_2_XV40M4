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
@Table(name = "keszulekek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Keszulekek.findAll", query = "SELECT k FROM Keszulekek k")
    , @NamedQuery(name = "Keszulekek.findByElnevezes", query = "SELECT k FROM Keszulekek k WHERE k.elnevezes = :elnevezes")
    , @NamedQuery(name = "Keszulekek.findById", query = "SELECT k FROM Keszulekek k WHERE k.id = :id")
    , @NamedQuery(name = "Keszulekek.findByEnergiaosztaly", query = "SELECT k FROM Keszulekek k WHERE k.energiaosztaly = :energiaosztaly")
    , @NamedQuery(name = "Keszulekek.findByFutoteljesitmeny", query = "SELECT k FROM Keszulekek k WHERE k.futoteljesitmeny = :futoteljesitmeny")
    , @NamedQuery(name = "Keszulekek.findByGarancia", query = "SELECT k FROM Keszulekek k WHERE k.garancia = :garancia")
    , @NamedQuery(name = "Keszulekek.findByGyarto", query = "SELECT k FROM Keszulekek k WHERE k.gyarto = :gyarto")
    , @NamedQuery(name = "Keszulekek.findByHutoteljesitmeny", query = "SELECT k FROM Keszulekek k WHERE k.hutoteljesitmeny = :hutoteljesitmeny")
    , @NamedQuery(name = "Keszulekek.findByKivitel", query = "SELECT k FROM Keszulekek k WHERE k.kivitel = :kivitel")
    , @NamedQuery(name = "Keszulekek.findByLeiras", query = "SELECT k FROM Keszulekek k WHERE k.leiras = :leiras")
    , @NamedQuery(name = "Keszulekek.findByGyartoKivitelElnevezes", query = "SELECT k FROM Keszulekek k WHERE k.elnevezes like :elnevezes and k.kivitel like :kivitel and k.gyarto like :gyarto")
})
public class Keszulekek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 240)
    @Column(name = "elnevezes")
    private String elnevezes;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "energiaosztaly")
    private String energiaosztaly;
    @Basic(optional = false)
    @NotNull
    @Column(name = "futoteljesitmeny")
    private double futoteljesitmeny;
    @Size(max = 20)
    @Column(name = "garancia")
    private String garancia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "gyarto")
    private String gyarto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hutoteljesitmeny")
    private double hutoteljesitmeny;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "kivitel")
    private String kivitel;
    @Size(max = 250)
    @Column(name = "leiras")
    private String leiras;
    @OneToMany(mappedBy = "keszulekId")
    private List<Megrendelesek> megrendelesekList;
    @OneToMany(mappedBy = "keszulekId")
    private List<RaktarKeszulekek> raktarKeszulekekList;
    @OneToMany(mappedBy = "keszulekId")
    private List<RendelesRaktarra> rendelesRaktarraList;

    public Keszulekek() {
    }

    public Keszulekek(Integer id) {
        this.id = id;
    }

    public Keszulekek(Integer id, String energiaosztaly, double futoteljesitmeny, String gyarto, double hutoteljesitmeny, String kivitel) {
        this.id = id;
        this.energiaosztaly = energiaosztaly;
        this.futoteljesitmeny = futoteljesitmeny;
        this.gyarto = gyarto;
        this.hutoteljesitmeny = hutoteljesitmeny;
        this.kivitel = kivitel;
    }

    public String getElnevezes() {
        return elnevezes;
    }

    public void setElnevezes(String elnevezes) {
        this.elnevezes = elnevezes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnergiaosztaly() {
        return energiaosztaly;
    }

    public void setEnergiaosztaly(String energiaosztaly) {
        this.energiaosztaly = energiaosztaly;
    }

    public double getFutoteljesitmeny() {
        return futoteljesitmeny;
    }

    public void setFutoteljesitmeny(double futoteljesitmeny) {
        this.futoteljesitmeny = futoteljesitmeny;
    }

    public String getGarancia() {
        return garancia;
    }

    public void setGarancia(String garancia) {
        this.garancia = garancia;
    }

    public String getGyarto() {
        return gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public double getHutoteljesitmeny() {
        return hutoteljesitmeny;
    }

    public void setHutoteljesitmeny(double hutoteljesitmeny) {
        this.hutoteljesitmeny = hutoteljesitmeny;
    }

    public String getKivitel() {
        return kivitel;
    }

    public void setKivitel(String kivitel) {
        this.kivitel = kivitel;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    @XmlTransient
    public List<Megrendelesek> getMegrendelesekList() {
        return megrendelesekList;
    }

    public void setMegrendelesekList(List<Megrendelesek> megrendelesekList) {
        this.megrendelesekList = megrendelesekList;
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
        if (!(object instanceof Keszulekek)) {
            return false;
        }
        Keszulekek other = (Keszulekek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Keszulekek[ id=" + id + " ]";
    }
    
}
