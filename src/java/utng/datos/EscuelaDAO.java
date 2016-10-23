/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Escuela;

/**
 *
 * @author user
 */
public class EscuelaDAO extends DAO<Escuela>{
    public EscuelaDAO(){
        super(new Escuela());
    }
    
    public Escuela getOneById(Escuela escuela)
            throws HibernateException{
        return super.getOneById(escuela.getIdEscuela());
    }
}
