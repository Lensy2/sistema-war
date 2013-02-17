/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author root : Zavaleta De la Cruz Yury Daniel
 * Copyright 2011 Zavaleta De la Cruz Yury Daniel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
@Entity
@Table(name = "DETALLE_FACTURA_VENTA_PRODUCTO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleFacturaVentaProducto.findAll", query = "SELECT d FROM DetalleFacturaVentaProducto d"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByIdFacturaVenta", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.detalleFacturaVentaProductoPK.idFacturaVenta = :idFacturaVenta"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByIdProducto", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.detalleFacturaVentaProductoPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByCantidad", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByPrecioVenta", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.precioVenta = :precioVenta"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findByDescuento", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleFacturaVentaProducto.findBySubTotal", query = "SELECT d FROM DetalleFacturaVentaProducto d WHERE d.subTotal = :subTotal")})
public class DetalleFacturaVentaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFacturaVentaProductoPK detalleFacturaVentaProductoPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "PRECIO_VENTA", nullable = false, precision = 9, scale = 2)
    private BigDecimal precioVenta;
    @Basic(optional = false)
    @Column(name = "DESCUENTO", nullable = false, precision = 9, scale = 2)
    private BigDecimal descuento;
    @Basic(optional = false)
    @Column(name = "SUB_TOTAL", nullable = false, precision = 9, scale = 2)
    private BigDecimal subTotal;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "ID_FACTURA_VENTA", referencedColumnName = "ID_FACTURA_VENTA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FacturaVenta facturaVenta;

    public DetalleFacturaVentaProducto() {
    }

    public DetalleFacturaVentaProducto(DetalleFacturaVentaProductoPK detalleFacturaVentaProductoPK) {
        this.detalleFacturaVentaProductoPK = detalleFacturaVentaProductoPK;
    }

    public DetalleFacturaVentaProducto(DetalleFacturaVentaProductoPK detalleFacturaVentaProductoPK, int cantidad, BigDecimal precioVenta, BigDecimal descuento, BigDecimal subTotal) {
        this.detalleFacturaVentaProductoPK = detalleFacturaVentaProductoPK;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.descuento = descuento;
        this.subTotal = subTotal;
    }

    public DetalleFacturaVentaProducto(int idFacturaVenta, int idProducto) {
        this.detalleFacturaVentaProductoPK = new DetalleFacturaVentaProductoPK(idFacturaVenta, idProducto);
    }

    public DetalleFacturaVentaProductoPK getDetalleFacturaVentaProductoPK() {
        return detalleFacturaVentaProductoPK;
    }

    public void setDetalleFacturaVentaProductoPK(DetalleFacturaVentaProductoPK detalleFacturaVentaProductoPK) {
        this.detalleFacturaVentaProductoPK = detalleFacturaVentaProductoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleFacturaVentaProductoPK != null ? detalleFacturaVentaProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaVentaProducto)) {
            return false;
        }
        DetalleFacturaVentaProducto other = (DetalleFacturaVentaProducto) object;
        if ((this.detalleFacturaVentaProductoPK == null && other.detalleFacturaVentaProductoPK != null) || (this.detalleFacturaVentaProductoPK != null && !this.detalleFacturaVentaProductoPK.equals(other.detalleFacturaVentaProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFacturaVentaProducto[detalleFacturaVentaProductoPK=" + detalleFacturaVentaProductoPK + "]";
    }

}
