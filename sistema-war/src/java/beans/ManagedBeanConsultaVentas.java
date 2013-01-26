/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.FacturaVentaFacadeLocal;
import bc.VentaFacadeLocal;
import be.DetalleFacturaVentaProducto;
import be.DetalleVentaProducto;
import be.FacturaVenta;
import be.Venta;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
/**
 *
 * @author argos
 */
@ManagedBean
@SessionScoped
public class ManagedBeanConsultaVentas implements Serializable{
    @EJB
    private VentaFacadeLocal ventaFacade;
    @EJB
    private FacturaVentaFacadeLocal facturaVentaFacade;
    private List<DetalleFacturaVentaProducto> lista_detalles_factura ;
    private List<DetalleVentaProducto> lista_detalles_venta ;
    private Venta venta;
    private FacturaVenta factura;
private Date fecha_inicial;
private Date fecha_final;
 private List<FacturaVenta> lista_facturas;
  private List<Venta> lista_ventas ;
  private Modelo_facturas_lista lista_modelos;
    public ManagedBeanConsultaVentas() {
        fecha_inicial = new Date();
         fecha_final = new Date();
         lista_facturas= new LinkedList<FacturaVenta>();
         lista_ventas = new LinkedList<Venta>();
         venta = new Venta();
         factura = new FacturaVenta();
         lista_modelos = new Modelo_facturas_lista();
    }

    public Modelo_facturas_lista getLista_modelos() {
        return lista_modelos;
    }

    public void setLista_modelos(Modelo_facturas_lista lista_modelos) {
        this.lista_modelos = lista_modelos;
    }

      public String buscar_ventas(){
         lista_facturas= new LinkedList<FacturaVenta>();
         lista_ventas = new LinkedList<Venta>();
        return "consulta_ventas";
        }


      public void filtrar_listas(){
lista_facturas= new LinkedList<FacturaVenta>();
         lista_ventas = new LinkedList<Venta>();
          try {
              for(Venta v: ventaFacade.findAll()){

                  if((v.getFechaVenta().after(fecha_inicial)&&v.getFechaVenta().before(fecha_final))||v.getFechaVenta().equals(fecha_final)||v.getFechaVenta().equals(fecha_inicial)){

                  if(v.getDetalleVentaProductoList().isEmpty()==false)
           {
           lista_ventas.add(v);
           }



                  }
              }
              for(FacturaVenta f: facturaVentaFacade.findAll()){
              
                       if((f.getFechaVenta().after(fecha_inicial)&&f.getFechaVenta().before(fecha_final))||f.getFechaVenta().equals(fecha_final)||f.getFechaVenta().equals(fecha_inicial)){

                            if(f.getDetalleFacturaVentaProductoList().isEmpty()==false)
           {
            lista_facturas.add(f);
           }
                 
                  }
              }
          } catch (Exception e) {
          }

      }

    public FacturaVenta getFactura() {
        return factura;
    }

    public void setFactura(FacturaVenta factura) {
        this.factura = factura;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<FacturaVenta> getLista_facturas() {
        return lista_facturas;
    }

    public void setLista_facturas(List<FacturaVenta> lista_facturas) {
        this.lista_facturas = lista_facturas;
    }

    public List<Venta> getLista_ventas() {
        return lista_ventas;
    }

    public void setLista_ventas(List<Venta> lista_ventas) {
        this.lista_ventas = lista_ventas;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }

    public Date getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(Date fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public List<DetalleFacturaVentaProducto> ListaProductosFacturas(FacturaVenta item){
         lista_detalles_factura = new LinkedList<DetalleFacturaVentaProducto>();
         FacturaVenta fact= new FacturaVenta();
        try {
            if(item.getIdFacturaVenta() != null)
            {
              fact = facturaVentaFacade.find(item.getIdFacturaVenta());
            lista_detalles_factura = fact.getDetalleFacturaVentaProductoList();

            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista_detalles_factura;
    }
public List<DetalleVentaProducto> ListaProductosVentas(Venta item){
lista_detalles_venta = new LinkedList<DetalleVentaProducto>();
Venta vent = new Venta();
    try {
         if(item.getIdVenta() != null)
            {
               vent = ventaFacade.find(item.getIdVenta());
               lista_detalles_venta= vent.getDetalleVentaProductoList();
            }
        
 
    } catch (Exception e) {
        e.printStackTrace();
    }
return lista_detalles_venta;
}









public List<DetalleVentaProducto> ListaVentas(Venta item){
     if(item.getDetalleVentaProductoList() != null){
   return item.getDetalleVentaProductoList();
    }else
    {
    return null;
    }
}
public List<DetalleFacturaVentaProducto> ListaFacturas(FacturaVenta item){
if(item.getDetalleFacturaVentaProductoList() != null){
      return item.getDetalleFacturaVentaProductoList();
}else{
return null;
}
}

 public int Tamanio_Factura_ventas(FacturaVenta item){
     int cantidad=0;
if(item.getDetalleFacturaVentaProductoList() != null){

    for(DetalleFacturaVentaProducto det:item.getDetalleFacturaVentaProductoList()){
    cantidad = cantidad+det.getCantidad();
    }
      return cantidad;
}else{
return 0;
}
  
    }
public int Tamanio_ventas(Venta item){
    int cantidad=0;
    if(item.getDetalleVentaProductoList() != null){
        for(DetalleVentaProducto det :item.getDetalleVentaProductoList())
        {
        cantidad = cantidad+det.getCantidad();
        }
   return cantidad;
    }else
    {
    return 0;
    }

}



public  class Modelo_facturas_lista extends ListDataModel<FacturaVenta> implements SelectableDataModel<FacturaVenta>{

        public Modelo_facturas_lista() {
        }



   // public Modelo_facturas_list(List<FacturaVenta> data) {
     //   super(data);
   // }

     @Override
    public FacturaVenta getRowData(String rowKey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data

    List<FacturaVenta> formulas = (List<FacturaVenta>)this.getWrappedData();

        // List<OrdenSalidaDetalleAlmacenProductos> ordenes = ordenSalidaDetalleAlmacenProductosFacade.findAll();


        for(FacturaVenta formula : formulas) {
            if(formula.getIdFacturaVenta().toString().equalsIgnoreCase(rowKey))

            {
                return formula;
            }
        }

        return null;
    }

    @Override
    public Object getRowKey(FacturaVenta form) {
        return form.getIdFacturaVenta();
    }



    }

}
