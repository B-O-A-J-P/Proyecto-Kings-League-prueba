package com.boajp.repositorios;

import com.boajp.modelo.ClasificacionEntidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class ClasificacionRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ClasificacionRepositorio() {
        emf = Persistence.createEntityManagerFactory("default");
        em = emf.createEntityManager();
    }

    public void insertar(ClasificacionEntidad clasificacion) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(clasificacion);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar insertar la clasificación");
        }
    }

    public void eliminar(ClasificacionEntidad clasificacion) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        ClasificacionEntidad c = em.find(ClasificacionEntidad.class, clasificacion.getSplit());
        try {
            transaction.begin();
            if (c != null) {
                em.remove(c);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar eliminar la clasificación");
        }
    }

    public void modificar(ClasificacionEntidad clasificacion) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        ClasificacionEntidad c = em.find(ClasificacionEntidad.class, clasificacion.getSplit());
        try {
            transaction.begin();
            if (c != null) {
                c.setPosicion(clasificacion.getPosicion());
                c.setSplit(clasificacion.getSplit());
                c.setEquipo(clasificacion.getEquipo());
                em.persist(c);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar la clasificación");
        }
    }

    public List<ClasificacionEntidad> seleccionarTodasLasClasificaciones() {
        return em.createQuery("SELECT c FROM ClasificacionEntidad c", ClasificacionEntidad.class)
                .getResultList();
    }

    public ClasificacionEntidad seleccionarClasificacionPorId(int id) {
        return em.find(ClasificacionEntidad.class, id);
    }
}
