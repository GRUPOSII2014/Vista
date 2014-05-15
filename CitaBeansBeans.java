/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Enfermero;
import Entidades.Enumerados;
import Entidades.Medico;
import Entidades.Persona;
import Entidades.Urgencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Fernando y Pyros
 */

@ManagedBean
@ViewScoped
public class CitaBeansBeans {
    private Urgencia urgencia= new Urgencia();
    private Persona persona=null;
    private Integer nss;
    private String tipocita;
    private List<Medico> medicosCabecera;
    private List<String> horas=null;
    private List<String> tiposCita;
    private String dias;
    private Enfermero enfermero;
    private Date fecha;
    public CitaBeansBeans(){
        medicosCabecera = new ArrayList<>();
        horas = null;
        tiposCita=new ArrayList<>();
        tiposCita.add("Enfermeria");
        tiposCita.add("Diagnostico");
        tiposCita.add("Cirugía");
        dias = "lunes, martes, miercoles";
        
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    
    public String getTipocita() {
        return tipocita;
    }

    public void setTipocita(String tipocita) {
        this.tipocita = tipocita;
    }

    
    public String buscaPersona(){
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
        horas.add("segunda");
        return "null";
    }

    
    public Enfermero getEnfermero() {
        return enfermero;
    }

    public void setEnfermero(Enfermero enfermero) {
        this.enfermero = enfermero;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getNss() {
        return nss;
    }

    public void setNss(Integer nss) {
        this.nss = nss;
    }

    public List<Medico> getMedicosCabecera() {
        return medicosCabecera;
    }

    public void setMedicosCabecera(List<Medico> medicosCabecera) {
        this.medicosCabecera = medicosCabecera;
    }
    
    public void buscaHoras(){
        
    }

    public List<String> getHoras() {
        return horas;
    }

    public void setHoras(List<String> horas) {
        this.horas = horas;
    }

    public List<String> getTiposCita() {
        return tiposCita;
    }

    public void setTiposCita(List<String> tiposCita) {
        this.tiposCita = tiposCita;
    }
    
    
    public String crearCita(){
        return null;
    }

    /**
     * @return the urgencia
     */
    public Urgencia getUrgencia() {
        return urgencia;
    }

    /**
     * @param urgencia the urgencia to set
     */
    public void setUrgencia(Urgencia urgencia) {
        this.urgencia = urgencia;
    }
}
