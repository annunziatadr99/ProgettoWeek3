package com.Bibliotecario.DAO;

import com.Bibliotecario.entities.Rivista;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RivistaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoWeek3");

    public void save(Rivista entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public Rivista findById(String id) {
        EntityManager em = emf.createEntityManager();
        Rivista entity = em.find(Rivista.class, id);
        em.close();
        return entity;
    }

    public List<Rivista> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Rivista> entities = em.createQuery("FROM Rivista", Rivista.class).getResultList();
        em.close();
        return entities;
    }

    public void update(Rivista entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Rivista entity = em.find(Rivista.class, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }

}
