/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Persona;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import Ejb.PersonaEjb;

/**
 *
 * @author Angel
 */
@ManagedBean
@ViewScoped
public class PersonaBeans {
    private Persona p=new Persona();
    private PersonaEjb ejb;
    public PersonaBeans(){
       
    }

    public Persona getP() {
        return p;
    }
    
    public void setP(Persona p) {
        this.p = p;
    }
    public String crear(ActionEvent actionEvent){
        ejb.crearPersona(p);
        FacesContext context = FacesContext.getCurrentInstance();
        return null;
       
    }
}
