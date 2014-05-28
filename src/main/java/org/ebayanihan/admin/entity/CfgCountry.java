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
@Table(name = "cfg_country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgCountry.findAll", query = "SELECT c FROM CfgCountry c"),
    @NamedQuery(name = "CfgCountry.findByPkCfgCountryId", query = "SELECT c FROM CfgCountry c WHERE c.pkCfgCountryId = :pkCfgCountryId"),
    @NamedQuery(name = "CfgCountry.findByCountryName", query = "SELECT c FROM CfgCountry c WHERE c.countryName = :countryName")})
public class CfgCountry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cfg_country_id")
    private Long pkCfgCountryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "country_name")
    private String countryName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCfgCountryId")
    private Collection<CfgStateprovince> cfgStateprovinceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressFkCfgCountryId")
    private Collection<Profile> profileCollection;

    public CfgCountry() {
    }

    public CfgCountry(Long pkCfgCountryId) {
        this.pkCfgCountryId = pkCfgCountryId;
    }

    public CfgCountry(Long pkCfgCountryId, String countryName) {
        this.pkCfgCountryId = pkCfgCountryId;
        this.countryName = countryName;
    }

    public Long getPkCfgCountryId() {
        return pkCfgCountryId;
    }

    public void setPkCfgCountryId(Long pkCfgCountryId) {
        this.pkCfgCountryId = pkCfgCountryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @XmlTransient
    public Collection<CfgStateprovince> getCfgStateprovinceCollection() {
        return cfgStateprovinceCollection;
    }

    public void setCfgStateprovinceCollection(Collection<CfgStateprovince> cfgStateprovinceCollection) {
        this.cfgStateprovinceCollection = cfgStateprovinceCollection;
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
        hash += (pkCfgCountryId != null ? pkCfgCountryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgCountry)) {
            return false;
        }
        CfgCountry other = (CfgCountry) object;
        if ((this.pkCfgCountryId == null && other.pkCfgCountryId != null) || (this.pkCfgCountryId != null && !this.pkCfgCountryId.equals(other.pkCfgCountryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.CfgCountry[ pkCfgCountryId=" + pkCfgCountryId + " ]";
    }
    
}
