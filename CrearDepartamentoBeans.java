/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vista;

import Ejb.CrearDepartamentoEjb;
import Entidades.Departamento;
import Entidades.Hospital;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ALBERTO
 */

@ManagedBean
@ViewScoped
public class CrearDepartamentoBeans {
   
    @EJB
    private CrearDepartamentoEjb ejb;

    private Departamento d;
    
    public Departamento getD() {
        return d;
    }

    public void setD(Departamento d) {
        this.d = d;
    }
    
    public String crearDepartamento (){
        return null;
    }
    
    public List<Hospital> getHospitales(){
        return ejb.todosHospitales();
    }
}
