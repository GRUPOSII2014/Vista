/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.IngresoEjb;
import Ejb.PersonaEjb;
import Entidades.Cantidad;
import static Entidades.HistoriaClinica_.persona;
import Entidades.Persona;
import Entidades.Tratamiento;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@RequestScoped
@ManagedBean
public class TratamientoBeans {

    private Tratamiento tratamiento;
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

    public boolean inic(){
        persona = pers.getPersona(login.getBuscado());
        tratamiento = persona.getTratamiento().get(persona.getTratamiento().size()-1);
        listaCant = tratamiento.getCantidades();
        return true;
    }
    /**
     * @return the t
     */
    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    /**
     * @param t the t to set
     */
    public void setT(Tratamiento tratamiento) {
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
