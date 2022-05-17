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

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "specialist")
@NamedQueries({
    @NamedQuery(name = "Specialist.findAll", query = "SELECT s FROM Specialist s"),
    @NamedQuery(name = "Specialist.findByIdSpecialist", query = "SELECT s FROM Specialist s WHERE s.idSpecialist = :idSpecialist")})
public class Specialist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_specialist")
    private Integer idSpecialist;
    @JoinColumn(name = "medic_id", referencedColumnName = "id_medic")
    @ManyToOne
    private Medic medicId;
    @JoinColumn(name = "medic_specialist", referencedColumnName = "id")
    @ManyToOne
    private Medicalspecialis medicSpecialist;

    public Specialist() {
    }

    public Specialist(Integer idSpecialist) {
        this.idSpecialist = idSpecialist;
    }

    public Integer getIdSpecialist() {
        return idSpecialist;
    }

    public void setIdSpecialist(Integer idSpecialist) {
        this.idSpecialist = idSpecialist;
    }

    public Medic getMedicId() {
        return medicId;
    }

    public void setMedicId(Medic medicId) {
        this.medicId = medicId;
    }

    public Medicalspecialis getMedicSpecialist() {
        return medicSpecialist;
    }

    public void setMedicSpecialist(Medicalspecialis medicSpecialist) {
        this.medicSpecialist = medicSpecialist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpecialist != null ? idSpecialist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialist)) {
            return false;
        }
        Specialist other = (Specialist) object;
        if ((this.idSpecialist == null && other.idSpecialist != null) || (this.idSpecialist != null && !this.idSpecialist.equals(other.idSpecialist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return medicSpecialist.getName();
    }
    
}
