package es.albarregas.beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity

@Table(name = "profesores")
public class Profesor implements Serializable{
    
    @EmbeddedId
    private Codigo codigo;
    @GeneratedValue(strategy = IDENTITY)
    
    @Column(name = "idProf")
    private int idProf;

    @Column(name = "nombre", length = 20, nullable = true)
    private String nombre;
    
    @Column(name = "ape1", length = 15, nullable = true)
    private String ape1;
    
    @Column(name = "ape2", length = 15, nullable = false)
    private String ape2;
    
    @Column(name = "escala", columnDefinition="set('s', 't') default 's'", insertable=false, updatable=true)
    private String escala;
    
    @Column(name = "fecha", columnDefinition="datetime default now()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }


    
}
