/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import sun.security.util.BigInt;
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
public class ManagedBeanCodificacion implements Serializable{
private String us="root";
private String pas="sistema";
    private int bloque_boleta;
    private int numero_boleta;
    private int bloque_factura;
    private int numero_factura;

    public ManagedBeanCodificacion() {
        bloque_boleta=1;
        numero_boleta=1;
        bloque_factura=1;
        numero_factura=1;
    }

    public String nueva(){
    return "nueva_codificacion_inicial";
    }


    public String resetear(){
    return "resetar_base_datos";
    }

    public int getBloque_boleta() {
        return bloque_boleta;
    }

    public void setBloque_boleta(int bloque_boleta) {
        this.bloque_boleta = bloque_boleta;
    }

    public int getBloque_factura() {
        return bloque_factura;
    }

    public void setBloque_factura(int bloque_factura) {
        this.bloque_factura = bloque_factura;
    }

    public int getNumero_boleta() {
        return numero_boleta;
    }

    public void setNumero_boleta(int numero_boleta) {
        this.numero_boleta = numero_boleta;
    }

    public int getNumero_factura() {
        return numero_factura;
    }

    public void setNumero_factura(int numero_factura) {
        this.numero_factura = numero_factura;
    }

    public String actualizar_codigos(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema", us, pas);
 Statement st = c.createStatement();
 st.executeUpdate("ALTER TABLE VENTA AUTO_INCREMENT="+this.retorna_codigo(bloque_boleta,numero_boleta));
 st.executeUpdate("ALTER TABLE FACTURA_VENTA AUTO_INCREMENT="+this.retorna_codigo(bloque_factura, numero_factura));

        } catch (Exception e) {
        }
return "index";
    }

    public void resetarBD(ActionEvent actionEvent){

 ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();



                  String ruta_script=    extContext.getRealPath("//BASEDATOS//script_sistema.sql");
                  String ruta_inserts=    extContext.getRealPath("//BASEDATOS//inserts_sistema.sql");
   

         try {
         Class.forName("com.mysql.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema", us, pas);
 Statement st = c.createStatement();
 st.executeUpdate(" call RESETEAR_SISTEMA();");
  System.out.println(" SE EJECUTO BIEN RESETEAR SISTEMA");
        }
         catch (SQLException es) {

            System.out.println("ERROR SQL");
            es.printStackTrace();
        }

         catch (Exception e) {

            System.out.println("ERROR EN RESETEAR");
            e.printStackTrace();
        }










        String executeCmd = "sh "+extContext.getRealPath("//BASEDATOS//resetea.sh")+" "+us+" "+pas+" "+ruta_script;

        System.out.println(" Este es el comando ejecutado "+executeCmd);
        Process runtimeProcess;
        try {

            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("SCRIPT EJECUTADO CORRECTAMENTE");

            } else {
                System.out.println("ERROR EN LOS SCRIPTS");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }






        executeCmd = "sh "+extContext.getRealPath("//BASEDATOS//resetea.sh")+" "+us+" "+pas+" "+ruta_inserts;

        System.out.println(" Este es el comando ejecutado "+executeCmd);

        try {

            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                System.out.println("LOS INSERTS SE EJECUTARON CORRECTAMENTE");

            } else {
                System.out.println("ERROR EN LOS INSERTS");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "SISTEMA RESETEADO",  "Se ejecutó con éxito");
        FacesContext.getCurrentInstance().addMessage(null, message);




    }
    public Integer retorna_codigo(int bloque_ , int numero_){
       Integer resultado=0;
        try {


        resultado = ((bloque_-1)*100000)+numero_;
        } catch (Exception e) {
        }
    return resultado;
    }

}
