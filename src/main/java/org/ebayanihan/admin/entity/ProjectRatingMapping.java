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
@Table(name = "project_rating_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectRatingMapping.findAll", query = "SELECT p FROM ProjectRatingMapping p"),
    @NamedQuery(name = "ProjectRatingMapping.findByPkProjectRatingId", query = "SELECT p FROM ProjectRatingMapping p WHERE p.pkProjectRatingId = :pkProjectRatingId"),
    @NamedQuery(name = "ProjectRatingMapping.findByRating", query = "SELECT p FROM ProjectRatingMapping p WHERE p.rating = :rating")})
public class ProjectRatingMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_rating_id")
    private Long pkProjectRatingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @ManyToOne(optional = false)
    private Appuser fkAppuserId;

    public ProjectRatingMapping() {
    }

    public ProjectRatingMapping(Long pkProjectRatingId) {
        this.pkProjectRatingId = pkProjectRatingId;
    }

    public ProjectRatingMapping(Long pkProjectRatingId, int rating) {
        this.pkProjectRatingId = pkProjectRatingId;
        this.rating = rating;
    }

    public Long getPkProjectRatingId() {
        return pkProjectRatingId;
    }

    public void setPkProjectRatingId(Long pkProjectRatingId) {
        this.pkProjectRatingId = pkProjectRatingId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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
        hash += (pkProjectRatingId != null ? pkProjectRatingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectRatingMapping)) {
            return false;
        }
        ProjectRatingMapping other = (ProjectRatingMapping) object;
        if ((this.pkProjectRatingId == null && other.pkProjectRatingId != null) || (this.pkProjectRatingId != null && !this.pkProjectRatingId.equals(other.pkProjectRatingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.ProjectRatingMapping[ pkProjectRatingId=" + pkProjectRatingId + " ]";
    }
    
}
