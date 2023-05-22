package com.boajp.repositorios;

import com.boajp.modelo.InformacionPartidoEntidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class InformacionPartidoRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public InformacionPartidoRepositorio() {
        emf = Persistence.createEntityManagerFactory("default"); //Cambiar "default" por el nombre de su unidad de persistencia
        em = emf.createEntityManager();
    }

    public void insertar(InformacionPartidoEntidad informacionPartido) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(informacionPartido);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar insertar la información del partido");
        }
    }

    public void eliminar(InformacionPartidoEntidad informacionPartido) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        InformacionPartidoEntidad i = em.find(InformacionPartidoEntidad.class, informacionPartido.getPartido().getCodPartido());
        try {
            transaction.begin();
            if (i != null) {
                em.remove(i);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar eliminar la información del partido");
        }
    }

    public void modificar(InformacionPartidoEntidad informacionPartido) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        InformacionPartidoEntidad i = em.find(InformacionPartidoEntidad.class, informacionPartido.getPartido().getCodPartido());
        try {
            transaction.begin();
            if (i != null) {
                i.setNumeroGoles(informacionPartido.getNumeroGoles());
                i.setResultado(informacionPartido.getResultado());
                em.persist(i);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar la información del partido");
        }
    }

    public List<InformacionPartidoEntidad> seleccionarTodasLasInformacionesDePartidos() {
        return em.createQuery("SELECT i FROM InformacionPartidoEntidad i", InformacionPartidoEntidad.class)
                .getResultList();
    }

    public InformacionPartidoEntidad seleccionarInformacionDePartidoPorCodigo(int codigoPartido) {
        return em.find(InformacionPartidoEntidad.class, codigoPartido);
    }
}
