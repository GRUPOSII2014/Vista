/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;



import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@Dependent
public class CambiarClaveBeans {
    private String actual,nueva,nueva2;
    
    /**
     * Creates a new instance of CambiarClave
     */
    public CambiarClaveBeans() {
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public String getNueva() {
        return nueva;
    }

    public void setNueva(String nueva) {
        this.nueva = nueva;
    }

    public String getNueva2() {
        return nueva2;
    }

    public void setNueva2(String nueva2) {
        this.nueva2 = nueva2;
    }
    
    public void doCambiarClave(ActionEvent actionEvent){
         FacesContext context = FacesContext.getCurrentInstance();  
         if(nueva.equalsIgnoreCase(nueva2)){
            context.addMessage(null, new FacesMessage("Exito", "Se ha cambiado la clave correctamente")); 
         }else{
             context.addMessage(null, new FacesMessage("Error", "Las contraseñas no coinciden"));
         }
    }
    
}
