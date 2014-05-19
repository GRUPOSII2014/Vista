/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.PersonaEjb;
import Entidades.Persona;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@Dependent
public class CambiarClaveBeans {

    private String actual, nueva, nueva2;
    @EJB
    private PersonaEjb ejb;

    @ManagedProperty(value = "#{loginController}")
    private LoginController login;

    /**
     * Creates a new instance of CambiarClave
     */
    public CambiarClaveBeans() {
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getNueva() {
        return nueva;
    }

    public void setNueva(String nueva) {
        this.nueva = nueva;
    }

    public String getNueva2() {
        return nueva2;
    }

    public void setNueva2(String nueva2) {
        this.nueva2 = nueva2;
    }

    public void doCambiarClave(ActionEvent actionEvent) {
        Persona p = ejb.getPersona(login.getBuscado());
        FacesContext context = FacesContext.getCurrentInstance();
        if(p.getPassword().equals(actual)){
            if (nueva.equalsIgnoreCase(nueva2)) {
                context.addMessage(null, new FacesMessage("Exito", "Se ha cambiado la clave correctamente"));
            } else {
                context.addMessage(null, new FacesMessage("Error", "Las contraseñas no coinciden"));
            }
        }else{
            context.addMessage(null, new FacesMessage("Error", "Contraseña de usuario incorrecta"));
        }
    }

    public PersonaEjb getEjb() {
        return ejb;
    }

    public void setEjb(PersonaEjb ejb) {
        this.ejb = ejb;
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    
}
