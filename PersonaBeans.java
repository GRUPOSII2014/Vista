/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.CrearDepartamentoEjb;
import Ejb.PersonaEjb;
import Entidades.Admin;
import Entidades.Departamento;
import Entidades.Enfermero;
import Entidades.Enumerados;
import Entidades.HistoriaClinica;
import Entidades.Medico;
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
    private Enfermero e = new Enfermero();
    private Medico m = new Medico();
    private Admin a = new Admin();
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

    public Enfermero getE() {
        return e;
    }

    public void setE(Enfermero e) {
        this.e = e;
    }

    public Medico getM() {
        return m;
    }

    public void setM(Medico m) {
        this.m = m;
    }

    public Admin getA() {
        return a;
    }

    public void setA(Admin a) {
        this.a = a;
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
        
        t.setSalario(new Float(2.0));
        t.setTipo(Enumerados.tipoTrabajador.ADMINISTRATIVO);
        
        h.setPersona(t);
        try {
            persona.crearPersona(h);
        } catch(EJBException ex) {
            context.addMessage(null, new FacesMessage("Error", "Violada la restricción de clave unica en NSS, DNI o Email"));
        }
        
        context.addMessage(null, new FacesMessage("Exito", "El Administrativo ha sido creado"));
    }
    
    public void crearEnfermero(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        e.setTipo(Enumerados.tipoTrabajador.ENFERMERO);
        
        h.setPersona(e);
        try {
            persona.crearPersona(h);
        } catch(EJBException ex) {
            context.addMessage(null, new FacesMessage("Error", "Violada la restricción de clave unica en NSS, DNI o Email"));
        }
        
        context.addMessage(null, new FacesMessage("Exito", "El Enfermero ha sido creado"));
    }
    
    public void crearMedico(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        
        m.setSalario(new Float(2.0));
        m.setTipo(Enumerados.tipoTrabajador.MEDICO);
       
        m.setPrecioHora(new Float(2.0));
        h.setPersona(m);
        try {
            persona.crearPersona(h);
        } catch(EJBException ex) {
            context.addMessage(null, new FacesMessage("Error", "Violada la restricción de clave unica en NSS, DNI o Email"));
        }
        
        context.addMessage(null, new FacesMessage("Exito", "El Médico ha sido creado"));
    }
    
    public void crearAdministrador(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();        

        a.setTipo(Enumerados.tipoTrabajador.ADMIN);
        
        h.setPersona(a);
        try {
            persona.crearPersona(h);
        } catch(EJBException ex) {
            context.addMessage(null, new FacesMessage("Error", "Violada la restricción de clave unica en NSS, DNI o Email"));
        }
        
        context.addMessage(null, new FacesMessage("Exito", "El Administrador ha sido creado"));
    }
    
    public List<Departamento> todosDep() {
        return depart.todosDepartamentos();
    }
    
}
