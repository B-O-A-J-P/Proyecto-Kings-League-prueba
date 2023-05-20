package com.boajp.repositorios;

import com.boajp.modelo.AgendaEntidad;
import jakarta.persistence.*;

import java.util.List;

public class AgendaRepositorio {
    private final EntityManagerFactory emf;
    private final EntityManager em;


    public AgendaRepositorio(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf. createEntityManager();

    }

    public void insertar (AgendaEntidad agenda) throws Exception {

        EntityTransaction transaction = em.getTransaction ();
        try {
            transaction.begin();
            em.persist(agenda);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar la agenda");
        }
    }

    public void eliminar (AgendaEntidad agenda) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        AgendaEntidad a = em.find(AgendaEntidad.class, agenda.getCodAgenda());
        try {
            transaction.begin();
            if (agenda != null) {
                em.remove(agenda);
                transaction.commit();
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar la agenda");
        }
    }

    public void modificar (AgendaEntidad agenda) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        AgendaEntidad a = em.find(AgendaEntidad.class, agenda.getCodAgenda());
        try {
            transaction.begin();
            if (agenda != null){
                a.setEmail(agenda.getEmail());
                a.setTelefono(agenda.getTelefono());
                em.persist(a);
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar la agenda");
        }
    }

    public  List<AgendaEntidad> seleccionarTodosLasAgendas(){

        Query qNroAgendas = em.createNativeQuery ("SELECT * FROM agendas ");
        List<AgendaEntidad> agendas = qNroAgendas.getResultList();
        return agendas;

    }
}
