/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "cross")
@NamedQueries({
    @NamedQuery(name = "Cross.findAll", query = "SELECT c FROM Cross c"),
    @NamedQuery(name = "Cross.findByIdCross", query = "SELECT c FROM Cross c WHERE c.idCross = :idCross"),
    @NamedQuery(name = "Cross.findBySenseorgans", query = "SELECT c FROM Cross c WHERE c.senseorgans = :senseorgans"),
    @NamedQuery(name = "Cross.findByRespiratory", query = "SELECT c FROM Cross c WHERE c.respiratory = :respiratory"),
    @NamedQuery(name = "Cross.findByCardiovascular", query = "SELECT c FROM Cross c WHERE c.cardiovascular = :cardiovascular"),
    @NamedQuery(name = "Cross.findByDigestive", query = "SELECT c FROM Cross c WHERE c.digestive = :digestive"),
    @NamedQuery(name = "Cross.findByGenital", query = "SELECT c FROM Cross c WHERE c.genital = :genital"),
    @NamedQuery(name = "Cross.findByUrinary", query = "SELECT c FROM Cross c WHERE c.urinary = :urinary"),
    @NamedQuery(name = "Cross.findBySkeletalmuscle", query = "SELECT c FROM Cross c WHERE c.skeletalmuscle = :skeletalmuscle"),
    @NamedQuery(name = "Cross.findByEndocrine", query = "SELECT c FROM Cross c WHERE c.endocrine = :endocrine"),
    @NamedQuery(name = "Cross.findByLymphatic", query = "SELECT c FROM Cross c WHERE c.lymphatic = :lymphatic"),
    @NamedQuery(name = "Cross.findByNervious", query = "SELECT c FROM Cross c WHERE c.nervious = :nervious"),
    @NamedQuery(name = "Cross.findByObservation", query = "SELECT c FROM Cross c WHERE c.observation = :observation")})
public class Cross implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cross")
    private Integer idCross;
    @Column(name = "senseorgans")
    private Boolean senseorgans;
    @Column(name = "respiratory")
    private Boolean respiratory;
    @Column(name = "cardiovascular")
    private Boolean cardiovascular;
    @Column(name = "digestive")
    private Boolean digestive;
    @Column(name = "genital")
    private Boolean genital;
    @Column(name = "urinary")
    private Boolean urinary;
    @Column(name = "skeletalmuscle")
    private Boolean skeletalmuscle;
    @Column(name = "endocrine")
    private Boolean endocrine;
    @Column(name = "lymphatic")
    private Boolean lymphatic;
    @Column(name = "nervious")
    private Boolean nervious;
    @Size(max = 2147483647)
    @Column(name = "observation")
    private String observation;
    @JoinColumn(name = "medicalrecord_id", referencedColumnName = "id_medicalrecord")
    @ManyToOne
    private Medicalrecord medicalrecordId;

    public Cross() {
    }

    public Cross(Integer idCross) {
        this.idCross = idCross;
    }

    public Integer getIdCross() {
        return idCross;
    }

    public void setIdCross(Integer idCross) {
        this.idCross = idCross;
    }

    public Boolean getSenseorgans() {
        return senseorgans;
    }

    public void setSenseorgans(Boolean senseorgans) {
        this.senseorgans = senseorgans;
    }

    public Boolean getRespiratory() {
        return respiratory;
    }

    public void setRespiratory(Boolean respiratory) {
        this.respiratory = respiratory;
    }

    public Boolean getCardiovascular() {
        return cardiovascular;
    }

    public void setCardiovascular(Boolean cardiovascular) {
        this.cardiovascular = cardiovascular;
    }

    public Boolean getDigestive() {
        return digestive;
    }

    public void setDigestive(Boolean digestive) {
        this.digestive = digestive;
    }

    public Boolean getGenital() {
        return genital;
    }

    public void setGenital(Boolean genital) {
        this.genital = genital;
    }

    public Boolean getUrinary() {
        return urinary;
    }

    public void setUrinary(Boolean urinary) {
        this.urinary = urinary;
    }

    public Boolean getSkeletalmuscle() {
        return skeletalmuscle;
    }

    public void setSkeletalmuscle(Boolean skeletalmuscle) {
        this.skeletalmuscle = skeletalmuscle;
    }

    public Boolean getEndocrine() {
        return endocrine;
    }

    public void setEndocrine(Boolean endocrine) {
        this.endocrine = endocrine;
    }

    public Boolean getLymphatic() {
        return lymphatic;
    }

    public void setLymphatic(Boolean lymphatic) {
        this.lymphatic = lymphatic;
    }

    public Boolean getNervious() {
        return nervious;
    }

    public void setNervious(Boolean nervious) {
        this.nervious = nervious;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Medicalrecord getMedicalrecordId() {
        return medicalrecordId;
    }

    public void setMedicalrecordId(Medicalrecord medicalrecordId) {
        this.medicalrecordId = medicalrecordId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCross != null ? idCross.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cross)) {
            return false;
        }
        Cross other = (Cross) object;
        if ((this.idCross == null && other.idCross != null) || (this.idCross != null && !this.idCross.equals(other.idCross))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Cross[ idCross=" + idCross + " ]";
    }
    
}
