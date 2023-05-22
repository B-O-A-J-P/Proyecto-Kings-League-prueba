package com.boajp.repositorios;

import com.boajp.modelo.ContratoEquipoMiembroEntidad;
import jakarta.persistence.*;

import java.util.List;

public class ContratoEquipoMiembroRepositorio {

    private final EntityManagerFactory entityManagerFactory;

    public ContratoEquipoMiembroRepositorio() {
        entityManagerFactory = AdministradorPersistencia.getEntityManagerFactory();
    }

    public void insertar(ContratoEquipoMiembroEntidad contrato) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(contrato);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar insertar el contrato");
        } finally {
            entityManager.close();
        }
    }

    public void eliminar(ContratoEquipoMiembroEntidad contrato) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        ContratoEquipoMiembroEntidad c = entityManager.find(ContratoEquipoMiembroEntidad.class, contrato.getCodContrato());
        try {
            transaction.begin();
            if (c != null) {
                entityManager.remove(c);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el contrato");
        } finally {
            entityManager.close();
        }
    }

    public void modificar(ContratoEquipoMiembroEntidad contrato) throws Exception {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        ContratoEquipoMiembroEntidad c = entityManager.find(ContratoEquipoMiembroEntidad.class, contrato.getCodContrato());
        try {
            transaction.begin();
            if (c != null) {
                c.setFuncion(contrato.getFuncion());
                c.setFechaEntrada(contrato.getFechaEntrada());
                c.setFechaSalida(contrato.getFechaSalida());
                c.setEquipo(contrato.getEquipo());
                c.setMiembro(contrato.getMiembro());
                entityManager.persist(c);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar el contrato");
        } finally {
            entityManager.close();
        }
    }

    public List<ContratoEquipoMiembroEntidad> seleccionarTodosLosContratos() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.createQuery("SELECT c FROM ContratoEquipoMiembroEntidad c JOIN FETCH c.equipo JOIN FETCH c.miembro", ContratoEquipoMiembroEntidad.class)
                    .getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer contratos");
        } finally {
            entityManager.close();
        }
    }

    public ContratoEquipoMiembroEntidad seleccionarContratoPorId(int id) throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(ContratoEquipoMiembroEntidad.class, id);
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer contrato");
        } finally {
            entityManager.close();
        }
    }

    public List<ContratoEquipoMiembroEntidad> buscarContratosVigentes() throws Exception{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            String sql = "SELECT cm FROM ContratoEquipoMiembroEntidad cm WHERE (cm.fechaSalida > current_date OR cm.fechaSalida IS NULL)";
            TypedQuery<ContratoEquipoMiembroEntidad> resultado = entityManager.createQuery(sql, ContratoEquipoMiembroEntidad.class);
            return resultado.getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer contratos");
        } finally {
            entityManager.close();
        }
    }
}

