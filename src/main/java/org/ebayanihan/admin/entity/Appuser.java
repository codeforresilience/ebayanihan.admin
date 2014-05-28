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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "appuser")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Appuser.findAll", query = "SELECT a FROM Appuser a"),
    @NamedQuery(name = "Appuser.findByPkAppuserId", query = "SELECT a FROM Appuser a WHERE a.pkAppuserId = :pkAppuserId"),
    @NamedQuery(name = "Appuser.findByAccountName", query = "SELECT a FROM Appuser a WHERE a.accountName = :accountName"),
    @NamedQuery(name = "Appuser.findByFirstName", query = "SELECT a FROM Appuser a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Appuser.findByLastName", query = "SELECT a FROM Appuser a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Appuser.findByAccountEmail", query = "SELECT a FROM Appuser a WHERE a.accountEmail = :accountEmail"),
    @NamedQuery(name = "Appuser.findByBirthday", query = "SELECT a FROM Appuser a WHERE a.birthday = :birthday"),
    @NamedQuery(name = "Appuser.findByMembershipDate", query = "SELECT a FROM Appuser a WHERE a.membershipDate = :membershipDate"),
    @NamedQuery(name = "Appuser.findByLastLogin", query = "SELECT a FROM Appuser a WHERE a.lastLogin = :lastLogin"),
    @NamedQuery(name = "Appuser.findByPicture", query = "SELECT a FROM Appuser a WHERE a.picture = :picture"),
    @NamedQuery(name = "Appuser.findByAccountStatus", query = "SELECT a FROM Appuser a WHERE a.accountStatus = :accountStatus")})
public class Appuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_appuser_id")
    private Long pkAppuserId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "account_name")
    private String accountName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "account_email")
    private String accountEmail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Column(name = "membership_date")
    @Temporal(TemporalType.DATE)
    private Date membershipDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Size(max = 2147483647)
    @Column(name = "picture")
    private String picture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "account_status")
    private int accountStatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Collection<Benefactor> benefactorCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Ngo ngo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Collection<ProjectAccountingMapping> projectAccountingMappingCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Advocacy advocacy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Collection<ProjectVolunteerMapping> projectVolunteerMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Collection<Project> projectCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Collection<ProjectRatingMapping> projectRatingMappingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Collection<ProjectCertificateMapping> projectCertificateMappingCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "fkAppuserId")
    private Profile profile;

    public Appuser() {
    }

    public Appuser(Long pkAppuserId) {
        this.pkAppuserId = pkAppuserId;
    }

    public Appuser(Long pkAppuserId, String accountName, String firstName, String lastName, String accountEmail, Date birthday, Date membershipDate, Date lastLogin, int accountStatus) {
        this.pkAppuserId = pkAppuserId;
        this.accountName = accountName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountEmail = accountEmail;
        this.birthday = birthday;
        this.membershipDate = membershipDate;
        this.lastLogin = lastLogin;
        this.accountStatus = accountStatus;
    }

    public Long getPkAppuserId() {
        return pkAppuserId;
    }

    public void setPkAppuserId(Long pkAppuserId) {
        this.pkAppuserId = pkAppuserId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(Date membershipDate) {
        this.membershipDate = membershipDate;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(int accountStatus) {
        this.accountStatus = accountStatus;
    }

    @XmlTransient
    public Collection<Benefactor> getBenefactorCollection() {
        return benefactorCollection;
    }

    public void setBenefactorCollection(Collection<Benefactor> benefactorCollection) {
        this.benefactorCollection = benefactorCollection;
    }

    public Ngo getNgo() {
        return ngo;
    }

    public void setNgo(Ngo ngo) {
        this.ngo = ngo;
    }

    @XmlTransient
    public Collection<ProjectAccountingMapping> getProjectAccountingMappingCollection() {
        return projectAccountingMappingCollection;
    }

    public void setProjectAccountingMappingCollection(Collection<ProjectAccountingMapping> projectAccountingMappingCollection) {
        this.projectAccountingMappingCollection = projectAccountingMappingCollection;
    }

    public Advocacy getAdvocacy() {
        return advocacy;
    }

    public void setAdvocacy(Advocacy advocacy) {
        this.advocacy = advocacy;
    }

    @XmlTransient
    public Collection<ProjectVolunteerMapping> getProjectVolunteerMappingCollection() {
        return projectVolunteerMappingCollection;
    }

    public void setProjectVolunteerMappingCollection(Collection<ProjectVolunteerMapping> projectVolunteerMappingCollection) {
        this.projectVolunteerMappingCollection = projectVolunteerMappingCollection;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
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

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkAppuserId != null ? pkAppuserId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appuser)) {
            return false;
        }
        Appuser other = (Appuser) object;
        if ((this.pkAppuserId == null && other.pkAppuserId != null) || (this.pkAppuserId != null && !this.pkAppuserId.equals(other.pkAppuserId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.Appuser[ pkAppuserId=" + pkAppuserId + " ]";
    }
    
}
