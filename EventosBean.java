/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.EventosEjb;
import Ejb.PersonaEjb;
import Entidades.Alerta;
import Entidades.Enumerados;
import Entidades.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author Ricardo
 */

@ManagedBean
@ViewScoped
public class EventosBean {
    
    private Alerta alerta = inic();
    private Date fecha;
    private String tipo;
    private String receptor;
    @EJB
    private EventosEjb ejb;
    @EJB
    private PersonaEjb ejb2;
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    
    public EventosBean(){
        
        
       
        
    }

    public Alerta inic(){
      Alerta  alerta2 = new Alerta();
        alerta2.setFecha(new Date());
        alerta2.setTipo(Enumerados.tipoAlerta.AVISO);
        
        return alerta2;
    }
    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    
    public List<String> complete(String query) {  
        List<String> results = new ArrayList<String>();
        for (Persona p : ejb.getPersonas(query)){
            results.add(p.getNombre()+" "+p.getApellido1()+" "+p.getApellido2() + " " + p.getDNI());
        }
        return results;  
    } 
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setAsunto(String asunto){
    
    this.alerta.setAsunto(asunto);
}
     public void setDescripcion(String descripcion){
    
    this.alerta.setDescripcion(descripcion);
}

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }

    public EventosEjb getEjb() {
        return ejb;
    }

    public void setEjb(EventosEjb ejb) {
        this.ejb = ejb;
    }
    
    public String creacion(){
        alerta.setTrabajador(ejb2.getTrabajador(login.getNss()));
         ejb.crearEventos(alerta);
        return "gestionalertas.xhtml";
       
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }
    
}
