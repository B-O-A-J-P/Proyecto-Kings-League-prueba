package com.boajp.repositorios;

import com.boajp.modelos.DraftEntidad;
import jakarta.persistence.*;

import java.util.List;

public class DraftRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;


    public DraftRepositorio(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf. createEntityManager();

    }

    public void insertar (DraftEntidad draft) throws Exception {

        EntityTransaction transaction = em.getTransaction ();
        try {
            transaction.begin();
            em.persist(draft);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar el draft");
        }
    }

    public void eliminar (DraftEntidad draft) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        DraftEntidad d = em.find(DraftEntidad.class, draft.getRegistroJugador());
        try {
            transaction.begin();
            if (draft != null) {
                em.remove(draft);
                transaction.commit();
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el draft");
        }
    }

    public void modificar (DraftEntidad draft) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        DraftEntidad d = em.find(DraftEntidad.class, draft.getRegistroJugador());
        try {
            transaction.begin();
            if (draft != null){
                d.setRegistroJugador(draft.getRegistroJugador());
                d.setPosicion(draft.getPosicion());
                em.persist(d);
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar el split");
        }
    }

    public List<DraftEntidad> seleccionarTodosLosDrafts (){

        Query qNroDraft = em.createNativeQuery ("SELECT * FROM draft ");
        List<DraftEntidad> drafts = qNroDraft.getResultList();
        return drafts;
    }
}
