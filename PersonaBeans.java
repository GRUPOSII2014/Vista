/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.PersonaEjb;
import Entidades.HistoriaClinica;
import Entidades.Persona;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Emilio
 */
@ManagedBean
@RequestScoped
public class PersonaBeans {

    Persona p = new Persona();
    HistoriaClinica h = new HistoriaClinica();
    
    @EJB
    private PersonaEjb persona;
    
    /**
     * Creates a new instance of PersonaBeans
     */
    public PersonaBeans() {
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public HistoriaClinica getH() {
        return h;
    }

    public void setH(HistoriaClinica h) {
        this.h = h;
    }
    
    public String crearPersona() {
        h.setPersona(p);
        persona.crearPersona(h);
        return null;
    }
}
