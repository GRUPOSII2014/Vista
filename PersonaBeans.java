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
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
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
    
    public void crearPersona(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        h.setPersona(p);
        try {
            persona.crearPersona(h);
        } catch(EJBException ex) {
            context.addMessage(null, new FacesMessage("Error", "Violada la restricción de clave unica en NSS, DNI o Email"));
        }
        
        context.addMessage(null, new FacesMessage("Exito", "La persona ha sido creada"));
    }
}
