/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.PersonaEjb;
import Entidades.Contacto;
import Entidades.Persona;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@ViewScoped
public class ContactoBean {
    private Persona p;
    private String descripcion;
    private String email;
    private String nombre;
    private String asunto;
    @EJB
    private PersonaEjb ejb;
    
    @ManagedProperty(value = "#{loginController}")
    private LoginController session;
    
    public ContactoBean(){
        if(session.getNss()!=null){
            p = ejb.getPersona(session.getNss());
        }
    }

    public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }

    public PersonaEjb getEjb() {
        return ejb;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    
    public void setEjb(PersonaEjb ejb) {
        this.ejb = ejb;
    }

    public LoginController getSession() {
        return session;
    }

    public void setSession(LoginController session) {
        this.session = session;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String enviarFormulario(){
        Contacto c = new Contacto();
        c.setContenido(descripcion);
        if(session.getNss()!=null){
            c.setP(p);
        }else{
            c.setEmail(email);
            c.setNombre(nombre);
        }
        ejb.crearFormularioContacto(c);
        return "null";
    }
}
