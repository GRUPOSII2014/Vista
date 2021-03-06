/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.crearCamaEjb;
import Entidades.Cama;
import Entidades.Enumerados;
import Entidades.Habitacion;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@ViewScoped
public class CrearCama {
   private Cama c=new Cama();
   private Integer n;
   private Long habi;
   @EJB
   private Ejb.crearCamaEjb ejb;
   
   
   public CrearCama(){
   }
    /**
     * @return the c
     */
    public Entidades.Cama getC() {
        return c;
    }

    public Long getHabi() {
        return habi;
    }

    public void setHabi(Long habi) {
        this.habi = habi;
    }
    
    /**
     * @param c the c to set
     */
    public void setC(Entidades.Cama c) {
        this.c = c;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }
    
    public String crearCama (){
        for(Habitacion h : todasHabitaciones()){
            if(h.getId().equals(habi)){
                c.setHabitacion(h);
                break;
            }
        }
        for (int i = 0 ; i<n;i++){
            Cama c3 = new Cama();
            c3.setEstado(Enumerados.estadoCama.LIBRE);
            c3.setHabitacion(c.getHabitacion());
            c3.setNum(1);
            ejb.crearCama(c3);
        }

        c = new Cama();
        return "principal.xhtml";
    }
    
    public List <Habitacion> todasHabitaciones(){
        return ejb.todasHabitaciones();
     }

    public crearCamaEjb getEjb() {
        return ejb;
    }

    public void setEjb(crearCamaEjb ejb) {
        this.ejb = ejb;
    }
    
    
}
