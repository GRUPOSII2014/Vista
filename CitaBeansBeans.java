/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.CrearCitaEjb;
import Ejb.IngresoEjb;
import Ejb.PersonaEjb;
import Entidades.Cita;
import Entidades.Medico;
import Entidades.Persona;
import Entidades.Trabajador;
import Entidades.Urgencia;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Fernando y Pyros
 */
@ManagedBean
@ViewScoped
public class CitaBeansBeans {
    
    private Cita cita;
    private Persona persona;
    private List<Medico> medicosCabecera;
    private List<Integer> horas;
    private Trabajador trabajador;
    private Urgencia urgencia;
    private Integer nss;
    
    @EJB
    private IngresoEjb ejb;
    @EJB
    private PersonaEjb pers;
    @Inject
    private CrearCitaEjb ejbCita;

    
    public Persona buscarPersona(){
        persona= ejbCita.buscarPersona(nss);
        return null;
    }
    public CitaBeansBeans() {
        /*medicosCabecera = new ArrayList<>();
         horas = null;
         tiposCita=new ArrayList<>();
         tiposCita.add("Enfermeria");
         tiposCita.add("Diagnostico");
         tiposCita.add("Cirugía");
         dias = "lunes, martes, miercoles";*/
        medicosCabecera = new ArrayList<>();
        medicosCabecera.add(persona.getMedicoCabecera());

        horas = new ArrayList<>();
        Integer h1 = 9;
        Integer h2 = 10;
        Integer h3 = 11;
        Integer h4 = 12;
        Integer h5 = 13;

        horas.add(h1);
        horas.add(h2);
        horas.add(h3);
        horas.add(h4);
        horas.add(h5);
    }

    public String buscaPersona() {
        /*Persona p1 = new Persona();
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
         p1.setCiudad("Jaen");
         p1.setPais("España");
         p1.setSexo("V");
         Medico medico = new Medico();
         medico.setPassword("micontraseña");
         medico.setEmail("alberto@gmail.com");
         medico.setNombre("Alberto");
         medico.setApellido1("Sanchez");
         medico.setApellido2("Muñoz");
         medico.setDNI("23232314h");
         medico.setNumSegSocial(1);
         medico.setEstadoCivil("Casado");
         medico.setPais("España");
         medico.setCiudad("Malaga");
         medico.setCodigoPostal(29009);
         medico.setDireccion("Calle Pepito");
         medico.setTelefono("954321123");
         medico.setActivo(true);
         medico.setSexo("V");
         medico.setTipo(Enumerados.tipoTrabajador.MEDICO);
         medico.setDespacho("3.3.3");
         p1.setMedicoCabecera(medico);
         persona = p1;
         Enfermero enf = new Enfermero();
         enf.setNumSegSocial(1);
         enf.setDNI("25351068F");
         enf.setNombre("Vladimir");
         enf.setApellido1("Putin");
         enf.setTelefono("666666666");
         enf.setEstadoCivil("Casado");
         enf.setDireccion("Calle Falsa 123");
         enf.setCodigoPostal(29000);
         enf.setPais("Rusia");
         enf.setCiudad("Moscow");
         enf.setSexo("Varón");
         enfermero = enf;
         horas = new ArrayList<>();
         horas.add("primera");
         horas.add("segunda");*/
        persona = pers.getPersona(getPersona().getNumSegSocial());
        return "null";
    }

    public Cita getCita() {
        return cita;
    }
    
    public Urgencia getUrgencia(){
        return urgencia;
    }
    
    public void setUrgencia(Urgencia urgencia){
        this.urgencia = urgencia;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Medico> getMedicosCabecera() {
        return medicosCabecera;
    }

    public void setMedicosCabecera(List<Medico> medicosCabecera) {
        this.medicosCabecera = medicosCabecera;
    }

    public List<Integer> getHoras() {
        return horas;
    }

    public void setHoras(List<Integer> horas) {
        this.horas = horas;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public String crearCita() {
        ejb.crearCita(getPersona(), cita);
        return null;
    }

    /**
     * @return the nss
     */
    public Integer getNss() {
        return nss;
    }

    /**
     * @param nss the nss to set
     */
    public void setNss(Integer nss) {
        this.nss = nss;
    }
}
