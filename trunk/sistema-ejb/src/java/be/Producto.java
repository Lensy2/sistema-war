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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "PRODUCTO", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto"),
    @NamedQuery(name = "Producto.findByFechaIngreso", query = "SELECT p FROM Producto p WHERE p.fechaIngreso = :fechaIngreso")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO", nullable = false)
    private Integer idProducto;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PRODUCTO", nullable = false, length = 300)
    private String nombreProducto;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleFumigacionProducto> detalleFumigacionProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList;
    @JoinColumn(name = "ID_MATERIAL_PRODUCTO", referencedColumnName = "ID_MATERIAL_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MaterialProducto materialProducto;
    @JoinColumn(name = "ID_ESTADO_PRODUCTO", referencedColumnName = "ID_ESTADO_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoProducto estadoProducto;
    @JoinColumn(name = "ID_TALLA_PRODUCTO", referencedColumnName = "ID_TALLA_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TallaProducto tallaProducto;
    @JoinColumn(name = "ID_COLOR_PRODUCTO", referencedColumnName = "ID_COLOR_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ColorProducto colorProducto;
    @JoinColumn(name = "ID_TIPO_PRODUCTO", referencedColumnName = "ID_TIPO_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoProducto tipoProducto;
    @JoinColumn(name = "ID_MODELO_PRODUCTO", referencedColumnName = "ID_MODELO_PRODUCTO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ModeloProducto modeloProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleCambioProducto> detalleCambioProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto1", fetch = FetchType.LAZY)
    private List<DetalleCambioProducto> detalleCambioProductoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleFacturaVentaProducto> detalleFacturaVentaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DevolucionLima> devolucionLimaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private PrecioProducto precioProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleVentaProducto> detalleVentaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleServicioProducto> detalleServicioProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<SalidaProductoTienda> salidaProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<IngresoProductoTienda> ingresoProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto", fetch = FetchType.LAZY)
    private List<Formulacion> formulacionList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombreProducto, Date fechaIngreso) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<DetalleFumigacionProducto> getDetalleFumigacionProductoList() {
        return detalleFumigacionProductoList;
    }

    public void setDetalleFumigacionProductoList(List<DetalleFumigacionProducto> detalleFumigacionProductoList) {
        this.detalleFumigacionProductoList = detalleFumigacionProductoList;
    }

    public List<DetalleAlmacenProductosCostos> getDetalleAlmacenProductosCostosList() {
        return detalleAlmacenProductosCostosList;
    }

    public void setDetalleAlmacenProductosCostosList(List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList) {
        this.detalleAlmacenProductosCostosList = detalleAlmacenProductosCostosList;
    }

    public List<StockProductoTiendaOrigen> getStockProductoTiendaOrigenList() {
        return stockProductoTiendaOrigenList;
    }

    public void setStockProductoTiendaOrigenList(List<StockProductoTiendaOrigen> stockProductoTiendaOrigenList) {
        this.stockProductoTiendaOrigenList = stockProductoTiendaOrigenList;
    }

    public List<DetalleOrdenCompraProducto> getDetalleOrdenCompraProductoList() {
        return detalleOrdenCompraProductoList;
    }

    public void setDetalleOrdenCompraProductoList(List<DetalleOrdenCompraProducto> detalleOrdenCompraProductoList) {
        this.detalleOrdenCompraProductoList = detalleOrdenCompraProductoList;
    }

    public MaterialProducto getMaterialProducto() {
        return materialProducto;
    }

    public void setMaterialProducto(MaterialProducto materialProducto) {
        this.materialProducto = materialProducto;
    }

    public EstadoProducto getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(EstadoProducto estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public TallaProducto getTallaProducto() {
        return tallaProducto;
    }

    public void setTallaProducto(TallaProducto tallaProducto) {
        this.tallaProducto = tallaProducto;
    }

    public ColorProducto getColorProducto() {
        return colorProducto;
    }

    public void setColorProducto(ColorProducto colorProducto) {
        this.colorProducto = colorProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public ModeloProducto getModeloProducto() {
        return modeloProducto;
    }

    public void setModeloProducto(ModeloProducto modeloProducto) {
        this.modeloProducto = modeloProducto;
    }

    public List<DetalleCambioProducto> getDetalleCambioProductoList() {
        return detalleCambioProductoList;
    }

    public void setDetalleCambioProductoList(List<DetalleCambioProducto> detalleCambioProductoList) {
        this.detalleCambioProductoList = detalleCambioProductoList;
    }

    public List<DetalleCambioProducto> getDetalleCambioProductoList1() {
        return detalleCambioProductoList1;
    }

    public void setDetalleCambioProductoList1(List<DetalleCambioProducto> detalleCambioProductoList1) {
        this.detalleCambioProductoList1 = detalleCambioProductoList1;
    }

    public List<DetalleFacturaVentaProducto> getDetalleFacturaVentaProductoList() {
        return detalleFacturaVentaProductoList;
    }

    public void setDetalleFacturaVentaProductoList(List<DetalleFacturaVentaProducto> detalleFacturaVentaProductoList) {
        this.detalleFacturaVentaProductoList = detalleFacturaVentaProductoList;
    }

    public List<DevolucionLima> getDevolucionLimaList() {
        return devolucionLimaList;
    }

    public void setDevolucionLimaList(List<DevolucionLima> devolucionLimaList) {
        this.devolucionLimaList = devolucionLimaList;
    }

    public PrecioProducto getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(PrecioProducto precioProducto) {
        this.precioProducto = precioProducto;
    }

    public List<DetalleVentaProducto> getDetalleVentaProductoList() {
        return detalleVentaProductoList;
    }

    public void setDetalleVentaProductoList(List<DetalleVentaProducto> detalleVentaProductoList) {
        this.detalleVentaProductoList = detalleVentaProductoList;
    }

    public List<DetalleServicioProducto> getDetalleServicioProductoList() {
        return detalleServicioProductoList;
    }

    public void setDetalleServicioProductoList(List<DetalleServicioProducto> detalleServicioProductoList) {
        this.detalleServicioProductoList = detalleServicioProductoList;
    }

    public List<SalidaProductoTienda> getSalidaProductoTiendaList() {
        return salidaProductoTiendaList;
    }

    public void setSalidaProductoTiendaList(List<SalidaProductoTienda> salidaProductoTiendaList) {
        this.salidaProductoTiendaList = salidaProductoTiendaList;
    }

    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    public List<IngresoProductoTienda> getIngresoProductoTiendaList() {
        return ingresoProductoTiendaList;
    }

    public void setIngresoProductoTiendaList(List<IngresoProductoTienda> ingresoProductoTiendaList) {
        this.ingresoProductoTiendaList = ingresoProductoTiendaList;
    }

    public List<Formulacion> getFormulacionList() {
        return formulacionList;
    }

    public void setFormulacionList(List<Formulacion> formulacionList) {
        this.formulacionList = formulacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Producto[idProducto=" + idProducto + "]";
    }

}
