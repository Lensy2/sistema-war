/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "mercado", catalog = "sistema", schema = "")
@NamedQueries({
    @NamedQuery(name = "Mercado.findAll", query = "SELECT m FROM Mercado m"),
    @NamedQuery(name = "Mercado.findByIdMercado", query = "SELECT m FROM Mercado m WHERE m.idMercado = :idMercado"),
    @NamedQuery(name = "Mercado.findByNombreMercado", query = "SELECT m FROM Mercado m WHERE m.nombreMercado = :nombreMercado"),
    @NamedQuery(name = "Mercado.findByDescripcion", query = "SELECT m FROM Mercado m WHERE m.descripcion = :descripcion")})
public class Mercado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MERCADO", nullable = false)
    private Integer idMercado;
    @Basic(optional = false)
    @Column(name = "NOMBRE_MERCADO", nullable = false, length = 200)
    private String nombreMercado;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mercado", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;

    public Mercado() {
    }

    public Mercado(Integer idMercado) {
        this.idMercado = idMercado;
    }

    public Mercado(Integer idMercado, String nombreMercado, String descripcion) {
        this.idMercado = idMercado;
        this.nombreMercado = nombreMercado;
        this.descripcion = descripcion;
    }

    public Integer getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(Integer idMercado) {
        this.idMercado = idMercado;
    }

    public String getNombreMercado() {
        return nombreMercado;
    }

    public void setNombreMercado(String nombreMercado) {
        this.nombreMercado = nombreMercado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMercado != null ? idMercado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mercado)) {
            return false;
        }
        Mercado other = (Mercado) object;
        if ((this.idMercado == null && other.idMercado != null) || (this.idMercado != null && !this.idMercado.equals(other.idMercado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Mercado[idMercado=" + idMercado + "]";
    }

}
