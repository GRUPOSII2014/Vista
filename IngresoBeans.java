/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.IngresoEjb;
import Ejb.PersonaEjb;
import Entidades.Cama;
import Entidades.Persona;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@ViewScoped
public class IngresoBeans {

    private Cama cama;
    private Persona persona;
    private Integer nss;
    
    @EJB
    private IngresoEjb ejb;
    @EJB
    private PersonaEjb pers;

    public IngresoBeans() {
        /*ArrayList<Cama> camas = new ArrayList<>();
        Habitacion h = new Habitacion();
        Planta p = new Planta();
        cama = new Cama();
        cama.setId(1L);
        //cama.setHabitacion(h);
        cama.setEstado(Enumerados.estadoCama.LIBRE);
        camas.add(cama);
        //h.setCamas(camas);
        h.setId(1L);
        h.setTipo(Enumerados.tipoHabitacion.UVI);
        h.setPlanta(p);
        p.setId(1L);
        p.setNombre("una planta");*/
    }
    
    public String inic(){
        cama = ejb.primeraLibre();
        return "inic";
    }
    
    public Integer getNss(){
        return nss;
    }
    
    public void setNss(Integer nss){
        this.nss = nss;
    }

    public Cama getCama() {
        return cama;
    }
    
    public String asignarCama(){
        ejb.asignarCama(persona, cama);
        return "principal.xhtml";
    }
    
    public String buscaPersona(){
        persona = pers.getPersona(nss);
        return "null";
        
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
