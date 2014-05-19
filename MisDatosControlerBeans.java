/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.PersonaEjb;
import Entidades.Horario;
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
    public Persona persona=inic();
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    @EJB
    private PersonaEjb ejb;
    /**
     * Creates a new instance of PrincipalPacienteBean
     */
    
    public MisDatosControlerBeans() {
        
    }
    
    private Persona inic(){
        Persona p1;
        p1=ejb.getPersona(login.getBuscado());
        return p1;
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
    
    public String horarioMedicoCabecera(){
        StringBuilder sb = new StringBuilder();
        for (Horario h : persona.getMedicoCabecera().getHorarios()){
            sb.append(h.getDia()+", ");
        }
        return sb.toString().substring(0,sb.length()-2)+".";
    }
}
