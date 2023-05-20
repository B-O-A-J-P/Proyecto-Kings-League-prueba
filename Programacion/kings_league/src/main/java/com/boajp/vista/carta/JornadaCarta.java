package com.boajp.vista.carta;

import javax.swing.*;
import java.awt.*;

public class JornadaCarta extends CartaAbstracta {
    private JLabel cabecera;
    private JPanel cuerpo;
    private int anchura = 400;
    private int altura = 400;
    private GridBagConstraints constraintCabecera = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 0, 0), 0, 0);
    private GridBagConstraints constraintCuerpo = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 20, 20, 20), 0, 0);
    private String[][] datosDePartidos;

    public JornadaCarta(int numeroDeJornada, String fechaDeJornada, String[][] partidos) {
        setLayout(new GridBagLayout());
        datosDePartidos = partidos;

        setMinimumSize(new Dimension(anchura, altura));
        setPreferredSize(new Dimension(anchura, altura));
        setMaximumSize(new Dimension(anchura, altura));

        cabecera = new JLabel("<html><div style='text-align: center;'>Jornada " + numeroDeJornada + "<p>" + fechaDeJornada + "</p></div></html>", JLabel.CENTER);

        add(cabecera, constraintCabecera);
    }

    public void crearCuerpo() {
        cuerpo = new JPanel(new GridLayout(datosDePartidos.length, datosDePartidos[0].length));
        cuerpo.setBackground(super.getColorPorDefecto());

        for ( String[] partido : datosDePartidos ) {
            for (String informacion : partido) {
                cuerpo.add(new JLabel(informacion, JLabel.CENTER));
            }
        }
        this.add(cuerpo, constraintCuerpo);
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

