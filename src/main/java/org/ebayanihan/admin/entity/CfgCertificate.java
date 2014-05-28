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
@Table(name = "cfg_certificate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgCertificate.findAll", query = "SELECT c FROM CfgCertificate c"),
    @NamedQuery(name = "CfgCertificate.findByPkCertificateId", query = "SELECT c FROM CfgCertificate c WHERE c.pkCertificateId = :pkCertificateId"),
    @NamedQuery(name = "CfgCertificate.findByCertificateName", query = "SELECT c FROM CfgCertificate c WHERE c.certificateName = :certificateName"),
    @NamedQuery(name = "CfgCertificate.findByCertificateDescription", query = "SELECT c FROM CfgCertificate c WHERE c.certificateDescription = :certificateDescription")})
public class CfgCertificate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_certificate_id")
    private Long pkCertificateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "certificate_name")
    private String certificateName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "certificate_description")
    private String certificateDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCertificateId")
    private Collection<ProjectCertificateMapping> projectCertificateMappingCollection;

    public CfgCertificate() {
    }

    public CfgCertificate(Long pkCertificateId) {
        this.pkCertificateId = pkCertificateId;
    }

    public CfgCertificate(Long pkCertificateId, String certificateName, String certificateDescription) {
        this.pkCertificateId = pkCertificateId;
        this.certificateName = certificateName;
        this.certificateDescription = certificateDescription;
    }

    public Long getPkCertificateId() {
        return pkCertificateId;
    }

    public void setPkCertificateId(Long pkCertificateId) {
        this.pkCertificateId = pkCertificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateDescription() {
        return certificateDescription;
    }

    public void setCertificateDescription(String certificateDescription) {
        this.certificateDescription = certificateDescription;
    }

    @XmlTransient
    public Collection<ProjectCertificateMapping> getProjectCertificateMappingCollection() {
        return projectCertificateMappingCollection;
    }

    public void setProjectCertificateMappingCollection(Collection<ProjectCertificateMapping> projectCertificateMappingCollection) {
        this.projectCertificateMappingCollection = projectCertificateMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCertificateId != null ? pkCertificateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgCertificate)) {
            return false;
        }
        CfgCertificate other = (CfgCertificate) object;
        if ((this.pkCertificateId == null && other.pkCertificateId != null) || (this.pkCertificateId != null && !this.pkCertificateId.equals(other.pkCertificateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.CfgCertificate[ pkCertificateId=" + pkCertificateId + " ]";
    }
    
}
