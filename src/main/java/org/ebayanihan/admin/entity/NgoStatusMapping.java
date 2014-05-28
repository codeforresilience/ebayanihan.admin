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
@Table(name = "ngo_status_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NgoStatusMapping.findAll", query = "SELECT n FROM NgoStatusMapping n"),
    @NamedQuery(name = "NgoStatusMapping.findByPkNgoStatusMappingId", query = "SELECT n FROM NgoStatusMapping n WHERE n.pkNgoStatusMappingId = :pkNgoStatusMappingId"),
    @NamedQuery(name = "NgoStatusMapping.findByStatusId", query = "SELECT n FROM NgoStatusMapping n WHERE n.statusId = :statusId"),
    @NamedQuery(name = "NgoStatusMapping.findByStatusNotes", query = "SELECT n FROM NgoStatusMapping n WHERE n.statusNotes = :statusNotes")})
public class NgoStatusMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_ngo_status_mapping_id")
    private Long pkNgoStatusMappingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_id")
    private int statusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "status_notes")
    private String statusNotes;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;

    public NgoStatusMapping() {
    }

    public NgoStatusMapping(Long pkNgoStatusMappingId) {
        this.pkNgoStatusMappingId = pkNgoStatusMappingId;
    }

    public NgoStatusMapping(Long pkNgoStatusMappingId, int statusId, String statusNotes) {
        this.pkNgoStatusMappingId = pkNgoStatusMappingId;
        this.statusId = statusId;
        this.statusNotes = statusNotes;
    }

    public Long getPkNgoStatusMappingId() {
        return pkNgoStatusMappingId;
    }

    public void setPkNgoStatusMappingId(Long pkNgoStatusMappingId) {
        this.pkNgoStatusMappingId = pkNgoStatusMappingId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusNotes() {
        return statusNotes;
    }

    public void setStatusNotes(String statusNotes) {
        this.statusNotes = statusNotes;
    }

    public Project getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(Project fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkNgoStatusMappingId != null ? pkNgoStatusMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NgoStatusMapping)) {
            return false;
        }
        NgoStatusMapping other = (NgoStatusMapping) object;
        if ((this.pkNgoStatusMappingId == null && other.pkNgoStatusMappingId != null) || (this.pkNgoStatusMappingId != null && !this.pkNgoStatusMappingId.equals(other.pkNgoStatusMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.NgoStatusMapping[ pkNgoStatusMappingId=" + pkNgoStatusMappingId + " ]";
    }
    
}
