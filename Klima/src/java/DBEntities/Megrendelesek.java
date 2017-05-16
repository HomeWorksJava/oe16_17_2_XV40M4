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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gery
 */
@Entity
@Table(name = "megrendelesek")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Megrendelesek.findAll", query = "SELECT m FROM Megrendelesek m")
    , @NamedQuery(name = "Megrendelesek.findById", query = "SELECT m FROM Megrendelesek m WHERE m.id = :id")
    , @NamedQuery(name = "Megrendelesek.findByMegrendelescim", query = "SELECT m FROM Megrendelesek m WHERE m.megrendelescim = :megrendelescim")
    , @NamedQuery(name = "Megrendelesek.findByUtolsokarb", query = "SELECT m FROM Megrendelesek m WHERE m.utolsokarb = :utolsokarb")
    , @NamedQuery(name = "Megrendelesek.findByRendelesdatum", query = "SELECT m FROM Megrendelesek m WHERE m.rendelesdatum = :rendelesdatum")
    , @NamedQuery(name = "Megrendelesek.findByCimAndVevoid", query = "SELECT m FROM Megrendelesek m WHERE m.vevoId = :vevoid and m.megrendelescim like :mc")
                                                                                                //
    //, @NamedQuery(name = "Megrendelesek.findByCimAndVevoid", query = "SELECT m FROM Megrendelesek m WHERE m.megrendelescim like :megrendelescim or m.rendelesdatum = :rd")
})
public class Megrendelesek implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "megrendelescim")
    private String megrendelescim;
    @Column(name = "utolsokarb")
    @Temporal(TemporalType.DATE)
    private Date utolsokarb;
    @Column(name = "rendelesdatum")
    @Temporal(TemporalType.DATE)
    private Date rendelesdatum;
    @JoinColumn(name = "keszulek_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Keszulekek keszulekId;
    @JoinColumn(name = "vevo_id", referencedColumnName = "id")
    @ManyToOne
    private Vevok vevoId;

    public Megrendelesek() {
    }

    public Megrendelesek(Integer id) {
        this.id = id;
    }

    public Megrendelesek(Integer id, String megrendelescim) {
        this.id = id;
        this.megrendelescim = megrendelescim;
    }

    

    public void setId(Integer id) {
        this.id = id;
    }   
    public Integer getId() {
        return id;
    }
    public String getMegrendelescim() {
        return megrendelescim;
    }

    public void setMegrendelescim(String megrendelescim) {
        this.megrendelescim = megrendelescim;
    }

    public Date getUtolsokarb() {
        return utolsokarb;
    }

    public void setUtolsokarb(Date utolsokarb) {
        this.utolsokarb = utolsokarb;
    }

    public Date getRendelesdatum() {
        return rendelesdatum;
    }

    public void setRendelesdatum(Date rendelesdatum) {
        this.rendelesdatum = rendelesdatum;
    }

    public Keszulekek getKeszulekId() {
        return keszulekId;
    }

    public void setKeszulekId(Keszulekek keszulekId) {
        this.keszulekId = keszulekId;
    }

    public Vevok getVevoId() {
        return vevoId;
    }

    public void setVevoId(Vevok vevoId) {
        this.vevoId = vevoId;
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
        if (!(object instanceof Megrendelesek)) {
            return false;
        }
        Megrendelesek other = (Megrendelesek) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DBEntities.Megrendelesek[ id=" + id + " ]";
    }
    
}
