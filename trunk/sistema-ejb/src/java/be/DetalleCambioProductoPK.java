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
public class DetalleCambioProductoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_CAMBIO", nullable = false)
    private int idCambio;
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO_CAMBIO", nullable = false)
    private int idProductoCambio;
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO_CAMBIADA", nullable = false)
    private int idProductoCambiada;

    public DetalleCambioProductoPK() {
    }

    public DetalleCambioProductoPK(int idCambio, int idProductoCambio, int idProductoCambiada) {
        this.idCambio = idCambio;
        this.idProductoCambio = idProductoCambio;
        this.idProductoCambiada = idProductoCambiada;
    }

    public int getIdCambio() {
        return idCambio;
    }

    public void setIdCambio(int idCambio) {
        this.idCambio = idCambio;
    }

    public int getIdProductoCambio() {
        return idProductoCambio;
    }

    public void setIdProductoCambio(int idProductoCambio) {
        this.idProductoCambio = idProductoCambio;
    }

    public int getIdProductoCambiada() {
        return idProductoCambiada;
    }

    public void setIdProductoCambiada(int idProductoCambiada) {
        this.idProductoCambiada = idProductoCambiada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCambio;
        hash += (int) idProductoCambio;
        hash += (int) idProductoCambiada;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCambioProductoPK)) {
            return false;
        }
        DetalleCambioProductoPK other = (DetalleCambioProductoPK) object;
        if (this.idCambio != other.idCambio) {
            return false;
        }
        if (this.idProductoCambio != other.idProductoCambio) {
            return false;
        }
        if (this.idProductoCambiada != other.idProductoCambiada) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleCambioProductoPK[idCambio=" + idCambio + ", idProductoCambio=" + idProductoCambio + ", idProductoCambiada=" + idProductoCambiada + "]";
    }

}
