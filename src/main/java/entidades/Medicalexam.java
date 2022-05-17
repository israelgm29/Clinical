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

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "medicalexam")
@NamedQueries({
    @NamedQuery(name = "Medicalexam.findAll", query = "SELECT m FROM Medicalexam m"),
    @NamedQuery(name = "Medicalexam.findByIdExam", query = "SELECT m FROM Medicalexam m WHERE m.idExam = :idExam"),
    @NamedQuery(name = "Medicalexam.findByCreateAt", query = "SELECT m FROM Medicalexam m WHERE m.createAt = :createAt")})
public class Medicalexam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_exam")
    private Integer idExam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @JoinColumn(name = "exam_id", referencedColumnName = "id_exam")
    @ManyToOne
    private Exam examId;
    @JoinColumn(name = "medicalrecord_id", referencedColumnName = "id_medicalrecord")
    @ManyToOne
    private Medicalrecord medicalrecordId;

    public Medicalexam() {
    }

    public Medicalexam(Integer idExam) {
        this.idExam = idExam;
    }

    public Medicalexam(Integer idExam, Date createAt) {
        this.idExam = idExam;
        this.createAt = createAt;
    }

    public Integer getIdExam() {
        return idExam;
    }

    public void setIdExam(Integer idExam) {
        this.idExam = idExam;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Exam getExamId() {
        return examId;
    }

    public void setExamId(Exam examId) {
        this.examId = examId;
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
        hash += (idExam != null ? idExam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicalexam)) {
            return false;
        }
        Medicalexam other = (Medicalexam) object;
        if ((this.idExam == null && other.idExam != null) || (this.idExam != null && !this.idExam.equals(other.idExam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Medicalexam[ idExam=" + idExam + " ]";
    }
    
}
