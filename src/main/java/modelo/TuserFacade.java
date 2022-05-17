/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import entidades.Tuser;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mainfrek
 */
@Stateless
public class TuserFacade extends AbstractFacade<Tuser> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TuserFacade() {
        super(Tuser.class);
    }

    public Tuser loginTuser(String email, String password) {
        try {
            Query query = em.createQuery("SELECT t FROM Tuser t WHERE t.password = :password AND t.idProfile.email = :email", Tuser.class);

            query.setParameter("password", password);
            query.setParameter("email", email);
            Tuser tuser = (Tuser) query.getSingleResult();
            if (tuser==null) {
                return null;
            }else{
            return tuser;
            }
        } catch (Exception e) {
            return null;
        }

    }

}
