/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TIPO_PLAGA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoPlaga.findAll", query = "SELECT t FROM TipoPlaga t"),
    @NamedQuery(name = "TipoPlaga.findByIdTipoPlaga", query = "SELECT t FROM TipoPlaga t WHERE t.idTipoPlaga = :idTipoPlaga"),
    @NamedQuery(name = "TipoPlaga.findByNombreTipoPlaga", query = "SELECT t FROM TipoPlaga t WHERE t.nombreTipoPlaga = :nombreTipoPlaga"),
    @NamedQuery(name = "TipoPlaga.findByDescripcion", query = "SELECT t FROM TipoPlaga t WHERE t.descripcion = :descripcion")})
public class TipoPlaga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PLAGA", nullable = false)
    private Integer idTipoPlaga;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_PLAGA", nullable = false, length = 170)
    private String nombreTipoPlaga;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;

    public TipoPlaga() {
    }

    public TipoPlaga(Integer idTipoPlaga) {
        this.idTipoPlaga = idTipoPlaga;
    }

    public TipoPlaga(Integer idTipoPlaga, String nombreTipoPlaga, String descripcion) {
        this.idTipoPlaga = idTipoPlaga;
        this.nombreTipoPlaga = nombreTipoPlaga;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoPlaga() {
        return idTipoPlaga;
    }

    public void setIdTipoPlaga(Integer idTipoPlaga) {
        this.idTipoPlaga = idTipoPlaga;
    }

    public String getNombreTipoPlaga() {
        return nombreTipoPlaga;
    }

    public void setNombreTipoPlaga(String nombreTipoPlaga) {
        this.nombreTipoPlaga = nombreTipoPlaga;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPlaga != null ? idTipoPlaga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlaga)) {
            return false;
        }
        TipoPlaga other = (TipoPlaga) object;
        if ((this.idTipoPlaga == null && other.idTipoPlaga != null) || (this.idTipoPlaga != null && !this.idTipoPlaga.equals(other.idTipoPlaga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoPlaga[idTipoPlaga=" + idTipoPlaga + "]";
    }

}
