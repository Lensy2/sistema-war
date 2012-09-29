/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "REPORTE_FUMIGACION", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "ReporteFumigacion.findAll", query = "SELECT r FROM ReporteFumigacion r"),
    @NamedQuery(name = "ReporteFumigacion.findByIdReporteFumigacion", query = "SELECT r FROM ReporteFumigacion r WHERE r.idReporteFumigacion = :idReporteFumigacion"),
    @NamedQuery(name = "ReporteFumigacion.findByFecha", query = "SELECT r FROM ReporteFumigacion r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "ReporteFumigacion.findByDescripcionCliente", query = "SELECT r FROM ReporteFumigacion r WHERE r.descripcionCliente = :descripcionCliente"),
    @NamedQuery(name = "ReporteFumigacion.findByCaracteristicasAlbiente", query = "SELECT r FROM ReporteFumigacion r WHERE r.caracteristicasAlbiente = :caracteristicasAlbiente"),
    @NamedQuery(name = "ReporteFumigacion.findByAreaEstimada", query = "SELECT r FROM ReporteFumigacion r WHERE r.areaEstimada = :areaEstimada"),
    @NamedQuery(name = "ReporteFumigacion.findByAreaTratada", query = "SELECT r FROM ReporteFumigacion r WHERE r.areaTratada = :areaTratada"),
    @NamedQuery(name = "ReporteFumigacion.findByTipoPlaga", query = "SELECT r FROM ReporteFumigacion r WHERE r.tipoPlaga = :tipoPlaga"),
    @NamedQuery(name = "ReporteFumigacion.findByPorcentajeInfestacion", query = "SELECT r FROM ReporteFumigacion r WHERE r.porcentajeInfestacion = :porcentajeInfestacion"),
    @NamedQuery(name = "ReporteFumigacion.findByPorcentajeCantidadFuentesAlimentarias", query = "SELECT r FROM ReporteFumigacion r WHERE r.porcentajeCantidadFuentesAlimentarias = :porcentajeCantidadFuentesAlimentarias"),
    @NamedQuery(name = "ReporteFumigacion.findByManejoResiduosAlimenticios", query = "SELECT r FROM ReporteFumigacion r WHERE r.manejoResiduosAlimenticios = :manejoResiduosAlimenticios"),
    @NamedQuery(name = "ReporteFumigacion.findByPorcentajeHigiene", query = "SELECT r FROM ReporteFumigacion r WHERE r.porcentajeHigiene = :porcentajeHigiene"),
    @NamedQuery(name = "ReporteFumigacion.findByMobiliario", query = "SELECT r FROM ReporteFumigacion r WHERE r.mobiliario = :mobiliario"),
    @NamedQuery(name = "ReporteFumigacion.findByDispercion", query = "SELECT r FROM ReporteFumigacion r WHERE r.dispercion = :dispercion"),
    @NamedQuery(name = "ReporteFumigacion.findByPorcentajeMachos", query = "SELECT r FROM ReporteFumigacion r WHERE r.porcentajeMachos = :porcentajeMachos"),
    @NamedQuery(name = "ReporteFumigacion.findByPorcentajeHembras", query = "SELECT r FROM ReporteFumigacion r WHERE r.porcentajeHembras = :porcentajeHembras"),
    @NamedQuery(name = "ReporteFumigacion.findByTapadoGrietas", query = "SELECT r FROM ReporteFumigacion r WHERE r.tapadoGrietas = :tapadoGrietas"),
    @NamedQuery(name = "ReporteFumigacion.findByZonasEquipos", query = "SELECT r FROM ReporteFumigacion r WHERE r.zonasEquipos = :zonasEquipos"),
    @NamedQuery(name = "ReporteFumigacion.findByUtilizacionProducto", query = "SELECT r FROM ReporteFumigacion r WHERE r.utilizacionProducto = :utilizacionProducto")})
public class ReporteFumigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REPORTE_FUMIGACION", nullable = false)
    private Integer idReporteFumigacion;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_CLIENTE", nullable = false, length = 350)
    private String descripcionCliente;
    @Basic(optional = false)
    @Column(name = "CARACTERISTICAS_ALBIENTE", nullable = false, length = 100)
    private String caracteristicasAlbiente;
    @Basic(optional = false)
    @Column(name = "AREA_ESTIMADA", nullable = false, length = 20)
    private String areaEstimada;
    @Basic(optional = false)
    @Column(name = "AREA_TRATADA", nullable = false, length = 20)
    private String areaTratada;
    @Basic(optional = false)
    @Column(name = "TIPO_PLAGA", nullable = false, length = 100)
    private String tipoPlaga;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_INFESTACION", nullable = false)
    private int porcentajeInfestacion;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_CANTIDAD_FUENTES_ALIMENTARIAS", nullable = false)
    private int porcentajeCantidadFuentesAlimentarias;
    @Basic(optional = false)
    @Column(name = "MANEJO_RESIDUOS_ALIMENTICIOS", nullable = false, length = 45)
    private String manejoResiduosAlimenticios;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_HIGIENE", nullable = false)
    private int porcentajeHigiene;
    @Basic(optional = false)
    @Column(name = "MOBILIARIO", nullable = false, length = 250)
    private String mobiliario;
    @Basic(optional = false)
    @Column(name = "DISPERCION", nullable = false, length = 400)
    private String dispercion;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_MACHOS", nullable = false)
    private int porcentajeMachos;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_HEMBRAS", nullable = false)
    private int porcentajeHembras;
    @Basic(optional = false)
    @Column(name = "TAPADO_GRIETAS", nullable = false, length = 100)
    private String tapadoGrietas;
    @Basic(optional = false)
    @Column(name = "ZONAS_EQUIPOS", nullable = false, length = 370)
    private String zonasEquipos;
    @Basic(optional = false)
    @Column(name = "UTILIZACION_PRODUCTO", nullable = false, length = 500)
    private String utilizacionProducto;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "ID_CONTRATO_FUMIGACION", referencedColumnName = "ID_CONTRATO_FUMIGACION", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ContratoFumigacion contratoFumigacion;

    public ReporteFumigacion() {
    }

    public ReporteFumigacion(Integer idReporteFumigacion) {
        this.idReporteFumigacion = idReporteFumigacion;
    }

    public ReporteFumigacion(Integer idReporteFumigacion, Date fecha, String descripcionCliente, String caracteristicasAlbiente, String areaEstimada, String areaTratada, String tipoPlaga, int porcentajeInfestacion, int porcentajeCantidadFuentesAlimentarias, String manejoResiduosAlimenticios, int porcentajeHigiene, String mobiliario, String dispercion, int porcentajeMachos, int porcentajeHembras, String tapadoGrietas, String zonasEquipos, String utilizacionProducto) {
        this.idReporteFumigacion = idReporteFumigacion;
        this.fecha = fecha;
        this.descripcionCliente = descripcionCliente;
        this.caracteristicasAlbiente = caracteristicasAlbiente;
        this.areaEstimada = areaEstimada;
        this.areaTratada = areaTratada;
        this.tipoPlaga = tipoPlaga;
        this.porcentajeInfestacion = porcentajeInfestacion;
        this.porcentajeCantidadFuentesAlimentarias = porcentajeCantidadFuentesAlimentarias;
        this.manejoResiduosAlimenticios = manejoResiduosAlimenticios;
        this.porcentajeHigiene = porcentajeHigiene;
        this.mobiliario = mobiliario;
        this.dispercion = dispercion;
        this.porcentajeMachos = porcentajeMachos;
        this.porcentajeHembras = porcentajeHembras;
        this.tapadoGrietas = tapadoGrietas;
        this.zonasEquipos = zonasEquipos;
        this.utilizacionProducto = utilizacionProducto;
    }

    public Integer getIdReporteFumigacion() {
        return idReporteFumigacion;
    }

    public void setIdReporteFumigacion(Integer idReporteFumigacion) {
        this.idReporteFumigacion = idReporteFumigacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionCliente() {
        return descripcionCliente;
    }

    public void setDescripcionCliente(String descripcionCliente) {
        this.descripcionCliente = descripcionCliente;
    }

    public String getCaracteristicasAlbiente() {
        return caracteristicasAlbiente;
    }

    public void setCaracteristicasAlbiente(String caracteristicasAlbiente) {
        this.caracteristicasAlbiente = caracteristicasAlbiente;
    }

    public String getAreaEstimada() {
        return areaEstimada;
    }

    public void setAreaEstimada(String areaEstimada) {
        this.areaEstimada = areaEstimada;
    }

    public String getAreaTratada() {
        return areaTratada;
    }

    public void setAreaTratada(String areaTratada) {
        this.areaTratada = areaTratada;
    }

    public String getTipoPlaga() {
        return tipoPlaga;
    }

    public void setTipoPlaga(String tipoPlaga) {
        this.tipoPlaga = tipoPlaga;
    }

    public int getPorcentajeInfestacion() {
        return porcentajeInfestacion;
    }

    public void setPorcentajeInfestacion(int porcentajeInfestacion) {
        this.porcentajeInfestacion = porcentajeInfestacion;
    }

    public int getPorcentajeCantidadFuentesAlimentarias() {
        return porcentajeCantidadFuentesAlimentarias;
    }

    public void setPorcentajeCantidadFuentesAlimentarias(int porcentajeCantidadFuentesAlimentarias) {
        this.porcentajeCantidadFuentesAlimentarias = porcentajeCantidadFuentesAlimentarias;
    }

    public String getManejoResiduosAlimenticios() {
        return manejoResiduosAlimenticios;
    }

    public void setManejoResiduosAlimenticios(String manejoResiduosAlimenticios) {
        this.manejoResiduosAlimenticios = manejoResiduosAlimenticios;
    }

    public int getPorcentajeHigiene() {
        return porcentajeHigiene;
    }

    public void setPorcentajeHigiene(int porcentajeHigiene) {
        this.porcentajeHigiene = porcentajeHigiene;
    }

    public String getMobiliario() {
        return mobiliario;
    }

    public void setMobiliario(String mobiliario) {
        this.mobiliario = mobiliario;
    }

    public String getDispercion() {
        return dispercion;
    }

    public void setDispercion(String dispercion) {
        this.dispercion = dispercion;
    }

    public int getPorcentajeMachos() {
        return porcentajeMachos;
    }

    public void setPorcentajeMachos(int porcentajeMachos) {
        this.porcentajeMachos = porcentajeMachos;
    }

    public int getPorcentajeHembras() {
        return porcentajeHembras;
    }

    public void setPorcentajeHembras(int porcentajeHembras) {
        this.porcentajeHembras = porcentajeHembras;
    }

    public String getTapadoGrietas() {
        return tapadoGrietas;
    }

    public void setTapadoGrietas(String tapadoGrietas) {
        this.tapadoGrietas = tapadoGrietas;
    }

    public String getZonasEquipos() {
        return zonasEquipos;
    }

    public void setZonasEquipos(String zonasEquipos) {
        this.zonasEquipos = zonasEquipos;
    }

    public String getUtilizacionProducto() {
        return utilizacionProducto;
    }

    public void setUtilizacionProducto(String utilizacionProducto) {
        this.utilizacionProducto = utilizacionProducto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ContratoFumigacion getContratoFumigacion() {
        return contratoFumigacion;
    }

    public void setContratoFumigacion(ContratoFumigacion contratoFumigacion) {
        this.contratoFumigacion = contratoFumigacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporteFumigacion != null ? idReporteFumigacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteFumigacion)) {
            return false;
        }
        ReporteFumigacion other = (ReporteFumigacion) object;
        if ((this.idReporteFumigacion == null && other.idReporteFumigacion != null) || (this.idReporteFumigacion != null && !this.idReporteFumigacion.equals(other.idReporteFumigacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ReporteFumigacion[idReporteFumigacion=" + idReporteFumigacion + "]";
    }

}
