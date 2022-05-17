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
@Table(name = "tuser")
@NamedQueries({
    @NamedQuery(name = "Tuser.findAll", query = "SELECT t FROM Tuser t"),
    @NamedQuery(name = "Tuser.findByIdUser", query = "SELECT t FROM Tuser t WHERE t.idUser = :idUser"),
    @NamedQuery(name = "Tuser.findByCreateAt", query = "SELECT t FROM Tuser t WHERE t.createAt = :createAt"),
    @NamedQuery(name = "Tuser.findByDeleteAt", query = "SELECT t FROM Tuser t WHERE t.deleteAt = :deleteAt"),
    @NamedQuery(name = "Tuser.findByEditAt", query = "SELECT t FROM Tuser t WHERE t.editAt = :editAt"),
    @NamedQuery(name = "Tuser.findByEditBy", query = "SELECT t FROM Tuser t WHERE t.editBy = :editBy"),
    @NamedQuery(name = "Tuser.findByDeleteBy", query = "SELECT t FROM Tuser t WHERE t.deleteBy = :deleteBy"),
    @NamedQuery(name = "Tuser.findByVerificationEmail", query = "SELECT t FROM Tuser t WHERE t.verificationEmail = :verificationEmail"),
    @NamedQuery(name = "Tuser.findByIsActive", query = "SELECT t FROM Tuser t WHERE t.isActive = :isActive"),
    @NamedQuery(name = "Tuser.findByPassword", query = "SELECT t FROM Tuser t WHERE t.password = :password")})
public class Tuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "delete_at")
    @Temporal(TemporalType.TIME)
    private Date deleteAt;
    @Column(name = "edit_at")
    @Temporal(TemporalType.TIME)
    private Date editAt;
    @Column(name = "edit_by")
    @Temporal(TemporalType.TIME)
    private Date editBy;
    @Column(name = "delete_by")
    @Temporal(TemporalType.TIME)
    private Date deleteBy;
    @Column(name = "verification_email")
    private Boolean verificationEmail;
    @Column(name = "is_active")
    private Boolean isActive;
    @Size(max = 32)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "id_profile", referencedColumnName = "id_profile")
    @ManyToOne
    private Profile idProfile;
    @JoinColumn(name = "role_id", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Role roleId;
    @OneToMany(mappedBy = "idUser")
    private Collection<Medic> medicCollection;

    public Tuser() {
    }

    public Tuser(Integer idUser) {
        this.idUser = idUser;
    }

    public Tuser(Integer idUser, Date createAt) {
        this.idUser = idUser;
        this.createAt = createAt;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    public Date getEditAt() {
        return editAt;
    }

    public void setEditAt(Date editAt) {
        this.editAt = editAt;
    }

    public Date getEditBy() {
        return editBy;
    }

    public void setEditBy(Date editBy) {
        this.editBy = editBy;
    }

    public Date getDeleteBy() {
        return deleteBy;
    }

    public void setDeleteBy(Date deleteBy) {
        this.deleteBy = deleteBy;
    }

    public Boolean getVerificationEmail() {
        return verificationEmail;
    }

    public void setVerificationEmail(Boolean verificationEmail) {
        this.verificationEmail = verificationEmail;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Profile idProfile) {
        this.idProfile = idProfile;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Collection<Medic> getMedicCollection() {
        return medicCollection;
    }

    public void setMedicCollection(Collection<Medic> medicCollection) {
        this.medicCollection = medicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tuser)) {
            return false;
        }
        Tuser other = (Tuser) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tuser[ idUser=" + idUser + " ]";
    }
    
}
