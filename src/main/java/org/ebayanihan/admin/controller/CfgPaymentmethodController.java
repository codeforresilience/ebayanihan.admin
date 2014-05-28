package org.ebayanihan.admin.controller;

import org.ebayanihan.admin.entity.CfgPaymentmethod;
import org.ebayanihan.admin.controller.util.JsfUtil;
import org.ebayanihan.admin.controller.util.JsfUtil.PersistAction;
import org.ebayanihan.admin.facade.CfgPaymentmethodFacade;

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

@Named("cfgPaymentmethodController")
@SessionScoped
public class CfgPaymentmethodController implements Serializable {

    @EJB
    private org.ebayanihan.admin.facade.CfgPaymentmethodFacade ejbFacade;
    private List<CfgPaymentmethod> items = null;
    private CfgPaymentmethod selected;

    public CfgPaymentmethodController() {
    }

    public CfgPaymentmethod getSelected() {
        return selected;
    }

    public void setSelected(CfgPaymentmethod selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CfgPaymentmethodFacade getFacade() {
        return ejbFacade;
    }

    public CfgPaymentmethod prepareCreate() {
        selected = new CfgPaymentmethod();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CfgPaymentmethodCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CfgPaymentmethodUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CfgPaymentmethodDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<CfgPaymentmethod> getItems() {
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

    public CfgPaymentmethod getCfgPaymentmethod(java.lang.Long id) {
        return getFacade().find(id);
    }

    public List<CfgPaymentmethod> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<CfgPaymentmethod> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = CfgPaymentmethod.class)
    public static class CfgPaymentmethodControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CfgPaymentmethodController controller = (CfgPaymentmethodController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cfgPaymentmethodController");
            return controller.getCfgPaymentmethod(getKey(value));
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
            if (object instanceof CfgPaymentmethod) {
                CfgPaymentmethod o = (CfgPaymentmethod) object;
                return getStringKey(o.getPkCfgPaymentmethodId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CfgPaymentmethod.class.getName()});
                return null;
            }
        }

    }

}
