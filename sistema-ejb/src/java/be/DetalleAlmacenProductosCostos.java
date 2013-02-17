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
@Table(name = "DETALLE_ALMACEN_PRODUCTOS_COSTOS", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findAll", query = "SELECT d FROM DetalleAlmacenProductosCostos d"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByIdDetalleAlmacenProductosCostos", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.idDetalleAlmacenProductosCostos = :idDetalleAlmacenProductosCostos"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByCosto", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.costo = :costo"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByFechaEntrada", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByFechaSalida", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByObservaciones", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.observaciones = :observaciones")})
public class DetalleAlmacenProductosCostos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_ALMACEN_PRODUCTOS_COSTOS", nullable = false)
    private Integer idDetalleAlmacenProductosCostos;
    @Basic(optional = false)
    @Column(name = "COSTO", nullable = false, precision = 9, scale = 3)
    private BigDecimal costo;
    @Basic(optional = false)
    @Column(name = "FECHA_ENTRADA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES", nullable = false, length = 300)
    private String observaciones;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;
    @JoinColumn(name = "ID_ESTADO_PRODUCTO_COSTO_ALMACEN", referencedColumnName = "ID_ESTADO_PRODUCTO_COSTO_ALMACEN")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoProductoCostoAlmacen estadoProductoCostoAlmacen;
    @JoinColumn(name = "ID_PROCEDENCIA_PRODUCTO_ALMACEN", referencedColumnName = "ID_PROCEDENCIA_PRODUCTO_ALMACEN", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProcedenciaProductoAlmacen procedenciaProductoAlmacen;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleAlmacenProductosCostos", fetch = FetchType.LAZY)
    private List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList;

    public DetalleAlmacenProductosCostos() {
    }

    public DetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
    }

    public DetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos, BigDecimal costo, Date fechaEntrada, String observaciones) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
        this.costo = costo;
        this.fechaEntrada = fechaEntrada;
        this.observaciones = observaciones;
    }

    public Integer getIdDetalleAlmacenProductosCostos() {
        return idDetalleAlmacenProductosCostos;
    }

    public void setIdDetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public EstadoProductoCostoAlmacen getEstadoProductoCostoAlmacen() {
        return estadoProductoCostoAlmacen;
    }

    public void setEstadoProductoCostoAlmacen(EstadoProductoCostoAlmacen estadoProductoCostoAlmacen) {
        this.estadoProductoCostoAlmacen = estadoProductoCostoAlmacen;
    }

    public ProcedenciaProductoAlmacen getProcedenciaProductoAlmacen() {
        return procedenciaProductoAlmacen;
    }

    public void setProcedenciaProductoAlmacen(ProcedenciaProductoAlmacen procedenciaProductoAlmacen) {
        this.procedenciaProductoAlmacen = procedenciaProductoAlmacen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<OrdenSalidaDetalleAlmacenProductosCostos> getOrdenSalidaDetalleAlmacenProductosCostosList() {
        return ordenSalidaDetalleAlmacenProductosCostosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosCostosList(List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList) {
        this.ordenSalidaDetalleAlmacenProductosCostosList = ordenSalidaDetalleAlmacenProductosCostosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleAlmacenProductosCostos != null ? idDetalleAlmacenProductosCostos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleAlmacenProductosCostos)) {
            return false;
        }
        DetalleAlmacenProductosCostos other = (DetalleAlmacenProductosCostos) object;
        if ((this.idDetalleAlmacenProductosCostos == null && other.idDetalleAlmacenProductosCostos != null) || (this.idDetalleAlmacenProductosCostos != null && !this.idDetalleAlmacenProductosCostos.equals(other.idDetalleAlmacenProductosCostos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleAlmacenProductosCostos[idDetalleAlmacenProductosCostos=" + idDetalleAlmacenProductosCostos + "]";
    }

}
