package com.boajp.repositorios;

import com.boajp.modelo.InformacionPartidoEntidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.rmi.server.ExportException;
import java.util.List;

public class InformacionPartidoRepositorio {

    private final EntityManagerFactory entityManagerFactory;

    public InformacionPartidoRepositorio() {
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public void insertar(InformacionPartidoEntidad informacionPartido) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(informacionPartido);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar insertar la información del partido");
        } finally {
            entityManager.close();
        }
    }

    public void eliminar(InformacionPartidoEntidad informacionPartido) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        InformacionPartidoEntidad i = entityManager.find(InformacionPartidoEntidad.class, informacionPartido.getPartido().getCodPartido());
        try {
            transaction.begin();
            if (i != null) {
                entityManager.remove(i);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar eliminar la información del partido");
        } finally {
            entityManager.close();
        }
    }

    public void modificar(InformacionPartidoEntidad informacionPartido) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            var informacionPartidoEntidad = entityManager.find(InformacionPartidoEntidad.class, informacionPartido.getPartido().getCodPartido());
            if (informacionPartidoEntidad != null) {
                informacionPartidoEntidad.setNumeroGoles(informacionPartido.getNumeroGoles());
                informacionPartidoEntidad.setResultado(informacionPartido.getResultado());
                entityManager.persist(informacionPartidoEntidad);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar la información del partido");
        } finally {
            entityManager.close();
        }
    }

    public List<InformacionPartidoEntidad> seleccionarTodasLasInformacionesDePartidos() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT i FROM InformacionPartidoEntidad i", InformacionPartidoEntidad.class)
                    .getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer la información de partido");
        } finally {
            entityManager.close();
        }
    }

    public InformacionPartidoEntidad seleccionarInformacionDePartidoPorCodigo(int codigoPartido) throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(InformacionPartidoEntidad.class, codigoPartido);
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer la información de partido");
        } finally {
            entityManager.close();
        }
    }
}
