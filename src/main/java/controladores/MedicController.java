package controladores;

import modelo.MedicFacade;
import modelo.TuserFacade;
import resources.Const;
import entidades.Medic;
import util.JsfUtil;
import util.JsfUtil.PersistAction;
import entidades.Role;
import entidades.Tuser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;
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
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

@Named("medicController")
@SessionScoped
public class MedicController implements Serializable {

    @EJB
    private modelo.MedicFacade ejbFacade;
    private List<Medic> items = null;
    private Medic selected;
    private TuserFacade tuserFacade;
    private UploadedFile file;
    private String destination;
    private String link;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public MedicController() {
    }

    public Medic getSelected() {
        return selected;
    }

    public void setSelected(Medic selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MedicFacade getFacade() {
        return ejbFacade;
    }

    public Medic prepareCreate() {
        selected = new Medic();
        selected.setCreateAt(new Date());
        selected.setEditAt(new Date());
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        if (upload()) {
            String passMD5 = DigestUtils.md5Hex(random());
            Tuser tuser = new Tuser();
            Role role = new Role();
            role.setIdRol(1);
            tuser.setCreateAt(new Date());
            tuser.setEditAt(new Date());
            tuser.setIdUser(selected.getIdMedic());
            tuser.setIsActive(false);
            tuser.setVerificationEmail(false);
            tuser.setRoleId(role);
            tuser.setPassword(passMD5);
            getTuserFacade().create(tuser);
            selected.setIdUser(tuser);
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MedicCreated"));
        } else {
            FacesMessage message = new FacesMessage("Error" + " Error al cargar la imagen.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        if (upload()) {
            persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MedicUpdated"));
        } else {
            FacesMessage message = new FacesMessage("Error" + " Error al cargar la imagen");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MedicDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Medic> getItems() {
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

    private String random() {

        return UUID.randomUUID().toString().substring(0, 10);

    }

    public Medic getMedic(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Medic> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Medic> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    private TuserFacade getTuserFacade() {
        return tuserFacade;
    }

    private boolean upload() {
        try {
            destination = Const.URL + Const.Medics + Const.SEPARATOR;
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
        File savedFile = new File(Const.URL + Const.Medics + Const.SEPARATOR, "" + selected.getDni() + "." + extension + "");
        link = "" + Const.SEPARATOR+Const.Medics+Const.SEPARATOR + selected.getDni() + "." + extension + "";

        try (InputStream input = upload.getInputStream()) {
            Files.copy(input, savedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            selected.setImage(link);
        } catch (IOException e) {
            // Show faces message?
        }
    }

    @FacesConverter(forClass = Medic.class)
    public static class MedicControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MedicController controller = (MedicController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "medicController");
            return controller.getMedic(getKey(value));
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
            if (object instanceof Medic) {
                Medic o = (Medic) object;
                return getStringKey(o.getIdMedic());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Medic.class.getName()});
                return null;
            }
        }

    }

}
