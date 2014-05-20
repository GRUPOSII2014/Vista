/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Emilio
 */
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {
    
    private Integer nss;
    private String tipoUsuario;
    private Integer buscado;
    private String tipoCrearPersona = "";
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
    }

    public Integer getNss() {
        return nss;
    }

    public void setNss(Integer nss) {
        this.nss = nss;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getBuscado() {
        return buscado;
    }

    public void setBuscado(Integer buscado) {
        this.buscado = buscado;
    }

    /**
     * @return the tipoCrearPersona
     */
    public String getTipoCrearPersona() {
        return tipoCrearPersona;
    }

    /**
     * @param tipoCrearPersona the tipoCrearPersona to set
     */
    public void setTipoCrearPersona(String tipoCrearPersona) {
        this.tipoCrearPersona = tipoCrearPersona;
    }
}
