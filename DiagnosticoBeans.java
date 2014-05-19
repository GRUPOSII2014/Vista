/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.PersonaEjb;
import Entidades.Cantidad;
import Entidades.Enumerados;
import Entidades.HistoriaClinica;
import Entidades.Informe;
import Entidades.Medicamento;
import Entidades.Medico;
import Entidades.Persona;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@ViewScoped
public class DiagnosticoBeans {

    private List<Medicamento> medicamentos;
    private int seleccionado;
    private float cantidad;
    private String res;
    private List<Cantidad> tratamientos=new ArrayList<>();
    private Informe informe=new Informe();
    private int var;
    
    private HistoriaClinica historia;
    private List<Informe> informes = new ArrayList<>();
    private Persona p1;
    
    @EJB
    private PersonaEjb pers;
   
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    
    public DiagnosticoBeans() {
    }

    public String inic(){
        p1 = pers.getPersona(2);
        return "Inic";
    }

    public int getVar() {
        return var;
    }
    
    public int tamInformes(){
        return p1.getHistoriaclinica().getInformes().size()-1;
    }
    
    public Informe informePorInd(int i){
        return p1.getHistoriaclinica().getInformes().get(i);
    }

    public void setVar(int var) {
        this.var = var;
    }

    
    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }
    
    public Persona getP1() {
        return p1;
    }

    public void setP1(Persona p1) {
        this.p1 = p1;
    }
    
    public Persona getPersona() {

        return this.p1;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public int getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(int seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    public List<Cantidad> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Cantidad> tratamientos) {
        this.tratamientos = tratamientos;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
    
    public String terminarDiagnostico(){
        return "Trabajo.xhtml";
    }
    
    public String eliminar(int id){
        int ind = 0;
        boolean eliminar = false;
        for (Cantidad c : tratamientos){
            if(c.getMedicamento().getId()==id){
                eliminar = true;
                break;
            }
            ind++;
        }
        if (eliminar) tratamientos.remove(ind);
        return "null";
    }
    
    public String anadirTratamiento(){
        Cantidad c = new Cantidad();
        
        c.setCantidad(cantidad);
        c.setMedicamento(medicamentos.get(seleccionado));
        tratamientos.add(c);
        return "null";
    }
    public String verHistoria(){
        return "HistoriaClinica";
    }

    public HistoriaClinica getHistoria() {
        return historia;
    }

    public void setHistoria(HistoriaClinica historia) {
        this.historia = historia;
    }

    public LoginController getLogin() {
        return login;
    }

    public void setLogin(LoginController login) {
        this.login = login;
    }
    
    public PersonaEjb getPers() {
        return pers;
    }


    public void setPers(PersonaEjb pers) {
        this.pers = pers;
    }

    public List<Informe> getInformes() {
        for(Informe e : p1.getHistoriaclinica().getInformes()){
            informes.add(e);  
        }
        return  informes;
    }

    public void setInformes(List<Informe> informes) {
        this.informes = informes;
    }
}

