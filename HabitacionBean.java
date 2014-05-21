/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.HospitalEjb;
import Entidades.Enumerados;
import Entidades.Habitacion;
import Entidades.Hospital;
import Entidades.Planta;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@ViewScoped
public class HabitacionBean {
    private Long planta;
    private Habitacion habitacion;
    private List<Planta> plantas ;
    
    @EJB
    private HospitalEjb ejb;

    
    public HabitacionBean(){
        habitacion = new Habitacion();
    }

    public Long getPlanta() {
        return planta;
    }

    public void setPlanta(Long planta) {
        this.planta = planta;
    }



    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public HospitalEjb getEjb() {
        return ejb;
    }

    public void setEjb(HospitalEjb ejb) {
        this.ejb = ejb;
    }

    public void setPlantas(List<Planta> plantas) {
        this.plantas = plantas;
    }
    
    
    public List<Planta> getPlantas(){
        plantas = ejb.getPlantas();
        return plantas;
    }

    
    public String crearHabitacion(){
        for(Planta p : plantas){
            if(p.getId().equals(planta)){
                habitacion.setPlanta(p);
                break;
            }
        }
        ejb.crearHabitacion(habitacion);
        plantas = new ArrayList<>();
        habitacion = new Habitacion();
        return "null";
    }
}
