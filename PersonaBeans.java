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
    public void crear(ActionEvent actionEvent){
        PersonaEjb.Error error = ejb.compruebaPersona(p);
        FacesContext context = FacesContext.getCurrentInstance();
        if(error.equals(PersonaEjb.Error.DNI_REPETIDO)){
            context.addMessage(null, new FacesMessage("Error", "El dni ya se encuentra en la base de datos"));
        }else if (error.equals(PersonaEjb.Error.CORREO_REPETIDO)){
            context.addMessage(null, new FacesMessage("Error", "El email ya se encuentra en la base de datos"));
        }else if (error.equals(PersonaEjb.Error.NSS_REPETIDO)){
            context.addMessage(null, new FacesMessage("Error", "El numero de seguridad social ya se encuentra en la base de datos"));
        }else{
            context.addMessage(null, new FacesMessage("Exito", "Persona Creada corectamente"));
        }
    }
}
