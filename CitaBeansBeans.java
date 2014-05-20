/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Fernando y Pyros
 */
@ManagedBean
@ViewScoped
public class CitaBeansBeans {

    private Persona persona;
    private Medico medicoBuscado;
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
    

    public CitaBeansBeans() {
        

    }

    public String inic(){
        medicosCabecera = new ArrayList<>();
        horas = null;
        tiposCita = new ArrayList<>();
        tiposCita.add("Enfermeria");
        tiposCita.add("Diagnostico");
        tiposCita.add("Cirugía");
        dias = "lunes, martes, miercoles";
        cita = new Cita();
        urgencia = new Urgencia();
        enfermeros = ejb.todosEnfermeros();
        return "Inic";
    }

    public Medico getMedicoBuscado() {
        return medicoBuscado;
    }

    public void setMedicoBuscado(Medico medicoBuscado) {
        this.medicoBuscado = medicoBuscado;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
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

    public String buscaPersona() {
        
        persona = ejb.getPersona(nss);
        if(persona.getMedicoCabecera()==null)
            Medico m = ;
        List<Horario> hor = m.getHorarios();
        int anho = Calendar.YEAR;
        int mes = Calendar.MONTH;
        int dia = Calendar.DAY_OF_MONTH;
        Date d = new Date();
        d.setYear(anho);
        d.setMonth(mes);
        d.setDate(dia);
        String esteDia = obtenerDia(d);
        for (Horario h : hor) {
            if (!h.getDia().equals(esteDia)) {
                hor.remove(h);
            }
        }
        
        for (Horario h:hor){
            Date ent = h.getHoraEntrada();
            Date sal = h.getHoraSalida();
            while (ent.before(sal)){
                boolean b = true;
                List<Cita> citas = m.getCitas();
                for (Cita c:citas){
                    if (c.getFecha()==ent){
                        b = false;
                    }
                }
                if (b){
                    horas.add(ent);
                }
                ent = addMinutesToDate(ent,15);
            }
        }
        
        medicosCabecera.add(m);
        return "dev";
    }
    
    public String buscaPersonaE(){
        persona = ejb.getPersona(nss);
        return null;
    }

    public Date addMinutesToDate(Date date, int minutes) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        calendarDate.add(Calendar.MINUTE, minutes);
        return calendarDate.getTime();
    }

    public String obtenerDia(Date d) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(d);
        int dia = cal.DAY_OF_WEEK;

        switch (dia) {
            case 1:
                return "Domingo";
            case 2:
                return "Lunes";
            case 3:
                return "Martes";
            case 4:
                return "Miercoles";
            case 5:
                return "Jueves";
            case 6:
                return "Viernes";
            case 7:
                return "Sabado";
            default:
                return "NOT VALID";
        }
    }
    
    public String asignarHoras(){
       
        List<Horario> hor = new ArrayList<>();
        if(enfermero.getHorarios()!=null)
            hor.addAll(enfermero.getHorarios());
        String esteDia = obtenerDia(fecha);
        for (Horario h : hor) {
            if (!h.getDia().equals(esteDia)) {
                hor.remove(h);
            }
        }
        
        for (Horario h:hor){
            Date ent = h.getHoraEntrada();
            Date sal = h.getHoraSalida();
            while (ent.before(sal)){
                boolean b = true;
                List<Cita> citas = new ArrayList<>();
                if(enfermero.getCitas()!=null)
                    citas.addAll(enfermero.getCitas());
                for (Cita c:citas){
                    if (c.getFecha()==ent){
                        b = false;
                    }
                }
                if (b){
                    horas.add(ent);
                }
                ent = addMinutesToDate(ent,15);
            }
        }
        return "dev";
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

    public List<Enfermero> getEnfermeros(){
        return enfermeros;
    }
    
    public void setEnfermeros(List<Enfermero> enfermeros){
        this.enfermeros = enfermeros;
    }
    
    public List<Medico> getMedicosCabecera() {
        return medicosCabecera;
    }

    public void setMedicosCabecera(List<Medico> medicosCabecera) {
        this.medicosCabecera = medicosCabecera;
    }

    //public void buscaHoras(){
    //}
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
    
    public String crearCitaE(){
        cita.setFecha(fecha);
        cita.setPersona(persona);
        cita.setAtendido(false);
        cita.setTipoCita(Enumerados.tipoCita.ENFERMERIA);
        cita.setTrabajador(enfermero);
        ejb1.crearCita(cita);
        return null;
    }
    
    public String crearUrgencia(){
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
