/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Alerta;
import Entidades.Mensaje;
import Entidades.TrabajadoresHospital;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private TrabajadoresHospital administrativo;
    private List<Alerta> alertas;
    
    @ManagedProperty(value = "#{loginController}")
    private LoginController session;

    public PrincipalControllerBeans() {
        administrativo = new TrabajadoresHospital();
        administrativo.setDNI("26806644Y");
        administrativo.setNombre("Emilio");
        administrativo.setApellido1("Tenorio");
        administrativo.setApellido2("Serrano");
        administrativo.setSexo("V");
        alertas = new ArrayList<Alerta>();
        mensajes = new ArrayList<Mensaje>();
        Alerta a = new Alerta();
        Mensaje m = new Mensaje();
        a.setAsunto("Probando");
        a.setDescripcion("Esta es una prueba de alerta");
        a.setFecha(new Date());
        alertas.add(a);
        a = new Alerta();
        a.setAsunto("Otra alerta");
        a.setDescripcion("Segunda alerta del administrativo");
        a.setFecha(new Date());
        alertas.add(a);
        m.setAsunto("Primer Mensaje");
        m.setMensaje("¿Si tiene fiebre el paciente a que puede deberse? vamos a rellenar con texto para ver que pasa si es más largo que la columna que lo almacena.");
        m.setFecha(new Date());
        m.setFrom(administrativo);
        mensajes.add(m);
    }

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public TrabajadoresHospital getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(TrabajadoresHospital administrativo) {
        this.administrativo = administrativo;
    }

    public List<Alerta> getAlertas() {
        return alertas;
    }

    public void setAlertas(List<Alerta> alertas) {
        this.alertas = alertas;
    }

    public String verMiHistoria(String nss) {
        session.setBuscado(Integer.parseInt(nss));
        return "HistoriaClinica.xhtml";
    }

    public LoginController getSession() {
        return session;
    }

    public void setSession(LoginController session) {
        this.session = session;
    }
    
    
}
