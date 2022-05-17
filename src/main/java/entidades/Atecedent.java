/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

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

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "atecedent")
@NamedQueries({
    @NamedQuery(name = "Atecedent.findAll", query = "SELECT a FROM Atecedent a"),
    @NamedQuery(name = "Atecedent.findByIdAntecedent", query = "SELECT a FROM Atecedent a WHERE a.idAntecedent = :idAntecedent"),
    @NamedQuery(name = "Atecedent.findByCreateAt", query = "SELECT a FROM Atecedent a WHERE a.createAt = :createAt"),
    @NamedQuery(name = "Atecedent.findByUpdateAt", query = "SELECT a FROM Atecedent a WHERE a.updateAt = :updateAt"),
    @NamedQuery(name = "Atecedent.findByPersonalAnt", query = "SELECT a FROM Atecedent a WHERE a.personalAnt = :personalAnt"),
    @NamedQuery(name = "Atecedent.findBySurgicalAnt", query = "SELECT a FROM Atecedent a WHERE a.surgicalAnt = :surgicalAnt"),
    @NamedQuery(name = "Atecedent.findByDamilyAnt", query = "SELECT a FROM Atecedent a WHERE a.damilyAnt = :damilyAnt"),
    @NamedQuery(name = "Atecedent.findByProfesionalAnt", query = "SELECT a FROM Atecedent a WHERE a.profesionalAnt = :profesionalAnt"),
    @NamedQuery(name = "Atecedent.findByHabit", query = "SELECT a FROM Atecedent a WHERE a.habit = :habit"),
    @NamedQuery(name = "Atecedent.findByClinical", query = "SELECT a FROM Atecedent a WHERE a.clinical = :clinical"),
    @NamedQuery(name = "Atecedent.findByTrauma", query = "SELECT a FROM Atecedent a WHERE a.trauma = :trauma"),
    @NamedQuery(name = "Atecedent.findByAllergy", query = "SELECT a FROM Atecedent a WHERE a.allergy = :allergy"),
    @NamedQuery(name = "Atecedent.findByAgo", query = "SELECT a FROM Atecedent a WHERE a.ago = :ago")})
public class Atecedent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_antecedent")
    private Integer idAntecedent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIME)
    private Date updateAt;
    @Size(max = 200)
    @Column(name = "personal_ant")
    private String personalAnt;
    @Size(max = 200)
    @Column(name = "surgical_ant")
    private String surgicalAnt;
    @Size(max = 200)
    @Column(name = "damily_ant")
    private String damilyAnt;
    @Size(max = 200)
    @Column(name = "profesional_ant")
    private String profesionalAnt;
    @Size(max = 200)
    @Column(name = "habit")
    private String habit;
    @Size(max = 200)
    @Column(name = "clinical")
    private String clinical;
    @Size(max = 200)
    @Column(name = "trauma")
    private String trauma;
    @Size(max = 200)
    @Column(name = "allergy")
    private String allergy;
    @Size(max = 200)
    @Column(name = "ago")
    private String ago;
    @JoinColumn(name = "patient_id", referencedColumnName = "id_patient")
    @ManyToOne
    private Patient patientId;

    public Atecedent() {
    }

    public Atecedent(Integer idAntecedent) {
        this.idAntecedent = idAntecedent;
    }

    public Atecedent(Integer idAntecedent, Date createAt) {
        this.idAntecedent = idAntecedent;
        this.createAt = createAt;
    }

    public Integer getIdAntecedent() {
        return idAntecedent;
    }

    public void setIdAntecedent(Integer idAntecedent) {
        this.idAntecedent = idAntecedent;
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

    public String getPersonalAnt() {
        return personalAnt;
    }

    public void setPersonalAnt(String personalAnt) {
        this.personalAnt = personalAnt;
    }

    public String getSurgicalAnt() {
        return surgicalAnt;
    }

    public void setSurgicalAnt(String surgicalAnt) {
        this.surgicalAnt = surgicalAnt;
    }

    public String getDamilyAnt() {
        return damilyAnt;
    }

    public void setDamilyAnt(String damilyAnt) {
        this.damilyAnt = damilyAnt;
    }

    public String getProfesionalAnt() {
        return profesionalAnt;
    }

    public void setProfesionalAnt(String profesionalAnt) {
        this.profesionalAnt = profesionalAnt;
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit;
    }

    public String getClinical() {
        return clinical;
    }

    public void setClinical(String clinical) {
        this.clinical = clinical;
    }

    public String getTrauma() {
        return trauma;
    }

    public void setTrauma(String trauma) {
        this.trauma = trauma;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getAgo() {
        return ago;
    }

    public void setAgo(String ago) {
        this.ago = ago;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAntecedent != null ? idAntecedent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atecedent)) {
            return false;
        }
        Atecedent other = (Atecedent) object;
        if ((this.idAntecedent == null && other.idAntecedent != null) || (this.idAntecedent != null && !this.idAntecedent.equals(other.idAntecedent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Atecedent[ idAntecedent=" + idAntecedent + " ]";
    }
    
}
