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
import javax.validation.constraints.Size;

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "medicalspecialis")
@NamedQueries({
    @NamedQuery(name = "Medicalspecialis.findAll", query = "SELECT m FROM Medicalspecialis m"),
    @NamedQuery(name = "Medicalspecialis.findById", query = "SELECT m FROM Medicalspecialis m WHERE m.id = :id"),
    @NamedQuery(name = "Medicalspecialis.findByCreateAt", query = "SELECT m FROM Medicalspecialis m WHERE m.createAt = :createAt"),
    @NamedQuery(name = "Medicalspecialis.findByEditAt", query = "SELECT m FROM Medicalspecialis m WHERE m.editAt = :editAt"),
    @NamedQuery(name = "Medicalspecialis.findByUpdateAt", query = "SELECT m FROM Medicalspecialis m WHERE m.updateAt = :updateAt"),
    @NamedQuery(name = "Medicalspecialis.findByDelete", query = "SELECT m FROM Medicalspecialis m WHERE m.delete = :delete"),
    @NamedQuery(name = "Medicalspecialis.findByName", query = "SELECT m FROM Medicalspecialis m WHERE m.name = :name"),
    @NamedQuery(name = "Medicalspecialis.findByDescription", query = "SELECT m FROM Medicalspecialis m WHERE m.description = :description")})
public class Medicalspecialis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "edit_at")
    @Temporal(TemporalType.TIME)
    private Date editAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIME)
    private Date updateAt;
    @Column(name = "delete")
    private Boolean delete;
    @Size(max = 50)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "medicSpecialist")
    private Collection<Specialist> specialistCollection;

    public Medicalspecialis() {
    }

    public Medicalspecialis(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getEditAt() {
        return editAt;
    }

    public void setEditAt(Date editAt) {
        this.editAt = editAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Specialist> getSpecialistCollection() {
        return specialistCollection;
    }

    public void setSpecialistCollection(Collection<Specialist> specialistCollection) {
        this.specialistCollection = specialistCollection;
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
        if (!(object instanceof Medicalspecialis)) {
            return false;
        }
        Medicalspecialis other = (Medicalspecialis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
