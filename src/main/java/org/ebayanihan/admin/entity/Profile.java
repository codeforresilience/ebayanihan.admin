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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Eris
 */
@Entity
@Table(name = "profile")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
    @NamedQuery(name = "Profile.findByPkProfileId", query = "SELECT p FROM Profile p WHERE p.pkProfileId = :pkProfileId"),
    @NamedQuery(name = "Profile.findByMobileNumber", query = "SELECT p FROM Profile p WHERE p.mobileNumber = :mobileNumber"),
    @NamedQuery(name = "Profile.findByBusinessEmail", query = "SELECT p FROM Profile p WHERE p.businessEmail = :businessEmail"),
    @NamedQuery(name = "Profile.findByLandline", query = "SELECT p FROM Profile p WHERE p.landline = :landline"),
    @NamedQuery(name = "Profile.findByAddressZipCode", query = "SELECT p FROM Profile p WHERE p.addressZipCode = :addressZipCode"),
    @NamedQuery(name = "Profile.findByAddressStreetSubdivision", query = "SELECT p FROM Profile p WHERE p.addressStreetSubdivision = :addressStreetSubdivision"),
    @NamedQuery(name = "Profile.findByAddressRoomFloorUnit", query = "SELECT p FROM Profile p WHERE p.addressRoomFloorUnit = :addressRoomFloorUnit"),
    @NamedQuery(name = "Profile.findByGoogleMap", query = "SELECT p FROM Profile p WHERE p.googleMap = :googleMap"),
    @NamedQuery(name = "Profile.findByIdentificationNoType", query = "SELECT p FROM Profile p WHERE p.identificationNoType = :identificationNoType"),
    @NamedQuery(name = "Profile.findByIdentificationNo", query = "SELECT p FROM Profile p WHERE p.identificationNo = :identificationNo"),
    @NamedQuery(name = "Profile.findByEmergencyPersonName", query = "SELECT p FROM Profile p WHERE p.emergencyPersonName = :emergencyPersonName"),
    @NamedQuery(name = "Profile.findByEmergencyContactNo", query = "SELECT p FROM Profile p WHERE p.emergencyContactNo = :emergencyContactNo"),
    @NamedQuery(name = "Profile.findByPrivacyLevel", query = "SELECT p FROM Profile p WHERE p.privacyLevel = :privacyLevel"),
    @NamedQuery(name = "Profile.findBySiteLink", query = "SELECT p FROM Profile p WHERE p.siteLink = :siteLink"),
    @NamedQuery(name = "Profile.findByRegularJob", query = "SELECT p FROM Profile p WHERE p.regularJob = :regularJob"),
    @NamedQuery(name = "Profile.findByRemarks", query = "SELECT p FROM Profile p WHERE p.remarks = :remarks")})
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_profile_id")
    private Long pkProfileId;
    @Size(max = 50)
    @Column(name = "mobile_number")
    private String mobileNumber;
    @Size(max = 500)
    @Column(name = "business_email")
    private String businessEmail;
    @Size(max = 50)
    @Column(name = "landline")
    private String landline;
    @Size(max = 7)
    @Column(name = "address_zip_code")
    private String addressZipCode;
    @Size(max = 50)
    @Column(name = "address_street_subdivision")
    private String addressStreetSubdivision;
    @Size(max = 50)
    @Column(name = "address_room_floor_unit")
    private String addressRoomFloorUnit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "google_map")
    private Double googleMap;
    @Size(max = 50)
    @Column(name = "identification_no_type")
    private String identificationNoType;
    @Size(max = 50)
    @Column(name = "identification_no")
    private String identificationNo;
    @Size(max = 50)
    @Column(name = "emergency_person_name")
    private String emergencyPersonName;
    @Size(max = 50)
    @Column(name = "emergency_contact_no")
    private String emergencyContactNo;
    @Column(name = "privacy_level")
    private Integer privacyLevel;
    @Size(max = 2147483647)
    @Column(name = "site_link")
    private String siteLink;
    @Size(max = 250)
    @Column(name = "regular_job")
    private String regularJob;
    @Size(max = 2147483647)
    @Column(name = "remarks")
    private String remarks;
    @JoinColumn(name = "address_fk_cfg_stateprovince_id", referencedColumnName = "pk_cfg_stateprovince_id")
    @ManyToOne(optional = false)
    private CfgStateprovince addressFkCfgStateprovinceId;
    @JoinColumn(name = "address_fk_cfg_country_id", referencedColumnName = "pk_cfg_country_id")
    @ManyToOne(optional = false)
    private CfgCountry addressFkCfgCountryId;
    @JoinColumn(name = "address_fk_cfg_citytown_id", referencedColumnName = "pk_cfg_citytown_id")
    @ManyToOne(optional = false)
    private CfgCitytown addressFkCfgCitytownId;
    @JoinColumn(name = "address_fk_cfg_barangay_id", referencedColumnName = "pk_cfg_barangay_id")
    @ManyToOne(optional = false)
    private CfgBarangay addressFkCfgBarangayId;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @OneToOne(optional = false)
    private Appuser fkAppuserId;

    public Profile() {
    }

    public Profile(Long pkProfileId) {
        this.pkProfileId = pkProfileId;
    }

    public Long getPkProfileId() {
        return pkProfileId;
    }

    public void setPkProfileId(Long pkProfileId) {
        this.pkProfileId = pkProfileId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBusinessEmail() {
        return businessEmail;
    }

    public void setBusinessEmail(String businessEmail) {
        this.businessEmail = businessEmail;
    }

    public String getLandline() {
        return landline;
    }

    public void setLandline(String landline) {
        this.landline = landline;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public String getAddressStreetSubdivision() {
        return addressStreetSubdivision;
    }

    public void setAddressStreetSubdivision(String addressStreetSubdivision) {
        this.addressStreetSubdivision = addressStreetSubdivision;
    }

    public String getAddressRoomFloorUnit() {
        return addressRoomFloorUnit;
    }

    public void setAddressRoomFloorUnit(String addressRoomFloorUnit) {
        this.addressRoomFloorUnit = addressRoomFloorUnit;
    }

    public Double getGoogleMap() {
        return googleMap;
    }

    public void setGoogleMap(Double googleMap) {
        this.googleMap = googleMap;
    }

    public String getIdentificationNoType() {
        return identificationNoType;
    }

    public void setIdentificationNoType(String identificationNoType) {
        this.identificationNoType = identificationNoType;
    }

    public String getIdentificationNo() {
        return identificationNo;
    }

    public void setIdentificationNo(String identificationNo) {
        this.identificationNo = identificationNo;
    }

    public String getEmergencyPersonName() {
        return emergencyPersonName;
    }

    public void setEmergencyPersonName(String emergencyPersonName) {
        this.emergencyPersonName = emergencyPersonName;
    }

    public String getEmergencyContactNo() {
        return emergencyContactNo;
    }

    public void setEmergencyContactNo(String emergencyContactNo) {
        this.emergencyContactNo = emergencyContactNo;
    }

    public Integer getPrivacyLevel() {
        return privacyLevel;
    }

    public void setPrivacyLevel(Integer privacyLevel) {
        this.privacyLevel = privacyLevel;
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        this.siteLink = siteLink;
    }

    public String getRegularJob() {
        return regularJob;
    }

    public void setRegularJob(String regularJob) {
        this.regularJob = regularJob;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public CfgStateprovince getAddressFkCfgStateprovinceId() {
        return addressFkCfgStateprovinceId;
    }

    public void setAddressFkCfgStateprovinceId(CfgStateprovince addressFkCfgStateprovinceId) {
        this.addressFkCfgStateprovinceId = addressFkCfgStateprovinceId;
    }

    public CfgCountry getAddressFkCfgCountryId() {
        return addressFkCfgCountryId;
    }

    public void setAddressFkCfgCountryId(CfgCountry addressFkCfgCountryId) {
        this.addressFkCfgCountryId = addressFkCfgCountryId;
    }

    public CfgCitytown getAddressFkCfgCitytownId() {
        return addressFkCfgCitytownId;
    }

    public void setAddressFkCfgCitytownId(CfgCitytown addressFkCfgCitytownId) {
        this.addressFkCfgCitytownId = addressFkCfgCitytownId;
    }

    public CfgBarangay getAddressFkCfgBarangayId() {
        return addressFkCfgBarangayId;
    }

    public void setAddressFkCfgBarangayId(CfgBarangay addressFkCfgBarangayId) {
        this.addressFkCfgBarangayId = addressFkCfgBarangayId;
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
        hash += (pkProfileId != null ? pkProfileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.pkProfileId == null && other.pkProfileId != null) || (this.pkProfileId != null && !this.pkProfileId.equals(other.pkProfileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.Profile[ pkProfileId=" + pkProfileId + " ]";
    }
    
}
