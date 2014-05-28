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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cfg_stateprovince")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgStateprovince.findAll", query = "SELECT c FROM CfgStateprovince c"),
    @NamedQuery(name = "CfgStateprovince.findByPkCfgStateprovinceId", query = "SELECT c FROM CfgStateprovince c WHERE c.pkCfgStateprovinceId = :pkCfgStateprovinceId"),
    @NamedQuery(name = "CfgStateprovince.findByStateprovinceName", query = "SELECT c FROM CfgStateprovince c WHERE c.stateprovinceName = :stateprovinceName")})
public class CfgStateprovince implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cfg_stateprovince_id")
    private Long pkCfgStateprovinceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "stateprovince_name")
    private String stateprovinceName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCfgStateprovinceId")
    private Collection<CfgCitytown> cfgCitytownCollection;
    @JoinColumn(name = "fk_cfg_country_id", referencedColumnName = "pk_cfg_country_id")
    @ManyToOne(optional = false)
    private CfgCountry fkCfgCountryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressFkCfgStateprovinceId")
    private Collection<Profile> profileCollection;

    public CfgStateprovince() {
    }

    public CfgStateprovince(Long pkCfgStateprovinceId) {
        this.pkCfgStateprovinceId = pkCfgStateprovinceId;
    }

    public CfgStateprovince(Long pkCfgStateprovinceId, String stateprovinceName) {
        this.pkCfgStateprovinceId = pkCfgStateprovinceId;
        this.stateprovinceName = stateprovinceName;
    }

    public Long getPkCfgStateprovinceId() {
        return pkCfgStateprovinceId;
    }

    public void setPkCfgStateprovinceId(Long pkCfgStateprovinceId) {
        this.pkCfgStateprovinceId = pkCfgStateprovinceId;
    }

    public String getStateprovinceName() {
        return stateprovinceName;
    }

    public void setStateprovinceName(String stateprovinceName) {
        this.stateprovinceName = stateprovinceName;
    }

    @XmlTransient
    public Collection<CfgCitytown> getCfgCitytownCollection() {
        return cfgCitytownCollection;
    }

    public void setCfgCitytownCollection(Collection<CfgCitytown> cfgCitytownCollection) {
        this.cfgCitytownCollection = cfgCitytownCollection;
    }

    public CfgCountry getFkCfgCountryId() {
        return fkCfgCountryId;
    }

    public void setFkCfgCountryId(CfgCountry fkCfgCountryId) {
        this.fkCfgCountryId = fkCfgCountryId;
    }

    @XmlTransient
    public Collection<Profile> getProfileCollection() {
        return profileCollection;
    }

    public void setProfileCollection(Collection<Profile> profileCollection) {
        this.profileCollection = profileCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCfgStateprovinceId != null ? pkCfgStateprovinceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgStateprovince)) {
            return false;
        }
        CfgStateprovince other = (CfgStateprovince) object;
        if ((this.pkCfgStateprovinceId == null && other.pkCfgStateprovinceId != null) || (this.pkCfgStateprovinceId != null && !this.pkCfgStateprovinceId.equals(other.pkCfgStateprovinceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.CfgStateprovince[ pkCfgStateprovinceId=" + pkCfgStateprovinceId + " ]";
    }
    
}
