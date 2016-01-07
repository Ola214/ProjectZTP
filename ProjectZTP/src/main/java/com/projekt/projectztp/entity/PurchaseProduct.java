/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekt.projectztp.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Olaa
 */
@Entity
@Table(name = "purchase_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseProduct.findAll", query = "SELECT p FROM PurchaseProduct p"),
    @NamedQuery(name = "PurchaseProduct.findByLogin", query = "SELECT p FROM PurchaseProduct p WHERE p.purchaseId.userId.login = :login"),
    @NamedQuery(name = "PurchaseProduct.findAllNull", query = "SELECT p FROM PurchaseProduct p WHERE p.acceptanceDate IS NULL"),
    @NamedQuery(name = "PurchaseProduct.findAllNullForUser", query = "SELECT p FROM PurchaseProduct p WHERE p.acceptanceDate IS NULL AND p.purchaseId.userId.login = :login"),
    @NamedQuery(name = "PurchaseProduct.findById", query = "SELECT p FROM PurchaseProduct p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseProduct.findByQuantity", query = "SELECT p FROM PurchaseProduct p WHERE p.quantity = :quantity")})
public class PurchaseProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    private long quantity;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "PURCHASE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Purchase purchaseId;
    @Column(name = "ACCEPTANCE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date acceptanceDate;

    public PurchaseProduct() {
    }

    public PurchaseProduct(Long id) {
        this.id = id;
    }

    public PurchaseProduct(Long id, long quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Purchase getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Purchase purchaseId) {
        this.purchaseId = purchaseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseProduct)) {
            return false;
        }
        PurchaseProduct other = (PurchaseProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    public Date getAcceptanceDate() {
        return acceptanceDate;
    }

    public void setAcceptanceDate(Date acceptanceDate) {
        this.acceptanceDate = acceptanceDate;
    }

    @Override
    public String toString() {
        return id.toString();
        //return "com.projekt.projectztp.entity.PurchaseProduct[ id=" + id + " ]";
    }
    
}
