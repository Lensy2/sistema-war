/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "ORDEN_COMPRA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "OrdenCompra.findAll", query = "SELECT o FROM OrdenCompra o"),
    @NamedQuery(name = "OrdenCompra.findByIdOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.idOrdenCompra = :idOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByFechaCreacionOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.fechaCreacionOrdenCompra = :fechaCreacionOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByFechaEntregaOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.fechaEntregaOrdenCompra = :fechaEntregaOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByTotalOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.totalOrdenCompra = :totalOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByTotalPagosCreditoOrdenCompra", query = "SELECT o FROM OrdenCompra o WHERE o.totalPagosCreditoOrdenCompra = :totalPagosCreditoOrdenCompra"),
    @NamedQuery(name = "OrdenCompra.findByObservaciones", query = "SELECT o FROM OrdenCompra o WHERE o.observaciones = :observaciones")})
public class OrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDEN_COMPRA", nullable = false)
    private Integer idOrdenCompra;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION_ORDEN_COMPRA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionOrdenCompra;
    @Basic(optional = false)
    @Column(name = "FECHA_ENTREGA_ORDEN_COMPRA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEntregaOrdenCompra;
    @Basic(optional = false)
    @Column(name = "TOTAL_ORDEN_COMPRA", nullable = false, precision = 9, scale = 2)
    private BigDecimal totalOrdenCompra;
    @Basic(optional = false)
    @Column(name = "TOTAL_PAGOS_CREDITO_ORDEN_COMPRA", nullable = false, precision = 9, scale = 2)
    private BigDecimal totalPagosCreditoOrdenCompra;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES", nullable = false, length = 300)
    private String observaciones;
    @OneToMany(mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    private List<PagoCompraCredito> pagoCompraCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    private List<CanjeOrdenCompra> canjeOrdenCompraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    private List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenCompra", fetch = FetchType.LAZY)
    private List<FacturaCompra> facturaCompraList;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor proveedor;
    @JoinColumn(name = "ID_ESTADO_FACTURACION_ORDEN_COMPRA", referencedColumnName = "ID_ESTADO_FACTURACION_ORDEN_COMPRA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoFacturacionOrdenCompra estadoFacturacionOrdenCompra;
    @JoinColumn(name = "ID_ESTADO_ORDEN_COMPRA", referencedColumnName = "ID_ESTADO_ORDEN_COMPRA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoOrdenCompra estadoOrdenCompra;

    public OrdenCompra() {
    }

    public OrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public OrdenCompra(Integer idOrdenCompra, Date fechaCreacionOrdenCompra, Date fechaEntregaOrdenCompra, BigDecimal totalOrdenCompra, BigDecimal totalPagosCreditoOrdenCompra, String observaciones) {
        this.idOrdenCompra = idOrdenCompra;
        this.fechaCreacionOrdenCompra = fechaCreacionOrdenCompra;
        this.fechaEntregaOrdenCompra = fechaEntregaOrdenCompra;
        this.totalOrdenCompra = totalOrdenCompra;
        this.totalPagosCreditoOrdenCompra = totalPagosCreditoOrdenCompra;
        this.observaciones = observaciones;
    }

    public Integer getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(Integer idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public Date getFechaCreacionOrdenCompra() {
        return fechaCreacionOrdenCompra;
    }

    public void setFechaCreacionOrdenCompra(Date fechaCreacionOrdenCompra) {
        this.fechaCreacionOrdenCompra = fechaCreacionOrdenCompra;
    }

    public Date getFechaEntregaOrdenCompra() {
        return fechaEntregaOrdenCompra;
    }

    public void setFechaEntregaOrdenCompra(Date fechaEntregaOrdenCompra) {
        this.fechaEntregaOrdenCompra = fechaEntregaOrdenCompra;
    }

    public BigDecimal getTotalOrdenCompra() {
        return totalOrdenCompra;
    }

    public void setTotalOrdenCompra(BigDecimal totalOrdenCompra) {
        this.totalOrdenCompra = totalOrdenCompra;
    }

    public BigDecimal getTotalPagosCreditoOrdenCompra() {
        return totalPagosCreditoOrdenCompra;
    }

    public void setTotalPagosCreditoOrdenCompra(BigDecimal totalPagosCreditoOrdenCompra) {
        this.totalPagosCreditoOrdenCompra = totalPagosCreditoOrdenCompra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<PagoCompraCredito> getPagoCompraCreditoList() {
        return pagoCompraCreditoList;
    }

    public void setPagoCompraCreditoList(List<PagoCompraCredito> pagoCompraCreditoList) {
        this.pagoCompraCreditoList = pagoCompraCreditoList;
    }

    public List<CanjeOrdenCompra> getCanjeOrdenCompraList() {
        return canjeOrdenCompraList;
    }

    public void setCanjeOrdenCompraList(List<CanjeOrdenCompra> canjeOrdenCompraList) {
        this.canjeOrdenCompraList = canjeOrdenCompraList;
    }

    public List<DetalleOrdenCompraProducto> getDetalleOrdenCompraProductoList() {
        return detalleOrdenCompraProductoList;
    }

    public void setDetalleOrdenCompraProductoList(List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList) {
        this.detalleOrdenCompraProductoList = detalleOrdenCompraProductoList;
    }

    public List<FacturaCompra> getFacturaCompraList() {
        return facturaCompraList;
    }

    public void setFacturaCompraList(List<FacturaCompra> facturaCompraList) {
        this.facturaCompraList = facturaCompraList;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public EstadoFacturacionOrdenCompra getEstadoFacturacionOrdenCompra() {
        return estadoFacturacionOrdenCompra;
    }

    public void setEstadoFacturacionOrdenCompra(EstadoFacturacionOrdenCompra estadoFacturacionOrdenCompra) {
        this.estadoFacturacionOrdenCompra = estadoFacturacionOrdenCompra;
    }

    public EstadoOrdenCompra getEstadoOrdenCompra() {
        return estadoOrdenCompra;
    }

    public void setEstadoOrdenCompra(EstadoOrdenCompra estadoOrdenCompra) {
        this.estadoOrdenCompra = estadoOrdenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenCompra != null ? idOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenCompra)) {
            return false;
        }
        OrdenCompra other = (OrdenCompra) object;
        if ((this.idOrdenCompra == null && other.idOrdenCompra != null) || (this.idOrdenCompra != null && !this.idOrdenCompra.equals(other.idOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.OrdenCompra[idOrdenCompra=" + idOrdenCompra + "]";
    }

}
