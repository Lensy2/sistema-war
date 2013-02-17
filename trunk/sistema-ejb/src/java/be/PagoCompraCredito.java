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
@Table(name = "PAGO_COMPRA_CREDITO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "PagoCompraCredito.findAll", query = "SELECT p FROM PagoCompraCredito p"),
    @NamedQuery(name = "PagoCompraCredito.findByIdPagoCompraCredito", query = "SELECT p FROM PagoCompraCredito p WHERE p.idPagoCompraCredito = :idPagoCompraCredito"),
    @NamedQuery(name = "PagoCompraCredito.findByFechaIngreso", query = "SELECT p FROM PagoCompraCredito p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PagoCompraCredito.findByObservaciones", query = "SELECT p FROM PagoCompraCredito p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PagoCompraCredito.findByCantidad", query = "SELECT p FROM PagoCompraCredito p WHERE p.cantidad = :cantidad")})
public class PagoCompraCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PAGO_COMPRA_CREDITO", nullable = false)
    private Integer idPagoCompraCredito;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES", nullable = false, length = 170)
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false, precision = 9, scale = 2)
    private BigDecimal cantidad;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "ID_ORDEN_COMPRA", referencedColumnName = "ID_ORDEN_COMPRA")
    @ManyToOne(fetch = FetchType.LAZY)
    private OrdenCompra ordenCompra;

    public PagoCompraCredito() {
    }

    public PagoCompraCredito(Integer idPagoCompraCredito) {
        this.idPagoCompraCredito = idPagoCompraCredito;
    }

    public PagoCompraCredito(Integer idPagoCompraCredito, Date fechaIngreso, String observaciones, BigDecimal cantidad) {
        this.idPagoCompraCredito = idPagoCompraCredito;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.cantidad = cantidad;
    }

    public Integer getIdPagoCompraCredito() {
        return idPagoCompraCredito;
    }

    public void setIdPagoCompraCredito(Integer idPagoCompraCredito) {
        this.idPagoCompraCredito = idPagoCompraCredito;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoCompraCredito != null ? idPagoCompraCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoCompraCredito)) {
            return false;
        }
        PagoCompraCredito other = (PagoCompraCredito) object;
        if ((this.idPagoCompraCredito == null && other.idPagoCompraCredito != null) || (this.idPagoCompraCredito != null && !this.idPagoCompraCredito.equals(other.idPagoCompraCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PagoCompraCredito[idPagoCompraCredito=" + idPagoCompraCredito + "]";
    }

}
