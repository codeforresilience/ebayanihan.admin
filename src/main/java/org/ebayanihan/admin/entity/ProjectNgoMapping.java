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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Eris
 */
@Entity
@Table(name = "project_ngo_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectNgoMapping.findAll", query = "SELECT p FROM ProjectNgoMapping p"),
    @NamedQuery(name = "ProjectNgoMapping.findByPkProjectNgoMappingId", query = "SELECT p FROM ProjectNgoMapping p WHERE p.pkProjectNgoMappingId = :pkProjectNgoMappingId"),
    @NamedQuery(name = "ProjectNgoMapping.findByNgoPurpose", query = "SELECT p FROM ProjectNgoMapping p WHERE p.ngoPurpose = :ngoPurpose")})
public class ProjectNgoMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_ngo_mapping_id")
    private Long pkProjectNgoMappingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ngo_purpose")
    private String ngoPurpose;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;
    @JoinColumn(name = "fk_ngo_id", referencedColumnName = "pk_ngo_id")
    @ManyToOne(optional = false)
    private Ngo fkNgoId;

    public ProjectNgoMapping() {
    }

    public ProjectNgoMapping(Long pkProjectNgoMappingId) {
        this.pkProjectNgoMappingId = pkProjectNgoMappingId;
    }

    public ProjectNgoMapping(Long pkProjectNgoMappingId, String ngoPurpose) {
        this.pkProjectNgoMappingId = pkProjectNgoMappingId;
        this.ngoPurpose = ngoPurpose;
    }

    public Long getPkProjectNgoMappingId() {
        return pkProjectNgoMappingId;
    }

    public void setPkProjectNgoMappingId(Long pkProjectNgoMappingId) {
        this.pkProjectNgoMappingId = pkProjectNgoMappingId;
    }

    public String getNgoPurpose() {
        return ngoPurpose;
    }

    public void setNgoPurpose(String ngoPurpose) {
        this.ngoPurpose = ngoPurpose;
    }

    public Project getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(Project fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    public Ngo getFkNgoId() {
        return fkNgoId;
    }

    public void setFkNgoId(Ngo fkNgoId) {
        this.fkNgoId = fkNgoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProjectNgoMappingId != null ? pkProjectNgoMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectNgoMapping)) {
            return false;
        }
        ProjectNgoMapping other = (ProjectNgoMapping) object;
        if ((this.pkProjectNgoMappingId == null && other.pkProjectNgoMappingId != null) || (this.pkProjectNgoMappingId != null && !this.pkProjectNgoMappingId.equals(other.pkProjectNgoMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.ProjectNgoMapping[ pkProjectNgoMappingId=" + pkProjectNgoMappingId + " ]";
    }
    
}
