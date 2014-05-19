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

    private Persona p1 = inic();
    @EJB
    private PersonaEjb pers;
    private List<Medicamento> medicamentos;
    private int seleccionado;
    private float cantidad;
    private String res;
    private List<Cantidad> tratamientos=new ArrayList<>();
    private Informe informe=new Informe();
    private int var;
    private HistoriaClinica historia = inicHist();
    private List<Informe> informes;
   
  
    @ManagedProperty(value = "#{loginController}")
    private LoginController login;
    
    public DiagnosticoBeans() {

        p1 = new Persona();
        p1.setDNI("45355678f");
        p1.setNumSegSocial(444457);
        p1.setNombre("juanito");
        p1.setApellido1("claverias");
        p1.setApellido2("gonzalez");
        p1.setEmail("persona1@h.com");
        p1.setEstadoCivil("soltero");
        p1.setTelefono("988544346");
        p1.setDireccion("callemarmoles");
        p1.setCodigoPostal(13335);
        p1.setCiudad("Jaen");
        p1.setPais("España");
        p1.setSexo("V");

        Cantidad c = new Cantidad();
        c.setCantidad(12F);
        Cantidad c2 = new Cantidad();
        c2.setCantidad(13F);
        medicamentos = new ArrayList<>();
        Medicamento m1 = new Medicamento();
        m1.setId(Integer.SIZE);
        m1.setNombre("Ibuprofeno");
        m1.setDescripcion("Se utiliza para tratar dolores musculares");

        medicamentos.add(m1);

        Medicamento m2 = new Medicamento();
        m2.setId(Integer.SIZE);
        m2.setNombre("Paracetamol");
        m2.setDescripcion("Para el resfriado");

        medicamentos.add(m2);
        
        historia.setGrupoSanguineo("0");
        historia.setObservaciones("Prueba");
        historia.setFechaNacimiento(null);
        Medico medico = new Medico();
        medico.setPassword("micontraseña");
        medico.setEmail("alberto@gmail.com");
        medico.setNombre("Alberto");
        medico.setApellido1("Sanchez");
        medico.setApellido2("Muñoz");
        medico.setDNI("23232314h");
        medico.setNumSegSocial(1);
        medico.setEstadoCivil("Casado");
        medico.setPais("España");
        medico.setCiudad("Malaga");
        medico.setCodigoPostal(29009);
        medico.setDireccion("Calle Pepito");
        medico.setTelefono("954321123");
        medico.setActivo(true);
        medico.setSexo("V");
        medico.setTipo(Enumerados.tipoTrabajador.MEDICO);
        medico.setDespacho("3.3.3");

        Informe i = new Informe();
        i.setId(1);
        i.setTipo(Enumerados.tipoInforme.INGRESO);
        i.setFecha(Date.valueOf("1992-2-10"));
        i.setMedico(medico);
        i.setObservaciones("Se ha detectado una masa anomala adsasda sdas da sdas dasdasdada sdasdadasd asdasdads asdasdasd asdasdad asda sdasdasdas dasdasdasdasd en el estomago");
        Informe i2 = new Informe();
        i2.setId(2);
        i2.setTipo(Enumerados.tipoInforme.INGRESO);
        i2.setFecha(Date.valueOf("1992-2-10"));
        i2.setMedico(medico);
        i2.setObservaciones("La masa parece ser grasa acumulada");
        ArrayList<Informe> segOp = new ArrayList<>();
        segOp.add(i2);
        i.setSegundasOpiniones(segOp);
        Informe i3 = new Informe();
        i3.setId(3);
        i3.setTipo(Enumerados.tipoInforme.INGRESO);
        i3.setFecha(Date.valueOf("1992-2-10"));
        i3.setMedico(medico);
        i3.setObservaciones("La masa parece ser grasa acumulada");
        ArrayList<Informe> informes = new ArrayList<>();
        Informe i4 = new Informe();
        i4.setFecha(null);
        informes.add(i4);
        informes.add(i);

        informes.add(i3);
        historia.setInformes(informes);
        
    }

    public int getVar() {
        return var;
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
    
    public Persona inic(){
        
        Persona p = pers.getPersona(login.getBuscado());
        return p;
        
    }
    
    public HistoriaClinica inicHist(){
        return p1.getHistoriaclinica();
              
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
