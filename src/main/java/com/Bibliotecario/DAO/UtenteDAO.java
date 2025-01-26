package com.Bibliotecario.DAO;

import com.Bibliotecario.entities.Utente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UtenteDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProgettoWeek3");

    public void save(Utente entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public Utente findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Utente entity = em.find(Utente.class, id);
        em.close();
        return entity;
    }

    public List<Utente> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Utente> entities = em.createQuery("FROM Utente", Utente.class).getResultList();
        em.close();
        return entities;
    }

    public void update(Utente entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Utente entity = em.find(Utente.class, id);
        if (entity != null) {
            em.remove(entity);
        }
        em.getTransaction().commit();
        em.close();
    }
}
