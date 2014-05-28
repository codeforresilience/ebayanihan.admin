package org.ebayanihan.admin.controller;

import org.ebayanihan.admin.entity.CfgBarangay;
import org.ebayanihan.admin.controller.util.JsfUtil;
import org.ebayanihan.admin.controller.util.JsfUtil.PersistAction;
import org.ebayanihan.admin.facade.CfgBarangayFacade;

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

@Named("cfgBarangayController")
@SessionScoped
public class CfgBarangayController implements Serializable {

    @EJB
    private org.ebayanihan.admin.facade.CfgBarangayFacade ejbFacade;
    private List<CfgBarangay> items = null;
    private CfgBarangay selected;

    public CfgBarangayController() {
    }

    public CfgBarangay getSelected() {
        return selected;
    }

    public void setSelected(CfgBarangay selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CfgBarangayFacade getFacade() {
        return ejbFacade;
    }

    public CfgBarangay prepareCreate() {
        selected = new CfgBarangay();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CfgBarangayCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CfgBarangayUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CfgBarangayDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CfgBarangay> getItems() {
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

    public CfgBarangay getCfgBarangay(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CfgBarangay> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CfgBarangay> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CfgBarangay.class)
    public static class CfgBarangayControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CfgBarangayController controller = (CfgBarangayController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cfgBarangayController");
            return controller.getCfgBarangay(getKey(value));
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
            if (object instanceof CfgBarangay) {
                CfgBarangay o = (CfgBarangay) object;
                return getStringKey(o.getPkCfgBarangayId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CfgBarangay.class.getName()});
                return null;
            }
        }

    }

}
