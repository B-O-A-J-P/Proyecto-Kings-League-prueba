package com.boajp.vista;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ContratosPanel {
    private JPanel panel1;
    private JPanel panel2;

    public ContratosPanel() {
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, BorderLayout.CENTER);
        scrollPane1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), null, TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        scrollPane1.setViewportView(panel2);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel1.add(panel3, BorderLayout.NORTH);
        final JLabel label1 = new JLabel();
        label1.setText("Imagen equipo");
        panel3.add(label1);
        final JLabel label2 = new JLabel();
        label2.setText("Nombre Equipo");
        panel3.add(label2);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
