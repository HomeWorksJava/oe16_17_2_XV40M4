/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBEntities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "vevok")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vevok.findAll", query = "SELECT v FROM Vevok v")
    , @NamedQuery(name = "Vevok.findById", query = "SELECT v FROM Vevok v WHERE v.id = :id")
    , @NamedQuery(name = "Vevok.findByNev", query = "SELECT v FROM Vevok v WHERE v.nev = :nev")
    , @NamedQuery(name = "Vevok.findByEmail", query = "SELECT v FROM Vevok v WHERE v.email = :email")
    , @NamedQuery(name = "Vevok.findByTelefon", query = "SELECT v FROM Vevok v WHERE v.telefon = :telefon")
    , @NamedQuery(name = "Vevok.findByEmailAndName", query = "SELECT v FROM Vevok v WHERE v.email like :email and v.nev like :nev and v.telefon like :telefon")})
public class Vevok implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(max = 50)
    @Column(name = "nev")
    private String nev;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 14)
    @Column(name = "telefon")
    private String telefon;
    @OneToMany(mappedBy = "vevoId")
    private List<Megrendelesek> megrendelesekList;

    public Vevok() {
    }

    public Vevok(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @XmlTransient
    public List<Megrendelesek> getMegrendelesekList() {
        return megrendelesekList;
    }

    public void setMegrendelesekList(List<Megrendelesek> megrendelesekList) {
        this.megrendelesekList = megrendelesekList;
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
        if (!(object instanceof Vevok)) {
            return false;
        }
        Vevok other = (Vevok) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Vevok[ id=" + id + " ]";
    }
    
}
