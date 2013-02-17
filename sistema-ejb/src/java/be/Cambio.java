/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "CAMBIO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cambio.findAll", query = "SELECT c FROM Cambio c"),
    @NamedQuery(name = "Cambio.findByIdCambio", query = "SELECT c FROM Cambio c WHERE c.idCambio = :idCambio"),
    @NamedQuery(name = "Cambio.findByFechaCambio", query = "SELECT c FROM Cambio c WHERE c.fechaCambio = :fechaCambio"),
    @NamedQuery(name = "Cambio.findByMotivoCambio", query = "SELECT c FROM Cambio c WHERE c.motivoCambio = :motivoCambio")})
public class Cambio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CAMBIO", nullable = false)
    private Integer idCambio;
    @Basic(optional = false)
    @Column(name = "FECHA_CAMBIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCambio;
    @Basic(optional = false)
    @Column(name = "MOTIVO_CAMBIO", nullable = false, length = 300)
    private String motivoCambio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cambio", fetch = FetchType.LAZY)
    private List<DetalleCambioProducto> detalleCambioProductoList;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venta venta;

    public Cambio() {
    }

    public Cambio(Integer idCambio) {
        this.idCambio = idCambio;
    }

    public Cambio(Integer idCambio, Date fechaCambio, String motivoCambio) {
        this.idCambio = idCambio;
        this.fechaCambio = fechaCambio;
        this.motivoCambio = motivoCambio;
    }

    public Integer getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(Integer idCambio) {
        this.idCambio = idCambio;
    }

    public Date getFechaCambio() {
        return fechaCambio;
    }

    public void setFechaCambio(Date fechaCambio) {
        this.fechaCambio = fechaCambio;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    public List<DetalleCambioProducto> getDetalleCambioProductoList() {
        return detalleCambioProductoList;
    }

    public void setDetalleCambioProductoList(List<DetalleCambioProducto> detalleCambioProductoList) {
        this.detalleCambioProductoList = detalleCambioProductoList;
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
        hash += (idCambio != null ? idCambio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cambio)) {
            return false;
        }
        Cambio other = (Cambio) object;
        if ((this.idCambio == null && other.idCambio != null) || (this.idCambio != null && !this.idCambio.equals(other.idCambio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Cambio[idCambio=" + idCambio + "]";
    }

}
