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
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

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
    private Integer pacOc;
    

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

    public Integer getNss() {
        return nss;
    }

    public void setNss(Integer nss) {
        this.nss = nss;
    }

    public Cama getCama() {
        return cama;
    }

    public String asignarCama() {
        
        ejb.asignarCama(persona, cama);
        return "ingreso.xhtml";
    }

    public void buscaPersona(ActionEvent action) {
        FacesContext context = FacesContext.getCurrentInstance();
        persona = pers.getPersona(nss);
        if (persona == null) {
            context.addMessage(null, new FacesMessage("Error", "No se encuentra la persona en la base de datos"));
        } else {
            if (persona.getCama() != null) {
                context.addMessage(null, new FacesMessage("Error","Esa persona ya tiene asignada una cama"));
            } else {
                cama = ejb.primeraLibre(persona);
                if (cama == null)
                    context.addMessage(null, new FacesMessage("Error","No hay cama libre"));
            }
        }
    }
    
    public String liberarCama (){
        if(pacOc!=null)
        ejb.liberarCama (pacOc);
        return "ingreso.xhtml";
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public List<Cama> camasOcupadas(){
       return ejb.todasCamasOcupadas();
    }

    public Integer getPacOcuc() {
        return pacOc;
    }

    public void setPacOcuc(Integer camaOcu) {
        this.pacOc = camaOcu;
    }

    public IngresoEjb getEjb() {
        return ejb;
    }

    public void setEjb(IngresoEjb ejb) {
        this.ejb = ejb;
    }

    public PersonaEjb getPers() {
        return pers;
    }

    public void setPers(PersonaEjb pers) {
        this.pers = pers;
    }


    

}
