/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "diseasetype")
@NamedQueries({
    @NamedQuery(name = "Diseasetype.findAll", query = "SELECT d FROM Diseasetype d"),
    @NamedQuery(name = "Diseasetype.findByIdDisease", query = "SELECT d FROM Diseasetype d WHERE d.idDisease = :idDisease"),
    @NamedQuery(name = "Diseasetype.findByName", query = "SELECT d FROM Diseasetype d WHERE d.name = :name")})
public class Diseasetype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disease")
    private Integer idDisease;
    @Size(max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "diseaseId")
    private Collection<Disease> diseaseCollection;

    public Diseasetype() {
    }

    public Diseasetype(Integer idDisease) {
        this.idDisease = idDisease;
    }

    public Integer getIdDisease() {
        return idDisease;
    }

    public void setIdDisease(Integer idDisease) {
        this.idDisease = idDisease;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Disease> getDiseaseCollection() {
        return diseaseCollection;
    }

    public void setDiseaseCollection(Collection<Disease> diseaseCollection) {
        this.diseaseCollection = diseaseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisease != null ? idDisease.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diseasetype)) {
            return false;
        }
        Diseasetype other = (Diseasetype) object;
        if ((this.idDisease == null && other.idDisease != null) || (this.idDisease != null && !this.idDisease.equals(other.idDisease))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
