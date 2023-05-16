package com.boajp.vista.carta;

import com.boajp.modelo.JornadaEntidad;
import com.boajp.modelo.PartidoEntidad;
import com.boajp.utilidades.EstilosDeVistas;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JornadaCarta extends CartaAbstracta {
    private JLabel cabecera;
    private JPanel cuerpo;
    private int anchura = 400;
    private int altura = 400;
    private GridBagConstraints constraintCabecera = new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 0, 0), 0, 0);
    private GridBagConstraints constraintCuerpo = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 20, 20, 20), 0, 0);
    private JornadaEntidad jornada;
    private List<PartidoEntidad> partidos;


    public JornadaCarta(JornadaEntidad jornada, List<PartidoEntidad> partidos) {
        setLayout(new GridBagLayout());
        this.jornada = jornada;
        this.partidos = partidos;

        setMinimumSize(new Dimension(anchura, altura));
        setPreferredSize(new Dimension(anchura, altura));
        setMaximumSize(new Dimension(anchura, altura));

        cabecera = new JLabel("<html> Jornada " + jornada.getNumero() + "<p>" + jornada.getFecha() + "</p></html>", JLabel.CENTER);


        add(cabecera, constraintCabecera);
    }

    public void crearCuerpo() {
        cuerpo = new JPanel(new GridLayout(partidos.size(), 3));
        cuerpo.setBackground(super.getColorPorDefecto());
        for ( PartidoEntidad partido : partidos ) {
            cuerpo.add(new JLabel(partido.getEquipoUno().getNombre(), JLabel.CENTER));
            cuerpo.add(new JLabel("vs", JLabel.CENTER));
            cuerpo.add(new JLabel(partido.getEquipoDos().getNombre(), JLabel.CENTER));
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
