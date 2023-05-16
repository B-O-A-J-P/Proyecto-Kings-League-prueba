package repositorios;

import jakarta.persistence.*;
import modelo.*;

import java.util.List;

public class RegistroJugadorRepositorio {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;
    private EntityTransaction transaction;

    public RegistroJugadorRepositorio() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }


    public List<RegistrosJugadoresEntidad> buscarTodosRegistrosJugadores() throws Exception {
        try {
            String jpql = "SELECT r FROM RegistrosJugadoresEntidad r";
            TypedQuery<RegistrosJugadoresEntidad> query = entityManager.createQuery(jpql, RegistrosJugadoresEntidad.class);
            return query.getResultList();
        } catch (Exception exception) {
            throw new Exception("Error al intentar extraer registros de jugadores.", exception);
        }
    }


}
