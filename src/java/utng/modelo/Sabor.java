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

/**
 *
 * @author user
 */
public class Sabor implements Serializable{
     @Id
    @GeneratedValue(
                    strategy = GenerationType.IDENTITY)
    @Column(name="id_sabor")
    private Long idSabor;
    @Column(length=30)
    private String tipo;
    @Column(length=30)
    private String descripcion;
    @Column(name="nivelSabor")
    private int nivelSabor;
    
    
     public Sabor(){
        this.idSabor = 0L;
    }

    public Long getIdSabor() {
        return idSabor;
    }

    public void setIdSabor(Long idSabor) {
        this.idSabor = idSabor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNivelSabor() {
        return nivelSabor;
    }

    public void setNivelSabor(int nivelSabor) {
        this.nivelSabor = nivelSabor;
    }
     
}
