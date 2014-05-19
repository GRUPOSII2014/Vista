/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.PersonaEjb;
import Entidades.Alerta;
import Entidades.Mensaje;
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
    private LoginController login;

    public PrincipalControllerBeans() {
    }

    public Persona getPersona() {
        return persona.getPersona(login.getNss());
    }

    public String verMiHistoria(Integer nss) {
        login.setBuscado(nss);
        return "HistoriaClinica.xhtml";
    }

    public LoginController getSession() {
        return login;
    }

    public void setSession(LoginController session) {
        this.login = session;
    }

    public String verMiTrabajo(Integer nss) {
        login.setBuscado(nss);
        return "Trabajo.xhtml";
    }

    public String verMisCitas(Integer nss) {
        login.setBuscado(nss);
        return "citas.xhtml";
    }

    public List<Alerta> getAlertas() {
        return persona.allAlertas(login.getNss());
    }

    public String cambiaPass(Integer nss) {
        login.setBuscado(nss);
        return "Cambiarclave.xhtml";
    }

    public List<Mensaje> getMensajes() {
        return persona.allMensajes(login.getNss());
    }
    public String verMisDatos(){
        login.setBuscado(login.getNss());
        return "MisDatos.xhtml";
    }
}
