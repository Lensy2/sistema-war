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
@Table(name = "FORMULACION", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Formulacion.findAll", query = "SELECT f FROM Formulacion f"),
    @NamedQuery(name = "Formulacion.findByIdFormulacion", query = "SELECT f FROM Formulacion f WHERE f.idFormulacion = :idFormulacion"),
    @NamedQuery(name = "Formulacion.findByFechaRegistro", query = "SELECT f FROM Formulacion f WHERE f.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Formulacion.findByPalabraClave", query = "SELECT f FROM Formulacion f WHERE f.palabraClave = :palabraClave"),
    @NamedQuery(name = "Formulacion.findByDescripcion", query = "SELECT f FROM Formulacion f WHERE f.descripcion = :descripcion")})
public class Formulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FORMULACION", nullable = false)
    private Integer idFormulacion;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "PALABRA_CLAVE", nullable = false, length = 250)
    private String palabraClave;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 800)
    private String descripcion;
    @OneToMany(mappedBy = "formulacion", fetch = FetchType.LAZY)
    private List<ProduccionAlmacen> produccionAlmacenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formulacion", fetch = FetchType.LAZY)
    private List<DetalleFormulacionInsumos> detalleFormulacionInsumosList;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto producto;

    public Formulacion() {
    }

    public Formulacion(Integer idFormulacion) {
        this.idFormulacion = idFormulacion;
    }

    public Formulacion(Integer idFormulacion, Date fechaRegistro, String palabraClave, String descripcion) {
        this.idFormulacion = idFormulacion;
        this.fechaRegistro = fechaRegistro;
        this.palabraClave = palabraClave;
        this.descripcion = descripcion;
    }

    public Integer getIdFormulacion() {
        return idFormulacion;
    }

    public void setIdFormulacion(Integer idFormulacion) {
        this.idFormulacion = idFormulacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ProduccionAlmacen> getProduccionAlmacenList() {
        return produccionAlmacenList;
    }

    public void setProduccionAlmacenList(List<ProduccionAlmacen> produccionAlmacenList) {
        this.produccionAlmacenList = produccionAlmacenList;
    }

    public List<DetalleFormulacionInsumos> getDetalleFormulacionInsumosList() {
        return detalleFormulacionInsumosList;
    }

    public void setDetalleFormulacionInsumosList(List<DetalleFormulacionInsumos> detalleFormulacionInsumosList) {
        this.detalleFormulacionInsumosList = detalleFormulacionInsumosList;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulacion != null ? idFormulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulacion)) {
            return false;
        }
        Formulacion other = (Formulacion) object;
        if ((this.idFormulacion == null && other.idFormulacion != null) || (this.idFormulacion != null && !this.idFormulacion.equals(other.idFormulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Formulacion[idFormulacion=" + idFormulacion + "]";
    }

}
