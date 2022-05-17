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

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "diagnostic")
@NamedQueries({
    @NamedQuery(name = "Diagnostic.findAll", query = "SELECT d FROM Diagnostic d"),
    @NamedQuery(name = "Diagnostic.findByIdDiagnostic", query = "SELECT d FROM Diagnostic d WHERE d.idDiagnostic = :idDiagnostic"),
    @NamedQuery(name = "Diagnostic.findByCreateAt", query = "SELECT d FROM Diagnostic d WHERE d.createAt = :createAt"),
    @NamedQuery(name = "Diagnostic.findByCreateBy", query = "SELECT d FROM Diagnostic d WHERE d.createBy = :createBy"),
    @NamedQuery(name = "Diagnostic.findByUpdateAt", query = "SELECT d FROM Diagnostic d WHERE d.updateAt = :updateAt"),
    @NamedQuery(name = "Diagnostic.findByUpdateBy", query = "SELECT d FROM Diagnostic d WHERE d.updateBy = :updateBy")})
public class Diagnostic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_diagnostic")
    private Integer idDiagnostic;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "create_by")
    private Integer createBy;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIME)
    private Date updateAt;
    @Column(name = "update_by")
    private Integer updateBy;
    @JoinColumn(name = "diseas_id", referencedColumnName = "id_disease")
    @ManyToOne
    private Disease diseasId;
    @JoinColumn(name = "mediacalrecord_id", referencedColumnName = "id_medicalrecord")
    @ManyToOne
    private Medicalrecord mediacalrecordId;

    public Diagnostic() {
    }

    public Diagnostic(Integer idDiagnostic) {
        this.idDiagnostic = idDiagnostic;
    }

    public Integer getIdDiagnostic() {
        return idDiagnostic;
    }

    public void setIdDiagnostic(Integer idDiagnostic) {
        this.idDiagnostic = idDiagnostic;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Disease getDiseasId() {
        return diseasId;
    }

    public void setDiseasId(Disease diseasId) {
        this.diseasId = diseasId;
    }

    public Medicalrecord getMediacalrecordId() {
        return mediacalrecordId;
    }

    public void setMediacalrecordId(Medicalrecord mediacalrecordId) {
        this.mediacalrecordId = mediacalrecordId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiagnostic != null ? idDiagnostic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostic)) {
            return false;
        }
        Diagnostic other = (Diagnostic) object;
        if ((this.idDiagnostic == null && other.idDiagnostic != null) || (this.idDiagnostic != null && !this.idDiagnostic.equals(other.idDiagnostic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Diagnostic[ idDiagnostic=" + idDiagnostic + " ]";
    }
    
}
