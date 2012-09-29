/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "EstadoOrdenSalidaDetalleAlmacenProductos.findAll", query = "SELECT e FROM EstadoOrdenSalidaDetalleAlmacenProductos e"),
    @NamedQuery(name = "EstadoOrdenSalidaDetalleAlmacenProductos.findByIdEstadoOrdenSalidaDetalleAlmacenProductos", query = "SELECT e FROM EstadoOrdenSalidaDetalleAlmacenProductos e WHERE e.idEstadoOrdenSalidaDetalleAlmacenProductos = :idEstadoOrdenSalidaDetalleAlmacenProductos"),
    @NamedQuery(name = "EstadoOrdenSalidaDetalleAlmacenProductos.findByNombreEstado", query = "SELECT e FROM EstadoOrdenSalidaDetalleAlmacenProductos e WHERE e.nombreEstado = :nombreEstado"),
    @NamedQuery(name = "EstadoOrdenSalidaDetalleAlmacenProductos.findByDescripcion", query = "SELECT e FROM EstadoOrdenSalidaDetalleAlmacenProductos e WHERE e.descripcion = :descripcion")})
public class EstadoOrdenSalidaDetalleAlmacenProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS", nullable = false)
    private Integer idEstadoOrdenSalidaDetalleAlmacenProductos;
    @Basic(optional = false)
    @Column(name = "NOMBRE_ESTADO", nullable = false, length = 100)
    private String nombreEstado;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 170)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoOrdenSalidaDetalleAlmacenProductos", fetch = FetchType.LAZY)
    private List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList;

    public EstadoOrdenSalidaDetalleAlmacenProductos() {
    }

    public EstadoOrdenSalidaDetalleAlmacenProductos(Integer idEstadoOrdenSalidaDetalleAlmacenProductos) {
        this.idEstadoOrdenSalidaDetalleAlmacenProductos = idEstadoOrdenSalidaDetalleAlmacenProductos;
    }

    public EstadoOrdenSalidaDetalleAlmacenProductos(Integer idEstadoOrdenSalidaDetalleAlmacenProductos, String nombreEstado, String descripcion) {
        this.idEstadoOrdenSalidaDetalleAlmacenProductos = idEstadoOrdenSalidaDetalleAlmacenProductos;
        this.nombreEstado = nombreEstado;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoOrdenSalidaDetalleAlmacenProductos() {
        return idEstadoOrdenSalidaDetalleAlmacenProductos;
    }

    public void setIdEstadoOrdenSalidaDetalleAlmacenProductos(Integer idEstadoOrdenSalidaDetalleAlmacenProductos) {
        this.idEstadoOrdenSalidaDetalleAlmacenProductos = idEstadoOrdenSalidaDetalleAlmacenProductos;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<OrdenSalidaDetalleAlmacenProductos> getOrdenSalidaDetalleAlmacenProductosList() {
        return ordenSalidaDetalleAlmacenProductosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosList(List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList) {
        this.ordenSalidaDetalleAlmacenProductosList = ordenSalidaDetalleAlmacenProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOrdenSalidaDetalleAlmacenProductos != null ? idEstadoOrdenSalidaDetalleAlmacenProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOrdenSalidaDetalleAlmacenProductos)) {
            return false;
        }
        EstadoOrdenSalidaDetalleAlmacenProductos other = (EstadoOrdenSalidaDetalleAlmacenProductos) object;
        if ((this.idEstadoOrdenSalidaDetalleAlmacenProductos == null && other.idEstadoOrdenSalidaDetalleAlmacenProductos != null) || (this.idEstadoOrdenSalidaDetalleAlmacenProductos != null && !this.idEstadoOrdenSalidaDetalleAlmacenProductos.equals(other.idEstadoOrdenSalidaDetalleAlmacenProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoOrdenSalidaDetalleAlmacenProductos[idEstadoOrdenSalidaDetalleAlmacenProductos=" + idEstadoOrdenSalidaDetalleAlmacenProductos + "]";
    }

}
