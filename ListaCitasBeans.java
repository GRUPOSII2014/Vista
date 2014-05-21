/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.CitaEjb;
import Entidades.Cita;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class ListaCitasBeans {
        private Date fecha;
        private List<Cita> citas = new ArrayList<>();
        private List<Cita> espera = new ArrayList<>();
        @EJB
        private CitaEjb ejb;
        @ManagedProperty(value = "#{loginController}")
        private LoginController login;
    /**
     * Creates a new instance of ListaCitas
     */
    public ListaCitasBeans() {

    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    
    
    public CitaEjb getEjb() {
        return ejb;
    }

    public void setEjb(CitaEjb ejb) {
        this.ejb = ejb;
    }
    
    
    public void inic (){
        citas.addAll(ejb.citasDePersona(login.getNss()));
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Cita> getEspera() {
        return espera;
    }

    public void setEspera(List<Cita> espera) {
        this.espera = espera;
    }

    public int getPosicion(Cita c){
        return 2;
    }
    public String eliminar(Cita c){
        citas.remove(c);
        return "null";
    }
    
}
