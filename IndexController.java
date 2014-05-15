package Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entidades.Noticia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Emilio
 */
@ManagedBean
@RequestScoped
public class IndexController {

    private String usuario, passwd;
    private List<Noticia> noticias;
    
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    
    public IndexController() {
    }
    
    public String doLogin() {
        String web = "principal.xhtml";
        
        if (usuario.equalsIgnoreCase("medico")) {
            login.setNss("123456789");
            login.setTipoUsuario("MEDICO");
        } else if (usuario.equalsIgnoreCase("enfermero")) {
            login.setNss("123456789");
            login.setTipoUsuario("ENFERMERO");
        } else if (usuario.equalsIgnoreCase("adminis")) {
            login.setNss("123456789");
            login.setTipoUsuario("ADMINIS");
        } else if (usuario.equalsIgnoreCase("paciente")) {
            login.setNss("123456789");
            login.setTipoUsuario("PACIENTE");
        } else {
            web = null;
        }
        
        return web;
    }
    
  
    
    public String doLogout() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ctx.getExternalContext().invalidateSession();
        login = null;
        return "index.xhtml";
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public List<Noticia> getNoticias() {
        noticias = new ArrayList<Noticia>();
        Noticia a = new Noticia();
        a.setTitulo("Primera Noticia");
        a.setDescripcion("Esta es una noticia que aparecerá en la página principal de la aplicación");
        a.setFecha(new Date());
        noticias.add(a);
        a = new Noticia();
        a.setTitulo("Segunda Noticia");
        a.setDescripcion("Esta es una noticia que debe aparecer justo debajo de la primera en la página principal de la aplicación.");
        a.setFecha(new Date());
        noticias.add(a);
        return noticias;
    }

    public void setNoticias(List<Noticia> noticias) {
        this.noticias = noticias;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }
    
    
}
