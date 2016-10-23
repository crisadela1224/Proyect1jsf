/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
public class Refresco implements Serializable{
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_refresco")
    private Long idRefresco;
    @Column(name = "nombre_refresco, length = 10")
    private String nombreRefresco;
    @Column(length = 40)
    private String tipo;
    @Column(name="caloriaa")
    private int calorias;
    @ManyToOne()
    @JoinColumn(name = "id_sabor")
    private Sabor sabor;


    public Refresco(Long idRefresco, String nombreRefresco,String tipo, int calorias,Sabor sabor) {
        super();
        this.idRefresco = idRefresco;
        this.nombreRefresco = nombreRefresco;
        this.tipo=tipo;
        this.calorias=calorias;
        this.sabor=sabor;
        
    }

    public Refresco() {
        this(0L,"","",0,null);
    }

    public Long getIdRefresco() {
        return idRefresco;
    }

    public void setIdRefresco(Long idRefresco) {
        this.idRefresco = idRefresco;
    }

    public String getNombreRefresco() {
        return nombreRefresco;
    }

    public void setNombreRefresco(String nombreRefresco) {
        this.nombreRefresco = nombreRefresco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }
    
}
