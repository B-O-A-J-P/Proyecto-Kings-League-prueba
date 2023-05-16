package com.boajp.vista.carta;

import javax.swing.*;
import java.awt.*;

public class Cabecera extends CabeceraAbstracta {
    public Cabecera(String... texto) {
        setLayout(new GridLayout(texto.length, 1));
        setBackground(new Color(0, 0, 0, 0));
        for(String elemento: texto) {
            add(new JLabel(elemento, JLabel.CENTER));
        }
    }
}
