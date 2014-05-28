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
@Table(name = "cfg_expense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgExpense.findAll", query = "SELECT c FROM CfgExpense c"),
    @NamedQuery(name = "CfgExpense.findByPkCfgExpenseId", query = "SELECT c FROM CfgExpense c WHERE c.pkCfgExpenseId = :pkCfgExpenseId"),
    @NamedQuery(name = "CfgExpense.findByExpenseName", query = "SELECT c FROM CfgExpense c WHERE c.expenseName = :expenseName"),
    @NamedQuery(name = "CfgExpense.findByExpenseDescription", query = "SELECT c FROM CfgExpense c WHERE c.expenseDescription = :expenseDescription")})
public class CfgExpense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_cfg_expense_id")
    private Long pkCfgExpenseId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "expense_name")
    private String expenseName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "expense_description")
    private String expenseDescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCfgExpenseId")
    private Collection<ProjectExpenseMapping> projectExpenseMappingCollection;

    public CfgExpense() {
    }

    public CfgExpense(Long pkCfgExpenseId) {
        this.pkCfgExpenseId = pkCfgExpenseId;
    }

    public CfgExpense(Long pkCfgExpenseId, String expenseName, String expenseDescription) {
        this.pkCfgExpenseId = pkCfgExpenseId;
        this.expenseName = expenseName;
        this.expenseDescription = expenseDescription;
    }

    public Long getPkCfgExpenseId() {
        return pkCfgExpenseId;
    }

    public void setPkCfgExpenseId(Long pkCfgExpenseId) {
        this.pkCfgExpenseId = pkCfgExpenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }

    @XmlTransient
    public Collection<ProjectExpenseMapping> getProjectExpenseMappingCollection() {
        return projectExpenseMappingCollection;
    }

    public void setProjectExpenseMappingCollection(Collection<ProjectExpenseMapping> projectExpenseMappingCollection) {
        this.projectExpenseMappingCollection = projectExpenseMappingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCfgExpenseId != null ? pkCfgExpenseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgExpense)) {
            return false;
        }
        CfgExpense other = (CfgExpense) object;
        if ((this.pkCfgExpenseId == null && other.pkCfgExpenseId != null) || (this.pkCfgExpenseId != null && !this.pkCfgExpenseId.equals(other.pkCfgExpenseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.CfgExpense[ pkCfgExpenseId=" + pkCfgExpenseId + " ]";
    }
    
}
