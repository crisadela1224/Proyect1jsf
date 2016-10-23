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
import utng.datos.SaborDAO;
import utng.modelo.Sabor;

/**
 *
 * @author user
 */
@ManagedBean
@SessionScoped
public class SaborBean implements Serializable{
    private List<Sabor> sabores;
    private Sabor sabor;
    
     public SaborBean() {
    }

    public List<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }
     
public String listar(){
        SaborDAO dao = new SaborDAO();
        try {
            sabores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sabores";
    }
    
    public String eliminar(){
        SaborDAO dao = new SaborDAO();
        try {
            dao.delete(sabor);
            sabores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        sabor = new Sabor();
        return "Iniciar";
    }
    
      public String guardar(){
        SaborDAO dao = new SaborDAO();
        try {
            if(sabor.getIdSabor()!= 0){
                dao.update(sabor);
            } else {
                dao.insert(sabor);
            }
           sabores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    public String cancelar(){
        return "cancelar";
    }
    public String editar(Sabor sabor){
        this.sabor = sabor;
        return "Editar";
    }
    
}

