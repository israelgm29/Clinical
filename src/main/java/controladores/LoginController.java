/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controladores;

import entidades.Medic;
import entidades.Tuser;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import util.JsfUtil;

/**
 *
 * @author Mainfrek
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController implements Serializable {

    private String email, password, role;
    @EJB
    private modelo.MedicFacade medicFacade;
    @EJB
    private modelo.TuserFacade tuserFacade;

    public LoginController() {
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public modelo.MedicFacade getMedicFacade() {
        return medicFacade;
    }

    public modelo.TuserFacade getTuserFacade() {
        return tuserFacade;
    }

    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public String loginUser() {

        switch (role) {
            case "Medico":
                Medic medicLog = medicFacade.loginMed(email);
                if (medicLog == null) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "El usuario no existe o su cuenta no pertenece al modulo de medicos ");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                } else {
                    if (medicLog.getIdUser().getPassword().contains(password)) {
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido ", " Doctor: " + medicLog.getFirstname() + " " + medicLog.getLastname());
                        FacesContext.getCurrentInstance().addMessage(null, message);

                    } else {
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error :", "Usuario o contraseña incorrectos");
                        FacesContext.getCurrentInstance().addMessage(null, message);
                    }

                }
                break;
            case "Enfermeria":
                Tuser userLog = tuserFacade.loginTuser(email, password);
                if (userLog == null) {
                    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "usuario o contraseña incorrectos o su cuenta no pertenece al modulo de Enfermeria");
                    FacesContext.getCurrentInstance().addMessage(null, message);
                } else {
                    if (!userLog.getIsActive() && !userLog.getVerificationEmail()) {
                        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Atención", "Su cuenta aun no a sido activada, activela para iniciar sesion");
                        FacesContext.getCurrentInstance().addMessage(null, message);
                    } else {

                        FacesMessage message = new FacesMessage("Bienvenido" + "Lic:" + userLog.getIdProfile().getFirstname());
                        FacesContext.getCurrentInstance().addMessage(null, message);
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userlog", userLog);
                        return "vistas/Nursing/Home";
                    }
                }

                break;
            default:
                return "Login";
        }
        return "Login";

    }

}
