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
public class StockProductoTiendaOrigenPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO", nullable = false)
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "ID_TIENDA_ORIGEN", nullable = false)
    private int idTiendaOrigen;

    public StockProductoTiendaOrigenPK() {
    }

    public StockProductoTiendaOrigenPK(int idProducto, int idTiendaOrigen) {
        this.idProducto = idProducto;
        this.idTiendaOrigen = idTiendaOrigen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTiendaOrigen() {
        return idTiendaOrigen;
    }

    public void setIdTiendaOrigen(int idTiendaOrigen) {
        this.idTiendaOrigen = idTiendaOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idTiendaOrigen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockProductoTiendaOrigenPK)) {
            return false;
        }
        StockProductoTiendaOrigenPK other = (StockProductoTiendaOrigenPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idTiendaOrigen != other.idTiendaOrigen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.StockProductoTiendaOrigenPK[idProducto=" + idProducto + ", idTiendaOrigen=" + idTiendaOrigen + "]";
    }

}
