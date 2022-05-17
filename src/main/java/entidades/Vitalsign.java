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
@Table(name = "vitalsign")
@NamedQueries({
    @NamedQuery(name = "Vitalsign.findAll", query = "SELECT v FROM Vitalsign v"),
    @NamedQuery(name = "Vitalsign.findByIdVitalsig", query = "SELECT v FROM Vitalsign v WHERE v.idVitalsig = :idVitalsig"),
    @NamedQuery(name = "Vitalsign.findByCreatedAt", query = "SELECT v FROM Vitalsign v WHERE v.createdAt = :createdAt"),
    @NamedQuery(name = "Vitalsign.findByUpdateAt", query = "SELECT v FROM Vitalsign v WHERE v.updateAt = :updateAt"),
    @NamedQuery(name = "Vitalsign.findByTemperature", query = "SELECT v FROM Vitalsign v WHERE v.temperature = :temperature"),
    @NamedQuery(name = "Vitalsign.findBySystolicpresure", query = "SELECT v FROM Vitalsign v WHERE v.systolicpresure = :systolicpresure"),
    @NamedQuery(name = "Vitalsign.findByDiastolicpresure", query = "SELECT v FROM Vitalsign v WHERE v.diastolicpresure = :diastolicpresure"),
    @NamedQuery(name = "Vitalsign.findByPulse", query = "SELECT v FROM Vitalsign v WHERE v.pulse = :pulse"),
    @NamedQuery(name = "Vitalsign.findByBreathingfrecuency", query = "SELECT v FROM Vitalsign v WHERE v.breathingfrecuency = :breathingfrecuency"),
    @NamedQuery(name = "Vitalsign.findByOxygensaturation", query = "SELECT v FROM Vitalsign v WHERE v.oxygensaturation = :oxygensaturation"),
    @NamedQuery(name = "Vitalsign.findByTall", query = "SELECT v FROM Vitalsign v WHERE v.tall = :tall"),
    @NamedQuery(name = "Vitalsign.findByWeight", query = "SELECT v FROM Vitalsign v WHERE v.weight = :weight"),
    @NamedQuery(name = "Vitalsign.findByMass", query = "SELECT v FROM Vitalsign v WHERE v.mass = :mass")})
public class Vitalsign implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_vitalsig")
    private Integer idVitalsig;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIME)
    private Date createdAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIME)
    private Date updateAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temperature")
    private double temperature;
    @Basic(optional = false)
    @NotNull
    @Column(name = "systolicpresure")
    private double systolicpresure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diastolicpresure")
    private double diastolicpresure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pulse")
    private double pulse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "breathingfrecuency")
    private double breathingfrecuency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oxygensaturation")
    private double oxygensaturation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tall")
    private double tall;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private double weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mass")
    private double mass;
    @JoinColumn(name = "medicalrecord_id", referencedColumnName = "id_medicalrecord")
    @ManyToOne(optional = false)
    private Medicalrecord medicalrecordId;

    public Vitalsign() {
    }

    public Vitalsign(Integer idVitalsig) {
        this.idVitalsig = idVitalsig;
    }

    public Vitalsign(Integer idVitalsig, Date createdAt, double temperature, double systolicpresure, double diastolicpresure, double pulse, double breathingfrecuency, double oxygensaturation, double tall, double weight, double mass) {
        this.idVitalsig = idVitalsig;
        this.createdAt = createdAt;
        this.temperature = temperature;
        this.systolicpresure = systolicpresure;
        this.diastolicpresure = diastolicpresure;
        this.pulse = pulse;
        this.breathingfrecuency = breathingfrecuency;
        this.oxygensaturation = oxygensaturation;
        this.tall = tall;
        this.weight = weight;
        this.mass = mass;
    }

    public Integer getIdVitalsig() {
        return idVitalsig;
    }

    public void setIdVitalsig(Integer idVitalsig) {
        this.idVitalsig = idVitalsig;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getSystolicpresure() {
        return systolicpresure;
    }

    public void setSystolicpresure(double systolicpresure) {
        this.systolicpresure = systolicpresure;
    }

    public double getDiastolicpresure() {
        return diastolicpresure;
    }

    public void setDiastolicpresure(double diastolicpresure) {
        this.diastolicpresure = diastolicpresure;
    }

    public double getPulse() {
        return pulse;
    }

    public void setPulse(double pulse) {
        this.pulse = pulse;
    }

    public double getBreathingfrecuency() {
        return breathingfrecuency;
    }

    public void setBreathingfrecuency(double breathingfrecuency) {
        this.breathingfrecuency = breathingfrecuency;
    }

    public double getOxygensaturation() {
        return oxygensaturation;
    }

    public void setOxygensaturation(double oxygensaturation) {
        this.oxygensaturation = oxygensaturation;
    }

    public double getTall() {
        return tall;
    }

    public void setTall(double tall) {
        this.tall = tall;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
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
        hash += (idVitalsig != null ? idVitalsig.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vitalsign)) {
            return false;
        }
        Vitalsign other = (Vitalsign) object;
        if ((this.idVitalsig == null && other.idVitalsig != null) || (this.idVitalsig != null && !this.idVitalsig.equals(other.idVitalsig))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Vitalsign[ idVitalsig=" + idVitalsig + " ]";
    }
    
}
