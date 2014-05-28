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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Eris
 */
@Entity
@Table(name = "advocacy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advocacy.findAll", query = "SELECT a FROM Advocacy a"),
    @NamedQuery(name = "Advocacy.findByPkAdvocateId", query = "SELECT a FROM Advocacy a WHERE a.pkAdvocateId = :pkAdvocateId"),
    @NamedQuery(name = "Advocacy.findByAdvocateTitle", query = "SELECT a FROM Advocacy a WHERE a.advocateTitle = :advocateTitle"),
    @NamedQuery(name = "Advocacy.findByAdvocateDescription", query = "SELECT a FROM Advocacy a WHERE a.advocateDescription = :advocateDescription"),
    @NamedQuery(name = "Advocacy.findByAdvocateCmslink", query = "SELECT a FROM Advocacy a WHERE a.advocateCmslink = :advocateCmslink")})
public class Advocacy implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_advocate_id")
    private Long pkAdvocateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "advocate_title")
    private String advocateTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "advocate_description")
    private String advocateDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "advocate_cmslink")
    private String advocateCmslink;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @OneToOne(optional = false)
    private Appuser fkAppuserId;

    public Advocacy() {
    }

    public Advocacy(Long pkAdvocateId) {
        this.pkAdvocateId = pkAdvocateId;
    }

    public Advocacy(Long pkAdvocateId, String advocateTitle, String advocateDescription, String advocateCmslink) {
        this.pkAdvocateId = pkAdvocateId;
        this.advocateTitle = advocateTitle;
        this.advocateDescription = advocateDescription;
        this.advocateCmslink = advocateCmslink;
    }

    public Long getPkAdvocateId() {
        return pkAdvocateId;
    }

    public void setPkAdvocateId(Long pkAdvocateId) {
        this.pkAdvocateId = pkAdvocateId;
    }

    public String getAdvocateTitle() {
        return advocateTitle;
    }

    public void setAdvocateTitle(String advocateTitle) {
        this.advocateTitle = advocateTitle;
    }

    public String getAdvocateDescription() {
        return advocateDescription;
    }

    public void setAdvocateDescription(String advocateDescription) {
        this.advocateDescription = advocateDescription;
    }

    public String getAdvocateCmslink() {
        return advocateCmslink;
    }

    public void setAdvocateCmslink(String advocateCmslink) {
        this.advocateCmslink = advocateCmslink;
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
        hash += (pkAdvocateId != null ? pkAdvocateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advocacy)) {
            return false;
        }
        Advocacy other = (Advocacy) object;
        if ((this.pkAdvocateId == null && other.pkAdvocateId != null) || (this.pkAdvocateId != null && !this.pkAdvocateId.equals(other.pkAdvocateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.Advocacy[ pkAdvocateId=" + pkAdvocateId + " ]";
    }
    
}
