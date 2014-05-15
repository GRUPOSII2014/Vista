/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Persona;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@SessionScoped
public class MisDatosControlerBeans {
    public Persona persona=inic();
    /**
     * Creates a new instance of PrincipalPacienteBean
     */
    
    public MisDatosControlerBeans() {
        
    }
    
    private Persona inic(){
        Persona p1 = new Persona();
        p1.setDNI("45355678f");
        p1.setNumSegSocial(444457);
        p1.setNombre("juanito");
        p1.setApellido1("claverias");
        p1.setApellido2("gonzalez");
        p1.setEmail("persona1@h.com");
        p1.setEstadoCivil("soltero");
        p1.setTelefono("988544346");
        p1.setDireccion("callemarmoles");
        p1.setCodigoPostal(13335);
        p1.setPassword("hola");
        p1.setCiudad("Jaen");
        p1.setPais("España");
        p1.setSexo("V");
        
        return p1;
    }
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String goHistoriaClinica(){
        return "HistoriaClinica.xhtml";
    }
    public String doChanges(){
        //Implementar
        return "MisDatos";
    }
    
}
