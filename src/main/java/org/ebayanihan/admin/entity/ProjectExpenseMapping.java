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
@Table(name = "project_expense_mapping")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProjectExpenseMapping.findAll", query = "SELECT p FROM ProjectExpenseMapping p"),
    @NamedQuery(name = "ProjectExpenseMapping.findByPkProjectExpenseMappingId", query = "SELECT p FROM ProjectExpenseMapping p WHERE p.pkProjectExpenseMappingId = :pkProjectExpenseMappingId"),
    @NamedQuery(name = "ProjectExpenseMapping.findByItemName", query = "SELECT p FROM ProjectExpenseMapping p WHERE p.itemName = :itemName"),
    @NamedQuery(name = "ProjectExpenseMapping.findByActualCost", query = "SELECT p FROM ProjectExpenseMapping p WHERE p.actualCost = :actualCost")})
public class ProjectExpenseMapping implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_project_expense_mapping_id")
    private Long pkProjectExpenseMappingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "item_name")
    private String itemName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "actual_cost")
    private double actualCost;
    @JoinColumn(name = "fk_project_id", referencedColumnName = "pk_project_id")
    @ManyToOne(optional = false)
    private Project fkProjectId;
    @JoinColumn(name = "fk_cfg_expense_id", referencedColumnName = "pk_cfg_expense_id")
    @ManyToOne(optional = false)
    private CfgExpense fkCfgExpenseId;

    public ProjectExpenseMapping() {
    }

    public ProjectExpenseMapping(Long pkProjectExpenseMappingId) {
        this.pkProjectExpenseMappingId = pkProjectExpenseMappingId;
    }

    public ProjectExpenseMapping(Long pkProjectExpenseMappingId, String itemName, double actualCost) {
        this.pkProjectExpenseMappingId = pkProjectExpenseMappingId;
        this.itemName = itemName;
        this.actualCost = actualCost;
    }

    public Long getPkProjectExpenseMappingId() {
        return pkProjectExpenseMappingId;
    }

    public void setPkProjectExpenseMappingId(Long pkProjectExpenseMappingId) {
        this.pkProjectExpenseMappingId = pkProjectExpenseMappingId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getActualCost() {
        return actualCost;
    }

    public void setActualCost(double actualCost) {
        this.actualCost = actualCost;
    }

    public Project getFkProjectId() {
        return fkProjectId;
    }

    public void setFkProjectId(Project fkProjectId) {
        this.fkProjectId = fkProjectId;
    }

    public CfgExpense getFkCfgExpenseId() {
        return fkCfgExpenseId;
    }

    public void setFkCfgExpenseId(CfgExpense fkCfgExpenseId) {
        this.fkCfgExpenseId = fkCfgExpenseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProjectExpenseMappingId != null ? pkProjectExpenseMappingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectExpenseMapping)) {
            return false;
        }
        ProjectExpenseMapping other = (ProjectExpenseMapping) object;
        if ((this.pkProjectExpenseMappingId == null && other.pkProjectExpenseMappingId != null) || (this.pkProjectExpenseMappingId != null && !this.pkProjectExpenseMappingId.equals(other.pkProjectExpenseMappingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.ProjectExpenseMapping[ pkProjectExpenseMappingId=" + pkProjectExpenseMappingId + " ]";
    }
    
}
