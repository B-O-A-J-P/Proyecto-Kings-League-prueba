package com.boajp.vistas.carta;

import com.boajp.controladores.Controlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EquipoCarta extends CartaAbstracta {
    private final JLabel LB_NOMBRE;
    public int anchura = 380;
    public int altura = 140;

    public EquipoCarta(String nombre) {
        setLayout(new BorderLayout());

        setMinimumSize(new Dimension(anchura, altura));
        setPreferredSize(new Dimension(anchura, altura));
        setMaximumSize(new Dimension(anchura, anchura));

        LB_NOMBRE = new JLabel(nombre, JLabel.CENTER);
        add(LB_NOMBRE, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EquipoCarta.super.estaHovered = true;
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                validate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                EquipoCarta.super.estaHovered = false;
                setCursor(Cursor.getDefaultCursor());
                validate();
                repaint();

            }
        });

    }

    public EquipoCarta(String nombre, Color colorPorDefecto, Color colorHover) {
        super(colorPorDefecto, colorHover);
        setLayout(new BorderLayout());

        setMinimumSize(new Dimension(anchura, altura));
        setPreferredSize(new Dimension(anchura, altura));
        setMaximumSize(new Dimension(anchura, anchura));

        LB_NOMBRE = new JLabel(nombre, JLabel.CENTER);
        add(LB_NOMBRE, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EquipoCarta.super.estaHovered = true;
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                validate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                EquipoCarta.super.estaHovered = false;
                setCursor(Cursor.getDefaultCursor());
                validate();
                repaint();
            }
        });
    }

    public EquipoCarta(String nombre, ImageIcon icon) {
        setLayout(new BorderLayout());

        setMinimumSize(new Dimension(anchura, altura));
        setPreferredSize(new Dimension(anchura, altura));
        setMaximumSize(new Dimension(anchura, anchura));

        LB_NOMBRE = new JLabel(nombre, icon, JLabel.CENTER);
        add(LB_NOMBRE, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EquipoCarta.super.estaHovered = true;
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                validate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                EquipoCarta.super.estaHovered = false;
                setCursor(Cursor.getDefaultCursor());
                validate();
                repaint();

            }
        });
    }

    public EquipoCarta(String nombre, ImageIcon icon, Color colorPorDefecto, Color colorHover) {
        super(colorPorDefecto, colorHover);
        setLayout(new BorderLayout());

        setMinimumSize(new Dimension(anchura, altura));
        setPreferredSize(new Dimension(anchura, altura));
        setMaximumSize(new Dimension(anchura, anchura));

        LB_NOMBRE = new JLabel(nombre, icon, JLabel.CENTER);
        add(LB_NOMBRE, BorderLayout.CENTER);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                EquipoCarta.super.estaHovered = true;
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                validate();
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                EquipoCarta.super.estaHovered = false;
                setCursor(Cursor.getDefaultCursor());
                validate();
                repaint();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String equipo ="";
                Controlador.mostrarPanelDeEquipos();
            }
        });

    }

    public JLabel getLB_NOMBRE() {
        return LB_NOMBRE;
    }

    @Override
    public int getAnchura() {
        return anchura;
    }

    @Override
    public int getAltura() {
        return altura;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
