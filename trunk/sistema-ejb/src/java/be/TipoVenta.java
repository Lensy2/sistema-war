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
@Table(name = "TIPO_VENTA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoVenta.findAll", query = "SELECT t FROM TipoVenta t"),
    @NamedQuery(name = "TipoVenta.findByIdTipoVenta", query = "SELECT t FROM TipoVenta t WHERE t.idTipoVenta = :idTipoVenta"),
    @NamedQuery(name = "TipoVenta.findByNombreTipoVenta", query = "SELECT t FROM TipoVenta t WHERE t.nombreTipoVenta = :nombreTipoVenta"),
    @NamedQuery(name = "TipoVenta.findByDescripcion", query = "SELECT t FROM TipoVenta t WHERE t.descripcion = :descripcion")})
public class TipoVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_VENTA", nullable = false)
    private Integer idTipoVenta;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_VENTA", nullable = false, length = 100)
    private String nombreTipoVenta;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 170)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVenta", fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVenta", fetch = FetchType.LAZY)
    private List<FacturaVenta> facturaVentaList;

    public TipoVenta() {
    }

    public TipoVenta(Integer idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public TipoVenta(Integer idTipoVenta, String nombreTipoVenta, String descripcion) {
        this.idTipoVenta = idTipoVenta;
        this.nombreTipoVenta = nombreTipoVenta;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoVenta() {
        return idTipoVenta;
    }

    public void setIdTipoVenta(Integer idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public String getNombreTipoVenta() {
        return nombreTipoVenta;
    }

    public void setNombreTipoVenta(String nombreTipoVenta) {
        this.nombreTipoVenta = nombreTipoVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
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
        hash += (idTipoVenta != null ? idTipoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVenta)) {
            return false;
        }
        TipoVenta other = (TipoVenta) object;
        if ((this.idTipoVenta == null && other.idTipoVenta != null) || (this.idTipoVenta != null && !this.idTipoVenta.equals(other.idTipoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoVenta[idTipoVenta=" + idTipoVenta + "]";
    }

}
