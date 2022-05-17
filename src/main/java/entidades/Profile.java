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
@Table(name = "profile")
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByIdProfile", query = "SELECT p FROM Profile p WHERE p.idProfile = :idProfile"),
    @NamedQuery(name = "Profile.findByCreateAt", query = "SELECT p FROM Profile p WHERE p.createAt = :createAt"),
    @NamedQuery(name = "Profile.findByUpdateAt", query = "SELECT p FROM Profile p WHERE p.updateAt = :updateAt"),
    @NamedQuery(name = "Profile.findByDeleteAt", query = "SELECT p FROM Profile p WHERE p.deleteAt = :deleteAt"),
    @NamedQuery(name = "Profile.findByDni", query = "SELECT p FROM Profile p WHERE p.dni = :dni"),
    @NamedQuery(name = "Profile.findByFirstname", query = "SELECT p FROM Profile p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Profile.findByLastname", query = "SELECT p FROM Profile p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Profile.findByPassport", query = "SELECT p FROM Profile p WHERE p.passport = :passport"),
    @NamedQuery(name = "Profile.findByTelephone", query = "SELECT p FROM Profile p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Profile.findByMobile", query = "SELECT p FROM Profile p WHERE p.mobile = :mobile"),
    @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email"),
    @NamedQuery(name = "Profile.findByAddress", query = "SELECT p FROM Profile p WHERE p.address = :address"),
    @NamedQuery(name = "Profile.findByImage", query = "SELECT p FROM Profile p WHERE p.image = :image")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_profile")
    private Integer idProfile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIME)
    private Date updateAt;
    @Column(name = "delete_at")
    private Boolean deleteAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lastname")
    private String lastname;
    @Size(max = 13)
    @Column(name = "passport")
    private String passport;
    @Size(max = 10)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "idProfile")
    private Collection<Tuser> tuserCollection;

    public Profile() {
    }

    public Profile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public Profile(Integer idProfile, Date createAt, String dni, String firstname, String lastname, String mobile, String email, String address) {
        this.idProfile = idProfile;
        this.createAt = createAt;
        this.dni = dni;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
    }

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
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

    public Boolean getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Boolean deleteAt) {
        this.deleteAt = deleteAt;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Tuser> getTuserCollection() {
        return tuserCollection;
    }

    public void setTuserCollection(Collection<Tuser> tuserCollection) {
        this.tuserCollection = tuserCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProfile != null ? idProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.idProfile == null && other.idProfile != null) || (this.idProfile != null && !this.idProfile.equals(other.idProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstname+" " + lastname;
    }
    
}
