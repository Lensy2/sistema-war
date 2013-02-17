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
@Table(name = "UNIDAD_TRANSPORTE", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "UnidadTransporte.findAll", query = "SELECT u FROM UnidadTransporte u"),
    @NamedQuery(name = "UnidadTransporte.findByIdUnidadTransporte", query = "SELECT u FROM UnidadTransporte u WHERE u.idUnidadTransporte = :idUnidadTransporte"),
    @NamedQuery(name = "UnidadTransporte.findByMarca", query = "SELECT u FROM UnidadTransporte u WHERE u.marca = :marca"),
    @NamedQuery(name = "UnidadTransporte.findByNumeroPlaca", query = "SELECT u FROM UnidadTransporte u WHERE u.numeroPlaca = :numeroPlaca"),
    @NamedQuery(name = "UnidadTransporte.findByNumeroConstanciaInscripcion", query = "SELECT u FROM UnidadTransporte u WHERE u.numeroConstanciaInscripcion = :numeroConstanciaInscripcion"),
    @NamedQuery(name = "UnidadTransporte.findByObservaciones", query = "SELECT u FROM UnidadTransporte u WHERE u.observaciones = :observaciones"),
    @NamedQuery(name = "UnidadTransporte.findByFechaRegistro", query = "SELECT u FROM UnidadTransporte u WHERE u.fechaRegistro = :fechaRegistro")})
public class UnidadTransporte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_UNIDAD_TRANSPORTE", nullable = false)
    private Integer idUnidadTransporte;
    @Basic(optional = false)
    @Column(name = "MARCA", nullable = false, length = 200)
    private String marca;
    @Basic(optional = false)
    @Column(name = "NUMERO_PLACA", nullable = false, length = 200)
    private String numeroPlaca;
    @Basic(optional = false)
    @Column(name = "NUMERO_CONSTANCIA_INSCRIPCION", nullable = false, length = 200)
    private String numeroConstanciaInscripcion;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES", nullable = false, length = 200)
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadTransporte", fetch = FetchType.LAZY)
    private List<GuiaRemicion> guiaRemicionList;

    public UnidadTransporte() {
    }

    public UnidadTransporte(Integer idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public UnidadTransporte(Integer idUnidadTransporte, String marca, String numeroPlaca, String numeroConstanciaInscripcion, String observaciones, Date fechaRegistro) {
        this.idUnidadTransporte = idUnidadTransporte;
        this.marca = marca;
        this.numeroPlaca = numeroPlaca;
        this.numeroConstanciaInscripcion = numeroConstanciaInscripcion;
        this.observaciones = observaciones;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdUnidadTransporte() {
        return idUnidadTransporte;
    }

    public void setIdUnidadTransporte(Integer idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public String getNumeroConstanciaInscripcion() {
        return numeroConstanciaInscripcion;
    }

    public void setNumeroConstanciaInscripcion(String numeroConstanciaInscripcion) {
        this.numeroConstanciaInscripcion = numeroConstanciaInscripcion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
        hash += (idUnidadTransporte != null ? idUnidadTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadTransporte)) {
            return false;
        }
        UnidadTransporte other = (UnidadTransporte) object;
        if ((this.idUnidadTransporte == null && other.idUnidadTransporte != null) || (this.idUnidadTransporte != null && !this.idUnidadTransporte.equals(other.idUnidadTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.UnidadTransporte[idUnidadTransporte=" + idUnidadTransporte + "]";
    }

}
