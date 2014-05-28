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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author John Eris
 */
@Entity
@Table(name = "constant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constant.findAll", query = "SELECT c FROM Constant c"),
    @NamedQuery(name = "Constant.findByPkConstantId", query = "SELECT c FROM Constant c WHERE c.pkConstantId = :pkConstantId"),
    @NamedQuery(name = "Constant.findByConstantName", query = "SELECT c FROM Constant c WHERE c.constantName = :constantName"),
    @NamedQuery(name = "Constant.findByConstantValue", query = "SELECT c FROM Constant c WHERE c.constantValue = :constantValue")})
public class Constant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_constant_id")
    private Integer pkConstantId;
    @Size(max = 25)
    @Column(name = "constant_name")
    private String constantName;
    @Size(max = 2147483647)
    @Column(name = "constant_value")
    private String constantValue;

    public Constant() {
    }

    public Constant(Integer pkConstantId) {
        this.pkConstantId = pkConstantId;
    }

    public Integer getPkConstantId() {
        return pkConstantId;
    }

    public void setPkConstantId(Integer pkConstantId) {
        this.pkConstantId = pkConstantId;
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkConstantId != null ? pkConstantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constant)) {
            return false;
        }
        Constant other = (Constant) object;
        if ((this.pkConstantId == null && other.pkConstantId != null) || (this.pkConstantId != null && !this.pkConstantId.equals(other.pkConstantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.ebayanihan.admin.Constant[ pkConstantId=" + pkConstantId + " ]";
    }
    
}
