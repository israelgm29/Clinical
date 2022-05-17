package controladores;

import modelo.ProfileFacade;
import entidades.Profile;
import entidades.Role;
import entidades.Tuser;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import util.JsfUtil;
import util.JsfUtil.PersistAction;

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
import modelo.TuserFacade;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import resources.Const;

@Named("profileController")
@SessionScoped
public class ProfileController implements Serializable {

    @EJB
    private modelo.ProfileFacade ejbFacade;
    @EJB
    private modelo.TuserFacade tuserFacade;
    private List<Profile> items = null;
    private Profile selected;
    private String destination;
    private String link;
    private UploadedFile fileimage;
    private Role role;

    public UploadedFile getFileimage() {
        return fileimage;
    }

    public void setFileimage(UploadedFile fileimage) {
        this.fileimage = fileimage;
    }

    public ProfileController() {
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Profile getSelected() {
        return selected;
    }

    public void setSelected(Profile selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProfileFacade getFacade() {
        return ejbFacade;
    }

    private TuserFacade getTuserFacade() {
        return tuserFacade;
    }

    public Profile prepareCreate() {
        selected = new Profile();
        selected.setCreateAt(new Date());
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        if (upload()) {
            String passMD5 = DigestUtils.md5Hex(random());
            Tuser tuser = new Tuser();
            tuser.setCreateAt(new Date());
            tuser.setEditAt(new Date());
            tuser.setIsActive(false);
            tuser.setVerificationEmail(false);
            tuser.setRoleId(role);
            tuser.setPassword(passMD5);
            persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProfileCreated"));
            tuser.setIdProfile(selected);
            getTuserFacade().create(tuser);

        } else {
            FacesMessage message = new FacesMessage("Error" + " Error al cargar la imagen.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    private String random() {

        return UUID.randomUUID().toString().substring(0, 10);

    }

    public void update() {
        if (upload()) {
            persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProfileUpdated"));
        } else {
            FacesMessage message = new FacesMessage("Error" + " Error al cargar la imagen.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProfileDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Profile> getItems() {
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

    public Profile getProfile(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Profile> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Profile> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    private boolean upload() {
        try {
            destination = Const.URL + Const.Perfiles + Const.SEPARATOR;
            System.err.println(destination);
            File folder = new File(destination);
            if (!folder.exists()) {
                folder.mkdir();
            }
            copyFile(getFileimage().getFileName(), getFileimage());
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
        File savedFile = new File(Const.URL + Const.Perfiles + Const.SEPARATOR, "" + selected.getDni() + "." + extension + "");
        link = "" + Const.SEPARATOR + Const.Perfiles + Const.SEPARATOR + selected.getDni() + "." + extension + "";

        try (InputStream input = upload.getInputStream()) {
            Files.copy(input, savedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            selected.setImage(link);
        } catch (IOException e) {
            // Show faces message?
        }
    }

   

    @FacesConverter(forClass = Profile.class)
    public static class ProfileControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProfileController controller = (ProfileController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "profileController");
            return controller.getProfile(getKey(value));
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
            if (object instanceof Profile) {
                Profile o = (Profile) object;
                return getStringKey(o.getIdProfile());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Profile.class.getName()});
                return null;
            }
        }

    }

}
