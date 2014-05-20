/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Habitacion;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@ViewScoped
public class crearCama {
   private Entidades.Cama c;
   private Ejb.crearCamaEjb ejb;
    /**
     * @return the c
     */
    public Entidades.Cama getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Entidades.Cama c) {
        this.c = c;
    }
    
    public String crearCama (){
        ejb.comprobarCama(c);
        return null;
    }
    
    public List <Habitacion> todasHabitaciones(){
        return ejb.todasHabitaciones();
     }
}
