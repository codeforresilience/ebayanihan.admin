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
@Table(name = "project_certificate_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectCertificateMapping.findAll", query = "SELECT p FROM ProjectCertificateMapping p"),
    @NamedQuery(name = "ProjectCertificateMapping.findByPkProjectCertificateMappingId", query = "SELECT p FROM ProjectCertificateMapping p WHERE p.pkProjectCertificateMappingId = :pkProjectCertificateMappingId"),
    @NamedQuery(name = "ProjectCertificateMapping.findByBayaniPoints", query = "SELECT p FROM ProjectCertificateMapping p WHERE p.bayaniPoints = :bayaniPoints"),
    @NamedQuery(name = "ProjectCertificateMapping.findByCertificateRemarks", query = "SELECT p FROM ProjectCertificateMapping p WHERE p.certificateRemarks = :certificateRemarks")})
public class ProjectCertificateMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_certificate_mapping_id")
    private Long pkProjectCertificateMappingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bayani_points")
    private int bayaniPoints;
    @Size(max = 2147483647)
    @Column(name = "certificate_remarks")
    private String certificateRemarks;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;
    @JoinColumn(name = "fk_certificate_id", referencedColumnName = "pk_certificate_id")
    @ManyToOne(optional = false)
    private CfgCertificate fkCertificateId;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @ManyToOne(optional = false)
    private Appuser fkAppuserId;

    public ProjectCertificateMapping() {
    }

    public ProjectCertificateMapping(Long pkProjectCertificateMappingId) {
        this.pkProjectCertificateMappingId = pkProjectCertificateMappingId;
    }

    public ProjectCertificateMapping(Long pkProjectCertificateMappingId, int bayaniPoints) {
        this.pkProjectCertificateMappingId = pkProjectCertificateMappingId;
        this.bayaniPoints = bayaniPoints;
    }

    public Long getPkProjectCertificateMappingId() {
        return pkProjectCertificateMappingId;
    }

    public void setPkProjectCertificateMappingId(Long pkProjectCertificateMappingId) {
        this.pkProjectCertificateMappingId = pkProjectCertificateMappingId;
    }

    public int getBayaniPoints() {
        return bayaniPoints;
    }

    public void setBayaniPoints(int bayaniPoints) {
        this.bayaniPoints = bayaniPoints;
    }

    public String getCertificateRemarks() {
        return certificateRemarks;
    }

    public void setCertificateRemarks(String certificateRemarks) {
        this.certificateRemarks = certificateRemarks;
    }

    public Project getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(Project fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    public CfgCertificate getFkCertificateId() {
        return fkCertificateId;
    }

    public void setFkCertificateId(CfgCertificate fkCertificateId) {
        this.fkCertificateId = fkCertificateId;
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
        hash += (pkProjectCertificateMappingId != null ? pkProjectCertificateMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectCertificateMapping)) {
            return false;
        }
        ProjectCertificateMapping other = (ProjectCertificateMapping) object;
        if ((this.pkProjectCertificateMappingId == null && other.pkProjectCertificateMappingId != null) || (this.pkProjectCertificateMappingId != null && !this.pkProjectCertificateMappingId.equals(other.pkProjectCertificateMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.ProjectCertificateMapping[ pkProjectCertificateMappingId=" + pkProjectCertificateMappingId + " ]";
    }
    
}
