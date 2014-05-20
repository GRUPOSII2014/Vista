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
    private Long id;
    private Integer numero;
    private Planta planta;
    private Enumerados.tipoHabitacion tipo;
    private Habitacion habitacion;
    
    @EJB
    private HospitalEjb ejb;

    
    public HabitacionBean(){
        habitacion = new Habitacion();
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    public Planta getPlanta(){
        return planta;
    }
    
    public void setPlanta(Planta planta){
        this.planta = planta;
    }
    
    public List<Planta> getPlantas(){
        return ejb.getPlantas();
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
    public Enumerados.tipoHabitacion getTipo(){
        return tipo;
    }
    
    public void setTipo(Enumerados.tipoHabitacion tipo){
        this.tipo = tipo;
    }
    
    public String crearHabitacion(){
        habitacion.setId(id);
        habitacion.setNum(numero);
        habitacion.setTipo(tipo);
        habitacion.setPlanta(planta);
        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.addAll(planta.getHabitaciones());
        habitaciones.add(habitacion);
        planta.setHabitaciones(habitaciones);
        ejb.crearHabitacion(habitacion);
        return null;
    }
}
