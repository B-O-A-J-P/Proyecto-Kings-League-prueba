package com.boajp.vista;

import javax.swing.*;
import java.awt.*;

public class ContratosPanel {
    private JPanel panel1;
    private JPanel panel2;

    public ContratosPanel(){
        Image image = new ImageIcon(ContratosPanel.class.getResource("/imagenes/logo.png")).getImage();
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
        panel2.add(new CartaMiembro(new ImageIcon(image), "Jorge Egea", "Presidente").getPanelPrincipal());
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public static void main(String... args) {
        JFrame frame = new JFrame();
        frame.add(new ContratosPanel().getPanel1());
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
