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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mainfrek
 */
@Entity
@Table(name = "disease")
@NamedQueries({
    @NamedQuery(name = "Disease.findAll", query = "SELECT d FROM Disease d"),
    @NamedQuery(name = "Disease.findByIdDisease", query = "SELECT d FROM Disease d WHERE d.idDisease = :idDisease"),
    @NamedQuery(name = "Disease.findByCode", query = "SELECT d FROM Disease d WHERE d.code = :code"),
    @NamedQuery(name = "Disease.findByName", query = "SELECT d FROM Disease d WHERE d.name = :name"),
    @NamedQuery(name = "Disease.findByDescription", query = "SELECT d FROM Disease d WHERE d.description = :description"),
    @NamedQuery(name = "Disease.findByActions", query = "SELECT d FROM Disease d WHERE d.actions = :actions")})
public class Disease implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disease")
    private Integer idDisease;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "actions")
    private String actions;
    @JoinColumn(name = "disease_id", referencedColumnName = "id_disease")
    @ManyToOne
    private Diseasetype diseaseId;
    @OneToMany(mappedBy = "diseasId")
    private Collection<Diagnostic> diagnosticCollection;

    public Disease() {
    }

    public Disease(Integer idDisease) {
        this.idDisease = idDisease;
    }

    public Disease(Integer idDisease, String code, String name, String description, String actions) {
        this.idDisease = idDisease;
        this.code = code;
        this.name = name;
        this.description = description;
        this.actions = actions;
    }

    public Integer getIdDisease() {
        return idDisease;
    }

    public void setIdDisease(Integer idDisease) {
        this.idDisease = idDisease;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public Diseasetype getDiseaseId() {
        return diseaseId;
    }

    public void setDiseaseId(Diseasetype diseaseId) {
        this.diseaseId = diseaseId;
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
        hash += (idDisease != null ? idDisease.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disease)) {
            return false;
        }
        Disease other = (Disease) object;
        if ((this.idDisease == null && other.idDisease != null) || (this.idDisease != null && !this.idDisease.equals(other.idDisease))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Disease[ idDisease=" + idDisease + " ]";
    }
    
}
