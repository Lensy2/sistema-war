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
@Table(name = "LETRAS_PAGO_CANJE", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "LetrasPagoCanje.findAll", query = "SELECT l FROM LetrasPagoCanje l"),
    @NamedQuery(name = "LetrasPagoCanje.findByIdLetrasPagoCanje", query = "SELECT l FROM LetrasPagoCanje l WHERE l.idLetrasPagoCanje = :idLetrasPagoCanje"),
    @NamedQuery(name = "LetrasPagoCanje.findByFechaPago", query = "SELECT l FROM LetrasPagoCanje l WHERE l.fechaPago = :fechaPago"),
    @NamedQuery(name = "LetrasPagoCanje.findByFechaRealizoPago", query = "SELECT l FROM LetrasPagoCanje l WHERE l.fechaRealizoPago = :fechaRealizoPago"),
    @NamedQuery(name = "LetrasPagoCanje.findByTotalLetra", query = "SELECT l FROM LetrasPagoCanje l WHERE l.totalLetra = :totalLetra"),
    @NamedQuery(name = "LetrasPagoCanje.findByObservaciones", query = "SELECT l FROM LetrasPagoCanje l WHERE l.observaciones = :observaciones")})
public class LetrasPagoCanje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LETRAS_PAGO_CANJE", nullable = false)
    private Integer idLetrasPagoCanje;
    @Basic(optional = false)
    @Column(name = "FECHA_PAGO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @Column(name = "FECHA_REALIZO_PAGO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRealizoPago;
    @Basic(optional = false)
    @Column(name = "TOTAL_LETRA", nullable = false, precision = 9, scale = 2)
    private BigDecimal totalLetra;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES", nullable = false, length = 300)
    private String observaciones;
    @JoinColumn(name = "ID_CANJE_ORDEN_COMPRA", referencedColumnName = "ID_CANJE_ORDEN_COMPRA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CanjeOrdenCompra canjeOrdenCompra;
    @JoinColumn(name = "ID_ESTADO_LETRAS_PAGO_CANJE", referencedColumnName = "ID_ESTADO_LETRAS_PAGO_CANJE")
    @ManyToOne(fetch = FetchType.LAZY)
    private EstadoLetrasPagoCanje estadoLetrasPagoCanje;

    public LetrasPagoCanje() {
    }

    public LetrasPagoCanje(Integer idLetrasPagoCanje) {
        this.idLetrasPagoCanje = idLetrasPagoCanje;
    }

    public LetrasPagoCanje(Integer idLetrasPagoCanje, Date fechaPago, Date fechaRealizoPago, BigDecimal totalLetra, String observaciones) {
        this.idLetrasPagoCanje = idLetrasPagoCanje;
        this.fechaPago = fechaPago;
        this.fechaRealizoPago = fechaRealizoPago;
        this.totalLetra = totalLetra;
        this.observaciones = observaciones;
    }

    public Integer getIdLetrasPagoCanje() {
        return idLetrasPagoCanje;
    }

    public void setIdLetrasPagoCanje(Integer idLetrasPagoCanje) {
        this.idLetrasPagoCanje = idLetrasPagoCanje;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Date getFechaRealizoPago() {
        return fechaRealizoPago;
    }

    public void setFechaRealizoPago(Date fechaRealizoPago) {
        this.fechaRealizoPago = fechaRealizoPago;
    }

    public BigDecimal getTotalLetra() {
        return totalLetra;
    }

    public void setTotalLetra(BigDecimal totalLetra) {
        this.totalLetra = totalLetra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public CanjeOrdenCompra getCanjeOrdenCompra() {
        return canjeOrdenCompra;
    }

    public void setCanjeOrdenCompra(CanjeOrdenCompra canjeOrdenCompra) {
        this.canjeOrdenCompra = canjeOrdenCompra;
    }

    public EstadoLetrasPagoCanje getEstadoLetrasPagoCanje() {
        return estadoLetrasPagoCanje;
    }

    public void setEstadoLetrasPagoCanje(EstadoLetrasPagoCanje estadoLetrasPagoCanje) {
        this.estadoLetrasPagoCanje = estadoLetrasPagoCanje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLetrasPagoCanje != null ? idLetrasPagoCanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LetrasPagoCanje)) {
            return false;
        }
        LetrasPagoCanje other = (LetrasPagoCanje) object;
        if ((this.idLetrasPagoCanje == null && other.idLetrasPagoCanje != null) || (this.idLetrasPagoCanje != null && !this.idLetrasPagoCanje.equals(other.idLetrasPagoCanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.LetrasPagoCanje[idLetrasPagoCanje=" + idLetrasPagoCanje + "]";
    }

}
