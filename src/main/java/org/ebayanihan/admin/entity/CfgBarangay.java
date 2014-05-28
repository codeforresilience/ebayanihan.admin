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
@Table(name = "cfg_barangay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgBarangay.findAll", query = "SELECT c FROM CfgBarangay c"),
    @NamedQuery(name = "CfgBarangay.findByPkCfgBarangayId", query = "SELECT c FROM CfgBarangay c WHERE c.pkCfgBarangayId = :pkCfgBarangayId"),
    @NamedQuery(name = "CfgBarangay.findByBarangayName", query = "SELECT c FROM CfgBarangay c WHERE c.barangayName = :barangayName")})
public class CfgBarangay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cfg_barangay_id")
    private Long pkCfgBarangayId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "barangay_name")
    private String barangayName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCfgBarangay")
    private Collection<Project> projectCollection;
    @JoinColumn(name = "fk_cfg_citytown_id", referencedColumnName = "pk_cfg_citytown_id")
    @ManyToOne(optional = false)
    private CfgCitytown fkCfgCitytownId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressFkCfgBarangayId")
    private Collection<Profile> profileCollection;

    public CfgBarangay() {
    }

    public CfgBarangay(Long pkCfgBarangayId) {
        this.pkCfgBarangayId = pkCfgBarangayId;
    }

    public CfgBarangay(Long pkCfgBarangayId, String barangayName) {
        this.pkCfgBarangayId = pkCfgBarangayId;
        this.barangayName = barangayName;
    }

    public Long getPkCfgBarangayId() {
        return pkCfgBarangayId;
    }

    public void setPkCfgBarangayId(Long pkCfgBarangayId) {
        this.pkCfgBarangayId = pkCfgBarangayId;
    }

    public String getBarangayName() {
        return barangayName;
    }

    public void setBarangayName(String barangayName) {
        this.barangayName = barangayName;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }

    public CfgCitytown getFkCfgCitytownId() {
        return fkCfgCitytownId;
    }

    public void setFkCfgCitytownId(CfgCitytown fkCfgCitytownId) {
        this.fkCfgCitytownId = fkCfgCitytownId;
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
        hash += (pkCfgBarangayId != null ? pkCfgBarangayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgBarangay)) {
            return false;
        }
        CfgBarangay other = (CfgBarangay) object;
        if ((this.pkCfgBarangayId == null && other.pkCfgBarangayId != null) || (this.pkCfgBarangayId != null && !this.pkCfgBarangayId.equals(other.pkCfgBarangayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.CfgBarangay[ pkCfgBarangayId=" + pkCfgBarangayId + " ]";
    }
    
}
