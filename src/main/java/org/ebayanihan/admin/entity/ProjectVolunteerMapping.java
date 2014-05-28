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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Eris
 */
@Entity
@Table(name = "project_volunteer_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectVolunteerMapping.findAll", query = "SELECT p FROM ProjectVolunteerMapping p"),
    @NamedQuery(name = "ProjectVolunteerMapping.findByPkProjectVolunteerMappingId", query = "SELECT p FROM ProjectVolunteerMapping p WHERE p.pkProjectVolunteerMappingId = :pkProjectVolunteerMappingId"),
    @NamedQuery(name = "ProjectVolunteerMapping.findByStatus", query = "SELECT p FROM ProjectVolunteerMapping p WHERE p.status = :status")})
public class ProjectVolunteerMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_volunteer_mapping_id")
    private Long pkProjectVolunteerMappingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @ManyToOne(optional = false)
    private Appuser fkAppuserId;

    public ProjectVolunteerMapping() {
    }

    public ProjectVolunteerMapping(Long pkProjectVolunteerMappingId) {
        this.pkProjectVolunteerMappingId = pkProjectVolunteerMappingId;
    }

    public ProjectVolunteerMapping(Long pkProjectVolunteerMappingId, short status) {
        this.pkProjectVolunteerMappingId = pkProjectVolunteerMappingId;
        this.status = status;
    }

    public Long getPkProjectVolunteerMappingId() {
        return pkProjectVolunteerMappingId;
    }

    public void setPkProjectVolunteerMappingId(Long pkProjectVolunteerMappingId) {
        this.pkProjectVolunteerMappingId = pkProjectVolunteerMappingId;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Project getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(Project fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    public Appuser getFkAppuserId() {
        return fkAppuserId;
    }

    public void setFkAppuserId(Appuser fkAppuserId) {
        this.fkAppuserId = fkAppuserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProjectVolunteerMappingId != null ? pkProjectVolunteerMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectVolunteerMapping)) {
            return false;
        }
        ProjectVolunteerMapping other = (ProjectVolunteerMapping) object;
        if ((this.pkProjectVolunteerMappingId == null && other.pkProjectVolunteerMappingId != null) || (this.pkProjectVolunteerMappingId != null && !this.pkProjectVolunteerMappingId.equals(other.pkProjectVolunteerMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.ProjectVolunteerMapping[ pkProjectVolunteerMappingId=" + pkProjectVolunteerMappingId + " ]";
    }
    
}
