/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.PersonaEjb;
import Entidades.HistoriaClinica;
import Entidades.Informe;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@ViewScoped
public class HistoriaBean {

    private Informe informe = null;
    private HistoriaClinica historia = null;
    
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    @Inject
    private PersonaEjb ejb;

    /**
     * Creates a new instance of HistoriaBean
     */
    public HistoriaBean() {
        
    }

    public void inic(){
        historia = ejb.getHistoria(login.getNss());
    }
    public HistoriaClinica getHistoria() {
        return historia;
    }

    public List<Informe> getInformes() {
        return historia.getInformes();
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public void cargaInforme(int ind) {
        informe = null;
        boolean salir = false;
        for (Informe inf : historia.getInformes()) {
            if (inf.getId() == ind) {
                informe = inf;
                salir = true;
                break;
            } else {
                if (inf.getSegundasOpiniones().size() != 0) {
                    for (Informe inf2 : inf.getSegundasOpiniones()) {
                        if (inf2.getId() == ind) {
                            informe = inf2;
                            salir = true;
                            break;
                        }
                    }
                    if (salir) {
                        break;
                    }
                }
            }
        }
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    public PersonaEjb getEjb() {
        return ejb;
    }

    public void setEjb(PersonaEjb ejb) {
        this.ejb = ejb;
    }
    
}
