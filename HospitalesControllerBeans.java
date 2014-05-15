/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Entidades.Hospital;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Emilio
 */
@ManagedBean
@RequestScoped
public class HospitalesControllerBeans {

    private Date fecha;
    private List<Hospital> hospitales = new ArrayList<Hospital>();
    /**
     * Creates a new instance of HospitalesController
     */
    public HospitalesControllerBeans() {
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    public List<Hospital> getHospitales() {
        Hospital h = new Hospital();
        h.setCiudad("Málaga");
        h.setCodigoPostal(29010);
        h.setDireccion("Avenida de Carlos Haya");
        h.setHoraApertura(new Date());
        h.setHoraCierre(new Date());
        h.setNombre("Hospital Universitario Carlos Haya");
        h.setLocalizacion("36.723070, -4.449301");
        if(!hospitales.contains(h))hospitales.add(h);
        return hospitales;
    }

    public void setHospitales(List<Hospital> hospitales) {
        this.hospitales = hospitales;
    }
    
}
