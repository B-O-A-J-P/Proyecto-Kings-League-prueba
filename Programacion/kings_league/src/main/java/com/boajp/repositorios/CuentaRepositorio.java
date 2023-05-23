package com.boajp.repositorios;

import com.boajp.excepciones.UsuarioNoEncontradoExcepcion;
import com.boajp.modelo.CuentaEntidad;
import jakarta.persistence.*;

public class CuentaRepositorio {
    private final EntityManagerFactory entityManagerFactory;

    public CuentaRepositorio() {
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public void insertar(CuentaEntidad cuenta) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(cuenta);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public void modificar(CuentaEntidad cuentaEntidad) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            CuentaEntidad oldCuenta = entityManager.find(CuentaEntidad.class, cuentaEntidad.getCodCuenta());
            oldCuenta.setNombreDeUsuario(cuentaEntidad.getNombreDeUsuario());
            oldCuenta.setEmail(cuentaEntidad.getEmail());
            oldCuenta.setContrasena(cuentaEntidad.getContrasena());
            entityManager.persist(oldCuenta);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public CuentaEntidad buscarCuenta(String usuario) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String sql = "SELECT c FROM CuentaEntidad c WHERE c.nombreDeUsuario = :usuario";
            TypedQuery<CuentaEntidad> resultado = entityManager.createQuery(sql, CuentaEntidad.class);
            resultado.setParameter("usuario", usuario);
            return resultado.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception exception) {
            throw new UsuarioNoEncontradoExcepcion();
        } finally {
            entityManager.close();
        }
    }
}
