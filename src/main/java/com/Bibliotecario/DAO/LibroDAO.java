package com.Bibliotecario.DAO;

import com.Bibliotecario.entities.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LibroDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoWeek3");

    public void save(Libro entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }
    public Libro findById(String id) {
        EntityManager em = emf.createEntityManager();
        Libro entity = em.find(Libro.class, id);
        em.close();
        return entity;
    }

    public List<Libro> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Libro> entities = em.createQuery("FROM Libro", Libro.class).getResultList();
        em.close();
        return entities;
    }

    public void update(Libro entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Libro entity = em.find(Libro.class, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }
}
