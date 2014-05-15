/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Cita;
import Entidades.Enumerados;
import Entidades.Medico;
import Entidades.Persona;
import Entidades.Urgencia;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@RequestScoped
public class TrabajosBean {
    private List<Cita> citas;
    private List<Urgencia> urgencias; 
    private String muestra="";
    private Urgencia urge;
    /**
     * Creates a new instance of CitasBean
     */
    public TrabajosBean() {
        citas = new ArrayList<>();
        urgencias = new ArrayList<>();
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
        Medico doctor = new Medico();
        doctor.setNumSegSocial(5);
        doctor.setNombre("Silvio");
        doctor.setApellido1("Berlusconi");
        Cita c1 = new Cita();
        c1.setAtendido(false);
        c1.setFecha(Date.valueOf("1992-1-12"));
        c1.setObservaciones("La cita ha terminado correctamente");
        c1.setPersona(p1);
        c1.setTipoCita(Enumerados.tipoCita.DIAGNOSTICO);
        c1.setTrabajador(doctor);
        Cita c2 = new Cita();
        c2.setAtendido(false);
        c2.setFecha(Date.valueOf("1992-1-12"));
        c2.setPersona(p1);
        c2.setTipoCita(Enumerados.tipoCita.DIAGNOSTICO);
        c2.setTrabajador(doctor);
        citas.add(c1);
        citas.add(c2);
        Urgencia u1 = new Urgencia();
        u1.setEstado(Enumerados.estadoUrgencia.ESPERA);
        u1.setFecha(Date.valueOf("1992-1-12"));
        u1.setPersona(p1);
        u1.setObservaciones("El paciente tiene un corte muy profundo");
        u1.setTipo(Enumerados.tipoUrgencia.CORTE);
        u1.setTrabajador(doctor);
        Urgencia u2 = new Urgencia();
        u2.setEstado(Enumerados.estadoUrgencia.TRATAMIENTO);
        u2.setFecha(Date.valueOf("1992-1-12"));
        u2.setPersona(p1);
        u2.setObservaciones("El paciente tiene un corte muy profundo");
        u2.setTipo(Enumerados.tipoUrgencia.CORTE);
        u2.setTrabajador(doctor);
        urgencias.add(u1);
        urgencias.add(u2);
    }

    public Urgencia getUrge() {
        return urge;
    }

    public void setUrge(Urgencia urge) {
        this.urge = urge;
    }

    
    public String getMuestra() {
        return muestra;
    }

    public void setMuestra(String muestra) {
        this.muestra = muestra;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Urgencia> getUrgencias() {
        return urgencias;
    }

    public void setUrgencias(List<Urgencia> urgencias) {
        this.urgencias = urgencias;
    } 
    
    public void muestraUregncias(){
        muestra="urgencias";
    }
    public void muestraCitas(){
        muestra="citas";
    }
    public String doDiagnostico(Cita cita){
        return "Diagnostico";
    }
    
    public String doDiagnosticoUrgencia(Urgencia u){
        
        return "Diagnostico";
    }
    public String doTratar(Cita c){
        return "tratamiento";
    }
    public String doTratarUrgencia(Urgencia u){
        return "tratamiento";
    }
}
