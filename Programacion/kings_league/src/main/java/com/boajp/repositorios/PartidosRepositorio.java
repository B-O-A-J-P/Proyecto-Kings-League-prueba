package com.boajp.repositorios;

import com.boajp.modelo.JornadaEntidad;
import com.boajp.modelo.PartidoEntidad;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PartidosRepositorio {
    EntityManagerFactory entityManagerFactory;
    public PartidosRepositorio() {
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public List<PartidoEntidad> buscarPartidosDeJornada(JornadaEntidad jornadaEntidad) throws Exception{
        int codigoDeJornada = jornadaEntidad.getCodJornada();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            String sql = "SELECT p FROM PartidoEntidad p WHERE p.jornada.codJornada = :codigoDeJornada";
            TypedQuery<PartidoEntidad> resultado = entityManager.createQuery(sql, PartidoEntidad.class);
            resultado.setParameter("codigoDeJornada", codigoDeJornada);
            return resultado.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public List<PartidoEntidad> buscarTodosLosPartidos() throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String sql = "SELECT p FROM PartidoEntidad p JOIN FETCH p.jornada JOIN FETCH p.equipoUno JOIN FETCH p.equipoDos";
            TypedQuery<PartidoEntidad> resultado = entityManager.createQuery(sql, PartidoEntidad.class);
            return resultado.getResultList();
        } finally {
            entityManager.close();
        }
    }

}
