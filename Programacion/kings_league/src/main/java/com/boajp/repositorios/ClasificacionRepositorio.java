package com.boajp.repositorios;

import com.boajp.modelo.ClasificacionEntidad;
import com.boajp.modelo.SplitEntidad;
import jakarta.persistence.*;

public class ClasificacionRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;


    public ClasificacionRepositorio(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf. createEntityManager();

    }

    public void insertar (ClasificacionEntidad clasificacion) throws Exception {

        EntityTransaction transaction = em.getTransaction ();
        try {
            transaction.begin();
            em.persist(clasificacion);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar la clasificacion");
        }
    }

    public void eliminar (ClasificacionEntidad clasificacion) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        ClasificacionEntidad c = em.find(ClasificacionEntidad.class, clasificacion.getSplit());
        try {
            transaction.begin();
            if (clasificacion != null) {
                em.remove(clasificacion);
                transaction.commit();
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar la clasificacion");
        }
    }

    public void modificar (ClasificacionEntidad clasificacion) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        ClasificacionEntidad c = em.find(ClasificacionEntidad.class, clasificacion.getSplit());
        try {
            transaction.begin();
            if (clasificacion != null){
                c.setSplit(clasificacion.getSplit());
                c.setEquipo(clasificacion.getEquipo());
                c.setPosicion(clasificacion.getPosicion());
                em.persist(c);
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar la clasificacion");
        }
    }

    public void seleccionarTodosLasClasificaciones (){
        EntityTransaction transaction = em.getTransaction ();
        transaction.begin();
        Query qNroClasificacion = em.createNativeQuery ("SELECT * FROM clasificaciones ");
    }
}
