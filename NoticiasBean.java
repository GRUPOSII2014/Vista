/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Ejb.NoticiasEJB;
import Ejb.PersonaEjb;
import Entidades.Noticia;
import Entidades.Trabajador;
import java.util.Date;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Emilio
 */
@ManagedBean
@RequestScoped
public class NoticiasBean {

    private String titulo, noticia;
    
    @ManagedProperty(value = "#{LoginController}")
    private LoginController login;
    
    @EJB
    private NoticiasEJB noticias;
    
    /**
     * Creates a new instance of NoticiasBean
     */
    public NoticiasBean() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNoticia() {
        return noticia;
    }

    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }
    
    public String doNoticia() {
        Noticia n = new Noticia();
        n.setDescripcion(noticia);
        n.setTitulo(titulo);
        n.setFecha(new Date());
        noticias.setNoticia(n, login.getNss());
        
        return null;
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }

    public NoticiasEJB getNoticias() {
        return noticias;
    }

    public void setNoticias(NoticiasEJB noticias) {
        this.noticias = noticias;
    }
   
}
