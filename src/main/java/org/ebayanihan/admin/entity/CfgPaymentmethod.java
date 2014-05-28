/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ebayanihan.admin.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John Eris
 */
@Entity
@Table(name = "cfg_paymentmethod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgPaymentmethod.findAll", query = "SELECT c FROM CfgPaymentmethod c"),
    @NamedQuery(name = "CfgPaymentmethod.findByPkCfgPaymentmethodId", query = "SELECT c FROM CfgPaymentmethod c WHERE c.pkCfgPaymentmethodId = :pkCfgPaymentmethodId"),
    @NamedQuery(name = "CfgPaymentmethod.findByPaymentmethodName", query = "SELECT c FROM CfgPaymentmethod c WHERE c.paymentmethodName = :paymentmethodName"),
    @NamedQuery(name = "CfgPaymentmethod.findByPaymentmethodDescription", query = "SELECT c FROM CfgPaymentmethod c WHERE c.paymentmethodDescription = :paymentmethodDescription")})
public class CfgPaymentmethod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cfg_paymentmethod_id")
    private Long pkCfgPaymentmethodId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "paymentmethod_name")
    private String paymentmethodName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "paymentmethod_description")
    private String paymentmethodDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCfgPaymentmethodId")
    private Collection<Benefactor> benefactorCollection;

    public CfgPaymentmethod() {
    }

    public CfgPaymentmethod(Long pkCfgPaymentmethodId) {
        this.pkCfgPaymentmethodId = pkCfgPaymentmethodId;
    }

    public CfgPaymentmethod(Long pkCfgPaymentmethodId, String paymentmethodName, String paymentmethodDescription) {
        this.pkCfgPaymentmethodId = pkCfgPaymentmethodId;
        this.paymentmethodName = paymentmethodName;
        this.paymentmethodDescription = paymentmethodDescription;
    }

    public Long getPkCfgPaymentmethodId() {
        return pkCfgPaymentmethodId;
    }

    public void setPkCfgPaymentmethodId(Long pkCfgPaymentmethodId) {
        this.pkCfgPaymentmethodId = pkCfgPaymentmethodId;
    }

    public String getPaymentmethodName() {
        return paymentmethodName;
    }

    public void setPaymentmethodName(String paymentmethodName) {
        this.paymentmethodName = paymentmethodName;
    }

    public String getPaymentmethodDescription() {
        return paymentmethodDescription;
    }

    public void setPaymentmethodDescription(String paymentmethodDescription) {
        this.paymentmethodDescription = paymentmethodDescription;
    }

    @XmlTransient
    public Collection<Benefactor> getBenefactorCollection() {
        return benefactorCollection;
    }

    public void setBenefactorCollection(Collection<Benefactor> benefactorCollection) {
        this.benefactorCollection = benefactorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCfgPaymentmethodId != null ? pkCfgPaymentmethodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgPaymentmethod)) {
            return false;
        }
        CfgPaymentmethod other = (CfgPaymentmethod) object;
        if ((this.pkCfgPaymentmethodId == null && other.pkCfgPaymentmethodId != null) || (this.pkCfgPaymentmethodId != null && !this.pkCfgPaymentmethodId.equals(other.pkCfgPaymentmethodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.CfgPaymentmethod[ pkCfgPaymentmethodId=" + pkCfgPaymentmethodId + " ]";
    }
    
}
