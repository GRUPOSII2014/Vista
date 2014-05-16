/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.PersonaEjb;
import Entidades.Alerta;
import Entidades.Persona;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Emilio
 */
@ManagedBean
@RequestScoped
public class PrincipalControllerBeans {

    @EJB
    private PersonaEjb persona;
    
    @ManagedProperty(value = "#{loginController}")
    private LoginController session;

    public PrincipalControllerBeans() {        
    }

    
    public Persona getPersona() {
        return persona.getPersona(session.getNss());
    }
    
    public String verMiHistoria(Integer nss) {
        session.setBuscado(nss);
        return "HistoriaClinica.xhtml";
    }

    public LoginController getSession() {
        return session;
    }

    public void setSession(LoginController session) {
        this.session = session;
    }
    
    public String verMiTrabajo(Integer nss){
        session.setBuscado(nss);
        return "Trabajo.xhtml";
    }
    
    public String verMisCitas (Integer nss){
        session.setBuscado(nss);
        return "citas.xhtml";
    }
    
    public List<Alerta> getAlertas() {
        return persona.allAlertas(session.getNss());
    }
    
<<<<<<< HEAD
    public String cambiaPass(Integer nss){
        session.setBuscado(nss);
        return "Cambiarclave.xhtml";
=======
    public List<Mensaje> getMensajes() {
        return persona.allMensajes(session.getNss());
>>>>>>> de3fa7cf7ebdb01a8fbcab4a5eca94b6ddb98411
    }
}
