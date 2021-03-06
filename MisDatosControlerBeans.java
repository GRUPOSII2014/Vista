/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.PersonaEjb;
import Entidades.Horario;
import Entidades.Medico;
import Entidades.Persona;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@ViewScoped
public class MisDatosControlerBeans {
    private Persona persona;
    private Medico medico;
    
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    @EJB
    private PersonaEjb ejb;
    /**
     * Creates a new instance of PrincipalPacienteBean
     */
    
    public MisDatosControlerBeans() {
        
    }

    public Medico getMedico() {
        return medico;
    }

    public String queEs(){
        if(ejb.getPersona(login.getNss()).getDisc()=="M"){
            medico =ejb.getMedico(login.getNss());
        }
        return ejb.getPersona(login.getNss()).getDisc();
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public void inic(){
        persona=ejb.getPersona(login.getBuscado());
    }
    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    public String doChanges(){
        ejb.actualizaPersona(persona);
        return "MisDatos.xhtml";
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    public PersonaEjb getEjb() {
        return ejb;
    }

    public void setEjb(PersonaEjb ejb) {
        this.ejb = ejb;
    }
    
}
