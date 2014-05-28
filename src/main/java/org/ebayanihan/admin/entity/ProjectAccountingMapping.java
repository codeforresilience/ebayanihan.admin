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
@Table(name = "project_accounting_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectAccountingMapping.findAll", query = "SELECT p FROM ProjectAccountingMapping p"),
    @NamedQuery(name = "ProjectAccountingMapping.findByPkProjectAccountingMappingId", query = "SELECT p FROM ProjectAccountingMapping p WHERE p.pkProjectAccountingMappingId = :pkProjectAccountingMappingId"),
    @NamedQuery(name = "ProjectAccountingMapping.findByReviewStatus", query = "SELECT p FROM ProjectAccountingMapping p WHERE p.reviewStatus = :reviewStatus"),
    @NamedQuery(name = "ProjectAccountingMapping.findByRemarks", query = "SELECT p FROM ProjectAccountingMapping p WHERE p.remarks = :remarks")})
public class ProjectAccountingMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_accounting_mapping_id")
    private Long pkProjectAccountingMappingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "review_status")
    private short reviewStatus;
    @Size(max = 2147483647)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @ManyToOne(optional = false)
    private Appuser fkAppuserId;

    public ProjectAccountingMapping() {
    }

    public ProjectAccountingMapping(Long pkProjectAccountingMappingId) {
        this.pkProjectAccountingMappingId = pkProjectAccountingMappingId;
    }

    public ProjectAccountingMapping(Long pkProjectAccountingMappingId, short reviewStatus) {
        this.pkProjectAccountingMappingId = pkProjectAccountingMappingId;
        this.reviewStatus = reviewStatus;
    }

    public Long getPkProjectAccountingMappingId() {
        return pkProjectAccountingMappingId;
    }

    public void setPkProjectAccountingMappingId(Long pkProjectAccountingMappingId) {
        this.pkProjectAccountingMappingId = pkProjectAccountingMappingId;
    }

    public short getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(short reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
        hash += (pkProjectAccountingMappingId != null ? pkProjectAccountingMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectAccountingMapping)) {
            return false;
        }
        ProjectAccountingMapping other = (ProjectAccountingMapping) object;
        if ((this.pkProjectAccountingMappingId == null && other.pkProjectAccountingMappingId != null) || (this.pkProjectAccountingMappingId != null && !this.pkProjectAccountingMappingId.equals(other.pkProjectAccountingMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.ProjectAccountingMapping[ pkProjectAccountingMappingId=" + pkProjectAccountingMappingId + " ]";
    }
    
}
