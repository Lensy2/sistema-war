/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "IGV_FACTURA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "IgvFactura.findAll", query = "SELECT i FROM IgvFactura i"),
    @NamedQuery(name = "IgvFactura.findByIdIgvFactura", query = "SELECT i FROM IgvFactura i WHERE i.idIgvFactura = :idIgvFactura"),
    @NamedQuery(name = "IgvFactura.findByMonto", query = "SELECT i FROM IgvFactura i WHERE i.monto = :monto"),
    @NamedQuery(name = "IgvFactura.findByDescripcion", query = "SELECT i FROM IgvFactura i WHERE i.descripcion = :descripcion")})
public class IgvFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_IGV_FACTURA", nullable = false)
    private Integer idIgvFactura;
    @Basic(optional = false)
    @Column(name = "MONTO", nullable = false, precision = 4, scale = 2)
    private BigDecimal monto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;
    @JoinColumn(name = "ID_ESTADO_IGV", referencedColumnName = "ID_ESTADO_IGV", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoIgv estadoIgv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "igvFactura", fetch = FetchType.LAZY)
    private List<FacturaVenta> facturaVentaList;

    public IgvFactura() {
    }

    public IgvFactura(Integer idIgvFactura) {
        this.idIgvFactura = idIgvFactura;
    }

    public IgvFactura(Integer idIgvFactura, BigDecimal monto, String descripcion) {
        this.idIgvFactura = idIgvFactura;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    public Integer getIdIgvFactura() {
        return idIgvFactura;
    }

    public void setIdIgvFactura(Integer idIgvFactura) {
        this.idIgvFactura = idIgvFactura;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoIgv getEstadoIgv() {
        return estadoIgv;
    }

    public void setEstadoIgv(EstadoIgv estadoIgv) {
        this.estadoIgv = estadoIgv;
    }

    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIgvFactura != null ? idIgvFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IgvFactura)) {
            return false;
        }
        IgvFactura other = (IgvFactura) object;
        if ((this.idIgvFactura == null && other.idIgvFactura != null) || (this.idIgvFactura != null && !this.idIgvFactura.equals(other.idIgvFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IgvFactura[idIgvFactura=" + idIgvFactura + "]";
    }

}
