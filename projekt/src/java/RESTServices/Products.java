/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RESTServices;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hans-erik
 */
@Entity
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p"),
    @NamedQuery(name = "Products.findByPname", query = "SELECT p FROM Products p WHERE p.pname = :pname"),
    @NamedQuery(name = "Products.findByCost", query = "SELECT p FROM Products p WHERE p.cost = :cost")})
public class Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PNAME")
    private String pname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COST")
    private int cost;

    public Products() {
    }

    public Products(String pname) {
        this.pname = pname;
    }

    public Products(String pname, int cost) {
        this.pname = pname;
        this.cost = cost;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pname != null ? pname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.pname == null && other.pname != null) || (this.pname != null && !this.pname.equals(other.pname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RESTServices.Products[ pname=" + pname + " ]";
    }
    
}
