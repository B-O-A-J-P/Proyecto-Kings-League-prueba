package com.boajp.vista.carta;

import javax.swing.*;
import java.awt.*;

public class CalendarioTabla extends CuerpoAbstracto {

    private Color backgroundColor = new Color(0, 0, 0, 0);
    private JLabel[][] filas;

    public CalendarioTabla(JLabel[][] filas) {
        setLayout(new GridLayout(filas.length, 1));
        setBackground(backgroundColor);

        this.filas = filas;
        for (JLabel[] fila: this.filas) {
            JLabel equipoUno = fila[0];
            JLabel texto = fila[1];
            JLabel equipoDos =fila[2];
            add(new Fila(equipoUno, texto, equipoDos));
        }
    }

    private class Fila extends JPanel{
        public Fila(JLabel equipoUno, JLabel texto, JLabel equipoDos) {
            setLayout(new GridLayout(1, 3));

            equipoUno.setHorizontalAlignment(JLabel.CENTER);
            equipoDos.setHorizontalAlignment(JLabel.CENTER);
            texto.setHorizontalAlignment(JLabel.CENTER);

            add(equipoUno);
            add(texto);
            add(equipoDos);

            setBackground(backgroundColor);
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        }
    }

    public static void main(String... args){
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        JLabel[][] list = new JLabel[6][3];
        for (int x = 0; x < 6; x++) {
            list[x] =
            new JLabel[]{new JLabel("Equipo uno"), new JLabel("vs"), new JLabel("Equipod dos")};
        }
        frame.add(new CalendarioTabla(list));

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
