/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.HospitalEjb;
import Entidades.Hospital;
import Entidades.Planta;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@ViewScoped
public class PlantaBean {
    private Long id;
    private Integer numero;
    private Hospital hospital;
    private String nombre;
    private Planta planta;
    
    public PlantaBean(){
        planta = new Planta();
    }
    
    @EJB
    private HospitalEjb ejb;
    
   public List<Hospital> getHospitales(){
       return ejb.getHospitales();
   }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the hospital
     */
    public Hospital getHospital() {
        return hospital;
    }

    /**
     * @param hospital the hospital to set
     */
    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
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
    
    public String crearPlanta(){
        planta.setId(id);
        planta.setNombre(nombre);
        planta.setNombre(nombre);
        planta.setHospital(hospital);
        List<Planta> plantas = new ArrayList<>();
        plantas.addAll(hospital.getPlantas());
        plantas.add(planta);
        hospital.setPlantas(plantas);
        ejb.crearPlanta(planta);
        return null;
    }
}
