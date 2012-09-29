/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.OrdenSalidaDetalleAlmacenProductosFacadeLocal;
import be.EstadoOrdenSalidaDetalleAlmacenProductos;
import be.OrdenSalidaDetalleAlmacenProductos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
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
@ManagedBean
@SessionScoped
public class ManagedBeanOrdenSalidaAlmacen implements Serializable{
    @EJB
    private OrdenSalidaDetalleAlmacenProductosFacadeLocal ordenSalidaDetalleAlmacenProductosFacade;
    private OrdenSalidaDetalleAlmacenProductos orden_salida = new OrdenSalidaDetalleAlmacenProductos();
    private List<OrdenSalidaDetalleAlmacenProductos> lista;
private Date fecha;
    public ManagedBeanOrdenSalidaAlmacen() {
        orden_salida = new OrdenSalidaDetalleAlmacenProductos();
        orden_salida.setEstadoOrdenSalidaDetalleAlmacenProductos(new EstadoOrdenSalidaDetalleAlmacenProductos(1));
        lista = new LinkedList<OrdenSalidaDetalleAlmacenProductos>();
        fecha = new Date();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    public void filtrar_lista(){
    lista.clear();
        try {
            for(OrdenSalidaDetalleAlmacenProductos o : ordenSalidaDetalleAlmacenProductosFacade.findAll()){
               if(o.getFechaRegistro().equals(fecha)){
               lista.add(o);
               }

            }
        } catch (Exception e) {
        }
    }
    public List<OrdenSalidaDetalleAlmacenProductos> getLista() {

        return lista;
    }

    public void setLista(List<OrdenSalidaDetalleAlmacenProductos> lista) {
        this.lista = lista;
    }

    public OrdenSalidaDetalleAlmacenProductos getOrden_salida() {
        return orden_salida;
    }

    public void setOrden_salida(OrdenSalidaDetalleAlmacenProductos orden_salida) {
        this.orden_salida = orden_salida;
    }


 public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Se Seleccionó un Item.", "Procesando Información");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

 public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Producto No seleccionado", "No se pueden Procesar Datos");

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public void onRowDblselect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        Flash flash = context.getExternalContext().getFlash();
        flash.put("selectedCar", (OrdenSalidaDetalleAlmacenProductos) event.getObject());

        handler.performNavigation("carDetail");
    }



     public void destroyWorld(ActionEvent actionEvent){

        try {
             this.editar2();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acción ejecutada con éxito",  "Se ejecutó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (Exception e) {
   e.printStackTrace();

   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error en la Aplicación",  "error en la aplicación");
        FacesContext.getCurrentInstance().addMessage(null, message);

        }



    }

    public void editar2()
    {
        try {
            ordenSalidaDetalleAlmacenProductosFacade.edit(orden_salida);
        } catch (Exception e) {
        e.printStackTrace();
        }

}


    public String Ordenes(){
        orden_salida = new OrdenSalidaDetalleAlmacenProductos();
    return "ordenes_salida";
    }

    public String Volver_OrdenSalida(){
return "index?faces-redirect=true";
     }
}
