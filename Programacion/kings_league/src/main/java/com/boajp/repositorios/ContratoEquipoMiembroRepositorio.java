package com.boajp.repositorios;

import com.boajp.modelo.ContratoEquipoMiembroEntidad;
import jakarta.persistence.*;

import java.util.List;

public class ContratoEquipoMiembroRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ContratoEquipoMiembroRepositorio() {
        emf = Persistence.createEntityManagerFactory("default"); //Cambiar "default" por el nombre de su unidad de persistencia
        em = emf.createEntityManager();
    }

    public void insertar(ContratoEquipoMiembroEntidad contrato) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(contrato);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar insertar el contrato");
        }
    }

    public void eliminar(ContratoEquipoMiembroEntidad contrato) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        ContratoEquipoMiembroEntidad c = em.find(ContratoEquipoMiembroEntidad.class, contrato.getCodContrato());
        try {
            transaction.begin();
            if (c != null) {
                em.remove(c);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el contrato");
        }
    }

    public void modificar(ContratoEquipoMiembroEntidad contrato) throws Exception {
        EntityTransaction transaction = em.getTransaction();
        ContratoEquipoMiembroEntidad c = em.find(ContratoEquipoMiembroEntidad.class, contrato.getCodContrato());
        try {
            transaction.begin();
            if (c != null) {
                c.setFuncion(contrato.getFuncion());
                c.setFechaEntrada(contrato.getFechaEntrada());
                c.setFechaSalida(contrato.getFechaSalida());
                c.setEquipo(contrato.getEquipo());
                c.setMiembro(contrato.getMiembro());
                em.persist(c);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new Exception("Error al intentar modificar el contrato");
        }
    }

    public List<ContratoEquipoMiembroEntidad> seleccionarTodosLosContratos() {
        return em.createQuery("SELECT c FROM ContratoEquipoMiembroEntidad c", ContratoEquipoMiembroEntidad.class)
                .getResultList();
    }

    public ContratoEquipoMiembroEntidad seleccionarContratoPorId(int id) {
        return em.find(ContratoEquipoMiembroEntidad.class, id);
    }

    public List<ContratoEquipoMiembroEntidad> buscarContratosVigentes() {
        String sql = "SELECT cm FROM ContratoEquipoMiembroEntidad cm WHERE (cm.fechaSalida > current_date OR cm.fechaSalida IS NULL)";
        TypedQuery<ContratoEquipoMiembroEntidad> resultado = em.createQuery(sql, ContratoEquipoMiembroEntidad.class);
        return resultado.getResultList();
    }
}

