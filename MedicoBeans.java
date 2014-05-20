/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;


import Entidades.Departamento;
import Entidades.Enumerados;
import Entidades.Especialidad;
import Entidades.HistoriaClinica;
import Entidades.Hospital;
import Entidades.Medico;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author ALBERTO
 */


@ManagedBean(name="MedicoBean")
@RequestScoped
public class MedicoBeans {
    private Medico m;
   /* Medico medico;
    Medico medicoc;
    Especialidad especialidad;
    Departamento departamento;
    Hospital hospital;
    HistoriaClinica hi;
    float s = 930;
    float e = 20;
    List<Especialidad> especialidades = new ArrayList<Especialidad>();
   */
    public MedicoBeans(){
<<<<<<< HEAD
       /*
        especialidad = new Especialidad();
=======
       /* especialidad = new Especialidad();
>>>>>>> 2f9941b9c079632056d86368f3e21fb3924d71a2
        especialidad.setNombre("Oftalmología");
        especialidad.setDescripcion("Especialidad para el tratamiento de los ojos");
        especialidades.add(especialidad);
        
        hospital = new Hospital();
        hospital.setId(123);
        hospital.setNombre("Carlos Haya");
        hospital.setDireccion("Avenida Carlos de Haya");
        hospital.setCodigoPostal(29009);
        hospital.setCiudad("Malaga");
        Date ap = new Date ();
        Date ci = new Date ();
        hospital.setHoraApertura(ap);
        hospital.setHoraCierre(ci);
        
        departamento = new Departamento();
        departamento.setId(11111111);
        departamento.setNombre("Oftalmología");
        departamento.setDescripcion("Departamento dedicado a la oftalmología");
        departamento.setActivo(true);
        
        medico = new Medico();
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
        medico.setSalario(s);
        medico.setDespacho("3.3.3");
        medico.setPrecioHora(e);
        medico.setMedicoCabecera(medicoc);
        medico.setEspecialidad(especialidades);
        medico.setDepartamento(departamento);
        
        hi = new HistoriaClinica();

        Date fechanac = new Date();
        hi.setFechaNacimiento(fechanac);
        hi.setGrupoSanguineo("0+");
        hi.setObservaciones("Aqui se muestra las observaciones de la historia clinica");
        hi.setInformes(null);
        
        medicoc = new Medico();       
        medicoc.setNombre("Pepe");
        medicoc.setApellido1("Leiva");
        medicoc.setApellido2("Valverde");
        medicoc.setDNI("23444314h");
        medicoc.setNumSegSocial(2);
        medicoc.setEstadoCivil("Soltero");
        medicoc.setPais("España");
        medicoc.setCiudad("Malaga");
        medicoc.setCodigoPostal(29009);
        medicoc.setDireccion("Calle Luis");
        medicoc.setTelefono("954322123");
        medicoc.setActivo(true);
        medicoc.setSexo("V");
        medicoc.setTipo(Enumerados.tipoTrabajador.MEDICO);
        medicoc.setSalario(s);
        medicoc.setDespacho("3.3.2");
        medicoc.setPrecioHora(e);
<<<<<<< HEAD
        medicoc.setMedicoCabecera(medico);   
               */
=======
        medicoc.setMedicoCabecera(medico);  
               */
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Medico getMedicoc() {
        return medicoc;
    }

    public void setMedicoc(Medico medicoc) {
        this.medicoc = medicoc;
    }

    public float getS() {
        return s;
    }

    public void setS(float s) {
        this.s = s;
    }

    public float getE() {
        return e;
    }

    public void setE(float e) {
        this.e = e;
>>>>>>> 2f9941b9c079632056d86368f3e21fb3924d71a2
    }

    /**
     * @return the m
     */
    public Medico getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(Medico m) {
        this.m = m;
    }

    /*
     public void crear(ActionEvent actionEvent){
        ejb.crearPersona(p);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Exito", "La persona ha sido creada correctamente"));
    }
    */
}
