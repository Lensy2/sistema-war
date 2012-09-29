/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.ContratoFumigacionFacadeLocal;
import bc.ReporteDesratizacionFacadeLocal;
import bc.ReporteFumigacionFacadeLocal;
import be.ContratoFumigacion;
import be.ReporteDesratizacion;
import be.ReporteFumigacion;
import be.Venta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ActionEvent;
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
public class ManagedBeanContratoFumigacion implements  Serializable{
    @EJB
    private ReporteFumigacionFacadeLocal reporteFumigacionFacade;
    @EJB
    private ReporteDesratizacionFacadeLocal reporteDesratizacionFacade;
    @EJB
  private   ContratoFumigacionFacadeLocal contratoFumigacionFacade;

private ContratoFumigacion contrato;
private List<ContratoFumigacion> lista ;

private Date fecha_ ;

private ReporteFumigacion fumigacion;
private ReporteDesratizacion desratizacion;
    public ManagedBeanContratoFumigacion() {
        contrato = new ContratoFumigacion();
        lista = new LinkedList<ContratoFumigacion>();
        fumigacion = new ReporteFumigacion();
        desratizacion = new ReporteDesratizacion();
    }

    public ReporteDesratizacion getDesratizacion() {
        return desratizacion;
    }

    public Date getFecha_() {
        return fecha_;
    }

    public void setFecha_(Date fecha_) {
        this.fecha_ = fecha_;
    }

    public void setDesratizacion(ReporteDesratizacion desratizacion) {
        this.desratizacion = desratizacion;
    }

    public ReporteFumigacion getFumigacion() {
        return fumigacion;
    }

    public void setFumigacion(ReporteFumigacion fumigacion) {
        this.fumigacion = fumigacion;
    }

    public ContratoFumigacion getContrato() {
        return contrato;
    }

    public void setContrato(ContratoFumigacion contrato) {
        this.contrato = contrato;
    }

    public List<ContratoFumigacion> getLista() {
        try {
          lista =  contratoFumigacionFacade.findAll();
        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<ContratoFumigacion> lista) {
        this.lista = lista;
    }


    public String nuevo(Venta v){
    contrato = new ContratoFumigacion();
 fecha_ = new Date();
   // contrato.setFechaHoraFumigacion(Fecha);

        contrato.setVenta(v);
return "nuevo_contrato";
    }

public String nuevo_reporte_fumigacion(){
fumigacion = new ReporteFumigacion();
fumigacion.setContratoFumigacion(contrato);
fumigacion.setFecha(new Date());
fumigacion.setDescripcionCliente("");

return "nuevo_reporte_fumigacion";

}

public String crear_rep_fumigacion(){
    try {
        reporteFumigacionFacade.create(fumigacion);
    } catch (Exception e) {
    }
    return "contratos?faces-redirect=true";

}

public String crear_rep_desrat(){
    try {
        reporteDesratizacionFacade.create(desratizacion);
    } catch (Exception e) {
    }
    return "contratos?faces-redirect=true";
}
public String nuevo_reporte_desratizacion(){
desratizacion = new ReporteDesratizacion();
desratizacion.setContratoFumigacion(contrato);
desratizacion.setFecha(new Date());
//desratizacion.setDescripcionCliente("");
return "nuevo_reporte_desratizacion";
}

    public String crear(){
        try {
    //     contrato.setFechaHoraFumigacion(fecha_);
            contrato.setCuenta(new BigDecimal(0));
            contrato.setFechaVenta(new Date());
            contrato.setFechaVentaEmision(new Date());
            contrato.setPlaga(contrato.getVenta().getObservaciones());
            contrato.setSaldo(BigDecimal.ZERO);
            contrato.setTotalServicio(contrato.getVenta().getTotalVenta());
            contratoFumigacionFacade.create(contrato);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "contratos?faces-redirect=true";
        
    }

   


    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Contrato Seleccionado",this.Formato((ContratoFumigacion) event.getObject()));

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


 public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Servicio No seleccionado", this.Formato((ContratoFumigacion) event.getObject()));

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }



    public void onRowDblselect(SelectEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) context.getApplication().getNavigationHandler();
        Flash flash = context.getExternalContext().getFlash();
        flash.put("selectedCar", (Venta) event.getObject());

        handler.performNavigation("carDetail");
    }

  public void destroyWorld(ActionEvent actionEvent){

        try {
           //  this.editar2();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Acción ejecutada con éxito",  "Se ejecutó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (Exception e) {
   e.printStackTrace();

   FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error en la Aplicación",  "Se ejecuto con exito");
        FacesContext.getCurrentInstance().addMessage(null, message);

        }



    }

  public String Formato(ContratoFumigacion v){
if(v.getIdContratoFumigacion()==null)
{
v = new ContratoFumigacion();
}

    String numero ="0000000";

numero = numero.concat(String.valueOf(v.getIdContratoFumigacion()));
numero = numero.substring(numero.length()-7);

return  numero;

}
}
