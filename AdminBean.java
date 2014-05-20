/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Angel
 */
@ManagedBean
@RequestScoped
public class AdminBean {
    private Entidades.Admin adm;
    private Ejb.PersonaEjb ejb;

    /**
     * @return the adm
     */
    public Entidades.Admin getAdm() {
        return adm;
    }

    /**
     * @param adm the adm to set
     */
    public void setAdm(Entidades.Admin adm) {
        this.adm = adm;
    }

    /**
     * @return the ejb
     */
    public Ejb.PersonaEjb getEjb() {
        return ejb;
    }

    /**
     * @param ejb the ejb to set
     */
    public void setEjb(Ejb.PersonaEjb ejb) {
        this.ejb = ejb;
    }
    
    public String crearAdmin(){
        ejb.crearAdministrativo(adm);
        return null;
    }
    
    
}
