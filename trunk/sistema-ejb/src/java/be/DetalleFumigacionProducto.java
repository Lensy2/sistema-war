/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "DETALLE_FUMIGACION_PRODUCTO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleFumigacionProducto.findAll", query = "SELECT d FROM DetalleFumigacionProducto d"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByIdDetalleFumigacionProducto", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.idDetalleFumigacionProducto = :idDetalleFumigacionProducto"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByCantidad", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByUtilizo", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.utilizo = :utilizo"),
    @NamedQuery(name = "DetalleFumigacionProducto.findByQuedo", query = "SELECT d FROM DetalleFumigacionProducto d WHERE d.quedo = :quedo")})
public class DetalleFumigacionProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_FUMIGACION_PRODUCTO", nullable = false)
    private Integer idDetalleFumigacionProducto;
    @Basic(optional = false)
    @Column(name = "CANTIDAD", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "UTILIZO", nullable = false, precision = 9, scale = 3)
    private BigDecimal utilizo;
    @Basic(optional = false)
    @Column(name = "QUEDO", nullable = false, precision = 9, scale = 3)
    private BigDecimal quedo;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;
    @JoinColumn(name = "ID_CONTRATO_FUMIGACION", referencedColumnName = "ID_CONTRATO_FUMIGACION", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContratoFumigacion contratoFumigacion;

    public DetalleFumigacionProducto() {
    }

    public DetalleFumigacionProducto(Integer idDetalleFumigacionProducto) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
    }

    public DetalleFumigacionProducto(Integer idDetalleFumigacionProducto, int cantidad, BigDecimal utilizo, BigDecimal quedo) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
        this.cantidad = cantidad;
        this.utilizo = utilizo;
        this.quedo = quedo;
    }

    public Integer getIdDetalleFumigacionProducto() {
        return idDetalleFumigacionProducto;
    }

    public void setIdDetalleFumigacionProducto(Integer idDetalleFumigacionProducto) {
        this.idDetalleFumigacionProducto = idDetalleFumigacionProducto;
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

    public ContratoFumigacion getContratoFumigacion() {
        return contratoFumigacion;
    }

    public void setContratoFumigacion(ContratoFumigacion contratoFumigacion) {
        this.contratoFumigacion = contratoFumigacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleFumigacionProducto != null ? idDetalleFumigacionProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFumigacionProducto)) {
            return false;
        }
        DetalleFumigacionProducto other = (DetalleFumigacionProducto) object;
        if ((this.idDetalleFumigacionProducto == null && other.idDetalleFumigacionProducto != null) || (this.idDetalleFumigacionProducto != null && !this.idDetalleFumigacionProducto.equals(other.idDetalleFumigacionProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFumigacionProducto[idDetalleFumigacionProducto=" + idDetalleFumigacionProducto + "]";
    }

}
