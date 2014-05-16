/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.PersonaImpl;
import Entidades.Alerta;
import Entidades.Mensaje;
import Entidades.Persona;
import java.util.ArrayList;
import java.util.Date;
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

    private List<Mensaje> mensajes;
    private List<Alerta> alertas;
    
    @EJB
    private PersonaImpl persona;
    
    public PrincipalControllerBeans() {
        
        alertas = new ArrayList<Alerta>();
        mensajes = new ArrayList<Mensaje>();
        Alerta a = new Alerta();
        a.setAsunto("Probando");
        a.setDescripcion("Esta es una prueba de alerta");
        a.setFecha(new Date());
        alertas.add(a);
        a = new Alerta();
        a.setAsunto("Otra alerta");
        a.setDescripcion("Segunda alerta del administrativo");
        a.setFecha(new Date());
        alertas.add(a);
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    public Persona getPersona() {
        return persona.getPersona(login.getNss());
    }
    
}
