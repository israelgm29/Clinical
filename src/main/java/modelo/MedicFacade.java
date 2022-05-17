/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import entidades.Medic;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mainfrek
 */
@Stateless
public class MedicFacade extends AbstractFacade<Medic> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedicFacade() {
        super(Medic.class);
    }

    public Medic loginMed(String email) {
        try {
            Query query = em.createNamedQuery("Medic.findByEmail", Medic.class);
            query.setParameter("email", email);
            Medic medic = (Medic) query.getSingleResult();
            if (medic == null) {
                return null;
            }else{
            return medic;
            }
        } catch (Exception e) {
            return null;
        }

    }

}
