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
@Table(name = "ESTADO_LETRAS_PAGO_CANJE", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "EstadoLetrasPagoCanje.findAll", query = "SELECT e FROM EstadoLetrasPagoCanje e"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByIdEstadoLetrasPagoCanje", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.idEstadoLetrasPagoCanje = :idEstadoLetrasPagoCanje"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByNombre", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoLetrasPagoCanje.findByDescripcion", query = "SELECT e FROM EstadoLetrasPagoCanje e WHERE e.descripcion = :descripcion")})
public class EstadoLetrasPagoCanje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_LETRAS_PAGO_CANJE", nullable = false)
    private Integer idEstadoLetrasPagoCanje;
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 170)
    private String descripcion;
    @OneToMany(mappedBy = "estadoLetrasPagoCanje", fetch = FetchType.LAZY)
    private List<LetrasPagoCanje> letrasPagoCanjeList;

    public EstadoLetrasPagoCanje() {
    }

    public EstadoLetrasPagoCanje(Integer idEstadoLetrasPagoCanje) {
        this.idEstadoLetrasPagoCanje = idEstadoLetrasPagoCanje;
    }

    public Integer getIdEstadoLetrasPagoCanje() {
        return idEstadoLetrasPagoCanje;
    }

    public void setIdEstadoLetrasPagoCanje(Integer idEstadoLetrasPagoCanje) {
        this.idEstadoLetrasPagoCanje = idEstadoLetrasPagoCanje;
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

    public List<LetrasPagoCanje> getLetrasPagoCanjeList() {
        return letrasPagoCanjeList;
    }

    public void setLetrasPagoCanjeList(List<LetrasPagoCanje> letrasPagoCanjeList) {
        this.letrasPagoCanjeList = letrasPagoCanjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoLetrasPagoCanje != null ? idEstadoLetrasPagoCanje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoLetrasPagoCanje)) {
            return false;
        }
        EstadoLetrasPagoCanje other = (EstadoLetrasPagoCanje) object;
        if ((this.idEstadoLetrasPagoCanje == null && other.idEstadoLetrasPagoCanje != null) || (this.idEstadoLetrasPagoCanje != null && !this.idEstadoLetrasPagoCanje.equals(other.idEstadoLetrasPagoCanje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoLetrasPagoCanje[idEstadoLetrasPagoCanje=" + idEstadoLetrasPagoCanje + "]";
    }

}
