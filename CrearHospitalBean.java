/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.HospitalEjb;
import Entidades.Hospital;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@RequestScoped
public class CrearHospitalBean {
    private String nombre;
    private String direccion;
    private Integer codigoPostal;
    private String ciudad;
    private String localizacion;
    private Hospital hospital = new Hospital();
    
    @EJB
    private HospitalEjb ejb;
    
    public CrearHospitalBean(){
        
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

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the codigoPostal
     */
    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal the codigoPostal to set
     */
    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    /**
     * @return the localizacion
     */
    public String getLocalizacion() {
        return localizacion;
    }
    
    public String crearHospital(){
        hospital.setNombre(nombre);
        hospital.setCiudad(ciudad);
        hospital.setDireccion(direccion);
        hospital.setCodigoPostal(codigoPostal);
        hospital.setLocalizacion(localizacion);
        ejb.crearHospital(hospital);
        return null;
    }

    /**
     * @param localizacion the localizacion to set
     */
    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public HospitalEjb getEjb() {
        return ejb;
    }

    public void setEjb(HospitalEjb ejb) {
        this.ejb = ejb;
    }
    
}
