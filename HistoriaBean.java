/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Entidades.Enumerados;
import Entidades.HistoriaClinica;
import Entidades.Informe;
import Entidades.Medico;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.jboss.weld.context.RequestContext;

/**
 *
 * @author PyRoS
 */
@ManagedBean
@ViewScoped
public class HistoriaBean {

    private HistoriaClinica historia = new HistoriaClinica();
    private Informe informe = null;

    /**
     * Creates a new instance of HistoriaBean
     */
    public HistoriaBean() {
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
        informes.add(i);

        informes.add(i3);
        historia.setInformes(informes);
    }

    public HistoriaClinica getHistoria() {
        return historia;
    }

    public void setHistoria(HistoriaClinica historia) {
        this.historia = historia;
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
}
