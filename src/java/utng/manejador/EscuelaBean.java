/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.AlumnoDAO;
import utng.datos.EscuelaDAO;
import utng.datos.ProfesorDAO;
import utng.modelo.Alumno;
import utng.modelo.Escuela;
import utng.modelo.Profesor;

/**
 *
 * @author user
 */
@ManagedBean(name = "escuelaBean")
@SessionScoped
public class EscuelaBean implements Serializable{
    private List<Escuela> escuelas;
    private Escuela escuela;
    private List<Profesor> profesores;
     private List<Alumno> alumnos;


   
    public EscuelaBean() {
        escuela = new Escuela();
        escuela.setIdAlumno(new Alumno());
        escuela.setProfesor(new Profesor());
    }

    public List<Escuela> getEscuelas() {
        return escuelas;
    }

    public void setEscuelas(List<Escuela> escuelas) {
        this.escuelas = escuelas;
    }

    public Escuela getEscuela() {
        return escuela;
    }

    public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
    public String listar(){
        EscuelaDAO dao = new EscuelaDAO();
        try {
            escuelas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Escuelas";
    }
    public String eliminar(){
       EscuelaDAO dao = new EscuelaDAO();
        try {
            dao.delete(escuela);
            escuelas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    public String iniciar(){
        escuela = new Escuela();
        escuela.setIdAlumno(new Alumno());
        escuela.setProfesor(new Profesor());
        try {
            alumnos = new AlumnoDAO().getAll();
            profesores = new ProfesorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }
    public String guardar(){
        EscuelaDAO dao = new EscuelaDAO();
        try {
            if(escuela.getIdEscuela()!= 0){
                dao.update(escuela);
            } else {
                dao.insert(escuela);
            }
            escuelas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    public String cancelar(){
        return "Cancelar";
    }
    public String editar(Escuela escuela){
        this.escuela = escuela;
        try {
            alumnos = new AlumnoDAO().getAll();
            profesores = new ProfesorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
   
}
