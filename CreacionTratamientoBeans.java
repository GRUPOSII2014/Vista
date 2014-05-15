/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Medicamento;
import Entidades.Persona;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Fernando
 */
@RequestScoped
@ManagedBean
public class CreacionTratamientoBeans {

    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    private Date tipo;
    private Persona persona;
    private List<Medicamento> medicamentos;

    public CreacionTratamientoBeans() {
        persona = new Persona();
        persona.setNumSegSocial(6);
        persona.setNombre("Ana María");
        persona.setApellido1("Botella");
        persona.setApellido2("Serrano");

        Medicamento m1 = new Medicamento();
        m1.setId(1);
        m1.setNombre("Ibuprofeno");
        m1.setDescripcion(" antiinflamatorio no esteroideo (AINE), utilizado frecuentemente como"
                + " antipirético y para el alivio sintomático del dolor de cabeza (cefalea), dolor "
                + "dental (odontalgia), dolor muscular o mialgia, molestias de la menstruación "
                + "(dismenorrea), dolor neurológico de carácter leve y dolor postquirúrgico");

        Medicamento m2 = new Medicamento();
        m2.setId(2);
        m2.setNombre("Lexatin");
        m2.setDescripcion("fármaco con acción depresora del sistema nervioso central, destinado"
                + " a disminuir o eliminar los síntomas de la ansiedad.");


        Medicamento m3 = new Medicamento();
        m3.setNombre("Maalox");
        m3.setId(3);
        m3.setDescripcion(" derivado del aluminio y magnesio con bajo contenido en sodio. "
                + "Posee una elevada actividad neutralizando el ácido clorhídrico que se produce"
                + " en el estómago y que es el que provoca la acidez, lo que también reduce la "
                + "formación y la actividad de la enzima pepsina que segrega el estómago.");
        
        medicamentos=new ArrayList<Medicamento>();
        medicamentos.add(m1);
        medicamentos.add(m2);
        medicamentos.add(m3);
    }
    
    public List<Medicamento> getMedicamentos(){
        return medicamentos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String crearTratamiento() {
        return null;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFinalizacion
     */
    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    /**
     * @param fechaFinalizacion the fechaFinalizacion to set
     */
    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    /**
     * @return the tipo
     */
    public Date getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Date tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona p) {
        persona = p;
    }

    public String addMedicamento() {
        return null;
    }

    public String addRecomendacion() {
        return null;
    }

}
