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
@Table(name = "NOTA_CREDITO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "NotaCredito.findAll", query = "SELECT n FROM NotaCredito n"),
    @NamedQuery(name = "NotaCredito.findByIdNotaCredito", query = "SELECT n FROM NotaCredito n WHERE n.idNotaCredito = :idNotaCredito"),
    @NamedQuery(name = "NotaCredito.findByFechaRegistro", query = "SELECT n FROM NotaCredito n WHERE n.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "NotaCredito.findByCantidad", query = "SELECT n FROM NotaCredito n WHERE n.cantidad = :cantidad"),
    @NamedQuery(name = "NotaCredito.findByDescripcion", query = "SELECT n FROM NotaCredito n WHERE n.descripcion = :descripcion")})
public class NotaCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NOTA_CREDITO", nullable = false)
    private Integer idNotaCredito;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false, precision = 9, scale = 3)
    private BigDecimal cantidad;
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta venta;

    public NotaCredito() {
    }

    public NotaCredito(Integer idNotaCredito) {
        this.idNotaCredito = idNotaCredito;
    }

    public NotaCredito(Integer idNotaCredito, Date fechaRegistro, BigDecimal cantidad) {
        this.idNotaCredito = idNotaCredito;
        this.fechaRegistro = fechaRegistro;
        this.cantidad = cantidad;
    }

    public Integer getIdNotaCredito() {
        return idNotaCredito;
    }

    public void setIdNotaCredito(Integer idNotaCredito) {
        this.idNotaCredito = idNotaCredito;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaCredito != null ? idNotaCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaCredito)) {
            return false;
        }
        NotaCredito other = (NotaCredito) object;
        if ((this.idNotaCredito == null && other.idNotaCredito != null) || (this.idNotaCredito != null && !this.idNotaCredito.equals(other.idNotaCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.NotaCredito[idNotaCredito=" + idNotaCredito + "]";
    }

}
