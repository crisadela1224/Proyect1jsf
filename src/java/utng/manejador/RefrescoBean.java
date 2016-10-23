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
import utng.datos.RefrescoDAO;
import utng.datos.SaborDAO;
import utng.modelo.Refresco;
import utng.modelo.Sabor;

/**
 *
 * @author user
 */
@ManagedBean(name = "refrescoBean")
@SessionScoped
public class RefrescoBean implements Serializable{
    private List<Refresco> refrescos;
    private Refresco refresco;
    private List<Sabor> sabores;
     

    public RefrescoBean() {
        refresco = new Refresco();
        refresco.setSabor(new Sabor());
    }

    public List<Refresco> getRefrescos() {
        return refrescos;
    }

    public void setRefrescos(List<Refresco> refrescos) {
        this.refrescos = refrescos;
    }

    public Refresco getRefresco() {
        return refresco;
    }

    public void setRefresco(Refresco refresco) {
        this.refresco = refresco;
    }

    public List<Sabor> getSabores() {
        return sabores;
    }

    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }
     public String listar(){
        RefrescoDAO dao = new RefrescoDAO();
        try {
            refrescos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Refrescos";
    }
    public String eliminar(){
       RefrescoDAO dao = new RefrescoDAO();
        try {
            dao.delete(refresco);
            refrescos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    public String iniciar(){
        refresco = new Refresco();
        refresco.setSabor(new Sabor());
        
        try {
            sabores = new SaborDAO().getAll();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }
    public String guardar(){
        RefrescoDAO dao = new RefrescoDAO();
        try {
            if(refresco.getIdRefresco()!= 0){
                dao.update(refresco);
            } else {
                dao.insert(refresco);
            }
            refrescos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    public String cancelar(){
        return "Cancelar";
    }
    public String editar(Refresco refresco){
        this.refresco = refresco;
        try {
            sabores = new SaborDAO().getAll();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
   
}
