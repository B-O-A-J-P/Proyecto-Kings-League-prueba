package com.boajp.repositorios;

import com.boajp.excepciones.UsuarioNoEncontradoExcepcion;
import com.boajp.modelo.CuentaEntidad;
import jakarta.persistence.*;

public class CuentaRepositorio {
    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private EntityTransaction transaction;

    public CuentaRepositorio() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void insertar(CuentaEntidad cuenta) throws Exception {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(cuenta);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        }
    }

    public CuentaEntidad buscarCuenta(String usuario) throws Exception {
        try {
            String sql = "SELECT c FROM CuentaEntidad c WHERE c.usuario = :usuario";
            TypedQuery<CuentaEntidad> resultado = entityManager.createQuery(sql, CuentaEntidad.class);
            resultado.setParameter("usuario", usuario);
            return resultado.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception exception) {
            throw new UsuarioNoEncontradoExcepcion();
        }
    }


}
