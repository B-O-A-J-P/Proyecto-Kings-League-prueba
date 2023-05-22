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
        String sql = "SELECT p FROM PartidoEntidad p WHERE p.jornada.codJornada = :codigoDeJornada";
        TypedQuery<PartidoEntidad> resultado = entityManager.createQuery(sql, PartidoEntidad.class);
        resultado.setParameter("codigoDeJornada", codigoDeJornada);
        return resultado.getResultList();
    }
}
