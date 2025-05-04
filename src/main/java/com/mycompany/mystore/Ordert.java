/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mystore;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ALaa MAHMOUD
 */
@Entity
@Table(name = "ordert")
@NamedQueries({
    @NamedQuery(name = "Ordert.findAll", query = "SELECT o FROM Ordert o"),
    @NamedQuery(name = "Ordert.findByOrderId", query = "SELECT o FROM Ordert o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Ordert.findByDate", query = "SELECT o FROM Ordert o WHERE o.date = :date"),
    @NamedQuery(name = "Ordert.findByTotalprice", query = "SELECT o FROM Ordert o WHERE o.totalprice = :totalprice"),
    @NamedQuery(name = "Ordert.findByDeliverystatus", query = "SELECT o FROM Ordert o WHERE o.deliverystatus = :deliverystatus"),
    @NamedQuery(name = "Ordert.findByPaymenlmethod", query = "SELECT o FROM Ordert o WHERE o.paymenlmethod = :paymenlmethod")})
public class Ordert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "totalprice")
    private BigInteger totalprice;
    @Column(name = "deliverystatus")
    private Short deliverystatus;
    @Column(name = "paymenlmethod")
    private String paymenlmethod;
    @JoinTable(name = "order_product", joinColumns = {
        @JoinColumn(name = "order_id", referencedColumnName = "order_id")}, inverseJoinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "product_id")})
    @ManyToMany
    private Collection<Product> productCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "customers_id")
    @ManyToOne(optional = false)
    private Customers customerId;
    @JoinColumn(name = "employe_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employee employeId;

    public Ordert() {
    }

    public Ordert(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigInteger getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigInteger totalprice) {
        this.totalprice = totalprice;
    }

    public Short getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(Short deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public String getPaymenlmethod() {
        return paymenlmethod;
    }

    public void setPaymenlmethod(String paymenlmethod) {
        this.paymenlmethod = paymenlmethod;
    }

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Customers getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customers customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Employee employeId) {
        this.employeId = employeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordert)) {
            return false;
        }
        Ordert other = (Ordert) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mystore.Ordert[ orderId=" + orderId + " ]";
    }
    
}
