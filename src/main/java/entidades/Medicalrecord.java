/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "medicalrecord")
@NamedQueries({
    @NamedQuery(name = "Medicalrecord.findAll", query = "SELECT m FROM Medicalrecord m"),
    @NamedQuery(name = "Medicalrecord.findByIdMedicalrecord", query = "SELECT m FROM Medicalrecord m WHERE m.idMedicalrecord = :idMedicalrecord"),
    @NamedQuery(name = "Medicalrecord.findByCreateAt", query = "SELECT m FROM Medicalrecord m WHERE m.createAt = :createAt"),
    @NamedQuery(name = "Medicalrecord.findByEditAt", query = "SELECT m FROM Medicalrecord m WHERE m.editAt = :editAt"),
    @NamedQuery(name = "Medicalrecord.findByDelete", query = "SELECT m FROM Medicalrecord m WHERE m.delete = :delete"),
    @NamedQuery(name = "Medicalrecord.findByReason", query = "SELECT m FROM Medicalrecord m WHERE m.reason = :reason"),
    @NamedQuery(name = "Medicalrecord.findByCurrentIllness", query = "SELECT m FROM Medicalrecord m WHERE m.currentIllness = :currentIllness"),
    @NamedQuery(name = "Medicalrecord.findByDone", query = "SELECT m FROM Medicalrecord m WHERE m.done = :done"),
    @NamedQuery(name = "Medicalrecord.findByCanceled", query = "SELECT m FROM Medicalrecord m WHERE m.canceled = :canceled")})
public class Medicalrecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medicalrecord")
    private Integer idMedicalrecord;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "edit_at")
    @Temporal(TemporalType.TIME)
    private Date editAt;
    @Column(name = "delete")
    private Boolean delete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "reason")
    private String reason;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "current_illness")
    private String currentIllness;
    @Column(name = "done")
    private Boolean done;
    @Column(name = "canceled")
    private Boolean canceled;
    @OneToMany(mappedBy = "medicalrecordId")
    private Collection<Rpe> rpeCollection;
    @JoinColumn(name = "medic_id", referencedColumnName = "id_medic")
    @ManyToOne(optional = false)
    private Medic medicId;
    @JoinColumn(name = "patient_id", referencedColumnName = "id_patient")
    @ManyToOne(optional = false)
    private Patient patientId;
    @OneToMany(mappedBy = "medicalrecordId")
    private Collection<Cross> crossCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalrecordId")
    private Collection<Vitalsign> vitalsignCollection;
    @OneToMany(mappedBy = "medicalrecordId")
    private Collection<Medicalexam> medicalexamCollection;
    @OneToMany(mappedBy = "mediacalrecordId")
    private Collection<Diagnostic> diagnosticCollection;

    public Medicalrecord() {
    }

    public Medicalrecord(Integer idMedicalrecord) {
        this.idMedicalrecord = idMedicalrecord;
    }

    public Medicalrecord(Integer idMedicalrecord, String reason, String currentIllness) {
        this.idMedicalrecord = idMedicalrecord;
        this.reason = reason;
        this.currentIllness = currentIllness;
    }

    public Integer getIdMedicalrecord() {
        return idMedicalrecord;
    }

    public void setIdMedicalrecord(Integer idMedicalrecord) {
        this.idMedicalrecord = idMedicalrecord;
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

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCurrentIllness() {
        return currentIllness;
    }

    public void setCurrentIllness(String currentIllness) {
        this.currentIllness = currentIllness;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public Collection<Rpe> getRpeCollection() {
        return rpeCollection;
    }

    public void setRpeCollection(Collection<Rpe> rpeCollection) {
        this.rpeCollection = rpeCollection;
    }

    public Medic getMedicId() {
        return medicId;
    }

    public void setMedicId(Medic medicId) {
        this.medicId = medicId;
    }

    public Patient getPatientId() {
        return patientId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public Collection<Cross> getCrossCollection() {
        return crossCollection;
    }

    public void setCrossCollection(Collection<Cross> crossCollection) {
        this.crossCollection = crossCollection;
    }

    public Collection<Vitalsign> getVitalsignCollection() {
        return vitalsignCollection;
    }

    public void setVitalsignCollection(Collection<Vitalsign> vitalsignCollection) {
        this.vitalsignCollection = vitalsignCollection;
    }

    public Collection<Medicalexam> getMedicalexamCollection() {
        return medicalexamCollection;
    }

    public void setMedicalexamCollection(Collection<Medicalexam> medicalexamCollection) {
        this.medicalexamCollection = medicalexamCollection;
    }

    public Collection<Diagnostic> getDiagnosticCollection() {
        return diagnosticCollection;
    }

    public void setDiagnosticCollection(Collection<Diagnostic> diagnosticCollection) {
        this.diagnosticCollection = diagnosticCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedicalrecord != null ? idMedicalrecord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalrecord)) {
            return false;
        }
        Medicalrecord other = (Medicalrecord) object;
        if ((this.idMedicalrecord == null && other.idMedicalrecord != null) || (this.idMedicalrecord != null && !this.idMedicalrecord.equals(other.idMedicalrecord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Medicalrecord[ idMedicalrecord=" + idMedicalrecord + " ]";
    }
    
}
