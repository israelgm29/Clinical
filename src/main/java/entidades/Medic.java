/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "medic")
@NamedQueries({
    @NamedQuery(name = "Medic.findAll", query = "SELECT m FROM Medic m"),
    @NamedQuery(name = "Medic.findByIdMedic", query = "SELECT m FROM Medic m WHERE m.idMedic = :idMedic"),
    @NamedQuery(name = "Medic.findByCreateAt", query = "SELECT m FROM Medic m WHERE m.createAt = :createAt"),
    @NamedQuery(name = "Medic.findByEditAt", query = "SELECT m FROM Medic m WHERE m.editAt = :editAt"),
    @NamedQuery(name = "Medic.findByDni", query = "SELECT m FROM Medic m WHERE m.dni = :dni"),
    @NamedQuery(name = "Medic.findByLastname", query = "SELECT m FROM Medic m WHERE m.lastname = :lastname"),
    @NamedQuery(name = "Medic.findByFirstname", query = "SELECT m FROM Medic m WHERE m.firstname = :firstname"),
    @NamedQuery(name = "Medic.findByPassport", query = "SELECT m FROM Medic m WHERE m.passport = :passport"),
    @NamedQuery(name = "Medic.findByTelephone", query = "SELECT m FROM Medic m WHERE m.telephone = :telephone"),
    @NamedQuery(name = "Medic.findByMobile", query = "SELECT m FROM Medic m WHERE m.mobile = :mobile"),
    @NamedQuery(name = "Medic.findByEmail", query = "SELECT m FROM Medic m WHERE m.email = :email"),
    @NamedQuery(name = "Medic.findByAddress", query = "SELECT m FROM Medic m WHERE m.address = :address"),
    @NamedQuery(name = "Medic.findByRegprofesional", query = "SELECT m FROM Medic m WHERE m.regprofesional = :regprofesional"),
    @NamedQuery(name = "Medic.findByImage", query = "SELECT m FROM Medic m WHERE m.image = :image")})
public class Medic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medic")
    private Integer idMedic;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIME)
    private Date createAt;
    @Column(name = "edit_at")
    @Temporal(TemporalType.TIME)
    private Date editAt;
    @Size(max = 14)
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "regprofesional")
    private String regprofesional;
    @Size(max = 2147483647)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicId")
    private Collection<Medicalrecord> medicalrecordCollection= new ArrayList<>();
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Tuser idUser;
    @OneToMany(mappedBy = "medicId",cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Specialist> specialistList= new ArrayList<>();

    public Medic() {
    }

    public Medic(Integer idMedic) {
        this.idMedic = idMedic;
    }

    public Medic(Integer idMedic, String lastname, String firstname, String mobile, String email, String address, String regprofesional) {
        this.idMedic = idMedic;
        this.lastname = lastname;
        this.firstname = firstname;
        this.mobile = mobile;
        this.email = email;
        this.address = address;
        this.regprofesional = regprofesional;
    }

    public Integer getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(Integer idMedic) {
        this.idMedic = idMedic;
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

    public String getRegprofesional() {
        return regprofesional;
    }

    public void setRegprofesional(String regprofesional) {
        this.regprofesional = regprofesional;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Collection<Medicalrecord> getMedicalrecordCollection() {
        return medicalrecordCollection;
    }

    public void setMedicalrecordCollection(Collection<Medicalrecord> medicalrecordCollection) {
        this.medicalrecordCollection = medicalrecordCollection;
    }

    public Tuser getIdUser() {
        return idUser;
    }

    public void setIdUser(Tuser idUser) {
        this.idUser = idUser;
    }

    public List<Specialist> getSpecialistList() {
        return specialistList;
    }

    public void setSpecialistList(List<Specialist> specialistList) {
        this.specialistList = specialistList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedic != null ? idMedic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medic)) {
            return false;
        }
        Medic other = (Medic) object;
        if ((this.idMedic == null && other.idMedic != null) || (this.idMedic != null && !this.idMedic.equals(other.idMedic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }

}
