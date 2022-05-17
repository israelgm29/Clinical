/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "examtype")
@NamedQueries({
    @NamedQuery(name = "Examtype.findAll", query = "SELECT e FROM Examtype e"),
    @NamedQuery(name = "Examtype.findByIdExamtype", query = "SELECT e FROM Examtype e WHERE e.idExamtype = :idExamtype"),
    @NamedQuery(name = "Examtype.findByName", query = "SELECT e FROM Examtype e WHERE e.name = :name"),
    @NamedQuery(name = "Examtype.findByCreateAt", query = "SELECT e FROM Examtype e WHERE e.createAt = :createAt"),
    @NamedQuery(name = "Examtype.findByUpdateAt", query = "SELECT e FROM Examtype e WHERE e.updateAt = :updateAt")})
public class Examtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_examtype")
    private Integer idExamtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIME)
    private Date updateAt;
    @OneToMany(mappedBy = "examtypeId")
    private Collection<Exam> examCollection;

    public Examtype() {
    }

    public Examtype(Integer idExamtype) {
        this.idExamtype = idExamtype;
    }

    public Examtype(Integer idExamtype, String name) {
        this.idExamtype = idExamtype;
        this.name = name;
    }

    public Integer getIdExamtype() {
        return idExamtype;
    }

    public void setIdExamtype(Integer idExamtype) {
        this.idExamtype = idExamtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Collection<Exam> getExamCollection() {
        return examCollection;
    }

    public void setExamCollection(Collection<Exam> examCollection) {
        this.examCollection = examCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExamtype != null ? idExamtype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Examtype)) {
            return false;
        }
        Examtype other = (Examtype) object;
        if ((this.idExamtype == null && other.idExamtype != null) || (this.idExamtype != null && !this.idExamtype.equals(other.idExamtype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Examtype[ idExamtype=" + idExamtype + " ]";
    }
    
}
