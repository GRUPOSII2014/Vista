package Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entidades.Alerta;
import Entidades.Cita;
import Entidades.Departamento;
import Entidades.Enfermero;
import Entidades.Enumerados;
import Entidades.Horario;
import Entidades.Hospital;
import Entidades.Medico;
import Entidades.Mensaje;
import Entidades.Persona;
import Entidades.Trabajador;
import Entidades.Urgencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class EnfermeroBeans {
    private Enfermero enf;
    
    public EnfermeroBeans(){
        
        
        /*
        enf = new Enfermero();
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
        float s=30;
        enf.setSueldoHora(s);
        float ss=1500;
        enf.setSueldoHora(ss);
        enf.setActivo(true);
        enf.setTipo(Enumerados.tipoTrabajador.ENFERMERO);
        
        Medico med=new Medico();
        med.setNumSegSocial(2);
        med.setDNI("25353552G");
        med.setNombre("Barack");
        med.setApellido1("Obama");
        med.setEstadoCivil("Casado");
        med.setDireccion("Casa Blanca");
        med.setPais("EEUU");
        med.setCiudad("Washington");
        med.setCodigoPostal(25417);
        med.setSexo("Varon");
        med.setActivo(true);
        med.setSalario(ss);
        med.setTipo(Enumerados.tipoTrabajador.MEDICO);
        med.setPrecioHora(s);
        
        Persona p = new Persona();
        p.setNumSegSocial(3);
        p.setDNI("25414147R");
        p.setNombre("Angela");
        p.setApellido1("Merkel");
        p.setEstadoCivil("Soltero");
        p.setDireccion("Calle Juan de Mitarte");
        p.setCodigoPostal(29210);
        p.setCiudad("Munich");
        p.setPais("Alemania");
        p.setSexo("Mujer");
        
        Persona pr = new Persona();
        pr.setNumSegSocial(4);
        pr.setDNI("25411447L");
        pr.setNombre("Nicolas");
        pr.setApellido1("Sarkozy");
        pr.setEstadoCivil("Casado");
        pr.setDireccion("Calle Evergreen Terrace");
        pr.setCodigoPostal(29658);
        pr.setCiudad("París");
        pr.setPais("Francia");
        pr.setSexo("Varón");
        
        Date da = new Date();
        da.setMonth(8);
        da.setYear(2014-1900);
        da.setDate(12);
        da.setHours(10);
        da.setMinutes(30);
        
        Cita c = new Cita();
        c.setFecha(da);
        c.setAtendido(false);
        c.setTipoCita(Enumerados.tipoCita.ENFERMERIA);
        
        Horario horM = new Horario();
        horM.setId(1);
        horM.setTipo(Enumerados.tipoHorario.MAÑANA);
        Date ent = new Date();
        Date sal = new Date();
        ent.setHours(9);
        ent.setMinutes(0);
        sal.setHours(13);
        sal.setMinutes(30);
        horM.setHoraEntrada(ent);
        horM.setHoraSalida(sal);
        
        Horario horT = new Horario();
        horT.setId(2);
        horT.setTipo(Enumerados.tipoHorario.TARDE);
        Date en = new Date ();
        Date sa = new Date ();
        en.setHours(16);
        en.setMinutes(00);
        sa.setHours(20);
        sa.setMinutes(30);
        horT.setHoraEntrada(en);
        horT.setHoraSalida(sa);
        
        Departamento dep = new Departamento();
        dep.setId(1);
        dep.setNombre("Ginecología");
        dep.setDescripcion("Asuntos íntimos de las mujeres");
        dep.setActivo(true);
        
        Hospital hosp = new Hospital();
        hosp.setId(1);
        hosp.setNombre("Hospital Guerra Fría");
        hosp.setDireccion("Calle Estacada 2");
        hosp.setCodigoPostal(29240);
        hosp.setCiudad("Valle de Abdalajís");
        Date ap = new Date();
        ap.setHours(9);
        ap.setMinutes(00);
        hosp.setHoraApertura(ap);
        Date ci = new Date();
        ci.setHours(21);
        ci.setMinutes(00);
        hosp.setHoraCierre(ci);
        hosp.setLocalizacion("17,53");
        
        Alerta a1 = new Alerta();
        a1.setId((long)1);
        a1.setAsunto("curar herida");
        a1.setDescripcion("curar la herida producida por quemadura de un paciente en el brazo a las 14:00");
        a1.setTipo(Enumerados.tipoAlerta.AVISO);
        Date d = new Date(2014-1900,5,1,17,24);
        a1.setFecha(d);
        a1.setTrabajador(med);
        
        Alerta a2 = new Alerta();
        a2.setId((long)2);
        a2.setAsunto("horario laboral");
        a2.setDescripcion("Mañana el hospital estará cerrado");
        a2.setTipo(Enumerados.tipoAlerta.NOTIFICACION);
        Date d2 = new Date(2014-1900,4,27);
        a2.setFecha(d2);
        a2.setTrabajador(enf);
        
        Alerta a3 = new Alerta();
        a3.setId((long)3);
        a3.setAsunto("Jubilación");
        a3.setDescripcion("El doctor Ramirez se jubila esta semana, será sustituido por el doctor Valverde");
        a3.setTipo(Enumerados.tipoAlerta.NOTIFICACION);
        a3.setFecha(d2);
        a3.setTrabajador(enf);
        
        Mensaje m1 = new Mensaje();
        m1.setId(1);
        m1.setAsunto("pacientes sospechosos");
        m1.setMensaje("He notado que el paciente Lopez tiene miedo de algo, quizás deberías verlo");
        Date dd= new Date(2014-1900,4,24,12,23);
        m1.setFecha(dd);
        
        Mensaje m2 = new Mensaje();
        m2.setId(2);
        m2.setAsunto("Habitación 343");
        m2.setMensaje("No puedo ver quien hay en la habitación 343, ¿Podrías mirarlo y decirme?");
        Date di = new Date(2014-1900,4,29,13,04);
        m2.setFecha(di);
        
        Mensaje m3 = new Mensaje();
        m3.setId(3);
        m3.setAsunto("Me voy");
        m3.setMensaje("Hoy he pedido un aumento de sueldo, si no me lo dan dejo el trabajo.");
        Date de = new Date(2014-1900,5,5,10,18);
        m3.setFecha(de);
        
        
        Urgencia u = new Urgencia();
        u.setFecha(de);
        u.setEstado(Enumerados.estadoUrgencia.ESPERA);
        u.setTipo(Enumerados.tipoUrgencia.CORTE);
        
        Urgencia uu = new Urgencia();
        uu.setFecha(de);
        uu.setEstado(Enumerados.estadoUrgencia.TRATAMIENTO);
        uu.setTipo(Enumerados.tipoUrgencia.DISPARO);
        
        List<Urgencia> urgencias = new ArrayList<Urgencia>();
        urgencias.add(u);
        urgencias.add(uu);
        
        List<Mensaje> recibidos = new ArrayList<Mensaje>();
        recibidos.add(m3);
        recibidos.add(m1);
        recibidos.add(m2);
        
        List<Mensaje> enviados = new ArrayList<Mensaje>();
        enviados.add(m2);
        
        List<Alerta> alertas = new ArrayList<Alerta>();
        alertas.add(a1);
        alertas.add(a2);
        alertas.add(a3);
        
        List<Horario> horarios = new ArrayList<Horario>();
        horarios.add(horM);
        horarios.add(horT);
        
        List<Trabajador> trabajadores = new ArrayList<Trabajador>();
        trabajadores.add(med);
        
        List<Cita> citas = new ArrayList<Cita>();
        citas.add(c);
        
        m1.setFrom(med);
        m2.setFrom(enf);
        m3.setFrom(med);
        med.setMedicoCabecera(med);
        dep.setTrabajadores(trabajadores);
        dep.setHospital(hosp);
        dep.setJefe(med);
        med.setDepartamento(dep);
        u.setTrabajador(med);
        uu.setTrabajador(enf);
        pr.setMedicoCabecera(med);
        p.setMedicoCabecera(med);
        c.setPersona(p);
        c.setTrabajador(enf);
        enf.setCitas(citas);
        enf.setMedicoCabecera(med);
        enf.setHorarios(horarios);
        enf.setAlertas(alertas);
        enf.setMensajeFrom(recibidos);
        enf.setMensajeTo(enviados);  
        enf.setUrgencias(urgencias);
                */
    
    }

    /**
     * @return the enf
     */
    public Enfermero getEnf() {
        return enf;
    }

    /**
     * @param enf the enf to set
     */
    public void setEnf(Enfermero enf) {
        this.enf = enf;
    }
    
 
}
