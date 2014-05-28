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
@Table(name = "cfg_citytown")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgCitytown.findAll", query = "SELECT c FROM CfgCitytown c"),
    @NamedQuery(name = "CfgCitytown.findByPkCfgCitytownId", query = "SELECT c FROM CfgCitytown c WHERE c.pkCfgCitytownId = :pkCfgCitytownId"),
    @NamedQuery(name = "CfgCitytown.findByCitytownName", query = "SELECT c FROM CfgCitytown c WHERE c.citytownName = :citytownName")})
public class CfgCitytown implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cfg_citytown_id")
    private Long pkCfgCitytownId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "citytown_name")
    private String citytownName;
    @JoinColumn(name = "fk_cfg_stateprovince_id", referencedColumnName = "pk_cfg_stateprovince_id")
    @ManyToOne(optional = false)
    private CfgStateprovince fkCfgStateprovinceId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCfgCitytownId")
    private Collection<CfgBarangay> cfgBarangayCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressFkCfgCitytownId")
    private Collection<Profile> profileCollection;

    public CfgCitytown() {
    }

    public CfgCitytown(Long pkCfgCitytownId) {
        this.pkCfgCitytownId = pkCfgCitytownId;
    }

    public CfgCitytown(Long pkCfgCitytownId, String citytownName) {
        this.pkCfgCitytownId = pkCfgCitytownId;
        this.citytownName = citytownName;
    }

    public Long getPkCfgCitytownId() {
        return pkCfgCitytownId;
    }

    public void setPkCfgCitytownId(Long pkCfgCitytownId) {
        this.pkCfgCitytownId = pkCfgCitytownId;
    }

    public String getCitytownName() {
        return citytownName;
    }

    public void setCitytownName(String citytownName) {
        this.citytownName = citytownName;
    }

    public CfgStateprovince getFkCfgStateprovinceId() {
        return fkCfgStateprovinceId;
    }

    public void setFkCfgStateprovinceId(CfgStateprovince fkCfgStateprovinceId) {
        this.fkCfgStateprovinceId = fkCfgStateprovinceId;
    }

    @XmlTransient
    public Collection<CfgBarangay> getCfgBarangayCollection() {
        return cfgBarangayCollection;
    }

    public void setCfgBarangayCollection(Collection<CfgBarangay> cfgBarangayCollection) {
        this.cfgBarangayCollection = cfgBarangayCollection;
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
        hash += (pkCfgCitytownId != null ? pkCfgCitytownId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgCitytown)) {
            return false;
        }
        CfgCitytown other = (CfgCitytown) object;
        if ((this.pkCfgCitytownId == null && other.pkCfgCitytownId != null) || (this.pkCfgCitytownId != null && !this.pkCfgCitytownId.equals(other.pkCfgCitytownId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.CfgCitytown[ pkCfgCitytownId=" + pkCfgCitytownId + " ]";
    }
    
}
