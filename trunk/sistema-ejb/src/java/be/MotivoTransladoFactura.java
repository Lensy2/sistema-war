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
@Table(name = "MOTIVO_TRANSLADO_FACTURA", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "MotivoTransladoFactura.findAll", query = "SELECT m FROM MotivoTransladoFactura m"),
    @NamedQuery(name = "MotivoTransladoFactura.findByIdMotivoTransladoFactura", query = "SELECT m FROM MotivoTransladoFactura m WHERE m.idMotivoTransladoFactura = :idMotivoTransladoFactura"),
    @NamedQuery(name = "MotivoTransladoFactura.findByMotivo", query = "SELECT m FROM MotivoTransladoFactura m WHERE m.motivo = :motivo"),
    @NamedQuery(name = "MotivoTransladoFactura.findByDescripcion", query = "SELECT m FROM MotivoTransladoFactura m WHERE m.descripcion = :descripcion")})
public class MotivoTransladoFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MOTIVO_TRANSLADO_FACTURA", nullable = false)
    private Integer idMotivoTransladoFactura;
    @Basic(optional = false)
    @Column(name = "MOTIVO", nullable = false, length = 100)
    private String motivo;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motivoTransladoFactura", fetch = FetchType.LAZY)
    private List<GuiaRemicion> guiaRemicionList;

    public MotivoTransladoFactura() {
    }

    public MotivoTransladoFactura(Integer idMotivoTransladoFactura) {
        this.idMotivoTransladoFactura = idMotivoTransladoFactura;
    }

    public MotivoTransladoFactura(Integer idMotivoTransladoFactura, String motivo, String descripcion) {
        this.idMotivoTransladoFactura = idMotivoTransladoFactura;
        this.motivo = motivo;
        this.descripcion = descripcion;
    }

    public Integer getIdMotivoTransladoFactura() {
        return idMotivoTransladoFactura;
    }

    public void setIdMotivoTransladoFactura(Integer idMotivoTransladoFactura) {
        this.idMotivoTransladoFactura = idMotivoTransladoFactura;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<GuiaRemicion> getGuiaRemicionList() {
        return guiaRemicionList;
    }

    public void setGuiaRemicionList(List<GuiaRemicion> guiaRemicionList) {
        this.guiaRemicionList = guiaRemicionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivoTransladoFactura != null ? idMotivoTransladoFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoTransladoFactura)) {
            return false;
        }
        MotivoTransladoFactura other = (MotivoTransladoFactura) object;
        if ((this.idMotivoTransladoFactura == null && other.idMotivoTransladoFactura != null) || (this.idMotivoTransladoFactura != null && !this.idMotivoTransladoFactura.equals(other.idMotivoTransladoFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.MotivoTransladoFactura[idMotivoTransladoFactura=" + idMotivoTransladoFactura + "]";
    }

}
