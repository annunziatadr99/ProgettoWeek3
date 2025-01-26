package com.Bibliotecario.DAO;

import com.Bibliotecario.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PrestitoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoWeek3");

    public void save(Prestito entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public Prestito findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Prestito entity = em.find(Prestito.class, id);
        em.close();
        return entity;
    }

    public List<Prestito> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Prestito> entities = em.createQuery("FROM Prestito", Prestito.class).getResultList();
        em.close();
        return entities;
    }

    public void update(Prestito entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Prestito entity = em.find(Prestito.class, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }
}
