/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.CitaEjb;
import Entidades.Cita;
import Entidades.Urgencia;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@RequestScoped
public class TrabajosBean {

    private Urgencia urge;
    @EJB
    private CitaEjb trabajos;
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    
    /**
     * Creates a new instance of CitasBean
     */
    public TrabajosBean() {
       
    }

    public Urgencia getUrge() {
        return urge;
    }

    public void setUrge(Urgencia urge) {
        this.urge = urge;
    }

    public List<Cita> listadoCitas(Integer nss) {
        return trabajos.citasNoAtendidas(nss);
    }

    public List<Urgencia> listadoUrgencias(Integer nss) {
        return trabajos.urgenciasEspera(nss);
    }
    
    public String doDiagnostico(Cita cita){
        login.setBuscado(cita.getPersona().getNumSegSocial());
        return "Diagnostico";
    }
    
    public String doDiagnosticoUrgencia(Urgencia u){
        //trabajos.avanzaAtendiendo(u);
        login.setBuscado(u.getPersona().getNumSegSocial());
        return "Diagnostico";
    }
    
    public String doTratar(Cita c){
        login.setBuscado(c.getPersona().getNumSegSocial());
        return "tratamiento";
    }
    
    public String doTratarUrgencia(Urgencia u){
        login.setBuscado(u.getPersona().getNumSegSocial());
        //trabajos.avanzaTratamiento(u);
        return "tratamiento";
    }

    public CitaEjb getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(CitaEjb trabajos) {
        this.trabajos = trabajos;
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }
    
    
}
