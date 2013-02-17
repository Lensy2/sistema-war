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
@Table(name = "FACTURA_VENTA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "FacturaVenta.findAll", query = "SELECT f FROM FacturaVenta f"),
    @NamedQuery(name = "FacturaVenta.findByIdFacturaVenta", query = "SELECT f FROM FacturaVenta f WHERE f.idFacturaVenta = :idFacturaVenta"),
    @NamedQuery(name = "FacturaVenta.findByBloqueFactura", query = "SELECT f FROM FacturaVenta f WHERE f.bloqueFactura = :bloqueFactura"),
    @NamedQuery(name = "FacturaVenta.findByNumeroFactura", query = "SELECT f FROM FacturaVenta f WHERE f.numeroFactura = :numeroFactura"),
    @NamedQuery(name = "FacturaVenta.findByFechaVenta", query = "SELECT f FROM FacturaVenta f WHERE f.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "FacturaVenta.findByFechaVentaEmision", query = "SELECT f FROM FacturaVenta f WHERE f.fechaVentaEmision = :fechaVentaEmision"),
    @NamedQuery(name = "FacturaVenta.findByTotalVenta", query = "SELECT f FROM FacturaVenta f WHERE f.totalVenta = :totalVenta"),
    @NamedQuery(name = "FacturaVenta.findByTotalVentaIncluidoIgv", query = "SELECT f FROM FacturaVenta f WHERE f.totalVentaIncluidoIgv = :totalVentaIncluidoIgv"),
    @NamedQuery(name = "FacturaVenta.findByObservaciones", query = "SELECT f FROM FacturaVenta f WHERE f.observaciones = :observaciones"),
    @NamedQuery(name = "FacturaVenta.findByTotalPagosCredito", query = "SELECT f FROM FacturaVenta f WHERE f.totalPagosCredito = :totalPagosCredito")})
public class FacturaVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FACTURA_VENTA", nullable = false)
    private Integer idFacturaVenta;
    @Basic(optional = false)
    @Column(name = "BLOQUE_FACTURA", nullable = false)
    private int bloqueFactura;
    @Basic(optional = false)
    @Column(name = "NUMERO_FACTURA", nullable = false)
    private int numeroFactura;
    @Basic(optional = false)
    @Column(name = "FECHA_VENTA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @Column(name = "FECHA_VENTA_EMISION", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVentaEmision;
    @Basic(optional = false)
    @Column(name = "TOTAL_VENTA", nullable = false, precision = 9, scale = 2)
    private BigDecimal totalVenta;
    @Basic(optional = false)
    @Column(name = "TOTAL_VENTA_INCLUIDO_IGV", nullable = false, precision = 11, scale = 2)
    private BigDecimal totalVentaIncluidoIgv;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES", nullable = false, length = 200)
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "TOTAL_PAGOS_CREDITO", nullable = false, precision = 9, scale = 2)
    private BigDecimal totalPagosCredito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaVenta", fetch = FetchType.LAZY)
    private List<GuiaRemicion> guiaRemicionList;
    @OneToMany(mappedBy = "facturaVenta", fetch = FetchType.LAZY)
    private List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaVenta", fetch = FetchType.LAZY)
    private List<DetalleFacturaVentaProducto> detalleFacturaVentaProductoList;
    @JoinColumn(name = "ID_IGV_FACTURA", referencedColumnName = "ID_IGV_FACTURA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private IgvFactura igvFactura;
    @JoinColumn(name = "ID_ESTADO_VENTA", referencedColumnName = "ID_ESTADO_VENTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoVenta estadoVenta;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "ID_TIPO_VENTA", referencedColumnName = "ID_TIPO_VENTA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoVenta tipoVenta;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;

    public FacturaVenta() {
    }

    public FacturaVenta(Integer idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public FacturaVenta(Integer idFacturaVenta, int bloqueFactura, int numeroFactura, Date fechaVenta, Date fechaVentaEmision, BigDecimal totalVenta, BigDecimal totalVentaIncluidoIgv, String observaciones, BigDecimal totalPagosCredito) {
        this.idFacturaVenta = idFacturaVenta;
        this.bloqueFactura = bloqueFactura;
        this.numeroFactura = numeroFactura;
        this.fechaVenta = fechaVenta;
        this.fechaVentaEmision = fechaVentaEmision;
        this.totalVenta = totalVenta;
        this.totalVentaIncluidoIgv = totalVentaIncluidoIgv;
        this.observaciones = observaciones;
        this.totalPagosCredito = totalPagosCredito;
    }

    public Integer getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(Integer idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public int getBloqueFactura() {
        return bloqueFactura;
    }

    public void setBloqueFactura(int bloqueFactura) {
        this.bloqueFactura = bloqueFactura;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaVentaEmision() {
        return fechaVentaEmision;
    }

    public void setFechaVentaEmision(Date fechaVentaEmision) {
        this.fechaVentaEmision = fechaVentaEmision;
    }

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public BigDecimal getTotalVentaIncluidoIgv() {
        return totalVentaIncluidoIgv;
    }

    public void setTotalVentaIncluidoIgv(BigDecimal totalVentaIncluidoIgv) {
        this.totalVentaIncluidoIgv = totalVentaIncluidoIgv;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getTotalPagosCredito() {
        return totalPagosCredito;
    }

    public void setTotalPagosCredito(BigDecimal totalPagosCredito) {
        this.totalPagosCredito = totalPagosCredito;
    }

    public List<GuiaRemicion> getGuiaRemicionList() {
        return guiaRemicionList;
    }

    public void setGuiaRemicionList(List<GuiaRemicion> guiaRemicionList) {
        this.guiaRemicionList = guiaRemicionList;
    }

    public List<PagoFacturaVentaCredito> getPagoFacturaVentaCreditoList() {
        return pagoFacturaVentaCreditoList;
    }

    public void setPagoFacturaVentaCreditoList(List<PagoFacturaVentaCredito> pagoFacturaVentaCreditoList) {
        this.pagoFacturaVentaCreditoList = pagoFacturaVentaCreditoList;
    }

    public List<DetalleFacturaVentaProducto> getDetalleFacturaVentaProductoList() {
        return detalleFacturaVentaProductoList;
    }

    public void setDetalleFacturaVentaProductoList(List<DetalleFacturaVentaProducto> detalleFacturaVentaProductoList) {
        this.detalleFacturaVentaProductoList = detalleFacturaVentaProductoList;
    }

    public IgvFactura getIgvFactura() {
        return igvFactura;
    }

    public void setIgvFactura(IgvFactura igvFactura) {
        this.igvFactura = igvFactura;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaVenta != null ? idFacturaVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaVenta)) {
            return false;
        }
        FacturaVenta other = (FacturaVenta) object;
        if ((this.idFacturaVenta == null && other.idFacturaVenta != null) || (this.idFacturaVenta != null && !this.idFacturaVenta.equals(other.idFacturaVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.FacturaVenta[idFacturaVenta=" + idFacturaVenta + "]";
    }

}
