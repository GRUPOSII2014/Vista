/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.CrearDepartamentoEjb;
import Ejb.PersonaEjb;
import Entidades.Departamento;
import Entidades.HistoriaClinica;
import Entidades.Persona;
import Entidades.TrabajadoresHospital;
import java.util.List;
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

    private Persona p = new Persona();
    private TrabajadoresHospital t = new TrabajadoresHospital();
    private HistoriaClinica h = new HistoriaClinica();
    private String dep;
    
    @EJB
    private PersonaEjb persona;
    
    @EJB
    private CrearDepartamentoEjb depart;
    
    /**
     * Creates a new instance of PersonaBeans
     */
    public PersonaBeans() {
    }

    public Persona getP() {
        return p;
    }

    public CrearDepartamentoEjb getDepart() {
        return depart;
    }

    public void setDepart(CrearDepartamentoEjb depart) {
        this.depart = depart;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
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

    public TrabajadoresHospital getT() {
        return t;
    }

    public void setT(TrabajadoresHospital t) {
        this.t = t;
    }

    public PersonaEjb getPersona() {
        return persona;
    }

    public void setPersona(PersonaEjb persona) {
        this.persona = persona;
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
    
    public void crearAdministrativo(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        h.setPersona(t);
        try {
            persona.crearPersona(h);
        } catch(EJBException ex) {
            context.addMessage(null, new FacesMessage("Error", "Violada la restricción de clave unica en NSS, DNI o Email"));
        }
        
        context.addMessage(null, new FacesMessage("Exito", "La persona ha sido creada"));
    }
    
    public List<Departamento> todosDep() {
        return depart.todosDepartamentos();
    }
    
}
