/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Cama;
import Entidades.Enumerados;
import Entidades.Habitacion;
import Entidades.Persona;
import Entidades.Planta;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Fernando
 */
@ManagedBean
@ViewScoped
public class IngresoBeans {

    private Integer nss;
    private Cama cama;
    public Persona p1=null;

    public IngresoBeans() {
        ArrayList<Cama> camas = new ArrayList<>();
        Habitacion h = new Habitacion();
        Planta p = new Planta();
        cama = new Cama();
        cama.setId(1L);
        //cama.setHabitacion(h);
        cama.setEstado(Enumerados.estadoCama.LIBRE);
        camas.add(cama);
        //h.setCamas(camas);
        h.setId(1L);
        h.setTipo(Enumerados.tipoHabitacion.UVI);
        h.setPlanta(p);
        p.setId(1L);
        p.setNombre("una planta");
    }
    
    public Integer getNss(){
        return nss;
    }
    
    public void setNss(Integer nss){
        this.nss = nss;
    }

    public Cama getCama() {
        return cama;
    }

    public void setCama(Cama cama) {
        this.cama = cama;
    }

    
    
    public String asignarCama(){
        return "principal";
    }
    
    public String buscaPersona(){
         p1 = new Persona();
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
        return "null";
        
    }

    public Persona getP1() {
        return p1;
    }

    public void setP1(Persona p1) {
        this.p1 = p1;
    }
    
}
