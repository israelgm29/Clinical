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
@Table(name = "permision")
@NamedQueries({
    @NamedQuery(name = "Permision.findAll", query = "SELECT p FROM Permision p"),
    @NamedQuery(name = "Permision.findByIdPermision", query = "SELECT p FROM Permision p WHERE p.idPermision = :idPermision"),
    @NamedQuery(name = "Permision.findByCre", query = "SELECT p FROM Permision p WHERE p.cre = :cre"),
    @NamedQuery(name = "Permision.findByRe", query = "SELECT p FROM Permision p WHERE p.re = :re"),
    @NamedQuery(name = "Permision.findByUp", query = "SELECT p FROM Permision p WHERE p.up = :up"),
    @NamedQuery(name = "Permision.findByWri", query = "SELECT p FROM Permision p WHERE p.wri = :wri")})
public class Permision implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_permision")
    private Integer idPermision;
    @Column(name = "cre")
    private Boolean cre;
    @Column(name = "re")
    private Boolean re;
    @Column(name = "up")
    private Boolean up;
    @Column(name = "wri")
    private Boolean wri;
    @JoinColumn(name = "module_id", referencedColumnName = "id_module")
    @ManyToOne
    private Module moduleId;
    @JoinColumn(name = "role_id", referencedColumnName = "id_rol")
    @ManyToOne
    private Role roleId;

    public Permision() {
    }

    public Permision(Integer idPermision) {
        this.idPermision = idPermision;
    }

    public Integer getIdPermision() {
        return idPermision;
    }

    public void setIdPermision(Integer idPermision) {
        this.idPermision = idPermision;
    }

    public Boolean getCre() {
        return cre;
    }

    public void setCre(Boolean cre) {
        this.cre = cre;
    }

    public Boolean getRe() {
        return re;
    }

    public void setRe(Boolean re) {
        this.re = re;
    }

    public Boolean getUp() {
        return up;
    }

    public void setUp(Boolean up) {
        this.up = up;
    }

    public Boolean getWri() {
        return wri;
    }

    public void setWri(Boolean wri) {
        this.wri = wri;
    }

    public Module getModuleId() {
        return moduleId;
    }

    public void setModuleId(Module moduleId) {
        this.moduleId = moduleId;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermision != null ? idPermision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permision)) {
            return false;
        }
        Permision other = (Permision) object;
        if ((this.idPermision == null && other.idPermision != null) || (this.idPermision != null && !this.idPermision.equals(other.idPermision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Permision[ idPermision=" + idPermision + " ]";
    }
    
}
