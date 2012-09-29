/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TIPO_PROVEEDOR", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoProveedor.findAll", query = "SELECT t FROM TipoProveedor t"),
    @NamedQuery(name = "TipoProveedor.findByIdTipoProveedor", query = "SELECT t FROM TipoProveedor t WHERE t.idTipoProveedor = :idTipoProveedor"),
    @NamedQuery(name = "TipoProveedor.findByNombre", query = "SELECT t FROM TipoProveedor t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoProveedor.findByDescripcion", query = "SELECT t FROM TipoProveedor t WHERE t.descripcion = :descripcion")})
public class TipoProveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PROVEEDOR", nullable = false)
    private Integer idTipoProveedor;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 250)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;
    @OneToMany(mappedBy = "tipoProveedor", fetch = FetchType.LAZY)
    private List<Proveedor> proveedorList;

    public TipoProveedor() {
    }

    public TipoProveedor(Integer idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
    }

    public TipoProveedor(Integer idTipoProveedor, String nombre, String descripcion) {
        this.idTipoProveedor = idTipoProveedor;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoProveedor() {
        return idTipoProveedor;
    }

    public void setIdTipoProveedor(Integer idTipoProveedor) {
        this.idTipoProveedor = idTipoProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoProveedor != null ? idTipoProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoProveedor)) {
            return false;
        }
        TipoProveedor other = (TipoProveedor) object;
        if ((this.idTipoProveedor == null && other.idTipoProveedor != null) || (this.idTipoProveedor != null && !this.idTipoProveedor.equals(other.idTipoProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoProveedor[idTipoProveedor=" + idTipoProveedor + "]";
    }

}
