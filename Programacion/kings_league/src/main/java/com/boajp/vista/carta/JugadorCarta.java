package com.boajp.vista.carta;

import com.boajp.modelo.JugadorEntidad;
import com.boajp.utilidades.EstilosDeVistas;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class JugadorCarta extends CartaAbstracta{
    private int anchura = 300;
    private int altura = 400;
    private Dimension dimension = new Dimension(anchura, altura);
    private Insets insets = new Insets(10, 10, 10, 10);

    public JugadorCarta(String nombreCompleto, HashMap<String, String> caracteristicasJugador) {
        super(EstilosDeVistas.COLOR_DE_CARTA_JUGADOR, Color.GRAY);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

        setLayout(new GridBagLayout());
        GridBagConstraints constraintsTitulo = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        GridBagConstraints constraintsImagen = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
        GridBagConstraints constraintsCaracteristicas = new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);

        Image image = new ImageIcon(JugadorCarta.class.getResource("/imagenes/perfil.png")).getImage();

        add(new JLabel(nombreCompleto, JLabel.CENTER), constraintsTitulo);
        add(new JLabel(new ImageIcon(image), JLabel.CENTER), constraintsImagen);
        String car = "";
        for ( String llave : caracteristicasJugador.keySet() ) {
            car += llave + " " + caracteristicasJugador.get(llave) + " || ";
        }
        add(new JLabel(car, JLabel.CENTER), constraintsCaracteristicas);
    }

    @Override
    public int getAnchura() {
        return anchura;
    }

    @Override
    public int getAltura() {
        return altura;
    }
}

