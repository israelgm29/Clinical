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
@Table(name = "rpe")
@NamedQueries({
    @NamedQuery(name = "Rpe.findAll", query = "SELECT r FROM Rpe r"),
    @NamedQuery(name = "Rpe.findByIdRep", query = "SELECT r FROM Rpe r WHERE r.idRep = :idRep"),
    @NamedQuery(name = "Rpe.findByCreateAt", query = "SELECT r FROM Rpe r WHERE r.createAt = :createAt"),
    @NamedQuery(name = "Rpe.findByUpdateAt", query = "SELECT r FROM Rpe r WHERE r.updateAt = :updateAt"),
    @NamedQuery(name = "Rpe.findByHead", query = "SELECT r FROM Rpe r WHERE r.head = :head"),
    @NamedQuery(name = "Rpe.findByNeck", query = "SELECT r FROM Rpe r WHERE r.neck = :neck"),
    @NamedQuery(name = "Rpe.findByChest", query = "SELECT r FROM Rpe r WHERE r.chest = :chest"),
    @NamedQuery(name = "Rpe.findByAbdomen", query = "SELECT r FROM Rpe r WHERE r.abdomen = :abdomen"),
    @NamedQuery(name = "Rpe.findByPelvis", query = "SELECT r FROM Rpe r WHERE r.pelvis = :pelvis"),
    @NamedQuery(name = "Rpe.findByExtremities", query = "SELECT r FROM Rpe r WHERE r.extremities = :extremities"),
    @NamedQuery(name = "Rpe.findByObservation", query = "SELECT r FROM Rpe r WHERE r.observation = :observation")})
public class Rpe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rep")
    private Integer idRep;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIME)
    private Date updateAt;
    @Column(name = "head")
    private Boolean head;
    @Column(name = "neck")
    private Boolean neck;
    @Column(name = "chest")
    private Boolean chest;
    @Column(name = "abdomen")
    private Boolean abdomen;
    @Column(name = "pelvis")
    private Boolean pelvis;
    @Column(name = "extremities")
    private Boolean extremities;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "observation")
    private String observation;
    @JoinColumn(name = "medicalrecord_id", referencedColumnName = "id_medicalrecord")
    @ManyToOne
    private Medicalrecord medicalrecordId;

    public Rpe() {
    }

    public Rpe(Integer idRep) {
        this.idRep = idRep;
    }

    public Rpe(Integer idRep, String observation) {
        this.idRep = idRep;
        this.observation = observation;
    }

    public Integer getIdRep() {
        return idRep;
    }

    public void setIdRep(Integer idRep) {
        this.idRep = idRep;
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

    public Boolean getHead() {
        return head;
    }

    public void setHead(Boolean head) {
        this.head = head;
    }

    public Boolean getNeck() {
        return neck;
    }

    public void setNeck(Boolean neck) {
        this.neck = neck;
    }

    public Boolean getChest() {
        return chest;
    }

    public void setChest(Boolean chest) {
        this.chest = chest;
    }

    public Boolean getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(Boolean abdomen) {
        this.abdomen = abdomen;
    }

    public Boolean getPelvis() {
        return pelvis;
    }

    public void setPelvis(Boolean pelvis) {
        this.pelvis = pelvis;
    }

    public Boolean getExtremities() {
        return extremities;
    }

    public void setExtremities(Boolean extremities) {
        this.extremities = extremities;
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
        hash += (idRep != null ? idRep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rpe)) {
            return false;
        }
        Rpe other = (Rpe) object;
        if ((this.idRep == null && other.idRep != null) || (this.idRep != null && !this.idRep.equals(other.idRep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Rpe[ idRep=" + idRep + " ]";
    }
    
}
