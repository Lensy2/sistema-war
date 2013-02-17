/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

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
@Embeddable
public class DetalleOrdenCompraProductoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_ORDEN_COMPRA", nullable = false)
    private int idOrdenCompra;
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO", nullable = false)
    private int idProducto;

    public DetalleOrdenCompraProductoPK() {
    }

    public DetalleOrdenCompraProductoPK(int idOrdenCompra, int idProducto) {
        this.idOrdenCompra = idOrdenCompra;
        this.idProducto = idProducto;
    }

    public int getIdOrdenCompra() {
        return idOrdenCompra;
    }

    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrdenCompra;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleOrdenCompraProductoPK)) {
            return false;
        }
        DetalleOrdenCompraProductoPK other = (DetalleOrdenCompraProductoPK) object;
        if (this.idOrdenCompra != other.idOrdenCompra) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleOrdenCompraProductoPK[idOrdenCompra=" + idOrdenCompra + ", idProducto=" + idProducto + "]";
    }

}
