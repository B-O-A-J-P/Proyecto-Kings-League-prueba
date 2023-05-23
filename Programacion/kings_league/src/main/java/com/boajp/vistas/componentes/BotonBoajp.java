package com.boajp.vistas.componentes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BotonBoajp extends JButton {
    private Color colorPorDefecto;
    private Color colorResaltado;
    private Color colorPresionado;

    public BotonBoajp(String texto) {
        super(texto);
        setFocusPainted(false);
    }

    public BotonBoajp(String texto, Color colorPorDefecto, Color colorResaltado, Color colorPresionado) {
        super(texto);
        this.colorPorDefecto = colorPorDefecto;
        this.colorResaltado = colorResaltado;
        this.colorPresionado = colorPresionado;
        setFocusPainted(false);
        setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        ButtonModel modelo = getModel();
        if (modelo.isRollover()) {
            setBackground(colorResaltado);
        } else if (modelo.isPressed()) {
            setBackground(colorPresionado);
        } else {
            setBackground(colorPorDefecto);
        }

        super.paintComponent(g2);
    }

    public void setBorde(Border borde) {
        setBorder(borde);
    }

    public Color getColorPorDefecto() {
        return colorPorDefecto;
    }

    public void setColorPorDefecto(Color colorPorDefecto) {
        this.colorPorDefecto = colorPorDefecto;
    }

    public Color getColorResaltado() {
        return colorResaltado;
    }

    public void setColorResaltado(Color colorResaltado) {
        this.colorResaltado = colorResaltado;
    }

    public Color getColorPresionado() {
        return colorPresionado;
    }

    public void setColorPresionado(Color colorPresionado) {
        this.colorPresionado = colorPresionado;
    }

}
