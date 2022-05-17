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
@Table(name = "patient")
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p"),
    @NamedQuery(name = "Patient.findByIdPatient", query = "SELECT p FROM Patient p WHERE p.idPatient = :idPatient"),
    @NamedQuery(name = "Patient.findByCreateAt", query = "SELECT p FROM Patient p WHERE p.createAt = :createAt"),
    @NamedQuery(name = "Patient.findByEditAt", query = "SELECT p FROM Patient p WHERE p.editAt = :editAt"),
    @NamedQuery(name = "Patient.findByUpdateAt", query = "SELECT p FROM Patient p WHERE p.updateAt = :updateAt"),
    @NamedQuery(name = "Patient.findByDelete", query = "SELECT p FROM Patient p WHERE p.delete = :delete"),
    @NamedQuery(name = "Patient.findByDni", query = "SELECT p FROM Patient p WHERE p.dni = :dni"),
    @NamedQuery(name = "Patient.findByLastname", query = "SELECT p FROM Patient p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Patient.findByFirstname", query = "SELECT p FROM Patient p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Patient.findByPassport", query = "SELECT p FROM Patient p WHERE p.passport = :passport"),
    @NamedQuery(name = "Patient.findByHc", query = "SELECT p FROM Patient p WHERE p.hc = :hc"),
    @NamedQuery(name = "Patient.findByOcupation", query = "SELECT p FROM Patient p WHERE p.ocupation = :ocupation"),
    @NamedQuery(name = "Patient.findByBirthday", query = "SELECT p FROM Patient p WHERE p.birthday = :birthday"),
    @NamedQuery(name = "Patient.findByTelephone", query = "SELECT p FROM Patient p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Patient.findByMobile", query = "SELECT p FROM Patient p WHERE p.mobile = :mobile"),
    @NamedQuery(name = "Patient.findByEmail", query = "SELECT p FROM Patient p WHERE p.email = :email"),
    @NamedQuery(name = "Patient.findByAddress", query = "SELECT p FROM Patient p WHERE p.address = :address"),
    @NamedQuery(name = "Patient.findByBloodtype", query = "SELECT p FROM Patient p WHERE p.bloodtype = :bloodtype"),
    @NamedQuery(name = "Patient.findBySex", query = "SELECT p FROM Patient p WHERE p.sex = :sex"),
    @NamedQuery(name = "Patient.findByCivilstatus", query = "SELECT p FROM Patient p WHERE p.civilstatus = :civilstatus"),
    @NamedQuery(name = "Patient.findByImage", query = "SELECT p FROM Patient p WHERE p.image = :image")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_patient")
    private Integer idPatient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "edit_at")
    @Temporal(TemporalType.TIME)
    private Date editAt;
    @Column(name = "update_at")
    @Temporal(TemporalType.TIME)
    private Date updateAt;
    @Column(name = "delete")
    private Boolean delete;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "dni")
    private String dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 50)
    @Column(name = "passport")
    private String passport;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "hc")
    private String hc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ocupation")
    private String ocupation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Size(max = 13)
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "mobile")
    private String mobile;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "bloodtype")
    private String bloodtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "sex")
    private String sex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "civilstatus")
    private String civilstatus;
    @Size(max = 2147483647)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "patientId")
    private Collection<Atecedent> atecedentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Medicalrecord> medicalrecordCollection;

    public Patient() {
    }

    public Patient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Patient(Integer idPatient, Date createAt, String dni, String lastname, String firstname, String hc, String ocupation, Date birthday, String mobile, String address, String bloodtype, String sex, String civilstatus) {
        this.idPatient = idPatient;
        this.createAt = createAt;
        this.dni = dni;
        this.lastname = lastname;
        this.firstname = firstname;
        this.hc = hc;
        this.ocupation = ocupation;
        this.birthday = birthday;
        this.mobile = mobile;
        this.address = address;
        this.bloodtype = bloodtype;
        this.sex = sex;
        this.civilstatus = civilstatus;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
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

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getHc() {
        return hc;
    }

    public void setHc(String hc) {
        this.hc = hc;
    }

    public String getOcupation() {
        return ocupation;
    }

    public void setOcupation(String ocupation) {
        this.ocupation = ocupation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCivilstatus() {
        return civilstatus;
    }

    public void setCivilstatus(String civilstatus) {
        this.civilstatus = civilstatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Atecedent> getAtecedentCollection() {
        return atecedentCollection;
    }

    public void setAtecedentCollection(Collection<Atecedent> atecedentCollection) {
        this.atecedentCollection = atecedentCollection;
    }

    public Collection<Medicalrecord> getMedicalrecordCollection() {
        return medicalrecordCollection;
    }

    public void setMedicalrecordCollection(Collection<Medicalrecord> medicalrecordCollection) {
        this.medicalrecordCollection = medicalrecordCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPatient != null ? idPatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.idPatient == null && other.idPatient != null) || (this.idPatient != null && !this.idPatient.equals(other.idPatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstname+" "+lastname;
    }
    
}
