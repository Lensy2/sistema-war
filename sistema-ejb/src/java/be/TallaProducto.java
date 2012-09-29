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
@Table(name = "TALLA_PRODUCTO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "TallaProducto.findAll", query = "SELECT t FROM TallaProducto t"),
    @NamedQuery(name = "TallaProducto.findByIdTallaProducto", query = "SELECT t FROM TallaProducto t WHERE t.idTallaProducto = :idTallaProducto"),
    @NamedQuery(name = "TallaProducto.findByNombreTallaProducto", query = "SELECT t FROM TallaProducto t WHERE t.nombreTallaProducto = :nombreTallaProducto"),
    @NamedQuery(name = "TallaProducto.findByDescripcion", query = "SELECT t FROM TallaProducto t WHERE t.descripcion = :descripcion")})
public class TallaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TALLA_PRODUCTO", nullable = false)
    private Integer idTallaProducto;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TALLA_PRODUCTO", nullable = false, length = 100)
    private String nombreTallaProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 170)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tallaProducto", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public TallaProducto() {
    }

    public TallaProducto(Integer idTallaProducto) {
        this.idTallaProducto = idTallaProducto;
    }

    public TallaProducto(Integer idTallaProducto, String nombreTallaProducto, String descripcion) {
        this.idTallaProducto = idTallaProducto;
        this.nombreTallaProducto = nombreTallaProducto;
        this.descripcion = descripcion;
    }

    public Integer getIdTallaProducto() {
        return idTallaProducto;
    }

    public void setIdTallaProducto(Integer idTallaProducto) {
        this.idTallaProducto = idTallaProducto;
    }

    public String getNombreTallaProducto() {
        return nombreTallaProducto;
    }

    public void setNombreTallaProducto(String nombreTallaProducto) {
        this.nombreTallaProducto = nombreTallaProducto;
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
        hash += (idTallaProducto != null ? idTallaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TallaProducto)) {
            return false;
        }
        TallaProducto other = (TallaProducto) object;
        if ((this.idTallaProducto == null && other.idTallaProducto != null) || (this.idTallaProducto != null && !this.idTallaProducto.equals(other.idTallaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TallaProducto[idTallaProducto=" + idTallaProducto + "]";
    }

}
