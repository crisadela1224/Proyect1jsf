/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Refresco;

/**
 *
 * @author user
 */
public class RefrescoDAO extends DAO<Refresco>{
    public RefrescoDAO(){
        super(new Refresco());
    }
    
    public Refresco getOneById(Refresco refresco)
            throws HibernateException{
        return super.getOneById(refresco.getIdRefresco());
    }
}
