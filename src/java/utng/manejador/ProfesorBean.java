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
import utng.datos.ProfesorDAO;
import utng.modelo.Profesor;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class ProfesorBean implements Serializable{
        private List<Profesor> profesores;
    private Profesor profesor;

    /**
     * Creates a new instance of RolBean
     */
    public ProfesorBean() {
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
    
    public String listar(){
        ProfesorDAO dao = new ProfesorDAO();
        try {
            profesores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Profesores";
    }
    
    public String eliminar(){
        ProfesorDAO dao = new ProfesorDAO();
        try {
            dao.delete(profesor);
            profesores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        profesor = new Profesor();
        return "Iniciar";
    }
    
      public String guardar(){
        ProfesorDAO dao = new ProfesorDAO();
        try {
            if(profesor.getIdProfesor()!= 0){
                dao.update(profesor);
            } else {
                dao.insert(profesor);
            }
           profesores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    public String cancelar(){
        return "cancelar";
    }
    public String editar(Profesor profesor){
        this.profesor = profesor;
        return "Editar";
    }
    
}
