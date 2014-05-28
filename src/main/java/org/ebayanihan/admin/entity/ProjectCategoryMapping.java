/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ebayanihan.admin.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Eris
 */
@Entity
@Table(name = "project_category_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectCategoryMapping.findAll", query = "SELECT p FROM ProjectCategoryMapping p"),
    @NamedQuery(name = "ProjectCategoryMapping.findByPkProjectCategoryMappingId", query = "SELECT p FROM ProjectCategoryMapping p WHERE p.pkProjectCategoryMappingId = :pkProjectCategoryMappingId")})
public class ProjectCategoryMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_category_mapping_id")
    private Long pkProjectCategoryMappingId;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;
    @JoinColumn(name = "fk_project_category_id", referencedColumnName = "pk_project_category_id")
    @ManyToOne(optional = false)
    private CfgProjectCategory fkProjectCategoryId;

    public ProjectCategoryMapping() {
    }

    public ProjectCategoryMapping(Long pkProjectCategoryMappingId) {
        this.pkProjectCategoryMappingId = pkProjectCategoryMappingId;
    }

    public Long getPkProjectCategoryMappingId() {
        return pkProjectCategoryMappingId;
    }

    public void setPkProjectCategoryMappingId(Long pkProjectCategoryMappingId) {
        this.pkProjectCategoryMappingId = pkProjectCategoryMappingId;
    }

    public Project getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(Project fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    public CfgProjectCategory getFkProjectCategoryId() {
        return fkProjectCategoryId;
    }

    public void setFkProjectCategoryId(CfgProjectCategory fkProjectCategoryId) {
        this.fkProjectCategoryId = fkProjectCategoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProjectCategoryMappingId != null ? pkProjectCategoryMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectCategoryMapping)) {
            return false;
        }
        ProjectCategoryMapping other = (ProjectCategoryMapping) object;
        if ((this.pkProjectCategoryMappingId == null && other.pkProjectCategoryMappingId != null) || (this.pkProjectCategoryMappingId != null && !this.pkProjectCategoryMappingId.equals(other.pkProjectCategoryMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.ProjectCategoryMapping[ pkProjectCategoryMappingId=" + pkProjectCategoryMappingId + " ]";
    }
    
}
