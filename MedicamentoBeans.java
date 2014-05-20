/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.MedicamentosEjb;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.behavior.AjaxBehavior;

/**
 *
 * @author Fernando
 */
@ManagedBean
@RequestScoped
public class MedicamentoBeans {
    
    @EJB
    private MedicamentosEjb ejb;
    int var;

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }
    
    public MedicamentosEjb getEjb() {
        return ejb;
    }

    public void setEjb(MedicamentosEjb ejb) {
        this.ejb = ejb;
    }
    
    private List<String> medicamentos;
    
    public MedicamentoBeans(){
        medicamentos=new ArrayList<String>();
    }
    
    public void setMedicamentos(List<String> medicamentos){
        this.medicamentos=medicamentos;
    }
    public void addMedicamento(AjaxBehavior evento){
        String s = evento.toString();
        medicamentos.add(s);
    }
    
    public List<String> getMedicamentos(){
        return medicamentos;
    }
}
