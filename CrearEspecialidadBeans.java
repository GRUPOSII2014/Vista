/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.CrearEspecialidadEjb;
import Entidades.Especialidad;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ALBERTO
 */

@ManagedBean
@ViewScoped
public class CrearEspecialidadBeans {
    
    
    private String nombre, descripcion;
    
    @ManagedProperty(value = "#{loginController}")
    private Vista.LoginController login;
    
    @EJB
    private CrearEspecialidadEjb especialidad;
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public CrearEspecialidadEjb getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(CrearEspecialidadEjb especialidad) {
        this.especialidad = especialidad;
    }

    
    public String crearEspecialidad (){
        Especialidad e = new Especialidad();
        e.setNombre(nombre);
        e.setDescripcion(descripcion);
        especialidad.crearEspecialidad(e);
        
        return null;
    }    

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }
    
    
}
