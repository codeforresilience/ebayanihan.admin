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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "ngo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ngo.findAll", query = "SELECT n FROM Ngo n"),
    @NamedQuery(name = "Ngo.findByPkNgoId", query = "SELECT n FROM Ngo n WHERE n.pkNgoId = :pkNgoId"),
    @NamedQuery(name = "Ngo.findByNgoName", query = "SELECT n FROM Ngo n WHERE n.ngoName = :ngoName"),
    @NamedQuery(name = "Ngo.findByNgoPurpose", query = "SELECT n FROM Ngo n WHERE n.ngoPurpose = :ngoPurpose"),
    @NamedQuery(name = "Ngo.findByNgoSecId", query = "SELECT n FROM Ngo n WHERE n.ngoSecId = :ngoSecId"),
    @NamedQuery(name = "Ngo.findByNgoCmsLink", query = "SELECT n FROM Ngo n WHERE n.ngoCmsLink = :ngoCmsLink"),
    @NamedQuery(name = "Ngo.findByNgoStatus", query = "SELECT n FROM Ngo n WHERE n.ngoStatus = :ngoStatus")})
public class Ngo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_ngo_id")
    private Long pkNgoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ngo_name")
    private String ngoName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ngo_purpose")
    private String ngoPurpose;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ngo_sec_id")
    private String ngoSecId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ngo_cms_link")
    private String ngoCmsLink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngo_status")
    private int ngoStatus;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @OneToOne(optional = false)
    private Appuser fkAppuserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkNgoId")
    private Collection<ProjectNgoMapping> projectNgoMappingCollection;

    public Ngo() {
    }

    public Ngo(Long pkNgoId) {
        this.pkNgoId = pkNgoId;
    }

    public Ngo(Long pkNgoId, String ngoName, String ngoPurpose, String ngoSecId, String ngoCmsLink, int ngoStatus) {
        this.pkNgoId = pkNgoId;
        this.ngoName = ngoName;
        this.ngoPurpose = ngoPurpose;
        this.ngoSecId = ngoSecId;
        this.ngoCmsLink = ngoCmsLink;
        this.ngoStatus = ngoStatus;
    }

    public Long getPkNgoId() {
        return pkNgoId;
    }

    public void setPkNgoId(Long pkNgoId) {
        this.pkNgoId = pkNgoId;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
    }

    public String getNgoPurpose() {
        return ngoPurpose;
    }

    public void setNgoPurpose(String ngoPurpose) {
        this.ngoPurpose = ngoPurpose;
    }

    public String getNgoSecId() {
        return ngoSecId;
    }

    public void setNgoSecId(String ngoSecId) {
        this.ngoSecId = ngoSecId;
    }

    public String getNgoCmsLink() {
        return ngoCmsLink;
    }

    public void setNgoCmsLink(String ngoCmsLink) {
        this.ngoCmsLink = ngoCmsLink;
    }

    public int getNgoStatus() {
        return ngoStatus;
    }

    public void setNgoStatus(int ngoStatus) {
        this.ngoStatus = ngoStatus;
    }

    public Appuser getFkAppuserId() {
        return fkAppuserId;
    }

    public void setFkAppuserId(Appuser fkAppuserId) {
        this.fkAppuserId = fkAppuserId;
    }

    @XmlTransient
    public Collection<ProjectNgoMapping> getProjectNgoMappingCollection() {
        return projectNgoMappingCollection;
    }

    public void setProjectNgoMappingCollection(Collection<ProjectNgoMapping> projectNgoMappingCollection) {
        this.projectNgoMappingCollection = projectNgoMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkNgoId != null ? pkNgoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ngo)) {
            return false;
        }
        Ngo other = (Ngo) object;
        if ((this.pkNgoId == null && other.pkNgoId != null) || (this.pkNgoId != null && !this.pkNgoId.equals(other.pkNgoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.Ngo[ pkNgoId=" + pkNgoId + " ]";
    }
    
}
