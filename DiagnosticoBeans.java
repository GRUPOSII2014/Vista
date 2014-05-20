/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Ejb.DiagnosticoEjb;
import Ejb.MedicamentosEjb;
import Ejb.PersonaEjb;
import Entidades.Cantidad;
import Entidades.Enumerados;
import Entidades.HistoriaClinica;
import Entidades.Informe;
import Entidades.Medicamento;
import Entidades.Medico;
import Entidades.Persona;
import Entidades.Tratamiento;
import java.util.ArrayList;
import java.util.Calendar;
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
    private String var2;
    private int var3;
    private HistoriaClinica historia;
    private List<Informe> informes = new ArrayList<>();
    private Persona p1;
    
    @EJB
    private PersonaEjb pers;
    
    @EJB
    private MedicamentosEjb medic;
    
    @EJB
    private DiagnosticoEjb diag;
   
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    
    public DiagnosticoBeans() {
    }

    public String inic(){
        p1 = pers.getPersona(2); // Cambiar a pers.buscado()
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
        //login.setBuscado(login.getNss()); //paciente
        Medico me = new Medico();
        me.setNumSegSocial(login.getNss());
        login.setBuscado(2);
        trata.setTipo(Enumerados.tipoTratamiento.valueOf(var2));
        trata.setPersona(p1);
        diag.creaTratamiento(trata);
        informe.setTratamiento(trata);
        informe.setMedico(me);
        informe.setFecha(Calendar.getInstance().getTime());
        informe.setTipo(Enumerados.tipoInforme.DIAGNOSTICO);       
        
        if(var==0){
            diag.anadeInf(informe);
        }else{
            List<Informe> segundasopiniones = new ArrayList<>();
            segundasopiniones.add(informe);
            informe.setSegundasOpiniones(segundasopiniones);
            diag.anadeSegOp(informe);
        } 
        return "Trabajo.xhtml";
    }

    public int getVar3() {
        return var3;
    }

    public void setVar3(int var3) {
        this.var3 = var3;
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
        c.setMedicamento(medic.getMedicamento().get(var3-1));
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
    
    
     public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }
    private Tratamiento trata = new Tratamiento();

    public Tratamiento getTrata() {
        return trata;
    }

    public void setTrata(Tratamiento trata) {
        this.trata = trata;
    }

    public MedicamentosEjb getMedic() {
        return medic;
    }

    public void setMedic(MedicamentosEjb medic) {
        this.medic = medic;
    }

    public DiagnosticoEjb getDiag() {
        return diag;
    }

    public void setDiag(DiagnosticoEjb diag) {
        this.diag = diag;
    }
    
    
}

