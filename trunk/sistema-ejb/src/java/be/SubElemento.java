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
@Table(name = "SUB_ELEMENTO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "SubElemento.findAll", query = "SELECT s FROM SubElemento s"),
    @NamedQuery(name = "SubElemento.findByIdSubElemento", query = "SELECT s FROM SubElemento s WHERE s.idSubElemento = :idSubElemento"),
    @NamedQuery(name = "SubElemento.findByNombreSubElemento", query = "SELECT s FROM SubElemento s WHERE s.nombreSubElemento = :nombreSubElemento"),
    @NamedQuery(name = "SubElemento.findByDescripcion", query = "SELECT s FROM SubElemento s WHERE s.descripcion = :descripcion")})
public class SubElemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SUB_ELEMENTO", nullable = false)
    private Integer idSubElemento;
    @Basic(optional = false)
    @Column(name = "NOMBRE_SUB_ELEMENTO", nullable = false, length = 170)
    private String nombreSubElemento;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subElemento", fetch = FetchType.LAZY)
    private List<CuentaContable> cuentaContableList;

    public SubElemento() {
    }

    public SubElemento(Integer idSubElemento) {
        this.idSubElemento = idSubElemento;
    }

    public SubElemento(Integer idSubElemento, String nombreSubElemento, String descripcion) {
        this.idSubElemento = idSubElemento;
        this.nombreSubElemento = nombreSubElemento;
        this.descripcion = descripcion;
    }

    public Integer getIdSubElemento() {
        return idSubElemento;
    }

    public void setIdSubElemento(Integer idSubElemento) {
        this.idSubElemento = idSubElemento;
    }

    public String getNombreSubElemento() {
        return nombreSubElemento;
    }

    public void setNombreSubElemento(String nombreSubElemento) {
        this.nombreSubElemento = nombreSubElemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CuentaContable> getCuentaContableList() {
        return cuentaContableList;
    }

    public void setCuentaContableList(List<CuentaContable> cuentaContableList) {
        this.cuentaContableList = cuentaContableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubElemento != null ? idSubElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubElemento)) {
            return false;
        }
        SubElemento other = (SubElemento) object;
        if ((this.idSubElemento == null && other.idSubElemento != null) || (this.idSubElemento != null && !this.idSubElemento.equals(other.idSubElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.SubElemento[idSubElemento=" + idSubElemento + "]";
    }

}
