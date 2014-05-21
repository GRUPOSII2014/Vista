/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Persona;
import javax.faces.bean.ManagedBean;
import Ejb.PersonaEjb;
import Entidades.HistoriaClinica;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@RequestScoped
public class PersonaBeans {
    private Persona p = new Persona();
    private HistoriaClinica h = new HistoriaClinica();
    
    @EJB
    private PersonaEjb ejb;
    
    public PersonaBeans(){
       
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

    public PersonaEjb getEjb() {
        return ejb;
    }

    public void setEjb(PersonaEjb ejb) {
        this.ejb = ejb;
    }
        
    public String crearPersona() {
        System.out.println("Creando la Persona" + p.getNumSegSocial());
        return "principal.xhtml";
        //h.setPersona(p);
        //ejb.crearPersona(h);
    }
}
