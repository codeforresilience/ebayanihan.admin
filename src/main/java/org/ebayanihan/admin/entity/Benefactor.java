/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ebayanihan.admin.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "benefactor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Benefactor.findAll", query = "SELECT b FROM Benefactor b"),
    @NamedQuery(name = "Benefactor.findByPkBenefactorId", query = "SELECT b FROM Benefactor b WHERE b.pkBenefactorId = :pkBenefactorId"),
    @NamedQuery(name = "Benefactor.findByBenefactorName", query = "SELECT b FROM Benefactor b WHERE b.benefactorName = :benefactorName"),
    @NamedQuery(name = "Benefactor.findByFromAmount", query = "SELECT b FROM Benefactor b WHERE b.fromAmount = :fromAmount"),
    @NamedQuery(name = "Benefactor.findByFromCurrency", query = "SELECT b FROM Benefactor b WHERE b.fromCurrency = :fromCurrency"),
    @NamedQuery(name = "Benefactor.findByForexRate", query = "SELECT b FROM Benefactor b WHERE b.forexRate = :forexRate"),
    @NamedQuery(name = "Benefactor.findByToAmount", query = "SELECT b FROM Benefactor b WHERE b.toAmount = :toAmount"),
    @NamedQuery(name = "Benefactor.findByToCurrency", query = "SELECT b FROM Benefactor b WHERE b.toCurrency = :toCurrency"),
    @NamedQuery(name = "Benefactor.findByStatus", query = "SELECT b FROM Benefactor b WHERE b.status = :status"),
    @NamedQuery(name = "Benefactor.findByRemainingBalance", query = "SELECT b FROM Benefactor b WHERE b.remainingBalance = :remainingBalance"),
    @NamedQuery(name = "Benefactor.findByTransactionNumber", query = "SELECT b FROM Benefactor b WHERE b.transactionNumber = :transactionNumber"),
    @NamedQuery(name = "Benefactor.findByContactNumber", query = "SELECT b FROM Benefactor b WHERE b.contactNumber = :contactNumber"),
    @NamedQuery(name = "Benefactor.findByContactEmail", query = "SELECT b FROM Benefactor b WHERE b.contactEmail = :contactEmail"),
    @NamedQuery(name = "Benefactor.findByVerified", query = "SELECT b FROM Benefactor b WHERE b.verified = :verified")})
public class Benefactor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_benefactor_id")
    private Long pkBenefactorId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "benefactor_name")
    private String benefactorName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "from_amount")
    private BigInteger fromAmount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "from_currency")
    private String fromCurrency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forex_rate")
    private BigInteger forexRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_amount")
    private BigInteger toAmount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "to_currency")
    private String toCurrency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "remaining_balance")
    private BigInteger remainingBalance;
    @Size(max = 2147483647)
    @Column(name = "transaction_number")
    private String transactionNumber;
    @Size(max = 2147483647)
    @Column(name = "contact_number")
    private String contactNumber;
    @Size(max = 2147483647)
    @Column(name = "contact_email")
    private String contactEmail;
    @Column(name = "verified")
    private Integer verified;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;
    @JoinColumn(name = "fk_cfg_paymentmethod_id", referencedColumnName = "pk_cfg_paymentmethod_id")
    @ManyToOne(optional = false)
    private CfgPaymentmethod fkCfgPaymentmethodId;
    @JoinColumn(name = "fk_appuser_id", referencedColumnName = "pk_appuser_id")
    @ManyToOne(optional = false)
    private Appuser fkAppuserId;

    public Benefactor() {
    }

    public Benefactor(Long pkBenefactorId) {
        this.pkBenefactorId = pkBenefactorId;
    }

    public Benefactor(Long pkBenefactorId, String benefactorName, BigInteger fromAmount, String fromCurrency, BigInteger forexRate, BigInteger toAmount, String toCurrency, int status, BigInteger remainingBalance) {
        this.pkBenefactorId = pkBenefactorId;
        this.benefactorName = benefactorName;
        this.fromAmount = fromAmount;
        this.fromCurrency = fromCurrency;
        this.forexRate = forexRate;
        this.toAmount = toAmount;
        this.toCurrency = toCurrency;
        this.status = status;
        this.remainingBalance = remainingBalance;
    }

    public Long getPkBenefactorId() {
        return pkBenefactorId;
    }

    public void setPkBenefactorId(Long pkBenefactorId) {
        this.pkBenefactorId = pkBenefactorId;
    }

    public String getBenefactorName() {
        return benefactorName;
    }

    public void setBenefactorName(String benefactorName) {
        this.benefactorName = benefactorName;
    }

    public BigInteger getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigInteger fromAmount) {
        this.fromAmount = fromAmount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public BigInteger getForexRate() {
        return forexRate;
    }

    public void setForexRate(BigInteger forexRate) {
        this.forexRate = forexRate;
    }

    public BigInteger getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigInteger toAmount) {
        this.toAmount = toAmount;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigInteger getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(BigInteger remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Project getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(Project fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    public CfgPaymentmethod getFkCfgPaymentmethodId() {
        return fkCfgPaymentmethodId;
    }

    public void setFkCfgPaymentmethodId(CfgPaymentmethod fkCfgPaymentmethodId) {
        this.fkCfgPaymentmethodId = fkCfgPaymentmethodId;
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
        hash += (pkBenefactorId != null ? pkBenefactorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benefactor)) {
            return false;
        }
        Benefactor other = (Benefactor) object;
        if ((this.pkBenefactorId == null && other.pkBenefactorId != null) || (this.pkBenefactorId != null && !this.pkBenefactorId.equals(other.pkBenefactorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.Benefactor[ pkBenefactorId=" + pkBenefactorId + " ]";
    }
    
}
