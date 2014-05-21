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
import Entidades.Enfermero;
import Entidades.Enumerados;
import Entidades.Horario;
import Entidades.Medico;
import Entidades.Persona;
import Entidades.Urgencia;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Fernando y Pyros
 */
@ManagedBean
@ViewScoped
public class CitaBeansBeans {

    private Persona persona;
    private Integer medicoBuscado;
    private List<Medico> medicosCabecera;

    private Urgencia urgencia;
    private Integer nss;
    private String tipocita;

    private List<Date> horas;
    private List<String> tiposCita;
    private String dias;
    private List<Enfermero> enfermeros;
    private Enfermero enfermero;
    private Date fecha;
    private Cita cita;
    @EJB
    private PersonaEjb ejb;
    @EJB
    private IngresoEjb ejb1;
    @EJB
    private CrearCitaEjb ejb2;

    public CitaBeansBeans() {
    }

    public String inic() {
        return "Inic";
    }

    public Integer getMedicoBuscado() {
        return medicoBuscado;
    }

    public void setMedicoBuscado(Integer medicoBuscado) {
        this.medicoBuscado = medicoBuscado;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public CrearCitaEjb getEjb2() {
        return ejb2;
    }

    public void setEjb2(CrearCitaEjb ejb2) {
        this.ejb2 = ejb2;
    }

    public PersonaEjb getEjb() {
        return ejb;
    }

    public void setEjb(PersonaEjb ejb) {
        this.ejb = ejb;
    }

    public IngresoEjb getEjb1() {
        return ejb1;
    }

    public void setEjb1(IngresoEjb ejb1) {
        this.ejb1 = ejb1;
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

    public void buscaPersona(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        persona = ejb.getPersona(nss);
        if (persona == null) {
            context.addMessage(null, new FacesMessage("Error", "No se encuentra la persona en la base de datos"));
        } else {
            if (persona.getMedicoCabecera() == null) {
                medicosCabecera = new ArrayList<>();
                medicosCabecera.addAll(ejb.medicos());
            }
            context.addMessage(null, new FacesMessage("Info", "Persona encontrada"));
        }
    }

    public void crearCita(ActionEvent actionEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Error", "El dni ya se encuentra en la base de datos"));
    }

    public String asignaMedico() {
        persona.setMedicoCabecera(ejb.getMedico(medicoBuscado));
        ejb.actualizaPersona(persona);
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

    public List<Enfermero> getEnfermeros() {
        return enfermeros;
    }

    public void setEnfermeros(List<Enfermero> enfermeros) {
        this.enfermeros = enfermeros;
    }

    public List<Medico> getMedicosCabecera() {
        return medicosCabecera;
    }

    public void setMedicosCabecera(List<Medico> medicosCabecera) {
        this.medicosCabecera = medicosCabecera;
    }

    public List<Date> getHoras() {
        return horas;
    }

    public void setHoras(List<Date> horas) {
        this.horas = horas;
    }

    public List<String> getTiposCita() {
        return tiposCita;
    }

    public void setTiposCita(List<String> tiposCita) {
        this.tiposCita = tiposCita;
    }

    public String crearCitaD() {
        cita.setFecha(fecha);
        cita.setPersona(persona);
        cita.setAtendido(false);
        cita.setTipoCita(Enumerados.tipoCita.DIAGNOSTICO);
        Medico m = persona.getMedicoCabecera();
        cita.setTrabajador(m);
        ejb1.crearCita(cita);
        return null;
    }

    public String crearCitaE() {
        cita.setFecha(fecha);
        cita.setPersona(persona);
        cita.setAtendido(false);
        cita.setTipoCita(Enumerados.tipoCita.ENFERMERIA);
        cita.setTrabajador(enfermero);
        ejb1.crearCita(cita);
        return null;
    }

    public String crearUrgencia() {
        urgencia.setFecha(fecha);
        urgencia.setPersona(persona);
        urgencia.setPersona(enfermero);
        //Esto debería estar en la vista
        urgencia.setEstado(Enumerados.estadoUrgencia.ESPERA);
        urgencia.setTipo(Enumerados.tipoUrgencia.CORTE);
        ejb1.crearUrgencia(urgencia);
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
