package com.boajp.repositorios;

import com.boajp.modelos.MiembroEntidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class MiembroRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public MiembroRepositorio() {
        emf = Persistence.createEntityManagerFactory("default"); //Cambiar "default" por el nombre de su unidad de persistencia
        em = emf.createEntityManager();
    }

    public void insertar(MiembroEntidad miembro) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(miembro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar insertar el miembro");
        }
    }

    public void eliminar(MiembroEntidad miembro) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        MiembroEntidad m = em.find(MiembroEntidad.class, miembro.getCodMiembro());
        try {
            transaction.begin();
            if (m != null) {
                em.remove(m);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el miembro");
        }
    }

    public void modificar(MiembroEntidad miembro) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        MiembroEntidad m = em.find(MiembroEntidad.class, miembro.getCodMiembro());
        try {
            transaction.begin();
            if (m != null) {
                m.setNombre(miembro.getNombre());
                m.setApellido(miembro.getApellido());
                em.persist(m);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar el miembro");
        }
    }

    public List<MiembroEntidad> seleccionarTodosLosMiembros() {
        return em.createQuery("SELECT m FROM MiembroEntidad m", MiembroEntidad.class) //Cambiar "MiembroEntidad" por el nombre de su clase de entidad
                .getResultList();
    }

    public MiembroEntidad seleccionarMiembroPorId(int id) {
        return em.find(MiembroEntidad.class, id); //Cambiar "MiembroEntidad" por el nombre de su clase de entidad
    }
}