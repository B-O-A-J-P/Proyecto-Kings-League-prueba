package com.boajp.repositorios;

import com.boajp.modelo.SplitEntidad;
import com.boajp.modelo.TemporadaEntidad;
import com.boajp.servicios.TemporadasServicio;
import jakarta.persistence.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class SplitRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;


    public SplitRepositorio(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf. createEntityManager();

    }

    public void insertar (SplitEntidad split) throws Exception{
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(split);
            transaction.commit();
        } catch (Exception exception) {
            transaction.rollback();
            System.out.println(exception.getMessage());
            throw exception;
        }
    }

    public void eliminar (SplitEntidad split) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        SplitEntidad s = em.find(SplitEntidad.class, split.getCodSplit());
        try {
            transaction.begin();
            if (s != null) {
                em.remove(s);
                transaction.commit();
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el split");
        }
    }

    public void eliminar (int codigo) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        SplitEntidad s = em.find(SplitEntidad.class, codigo);
        try {
            transaction.begin();
            if (s != null) {
                em.remove(s);
                transaction.commit();
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el split");
        }
    }

    public void modificar (SplitEntidad split) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        SplitEntidad s = em.find(SplitEntidad.class, split.getCodSplit());
        try {
            transaction.begin();
            if (split != null){
                s.setNombre(split.getNombre());
                s.setFechaFin(split.getFechaFin());
                s.setFechaInicio(split.getFechaInicio());
                s.setTemporada(split.getTemporada());
                s.setListaJornadas(split.getListaJornadas());
                s.setTablaClasificaciones(split.getTablaClasificaciones());
                em.persist(s);
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar el split");
        }
    }

    public List<SplitEntidad> buscarSplits() throws Exception {
        try {
            String jpql = "SELECT s FROM SplitEntidad s";
            TypedQuery<SplitEntidad> query = em.createQuery(jpql, SplitEntidad.class);
            return query.getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer temporadas.", exception);
        }
    }

}