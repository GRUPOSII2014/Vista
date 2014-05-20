/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;


import Ejb.PersonaEjb;
import Entidades.Medico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
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
    @EJB
    private PersonaEjb ejb;
    private Medico m;
    private int horaEntrada;
    private int horaSalida;
    private List<Integer> horas = new ArrayList<>();
    
    public MedicoBeans(){
        for (int i = 0; i< 24 ;i++)
            horas.add(i);
    }

    public PersonaEjb getEjb() {
        return ejb;
    }

    public void setEjb(PersonaEjb ejb) {
        this.ejb = ejb;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(int horaSalida) {
        this.horaSalida = horaSalida;
    }

    public List<Integer> getHoras() {
        return horas;
    }

    public void setHoras(List<Integer> horas) {
        this.horas = horas;
    }
    
    public Medico getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(Medico m) {
        this.m = m;
    }

    
     public void crear(ActionEvent actionEvent){
       PersonaEjb.Error error = ejb.compruebaMedico(m);
        FacesContext context = FacesContext.getCurrentInstance();
        if(error.equals(PersonaEjb.Error.DNI_REPETIDO)){
            context.addMessage(null, new FacesMessage("Error", "El dni ya se encuentra en la base de datos"));
        }else if (error.equals(PersonaEjb.Error.CORREO_REPETIDO)){
            context.addMessage(null, new FacesMessage("Error", "El email ya se encuentra en la base de datos"));
        }else if (error.equals(PersonaEjb.Error.NSS_REPETIDO)){
            context.addMessage(null, new FacesMessage("Error", "El numero de seguridad social ya se encuentra en la base de datos"));
        }else{
            context.addMessage(null, new FacesMessage("Exito", "Persona Creada corectamente"));
        }
    }
    
}
