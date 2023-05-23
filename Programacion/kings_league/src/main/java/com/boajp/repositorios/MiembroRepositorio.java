package com.boajp.repositorios;

import com.boajp.modelo.MiembroEntidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class MiembroRepositorio {

    private final EntityManagerFactory entityManagerFactory;

    public MiembroRepositorio() {
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public void insertar(MiembroEntidad miembro) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(miembro);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar insertar el miembro");
        } finally {
            entityManager.close();
        }
    }

    public void eliminar(MiembroEntidad miembro) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            MiembroEntidad m = entityManager.find(MiembroEntidad.class, miembro.getCodMiembro());
            if (m != null) {
                entityManager.remove(m);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el miembro");
        } finally {
            entityManager.close();
        }
    }

    public void modificar(MiembroEntidad miembro) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            MiembroEntidad m = entityManager.find(MiembroEntidad.class, miembro.getCodMiembro());
            if (m != null) {
                m.setNombre(miembro.getNombre());
                m.setApellido(miembro.getApellido());
                entityManager.persist(m);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar el miembro");
        } finally {
            entityManager.close();
        }
    }

    public List<MiembroEntidad> seleccionarTodosLosMiembros() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT m FROM MiembroEntidad m", MiembroEntidad.class).getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer miembros");
        } finally {
            entityManager.close();
        }
    }

    public MiembroEntidad seleccionarMiembroPorId(int id) throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(MiembroEntidad.class, id);
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer miembros");
        } finally {
            entityManager.close();
        }
    }
}