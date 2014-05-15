/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.HospitalesEJB;
import Entidades.Hospital;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
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
        
    @EJB
    private HospitalesEJB hospitales;
    
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
        return hospitales.allHospitales();
    }
     
}
