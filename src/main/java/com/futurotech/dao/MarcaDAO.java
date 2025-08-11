package com.futurotech.dao;
import com.futurotech.model.marcadorModel;
import com.futurotech.util.JPAUtil;
import java.util.List;
import jakarta.persistence.TypedQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class MarcaDAO {

    public List<marcadorModel> obtenerTodas() {
    EntityManager em = JPAUtil.getEntityManager();
    try {
        TypedQuery<marcadorModel> query = em.createQuery("SELECT m FROM marcadorModel m", marcadorModel.class);
        return query.getResultList();
    } finally {
        em.close();
    }
}

    public void insertar(marcadorModel marcadorModel) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction(); 
        try {

            tx.begin();
            em.persist(marcadorModel);
            tx.commit();
        }catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
            
    } finally {
        em.close();


}

        }
    }

  