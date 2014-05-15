/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Enumerados;
import Entidades.Informe;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ALBERTO
 */

@ManagedBean
@RequestScoped
public class InformeBean {
  
    private Informe informe;
    private String SegOpinion;
    private List<String> listado;
    
    public InformeBean(){
        informe = new Informe();
        informe.setId(Integer.SIZE);
        listado = new ArrayList<String>();
        listado.add("nllsf");
        listado.add("hola");
        listado.add("YO");
        listado.add("pac");
    } 
    
    public Informe getInforme() {
        return informe;
    }

    public String getSegOpinion() {
        return SegOpinion;
    }

    public void setSegOpinion(String SegOpinion) {
        this.SegOpinion = SegOpinion;
    }

    public List<String> getListado() {
        return listado;
    }

    public void setListado(List<String> listado) {
        this.listado = listado;
    }
    
    
    public void setInforme(Informe informe) {
        this.informe = informe;
    }
    public void setDiagnostico(String diagnostico){    
        this.informe.setDiagnostico(diagnostico);
    }
    
    public void setObservaciones(String observaciones){
        this.informe.setObservaciones(observaciones);
    }
    
    public void setFecha(Date fecha){
        this.informe.setFecha(fecha);
    }
    
    public void setTipo(String tipo){
        if(tipo==Enumerados.tipoInforme.ALERGIAS.name()){
            this.informe.setTipo(Enumerados.tipoInforme.ALERGIAS);
        }
        if(tipo==Enumerados.tipoInforme.DIAGNOSTICO.name()){
            this.informe.setTipo(Enumerados.tipoInforme.DIAGNOSTICO);
        }
        if(tipo==Enumerados.tipoInforme.ENFERMERIA.name()){
            this.informe.setTipo(Enumerados.tipoInforme.ENFERMERIA);
        }
        if(tipo==Enumerados.tipoInforme.INGRESO.name()){
            this.informe.setTipo(Enumerados.tipoInforme.INGRESO);
        }
        if(tipo==Enumerados.tipoInforme.QUIROFANO.name()){
            this.informe.setTipo(Enumerados.tipoInforme.QUIROFANO);
        }
        if(tipo==Enumerados.tipoInforme.TRATAMIENTOS.name()){
            this.informe.setTipo(Enumerados.tipoInforme.TRATAMIENTOS);
        }
        if(tipo==Enumerados.tipoInforme.URGENCIAS.name()){
            this.informe.setTipo(Enumerados.tipoInforme.URGENCIAS);
        }
    }
    
    public String goEnviar(){
        return "medico.xhtml";
    }
    
    public String goEnlazar(){
        return "medico.xhtml";
    }
}
