

import modelo.RegistrosJugadoresEntidad;
import repositorios.RegistroJugadorRepositorio;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Aplicacion {

    static public void main(String... args) {

        RegistroJugadorRepositorio registroJugadorRepositorio = new RegistroJugadorRepositorio();
        List<RegistrosJugadoresEntidad> registroJugadorEntidads = new ArrayList<>();
        try {
            registroJugadorEntidads = registroJugadorRepositorio.buscarTodosRegistrosJugadores();
        }catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getClass() + "\n" + exception.getMessage());
        }

        for (RegistrosJugadoresEntidad registroJugadorEntidad : registroJugadorEntidads) {
            System.out.println(registroJugadorEntidad.getJugadoresByCodJugador().getCodJugador());
        }
    }

}
