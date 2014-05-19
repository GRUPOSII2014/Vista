/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.util.Date;
import javax.ejb.Schedule;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

 /*
 @author Angel
 */
@ManagedBean
@RequestScoped
public class EnumeradosBean {

    @Schedule(minute = "*", second = "0", dayOfMonth = "*", month = "*", year = "*", hour = "9-17", dayOfWeek = "Mon-Fri", persistent = false)
    
    public void myTimer() {
        System.out.println("Timer event: " + new Date());
    }
    
    public List<String> getTipoUrgencia (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoUrgencia c: Entidades.Enumerados.tipoUrgencia.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
     public List<String> getTipoAlerta (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoAlerta c: Entidades.Enumerados.tipoAlerta.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
      public List<String> getTipoTrabajador( ){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoTrabajador c: Entidades.Enumerados.tipoTrabajador.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
       public List<String> getTipoHabitacion (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoHabitacion c: Entidades.Enumerados.tipoHabitacion.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
        public List<String> getTipoDieta (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoDieta c: Entidades.Enumerados.tipoDieta.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
         public List<String> getTipoCita (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoCita c: Entidades.Enumerados.tipoCita.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
         
          public List<String> getTipoInforme (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoInforme c: Entidades.Enumerados.tipoInforme.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
           public List<String> getTipoRecomendacion (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoRecomendacion c: Entidades.Enumerados.tipoRecomendacion.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
            public List<String> getEstadoUrgencia (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.estadoUrgencia c: Entidades.Enumerados.estadoUrgencia.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
             public List<String> getTipoTratamiento (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoTratamiento c: Entidades.Enumerados.tipoTratamiento.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }

              public List<String> getDiaSemana (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.diaSemana c: Entidades.Enumerados.diaSemana.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
               public List<String> getTipoHorario (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoHorario c: Entidades.Enumerados.tipoHorario.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
                public List<String> getEstadoCama (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.estadoCama c: Entidades.Enumerados.estadoCama.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
                
                 public List<String> getTipoFormulario (){
       List<String> lista = new ArrayList<String>();
        for (Entidades.Enumerados.tipoFormulario c: Entidades.Enumerados.tipoFormulario.values()){
           lista.add(String.valueOf(c));
       } 
        return lista;
        
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}