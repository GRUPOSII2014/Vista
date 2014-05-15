/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Cantidad;
import Entidades.Enumerados;
import Entidades.Medicamento;
import Entidades.Tratamiento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@RequestScoped
@ManagedBean
public class TratamientoBeans {

    private Tratamiento t;
    private List <Cantidad> listaCant;
    private String obs;
    public TratamientoBeans() {
        t=new Tratamiento();
        listaCant= new ArrayList<Cantidad>();
        
        t.setNombre("Tratamiento 1");
        
        
        
        
        t.setDescripcion("Limpieza y cura de las heridas cutáneas del paciente,"
                + "cambio de suero cada 8 horas.");
        Date inicio = new Date(2014, 05, 02);
        t.setFechaInicio(inicio);
        Date fin = new Date(2014, 05, 30);
        t.setFechaFinalizacion(fin);
        
        
        t.setTipo(Enumerados.tipoTratamiento.CURA);

        

        Medicamento m1 = new Medicamento();
        m1.setId(1);
        m1.setNombre("Ibuprofeno");
        m1.setDescripcion(" antiinflamatorio no esteroideo (AINE), utilizado frecuentemente como"
                + " antipirético y para el alivio sintomático del dolor de cabeza (cefalea), dolor "
                + "dental (odontalgia), dolor muscular o mialgia, molestias de la menstruación "
                + "(dismenorrea), dolor neurológico de carácter leve y dolor postquirúrgico");
        
        Medicamento m2 = new Medicamento();
        m2.setId(2);
        m2.setNombre("Lexatin");
        m2.setDescripcion("fármaco con acción depresora del sistema nervioso central, destinado"
                + " a disminuir o eliminar los síntomas de la ansiedad.");
        
        Medicamento m3 = new Medicamento();
        m3.setNombre("Maalox");
        m3.setId(3);
        m3.setDescripcion(" derivado del aluminio y magnesio con bajo contenido en sodio. "
                + "Posee una elevada actividad neutralizando el ácido clorhídrico que se produce"
                + " en el estómago y que es el que provoca la acidez, lo que también reduce la "
                + "formación y la actividad de la enzima pepsina que segrega el estómago.");
        
        List<Medicamento> medicamentos = new ArrayList<>();
        medicamentos.add(m1);
        medicamentos.add(m2);
        medicamentos.add(m3);
        
        Cantidad c1 = new Cantidad();
        c1.setMedicamento(m1);
        c1.setCantidad((float)3);
        Cantidad c2 = new Cantidad();
        c2.setMedicamento(m2);
        c2.setCantidad((float)2);
        Cantidad c3 = new Cantidad();
        c3.setMedicamento(m3);
        c3.setCantidad((float)1);
        listaCant.add(c1);
        listaCant.add(c2);
        listaCant.add(c3);
        
        
    }

    
    public String getNombre(){
        return getT().getNombre();
    }
    
    public String getDescripcion(){
        return getT().getDescripcion();
    }
    
    public String getFechaInicio(){
        int dia = getT().getFechaInicio().getDate();
        int mes = getT().getFechaInicio().getMonth();
        int anho = getT().getFechaInicio().getYear();
        String s = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anho);
        return s;
    }
    
    public String getFechaFinalizacion(){
        int dia = getT().getFechaFinalizacion().getDate();
        int mes = getT().getFechaFinalizacion().getMonth();
        int anho = getT().getFechaFinalizacion().getYear();
        String s = Integer.toString(dia)+"/"+Integer.toString(mes)+"/"+Integer.toString(anho);
        return s;
    }
    
    public Enumerados.tipoTratamiento getTipo(){
        return getT().getTipo();
    }

    /**
     * @return the t
     */
    public Tratamiento getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(Tratamiento t) {
        this.t = t;
    }

    /**
     * @return the listaCant
     */
    public List <Cantidad> getListaCant() {
        return listaCant;
    }

    /**
     * @param listaCant the listaCant to set
     */
    public void setListaCant(List <Cantidad> listaCant) {
        this.listaCant = listaCant;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public String terminarTratamiento(){
        return "Trabajo";
    }

    
}
