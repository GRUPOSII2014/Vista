/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.PersonaEjb;
import Entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@ViewScoped
public class TodasPersonasBeans {
    private List<Persona> personasFiltradas= new ArrayList<>();
    @EJB
    private PersonaEjb personaEjb;
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    public TodasPersonasBeans() {
        
    }

    public List<Persona> getPersonas() {
        
        return personaEjb.todasPersonas();
    }

    public String creaMedico(){
        login.setTipoUsuario("Medico");
        return "Crearpersona";
    }
    public String creaEnfermero(){
        login.setTipoUsuario("Enfermero");
        return "Crearpersona";
    }
    public String creaAdministrativo(){
        login.setTipoUsuario("Administrativo");
        return "Crearpersona";
    }
    public String creaPersona(){
        /*Persona p1 = new Persona();
        p1.setDNI("45355654f");
        p1.setNumSegSocial(1);
        p1.setNombre("juanito");
        p1.setApellido1("claverias");
        p1.setApellido2("gonzalez");
        p1.setEmail("persona1@h.com");
        p1.setEstadoCivil("soltero");
        p1.setTelefono("988544346");
        p1.setDireccion("callemarmoles");
        p1.setCodigoPostal(13335);
        p1.setCiudad("Jaen");
        p1.setPais("España");
        p1.setSexo("V");
        p1.setPassword("1234");
        p1.setFechaNacimiento(Date.valueOf("1992-10-3"));
        personaEjb.crearPersona(p1);
                */
        return "Crearpersona";
    }
    public List<Persona> getPersonasFiltradas() {
        return personasFiltradas;
    }

    public void setPersonasFiltradas(List<Persona> personasFiltradas) {
        this.personasFiltradas = personasFiltradas;
    }
     public boolean filtrarNss(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }
         
        if(value == null) {
            return false;
        }
         
        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) >= 0;
    }
    public String editarPersona(Persona p){
        login.setBuscado(p.getNumSegSocial());
        return "MisDatos.xhtml";
    }
    public String eliminarPersona(Persona p){
        return "null";
    }
    public void delete(ActionEvent actionEvent){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Accion",  "Se ha eliminado una persona");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public PersonaEjb getPersonaEjb() {
        return personaEjb;
    }

    public void setPersonaEjb(PersonaEjb personaEjb) {
        this.personaEjb = personaEjb;
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }
    
}
