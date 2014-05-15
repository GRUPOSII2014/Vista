package Vista;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Ejb.NoticiasImpl;
import Ejb.PersonaEjb;
import Entidades.Noticia;
import Entidades.Persona;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
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

    private Integer usuario;
    private String passwd;
    
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    
    @EJB
    private NoticiasImpl noticias;
    
    @EJB
    private PersonaEjb persona;

    public IndexController() {
    }

    public String doLogin() {
        String web = "principal.xhtml";
        Persona p = persona.compruebaPersona(usuario, passwd);
        
        if (p != null) {
            login.setNss(p.getNumSegSocial());
            login.setTipoUsuario(p.getDisc());
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error", "No existe el usuario o no coinciden las credenciales."));
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

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public List<Noticia> getNoticias() {
        return noticias.allNoticias();
    }
    
    public void setLogin(LoginController login) {
        this.login = login;
    }

}
