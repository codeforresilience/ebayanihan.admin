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
@Table(name = "cfg_project_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgProjectCategory.findAll", query = "SELECT c FROM CfgProjectCategory c"),
    @NamedQuery(name = "CfgProjectCategory.findByPkProjectCategoryId", query = "SELECT c FROM CfgProjectCategory c WHERE c.pkProjectCategoryId = :pkProjectCategoryId"),
    @NamedQuery(name = "CfgProjectCategory.findByProjectCategoryName", query = "SELECT c FROM CfgProjectCategory c WHERE c.projectCategoryName = :projectCategoryName"),
    @NamedQuery(name = "CfgProjectCategory.findByProjectCategoryDescription", query = "SELECT c FROM CfgProjectCategory c WHERE c.projectCategoryDescription = :projectCategoryDescription")})
public class CfgProjectCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_category_id")
    private Long pkProjectCategoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "project_category_name")
    private String projectCategoryName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "project_category_description")
    private String projectCategoryDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectCategoryId")
    private Collection<ProjectCategoryMapping> projectCategoryMappingCollection;

    public CfgProjectCategory() {
    }

    public CfgProjectCategory(Long pkProjectCategoryId) {
        this.pkProjectCategoryId = pkProjectCategoryId;
    }

    public CfgProjectCategory(Long pkProjectCategoryId, String projectCategoryName, String projectCategoryDescription) {
        this.pkProjectCategoryId = pkProjectCategoryId;
        this.projectCategoryName = projectCategoryName;
        this.projectCategoryDescription = projectCategoryDescription;
    }

    public Long getPkProjectCategoryId() {
        return pkProjectCategoryId;
    }

    public void setPkProjectCategoryId(Long pkProjectCategoryId) {
        this.pkProjectCategoryId = pkProjectCategoryId;
    }

    public String getProjectCategoryName() {
        return projectCategoryName;
    }

    public void setProjectCategoryName(String projectCategoryName) {
        this.projectCategoryName = projectCategoryName;
    }

    public String getProjectCategoryDescription() {
        return projectCategoryDescription;
    }

    public void setProjectCategoryDescription(String projectCategoryDescription) {
        this.projectCategoryDescription = projectCategoryDescription;
    }

    @XmlTransient
    public Collection<ProjectCategoryMapping> getProjectCategoryMappingCollection() {
        return projectCategoryMappingCollection;
    }

    public void setProjectCategoryMappingCollection(Collection<ProjectCategoryMapping> projectCategoryMappingCollection) {
        this.projectCategoryMappingCollection = projectCategoryMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProjectCategoryId != null ? pkProjectCategoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgProjectCategory)) {
            return false;
        }
        CfgProjectCategory other = (CfgProjectCategory) object;
        if ((this.pkProjectCategoryId == null && other.pkProjectCategoryId != null) || (this.pkProjectCategoryId != null && !this.pkProjectCategoryId.equals(other.pkProjectCategoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.CfgProjectCategory[ pkProjectCategoryId=" + pkProjectCategoryId + " ]";
    }
    
}
