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
import Entidades.Trabajador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
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
    
    private String consulta, mensaje;

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

    public void setPersona(PersonaEjb persona) {
        this.persona = persona;
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    public String getConsulta() {
        return consulta;
    }

    public void setConsulta(String consulta) {
        this.consulta = consulta;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String enviaMensaje() {
        Trabajador from, to;
        StringTokenizer st = new StringTokenizer(consulta,";");
        st.nextToken();
        from = persona.getTrabajador(login.getNss());
        to = persona.getTrabajador(st.nextToken());
        
        Mensaje m = new Mensaje();
        m.setAsunto("");
        m.setFecha(new Date());
        m.setFrom(from);
        m.setTo(to);
        m.setMensaje(mensaje);
        
        persona.setMensaje(m);
        
        return null;
    }
    
    public List<String> getTrabajadores(String query) {
        List<String> results = new ArrayList<String>();
        for (Trabajador p : persona.getTrabajadores(query)){
            results.add(p.getNombre()+" "+p.getApellido1()+" "+p.getApellido2() + ";" + p.getDNI());
        }
        return results;  
    } 
}
