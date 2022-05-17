package controladores;

import modelo.MedicalrecordFacade;
import modelo.VitalsignFacade;
import entidades.Vitalsign;
import util.JsfUtil;
import util.JsfUtil.PersistAction;
import entidades.Medic;
import entidades.Medicalrecord;
import entidades.Patient;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("vitalsignController")
@RequestScoped
public class VitalsignController implements Serializable {

    @EJB
    private modelo.VitalsignFacade ejbFacade;
    @EJB
    private modelo.MedicalrecordFacade medicalrecordFacade;
    private Patient patient;
    private Medic medic;
    private List<Vitalsign> items = null;
    private Vitalsign selected;
    private String reason;
    private String curcurrentIllness;

    @PostConstruct
    public void init() {
        prepareCreate();
    }

    public String getCurcurrentIllness() {
        return curcurrentIllness;
    }

    public void setCurcurrentIllness(String curcurrentIllness) {
        this.curcurrentIllness = curcurrentIllness;
    }

    public VitalsignController() {
    }

    public Vitalsign getSelected() {
        return selected;
    }

    public void setSelected(Vitalsign selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    public MedicalrecordFacade getMedicalrecordFacade() {
        return medicalrecordFacade;
    }

    private VitalsignFacade getFacade() {
        return ejbFacade;
    }

    public Vitalsign prepareCreate() {
        selected = new Vitalsign();

        initializeEmbeddableKey();
        return selected;
    }

    public void create() {

        Medicalrecord medicalrecord = new Medicalrecord();
        medicalrecord.setCreateAt(new Date());
        medicalrecord.setEditAt(new Date());
        medicalrecord.setDelete(false);
        medicalrecord.setReason(reason);
        medicalrecord.setCurrentIllness(curcurrentIllness);
        medicalrecord.setDone(false);
        medicalrecord.setCanceled(false);
        medicalrecord.setMedicId(medic);
        medicalrecord.setPatientId(patient);
        selected.setCreatedAt(new Date());
        getMedicalrecordFacade().create(medicalrecord);
        selected.setMedicalrecordId(medicalrecord);
        patient = null;
        medic = null;
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("VitalsignCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("VitalsignUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("VitalsignDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Vitalsign> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Vitalsign getVitalsign(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Vitalsign> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Vitalsign> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medic getMedic() {
        return medic;
    }

    public void setMedic(Medic medic) {
        this.medic = medic;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @FacesConverter(forClass = Vitalsign.class)
    public static class VitalsignControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            VitalsignController controller = (VitalsignController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "vitalsignController");
            return controller.getVitalsign(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Vitalsign) {
                Vitalsign o = (Vitalsign) object;
                return getStringKey(o.getIdVitalsig());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Vitalsign.class.getName()});
                return null;
            }
        }

    }

}
