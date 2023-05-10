package com.boajp.repositorios;

import com.boajp.modelo.ContratoEquipoJugadorEntidad;
import com.boajp.modelo.SplitEntidad;
import jakarta.persistence.*;

public class ContratoEquipoJugadorRepositorio {

    private final EntityManagerFactory emf;
    private final EntityManager em;


    public ContratoEquipoJugadorRepositorio(){
        emf = Persistence.createEntityManagerFactory("default");
        em = emf. createEntityManager();

    }

    public void insertar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {

        EntityTransaction transaction = em.getTransaction ();
        try {
            transaction.begin();
            em.persist(contratojugador);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar insertar el contrato del jugador");
        }
    }

    public void eliminar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        ContratoEquipoJugadorEntidad c = em.find(ContratoEquipoJugadorEntidad.class, contratojugador.getCodContrato());
        try {
            transaction.begin();
            if (contratojugador != null) {
                em.remove(contratojugador);
                transaction.commit();
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar eliminar el contrato del jugador");
        }
    }

    public void modificar (ContratoEquipoJugadorEntidad contratojugador) throws Exception {
        EntityTransaction transaction = em.getTransaction ();
        ContratoEquipoJugadorEntidad c = em.find(ContratoEquipoJugadorEntidad.class, contratojugador.getCodContrato());
        try {
            transaction.begin();
            if (contratojugador != null){
                c.setEquipo(contratojugador.getEquipo());
                c.setJugador(contratojugador.getJugador());
                c.setClausula(contratojugador.getClausula());
                c.setSalario(contratojugador.getSalario());
                c.setFechaInicio(contratojugador.getFechaInicio());
                c.setFechaFin(contratojugador.getFechaFin());
                em.persist(c);
            }
        }catch (Exception exception){
            transaction.rollback();
            throw new Exception("Error al intentar modificar el contrato del jugador");
        }
    }

    public void seleccionarTodosLosContratosDeJugador (){
        EntityTransaction transaction = em.getTransaction ();
        transaction.begin();
        Query qNroCont_equi = em.createNativeQuery ("SELECT * FROM contratos_equipo_jugador ");
    }

    public void seleccionarSalarioPorEquipo (){
        EntityTransaction transaction = em.getTransaction ();
        transaction.begin();
        Query qNroCont_equi = em.createNativeQuery ("SELECT cod_equipo, SUM(salario) as salario_total_del_equipo\n" +
                "    FROM contratos_equipo_jugador\n" +
                "    GROUP BY cod_equipo ");
    }

    public void seleccionarSalarioPorJugador (){
        EntityTransaction transaction = em.getTransaction ();
        transaction.begin();
        Query qNroCont_equi = em.createNativeQuery ("SELECT *\n" +
                "FROM contratos_equipo_jugador\n" +
                "ORDER BY fecha_inicio");
    }

    public void seleccionarPorFechaDeContrato (){
        EntityTransaction transaction = em.getTransaction ();
        transaction.begin();
        Query qNroCont_equi = em.createNativeQuery ("SELECT cod_jugador, SUM(salario) as salario_total\n" +
                "FROM contratos_equipo_jugador\n" +
                "GROUP BY cod_jugador ");
    }



}
