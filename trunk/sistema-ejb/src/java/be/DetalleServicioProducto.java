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
@Table(name = "DETALLE_SERVICIO_PRODUCTO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleServicioProducto.findAll", query = "SELECT d FROM DetalleServicioProducto d"),
    @NamedQuery(name = "DetalleServicioProducto.findByIdServicio", query = "SELECT d FROM DetalleServicioProducto d WHERE d.detalleServicioProductoPK.idServicio = :idServicio"),
    @NamedQuery(name = "DetalleServicioProducto.findByIdProducto", query = "SELECT d FROM DetalleServicioProducto d WHERE d.detalleServicioProductoPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleServicioProducto.findByCantidad", query = "SELECT d FROM DetalleServicioProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleServicioProducto.findByUtilizo", query = "SELECT d FROM DetalleServicioProducto d WHERE d.utilizo = :utilizo"),
    @NamedQuery(name = "DetalleServicioProducto.findByQuedo", query = "SELECT d FROM DetalleServicioProducto d WHERE d.quedo = :quedo")})
public class DetalleServicioProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleServicioProductoPK detalleServicioProductoPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "UTILIZO", nullable = false, precision = 9, scale = 3)
    private BigDecimal utilizo;
    @Basic(optional = false)
    @Column(name = "QUEDO", nullable = false, precision = 9, scale = 3)
    private BigDecimal quedo;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "ID_SERVICIO", referencedColumnName = "ID_SERVICIO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicio servicio;

    public DetalleServicioProducto() {
    }

    public DetalleServicioProducto(DetalleServicioProductoPK detalleServicioProductoPK) {
        this.detalleServicioProductoPK = detalleServicioProductoPK;
    }

    public DetalleServicioProducto(DetalleServicioProductoPK detalleServicioProductoPK, int cantidad, BigDecimal utilizo, BigDecimal quedo) {
        this.detalleServicioProductoPK = detalleServicioProductoPK;
        this.cantidad = cantidad;
        this.utilizo = utilizo;
        this.quedo = quedo;
    }

    public DetalleServicioProducto(int idServicio, int idProducto) {
        this.detalleServicioProductoPK = new DetalleServicioProductoPK(idServicio, idProducto);
    }

    public DetalleServicioProductoPK getDetalleServicioProductoPK() {
        return detalleServicioProductoPK;
    }

    public void setDetalleServicioProductoPK(DetalleServicioProductoPK detalleServicioProductoPK) {
        this.detalleServicioProductoPK = detalleServicioProductoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getUtilizo() {
        return utilizo;
    }

    public void setUtilizo(BigDecimal utilizo) {
        this.utilizo = utilizo;
    }

    public BigDecimal getQuedo() {
        return quedo;
    }

    public void setQuedo(BigDecimal quedo) {
        this.quedo = quedo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleServicioProductoPK != null ? detalleServicioProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleServicioProducto)) {
            return false;
        }
        DetalleServicioProducto other = (DetalleServicioProducto) object;
        if ((this.detalleServicioProductoPK == null && other.detalleServicioProductoPK != null) || (this.detalleServicioProductoPK != null && !this.detalleServicioProductoPK.equals(other.detalleServicioProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleServicioProducto[detalleServicioProductoPK=" + detalleServicioProductoPK + "]";
    }

}
