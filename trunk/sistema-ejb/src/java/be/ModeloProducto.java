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
@Table(name = "MODELO_PRODUCTO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "ModeloProducto.findAll", query = "SELECT m FROM ModeloProducto m"),
    @NamedQuery(name = "ModeloProducto.findByIdModeloProducto", query = "SELECT m FROM ModeloProducto m WHERE m.idModeloProducto = :idModeloProducto"),
    @NamedQuery(name = "ModeloProducto.findByNombreModeloProducto", query = "SELECT m FROM ModeloProducto m WHERE m.nombreModeloProducto = :nombreModeloProducto"),
    @NamedQuery(name = "ModeloProducto.findByDescripcion", query = "SELECT m FROM ModeloProducto m WHERE m.descripcion = :descripcion")})
public class ModeloProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MODELO_PRODUCTO", nullable = false)
    private Integer idModeloProducto;
    @Basic(optional = false)
    @Column(name = "NOMBRE_MODELO_PRODUCTO", nullable = false, length = 100)
    private String nombreModeloProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeloProducto", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public ModeloProducto() {
    }

    public ModeloProducto(Integer idModeloProducto) {
        this.idModeloProducto = idModeloProducto;
    }

    public ModeloProducto(Integer idModeloProducto, String nombreModeloProducto, String descripcion) {
        this.idModeloProducto = idModeloProducto;
        this.nombreModeloProducto = nombreModeloProducto;
        this.descripcion = descripcion;
    }

    public Integer getIdModeloProducto() {
        return idModeloProducto;
    }

    public void setIdModeloProducto(Integer idModeloProducto) {
        this.idModeloProducto = idModeloProducto;
    }

    public String getNombreModeloProducto() {
        return nombreModeloProducto;
    }

    public void setNombreModeloProducto(String nombreModeloProducto) {
        this.nombreModeloProducto = nombreModeloProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModeloProducto != null ? idModeloProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeloProducto)) {
            return false;
        }
        ModeloProducto other = (ModeloProducto) object;
        if ((this.idModeloProducto == null && other.idModeloProducto != null) || (this.idModeloProducto != null && !this.idModeloProducto.equals(other.idModeloProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ModeloProducto[idModeloProducto=" + idModeloProducto + "]";
    }

}
