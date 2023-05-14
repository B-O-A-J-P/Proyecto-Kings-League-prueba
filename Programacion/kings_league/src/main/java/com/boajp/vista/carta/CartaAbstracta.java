package com.boajp.vista.carta;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

abstract public class CartaAbstracta extends JPanel {
    private Color colorPorDefecto = Color.GRAY;
    private Color colorHover = Color.DARK_GRAY;
    protected boolean estaHovered = false;

    public CartaAbstracta() {}

    public CartaAbstracta(Color colorPorDefecto, Color colorHover) {
        this.colorPorDefecto = colorPorDefecto;
        this.colorHover = colorHover;
        setBackground(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call super method to paint the components
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int coordenadaX = 0;
        int coordenadaY = 0;

        int lbAnchura = getWidth();
        int lbAltura = getHeight();

        int anchuraDeArco = (int) (getWidth() * 0.05) + 5;
        int alturaDeArco = (int) (getWidth() * 0.05) + 5;
        Color colorDeFondo = estaHovered ? colorHover : colorPorDefecto;

        graphics2D.setColor(colorDeFondo);
        graphics2D.fillRoundRect(coordenadaX, coordenadaY, lbAnchura, lbAltura, anchuraDeArco, alturaDeArco);
        setOpaque(false);
    }


    public Color getColorPorDefecto() {
        return colorPorDefecto;
    }

    public void setColorPorDefecto(Color colorPorDefecto) {
        this.colorPorDefecto = colorPorDefecto;
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public boolean isEstaHovered() {
        return estaHovered;
    }

    public void setEstaHovered(boolean estaHovered) {
        this.estaHovered = estaHovered;
    }

    abstract public int getAnchura();
    abstract public int getAltura();
}
