package com.boajp.repositorios;

import com.boajp.modelo.RegistroEquipoEntidad;
import com.boajp.modelo.SplitEntidad;
import jakarta.persistence.*;
import jakarta.persistence.*;
public class RegistroEquipoRespositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;


    public RegistroEquipoRespositorio(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf. createEntityManager();

    }
    public void insertar (RegistroEquipoEntidad registroEquipo) throws Exception {

        EntityTransaction transaction = em.getTransaction ();
        try {
            transaction.begin();
            em.persist(registroEquipo);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar un equipo participante");
        }
    }
    public void eliminar (RegistroEquipoEntidad registroEquipo) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        RegistroEquipoEntidad r = em.find(RegistroEquipoEntidad.class, registroEquipo.getTemporada());
        try {
            transaction.begin();
            if (registroEquipo != null) {
                em.remove(registroEquipo);
                transaction.commit();
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el equipo participante");
        }
    }

    public void modificar (RegistroEquipoEntidad registroEquipo) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        RegistroEquipoEntidad r = em.find(RegistroEquipoEntidad.class, registroEquipo.getTemporada());
        try {
            transaction.begin();
            if (registroEquipo != null){
                r.setEquipo(registroEquipo.getEquipo());
                r.setTemporada(registroEquipo.getTemporada());
                em.persist(r);
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar el equipo participante");
        }
    }

    public void seleccionarTodosLosEquiposParticipantes (){
        EntityTransaction transaction = em.getTransaction ();
        transaction.begin();
        Query qEquiposParticipantes = em.createNativeQuery ("SELECT DISTINCT cod_equipo FROM equipos_participantes");
    }

    public void seleccionarCantidadEquiposParticipantes(){
        EntityTransaction transaction = em.getTransaction ();
        transaction.begin();
        Query qNroEquiposParticipantes = em.createNativeQuery ("SELECT COUNT(DISTINCT cod_equipo) FROM equipos_participantes ");
    }

    }



