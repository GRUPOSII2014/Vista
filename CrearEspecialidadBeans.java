/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import Ejb.CrearEspecialidadEjb;
import Entidades.Especialidad;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ALBERTO
 */

@ManagedBean
@ViewScoped
public class CrearEspecialidadBeans {
    
    @EJB
    private CrearEspecialidadEjb ejb;
    
    private Especialidad e;
    
     public Especialidad getE() {
        return e;
    }

    public void setE(Especialidad e) {
        this.e = e;
    }
    
    public String crearEspecialidad (){
        return null;
    }    
}
