package org.ebayanihan.admin.controller;

import org.ebayanihan.admin.entity.ProjectExpenseMapping;
import org.ebayanihan.admin.controller.util.JsfUtil;
import org.ebayanihan.admin.controller.util.JsfUtil.PersistAction;
import org.ebayanihan.admin.facade.ProjectExpenseMappingFacade;

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

@Named("projectExpenseMappingController")
@SessionScoped
public class ProjectExpenseMappingController implements Serializable {

    @EJB
    private org.ebayanihan.admin.facade.ProjectExpenseMappingFacade ejbFacade;
    private List<ProjectExpenseMapping> items = null;
    private ProjectExpenseMapping selected;

    public ProjectExpenseMappingController() {
    }

    public ProjectExpenseMapping getSelected() {
        return selected;
    }

    public void setSelected(ProjectExpenseMapping selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ProjectExpenseMappingFacade getFacade() {
        return ejbFacade;
    }

    public ProjectExpenseMapping prepareCreate() {
        selected = new ProjectExpenseMapping();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ProjectExpenseMappingCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ProjectExpenseMappingUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ProjectExpenseMappingDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<ProjectExpenseMapping> getItems() {
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

    public ProjectExpenseMapping getProjectExpenseMapping(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<ProjectExpenseMapping> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<ProjectExpenseMapping> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = ProjectExpenseMapping.class)
    public static class ProjectExpenseMappingControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProjectExpenseMappingController controller = (ProjectExpenseMappingController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "projectExpenseMappingController");
            return controller.getProjectExpenseMapping(getKey(value));
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
            if (object instanceof ProjectExpenseMapping) {
                ProjectExpenseMapping o = (ProjectExpenseMapping) object;
                return getStringKey(o.getPkProjectExpenseMappingId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProjectExpenseMapping.class.getName()});
                return null;
            }
        }

    }

}
