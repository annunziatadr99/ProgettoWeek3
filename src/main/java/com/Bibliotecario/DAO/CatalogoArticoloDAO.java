package com.Bibliotecario.DAO;

import com.Bibliotecario.entities.CatalogoArticolo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CatalogoArticoloDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoWeek3");

    public void save(CatalogoArticolo entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public CatalogoArticolo findById(String id) {
        EntityManager em = emf.createEntityManager();
        CatalogoArticolo entity = em.find(CatalogoArticolo.class, id);
        em.close();
        return entity;
    }

    public List<CatalogoArticolo> findAll() {
        EntityManager em = emf.createEntityManager();
        List<CatalogoArticolo> entities = em.createQuery("FROM CatalogoArticolo", CatalogoArticolo.class).getResultList();
        em.close();
        return entities;
    }

    public void update(CatalogoArticolo entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CatalogoArticolo entity = em.find(CatalogoArticolo.class, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }
}
