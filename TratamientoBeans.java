/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.IngresoEjb;
import Ejb.PersonaEjb;
import Entidades.Cantidad;
import Entidades.Persona;
import Entidades.Tratamiento;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;


@ViewScoped
@ManagedBean
public class TratamientoBeans {

    private Tratamiento tratamiento;
    private String obs = "";
    private List <Cantidad> listaCant;
    private Persona persona;
    @EJB
    private IngresoEjb ejb;
    @EJB
    private PersonaEjb pers;
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    
    
    public TratamientoBeans() {
    }

    public void inic(){
        persona = pers.getPersona(login.getBuscado());
        List<Tratamiento> lista = ejb.tratamientos(login.getBuscado());
        tratamiento = new Tratamiento();
        if (!lista.isEmpty())
            tratamiento = lista.get(lista.size()-1);
        listaCant = tratamiento.getCantidades();
    }
    /**
     * @return the t
     */
    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }

    /**
     * @return the listaCant
     */
    public List <Cantidad> getListaCant() {
        return listaCant;
    }

    /**
     * @param listaCant the listaCant to set
     */
    public void setListaCant(List <Cantidad> listaCant) {
        this.listaCant = listaCant;
    }
    
    public String terminarTratamiento(){
        tratamiento.setObservaciones(obs);
        ejb.terminarTratamiento(tratamiento);
        return "Trabajo.xhtml";
    }

    public IngresoEjb getEjb() {
        return ejb;
    }

    public void setEjb(IngresoEjb ejb) {
        this.ejb = ejb;
    }

    public PersonaEjb getPers() {
        return pers;
    }

    public void setPers(PersonaEjb pers) {
        this.pers = pers;
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
}
