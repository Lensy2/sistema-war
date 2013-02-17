/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "INGRESO_PRODUCTO_TIENDA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "IngresoProductoTienda.findAll", query = "SELECT i FROM IngresoProductoTienda i"),
    @NamedQuery(name = "IngresoProductoTienda.findByIdIngresoProductoTienda", query = "SELECT i FROM IngresoProductoTienda i WHERE i.idIngresoProductoTienda = :idIngresoProductoTienda"),
    @NamedQuery(name = "IngresoProductoTienda.findByCantidad", query = "SELECT i FROM IngresoProductoTienda i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "IngresoProductoTienda.findByFechaIngreso", query = "SELECT i FROM IngresoProductoTienda i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "IngresoProductoTienda.findByFechaVencimiento", query = "SELECT i FROM IngresoProductoTienda i WHERE i.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "IngresoProductoTienda.findByMotivo", query = "SELECT i FROM IngresoProductoTienda i WHERE i.motivo = :motivo"),
    @NamedQuery(name = "IngresoProductoTienda.findByUbicacion", query = "SELECT i FROM IngresoProductoTienda i WHERE i.ubicacion = :ubicacion"),
    @NamedQuery(name = "IngresoProductoTienda.findByCostoUnitario", query = "SELECT i FROM IngresoProductoTienda i WHERE i.costoUnitario = :costoUnitario")})
public class IngresoProductoTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INGRESO_PRODUCTO_TIENDA", nullable = false)
    private Integer idIngresoProductoTienda;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "FECHA_VENCIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @Column(name = "MOTIVO", nullable = false, length = 300)
    private String motivo;
    @Basic(optional = false)
    @Column(name = "UBICACION", nullable = false, length = 300)
    private String ubicacion;
    @Basic(optional = false)
    @Column(name = "COSTO_UNITARIO", nullable = false, precision = 9, scale = 2)
    private BigDecimal costoUnitario;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;

    public IngresoProductoTienda() {
    }

    public IngresoProductoTienda(Integer idIngresoProductoTienda) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
    }

    public IngresoProductoTienda(Integer idIngresoProductoTienda, int cantidad, Date fechaIngreso, Date fechaVencimiento, String motivo, String ubicacion, BigDecimal costoUnitario) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.motivo = motivo;
        this.ubicacion = ubicacion;
        this.costoUnitario = costoUnitario;
    }

    public Integer getIdIngresoProductoTienda() {
        return idIngresoProductoTienda;
    }

    public void setIdIngresoProductoTienda(Integer idIngresoProductoTienda) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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
        hash += (idIngresoProductoTienda != null ? idIngresoProductoTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoProductoTienda)) {
            return false;
        }
        IngresoProductoTienda other = (IngresoProductoTienda) object;
        if ((this.idIngresoProductoTienda == null && other.idIngresoProductoTienda != null) || (this.idIngresoProductoTienda != null && !this.idIngresoProductoTienda.equals(other.idIngresoProductoTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IngresoProductoTienda[idIngresoProductoTienda=" + idIngresoProductoTienda + "]";
    }

}
