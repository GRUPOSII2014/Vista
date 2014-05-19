/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Alerta;
import Entidades.Enumerados;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
/**
 *
 * @author Ricardo
 */

@ManagedBean
@ViewScoped
public class EventosBean {
    
    private Alerta alerta;
    private Date fecha;
    private String tipo;
    private String receptor;
    
    public EventosBean(){
        
        alerta = new Alerta();
        alerta.setId(Long.MIN_VALUE);
        alerta.setFecha(new Date());
        alerta.setTipo(Enumerados.tipoAlerta.AVISO);
       
        
    }

    public String getReceptor() {
        return receptor;
    }

    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    
    public List<String> complete(String query) {  
        List<String> results = new ArrayList<String>();  
          
        for (int i = 0; i < 10; i++) {  
            results.add(query + i);  
        }  
          
        return results;  
    } 
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public void setAsunto(String asunto){
    
    this.alerta.setAsunto(asunto);
}
     public void setDescripcion(String descripcion){
    
    this.alerta.setDescripcion(descripcion);
}

    public Alerta getAlerta() {
        return alerta;
    }

    public void setAlerta(Alerta alerta) {
        this.alerta = alerta;
    }
    public String creacion(){
         System.out.println(this.alerta.getAsunto());
        return "gestionalertas.xhtml";
       
    }
    
}
