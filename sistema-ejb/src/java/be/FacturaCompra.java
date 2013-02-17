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
@Table(name = "FACTURA_COMPRA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "FacturaCompra.findAll", query = "SELECT f FROM FacturaCompra f"),
    @NamedQuery(name = "FacturaCompra.findByIdFacturaCompra", query = "SELECT f FROM FacturaCompra f WHERE f.idFacturaCompra = :idFacturaCompra"),
    @NamedQuery(name = "FacturaCompra.findByFechaRecepcion", query = "SELECT f FROM FacturaCompra f WHERE f.fechaRecepcion = :fechaRecepcion"),
    @NamedQuery(name = "FacturaCompra.findByNumeroFacturaCompra", query = "SELECT f FROM FacturaCompra f WHERE f.numeroFacturaCompra = :numeroFacturaCompra"),
    @NamedQuery(name = "FacturaCompra.findByNumeroGuiaRemision", query = "SELECT f FROM FacturaCompra f WHERE f.numeroGuiaRemision = :numeroGuiaRemision"),
    @NamedQuery(name = "FacturaCompra.findByDescripcion", query = "SELECT f FROM FacturaCompra f WHERE f.descripcion = :descripcion")})
public class FacturaCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FACTURA_COMPRA", nullable = false)
    private Integer idFacturaCompra;
    @Basic(optional = false)
    @Column(name = "FECHA_RECEPCION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Basic(optional = false)
    @Column(name = "NUMERO_FACTURA_COMPRA", nullable = false, length = 68)
    private String numeroFacturaCompra;
    @Basic(optional = false)
    @Column(name = "NUMERO_GUIA_REMISION", nullable = false, length = 68)
    private String numeroGuiaRemision;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 170)
    private String descripcion;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "ID_ORDEN_COMPRA", referencedColumnName = "ID_ORDEN_COMPRA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private OrdenCompra ordenCompra;

    public FacturaCompra() {
    }

    public FacturaCompra(Integer idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public FacturaCompra(Integer idFacturaCompra, Date fechaRecepcion, String numeroFacturaCompra, String numeroGuiaRemision, String descripcion) {
        this.idFacturaCompra = idFacturaCompra;
        this.fechaRecepcion = fechaRecepcion;
        this.numeroFacturaCompra = numeroFacturaCompra;
        this.numeroGuiaRemision = numeroGuiaRemision;
        this.descripcion = descripcion;
    }

    public Integer getIdFacturaCompra() {
        return idFacturaCompra;
    }

    public void setIdFacturaCompra(Integer idFacturaCompra) {
        this.idFacturaCompra = idFacturaCompra;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public String getNumeroFacturaCompra() {
        return numeroFacturaCompra;
    }

    public void setNumeroFacturaCompra(String numeroFacturaCompra) {
        this.numeroFacturaCompra = numeroFacturaCompra;
    }

    public String getNumeroGuiaRemision() {
        return numeroGuiaRemision;
    }

    public void setNumeroGuiaRemision(String numeroGuiaRemision) {
        this.numeroGuiaRemision = numeroGuiaRemision;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idFacturaCompra != null ? idFacturaCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCompra)) {
            return false;
        }
        FacturaCompra other = (FacturaCompra) object;
        if ((this.idFacturaCompra == null && other.idFacturaCompra != null) || (this.idFacturaCompra != null && !this.idFacturaCompra.equals(other.idFacturaCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.FacturaCompra[idFacturaCompra=" + idFacturaCompra + "]";
    }

}
