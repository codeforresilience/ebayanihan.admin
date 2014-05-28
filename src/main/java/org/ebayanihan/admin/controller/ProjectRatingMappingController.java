package org.ebayanihan.admin.controller;

import org.ebayanihan.admin.entity.ProjectRatingMapping;
import org.ebayanihan.admin.controller.util.JsfUtil;
import org.ebayanihan.admin.controller.util.JsfUtil.PersistAction;
import org.ebayanihan.admin.facade.ProjectRatingMappingFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("projectRatingMappingController")
@SessionScoped
public class ProjectRatingMappingController implements Serializable {

    @EJB
    private org.ebayanihan.admin.facade.ProjectRatingMappingFacade ejbFacade;
    private List<ProjectRatingMapping> items = null;
    private ProjectRatingMapping selected;

    public ProjectRatingMappingController() {
    }

    public ProjectRatingMapping getSelected() {
        return selected;
    }

    public void setSelected(ProjectRatingMapping selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProjectRatingMappingFacade getFacade() {
        return ejbFacade;
    }

    public ProjectRatingMapping prepareCreate() {
        selected = new ProjectRatingMapping();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProjectRatingMappingCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProjectRatingMappingUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProjectRatingMappingDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProjectRatingMapping> getItems() {
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

    public ProjectRatingMapping getProjectRatingMapping(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<ProjectRatingMapping> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProjectRatingMapping> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProjectRatingMapping.class)
    public static class ProjectRatingMappingControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProjectRatingMappingController controller = (ProjectRatingMappingController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "projectRatingMappingController");
            return controller.getProjectRatingMapping(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof ProjectRatingMapping) {
                ProjectRatingMapping o = (ProjectRatingMapping) object;
                return getStringKey(o.getPkProjectRatingId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProjectRatingMapping.class.getName()});
                return null;
            }
        }

    }

}
