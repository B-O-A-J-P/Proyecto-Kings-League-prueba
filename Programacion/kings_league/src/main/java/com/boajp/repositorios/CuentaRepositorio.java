package com.boajp.repositorios;

import com.boajp.modelo.CuentaEntidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CuentaRepositorio {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public CuentaRepositorio() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public void insertar(CuentaEntidad cuenta) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(cuenta);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }
}
