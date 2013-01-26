
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.PrecioProductoFacadeLocal;
import bc.ProductoFacadeLocal;
import be.ColorProducto;
import be.EstadoProducto;
import be.MaterialProducto;
import be.ModeloProducto;
import be.PrecioProducto;
import be.Producto;
import be.TallaProducto;
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
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */




@ManagedBean
@SessionScoped
public class ManagedBeanProducto implements Serializable {
    @EJB
    private ProductoFacadeLocal ProductoFacade;
    @EJB
    private  PrecioProductoFacadeLocal precioProductoFacade ;
    private Producto Producto;
    private List<SelectItem> ProductosItems = new LinkedList<SelectItem>();
    private HashMap<Integer, Producto> myProductos = new HashMap<Integer,Producto>();
private List<Producto> lista ;

    public ManagedBeanProducto() {
   Producto = new Producto();
   lista= new LinkedList<Producto>();
    }

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

     public Producto getProducto(Integer id) {
    return (Producto) myProductos.get(id);
     }

    public HashMap<Integer, Producto> getMyProductos() {
        return myProductos;
    }

    public void setMyProductos(HashMap<Integer, Producto> myProductos) {
        this.myProductos = myProductos;
    }

    public List<SelectItem> getProductosItems() {
          lista = new ArrayList<Producto>();
        ProductosItems = new LinkedList<SelectItem>();
        lista = ProductoFacade.findAll();
        for(Producto p: lista){
        myProductos.put(p.getIdProducto(), p);
            ProductosItems.add(new SelectItem(p, p.getNombreProducto()));
        }

        return ProductosItems;

    }

    public void setProductosItems(List<SelectItem> ProductosItems) {
        this.ProductosItems = ProductosItems;
    }

    public List<Producto> getLista_Productos(){
        try {

            lista = ProductoFacade.findAll();

        } catch (Exception e) {
        e.printStackTrace();
        }
        return lista;
    }

    public String Nueva(){
    Producto = new Producto();
Producto.setFechaIngreso(new Date());
    return "nuevo_producto";
    }

     public String edicion(){
return "editar_producto";
    }

    public String Crear_Producto(){
    Producto.setEstadoProducto(new EstadoProducto(1));
    Producto.setFechaIngreso(new Date());
    Producto.setModeloProducto(new ModeloProducto(1));
    Producto.setTallaProducto(new TallaProducto(1));
    Producto.setColorProducto(new ColorProducto(1));
    Producto.setMaterialProducto(new MaterialProducto(1));
        try {
            ProductoFacade.create(Producto);
/*Agregado aqui*/
            precioProductoFacade.create(new PrecioProducto(Producto.getIdProducto(), new Date(), BigDecimal.ZERO));

        } catch (Exception e) {
        e.printStackTrace();
        }
    return "productos?faces-redirect=true";
    }

    public String editar_producto(){
        try {
            ProductoFacade.edit(Producto);
        } catch (Exception e) {
        e.printStackTrace();
        }
    return "productos?faces-redirect=true";
    }

    public String Volver_Producto(){
return "index?faces-redirect=true";
     }


 public List<Producto> completar_filtrado_Producto(String nombre) {
  lista = new LinkedList<Producto>();
  for(Producto p : ProductoFacade.findAll()){
      myProductos.put(p.getIdProducto(), p);
    if (p.getNombreProducto().toUpperCase().indexOf(nombre.toUpperCase())!=-1){
    lista.add(p);

    }
    }
       return lista;
    }

}
