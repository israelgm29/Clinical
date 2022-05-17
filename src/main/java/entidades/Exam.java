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
@Table(name = "exam")
@NamedQueries({
    @NamedQuery(name = "Exam.findAll", query = "SELECT e FROM Exam e"),
    @NamedQuery(name = "Exam.findByIdExam", query = "SELECT e FROM Exam e WHERE e.idExam = :idExam"),
    @NamedQuery(name = "Exam.findByCreateAt", query = "SELECT e FROM Exam e WHERE e.createAt = :createAt"),
    @NamedQuery(name = "Exam.findByEditAt", query = "SELECT e FROM Exam e WHERE e.editAt = :editAt"),
    @NamedQuery(name = "Exam.findByName", query = "SELECT e FROM Exam e WHERE e.name = :name")})
public class Exam implements Serializable {

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
    @Column(name = "edit_at")
    @Temporal(TemporalType.TIME)
    private Date editAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "examtype_id", referencedColumnName = "id_examtype")
    @ManyToOne
    private Examtype examtypeId;
    @OneToMany(mappedBy = "examId")
    private Collection<Medicalexam> medicalexamCollection;

    public Exam() {
    }

    public Exam(Integer idExam) {
        this.idExam = idExam;
    }

    public Exam(Integer idExam, Date createAt, String name) {
        this.idExam = idExam;
        this.createAt = createAt;
        this.name = name;
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

    public Date getEditAt() {
        return editAt;
    }

    public void setEditAt(Date editAt) {
        this.editAt = editAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Examtype getExamtypeId() {
        return examtypeId;
    }

    public void setExamtypeId(Examtype examtypeId) {
        this.examtypeId = examtypeId;
    }

    public Collection<Medicalexam> getMedicalexamCollection() {
        return medicalexamCollection;
    }

    public void setMedicalexamCollection(Collection<Medicalexam> medicalexamCollection) {
        this.medicalexamCollection = medicalexamCollection;
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
        if (!(object instanceof Exam)) {
            return false;
        }
        Exam other = (Exam) object;
        if ((this.idExam == null && other.idExam != null) || (this.idExam != null && !this.idExam.equals(other.idExam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Exam[ idExam=" + idExam + " ]";
    }
    
}
