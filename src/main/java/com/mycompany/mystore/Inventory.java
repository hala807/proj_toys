/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mystore;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author ALaa MAHMOUD
 */
@Entity
@Table(name = "inventory")
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByCabinetId", query = "SELECT i FROM Inventory i WHERE i.cabinetId = :cabinetId"),
    @NamedQuery(name = "Inventory.findByStockquantity", query = "SELECT i FROM Inventory i WHERE i.stockquantity = :stockquantity")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cabinet_id")
    private Integer cabinetId;
    @Column(name = "stockquantity")
    private String stockquantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cabinetId")
    private Collection<Product> productCollection;
    @JoinColumn(name = "manegar", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employee manegar;

    public Inventory() {
    }

    public Inventory(Integer cabinetId) {
        this.cabinetId = cabinetId;
    }

    public Integer getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Integer cabinetId) {
        this.cabinetId = cabinetId;
    }

    public String getStockquantity() {
        return stockquantity;
    }

    public void setStockquantity(String stockquantity) {
        this.stockquantity = stockquantity;
    }

    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    public Employee getManegar() {
        return manegar;
    }

    public void setManegar(Employee manegar) {
        this.manegar = manegar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cabinetId != null ? cabinetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.cabinetId == null && other.cabinetId != null) || (this.cabinetId != null && !this.cabinetId.equals(other.cabinetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mystore.Inventory[ cabinetId=" + cabinetId + " ]";
    }
    
}
