/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ebayanihan.admin.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author John Eris
 */
@Entity
@Table(name = "project")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findByPkProjectId", query = "SELECT p FROM Project p WHERE p.pkProjectId = :pkProjectId"),
    @NamedQuery(name = "Project.findByProjectTitle", query = "SELECT p FROM Project p WHERE p.projectTitle = :projectTitle"),
    @NamedQuery(name = "Project.findByProjectDescription", query = "SELECT p FROM Project p WHERE p.projectDescription = :projectDescription"),
    @NamedQuery(name = "Project.findByProjectCmslink", query = "SELECT p FROM Project p WHERE p.projectCmslink = :projectCmslink"),
    @NamedQuery(name = "Project.findByStartDate", query = "SELECT p FROM Project p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Project.findByEndDate", query = "SELECT p FROM Project p WHERE p.endDate = :endDate"),
    @NamedQuery(name = "Project.findByProjectRegistrationDate", query = "SELECT p FROM Project p WHERE p.projectRegistrationDate = :projectRegistrationDate"),
    @NamedQuery(name = "Project.findByMaxVolunteerCount", query = "SELECT p FROM Project p WHERE p.maxVolunteerCount = :maxVolunteerCount"),
    @NamedQuery(name = "Project.findByProjectStatus", query = "SELECT p FROM Project p WHERE p.projectStatus = :projectStatus"),
    @NamedQuery(name = "Project.findByAddressStreet", query = "SELECT p FROM Project p WHERE p.addressStreet = :addressStreet"),
    @NamedQuery(name = "Project.findByAddressUnit", query = "SELECT p FROM Project p WHERE p.addressUnit = :addressUnit")})
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_id")
    private Long pkProjectId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "project_title")
    private String projectTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "project_description")
    private String projectDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "project_cmslink")
    private String projectCmslink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "project_registration_date")
    @Temporal(TemporalType.DATE)
    private Date projectRegistrationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_volunteer_count")
    private int maxVolunteerCount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "project_status")
    private int projectStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "address_street")
    private String addressStreet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "address_unit")
    private String addressUnit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<Benefactor> benefactorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<ProjectCategoryMapping> projectCategoryMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<NgoStatusMapping> ngoStatusMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<ProjectNgoMapping> projectNgoMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<ProjectAccountingMapping> projectAccountingMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<ProjectVolunteerMapping> projectVolunteerMappingCollection;
    @JoinColumn(name = "fk_cfg_barangay", referencedColumnName = "pk_cfg_barangay_id")
    @ManyToOne(optional = false)
    private CfgBarangay fkCfgBarangay;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @ManyToOne(optional = false)
    private Appuser fkAppuserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<ProjectExpenseMapping> projectExpenseMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<ProjectRatingMapping> projectRatingMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkProjectId")
    private Collection<ProjectCertificateMapping> projectCertificateMappingCollection;

    public Project() {
    }

    public Project(Long pkProjectId) {
        this.pkProjectId = pkProjectId;
    }

    public Project(Long pkProjectId, String projectTitle, String projectDescription, String projectCmslink, Date startDate, Date endDate, Date projectRegistrationDate, int maxVolunteerCount, int projectStatus, String addressStreet, String addressUnit) {
        this.pkProjectId = pkProjectId;
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectCmslink = projectCmslink;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectRegistrationDate = projectRegistrationDate;
        this.maxVolunteerCount = maxVolunteerCount;
        this.projectStatus = projectStatus;
        this.addressStreet = addressStreet;
        this.addressUnit = addressUnit;
    }

    public Long getPkProjectId() {
        return pkProjectId;
    }

    public void setPkProjectId(Long pkProjectId) {
        this.pkProjectId = pkProjectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectCmslink() {
        return projectCmslink;
    }

    public void setProjectCmslink(String projectCmslink) {
        this.projectCmslink = projectCmslink;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getProjectRegistrationDate() {
        return projectRegistrationDate;
    }

    public void setProjectRegistrationDate(Date projectRegistrationDate) {
        this.projectRegistrationDate = projectRegistrationDate;
    }

    public int getMaxVolunteerCount() {
        return maxVolunteerCount;
    }

    public void setMaxVolunteerCount(int maxVolunteerCount) {
        this.maxVolunteerCount = maxVolunteerCount;
    }

    public int getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressUnit() {
        return addressUnit;
    }

    public void setAddressUnit(String addressUnit) {
        this.addressUnit = addressUnit;
    }

    @XmlTransient
    public Collection<Benefactor> getBenefactorCollection() {
        return benefactorCollection;
    }

    public void setBenefactorCollection(Collection<Benefactor> benefactorCollection) {
        this.benefactorCollection = benefactorCollection;
    }

    @XmlTransient
    public Collection<ProjectCategoryMapping> getProjectCategoryMappingCollection() {
        return projectCategoryMappingCollection;
    }

    public void setProjectCategoryMappingCollection(Collection<ProjectCategoryMapping> projectCategoryMappingCollection) {
        this.projectCategoryMappingCollection = projectCategoryMappingCollection;
    }

    @XmlTransient
    public Collection<NgoStatusMapping> getNgoStatusMappingCollection() {
        return ngoStatusMappingCollection;
    }

    public void setNgoStatusMappingCollection(Collection<NgoStatusMapping> ngoStatusMappingCollection) {
        this.ngoStatusMappingCollection = ngoStatusMappingCollection;
    }

    @XmlTransient
    public Collection<ProjectNgoMapping> getProjectNgoMappingCollection() {
        return projectNgoMappingCollection;
    }

    public void setProjectNgoMappingCollection(Collection<ProjectNgoMapping> projectNgoMappingCollection) {
        this.projectNgoMappingCollection = projectNgoMappingCollection;
    }

    @XmlTransient
    public Collection<ProjectAccountingMapping> getProjectAccountingMappingCollection() {
        return projectAccountingMappingCollection;
    }

    public void setProjectAccountingMappingCollection(Collection<ProjectAccountingMapping> projectAccountingMappingCollection) {
        this.projectAccountingMappingCollection = projectAccountingMappingCollection;
    }

    @XmlTransient
    public Collection<ProjectVolunteerMapping> getProjectVolunteerMappingCollection() {
        return projectVolunteerMappingCollection;
    }

    public void setProjectVolunteerMappingCollection(Collection<ProjectVolunteerMapping> projectVolunteerMappingCollection) {
        this.projectVolunteerMappingCollection = projectVolunteerMappingCollection;
    }

    public CfgBarangay getFkCfgBarangay() {
        return fkCfgBarangay;
    }

    public void setFkCfgBarangay(CfgBarangay fkCfgBarangay) {
        this.fkCfgBarangay = fkCfgBarangay;
    }

    public Appuser getFkAppuserId() {
        return fkAppuserId;
    }

    public void setFkAppuserId(Appuser fkAppuserId) {
        this.fkAppuserId = fkAppuserId;
    }

    @XmlTransient
    public Collection<ProjectExpenseMapping> getProjectExpenseMappingCollection() {
        return projectExpenseMappingCollection;
    }

    public void setProjectExpenseMappingCollection(Collection<ProjectExpenseMapping> projectExpenseMappingCollection) {
        this.projectExpenseMappingCollection = projectExpenseMappingCollection;
    }

    @XmlTransient
    public Collection<ProjectRatingMapping> getProjectRatingMappingCollection() {
        return projectRatingMappingCollection;
    }

    public void setProjectRatingMappingCollection(Collection<ProjectRatingMapping> projectRatingMappingCollection) {
        this.projectRatingMappingCollection = projectRatingMappingCollection;
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
        hash += (pkProjectId != null ? pkProjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.pkProjectId == null && other.pkProjectId != null) || (this.pkProjectId != null && !this.pkProjectId.equals(other.pkProjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.Project[ pkProjectId=" + pkProjectId + " ]";
    }
    
}
