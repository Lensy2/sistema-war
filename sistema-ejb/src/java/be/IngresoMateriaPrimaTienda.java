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
@Table(name = "INGRESO_MATERIA_PRIMA_TIENDA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findAll", query = "SELECT i FROM IngresoMateriaPrimaTienda i"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByIdIngresoMateriaPrimaTienda", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.idIngresoMateriaPrimaTienda = :idIngresoMateriaPrimaTienda"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByCantidad", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByFechaIngreso", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "IngresoMateriaPrimaTienda.findByMotivo", query = "SELECT i FROM IngresoMateriaPrimaTienda i WHERE i.motivo = :motivo")})
public class IngresoMateriaPrimaTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INGRESO_MATERIA_PRIMA_TIENDA", nullable = false)
    private Integer idIngresoMateriaPrimaTienda;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false, precision = 12, scale = 4)
    private BigDecimal cantidad;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "MOTIVO", nullable = false, length = 300)
    private String motivo;
    @JoinColumn(name = "ID_MATERIA_PRIMA", referencedColumnName = "ID_MATERIA_PRIMA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MateriaPrima materiaPrima;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tienda tienda;

    public IngresoMateriaPrimaTienda() {
    }

    public IngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
    }

    public IngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda, BigDecimal cantidad, Date fechaIngreso, String motivo) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.motivo = motivo;
    }

    public Integer getIdIngresoMateriaPrimaTienda() {
        return idIngresoMateriaPrimaTienda;
    }

    public void setIdIngresoMateriaPrimaTienda(Integer idIngresoMateriaPrimaTienda) {
        this.idIngresoMateriaPrimaTienda = idIngresoMateriaPrimaTienda;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
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
        hash += (idIngresoMateriaPrimaTienda != null ? idIngresoMateriaPrimaTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoMateriaPrimaTienda)) {
            return false;
        }
        IngresoMateriaPrimaTienda other = (IngresoMateriaPrimaTienda) object;
        if ((this.idIngresoMateriaPrimaTienda == null && other.idIngresoMateriaPrimaTienda != null) || (this.idIngresoMateriaPrimaTienda != null && !this.idIngresoMateriaPrimaTienda.equals(other.idIngresoMateriaPrimaTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IngresoMateriaPrimaTienda[idIngresoMateriaPrimaTienda=" + idIngresoMateriaPrimaTienda + "]";
    }

}
