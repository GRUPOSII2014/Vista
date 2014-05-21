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
import java.util.List;
import java.util.StringTokenizer;
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

    private Alerta alerta = new Alerta();
    private String tipo;
    private String receptor;
    @EJB
    private EventosEjb ejb;
    @EJB
    private PersonaEjb ejb2;
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;

    public EventosBean() {

    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    public List<String> complete(String query) {
        List<String> results = new ArrayList<String>();
        for (Persona p : ejb.getPersonas(query)) {
            results.add(p.getNombre() + " " + p.getApellido1() + " " + p.getApellido2() + ";" + p.getDNI());
        }
        return results;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setAsunto(String asunto) {
        this.alerta.setAsunto(asunto);
    }

    public void setDescripcion(String descripcion) {
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

    public String creacion() {
        alerta.setTipo(Enumerados.tipoAlerta.AVISO);
        alerta.setTrabajador(ejb2.getTrabajador(login.getNss()));

        if (receptor != null) {
            StringTokenizer st = new StringTokenizer(receptor, ";");
            Persona p;

            st.nextToken();

            p = ejb2.getPersona(st.nextToken());

            if (p != null) {
                ejb.crearEventos(alerta, p);
            }
        } else {
            ejb.crearEventos(alerta);
        }

        return "gestionalertas.xhtml";

    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

}
