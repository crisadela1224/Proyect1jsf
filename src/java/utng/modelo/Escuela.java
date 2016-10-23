/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity @Table(name = "escuela")
public class Escuela implements Serializable{
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_escuela")
    private Long idEscuela;
    @Column(name = "nombre_escuela", length = 10)
    private String nombreEscuela;
    @Column(length = 40)
    private String direccion;
    @Column(name="NumeroAlumnos")
    private int numeroAlumnos;
    @ManyToOne()
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;
    @ManyToOne()
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    public Escuela(Long idEscuela, String nombreEscuela,String direccion, int numeroAlumnos,Profesor profesor,Alumno alumno) {
        super();
        this.idEscuela = idEscuela;
        this.nombreEscuela = nombreEscuela;
        this.direccion=direccion;
        this.numeroAlumnos=numeroAlumnos;
        this.profesor=profesor;
        this.alumno=alumno;
    }

    public Escuela() {
        this(0L,"","",0,null,null);
    }

    public Long getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Long idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombreEscuela() {
        return nombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        this.nombreEscuela = nombreEscuela;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroAlumnos() {
        return numeroAlumnos;
    }

    public void setNumeroAlumnos(int numeroAlumnos) {
        this.numeroAlumnos = numeroAlumnos;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Alumno getIdAlumno() {
        return alumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.alumno = idAlumno;
    }

  

}