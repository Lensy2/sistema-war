/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findAll", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByIdOrdenSalidaDetalleAlmacenProductosCostos", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.idOrdenSalidaDetalleAlmacenProductosCostos = :idOrdenSalidaDetalleAlmacenProductosCostos"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByObservacionesUbicacion", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.observacionesUbicacion = :observacionesUbicacion"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByFechaRegistro", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByCodigoFacturaBoleta", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.codigoFacturaBoleta = :codigoFacturaBoleta"),
    @NamedQuery(name = "OrdenSalidaDetalleAlmacenProductos.findByCantidad", query = "SELECT o FROM OrdenSalidaDetalleAlmacenProductos o WHERE o.cantidad = :cantidad")})
public class OrdenSalidaDetalleAlmacenProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS_COSTOS", nullable = false)
    private Integer idOrdenSalidaDetalleAlmacenProductosCostos;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES_UBICACION", nullable = false, length = 300)
    private String observacionesUbicacion;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "CODIGO_FACTURA_BOLETA", nullable = false, length = 150)
    private String codigoFacturaBoleta;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;
    @JoinColumn(name = "ID_ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS", referencedColumnName = "ID_ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoOrdenSalidaDetalleAlmacenProductos estadoOrdenSalidaDetalleAlmacenProductos;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente cliente;
    @JoinColumn(name = "ID_DETALLE_ALMACEN_PRODUCTOS", referencedColumnName = "ID_DETALLE_ALMACEN_PRODUCTOS", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DetalleAlmacenProductos detalleAlmacenProductos;

    public OrdenSalidaDetalleAlmacenProductos() {
    }

    public OrdenSalidaDetalleAlmacenProductos(Integer idOrdenSalidaDetalleAlmacenProductosCostos) {
        this.idOrdenSalidaDetalleAlmacenProductosCostos = idOrdenSalidaDetalleAlmacenProductosCostos;
    }

    public OrdenSalidaDetalleAlmacenProductos(Integer idOrdenSalidaDetalleAlmacenProductosCostos, String observacionesUbicacion, Date fechaRegistro, String codigoFacturaBoleta, int cantidad) {
        this.idOrdenSalidaDetalleAlmacenProductosCostos = idOrdenSalidaDetalleAlmacenProductosCostos;
        this.observacionesUbicacion = observacionesUbicacion;
        this.fechaRegistro = fechaRegistro;
        this.codigoFacturaBoleta = codigoFacturaBoleta;
        this.cantidad = cantidad;
    }

    public Integer getIdOrdenSalidaDetalleAlmacenProductosCostos() {
        return idOrdenSalidaDetalleAlmacenProductosCostos;
    }

    public void setIdOrdenSalidaDetalleAlmacenProductosCostos(Integer idOrdenSalidaDetalleAlmacenProductosCostos) {
        this.idOrdenSalidaDetalleAlmacenProductosCostos = idOrdenSalidaDetalleAlmacenProductosCostos;
    }

    public String getObservacionesUbicacion() {
        return observacionesUbicacion;
    }

    public void setObservacionesUbicacion(String observacionesUbicacion) {
        this.observacionesUbicacion = observacionesUbicacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getCodigoFacturaBoleta() {
        return codigoFacturaBoleta;
    }

    public void setCodigoFacturaBoleta(String codigoFacturaBoleta) {
        this.codigoFacturaBoleta = codigoFacturaBoleta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public EstadoOrdenSalidaDetalleAlmacenProductos getEstadoOrdenSalidaDetalleAlmacenProductos() {
        return estadoOrdenSalidaDetalleAlmacenProductos;
    }

    public void setEstadoOrdenSalidaDetalleAlmacenProductos(EstadoOrdenSalidaDetalleAlmacenProductos estadoOrdenSalidaDetalleAlmacenProductos) {
        this.estadoOrdenSalidaDetalleAlmacenProductos = estadoOrdenSalidaDetalleAlmacenProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DetalleAlmacenProductos getDetalleAlmacenProductos() {
        return detalleAlmacenProductos;
    }

    public void setDetalleAlmacenProductos(DetalleAlmacenProductos detalleAlmacenProductos) {
        this.detalleAlmacenProductos = detalleAlmacenProductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrdenSalidaDetalleAlmacenProductosCostos != null ? idOrdenSalidaDetalleAlmacenProductosCostos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenSalidaDetalleAlmacenProductos)) {
            return false;
        }
        OrdenSalidaDetalleAlmacenProductos other = (OrdenSalidaDetalleAlmacenProductos) object;
        if ((this.idOrdenSalidaDetalleAlmacenProductosCostos == null && other.idOrdenSalidaDetalleAlmacenProductosCostos != null) || (this.idOrdenSalidaDetalleAlmacenProductosCostos != null && !this.idOrdenSalidaDetalleAlmacenProductosCostos.equals(other.idOrdenSalidaDetalleAlmacenProductosCostos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.OrdenSalidaDetalleAlmacenProductos[idOrdenSalidaDetalleAlmacenProductosCostos=" + idOrdenSalidaDetalleAlmacenProductosCostos + "]";
    }

}
