package controladores;

import modelo.PatientFacade;
import resources.Const;
import util.JsfUtil;
import util.JsfUtil.PersistAction;
import entidades.Patient;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

@Named("patientController")
@SessionScoped
public class PatientController implements Serializable {

    @EJB
    private modelo.PatientFacade ejbFacade;
    private List<Patient> items = null;
    private Patient selected;
    private String hc = "A-01-";
    private UploadedFile file;
    private String destination;
    private String link;

    public PatientController() {
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Patient getSelected() {
        return selected;
    }

    public void setSelected(Patient selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private PatientFacade getFacade() {
        return ejbFacade;
    }

    public Patient prepareCreate() throws IOException {

        selected = new Patient();
        selected.setCreateAt(new Date());
        selected.setEditAt(new Date());
        selected.setUpdateAt(new Date());
        selected.setDelete(false);
        selected.setHc(hc);
        initializeEmbeddableKey();
        return selected;

    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void create() {
        if (upload()) {
            selected.setImage(link);
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("PatientCreated"));
        } else {
            FacesMessage message = new FacesMessage("Error" + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.

        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("PatientUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("PatientDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Patient> getItems() {
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

    public Patient getPatient(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Patient> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Patient> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    private boolean upload() {
        try {
            destination = Const.URL + Const.Patients + Const.SEPARATOR;
            System.err.println(destination);
            File folder = new File(destination);
            if (!folder.exists()) {
                folder.mkdir();
            }
            copyFile(getFile().getFileName(), getFile());
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void copyFile(String filename, UploadedFile upload) throws IOException {
        String fileName = upload.getFileName();
        String extension = FilenameUtils.getExtension(fileName);
        System.err.println(extension);
        File savedFile = new File(Const.URL + Const.Patients + Const.SEPARATOR, "" + selected.getDni() + "." + extension + "");
        link = "" + Const.SEPARATOR + Const.Patients + Const.SEPARATOR + selected.getDni() + "." + extension + "";

        try (InputStream input = upload.getInputStream()) {
            Files.copy(input, savedFile.toPath());
            selected.setImage(link);
        } catch (IOException e) {
            // Show faces message?
        }
    }

    public int countPatient() {
       return ejbFacade.count();
    }

    @FacesConverter(forClass = Patient.class)
    public static class PatientControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PatientController controller = (PatientController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "patientController");
            return controller.getPatient(getKey(value));
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
            if (object instanceof Patient) {
                Patient o = (Patient) object;
                return getStringKey(o.getIdPatient());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Patient.class.getName()});
                return null;
            }
        }

    }

}
