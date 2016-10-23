/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Sabor;

/**
 *
 * @author user
 */
public class SaborDAO extends DAO<Sabor>{
    public SaborDAO(){
        super(new Sabor());
    }
    
    public Sabor getOneById(Sabor sabor)
            throws HibernateException{
        return super.getOneById(
                        sabor.getIdSabor());
    }
}
