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
@Table(name = "TIPO_SERVICIO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoServicio.findAll", query = "SELECT t FROM TipoServicio t"),
    @NamedQuery(name = "TipoServicio.findByIdTipoServicio", query = "SELECT t FROM TipoServicio t WHERE t.idTipoServicio = :idTipoServicio"),
    @NamedQuery(name = "TipoServicio.findByNombreTipoServicio", query = "SELECT t FROM TipoServicio t WHERE t.nombreTipoServicio = :nombreTipoServicio"),
    @NamedQuery(name = "TipoServicio.findByDescripcion", query = "SELECT t FROM TipoServicio t WHERE t.descripcion = :descripcion")})
public class TipoServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_SERVICIO", nullable = false)
    private Integer idTipoServicio;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_SERVICIO", nullable = false, length = 170)
    private String nombreTipoServicio;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoServicio", fetch = FetchType.LAZY)
    private List<Servicio> servicioList;

    public TipoServicio() {
    }

    public TipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public TipoServicio(Integer idTipoServicio, String nombreTipoServicio, String descripcion) {
        this.idTipoServicio = idTipoServicio;
        this.nombreTipoServicio = nombreTipoServicio;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }

    public void setNombreTipoServicio(String nombreTipoServicio) {
        this.nombreTipoServicio = nombreTipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoServicio != null ? idTipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoServicio)) {
            return false;
        }
        TipoServicio other = (TipoServicio) object;
        if ((this.idTipoServicio == null && other.idTipoServicio != null) || (this.idTipoServicio != null && !this.idTipoServicio.equals(other.idTipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoServicio[idTipoServicio=" + idTipoServicio + "]";
    }

}
