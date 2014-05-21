/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.CrearDepartamentoEjb;
import Entidades.Departamento;
import Entidades.Hospital;
import Vista.LoginController;
import java.util.ArrayList;
import java.util.List;
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
public class CrearDepartamentoBeans {
    
    private String nombre,descripcion;
    private String active;
    private List <Hospital> hos = new ArrayList<>();
    private int var;
    
    @ManagedProperty(value = "#{loginController}")
    private Vista.LoginController login;

    @EJB
    private CrearDepartamentoEjb ejb;

    public CrearDepartamentoBeans(){};
    
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
    
    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    public CrearDepartamentoEjb getEjb() {
        return ejb;
    }

    public void setEjb(CrearDepartamentoEjb ejb) {
        this.ejb = ejb;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
   
    public String crearDepartamento (){
        
        Departamento d = new Departamento();
        d.setNombre(nombre);
        d.setDescripcion(descripcion);
        if(active == "0"){
            
            d.setActivo(false);
            
        }else{
            
            d.setActivo(true);
        }
        
        Hospital hospi = new Hospital();
       hospi.setId(var);
        
        d.setHospital(hospi);
        ejb.crearDepartamento(d);
        
        
        
        return null;
    }

    public List<Hospital> getHos() {
        
        for(Hospital h : getHospitales()){
        hos.add(h);
    }
        return hos;
    }

    public void setHos(List<Hospital> hos) {
        this.hos = hos;
    }
    
    public List<Hospital> getHospitales(){
        return ejb.todosHospitales();
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }
    
}
