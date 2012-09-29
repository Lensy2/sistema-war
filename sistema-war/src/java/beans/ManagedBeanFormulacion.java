/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.DetalleFormulacionInsumosFacadeLocal;
import bc.FormulacionFacadeLocal;
import be.DetalleFormulacionInsumos;
import be.DetalleFormulacionInsumosPK;
import be.Formulacion;
import be.MateriaPrima;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

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
public class ManagedBeanFormulacion implements Serializable{
    @EJB
    private DetalleFormulacionInsumosFacadeLocal detalleFormulacionInsumosFacade;
   @EJB
    private  FormulacionFacadeLocal formulacionFacade;



    private List<SelectItem> formulacionesItems = new LinkedList<SelectItem>();
private HashMap<Integer, Formulacion> myformulaciones = new HashMap<Integer,Formulacion>();

    private Formulacion formulacion;
 private List<Formulacion> lista;
 private DetalleFormulacionInsumos detalle;
private List<DetalleFormulacionInsumos> lista_detalles;
private MateriaPrima materia_prima;
private BigDecimal proporcion;

    public ManagedBeanFormulacion() {
        formulacion = new Formulacion();
        lista = new LinkedList<Formulacion>();
        detalle = new DetalleFormulacionInsumos();
        detalle.setMateriaPrima(new MateriaPrima());
        lista_detalles = new LinkedList<DetalleFormulacionInsumos>();
        materia_prima = new MateriaPrima();
        proporcion = new BigDecimal(0);
    }

    public BigDecimal getProporcion() {
        return proporcion;
    }

    public void setProporcion(BigDecimal proporcion) {
        this.proporcion = proporcion;
    }


    public MateriaPrima getMateria_prima() {
        return materia_prima;
    }

    public void setMateria_prima(MateriaPrima materia_prima) {
        this.materia_prima = materia_prima;
    }


    public Formulacion getFormulacion() {
        return formulacion;
    }

    public void setFormulacion(Formulacion formulacion) {
        this.formulacion = formulacion;
    }

    public List<Formulacion> getLista() {
        lista.clear();
        try {
           for(Formulacion f :formulacionFacade.findAll())
           {
           if(f.getDetalleFormulacionInsumosList().isEmpty()==false)
           {
           lista.add(f);
           }
           }

        } catch (Exception e) {
        }
        return lista;
    }

    public void setLista(List<Formulacion> lista) {
        this.lista = lista;
    }




    public String Nueva(){
formulacion = new Formulacion();
formulacion.setFechaRegistro(new Date());
detalle = new DetalleFormulacionInsumos();
lista.clear();
lista_detalles.clear();
return "nueva_formula";
 }

     public String Edicion(){
       //   detalle = formulacion.getDetalleFormulacionInsumosList().get(0).getMateriaPrima();
     detalle = new DetalleFormulacionInsumos();
     detalle.setMateriaPrima(new MateriaPrima(1));
         return "editar_formula";
 }

     public void AgregarDetalleMateriaPrima(){
      if(formulacion.getIdFormulacion()==null)
               {
                     formulacion.setDetalleFormulacionInsumosList(new  LinkedList<DetalleFormulacionInsumos>());
      formulacionFacade.create(formulacion);

      }
      
detalle.setFormulacion(formulacion);
detalle.setDetalleFormulacionInsumosPK(new DetalleFormulacionInsumosPK(detalle.getFormulacion().getIdFormulacion(), detalle.getMateriaPrima().getIdMateriaPrima()));
int id_ = detalle.getMateriaPrima().getIdMateriaPrima();
formulacion.getDetalleFormulacionInsumosList().add(detalle);
detalle = new DetalleFormulacionInsumos();
detalle.setMateriaPrima(new MateriaPrima(id_));
  }

 public String crear(){
     try
     {
formulacionFacade.edit(formulacion);
     } catch (Exception e) {
    e.printStackTrace();
     }

return "formulas?faces-redirect=true";

 }

 public String edita(){
     try {
   //  formulacion.getDetalleFormulacionInsumosList().clear();
 //    formulacion.setDetalleFormulacionInsumosList(lista_detalles);
      formulacionFacade.edit(formulacion);
     } catch (Exception e) {
    e.printStackTrace();
     }

return "formulas?faces-redirect=true";

 }

  public String Volver_Formulacion(){
return "index?faces-redirect=true";
     }

    public DetalleFormulacionInsumos getDetalle() {
        return detalle;
    }

    public void setDetalle(DetalleFormulacionInsumos detalle) {
        this.detalle = detalle;
    }

  

    public List<DetalleFormulacionInsumos> getLista_detalles() {
        return lista_detalles;
    }

     public List<DetalleFormulacionInsumos> getLista_detalles_Editar() {
     lista_detalles = formulacion.getDetalleFormulacionInsumosList();
         return lista_detalles;
    }


    public void setLista_detalles(List<DetalleFormulacionInsumos> lista_detalles) {
        this.lista_detalles = lista_detalles;
    }

    public List<SelectItem> getFormulacionesItems() {


          lista = new ArrayList<Formulacion>();
        formulacionesItems = new LinkedList<SelectItem>();
        lista = formulacionFacade.findAll();
        for(Formulacion p: lista){
        myformulaciones.put(p.getIdFormulacion(), p);
           formulacionesItems.add(new SelectItem(p, p.getProducto().getNombreProducto()));
        }
        return formulacionesItems;
    }

    public void setFormulacionesItems(List<SelectItem> formulacionesItems) {
        this.formulacionesItems = formulacionesItems;
    }

    public HashMap<Integer, Formulacion> getMyformulaciones() {
        return myformulaciones;
    }

    public void setMyformulaciones(HashMap<Integer, Formulacion> myformulaciones) {
        this.myformulaciones = myformulaciones;
    }


    public Formulacion getFormulacion(Integer id) {
           return (Formulacion) myformulaciones.get(id);

    }

    public List<Formulacion> completar_filtrado_Formulacion(String nombre) {
  lista = new LinkedList<Formulacion>();
  for(Formulacion p : formulacionFacade.findAll()){
      myformulaciones.put(p.getIdFormulacion(), p);
    if (p.getProducto().getNombreProducto().toUpperCase().indexOf(nombre.toUpperCase())!=-1){
    lista.add(p);

    }
    }
       return lista;
    }



public void EliminarLista(){
    try {
        // lista_detalles= venta_total_detalles.subtract(detalle_venta_Producto.getSubTotal());
        formulacion.getDetalleFormulacionInsumosList().remove(detalle);
        detalleFormulacionInsumosFacade.remove(detalle);
    } catch (Exception e) {
        e.printStackTrace();
    }

}

    
}
